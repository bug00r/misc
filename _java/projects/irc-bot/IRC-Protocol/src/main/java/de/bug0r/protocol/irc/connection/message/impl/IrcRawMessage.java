/**
 * 
 */
package de.bug0r.protocol.irc.connection.message.impl;

import de.bug0r.protocol.irc.connection.message.IIrcRawMessage;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class IrcRawMessage implements IIrcRawMessage {

	public IrcRawMessage(String completeMessage) {
		this.completeMessage = completeMessage;
	}
	
	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.connection.message.IIrcMessage#getCompleteMessage()
	 */
	@Override
	public String getCompleteMessage() {
		return completeMessage;
	}

	private String completeMessage;
}
