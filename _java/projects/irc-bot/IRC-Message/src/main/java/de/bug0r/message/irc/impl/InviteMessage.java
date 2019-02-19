/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class InviteMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public InviteMessage(String sourceNick, String targetNick, String channel ) {
		super(IrcMessage.INVITE);
		
		if ( StringUtils.isEmptyTrim(channel) ||
				StringUtils.isEmptyTrim(targetNick)) 
			throw new IllegalArgumentException();
		
		
		_sourceNick = sourceNick;
		_channel = channel;
		_targetNick = targetNick;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( !StringUtils.isEmptyTrim(_sourceNick) ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_sourceNick)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString())
		.append(IrcMessageUtils.SPACE)
		.append(_targetNick)
		.append(IrcMessageUtils.SPACE)
		.append(_channel)
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _sourceNick;
	private String _channel;
	private String _targetNick;
	
}
