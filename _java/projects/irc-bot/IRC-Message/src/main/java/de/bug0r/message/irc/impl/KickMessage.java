/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.List;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.core.utils.collection.CollectionUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class KickMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public KickMessage(String sourceNick, List<String> channel, List<String> targetNicks, String comment ) {
		super(IrcMessage.KICK);
		
		if ( CollectionUtils.isEmpty(channel) ||
				CollectionUtils.isEmpty(targetNicks))
			throw new IllegalArgumentException();
		
		_sourceNick = sourceNick;
		_comment = comment;
		_channel = channel;
		_targetNicks = targetNicks;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if ( !StringUtils.isEmptyTrim(_sourceNick) ) {
			msg.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_sourceNick)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE);
		
	
		for ( String channel: _channel ) {
			msg.append(channel)
				.append(IrcMessageUtils.MSG_PARAM_SEP);
		}
			
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP))
			.append(IrcMessageUtils.SPACE);
		
		for ( String channel: _targetNicks ) {
			msg.append(channel)
				.append(IrcMessageUtils.MSG_PARAM_SEP);
		}
		
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP));
		
		if ( !StringUtils.isEmptyTrim(_comment) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(IrcMessageUtils.MSG_PARAM_PREFIX)
				.append(_comment);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _sourceNick;
	private String _comment;
	private List<String> _channel;
	private List<String> _targetNicks;
	
	
}
