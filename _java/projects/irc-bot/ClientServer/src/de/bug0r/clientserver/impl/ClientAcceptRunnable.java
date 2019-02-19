package de.bug0r.clientserver.impl;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Client;
import de.bug0r.client.impl.SocketClient;
import de.bug0r.clientserver.ClientRequest;

public class ClientAcceptRunnable implements Runnable {

	public ClientAcceptRunnable(ServerSocketChannel server,
			ConcurrentHashMap<Long, Client> clientMap,
			ConcurrentLinkedQueue<ClientRequest> clientRequest) {
		if ( server == null ) throw new IllegalArgumentException("no server given");
		if ( clientMap == null ) throw new IllegalArgumentException("no client map given");
		if ( clientRequest == null ) throw new IllegalArgumentException("no clientRequest given");
		this.server = server;
		this.clientMap = clientMap;
		this.clientRequest = clientRequest;
	}

	public void finish() {
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		
		SocketChannel newSocket = null;
		while(isRunning) {
			    try {
			    	Thread.sleep(10);
			    	newSocket = this.server.accept();
			    } catch (IOException e) {
			    	Thread.yield();
			    } catch (InterruptedException e) {
			    	Thread.yield();
				}
				if ( newSocket != null ) {
					long newClientId = System.currentTimeMillis();
					Client newClient = new SocketClient(newSocket, new ClientRequestQueue(clientRequest,newClientId), newClientId);
					newClient.startProcessing();
					this.clientMap.put(newClientId, newClient);
					System.out.println("accepted new client: " + newSocket);
				} else {
					Thread.yield();
				}
		}
	}

	private volatile boolean isRunning;
	private ServerSocketChannel server;
	private ConcurrentHashMap<Long, Client> clientMap;
	private ConcurrentLinkedQueue<ClientRequest> clientRequest;
}
