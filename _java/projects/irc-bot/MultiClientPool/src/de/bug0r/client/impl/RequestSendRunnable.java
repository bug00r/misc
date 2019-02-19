package de.bug0r.client.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.ClientRequest;
import de.bug0r.client.ClientRequestListener;

public class RequestSendRunnable implements Runnable {

	public RequestSendRunnable(
			ConcurrentLinkedQueue<ClientRequest> requestQueue,
			ClientRequestListener listener) {
		if ( requestQueue == null ) throw new IllegalArgumentException("no requestQueue given");
		this.requestQueue = requestQueue;
		this.listener = listener;
	}
	
	public void finsh() {
		this.isRunning = false;
	}

	@Override
	public void run() {
		this.isRunning = true;
		while(this.isRunning) {
			if ( this.listener != null && requestQueue.size() > 0 ) {
				ClientRequest curRequest = requestQueue.remove();
				this.listener.doClientRequest(curRequest);
			} else {
				Thread.yield();
			}
		}
	}

	public void setListener(ClientRequestListener requestListener) {
		synchronized(this) {
			this.listener = requestListener;
		}
	}
	
	private boolean isRunning;
	private ConcurrentLinkedQueue<ClientRequest> requestQueue;
	private ClientRequestListener listener;
}
