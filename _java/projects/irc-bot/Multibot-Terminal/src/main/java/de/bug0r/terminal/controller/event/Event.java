package de.bug0r.terminal.controller.event;

public interface Event {

	public EventId getId();
	public Object getData();
	public boolean containsData();
}
