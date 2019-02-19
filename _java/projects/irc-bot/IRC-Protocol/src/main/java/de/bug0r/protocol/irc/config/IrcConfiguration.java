package de.bug0r.protocol.irc.config;

import de.bug0r.protocol.irc.connection.config.IIrcConnectionConfiguration;

public class IrcConfiguration implements IIrcConfiguration {

	private final IIrcConnectionConfiguration ircConnectionConfiguration;
	
	public IrcConfiguration(IIrcConnectionConfiguration ircConnectionConfiguration) {
		if ( ircConnectionConfiguration == null ) throw new NullPointerException();
		this.ircConnectionConfiguration = ircConnectionConfiguration;
	}

	@Override
	public IIrcConnectionConfiguration getConnectionConfiguration() {
		return this.ircConnectionConfiguration;
	}
	
	
	
}
