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
public class NickMessage extends AbstractMessage {

	public NickMessage(String nick) {
		super(IrcMessage.NICK);
		
		if ( StringUtils.isEmptyTrim(nick) )
			throw new IllegalArgumentException();
		
		_useOldNick = Boolean.FALSE;
		_nick = nick;
		_oldNick = StringUtils.EMPTY_STRING;
	}

	public NickMessage(String nick, String oldNick) {
		super(IrcMessage.NICK);
		
		if ( StringUtils.isEmptyTrim(nick) || 
				StringUtils.isEmptyTrim(nick) )
			throw new IllegalArgumentException();
		
		_useOldNick = Boolean.TRUE;
		_nick = nick;
		_oldNick = oldNick;
	}
		
	public String getNick() {
		return _nick;
	}

	public String getOldNick() {
		return _oldNick;
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( _useOldNick ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
			   .append(_oldNick)
			   .append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString())
		.append(IrcMessageUtils.SPACE)
		.append(_nick)
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	/** flag is using ol nick */
	private boolean _useOldNick;
	/** new nick */
	private String _nick;
	/** old nick which want to change from */
	private String _oldNick;
}
