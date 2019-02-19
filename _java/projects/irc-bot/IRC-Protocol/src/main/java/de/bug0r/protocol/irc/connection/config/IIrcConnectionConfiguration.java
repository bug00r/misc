/**
 * 
 */
package de.bug0r.protocol.irc.connection.config;

import de.bug0r.message.irc.impl.UserMessage.EUserMode;


/**
 * @author bug0r
 * @version 0.1
 */
public interface IIrcConnectionConfiguration {

	/**
	 * 
	 * @return nickname
	 */
	public String getNickName();
	/**
	 * 
	 * @return host
	 */
	public String getHost();
	/**
	 * 
	 * @return Realname
	 */
	public String getRealName();
	/**
	 * 
	 * @return connection password
	 */
	public String getPassword();
	/**
	 * 
	 * @return connection password
	 */
	public EUserMode getUsermode();
	
}
