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
public class UserMessage extends AbstractMessage {

	public static enum EUserMode {
		MODE_0(1),
		MODE_1(2),
		MODE_2(4),
		MODE_3(8);
		
		private EUserMode(int mode) {
			_mode = mode;
		}
		
		@Override
		public String toString() {
			return String.valueOf(_mode);
		}
		
		private int _mode;
	}
	
	/**
	 * @param messageId
	 */
	public UserMessage(String user, EUserMode mode, String realName) {
		super(IrcMessage.USER);
		
		if ( StringUtils.isEmptyTrim(user) ||
				StringUtils.isEmptyTrim(realName))
			throw new IllegalArgumentException();
		
		_mode = mode;
		_user = user;
		_realName = realName;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
		   .append(IrcMessageUtils.SPACE)
		   .append(_user)
		   .append(IrcMessageUtils.SPACE)
		   .append(_mode.toString())
		   .append(IrcMessageUtils.SPACE)
		   .append(IrcMessageUtils.MSG_PARAM_ASTERIX)
		   .append(IrcMessageUtils.SPACE)
		   .append(IrcMessageUtils.MSG_PARAM_PREFIX)
		   .append(_realName)
		   .append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	/** usermode */
	private EUserMode _mode;
	/** username */
	private String _user;
	/** realname from user */
	private String _realName;
	
}
