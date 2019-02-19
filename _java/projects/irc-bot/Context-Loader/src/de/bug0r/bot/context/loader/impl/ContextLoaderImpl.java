package de.bug0r.bot.context.loader.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.loader.ContextLoader;
import de.bug0r.bot.context.loader.ContextLoaderItemFactory;
import de.bug0r.bot.context.loader.item.LoaderItem;
import de.bug0r.core.utils.String.StringUtils;

public class ContextLoaderImpl implements ContextLoader {

	public ContextLoaderImpl() {
		this.loadedContext = new HashMap<String, Context>();
		this.loaderItemFactory = new ContextLoaderItemFactoryImpl(this.loadedContext);
	}
	
	@Override
	public Context loadContext(String source, String sourceType) {
		if ( StringUtils.isEmptyTrim(source) || 
				StringUtils.isEmptyTrim(sourceType) ) return null;
		LoaderItem loader = loaderItemFactory.getLoader(sourceType);
		return loader.load(source);
	}

	@Override
	public Context loadContext(String source, String sourceType, String parent) {
		if ( StringUtils.isEmptyTrim(source) || 
				StringUtils.isEmptyTrim(sourceType) ||
				StringUtils.isEmptyTrim(parent)) return null;
		LoaderItem loader = loaderItemFactory.getLoader(sourceType);
		return loader.load(source, parent);
	}
	
	public Map<String, Context> getLoadedContext() {
		return loadedContext;
	}
	
	private ContextLoaderItemFactory loaderItemFactory;
	private Map<String,Context> loadedContext;
	
}
