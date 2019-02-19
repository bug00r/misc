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
public class NumericMessage extends AbstractMessage {

	public NumericMessage(String source, String numeric, String target, String text){
		super(IrcMessage.NUMERIC);
		
		if ( StringUtils.isEmptyTrim(source) || 
				StringUtils.isEmptyTrim(numeric) ||
				StringUtils.isEmptyTrim(target))
			throw new IllegalArgumentException();
		
		_source = source;
		_numeric = numeric;
		_target = target;
		_text = text;
	
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
			.append(_source).
			append(IrcMessageUtils.SPACE)
			.append(_numeric)
			.append(IrcMessageUtils.SPACE)
			.append(_target);
		
		if ( !StringUtils.isEmptyTrim(_text) ) {
			msg.append(IrcMessageUtils.SPACE)
			.append(IrcMessageUtils.MSG_PARAM_PREFIX)
			.append(_text);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	@Override
	public IrcMessage getMessageId() {
		return null;
	}
	
	private String _source;
	private String _numeric;
	private String _target;
	private String _text;

	
}
