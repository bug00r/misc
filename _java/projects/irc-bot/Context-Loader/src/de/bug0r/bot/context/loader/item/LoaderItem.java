package de.bug0r.bot.context.loader.item;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.loader.exception.ContextLoadException;

public interface LoaderItem {

	public Context load(String source) throws ContextLoadException;
	public Context load(String source, String parent) throws ContextLoadException;
}
