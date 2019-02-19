package de.bug0r.client.impl;

import de.bug0r.client.Response;

public class StringResponse implements Response {

	public StringResponse(String content) {
		if ( content == null ) throw new IllegalArgumentException("no response content given");
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	private String content;
}
