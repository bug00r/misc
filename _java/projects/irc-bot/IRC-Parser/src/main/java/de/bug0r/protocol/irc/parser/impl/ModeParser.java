package de.bug0r.protocol.irc.parser.impl;

import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringArea;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.ModeMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class ModeParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		ModeMessage modeMessage = null;
		
		String nick = StringUtils.EMPTY_STRING;
		int messageIndex = 0;
		int minSpaceTokenForModeToken = 4;
		String modeParams = StringUtils.EMPTY_STRING;
		if (IrcMessageUtils.messageHasSource(rawMessage)) {
			nick = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			++messageIndex;
			++minSpaceTokenForModeToken;
		}
		
		String target = IrcMessageUtils.getParamByIndex(rawMessage, messageIndex);
		String mode = IrcMessageUtils.getParamByIndex(rawMessage, ++messageIndex);
		
		StringTokenizer messageTokenizer = new StringTokenizer(rawMessage,IrcMessageUtils.SPACE);
		if ( messageTokenizer.countTokens() >= minSpaceTokenForModeToken) {
			modeParams = StringUtils.extractStringArea(rawMessage, 
					new StringArea(2, IrcMessageUtils.SPACE_CHR, ++messageIndex, IrcMessageUtils.IRC_MESSAGE_CR, 0));
		}
		
		return new ModeMessage(nick, target, mode, modeParams);
	}

}
