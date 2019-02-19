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
public class SqueryMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public SqueryMessage(String serviceName, String text) {
		super(IrcMessage.SQUERY);
		
		if ( StringUtils.isEmptyTrim(serviceName) ||
				StringUtils.isEmptyTrim(text))
			throw new IllegalArgumentException();
		
		_serviceName = serviceName;
		_text = text;
	
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE)
			.append(_serviceName)
			.append(IrcMessageUtils.SPACE)
			.append(IrcMessageUtils.MSG_PARAM_PREFIX)
			.append(_text)
			.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _serviceName;
	private String _text;
	
}
