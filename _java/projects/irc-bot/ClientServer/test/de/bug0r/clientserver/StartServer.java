package de.bug0r.clientserver;

import de.bug0r.client.Response;
import de.bug0r.client.impl.StringResponse;
import de.bug0r.clientserver.impl.ClientResponseImpl;
import de.bug0r.clientserver.impl.ClientServerImpl;

public class StartServer {

	public static ClientServerImpl server;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		server = new ClientServerImpl(4444, new ClientServerListener() {
			public void doClientRequest(ClientRequest request) {
				System.out.println("in to server: " + request.getContent());
				Response response = new StringResponse("bla bla bla vom Server die Antwort");
				ClientResponse cliresponse = new ClientResponseImpl(response, request.getClientId());
				server.send(cliresponse);
			}
		});
		server.startProcessing();
	}

}
