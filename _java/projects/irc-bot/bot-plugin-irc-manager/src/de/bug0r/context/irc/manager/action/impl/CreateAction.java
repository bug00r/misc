package de.bug0r.context.irc.manager.action.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MultiRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.context.irc.impl.IrcContextConfiguration;
import de.bug0r.context.irc.impl.IrcContextImpl;
import de.bug0r.context.irc.manager.IrcConfigContext;
import de.bug0r.message.irc.impl.UserMessage.EUserMode;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class CreateAction extends AbstractAction implements Context {

	public CreateAction(ConcurrentHashMap<String, Context> configMap,
			Map<String, IrcContext> ircContextMap) {
		super(configMap, ircContextMap);
	}

	@Override
	public ContextResponse perform(ContextRequest request) {
		String result = "";
		try {
			String server = (String) request.getParameter("server");
			String host = (String) request.getParameter("host");
			int port = Integer.parseInt((String) request.getParameter("port"));
			String nick = (String) request.getParameter("nick");
			String realName = (String) request.getParameter("realName");
			DefaultIrcConnectionConfiguration connectionConfiguration = new DefaultIrcConnectionConfiguration(
					InetAddress.getByName(server), 
					port, host, nick, realName,
					String.valueOf(System.currentTimeMillis()),
					EUserMode.MODE_3);
			IrcContextConfiguration config = new IrcContextConfiguration(connectionConfiguration);
			IrcContext newIrcContext = new IrcContextImpl(config);
			ircContextMap.put(server, newIrcContext);
		} catch (NumberFormatException e) {
			result = "given port error: " + e.getMessage();
		} catch (UnknownHostException e) {
			result = "unknown host error: " + e.getMessage();
		}
		return new StringResponse(result);
	}

	
	
}
