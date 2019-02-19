package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringArea;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.KillMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class KillParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		int paramIndex = 0;
		StringArea commentArea = new StringArea(2, IrcMessageUtils.SPACE_CHR, 1, IrcMessageUtils.IRC_MESSAGE_CR, 0);
		return new KillMessage(IrcMessageUtils.getParamByIndex(rawMessage, paramIndex), 
				StringUtils.extractStringArea(rawMessage, commentArea));
	}

}
