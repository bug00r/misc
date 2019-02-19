package de.bug0r.clientserver.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Client;
import de.bug0r.client.Response;
import de.bug0r.client.impl.StringResponse;
import de.bug0r.clientserver.ClientResponse;

public class ClientResponseRunnable implements Runnable {

	public ClientResponseRunnable(ConcurrentHashMap<Long, Client> clientMap,
			ConcurrentLinkedQueue<ClientResponse> clientResponse) {
		if ( clientMap == null ) throw new IllegalArgumentException("no client map given");
		if ( clientResponse == null ) throw new IllegalArgumentException("no client REsponse given");
		this.clientMap = clientMap;
		this.clientResponse = clientResponse;
	}

	public void finish() {
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		while(isRunning) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				Thread.yield();
			}
			if ( clientResponse.size() > 0 ) {
				ClientResponse response = clientResponse.remove();
				Client client = clientMap.get(response.getClientId());
				if ( client != null ) {
					Response cliResponse = new StringResponse(response.getContent());
					client.send(cliResponse);
					System.out.println("answer to client: " + cliResponse.getContent());
				}
			} else {
				Thread.yield();
			}
		}
	}
	
	private ConcurrentHashMap<Long, Client> clientMap;
	private ConcurrentLinkedQueue<ClientResponse> clientResponse;
	private volatile boolean isRunning;
}
