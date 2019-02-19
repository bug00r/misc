package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.QuitMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class QuitParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		
		String source = StringUtils.EMPTY_STRING;
		String message =  StringUtils.EMPTY_STRING;
		
		if (IrcMessageUtils.messageHasSource(rawMessage)) {
			source = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			message = IrcMessageUtils.extractTextResourceFromMessage(rawMessage);
		} else {
			message = IrcMessageUtils.extractTextResourceFromMessageWithoutSource(rawMessage);
		}
		
		return new QuitMessage(source, message);
	}

}
