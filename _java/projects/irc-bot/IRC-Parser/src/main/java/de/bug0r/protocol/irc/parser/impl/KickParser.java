package de.bug0r.protocol.irc.parser.impl;

import java.util.Arrays;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.KickMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class KickParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		
		String sourceNick = StringUtils.EMPTY_STRING;
		String comment = IrcMessageUtils.rawMessageContainsTextResource(rawMessage) ?  
				( IrcMessageUtils.messageHasSource(rawMessage) ? 
						IrcMessageUtils.extractTextResourceFromMessage(rawMessage): 
							IrcMessageUtils.extractTextResourceFromMessageWithoutSource(rawMessage) ) : 
								StringUtils.EMPTY_STRING;
		int parameterIndex = 0;
		
		if ( IrcMessageUtils.messageHasSource(rawMessage) ) {
			sourceNick = IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage);
			++parameterIndex;
		}
		
		return new KickMessage(sourceNick,
					Arrays.asList(IrcMessageUtils.getParamByIndex(rawMessage, parameterIndex).split(",")), 
					Arrays.asList(IrcMessageUtils.getParamByIndex(rawMessage, ++parameterIndex).split(",")), 
					comment);
	}

}
