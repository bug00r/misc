package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.DieMessage;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class DieParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		return new DieMessage();
	}

}
