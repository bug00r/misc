package de.bug0r.context.irc.context.utils;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MapRequest;
import de.bug0r.bot.context.request.impl.MultiRequest;
import de.bug0r.bot.context.response.impl.ObjectResponse;
import de.bug0r.context.irc.impl.IrcContextConfiguration;
import de.bug0r.context.irc.manager.IrcConfigContext;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class IrcContextUtils {

	public static IrcConfigContext createContextFromConfig(IrcContextConfiguration connectionConfiguration) {
		Map<String,String> requestMap = new HashMap<String, String>();
		requestMap.put("action", "set");
		requestMap.put("set", "ircconfig");
		ContextRequest request = new MultiRequest(requestMap, connectionConfiguration);
		IrcConfigContext configContext = new IrcConfigContext();
		configContext.perform(request);
		return configContext;
	}
	
	public static DefaultIrcConnectionConfiguration getDefaultIrcConfiguration(IrcConfigContext context) {
		IrcContextConfiguration result;
		Map<String,String> requestMap = new HashMap<String, String>();
		requestMap.put("action", "get");
		requestMap.put("get", "ircconfig");
		MapRequest request = new MapRequest(requestMap);
		ObjectResponse response = (ObjectResponse) context.perform(request);
		result = (IrcContextConfiguration) response.getContent();
		return result.getConnectionConfiguration();
	}

}
