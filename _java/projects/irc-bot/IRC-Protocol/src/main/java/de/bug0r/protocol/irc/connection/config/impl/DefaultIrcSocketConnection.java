/**
 * 
 */
package de.bug0r.protocol.irc.connection.config.impl;

import java.net.InetAddress;

import de.bug0r.protocol.irc.connection.config.IIrc;

/**
 * 
 * Implementaton from default socket configuration
 * 
 * @author bug0r
 * @version 0.1
 */
public class DefaultIrcSocketConnection implements IIrc {

	/**
	 * default irc port 6667
	 */
	public static final Integer DEFAULT_IRC_PORT = 6667;
	
	public DefaultIrcSocketConnection(InetAddress server, Integer port) {
		setConfig(server, port, null, false);
	}
	
	public DefaultIrcSocketConnection(InetAddress server, Integer port, Integer timeout) {
		setConfig(server, port, timeout, false);
	}
	
	public DefaultIrcSocketConnection(InetAddress server, Integer port, boolean useSSL) {
		setConfig(server, port, null, useSSL);
	}
	
	public DefaultIrcSocketConnection(InetAddress server, Integer port, Integer timeout, boolean useSSL) {
		setConfig(server, port, timeout, useSSL);
	}
	
	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.socket.config.IIrcSocketConfiguration#getServerAddress()
	 */
	@Override
	public InetAddress getServerAddress() {
		return serverAddress;
	}

	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.socket.config.IIrcSocketConfiguration#getPort()
	 */
	@Override
	public Integer getPort() {
		return port;
	}

	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.socket.config.IIrcSocketConfiguration#getTimeout()
	 */
	@Override
	public Integer getTimeout() {
		return timeout;
	}

	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.socket.config.IIrcSocketConfiguration#useSSL()
	 */
	@Override
	public boolean useSSL() {
		return useSSL;
	}
	
	@Override
	public boolean isValidConfiguration() {
		return null != serverAddress && null != port && port.intValue() > 0 ;
	}

	@Override
	public boolean useTimeout() {
		return null != timeout && timeout.intValue() > 0;
	}
	
	private void setConfig(InetAddress server, Integer port, Integer timeout, boolean useSSL) {
		if ( null == server )
			throw new NullPointerException();
		if ( null == port) this.port = DEFAULT_IRC_PORT;
		else this.port = port;
		this.serverAddress = server;
		this.timeout = timeout;
		this.useSSL = useSSL;
	}
	
	private InetAddress serverAddress;
	private Integer timeout;
	private Integer port;
	private boolean useSSL;
}
