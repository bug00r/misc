package de.bug0r.message.irc;

import de.bug0r.message.raw.IRawMessage;

/**
 * @author bug0r
 *
 */
public interface IIrcMessage extends IRawMessage<IrcMessage> {

	@Override
	public IrcMessage getMessageId();
	
	@Override
	public String toString();
}
