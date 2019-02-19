/**
 * 
 */
package de.bug0r.protocol.irc.parser.message;

import de.bug0r.message.irc.IIrcMessage;

/**
 * 
 * Message parser parse raw string to message or throws exception.
 * 
 * @author bug0r
 * @version 0.1
 */
public interface IMessageParser {
	
	/**
	 * 
	 * @param rawMessage
	 * @return
	 */
	public IIrcMessage parse(String rawMessage);
	
}
