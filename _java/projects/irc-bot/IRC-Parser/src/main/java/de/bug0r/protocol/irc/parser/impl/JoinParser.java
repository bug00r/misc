package de.bug0r.protocol.irc.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.JoinMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class JoinParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		StringTokenizer tokenizer = new StringTokenizer(rawMessage, " ");
		String nick = StringUtils.EMPTY_STRING;
		IIrcMessage parsedMessage;
		if ( IrcMessageUtils.messageHasSource(rawMessage) ) {
			nick = tokenizer.nextToken();
			nick = nick.substring(1);
			tokenizer.nextToken();
			parsedMessage = new JoinMessage(nick, tokenizer.nextToken());
		} else {
			List<String> channel = new ArrayList<String>();
			List<String> passwords = new ArrayList<String>();
			tokenizer.nextToken();
			channel.add(tokenizer.nextToken());
			parsedMessage = new JoinMessage(channel, passwords);
		}
		
		return parsedMessage;
	}

}
