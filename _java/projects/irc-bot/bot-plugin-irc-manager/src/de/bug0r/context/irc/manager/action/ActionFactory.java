package de.bug0r.context.irc.manager.action;

import de.bug0r.bot.context.Context;

public interface ActionFactory {
	public Context getAction(Object key);
}
