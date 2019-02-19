/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 *
 */
public class QuitMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public QuitMessage(String source, String quitmessage) {
		super(IrcMessage.QUIT);
			
		_source = source;
		_message = quitmessage;
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( !StringUtils.isEmtpy(_source) ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX).append(_source).append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString());
		
		if (!StringUtils.isEmptyTrim(_message) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_message);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	
	
	private String _message;
	private String _source;
	
}
