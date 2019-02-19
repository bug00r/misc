package de.bug0r.context.irc.manager;

import java.util.concurrent.ConcurrentHashMap;

import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.ObjectResponse;
import de.bug0r.bot.context.response.impl.StringResponse;

public class IrcConfigContext extends AbstractConfigurableContext {

	public IrcConfigContext() {
		this.config = new ConcurrentHashMap<String, Object>();
	}
	
	@Override
	protected ContextResponse doPerform(ContextRequest request) {
		String action = (String) request.getParameter("action");
		String param = (String) request.getParameter(action);
		Object data = request.getParameter("data");
		ContextResponse response = null;
		if ( "set".equals(action) ) {
			if( data != null ) {
				config.put(param, data);
				response = new StringResponse("config add");
			} else {
				response = new StringResponse("error: data is null");
			}
			
		} else if ("get".equals(action)) {
			Object configData=config.get(param);
			response = (configData != null ? new ObjectResponse(configData) :
											 new StringResponse("not found: " + param));
		}
		return response;
	}

	private ConcurrentHashMap<String, Object> config;
	
}
