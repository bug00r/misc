package de.bug0r.client.impl;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.ClientRequest;

public class ClientRequestRunnable implements Runnable {

	public ClientRequestRunnable(Socket socket,
			ConcurrentLinkedQueue<ClientRequest> requestQueue) {
		if ( socket == null ) throw new IllegalArgumentException("no socket given");
		if ( requestQueue == null ) throw new IllegalArgumentException("no responseQueue given");
		this.socket = socket;
		this.requestQueue = requestQueue;
	}
	
	public void finsh() {
		this.isRunning = false;
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		SocketChannel channel = socket.getChannel();
		ByteBuffer bBuffer = null;
		int read=-1;
		while( isRunning && socket.isConnected() ) {
			bBuffer = ByteBuffer.allocate(1024);
			try {
				read = channel.read(bBuffer);
				if ( read > 0 ) {
					ClientRequest cliReq = new StringRequest(new String(bBuffer.array()));
					this.requestQueue.add(cliReq);
				}
			} catch (IOException e) {
				System.err.println("write response: " + e.getMessage());
			}
		}
	}
	
	private Socket socket;
	private boolean isRunning;
	private ConcurrentLinkedQueue<ClientRequest> requestQueue;
}

