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
public class WhoisMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public WhoisMessage(String target, List<String> masks) {
		super(IrcMessage.WHOIS);
		
		if ( CollectionUtils.isEmpty(masks) )
			throw new IllegalArgumentException();
		
		
		_target = target;
		_masks = masks;
		
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
		.append(IrcMessageUtils.SPACE);
		
		if ( !StringUtils.isEmptyTrim(_target) ) {
			msg.append(_target)
				.append(IrcMessageUtils.SPACE);
		}
		
		for ( String channel: _masks ) {
			msg.append(channel)
				.append(IrcMessageUtils.MSG_PARAM_SEP);
		}
		
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP))
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _target;
	private List<String> _masks;
	
}
