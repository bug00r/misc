package de.bug0r.protocol.irc.parser.impl;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.WhowasMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class WhowasParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		StringTokenizer tokenizer = new StringTokenizer(rawMessage, IrcMessageUtils.SPACE);
		List<String> nicks = Arrays.asList(IrcMessageUtils.getParamByIndex(rawMessage, 0).split(IrcMessageUtils.MSG_PARAM_SEP));
		int messageToken = tokenizer.countTokens();
		String count = StringUtils.EMPTY_STRING;
		String target = StringUtils.EMPTY_STRING;
		if ( messageToken >= 3) {
			count = IrcMessageUtils.getParamByIndex(rawMessage, 1);
		}
		if ( messageToken == 4) {
			target = IrcMessageUtils.getParamByIndex(rawMessage, 2);
		}
		return new WhowasMessage(nicks, count, target);
	}

}
