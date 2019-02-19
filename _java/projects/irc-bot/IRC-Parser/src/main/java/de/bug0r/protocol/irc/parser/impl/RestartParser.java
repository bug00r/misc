package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.RestartMessage;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class RestartParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		return new RestartMessage();
	}

}
