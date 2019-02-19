/**
 * 
 */
package de.bug0r.protocol.irc.connection.listener.event.impl;

/**
 * @author bug0r
 * @version 0.1
 */
public enum EIrcEvents {
	BASE_EVENT(0),
	SERVER_EVENT(1),
	CONNECTION_EVENT(2);
	
	private EIrcEvents(int eventId) {
		this.eventId = eventId;
	}
	
	public int value() {
		return eventId;
	}
	
	private int eventId;
	
}
