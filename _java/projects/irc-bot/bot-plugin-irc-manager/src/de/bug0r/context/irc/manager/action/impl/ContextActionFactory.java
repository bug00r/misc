package de.bug0r.context.irc.manager.action.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.NullContext;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.manager.action.ActionFactory;

public class ContextActionFactory implements ActionFactory {

	public ContextActionFactory(ConcurrentHashMap<String, Context> configMap, Map<String, IrcContext> ircContextMap) {
		this.actionMap = new HashMap<Object, Context>();
		this.actionMap.put("create", new CreateAction(configMap,ircContextMap));
		this.actionMap.put("delegate", new DelegateAction(configMap,ircContextMap));
		this.actionMap.put("connect", new ConnectAction(configMap,ircContextMap));
		this.actionMap.put("disconnect", new DisconnectAction(configMap,ircContextMap));
	}
	
	@Override
	public Context getAction(Object key) {
		if ( key == null || !this.actionMap.containsKey(key) ) return new NullContext();
		return this.actionMap.get(key);
	}
	
	private Map<Object, Context> actionMap;
	
}
