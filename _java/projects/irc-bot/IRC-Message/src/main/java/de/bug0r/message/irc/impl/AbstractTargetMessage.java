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
public abstract class AbstractTargetMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public AbstractTargetMessage(IrcMessage messageType, String source, String target, String message) {
		super(messageType);
		
		if ( StringUtils.isEmptyTrim(target) ||
				StringUtils.isEmptyTrim(message))
			throw new IllegalArgumentException();
		
		_source = source;
		_target = target;
		_message = message;
		
	}
	public String get_source() {
		return _source;
	}
	public String get_target() {
		return _target;
	}
	public String get_message() {
		return _message;
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
			.append(_target)
			.append(IrcMessageUtils.SPACE)
			.append(IrcMessageUtils.MSG_PARAM_PREFIX)
			.append(_message)
			.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	protected String _source;
	protected String _target;
	protected String _message;
	
}
