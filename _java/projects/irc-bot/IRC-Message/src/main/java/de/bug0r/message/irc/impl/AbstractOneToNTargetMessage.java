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
public abstract class AbstractOneToNTargetMessage extends AbstractMessage {


	/**
	 * @param messageId
	 */
	public AbstractOneToNTargetMessage(IrcMessage messageId, List<String> targets ) {
		super(messageId);

		if ( CollectionUtils.isEmpty(targets))
			throw new IllegalArgumentException();
		
		_targets = targets;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
		 .append(IrcMessageUtils.SPACE);
		
		for ( String target: _targets ) {
			msg.append(target)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.SPACE))
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _targets;
	
}
