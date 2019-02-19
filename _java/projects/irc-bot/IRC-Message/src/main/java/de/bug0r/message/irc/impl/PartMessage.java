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
public class PartMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public PartMessage(String nick, String channel, String message) {
		super(IrcMessage.PART);
		
		if ( StringUtils.isEmptyTrim(channel) )
			throw new IllegalArgumentException();
		
		_channel = new ArrayList<String>();
		_channel.add(channel);
		
		_nick = nick;
		_message = message;
		
	}
	
	/**
	 * @param messageId
	 */
	public PartMessage(List<String> channel, String message) {
		super(IrcMessage.PART);
		
		if (CollectionUtils.isEmpty(channel))
			throw new IllegalArgumentException();
		
		_channel = channel;
		_message = message;
		
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
	
		for ( String channel: _channel ) {
		msg.append(channel)
			.append(IrcMessageUtils.MSG_PARAM_SEP);
		}
	
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP));
		
		if ( !StringUtils.isEmptyTrim(_message) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_message);
		}
	
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _channel;
	private String _message;
	private String _nick;
	
}
