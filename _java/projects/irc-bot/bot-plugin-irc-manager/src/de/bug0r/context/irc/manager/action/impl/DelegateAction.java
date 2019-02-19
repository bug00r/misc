package de.bug0r.context.irc.manager.action.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.beust.jcommander.internal.Lists;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.context.event.impl.ClientToIrcServerEvent;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.protocol.irc.parser.impl.IrcParser;

public class DelegateAction extends AbstractAction implements Context{

	public DelegateAction(ConcurrentHashMap<String, Context> configMap,
			Map<String, IrcContext> ircContextMap) {
		super(configMap, ircContextMap);
	}

	@Override
	public ContextResponse perform(ContextRequest request) {
		String server = (String) request.getParameter("server");
		IrcContext context = this.ircContextMap.get(server);
		String result = "";
		if ( context != null ) {
			String delegation = (String) request.getParameter("delegate");
			if ( "message".equals(delegation) ) {
				String rawircmessage = (String) request.getParameter(delegation);
				result = delegateIrcMessage(context, rawircmessage);
			} else if ( "plugin".equals(delegation) ) {
				String pluginEvent = (String) request.getParameter(delegation);
				String pluginList = (String) request.getParameter("list");
				result = delegatePluginEvent(context, pluginEvent, pluginList);
			}
		} else {
			result = "raw message error: " + server + " not found";
		}
		
		return new StringResponse(result);
	}

	private String delegateIrcMessage(IrcContext context, String message) {
		IIrcMessage parsedMessage = new IrcParser().strToMsg(message);
		ClientToIrcServerEvent messageEvent = new ClientToIrcServerEvent(parsedMessage);
		context.fireIrcContextEvent(messageEvent);
		return "delegate message: " + message;
	}
	
	private String delegatePluginEvent(IrcContext context, String pluginEvent,
			String pluginList) {
		String result = "";
		if( "bind".equals(pluginEvent) ) {
			result = this.bindPluginsToContext(pluginList, context);
		} else if ("unbind".equals(pluginEvent) ) {
			result = this.unbindPluginsFromContext(pluginList, context);
		} else {
			result = "unknown plugin event";
		}
		
		return result;
	}
	
	private String unbindPluginsFromContext(String pluginList, IrcContext context) {
		String result = "Plugins successful unbind";
		List<String> plugins = Arrays.asList(pluginList.split(","));
		AbstractConfigurableContext configContext = (AbstractConfigurableContext) context;
		AbstractConfigurableContext foundcontext = null;
		for ( String plugin: plugins ) {
			foundcontext = (AbstractConfigurableContext) configMap.get(plugin);
			((AbstractConfigurableContext)foundcontext).removeConfig("contextconfig");
			configContext.removeConfig(plugin);
		}
		return result;
	}

	private String bindPluginsToContext(String pluginList, IrcContext context) {
		String result = "";
		List<String> plugins = Arrays.asList(pluginList.split(","));
		List<String> notFound = new ArrayList<String>();
		AbstractConfigurableContext configContext = (AbstractConfigurableContext) context;
		Context foundcontext = null;
		for ( String plugin: plugins ) {
			foundcontext = configMap.get(plugin);
			if ( foundcontext == null ) {
				notFound.add(plugin);
			}
			else { 
				//TODO check delegation from irc plugin to config
				((AbstractConfigurableContext)foundcontext).addConfig("contextconfig",context.getConfig(), true);
				configContext.addConfig(plugin, foundcontext, true);	
			}
		}
		
		if ( notFound.isEmpty() ) result = "plugins: " + pluginList + " successful bind";
		else result = "plugins not found to bind: " + notFound.size();
		
		return result;
	}
	
}
