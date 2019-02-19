package de.bug0r.context.irc.manager.action.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.irc.IrcContext;

public class ConnectAction extends AbstractAction implements Context {

	public ConnectAction(ConcurrentHashMap<String, Context> configMap,
			Map<String, IrcContext> ircContextMap) {
		super(configMap, ircContextMap);
	}

	@Override
	public ContextResponse perform(ContextRequest request) {
		String server = (String) request.getParameter("server");
		String result = "established: " + server;
		IrcContext context = ircContextMap.get(server);
		if ( context == null ) 
			result = "connect error: " + server + " not found";
		else {
			context.activate();
			result = "connection successful: " + server;
		}
		//TODO may be handle function isActivated?!
		context.activate();
		return new StringResponse(result);
	}

}
