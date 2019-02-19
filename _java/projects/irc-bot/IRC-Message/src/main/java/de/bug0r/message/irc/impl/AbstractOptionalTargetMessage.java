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
public abstract class AbstractOptionalTargetMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public AbstractOptionalTargetMessage(IrcMessage messageId, String target) {
		super(messageId);
		
		_target = target;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString());
		
		if ( !StringUtils.isEmptyTrim(_target) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(_target);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _target;
	
	
}
