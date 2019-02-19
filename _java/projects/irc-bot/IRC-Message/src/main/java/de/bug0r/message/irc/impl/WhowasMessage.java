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
 */
public class WhowasMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public WhowasMessage(List<String> nicks, String count, String target) {
		super(IrcMessage.WHOWAS);
		
		if ( CollectionUtils.isEmpty(nicks) )
			throw new IllegalArgumentException();
		
		_nicks = nicks;
		_count = count;
		_target = target;
		
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE);

		for ( String nick: _nicks ) {
			msg.append(nick)
				.append(IrcMessageUtils.MSG_PARAM_SEP);
		}
		
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP));
		
		if ( !StringUtils.isEmptyTrim(_count) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(_count);
		}
		
		if ( !StringUtils.isEmptyTrim(_target) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(_target);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _nicks;
	private String _count;
	private String _target;
	
}
