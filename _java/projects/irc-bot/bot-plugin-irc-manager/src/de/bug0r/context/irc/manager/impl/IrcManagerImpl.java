package de.bug0r.context.irc.manager.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.manager.control.ControlFactory;
import de.bug0r.context.irc.manager.control.impl.ControlFactoryImpl;

public class IrcManagerImpl extends AbstractConfigurableContext {

	
	public IrcManagerImpl() {
		this.ircContextMap = new HashMap<String, IrcContext>();
		this.controlFactory = new ControlFactoryImpl(configMap, ircContextMap);
//		this.commandLineParser = new CommandLineToMapParser("\t","=");
//		this.pluginManager = new IrcPluginManagerImpl();
//		this.ircContextMap = new HashMap<String, IrcContext>();
//		this.delegationFactory = new IrcManagerMessageDelegationFactoryImpl(this.ircContextMap, this.pluginManager);
		
	}

//	public void send(String message) {
//		Map<String, String> cmdParamMap = commandLineParser.parse(message);
//		String delegationContext = cmdParamMap.get("context");
//		IrcManagerMessageDelegationItem delegationItem = this.delegationFactory.getDelegationItem(delegationContext);
//		delegationItem.delegate(cmdParamMap);
//	}
	
	@Override
	public ContextResponse doPerform(ContextRequest request) {
		Context curControl = this.controlFactory.getControl(request.getParameter("control"));
		ContextResponse response = curControl.perform(request);
		return response;
	}
	
	private ControlFactory controlFactory;
	private Map<String, IrcContext> ircContextMap;

}
