package de.bug0r.client.impl;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Client;
import de.bug0r.client.Request;
import de.bug0r.client.RequestListener;
import de.bug0r.client.Response;

public class SocketClient implements Client {

	public SocketClient(SocketChannel socket, RequestListener listener, long clientId) {
		if ( socket == null ) throw new IllegalArgumentException("no socket given");
		if ( listener == null ) throw new IllegalArgumentException("no listener given");
		this.socket = socket;
		this.listener = listener;
		this.clientId = clientId;
		this.requestQueue = new ConcurrentLinkedQueue<Request>();
		this.responseQueue = new ConcurrentLinkedQueue<Response>();
	}

	public long getClientId() {
		return clientId;
	}
	
	public void startProcessing() {
		clientInputRunnable = new InputReadRunnable(this.socket, this.requestQueue);
		clientOutputRunnable = new OutputWriteRunnable(this.socket, this.responseQueue);
		listenerNotifyRunnable = new NotifyListenerRunnable(this.requestQueue, this.listener);
		
		startThreadWith(clientInputRunnable, "InputWorker");
		startThreadWith(clientOutputRunnable , "OutpurWorker");
		startThreadWith(listenerNotifyRunnable, "Notifyer");
	}

	public void stopProcessing() {
		clientInputRunnable.finish();
		clientOutputRunnable.finish();
		listenerNotifyRunnable.finish();
	}
	
	public void send(Response response) {
		if ( response != null ) {
			this.responseQueue.add(response);
		}
	}
	
	private void startThreadWith(Runnable runnable, String name) {
		new Thread(runnable,name).start();
	}
	
	private SocketChannel socket;
	private RequestListener listener;
	private ConcurrentLinkedQueue<Request> requestQueue;
	private ConcurrentLinkedQueue<Response> responseQueue;
	private InputReadRunnable clientInputRunnable;
	private OutputWriteRunnable clientOutputRunnable;
	private NotifyListenerRunnable listenerNotifyRunnable;
	private long clientId;
	
}
