package de.bug0r.context.irc.manager.action.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.IrcContext;

public class PluginBindAction extends AbstractAction implements Context {


	public PluginBindAction(ConcurrentHashMap<String, Context> configMap,
			Map<String, IrcContext> ircContextMap) {
		super(configMap, ircContextMap);
	}

	@Override
	public ContextResponse perform(ContextRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
