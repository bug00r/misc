/**
 * 
 */
package de.bug0r.message.irc.impl;

import java.util.List;

import de.bug0r.message.irc.IrcMessage;

/**
 * @author bug0r
 * @version 0.1
 */
public class NamesMessage extends AbstractMultiChannelMessage {

	/**
	 * @param messageType
	 * @param channel
	 */
	public NamesMessage(List<String> channel) {
		super(IrcMessage.NAMES, channel);
	}

}
