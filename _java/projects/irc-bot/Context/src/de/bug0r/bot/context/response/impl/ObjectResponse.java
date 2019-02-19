package de.bug0r.bot.context.response.impl;

import de.bug0r.bot.context.response.ContextResponse;

public class ObjectResponse implements ContextResponse {

	private Object data;
	
	public ObjectResponse(Object requestData) {
		if (requestData == null) throw new IllegalArgumentException("no request data given");
		this.data = requestData; 
	}

	@Override
	public Object getContent() {
		return this.data;
	}

	
	
}
