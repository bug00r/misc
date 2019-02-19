/**
 * 
 */
package de.bug0r.message.irc;

import java.util.Hashtable;
import java.util.Map;

import de.bug0r.core.utils.String.StringUtils;


/**
 * @author bug0r
 * @version 0.1
 */
public enum IrcMessage {
    NULL("NULL"),
    NUMERIC("NUMERIC"),
	PASS("PASS"),
	NICK("NICK"),
	USER("USER"),
	OPER("OPER"),
	QUIT("QUIT"),
	JOIN("JOIN"),
	PART("PART"),
	TOPIC("TOPIC"),
	NAMES("NAMES"),
	LIST("LIST"),
	INVITE("INVITE"),
	KICK("KICK"),
	PRIVMSG("PRIVMSG"),
	NOTICE("NOTICE"),
	MODT("MODT"),
	LUSERS("LUSERS"),
	VERSION("VERSION"),
	STATS("STATS"),
	LINKS("LINKS"),
	TIME("TIME"),
	TRACE("TRACE"),
	CONNECT("CONNECT"),
	ADMIN("ADMIN"),
	INFO("INFO"),
	SERVLIST("SERVLIST"),
	SQUERY("SQUERY"),
	WHO("WHO"),
	WHOIS("WHOIS"),
	WHOWAS("WHOWAS"),
	KILL("KILL"),
	PING("PING"),
	PONG("PONG"),
	ERROR("ERROR"),
	AWAY("AWAY"),
	REHASH("REHASH"),
	DIE("DIE"),
	RESTART("RESTART"),
	SUMMON("SUMMON"),
	USERS("USERS"),
	WALLOPS("WALLOPS"),
	USERHOST("USERHOST"),
	ISON("ISON"),
	MODE("MODE");
	
	//init reverse map container
	private static Map<String,IrcMessage> _reverseMap = new Hashtable<String,IrcMessage>();
	
	//add all reverse entries
	static {
		for(IrcMessage message : IrcMessage.values())
			_reverseMap.put(message.toString(), message);
	     
	}
	
	/**
	 * private C'tor
	 * @param value message value
	 */
	private IrcMessage(String value) {
		if ( StringUtils.isEmtpy(value) )
			throw new IllegalArgumentException();
		
		_value = value;
	}

	/**
	 * 
	 * @param message message for reverse access
	 * @return
	 */
	public static IrcMessage reverse(String message) {
		return _reverseMap.get(message);
	}
	
	@Override
	public String toString() {
		return _value;
	}
	
	/** message ident */
	private String _value;
	
}
