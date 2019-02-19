/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.List;

import de.bug0r.core.utils.collection.CollectionUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 * @version 0.1
 */
public abstract class AbstractMultiChannelMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public AbstractMultiChannelMessage(IrcMessage messageType ,List<String> channel) {
		super(messageType);
		
		_channel = channel;
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString());
		
		if ( !CollectionUtils.isEmpty(_channel) ) {
			msg.append(IrcMessageUtils.SPACE);
			for ( String channel: _channel ) {
				msg.append(channel)
					.append(IrcMessageUtils.MSG_PARAM_SEP);
				}
			
				msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP));
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _channel;
	
}
