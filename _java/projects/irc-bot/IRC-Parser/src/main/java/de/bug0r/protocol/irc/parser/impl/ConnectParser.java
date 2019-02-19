package de.bug0r.protocol.irc.parser.impl;

import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.ConnectMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.message.IMessageParser;

public class ConnectParser implements IMessageParser {

	@Override
	public IIrcMessage parse(String rawMessage) {
		ConnectMessage connectMessage = null;
		
		String remoteServer = StringUtils.EMPTY_STRING;
		
		if ( new StringTokenizer(rawMessage,IrcMessageUtils.SPACE).countTokens() == 4 ) {
			remoteServer = IrcMessageUtils.getParamByIndex(rawMessage, 2);
		}
		
		connectMessage = new ConnectMessage(IrcMessageUtils.getParamByIndex(rawMessage, 0), 
				IrcMessageUtils.getParamByIndex(rawMessage, 1), 
				remoteServer);
		
		return connectMessage;
	}

}
