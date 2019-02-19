package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.PassMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class PassParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		return new PassMessage(IrcMessageUtils.getParamByIndex(rawMessage, 1));
	}

}
