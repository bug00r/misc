/**
 * 
 */
package de.bug0r.protocol.irc.connection.config.impl;

import java.net.InetAddress;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.impl.UserMessage.EUserMode;
import de.bug0r.protocol.irc.connection.config.IIrcConnectionConfiguration;


/**
 * @author bug0r
 * @version 0.1
 */
public class DefaultIrcConnectionConfiguration extends DefaultIrcSocketConnection implements
		IIrcConnectionConfiguration {

	public DefaultIrcConnectionConfiguration(InetAddress server, Integer port, String host, String nick, String realName, String password, EUserMode mode) {
		super(server,port);
		setAdvancedConfig(host, nick, realName, password, mode);
	}
	
	public DefaultIrcConnectionConfiguration(InetAddress server, Integer port, Integer timeout, String host, String nick, String realName, String password, EUserMode mode) {
		super(server,port,timeout);
		setAdvancedConfig(host, nick, realName, password, mode);
	}
	
	public DefaultIrcConnectionConfiguration(InetAddress server, Integer port, boolean useSSL, String host, String nick, String realName, String password, EUserMode mode) {
		super(server,port,useSSL);
		setAdvancedConfig(host, nick, realName, password, mode);
	}
	
	public DefaultIrcConnectionConfiguration(InetAddress server, Integer port, Integer timeout, boolean useSSL, String host, String nick, String realName, String password, EUserMode mode) {
		super(server,port,timeout,useSSL);
		setAdvancedConfig(host, nick, realName, password, mode);
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public String getRealName() {
		return realName;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public EUserMode getUsermode() {
		return _mode;
	}
	
	private void setAdvancedConfig(String host, String nick, String realName, String password, EUserMode mode) {
		String error = null;
		if ( StringUtils.isEmptyTrim(host) ) error = "host";
		if ( error != null && StringUtils.isEmptyTrim(nick) ) error = "nick";
		if ( error != null && StringUtils.isEmptyTrim(realName) ) error = "realname";
		if ( error != null && StringUtils.isEmptyTrim(password) ) error = "password";
		if ( !StringUtils.isEmtpy(error) ) {
			throw new NullPointerException(error + " is missing");
		}
		//set default invisible mode
		if ( null == mode ) _mode = EUserMode.MODE_3;
		
		_mode = mode;
		this.host = host;
		this.nickName = nick;
		this.realName = realName;
		this.password = password;
		
	}
	
	/** hostname */
	private String host;
	/** nickname */
	private String nickName;
	/** realname */
	private String realName;
	/** password */
	private String password;
	/** usermode */
	private EUserMode _mode;


}
