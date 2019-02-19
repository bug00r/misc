package de.bug0r.terminal.controller.event.listener.impl.model.worker.impl;

import de.bug0r.client.Request;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.model.context.ModelContext;

public class ClientRequestWorker implements Worker {

	public ClientRequestWorker(ModelContext context) {
		if ( context == null ) throw new IllegalArgumentException("no model context given");
		this.context = context;
	}

	@Override
	public void doIt(Object data) {
		Request request = (Request)data;
		System.out.println("terminal reaches >> " + request.getContent());
	}

	private ModelContext context;
}
