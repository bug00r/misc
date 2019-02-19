package de.bug0r.protocol.irc.parser.impl;

import java.util.Arrays;
import java.util.List;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.UserhostMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class UserhostParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		List<String> nickList = Arrays.asList(rawMessage.split(IrcMessageUtils.SPACE));
		return new UserhostMessage(nickList.subList(1, nickList.size()));
	}

}
