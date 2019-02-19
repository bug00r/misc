package de.bug0r.context.irc.context.event.delegation.item;

import de.bug0r.context.irc.context.event.IrcContextEvent;

public interface IrcContextDelegationItem {

	public void delegate(IrcContextEvent<?, ?> contextEvent);
	
}
