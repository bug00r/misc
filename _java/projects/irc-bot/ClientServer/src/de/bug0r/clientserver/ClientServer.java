package de.bug0r.clientserver;

public interface ClientServer {
	public void send(ClientResponse response);
	public void startProcessing();
	public void stopProcessing();
}
