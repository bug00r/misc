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
public abstract class AbstractOptionalMultiTargetMessage extends
		AbstractMessage {

	/**
	 * 
	 * @param messageId
	 * @param targets
	 * @param targetDelimiter
	 */
	public AbstractOptionalMultiTargetMessage(IrcMessage messageId, List<String> targets, String targetDelimiter ) {
		super(messageId);
		
		if ( StringUtils.isEmtpy(targetDelimiter) )
			_targetDelimiter = IrcMessageUtils.SPACE;
		else
			_targetDelimiter = targetDelimiter;
		_targets = targets;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString());
		
		if ( !CollectionUtils.isEmpty(_targets) ) {
			msg.append(IrcMessageUtils.SPACE);
			for ( String channel: _targets ) {
				msg.append(channel)
					.append(_targetDelimiter);
			}
			msg.deleteCharAt(msg.lastIndexOf(_targetDelimiter));
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private List<String> _targets;
	private String _targetDelimiter;
}
