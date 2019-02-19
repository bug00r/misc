/**
 * 
 */
package de.bug0r.protocol.irc.parser.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.message.irc.IrcMessage;
import de.bug0r.protocol.irc.parser.message.IMessageParser;
import de.bug0r.protocol.irc.parser.message.IMessageParserFactory;

public class IrcMessageParserFactory implements IMessageParserFactory {

	private final Map<IrcMessage, IMessageParser> _parserMap = new HashMap<IrcMessage, IMessageParser>();
	
	/* (non-Javadoc)
	 * @see de.bug0r.protocol.irc.parser.message.IMessageParserFactory#getParser(de.bug0r.protocol.irc.parser.message.impl.EIrcMessage)
	 */
	@Override
	public synchronized IMessageParser getParser(IrcMessage message) {
		if ( null == message ) return _parserMap.get(IrcMessage.NULL);
		return _parserMap.get(message);
	}

	public IrcMessageParserFactory() {
		_parserMap.put(IrcMessage.NULL, new NullParser());
		_parserMap.put(IrcMessage.JOIN, new JoinParser());
		_parserMap.put(IrcMessage.NOTICE, new NoticeParser());
		_parserMap.put(IrcMessage.PRIVMSG, new PrivMsgParser());
		_parserMap.put(IrcMessage.PONG, new PongParser());
		_parserMap.put(IrcMessage.PING, new PingParser());
		_parserMap.put(IrcMessage.PASS, new PassParser());
		_parserMap.put(IrcMessage.PART, new PartParser());
		_parserMap.put(IrcMessage.NICK, new NickParser());
		_parserMap.put(IrcMessage.QUIT, new QuitParser());
		_parserMap.put(IrcMessage.ADMIN, new AdminParser());
		_parserMap.put(IrcMessage.INFO, new InfoParser());
		_parserMap.put(IrcMessage.TRACE, new TraceParser());
		_parserMap.put(IrcMessage.STATS, new StatsParser());
		_parserMap.put(IrcMessage.TIME, new TimeParser());
		_parserMap.put(IrcMessage.VERSION, new VersionParser());
		_parserMap.put(IrcMessage.WHO, new WhoParser());
		_parserMap.put(IrcMessage.WHOIS, new WhoParser());
		_parserMap.put(IrcMessage.WHOWAS, new WhoParser());
		_parserMap.put(IrcMessage.MODT, new MotdParser());
		_parserMap.put(IrcMessage.LUSERS, new LusersParser());
		_parserMap.put(IrcMessage.DIE, new DieParser());
		_parserMap.put(IrcMessage.ERROR, new ErrorParser());
		_parserMap.put(IrcMessage.RESTART, new RestartParser());
		_parserMap.put(IrcMessage.AWAY, new AwayParser());
		_parserMap.put(IrcMessage.CONNECT, new ConnectParser());
		_parserMap.put(IrcMessage.INVITE, new InviteParser());
		_parserMap.put(IrcMessage.USERHOST, new UserhostParser());
		_parserMap.put(IrcMessage.ISON, new IsonParser());
		_parserMap.put(IrcMessage.KICK, new KickParser());
		_parserMap.put(IrcMessage.KILL, new KillParser());
		_parserMap.put(IrcMessage.LINKS, new LinksParser());
		_parserMap.put(IrcMessage.LIST, new ListParser());
		_parserMap.put(IrcMessage.MODE, new ModeParser());
		_parserMap.put(IrcMessage.NAMES, new NamesParser());
		_parserMap.put(IrcMessage.OPER, new OperParser());
		_parserMap.put(IrcMessage.SERVLIST, new ServlistParser());
		_parserMap.put(IrcMessage.SQUERY, new SqueryParser());
		_parserMap.put(IrcMessage.NUMERIC, new NumericParser());
		
		//INFO not implement: summon, users, user, wallops
	}
	
}
