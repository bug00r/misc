/**
 * 
 */
package de.bug0r.protocol.irc.parser.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.impl.NullMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.parser.IIrcParser;
import de.bug0r.protocol.irc.parser.message.IMessageParser;
import de.bug0r.protocol.irc.parser.message.IMessageParserFactory;

/**
 * @author bug0r
 * @version 0.1
 */
public class IrcParser implements IIrcParser {

	private final IMessageParserFactory messageParserFactory;
	
	public IrcParser() {
		this.messageParserFactory = new IrcMessageParserFactory();
	}
	
	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.parser.IIrcParser#strToMsg(java.lang.String)
	 */
	@Override
	public IIrcMessage strToMsg(String rawMsg) {
		IMessageParser messageParser = messageParserFactory.getParser(IrcMessageUtils.getIrcMessageByRawMessage(rawMsg));
		if ( null == messageParser ) {
			return new NullMessage();
		}
		return messageParser.parse(rawMsg);
	}

	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.parser.IIrcParser#msgToStr(de.bug0r.protocol.irc.parser.message.IMessage)
	 */
	@Override
	public String msgToStr(IIrcMessage message) {
		return message.toString();
	}
	
	

}
