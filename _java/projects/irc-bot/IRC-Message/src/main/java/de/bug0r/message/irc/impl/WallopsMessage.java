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
public class WallopsMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public WallopsMessage(String source, String text) {
		super(IrcMessage.WALLOPS);
		
		if (StringUtils.isEmptyTrim(text))
			throw new IllegalArgumentException();
		
		_source = source;
		_text = text;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( !StringUtils.isEmptyTrim(_source) ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_source)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString())
		.append(IrcMessageUtils.SPACE)
		.append(IrcMessageUtils.MSG_PARAM_PREFIX)
		.append(_text)
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _source;
	private String _text;
	
}
