package de.bug0r.context.irc.context.event.impl;

import de.bug0r.message.irc.IIrcMessage;

public class ClientToIrcServerEvent extends AbstractIrcContextEvent<IIrcMessage, IrcContextEventTypes> {

	public ClientToIrcServerEvent(IIrcMessage data) {
		super(data, IrcContextEventTypes.CLIENT_TO_IRC_SERVER);
	}

}
