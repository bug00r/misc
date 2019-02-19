package de.bug0r.terminal.controller.event.listener.impl.model;

import de.bug0r.terminal.controller.event.EventId;

public enum ModelEventId implements EventId {
	CREATE_NEW_BOT_CONNECTION,
	REQUEST_FROM_CLIENT, 
	REQUEST_TO_SERVER;

	@Override
	public Object get() {
		return this;
	}

}
