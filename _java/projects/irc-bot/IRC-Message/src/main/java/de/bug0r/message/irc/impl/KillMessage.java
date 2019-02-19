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
public class KillMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public KillMessage(String nick, String comment) {
		super(IrcMessage.KILL);
	
		if ( StringUtils.isEmptyTrim(nick))
			throw new IllegalArgumentException();
		
		_nick = nick;
		_comment = comment;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE)
			.append(_nick);
		
		if ( !StringUtils.isEmptyTrim(_comment) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(_comment);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	
	private String _nick;
	private String _comment;
}
