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
public abstract class AbstractPingPongMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public AbstractPingPongMessage(IrcMessage messageId, List<String> server) {
		super(messageId);

		if ( CollectionUtils.isEmpty(server) )
			throw new IllegalArgumentException();
		
		_server = server;
		
	}

	@Override
	public String toString() {
	    StringBuilder msg = new StringBuilder();
	    
	    msg.append(super.toString())
	    	.append(IrcMessageUtils.SPACE);
	    
	    for ( String server: _server ) {
			msg.append(server)
				.append(IrcMessageUtils.SPACE);
		}
		
		msg.deleteCharAt(msg.lastIndexOf(IrcMessageUtils.SPACE))
		.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
	    
		return new String(msg);
	}
	
	private List<String> _server;
	
}
