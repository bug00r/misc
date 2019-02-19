package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.AwayMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class AwayParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		AwayMessage awayMessage = null;
		if ( IrcMessageUtils.messageHasParameter(rawMessage) ) {
			awayMessage = new AwayMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		} else {
			awayMessage = new AwayMessage(StringUtils.EMPTY_STRING);
		}
		return awayMessage;
	}

}
