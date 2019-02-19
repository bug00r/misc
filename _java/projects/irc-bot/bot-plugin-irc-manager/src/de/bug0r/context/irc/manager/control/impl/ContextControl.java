package de.bug0r.context.irc.manager.control.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.manager.action.ActionFactory;
import de.bug0r.context.irc.manager.action.impl.ContextActionFactory;

public class ContextControl implements Context {

	public ContextControl(ConcurrentHashMap<String, Context> configMap, Map<String, IrcContext> ircContextMap) {
		this.actionFactory = new ContextActionFactory(configMap,ircContextMap);
	}
	
	@Override
	public ContextResponse perform(ContextRequest request) {
		Context action = this.actionFactory.getAction(request.getParameter("action"));
		ContextResponse response = action.perform(request);
		return response;
	}

	private ActionFactory actionFactory;
}
