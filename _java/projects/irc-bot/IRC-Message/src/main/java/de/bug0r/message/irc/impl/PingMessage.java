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
public class PingMessage extends AbstractPingPongMessage {

	public PingMessage(List<String> server) {
		super(IrcMessage.PING, server);
	}

}
