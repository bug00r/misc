package de.bug0r.client.impl;

import de.bug0r.client.ClientResponse;

public class StringResponse implements ClientResponse {

	public StringResponse(String response) {
		if ( response == null ) throw new IllegalArgumentException("no response given");
		this.response = response;
	}
	
	@Override
	public String getData() {
		return this.response;
	}

	private String response;
}
