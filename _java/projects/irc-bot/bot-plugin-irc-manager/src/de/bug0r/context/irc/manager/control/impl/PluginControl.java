package de.bug0r.context.irc.manager.control.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.manager.action.ActionFactory;
import de.bug0r.context.irc.manager.action.impl.PluginActionFactory;

public class PluginControl implements Context{

	public PluginControl(ConcurrentHashMap<String, Context> configMap, Map<String, IrcContext> ircContextMap) {
		this.pluginFactory = new PluginActionFactory(configMap,ircContextMap);
	}
	
	@Override
	public ContextResponse perform(ContextRequest request) {
		Context plugin = this.pluginFactory.getAction(request.getParameter("plugin"));
		ContextResponse response = plugin.perform(request);
		return response;
	}

	private ActionFactory pluginFactory;
}
