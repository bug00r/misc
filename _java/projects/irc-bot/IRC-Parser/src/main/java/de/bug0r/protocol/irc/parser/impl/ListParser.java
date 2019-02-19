package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.ListMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class ListParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		String [] splittedMessage = rawMessage.split(IrcMessageUtils.SPACE);
		List<String> targetChannel = new ArrayList<String>();
		if ( splittedMessage.length > 1 ) {
			targetChannel = Arrays.asList(splittedMessage[1].split(","));
		}
		
		return new ListMessage(targetChannel);
	}

}
