package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.List;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.PongMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class PongParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		List<String> server = new ArrayList<String>();
		server.add(IrcMessageUtils.extractTextResourceFromMessage(rawMessage));
		return new PongMessage(server);
	}

}
