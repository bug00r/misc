package de.bug0r.bot.context.loader;

import de.bug0r.bot.context.Context;

public interface ContextLoader {

	public Context loadContext(String source, String sourceType);
	public Context loadContext(String source, String sourceType, String parent);
}
