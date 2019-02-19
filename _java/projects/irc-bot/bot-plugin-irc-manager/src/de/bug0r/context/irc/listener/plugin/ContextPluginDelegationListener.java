package de.bug0r.context.irc.listener.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.ObjectRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.facade.IrcContextFacade;
import de.bug0r.listener.AbstractListenerPool;
import de.bug0r.listener.IListener;
import de.bug0r.message.irc.IIrcMessage;

public class ContextPluginDelegationListener
extends AbstractListenerPool<List<ContextResponse>>
implements IListener<IIrcMessage> {

	public ContextPluginDelegationListener(IrcContextFacade ircContext, ConcurrentHashMap<String, Context> configMap) {
		if ( null == ircContext ) throw new IllegalArgumentException("no irc context given");
		this.ircContext = ircContext;
		this.configMap = configMap;
	}
	
	@Override
	public void perform(IIrcMessage listenerEvent) {
		System.out.println("plugindepend request: " + listenerEvent);
		List<ContextResponse> resultResponse = new ArrayList<ContextResponse>();
		for ( Context context : this.configMap.values()) {
			ContextRequest request = new ObjectRequest(listenerEvent);
			ContextResponse response = context.perform(request);
			if ( response != null ) resultResponse.add(response);
		}
		this.performEvent(resultResponse);
	}
	
	private IrcContextFacade ircContext;
	private ConcurrentHashMap<String, Context> configMap;
	
}
