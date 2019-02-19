package de.bug0r.clientserver.impl;

import de.bug0r.client.Response;
import de.bug0r.clientserver.ClientResponse;

public class ClientResponseImpl implements ClientResponse {

	public ClientResponseImpl(Response response, long clientId) {
		if ( response == null ) throw new IllegalArgumentException("no content given");
		this.response = response;
		this.clientId = clientId;
	}
	
	public String getContent() {
		return this.response.getContent();
	}

	public long getClientId() {
		return this.clientId;
	}

	private Response response;
	private long clientId;
	
}
