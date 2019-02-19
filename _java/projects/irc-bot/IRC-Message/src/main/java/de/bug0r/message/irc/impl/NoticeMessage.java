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
public class NoticeMessage extends AbstractTargetMessage {

	/**
	 * @param messageType
	 * @param source
	 * @param target
	 * @param message
	 */
	public NoticeMessage( String source, String target,
			String message) {
		super(IrcMessage.NOTICE, source, target, message);
	}

}
