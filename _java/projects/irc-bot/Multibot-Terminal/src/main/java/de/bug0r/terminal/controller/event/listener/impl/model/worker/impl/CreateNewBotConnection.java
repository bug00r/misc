package de.bug0r.terminal.controller.event.listener.impl.model.worker.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

import de.bug0r.client.Client;
import de.bug0r.client.Request;
import de.bug0r.client.RequestListener;
import de.bug0r.client.impl.SocketClient;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEvent;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEventId;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.impl.ControllerImpl;
import de.bug0r.terminal.controller.model.context.ConnectionData;
import de.bug0r.terminal.controller.model.context.ModelContext;

public class CreateNewBotConnection implements Worker {

	public CreateNewBotConnection(ModelContext context) {
		if ( context == null ) throw new IllegalArgumentException("no model context given");
		this.context = context;
	}

	@Override
	public void doIt(Object data) {
		ConnectionData conData = (ConnectionData)data;
		SocketChannel socket;
		try {
			socket = SocketChannel.open(new InetSocketAddress("localhost", conData.getPort()));
			Client client = new SocketClient(socket, new RequestListener() {
			
				@Override
				public void doRequest(Request nextRequest) {
					ControllerImpl.getInstance().fire(new ModelEvent(ModelEventId.REQUEST_FROM_CLIENT, nextRequest));
				}
			}		
			, System.currentTimeMillis());
			client.startProcessing();
			context.addClient(conData.getAlias(), client);
		} catch (IOException e) {
			// TODO HERE ERROR TO CONTROLLER GUI!!!!
			e.printStackTrace();
		}
	}

	private ModelContext context;
}
