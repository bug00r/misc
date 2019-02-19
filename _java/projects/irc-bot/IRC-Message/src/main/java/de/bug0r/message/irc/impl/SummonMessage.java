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
 */
public class SummonMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public SummonMessage(String user, String target, String channel) {
		super(IrcMessage.SUMMON);

		if ( !StringUtils.isEmptyTrim(user))
			throw new IllegalArgumentException();
		
		_user = user;
		_target = target;
		_channel = channel;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE)
			.append(_user);
		
		if ( !StringUtils.isEmptyTrim(_target) ) {
			msg.append(IrcMessageUtils.SPACE)
			.append(_target);
		}
		
		if ( !StringUtils.isEmptyTrim(_channel) ) {
			msg.append(IrcMessageUtils.SPACE)
			.append(_channel);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _user;
	private String _target;
	private String _channel;
	
}
