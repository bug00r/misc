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
public class PongMessage extends AbstractPingPongMessage {

	/**
	 * @param messageId
	 * @param server
	 */
	public PongMessage(List<String> server) {
		super(IrcMessage.PONG, server);
	}

}
