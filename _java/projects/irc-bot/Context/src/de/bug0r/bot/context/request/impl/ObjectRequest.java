package de.bug0r.bot.context.request.impl;

import de.bug0r.bot.context.request.ContextRequest;

public class ObjectRequest implements ContextRequest {

	private Object data;
	
	public ObjectRequest(Object requestData) {
		if (requestData == null) throw new IllegalArgumentException("no request data given");
		this.data = requestData; 
	}
	
	@Override
	public Object getParameter(String parameterName) {
		return this.data;
	}

	
	
}
