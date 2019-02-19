package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.WhoisMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class WhoisParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		StringTokenizer whoisMessageToken = new StringTokenizer(rawMessage,IrcMessageUtils.SPACE);
		String target = StringUtils.EMPTY_STRING;
		int masksIndex = 0;
		if ( whoisMessageToken.countTokens() == 3 ) {
			target = IrcMessageUtils.getParamByIndex(rawMessage, 0);
			++masksIndex;
		} 
		
		List<String> masks = Arrays.asList(IrcMessageUtils.getParamByIndex(rawMessage, masksIndex).split(IrcMessageUtils.MSG_PARAM_SEP));
		
		return new WhoisMessage(target, masks);
	}

}
