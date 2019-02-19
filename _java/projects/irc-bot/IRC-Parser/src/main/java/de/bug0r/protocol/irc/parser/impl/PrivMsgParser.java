package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringArea;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class PrivMsgParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		String usedMessage = rawMessage;
		String message = IrcMessageUtils.messageHasSource(usedMessage) ? 
								IrcMessageUtils.extractTextResourceFromMessage(usedMessage):
									IrcMessageUtils.extractTextResourceFromMessageWithoutSource(usedMessage);	
		String source = StringUtils.EMPTY_STRING;
		int toSkipBeginCharacter = 0; 
		if ( IrcMessageUtils.messageHasSource(usedMessage) ) {
			source = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			++toSkipBeginCharacter;
		}
		StringArea channelArea = new StringArea(0, IrcMessageUtils.SPACE_CHR, toSkipBeginCharacter, IrcMessageUtils.SPACE_CHR, 0);
		String target = StringUtils.extractStringArea(usedMessage, channelArea);	
		return new PrivmsgMessage(source, target, message);
	}

}
