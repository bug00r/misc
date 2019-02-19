/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.List;

import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 * @version 0.1
 */
public class ServlistMessage extends AbstractOptionalMultiTargetMessage {

	/**
	 * @param messageId
	 * @param targets
	 * @param targetDelimiter
	 */
	public ServlistMessage(List<String> targets) {
		super(IrcMessage.SERVLIST, targets, IrcMessageUtils.SPACE);
	}

}
