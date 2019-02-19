package de.bug0r.client.impl;

import de.bug0r.client.ClientRequest;

public class StringRequest implements ClientRequest {

	public StringRequest(String request) {
		if ( request == null ) throw new IllegalArgumentException("no request given");
		this.request = request;
	}
	
	@Override
	public String getRequest() {
		return request;
	}

	private String request;
	
}
