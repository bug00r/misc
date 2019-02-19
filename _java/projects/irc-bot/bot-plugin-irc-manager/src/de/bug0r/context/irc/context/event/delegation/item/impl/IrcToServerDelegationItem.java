package de.bug0r.context.irc.context.event.delegation.item.impl;

import java.util.Date;

import de.bug0r.context.irc.context.event.IrcContextEvent;
import de.bug0r.context.irc.context.event.delegation.item.IrcContextDelegationItem;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.protocol.irc.connection.impl.IrcSteadyConnection;
import de.bug0r.protocol.irc.connection.listener.event.IEvent;
import de.bug0r.protocol.irc.connection.listener.event.impl.EIrcEvents;
import de.bug0r.protocol.irc.connection.listener.event.impl.IrcEvent;

public class IrcToServerDelegationItem implements IrcContextDelegationItem {

	public IrcToServerDelegationItem(IrcSteadyConnection connection) {
		if ( null == connection ) throw new IllegalArgumentException("no connection given");
		this.connection = connection;
	}
	
	@Override
	public void delegate(IrcContextEvent<?, ?> contextEvent) {
		try {
			IIrcMessage message = (IIrcMessage) contextEvent.getData();
			IEvent outputEvent = new IrcEvent(message.toString(),
					new Date(System.currentTimeMillis()), EIrcEvents.CONNECTION_EVENT);
			connection.performOutputEvent(outputEvent);
		} catch (ClassCastException e) {
			System.out.println("delegate error, cast from " + contextEvent);
		}
	}

	private IrcSteadyConnection connection;
	
}
