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
public class ModeMessage extends AbstractMessage {

	/**
	 * 
	 * @param target user oder channel
	 * @param modes modes like "-iaw..."
	 * @param modeParameter 
	 */
	public ModeMessage(String nick, String target, String modes, String modeParameter) {
		super(IrcMessage.MODE);
		
		if ( StringUtils.isEmptyTrim(target) ||
				StringUtils.isEmptyTrim(modes))
			throw new IllegalArgumentException();
		
		
		_target = target;
		_modes = modes;
		_modeParameter = (StringUtils.isEmptyTrim(modeParameter) ?
				StringUtils.EMPTY_STRING:modeParameter);
		_nick = nick;
		
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( !StringUtils.isEmptyTrim(_nick) ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_nick)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE)
			.append(_target)
			.append(IrcMessageUtils.SPACE)
			.append(_modes);
		
		if ( !StringUtils.isEmptyTrim(_modeParameter)  ) {
			msg.append(IrcMessageUtils.SPACE)
			.append(_modeParameter);
		}
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	
	public String getUser() {
		return _target;
	}
	
	public String getModes() {
		return _modes;
	}

	private String _target;
	private String _modes;
	private String _modeParameter;
	private String _nick;
	
}
