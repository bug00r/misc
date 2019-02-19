package de.bug0r.client.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.client.Response;

public class OutputWriteRunnable implements Runnable {

	public OutputWriteRunnable(SocketChannel socket,
			ConcurrentLinkedQueue<Response> responseQueue) {
		if ( responseQueue == null ) throw new IllegalArgumentException("no responseQueue given");
		if ( socket == null ) throw new IllegalArgumentException("no listener given");
		this.socket = socket;
		this.responseQueue = responseQueue;
	}

	public void finish() {
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		try {
			ByteBuffer buffer = null;
			int writtenBytes;
			while(isRunning) {
				try { Thread.sleep(10);} catch (InterruptedException e) {}
				if ( this.responseQueue.size() > 0 ) {
					Response response = responseQueue.remove();
					buffer = ByteBuffer.wrap(response.getContent().getBytes());
					writtenBytes = this.socket.write(buffer);
					System.out.println("written request to server: " + response.getContent() + " bytes: " + writtenBytes);
				} else {
					Thread.yield();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private volatile boolean isRunning;
	private ConcurrentLinkedQueue<Response> responseQueue;
	private SocketChannel socket;
}
