/**
 * 
 */
package de.bug0r.protocol.irc.connection.listener.event.impl;

import java.util.Date;

/**
 * @author bug0r
 *
 */
public class IrcEvent extends BaseIrcEvent {

	public IrcEvent(Object data, Date creationDate, EIrcEvents eventId) {
		this.data = data;
		this.ceationDate = creationDate;
		this.eventId = eventId;
	}

	@Override
	public Object getEventData() {
		return data;
	}

	@Override
	public Date getDate() {
		return ceationDate;
	}
	
	@Override
	public int getId() {
		return eventId.value();
	}
	
	private Object data;
	private Date ceationDate;
	private EIrcEvents eventId;
}
