package de.bug0r.client.impl;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.ClientResponse;

public class ClientResponseRunnable implements Runnable {

	public ClientResponseRunnable(Socket socket,
			ConcurrentLinkedQueue<ClientResponse> responseQueue) {
		if ( socket == null ) throw new IllegalArgumentException("no socket given");
		if ( responseQueue == null ) throw new IllegalArgumentException("no responseQueue given");
		this.socket = socket;
		this.responseQueue = responseQueue;
	}
	
	public void finsh() {
		this.isRunning = false;
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		SocketChannel channel = socket.getChannel(); // NO CHANNEL GIVEN :( in BOT-SERVER
		ByteBuffer bBuffer = null;
		while( isRunning && socket.isConnected() ) {
			String nextResponse = getNextData();
			if ( nextResponse.length() > 0 ) {
				bBuffer = ByteBuffer.wrap(nextResponse.getBytes());
				try {
					if ( bBuffer != null ) channel.write(bBuffer);
				} catch (IOException e) {
					System.err.println("write response: " + e.getMessage());
				}
			}
		}
	}

	private String getNextData() {
		if ( responseQueue.size() == 0 ) return "";
		ClientResponse response = responseQueue.remove();
		return response.getData();
	}
	
	private Socket socket;
	private boolean isRunning;
	private ConcurrentLinkedQueue<ClientResponse> responseQueue;
}
