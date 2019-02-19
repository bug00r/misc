package de.bug0r.client.impl;

import de.bug0r.client.Request;

public class StringRequest implements Request {

	public StringRequest(String content) {
		if ( content == null ) throw new IllegalArgumentException("no request content given");
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	private String content;
}
