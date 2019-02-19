package de.bug0r.context.irc.manager.control;

import de.bug0r.bot.context.Context;

public interface ControlFactory {
	public Context getControl(Object key);
}
