package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.TimeMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class TimeParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		TimeMessage timeMessage = null;
		timeMessage = new TimeMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return timeMessage;
	}

}
