package de.bug0r.bot.context.loader;

import de.bug0r.bot.context.loader.item.LoaderItem;

public interface ContextLoaderItemFactory {

	public LoaderItem getLoader(String key);
	
}
