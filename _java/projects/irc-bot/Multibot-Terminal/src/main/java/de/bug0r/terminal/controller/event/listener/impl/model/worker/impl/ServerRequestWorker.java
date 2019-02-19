package de.bug0r.terminal.controller.event.listener.impl.model.worker.impl;

import de.bug0r.client.Client;
import de.bug0r.client.Response;
import de.bug0r.client.impl.StringResponse;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.model.context.ModelContext;

public class ServerRequestWorker implements Worker {

	public ServerRequestWorker(ModelContext context) {
		if ( context == null ) throw new IllegalArgumentException("no model context given");
		this.context = context;
	}

	@Override
	public void doIt(Object data) {
		String request = (String)data;
		Client client = context.getFirstClient();
		Response response = new StringResponse(request);
		client.send(response);
	}

	private ModelContext context;
}
