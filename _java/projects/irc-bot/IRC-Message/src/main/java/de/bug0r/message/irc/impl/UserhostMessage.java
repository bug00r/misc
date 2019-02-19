/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.List;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r
 * @version 0.1
 */
public class UserhostMessage extends AbstractOneToNTargetMessage {

	/**
	 * @param messageId
	 * @param targets
	 */
	public UserhostMessage(List<String> targets) {
		super(IrcMessage.USERHOST, targets);
	}

}
