package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.NickMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class NickParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		NickMessage nickMessage = null;
		
		if ( IrcMessageUtils.messageHasSource(rawMessage) ) {
			nickMessage = new NickMessage(IrcMessageUtils.getParamByIndex(rawMessage, 1),
					IrcMessageUtils.getNickNameFromCompleteUsername(rawMessage));
		} else {
			nickMessage = new NickMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0));
		}
		
		return nickMessage;
	}

}
