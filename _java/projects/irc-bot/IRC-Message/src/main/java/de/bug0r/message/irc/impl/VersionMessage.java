/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author jessica
 *
 */
public class VersionMessage extends AbstractOptionalTargetMessage {

	/**
	 * @param messageId
	 * @param target
	 */
	public VersionMessage( String target) {
		super(IrcMessage.VERSION, target);
	}

}
