package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.SqueryMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class SqueryParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		return new SqueryMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0), 
				IrcMessageUtils.extractTextResourceFromMessageWithoutSource(rawMessage));
	}

}
