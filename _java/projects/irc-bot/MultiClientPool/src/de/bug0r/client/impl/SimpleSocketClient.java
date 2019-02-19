package de.bug0r.client.impl;

import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Client;
import de.bug0r.client.ClientRequest;
import de.bug0r.client.ClientRequestListener;
import de.bug0r.client.ClientResponse;

public class SimpleSocketClient implements Client {

	public SimpleSocketClient(Socket socket, ClientRequestListener listener) {
		if ( socket == null ) throw new IllegalArgumentException("no socket given");
		if ( listener == null ) throw new IllegalArgumentException("no listener given");
		this.socket = socket;
		this.responseQueue = new ConcurrentLinkedQueue<ClientResponse>();
		this.requestQueue = new ConcurrentLinkedQueue<ClientRequest>();
		this.listener = listener;
	}
	
	@Override
	public void connect() {
		this.responseRunnable = new ClientResponseRunnable(socket, responseQueue);
		this.requestRunnable = new ClientRequestRunnable(socket, requestQueue);
		this.requestSendRunnable = new RequestSendRunnable(requestQueue, listener);
		new Thread(this.responseRunnable).start();
		new Thread(this.requestRunnable).start();
	}

	@Override
	public void disconnet() {
		this.responseQueue.clear();
		this.responseRunnable.finsh();
	}

	@Override
	public void send(ClientResponse clientResponse) {
		if ( clientResponse == null ) throw new IllegalArgumentException("no response given");
		this.responseQueue.add(clientResponse);
	}
	
	private Socket socket;
	private ClientRequestListener listener;
	private ConcurrentLinkedQueue<ClientResponse> responseQueue;
	private ConcurrentLinkedQueue<ClientRequest> requestQueue;
	private ClientResponseRunnable responseRunnable;
	private ClientRequestRunnable requestRunnable;
	private RequestSendRunnable requestSendRunnable;
}
