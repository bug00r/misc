package de.bug0r.clientserver.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.clientserver.ClientRequest;
import de.bug0r.clientserver.ClientServerListener;

public class ClientRequestRunnable implements Runnable {

	public ClientRequestRunnable(
			ConcurrentLinkedQueue<ClientRequest> clientRequest,
			ClientServerListener listener) {
		if ( clientRequest == null ) throw new IllegalArgumentException("no request queue given");
		if ( listener == null ) throw new IllegalArgumentException("no listener given");
		this.clientRequest = clientRequest;
		this.listener = listener;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ( clientRequest.size() > 0 ) {
				ClientRequest request = clientRequest.remove();
				listener.doClientRequest(request);
				System.out.println("request from client: " + request.getContent());
			} else {
				Thread.yield();
			}
		}
	}

	private volatile boolean isRunning;
	private ConcurrentLinkedQueue<ClientRequest> clientRequest;
	private ClientServerListener listener;
}
