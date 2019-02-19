package de.bug0r.context.manager.impl;

import java.util.List;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.loader.ContextLoader;
import de.bug0r.bot.context.loader.exception.ContextLoadException;
import de.bug0r.bot.context.loader.impl.ContextLoaderImpl;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.manager.ContextManager;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.core.utils.collection.CollectionUtils;

public class ContextManagerImpl implements ContextManager {


	public ContextManagerImpl() {
		this.contextLoader = new ContextLoaderImpl();
		this.loadedContext = ((ContextLoaderImpl)this.contextLoader).getLoadedContext(); // ADD to interface
	}
	
	@Override
	public void loadContext(String type, String alias, String contextSource, String parent) throws ContextLoadException {
		if ( StringUtils.isEmptyTrim(alias) ) throw new ContextLoadException("no alias give");
		if ( StringUtils.isEmptyTrim(contextSource) ) throw new ContextLoadException("no context source give");
		if ( StringUtils.isEmptyTrim(type) ) throw new ContextLoadException("no context type give");
		if ( this.loadedContext.containsKey(alias) ) throw new ContextLoadException("alias \"" + alias + "\" already exists" );
		Context loadedContext;
		if ( StringUtils.isEmptyTrim(parent) ) {
			loadedContext = this.contextLoader.loadContext(contextSource, type);
		} else {
			loadedContext = this.contextLoader.loadContext(contextSource, type, parent);
		}
		this.loadedContext.put(alias, loadedContext);
	}

	@Override
	public void removeContext(List<String> aliasList) {
		if ( aliasList != null && !aliasList.isEmpty() ) {
			for(String alias: aliasList) {
				this.loadedContext.remove(alias);
			}
		}
	}

	@Override
	public void delegateContext(List<String> aliasList,
			List<String> targetAliasList) {
		processAlias(aliasList, targetAliasList, true);
	}

	@Override
	public ContextResponse perform(String alias, ContextRequest request) {
		if ( StringUtils.isEmptyTrim(alias) ) return new StringResponse("no alias given");
		Context context = this.loadedContext.get(alias);
		if ( context == null ) return new StringResponse("no context found: " + alias);
		return context.perform(request);
	}
	
	@Override
	public void removeDelegation(List<String> aliasList,
			List<String> targetAliasList) {
		processAlias(aliasList, targetAliasList, false);
	}
	
	private void processAlias(List<String> aliasList,
			List<String> targetAliasList, boolean add) {
		if ( !CollectionUtils.isEmpty(aliasList) &&
				!CollectionUtils.isEmpty(targetAliasList)){
			AbstractConfigurableContext targetContext;
			Context configContext;
			for(String contextName:targetAliasList){
				targetContext = (AbstractConfigurableContext) this.loadedContext.get(contextName);
				if ( targetContext == null ) continue;
				for ( String configName: aliasList ) {
					configContext = this.loadedContext.get(configName);
					if ( configContext == null ) continue;
					if ( add ) {
						targetContext.addConfig(configName, configContext, true);
					} else {
						targetContext.removeConfig(configName);
					}
				}
			}
		}
	}

	@Override
	public Object[] getDelegationsFromContext(String alias) {
		Object[] result = new String[0];
		if ( !StringUtils.isEmptyTrim(alias) && 
				this.loadedContext.containsKey(alias)) {
			AbstractConfigurableContext context = (AbstractConfigurableContext) this.loadedContext.get(alias);
			result = context.listConfig();
		}
		return result;
	}
	
	
	private ContextLoader contextLoader;
	private Map<String, Context> loadedContext;
}
