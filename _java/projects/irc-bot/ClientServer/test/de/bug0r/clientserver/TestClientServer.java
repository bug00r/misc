package de.bug0r.clientserver;

import org.testng.annotations.Test;

import de.bug0r.clientserver.impl.ClientServerImpl;

public class TestClientServer {

	@Test()
	public void testServerClient() {
		final ClientServerImpl server = new ClientServerImpl(4444, new ClientServerListener() {
			public void doClientRequest(ClientRequest request) {
				System.out.println("in to server: " + request.getContent());
			}
		});
		server.startProcessing();
	}
	
}
