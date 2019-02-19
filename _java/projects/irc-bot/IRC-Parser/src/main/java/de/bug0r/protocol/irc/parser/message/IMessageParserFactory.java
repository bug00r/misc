/**
 * 
 */
package de.bug0r.protocol.irc.parser.message;

import de.bug0r.message.irc.IrcMessage;



/**
 * @author bug0r
 * @version 0.1
 */
public interface IMessageParserFactory {

	/**
	 * 
	 * @param messageType messageId i.e. USER. 
	 * @return IMessageParser object
	 */
	public IMessageParser getParser(IrcMessage message);
	
}
