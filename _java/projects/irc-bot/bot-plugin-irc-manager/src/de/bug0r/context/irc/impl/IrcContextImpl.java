package de.bug0r.context.irc.impl;

import java.util.List;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.context.event.IrcContextEvent;
import de.bug0r.context.irc.context.event.delegation.factory.IrcContextEventDelegationFactory;
import de.bug0r.context.irc.context.event.delegation.factory.impl.IrcContextEventDelegationFactoryImpl;
import de.bug0r.context.irc.context.event.delegation.item.IrcContextDelegationItem;
import de.bug0r.context.irc.context.event.impl.ClientToIrcServerEvent;
import de.bug0r.context.irc.context.event.impl.IrcContextEventTypes;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.context.irc.facade.impl.IrcContextFacadeImpl;
import de.bug0r.context.irc.listener.plugin.ContextPluginDelegationListener;
import de.bug0r.listener.IListener;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.protocol.irc.connection.impl.IrcSteadyConnection;
import de.bug0r.protocol.irc.connection.listener.IrcRawMessageListener;
import de.bug0r.protocol.irc.parser.listener.IrcParsingRawMessageListener;

public class IrcContextImpl
extends AbstractConfigurableContext
implements IrcContext, IListener<List<ContextResponse>> {

	public IrcContextImpl(IrcContextConfiguration config) {
		if ( null == config) throw new IllegalArgumentException("no config given");
		this.config = config;
		this.ircConfig = IrcContextUtils.createContextFromConfig(config);
	} 
	
	@Override
	public void activate() {
		//connect to IRC Connection
		this.ircConnection = new IrcSteadyConnection(this.config.getConnectionConfiguration());
		this.eventDelegationFactory = new IrcContextEventDelegationFactoryImpl(this.ircConnection);
		this.rawListener = new IrcRawMessageListener();
		this.ircConnection.addMessageListener(this.rawListener);
		this.parsingListener = new IrcParsingRawMessageListener(this.config.getIrcParser());
		this.rawListener.appendListener(this.parsingListener);
		this.pluginDelegater = new ContextPluginDelegationListener(
							new IrcContextFacadeImpl(this),
							this.configMap);
		this.parsingListener.appendListener(pluginDelegater);
		this.pluginDelegater.appendListener(this);
		this.ircConnection.start();
	}

	@Override
	public void deactivate() {
		this.ircConnection.stop();
	}
	
	@Override
	public Context getConfig() {
		return this.ircConfig;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void perform(List<ContextResponse> listenerEvent) {
		//TODO hier könnte eine ConcurrentEvent Queue notwendig werden und ein WorkerThread
		Object content = null;
		for ( ContextResponse response: listenerEvent ) {
			content = response.getContent();
			if ( content instanceof IIrcMessage ) {
				ClientToIrcServerEvent messageEvent = new ClientToIrcServerEvent((IIrcMessage) content);
				this.fireIrcContextEvent(messageEvent);
			} else if ( content instanceof List<?> ) {
				for ( IIrcMessage message: (List<IIrcMessage>)content ) {
					ClientToIrcServerEvent messageEvent = new ClientToIrcServerEvent(message);
					this.fireIrcContextEvent(messageEvent);
				}
			}
		}
		
		//Hier haben wir das Problem, dass keine Verbindung zum Parent besteht. Hier wäre es denkbar
		//dafür zu sorgen das sind ein lauscher als Plugin registriert :) muss evaluiert werden.
	}
	
	@Override
	protected ContextResponse doPerform(ContextRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void fireIrcContextEvent(IrcContextEvent<?, ?> event) {
		IrcContextDelegationItem delegationItem = this.eventDelegationFactory.get((IrcContextEventTypes) event.getType());
		delegationItem.delegate(event);
	}
	
	private IrcContextConfiguration config;
	private IrcSteadyConnection ircConnection;
	private IrcRawMessageListener rawListener;
	private IrcParsingRawMessageListener parsingListener;
	private ContextPluginDelegationListener pluginDelegater;
	private IrcContextEventDelegationFactory eventDelegationFactory;
	private Context ircConfig;

}
