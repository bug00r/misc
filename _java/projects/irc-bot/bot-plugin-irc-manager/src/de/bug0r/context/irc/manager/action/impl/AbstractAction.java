package de.bug0r.context.irc.manager.action.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.context.irc.IrcContext;

public abstract class AbstractAction {

	protected ConcurrentHashMap<String, Context> configMap;
	protected Map<String, IrcContext> ircContextMap;

	public AbstractAction(ConcurrentHashMap<String, Context> configMap,
			Map<String, IrcContext> ircContextMap) {
		if (configMap == null ) throw new IllegalArgumentException("no config map given");
		if (ircContextMap == null ) throw new IllegalArgumentException("no irc context map given");
		this.configMap = configMap;
		this.ircContextMap = ircContextMap;
	}
	
}
