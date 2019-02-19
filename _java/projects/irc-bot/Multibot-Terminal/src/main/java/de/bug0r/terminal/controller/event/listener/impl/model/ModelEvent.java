package de.bug0r.terminal.controller.event.listener.impl.model;

import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.EventId;

public class ModelEvent implements Event {

	public ModelEvent(ModelEventId id, Object data) {
		if (id==null) throw new IllegalArgumentException("no event id given");
		this.id = id;
		this.data = data;
	}

	@Override
	public boolean containsData() {
		return this.data != null;
	}
	
	@Override
	public EventId getId() {
		return this.id;
	}

	@Override
	public Object getData() {
		return this.data;
	}

	private EventId id;
	private Object data;

	
}
