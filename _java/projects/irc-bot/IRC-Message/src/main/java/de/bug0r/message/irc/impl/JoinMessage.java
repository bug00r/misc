/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.ArrayList;
import java.util.List;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.core.utils.collection.CollectionUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 *
 */
public class JoinMessage extends AbstractMessage {
	
	public JoinMessage(String nick, String channel) {
		super(IrcMessage.JOIN);
		
		if ( StringUtils.isEmptyTrim(channel) || 
				StringUtils.isEmptyTrim(nick)) {
			throw new IllegalArgumentException();
		}
		
		_channel = new ArrayList<String>();
		_passwords = new ArrayList<String>();
		
		_channel.add(channel);
		_nick = nick.trim();
	}
	
	/**
	 * 
	 * Method generate single or multichannel join. Message will be create
	 * in order from channel and password list and both should be ordered.
	 * Means, channel with password at first, channels without passwords at
	 * last.
	 * 
	 * @param channel list with channel
	 * @param passwords list with passwords
	 */
	public JoinMessage(List<String> channel, List<String> passwords) {
		super(IrcMessage.JOIN);
		
		if ( CollectionUtils.isEmpty(channel)) {
			throw new IllegalArgumentException();
		}
		
		_channel = channel;
		_passwords = ( CollectionUtils.isEmpty(passwords) ? 
				       new ArrayList<String>(): passwords );
		
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
			.append(IrcMessageUtils.SPACE);
		
		msg.append(StringUtils.collectionToSeparatedString(_channel, IrcMessageUtils.MSG_PARAM_SEP));
		if (!_passwords.isEmpty()) msg.append(IrcMessageUtils.SPACE);
		msg.append(StringUtils.collectionToSeparatedString(_passwords, IrcMessageUtils.MSG_PARAM_SEP));
	
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _channel;
	private List<String> _passwords;
	private String _nick;

}
