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
public abstract class AbstractTextCommandMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public AbstractTextCommandMessage(IrcMessage messageId, String text) {
		super(messageId);
		
		_text = text;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString());
		
		if ( null != _text ) {
			msg.append(IrcMessageUtils.SPACE)
			.append(IrcMessageUtils.MSG_PARAM_PREFIX);
			if ( !StringUtils.isEmptyTrim(_text)) {
				msg.append(_text);
			}
		} 
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _text;
	
}
