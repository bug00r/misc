/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.IrcMessage;

/**
 * 
 * Base Message contains information about 
 * 
 * @author bug0r
 * @version 0.1
 *
 */
public abstract class AbstractMessage implements IIrcMessage {

	/**
	 * std c-tor
	 * @param messageId message id
	 */
	public AbstractMessage(IrcMessage messageId) {
		if ( null == messageId )
			throw new NullPointerException();
		
		_messageId = messageId;
	}
	
	@Override
	public String toString() {
		return _messageId.toString();
	}
	
	@Override
	public IrcMessage getMessageId() {
		return this._messageId;
	}
	
	/** Messagetype */
	private final IrcMessage _messageId;
	
}
