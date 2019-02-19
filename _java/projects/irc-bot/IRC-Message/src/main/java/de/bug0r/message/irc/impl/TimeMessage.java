/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class TimeMessage extends AbstractOptionalTargetMessage {

	/**
	 * @param messageId
	 * @param target
	 */
	public TimeMessage(String target) {
		super(IrcMessage.TIME, target);
	}

}
