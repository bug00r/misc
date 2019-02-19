package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.InfoMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class InfoParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		InfoMessage infoMessage = null;
		infoMessage = new InfoMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return infoMessage;
	}

}
