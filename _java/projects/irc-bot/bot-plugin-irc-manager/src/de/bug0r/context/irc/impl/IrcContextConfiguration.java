package de.bug0r.context.irc.impl;

import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;
import de.bug0r.protocol.irc.parser.IIrcParser;
import de.bug0r.protocol.irc.parser.impl.IrcParser;

public class IrcContextConfiguration {

	public IrcContextConfiguration(
			DefaultIrcConnectionConfiguration connectionConfiguration) {
		
		if ( null == connectionConfiguration ) throw new IllegalArgumentException("no connection Configuration given");
		
		this.connectionConfiguration = connectionConfiguration;
		this.ircParser = new IrcParser();
	}
	public DefaultIrcConnectionConfiguration getConnectionConfiguration() {
		return connectionConfiguration;
	}

	public IIrcParser getIrcParser() {
		return ircParser;
	}
	private DefaultIrcConnectionConfiguration connectionConfiguration;
	private IIrcParser ircParser;
}
