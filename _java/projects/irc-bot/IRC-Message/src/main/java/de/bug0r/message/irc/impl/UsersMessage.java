/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r
 * @version 0.1
 */
public class UsersMessage extends AbstractOptionalTargetMessage {

	/**
	 * @param messageId
	 * @param target
	 */
	public UsersMessage(String target) {
		super(IrcMessage.USERS, target);
	}

}
