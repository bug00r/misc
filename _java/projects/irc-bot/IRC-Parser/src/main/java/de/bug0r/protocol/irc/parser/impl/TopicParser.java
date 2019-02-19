package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.TopicMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class TopicParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		
		String topic = null;
		String nick = StringUtils.EMPTY_STRING;
		int targetIndex = 0;
		if ( IrcMessageUtils.messageHasSource(rawMessage) ) {
			nick = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			if ( IrcMessageUtils.rawMessageContainsTextResource(rawMessage) ) {
				topic = IrcMessageUtils.extractTextResourceFromMessage(rawMessage);
			}
			++targetIndex;
		} else {
			if ( IrcMessageUtils.rawMessageContainsTextResource(rawMessage) ) {
				topic = IrcMessageUtils.extractTextResourceFromMessageWithoutSource(rawMessage);
			}
		}
		
		return new TopicMessage(nick, IrcMessageUtils.getParamByIndex(rawMessage, targetIndex), topic);
	}

}
