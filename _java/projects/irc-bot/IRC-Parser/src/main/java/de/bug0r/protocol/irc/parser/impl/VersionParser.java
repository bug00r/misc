package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.VersionMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class VersionParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		VersionMessage versionMessage = null;
		versionMessage = new VersionMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		return versionMessage;
	}

}
