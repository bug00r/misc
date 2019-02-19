package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.StatsMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class StatsParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		StatsMessage statsMessage = null;
		statsMessage = new StatsMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return statsMessage;
	}

}
