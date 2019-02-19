package de.bug0r.protocol.irc.connection.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.NickMessage;
import de.bug0r.message.irc.impl.PassMessage;
import de.bug0r.message.irc.impl.PongMessage;
import de.bug0r.message.irc.impl.UserMessage;
import de.bug0r.protocol.irc.connection.config.IIrc;
import de.bug0r.protocol.irc.connection.config.IIrcConnectionConfiguration;
import de.bug0r.protocol.irc.connection.listener.IIrcConnectionListener;
import de.bug0r.protocol.irc.connection.listener.event.IEvent;
import de.bug0r.protocol.irc.connection.listener.event.impl.EIrcEvents;
import de.bug0r.protocol.irc.connection.listener.event.impl.IrcEvent;
import de.bug0r.protocol.irc.connection.message.IIrcRawMessage;

/**
 * 
 * the steady connection handels start registration and pong from ping evens.
 * you mustn't handle these events  by using this connection.
 * 
 * @author bug0r
 * @version 0.1
 *
 */
public class IrcSteadyConnection 
extends IrcConnection 
implements IIrcConnectionListener
{

	public IrcSteadyConnection( IIrcConnectionConfiguration config ) {
	   super((IIrc)config);
	   super.addMessageListener(this);
	   this.config = config;
	}

	@Override
	public void process(IEvent event) {
		String eventMsg = ((IIrcRawMessage)event.getEventData()).getCompleteMessage();
		
		if ( eventMsg.startsWith("PING") ) {
			List<String> server = new ArrayList<String>();
			server.add(eventMsg.split(":")[1]);
			PongMessage pongMsg = new PongMessage(server);
			performOutputEvent(new IrcEvent(pongMsg.toString(),
					new Date(System.currentTimeMillis()), EIrcEvents.CONNECTION_EVENT));
				
		}
		
	}
	
	@Override
	public void stop() {
		super.stop();
	}
	
	private IIrcConnectionConfiguration config;
}
