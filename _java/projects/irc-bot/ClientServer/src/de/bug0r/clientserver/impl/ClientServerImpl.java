package de.bug0r.clientserver.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Client;
import de.bug0r.clientserver.ClientRequest;
import de.bug0r.clientserver.ClientResponse;
import de.bug0r.clientserver.ClientServer;
import de.bug0r.clientserver.ClientServerListener;

public class ClientServerImpl implements ClientServer {
	
	public ClientServerImpl(int listeningPort, ClientServerListener listener) {
		this.listeningPort = listeningPort;
		this.listener = listener;
		this.clientResponse = new ConcurrentLinkedQueue<ClientResponse>();
		this.clientRequest = new ConcurrentLinkedQueue<ClientRequest>();
		this.clientMap = new ConcurrentHashMap<Long, Client>();
	}
	
	public void send(ClientResponse response) {
		if ( response != null ) {
			this.clientResponse.add(response);
		}
	}

	public void startProcessing() {
		
		try {
			
			this.server = ServerSocketChannel.open();
			this.server.configureBlocking(false);//new ServerSocket(listeningPort);
			this.server.socket().bind(new InetSocketAddress(listeningPort));
		} catch (IOException e) {
			System.err.println("error create server: " + e.getMessage());
			return;
		}
		
		clientAcceptRunnable = new ClientAcceptRunnable(this.server, this.clientMap, this.clientRequest);
		clientRequestRunnable = new ClientRequestRunnable(this.clientRequest, this.listener);
		clientResponseRunnable = new ClientResponseRunnable(this.clientMap, this.clientResponse);
		
		startNewThreadWith(clientAcceptRunnable, "ClientAcceptor");
		startNewThreadWith(clientRequestRunnable, "RequestWorker");
		startNewThreadWith(clientResponseRunnable , "ResponseWorker");
	}

	public void stopProcessing() {
		if ( clientAcceptRunnable != null ) clientAcceptRunnable.finish();
		if ( clientRequestRunnable != null ) clientRequestRunnable.finish();
		if ( clientResponseRunnable != null ) clientResponseRunnable.finish();
	}
	
	private void startNewThreadWith(Runnable runnable, String name) {
		new Thread(runnable, name).start();
	}
	
	private int listeningPort;
	private ServerSocketChannel server;
	private final ClientServerListener listener;
	private ConcurrentLinkedQueue<ClientResponse> clientResponse;
	private ConcurrentLinkedQueue<ClientRequest> clientRequest;
	private ConcurrentHashMap<Long, Client> clientMap;
	private ClientAcceptRunnable clientAcceptRunnable;
	private ClientRequestRunnable clientRequestRunnable; //delegates client requests to clientserver lsitener
	private ClientResponseRunnable clientResponseRunnable; //delegeate Responses to Client
}
