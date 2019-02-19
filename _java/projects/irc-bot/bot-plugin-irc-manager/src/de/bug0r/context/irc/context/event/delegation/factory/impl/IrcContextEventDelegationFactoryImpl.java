package de.bug0r.context.irc.context.event.delegation.factory.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.context.irc.context.event.delegation.factory.IrcContextEventDelegationFactory;
import de.bug0r.context.irc.context.event.delegation.item.IrcContextDelegationItem;
import de.bug0r.context.irc.context.event.delegation.item.impl.IrcNullDelegationItem;
import de.bug0r.context.irc.context.event.delegation.item.impl.IrcToServerDelegationItem;
import de.bug0r.context.irc.context.event.impl.IrcContextEventTypes;
import de.bug0r.protocol.irc.connection.impl.IrcSteadyConnection;

public class IrcContextEventDelegationFactoryImpl implements
		IrcContextEventDelegationFactory {
	
	public IrcContextEventDelegationFactoryImpl(IrcSteadyConnection connection) {
		if ( null == connection ) throw new IllegalArgumentException("no connection given");
		this.connection = connection;
		this.delegationItem = new HashMap<IrcContextEventTypes, IrcContextDelegationItem>();
		this.delegationItem.put(IrcContextEventTypes.CLIENT_TO_IRC_SERVER, new IrcToServerDelegationItem(this.connection));
		//TODO Implement Other delegator  SERVER_TO_CONTEXT and so
	}
	
	@Override
	public IrcContextDelegationItem get(IrcContextEventTypes eventType) {
		IrcContextDelegationItem item = delegationItem.get(eventType);
		if (null==item) item = new IrcNullDelegationItem();
		return item;
	}

	@Override
	public boolean contains(IrcContextEventTypes eventType) {
		return this.delegationItem.containsKey(eventType);
	}
	
	private Map<IrcContextEventTypes, IrcContextDelegationItem> delegationItem;
	private IrcSteadyConnection connection;
}
