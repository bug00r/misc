/**
 * 
 */
package de.bug0r.protocol.irc.parser;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.parser.IParser;



/**
 * 
 * the irc parser transform raw string to irc message and backward.
 * 
 * @author bug0r
 * @version 0.1
 */
public interface IIrcParser extends IParser<IIrcMessage> {

	/**
	 * 
	 * @param rawMsg
	 * @return
	 */
	public IIrcMessage strToMsg(String rawMsg);
	
	/**
	 * 
	 * @param message message object
	 * @return raw string from message
	 */
	public String msgToStr(IIrcMessage message);
	
}
