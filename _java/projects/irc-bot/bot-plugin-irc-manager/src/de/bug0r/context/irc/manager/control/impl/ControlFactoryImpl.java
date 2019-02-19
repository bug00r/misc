package de.bug0r.context.irc.manager.control.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.NullContext;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.manager.control.ControlFactory;

public class ControlFactoryImpl implements ControlFactory {

	public ControlFactoryImpl(ConcurrentHashMap<String, Context> configMap, Map<String, IrcContext> ircContextMap) {
		this.controlMap = new HashMap<Object, Context>();
		this.controlMap.put("context", new ContextControl(configMap, ircContextMap));
		this.controlMap.put("plugin", new PluginControl(configMap, ircContextMap));
	}
	
	@Override
	public Context getControl(Object key) {
		if ( key == null || !this.controlMap.containsKey(key) ) return new NullContext();
		return this.controlMap.get(key);
	}
	
	private Map<Object, Context> controlMap;
	
}
