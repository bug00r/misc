/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;



/**
 * @author bug0r
 * @version 0.1
 */
public class InfoMessage extends AbstractOptionalTargetMessage {

	/**
	 * @param messageId
	 * @param target
	 */
	public InfoMessage(String target) {
		super(IrcMessage.INFO, target);
	}

}
