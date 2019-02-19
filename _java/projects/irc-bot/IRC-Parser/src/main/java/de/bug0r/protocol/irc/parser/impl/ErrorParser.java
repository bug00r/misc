package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.ErrorMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class ErrorParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		ErrorMessage errorMessage = null;
		errorMessage = new ErrorMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return errorMessage;
	}

}
