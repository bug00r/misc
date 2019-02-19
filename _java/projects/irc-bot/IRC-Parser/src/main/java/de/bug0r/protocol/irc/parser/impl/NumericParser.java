package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.core.utils.String.StringArea;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.NumericMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class NumericParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		String endText = "";
		try {
			endText = StringUtils.extractStringArea(rawMessage, new StringArea(2, IrcMessageUtils.SPACE_CHR,
								2, IrcMessageUtils.IRC_MESSAGE_CR, 0));
		} catch (Exception e) {
			//no end text
		}
		
		if ( !StringUtils.isEmptyTrim(endText) )
			endText = IrcMessageUtils.messageHasSource(endText)?endText.substring(1):endText;
		
		
		
		return new NumericMessage(IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage),
					IrcMessageUtils.getParamByIndex(rawMessage, 0), 
					IrcMessageUtils.getParamByIndex(rawMessage, 1),
					endText);
	}

}
