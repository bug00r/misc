package de.bug0r.context.irc;

import de.bug0r.bot.context.Context;
import de.bug0r.context.irc.context.event.IrcContextEvent;


public interface IrcContext {
	public void activate();
	public void deactivate();
	public void fireIrcContextEvent(IrcContextEvent<?, ?> event);
	public Context getConfig();
}
