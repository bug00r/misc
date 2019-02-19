package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.TraceMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class TraceParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		TraceMessage traceMessage = null;
		traceMessage = new TraceMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return traceMessage;
	}

}
