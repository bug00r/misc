package de.bug0r.protocol.irc.connection.config.impl;

import de.bug0r.protocol.irc.config.IIrcConfiguration;
import de.bug0r.protocol.irc.connection.config.IIrcConnectionConfiguration;

public class IrcConfiguration implements IIrcConfiguration {

	public IrcConfiguration(IIrcConnectionConfiguration ircConnectionConfiguration) {
		if ( null == ircConnectionConfiguration )
			throw new NullPointerException();
		
		this.ircConnectionConfiguration = ircConnectionConfiguration;
	}
	
	@Override
	public IIrcConnectionConfiguration getConnectionConfiguration() {
		return this.ircConnectionConfiguration;
	}

	private final IIrcConnectionConfiguration ircConnectionConfiguration;
}
