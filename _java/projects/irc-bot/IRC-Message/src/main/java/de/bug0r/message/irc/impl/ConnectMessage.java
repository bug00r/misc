/**
 * 
 */
package de.bug0r.message.irc.impl;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class ConnectMessage extends AbstractMessage {

	/**
	 * @param messageId
	 */
	public ConnectMessage(String targetServer, String port, String remoteServer) {
		super(IrcMessage.CONNECT);

		if ( StringUtils.isEmptyTrim(targetServer) ||
				StringUtils.isEmptyTrim(port))
			throw new IllegalArgumentException();
		
		_targetServer = targetServer;
		_port	= port;
		_remoteServer = remoteServer;
		
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append(super.toString())
			.append(IrcMessageUtils.SPACE)
			.append(_targetServer)
			.append(IrcMessageUtils.SPACE)
			.append(_port);
		
		if ( !StringUtils.isEmptyTrim(_remoteServer) ) {
			msg.append(IrcMessageUtils.SPACE)
				.append(_remoteServer);
		}
		
		msg.append(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
		
		return new String(msg);
	}
	
	private String _targetServer;
	private String _port;
	private String _remoteServer;
	
}
