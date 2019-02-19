package de.bug0r.app.multibot.context;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.clientserver.ClientRequest;
import de.bug0r.clientserver.ClientResponse;
import de.bug0r.clientserver.ClientServer;
import de.bug0r.clientserver.ClientServerListener;
import de.bug0r.clientserver.impl.ClientServerImpl;
import de.bug0r.context.manager.ContextManager;
import de.bug0r.context.manager.impl.ContextManagerImpl;

public class BotApplicationContext 
implements ClientServerListener {

	public BotApplicationContext(int port) {
		clientRequestQueue = new ConcurrentLinkedQueue<ClientRequest>();
		// Hier muss globaler Pluginmanager an Runnable übergeben werden um requests daran weiterzuleiten
		this.contextManager = new ContextManagerImpl();
		this.workerRunnable = new BotAppCtxWorkerRunnable(clientRequestQueue, this, this.contextManager);
		new Thread(this.workerRunnable).start();
		this.clientServer = new ClientServerImpl(port, this);
		this.clientServer.startProcessing();
	}
	
	@Override
	public void doClientRequest(ClientRequest request) {
		if ( request != null ) {
			clientRequestQueue.add(request);
		}
	}

	public void doClientResponse(ClientResponse response) {
		if ( response != null ) {
			this.clientServer.send(response);
		}
	}
	
	private BotAppCtxWorkerRunnable workerRunnable;
	private ConcurrentLinkedQueue<ClientRequest> clientRequestQueue;
	private ClientServer clientServer;
	//Hier muss globaler PluginManager ran
	private ContextManager contextManager;
}
