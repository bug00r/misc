package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.WhoMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class WhoParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		WhoMessage whoMessage = null;
		whoMessage = new WhoMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return whoMessage;
	}

}
