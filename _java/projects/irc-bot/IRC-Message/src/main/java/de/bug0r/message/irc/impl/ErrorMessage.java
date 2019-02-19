/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;


/**
 * @author bug0r
 * @version 0.1
 */
public class ErrorMessage extends AbstractTextCommandMessage {

	/**
	 * @param messageId
	 * @param text
	 */
	public ErrorMessage(String text) {
		super(IrcMessage.ERROR, text);
	}

}
