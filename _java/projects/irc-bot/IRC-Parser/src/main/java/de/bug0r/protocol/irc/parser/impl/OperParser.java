package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.OperMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class OperParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		return new OperMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0),
				IrcMessageUtils.getParamByIndex(rawMessage, 1));
	}

}
