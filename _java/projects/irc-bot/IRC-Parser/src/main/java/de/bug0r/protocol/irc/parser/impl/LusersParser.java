package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.LusersMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class LusersParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		LusersMessage lusersMessage = null;
		lusersMessage = new LusersMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return lusersMessage;
	}

}
