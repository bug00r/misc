package de.bug0r.client;

public interface Client {

	public void send(ClientResponse clientResponse);
	public void connect();
	public void disconnet();
	
}
