package de.bug0r.protocol.irc.connection.listener.event.impl;

import java.util.Date;

import de.bug0r.protocol.irc.connection.listener.event.IEvent;

public class BaseIrcEvent implements IEvent {

	
	
	@Override
	public Object getDestination() {
		return null;
	}

	@Override
	public Object getSource() {
		return null;
	}

	@Override
	public Object getEventData() {
		return null;
	}

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public boolean hasSource() {
		return false;
	}

	@Override
	public boolean hasDestination() {
		return false;
	}

	@Override
	public boolean hasData() {
		return false;
	}

	@Override
	public int getId() {
		return EIrcEvents.BASE_EVENT.value();
	}

	
	
}
