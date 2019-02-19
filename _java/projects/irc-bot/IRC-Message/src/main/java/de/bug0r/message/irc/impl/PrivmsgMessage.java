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
public class PrivmsgMessage extends AbstractTargetMessage {

	/**
	 * @param messageType
	 * @param source
	 * @param target
	 * @param message
	 */
	public PrivmsgMessage(String source,
			String target, String message) {
		super(IrcMessage.PRIVMSG, source, target, message);
	}

	public String nick() {
		return _source;
	}
	
	public String channel() {
		return _target;
	}
	
	public String message() {
		return _message;
	}
}
