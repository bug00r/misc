package de.bug0r.bot.context.impl;

import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.core.utils.String.StringUtils;

public abstract class AbstractConfigurableContext implements Context {

	public AbstractConfigurableContext() {
		configMap = new ConcurrentHashMap<String, Context>();
	}
	
	@Override
	public ContextResponse perform(ContextRequest request) {
		return doPerform(request);
	}

	public void addConfig(String alias, Context config, boolean override) {
		if ( !StringUtils.isEmptyTrim(alias) && config != null ) {
			if ( override || !this.configMap.containsKey(alias) ) {
				this.configMap.put(alias, config);
			}
		}
	}
	
	public void removeConfig(String alias) {
		if (alias != null) {
			this.configMap.remove(alias);
		}
	}
	
	public Object[] listConfig() {
		 return this.configMap.keySet().toArray();
	}
	
	protected abstract ContextResponse doPerform(ContextRequest request);
	
	protected ConcurrentHashMap<String, Context> configMap;
}
