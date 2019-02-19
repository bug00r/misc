package de.bug0r.context.irc.context.event.delegation.item.impl;

import de.bug0r.context.irc.context.event.IrcContextEvent;
import de.bug0r.context.irc.context.event.delegation.item.IrcContextDelegationItem;

public class IrcNullDelegationItem implements IrcContextDelegationItem {

	@Override
	public void delegate(IrcContextEvent<?, ?> contextEvent) {
		System.out.println("null delegation for " + contextEvent);
	}

	
	
}
