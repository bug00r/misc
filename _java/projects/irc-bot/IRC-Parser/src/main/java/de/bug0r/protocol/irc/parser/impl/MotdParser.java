package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.MotdMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class MotdParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		MotdMessage motdMessage = null;
		motdMessage = new MotdMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return motdMessage;
	}

}
