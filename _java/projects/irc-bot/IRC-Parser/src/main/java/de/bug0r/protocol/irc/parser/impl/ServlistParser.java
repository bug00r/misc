package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.ServlistMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class ServlistParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		List<String> targetList = Arrays.asList(rawMessage.split(IrcMessageUtils.SPACE));
		List<String> messageTargetList = new ArrayList<String>();
		if ( targetList.size() > 1 ) {
			messageTargetList = targetList.subList(1, targetList.size());
		}
		return new ServlistMessage(messageTargetList);
	}

}
