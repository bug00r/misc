package de.bug0r.protocol.irc.parser.impl;

import java.util.Arrays;
import java.util.List;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.PingMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class PingParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		List<String> server = Arrays.asList(rawMessage.replaceAll(IrcMessageUtils.MSG_PARAM_PREFIX,
					StringUtils.EMPTY_STRING).split(IrcMessageUtils.SPACE));
		return new PingMessage(server.subList(1, server.size()));
	}

}
