package de.bug0r.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Request;

public class InputReadRunnable implements Runnable {

	public InputReadRunnable(SocketChannel socket,
			ConcurrentLinkedQueue<Request> requestQueue) {
		if ( requestQueue == null ) throw new IllegalArgumentException("no requestQueue given");
		if ( socket == null ) throw new IllegalArgumentException("no listener given");
		this.socket = socket;
		this.requestQueue = requestQueue;
	}

	public void finish() {
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		try {
			//BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ByteBuffer buffer = null;
			int readBytes;
			while(isRunning) {
					try { Thread.sleep(10);} catch (InterruptedException e) {}
					buffer = ByteBuffer.allocate(1024);
					readBytes = socket.read(buffer);
					if ( readBytes > -1 ) {
							Request incomingRequest = new StringRequest(new String(buffer.array()).trim());
							System.out.println("from server: " + incomingRequest.getContent());
							this.requestQueue.add(incomingRequest);
					} else {
						Thread.yield();
					}
			} 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private volatile boolean isRunning;
	private ConcurrentLinkedQueue<Request> requestQueue;
	private SocketChannel socket;
}
