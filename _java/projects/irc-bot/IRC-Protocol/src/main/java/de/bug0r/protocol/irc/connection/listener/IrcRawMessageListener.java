package de.bug0r.protocol.irc.connection.listener;

import de.bug0r.listener.AbstractListenerPool;
import de.bug0r.protocol.irc.connection.listener.event.IEvent;
import de.bug0r.protocol.irc.connection.message.IIrcRawMessage;

public class IrcRawMessageListener 
extends AbstractListenerPool<String>
implements IIrcConnectionListener {

	@Override
	public void process(IEvent event) {
		String rawIrcMessage = ((IIrcRawMessage)event.getEventData()).getCompleteMessage();
		System.out.println("raw listener: " + rawIrcMessage);
		super.performEvent(rawIrcMessage);
	}

}
