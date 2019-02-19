/**
 * 
 */
package de.bug0r.protocol.irc.connection.config;

import java.net.InetAddress;

/**
 * @author bug0r
 * @version 0.1
 */
public interface IIrc {

	/**
	 * 
	 * @return Address from to connecting server
	 */
	public InetAddress getServerAddress();
	/**
	 * 
	 * @return connection port
	 */
	public Integer getPort();
	/**
	 * 
	 * @return connetion timeout
	 */
	public Integer getTimeout();
	/**
	 * 
	 * @return the use of ssl 
	 */
	public boolean useSSL();
	/**
	 * 
	 * @return true if minimal configuration valid, otherwise false
	 */
	public boolean isValidConfiguration();

	/**
	 * 
	 * @return true if timeout should be use, otherwise false
	 */
	public boolean useTimeout();
	
}
