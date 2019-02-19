package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.PartMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class PartParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		
		IIrcMessage partMessage = null;
		
		String message = IrcMessageUtils.rawMessageContainsTextResource(rawMessage) ?  
				( IrcMessageUtils.messageHasSource(rawMessage) ? 
						IrcMessageUtils.extractTextResourceFromMessage(rawMessage): 
							IrcMessageUtils.extractTextResourceFromMessageWithoutSource(rawMessage) ) : 
								StringUtils.EMPTY_STRING;
		
		if ( IrcMessageUtils.messageHasSource(rawMessage) ) {
			partMessage = new PartMessage(IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage), 
					IrcMessageUtils.getParamByIndex(rawMessage, 1),message);
		} else {
			partMessage = new PartMessage(Arrays.asList(IrcMessageUtils.getParamByIndex(rawMessage, 0).split(",")), 
					message);
		}
		
		return partMessage;
	}

}
