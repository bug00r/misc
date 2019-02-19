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
public class TopicMessage extends AbstractMessage {

	/**
	 * 
	 * changes topic. if topic null the topic is reset
	 * 
	 * @param nick name who changes topic, null if its current user
	 * @param channel channel in which topic is changed
	 * @param topic topic to change.
	 */
	public TopicMessage(String nick, String channel, String topic) {
		super(IrcMessage.TOPIC);
		
		if ( StringUtils.isEmptyTrim(channel) )
			throw new IllegalArgumentException();
		
		_channel = channel;
		_nick = nick;
		_topic = topic;
		
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
			.append(_channel);
		
		if ( _topic != null ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_topic.trim());
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _nick;
	private String _topic;
	private String _channel;
	
}
