/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r	
 * @version 0.1
 */
public class RestartMessage extends AbstractTextCommandMessage {

	/**
	 * @param messageId
	 * @param text
	 */
	public RestartMessage() {
		super(IrcMessage.RESTART, null);
	}

}
