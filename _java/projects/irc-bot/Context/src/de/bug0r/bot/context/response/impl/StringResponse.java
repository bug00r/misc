package de.bug0r.bot.context.response.impl;

import de.bug0r.bot.context.response.ContextResponse;

public class StringResponse implements ContextResponse {

	public StringResponse(String response) {
		if ( response == null ) throw new NullPointerException("no response string given");
		this.response = response;
	}
	
	@Override
	public Object getContent() {
		return response;
	}

	private String response;
}
