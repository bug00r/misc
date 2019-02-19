package de.bug0r.client;

public interface Client {

	public void startProcessing();
	public void stopProcessing();
	public void send(Response response);
	public long getClientId();
}
