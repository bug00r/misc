package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.AdminMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class AdminParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		AdminMessage adminMessage = null;
		adminMessage = new AdminMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return adminMessage;
	}

}
