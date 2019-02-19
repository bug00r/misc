package de.bug0r.clientserver.impl;

import de.bug0r.client.Request;
import de.bug0r.clientserver.ClientRequest;

public class ClientRequestImpl implements ClientRequest {

	public ClientRequestImpl(Request request, long clientId) {
		if ( request == null ) throw new IllegalArgumentException("no content given");
		this.request = request;
		this.clientId = clientId;
	}
	
	public String getContent() {
		return this.request.getContent();
	}

	public long getClientId() {
		return this.clientId;
	}

	private Request request;
	private long clientId;
	
}
