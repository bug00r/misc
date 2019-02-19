package de.bug0r.client.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Request;
import de.bug0r.client.RequestListener;

public class NotifyListenerRunnable implements Runnable {

	public NotifyListenerRunnable(ConcurrentLinkedQueue<Request> requestQueue,
			RequestListener listener) {
		if ( requestQueue == null ) throw new IllegalArgumentException("no requestQueue given");
		if ( listener == null ) throw new IllegalArgumentException("no listener given");
		this.listener = listener;
		this.requestQueue = requestQueue;
	}

	public void finish() {
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		while(isRunning) {
			try { Thread.sleep(10);} catch (InterruptedException e) {}
			if ( requestQueue.size() > 0 ) {
				Request nextRequest = requestQueue.remove();
				listener.doRequest(nextRequest);
				System.out.println("notified clientlistener: " + nextRequest.getContent());
			} else {
				Thread.yield();
			}
		}
	}

	private volatile boolean isRunning;
	private RequestListener listener;
	private ConcurrentLinkedQueue<Request> requestQueue;
}
