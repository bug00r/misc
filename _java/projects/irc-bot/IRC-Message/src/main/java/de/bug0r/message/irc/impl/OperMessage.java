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
public class OperMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public OperMessage(String username, String password) {
		super(IrcMessage.OPER);
		
		if ( StringUtils.isEmptyTrim(username) || 
				StringUtils.isEmptyTrim(password))
			throw new IllegalArgumentException();
	
		_username = username;
		_password = password;
		
	}

	public String getUsername() {
		return _username;
	}

	public String getPassword() {
		return _password;
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
		   .append(IrcMessageUtils.SPACE)
		   .append(_username)
		   .append(IrcMessageUtils.SPACE)
		   .append(_password)
		   .append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	
	/** user who wants oper */
	private String _username;
	/** password for oper */
	private String _password;
	
}
