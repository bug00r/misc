/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r	
 * @version 0.1
 */
public class RehashMessage extends AbstractTextCommandMessage {

	/**
	 * @param messageId
	 * @param text
	 */
	public RehashMessage() {
		super(IrcMessage.REHASH, null);
	}

}
