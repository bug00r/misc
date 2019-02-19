package de.bug0r.clientserver.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Request;
import de.bug0r.client.RequestListener;
import de.bug0r.clientserver.ClientRequest;

public class ClientRequestQueue implements RequestListener {

	public ClientRequestQueue(ConcurrentLinkedQueue<ClientRequest> clientRequest,
			long clientId ) {
		if ( clientRequest == null ) throw new IllegalArgumentException("no requestQueue given");
		this.clientRequest = clientRequest;
		this.clientId = clientId;
	}
	
	public void doRequest(Request nextRequest) {
		if ( nextRequest != null ) {
			ClientRequest newClientRequest = new ClientRequestImpl(nextRequest, this.clientId);
			clientRequest.add(newClientRequest);
		}
	}

	private ConcurrentLinkedQueue<ClientRequest> clientRequest;
	private long clientId;
}
