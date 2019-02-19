package de.bug0r.context.irc.context.event.delegation.factory;

import de.bug0r.context.irc.context.event.delegation.item.IrcContextDelegationItem;
import de.bug0r.context.irc.context.event.impl.IrcContextEventTypes;

public interface IrcContextEventDelegationFactory {

	public IrcContextDelegationItem get(IrcContextEventTypes eventType);
	public boolean contains(IrcContextEventTypes eventType);
	
}
