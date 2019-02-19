package de.bug0r.bot.context.loader.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.loader.ContextLoaderItemFactory;
import de.bug0r.bot.context.loader.item.LoaderItem;
import de.bug0r.bot.context.loader.item.impl.ClassFileLoaderItem;
import de.bug0r.bot.context.loader.item.impl.JarFileLoaderItem;
import de.bug0r.bot.context.loader.item.impl.PropertyFileLoaderItem;
import de.bug0r.core.utils.String.StringUtils;

public class ContextLoaderItemFactoryImpl implements ContextLoaderItemFactory {

	public ContextLoaderItemFactoryImpl(Map<String, Context> loadedContext) {
		this.loaderMap = new HashMap<String, LoaderItem>();
		this.loaderMap.put("property", new PropertyFileLoaderItem());
		this.loaderMap.put("class", new ClassFileLoaderItem(loadedContext));
		this.loaderMap.put("jar", new JarFileLoaderItem(loadedContext));
	}
	
	@Override
	public LoaderItem getLoader(String key) {
		if ( StringUtils.isEmptyTrim(key) ) return null;
		return loaderMap.get(key);
	}

	private Map<String,LoaderItem> loaderMap;
	
}
