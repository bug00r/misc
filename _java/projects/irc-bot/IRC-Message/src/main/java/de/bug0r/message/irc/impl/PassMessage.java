/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * 
 * password message
 * 
 * @author bug0r
 * @version 0.1 
 *
 */
public class PassMessage extends AbstractMessage {

	public PassMessage(String password) {
		super(IrcMessage.PASS);

		if ( StringUtils.isEmtpy(password) )
			throw new NullPointerException();
		
		_password = password;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
		   .append(IrcMessageUtils.SPACE)
		   .append(_password)
		   .append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _password;
	
}
