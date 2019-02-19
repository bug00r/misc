/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r
 * @version 0.1
 */
public class DieMessage extends AbstractTextCommandMessage {

	/**
	 * @param messageId
	 * @param text
	 */
	public DieMessage() {
		super(IrcMessage.DIE, null);
	}

}
