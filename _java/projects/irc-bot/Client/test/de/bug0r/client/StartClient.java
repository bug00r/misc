package de.bug0r.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

import de.bug0r.client.impl.SocketClient;
import de.bug0r.client.impl.StringResponse;

public class StartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long clientId = System.currentTimeMillis();
		SocketChannel socket;
		try {
			socket = SocketChannel.open(new InetSocketAddress("localhost", 4444));
			Client client = new SocketClient(socket, new RequestListener() {
				
				public void doRequest(Request nextRequest) {
					System.out.println("ANGEKOMMEN: " + nextRequest.getContent());
					
				}
			}, clientId);
			
			client.startProcessing();
			
			Response response = new StringResponse("bla bla bla test bla bla bla");
			client.send(response);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
