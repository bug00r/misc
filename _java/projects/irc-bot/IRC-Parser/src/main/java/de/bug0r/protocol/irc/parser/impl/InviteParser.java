package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.InviteMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class InviteParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {		
		String sourceNick = StringUtils.EMPTY_STRING;		
		int startIndex = 0;
		if ( IrcMessageUtils.messageHasSource(rawMessage)) {
			sourceNick = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			++startIndex;
		}	
		return new InviteMessage(sourceNick,
								IrcMessageUtils.getParamByIndex(rawMessage, startIndex), 
								IrcMessageUtils.getParamByIndex(rawMessage, ++startIndex));
	}

}
