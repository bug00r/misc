package de.bug0r.terminal.controller.event.listener.impl.model.factory;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.terminal.controller.event.listener.impl.model.ModelEventId;
import de.bug0r.terminal.controller.event.listener.impl.model.worker.impl.ClientRequestWorker;
import de.bug0r.terminal.controller.event.listener.impl.model.worker.impl.CreateNewBotConnection;
import de.bug0r.terminal.controller.event.listener.impl.model.worker.impl.ServerRequestWorker;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.event.listener.worker.impl.NullWorker;
import de.bug0r.terminal.controller.model.context.ModelContext;

public class ModelEventWorkerFactory {

	public ModelEventWorkerFactory(ModelContext context) {
		if ( context == null ) throw new IllegalArgumentException("no model context given");
		this.context = context;
		this.guiWorkerMap = new HashMap<Object, Worker>();
		this.guiWorkerMap.put(ModelEventId.CREATE_NEW_BOT_CONNECTION, new CreateNewBotConnection(this.context));
		this.guiWorkerMap.put(ModelEventId.REQUEST_FROM_CLIENT, new ClientRequestWorker(context));
		this.guiWorkerMap.put(ModelEventId.REQUEST_TO_SERVER, new ServerRequestWorker(context));
	}
	
	public Worker getWorker(Object key) {
		Worker foundWorker = new NullWorker();
		if ( key != null && guiWorkerMap.containsKey(key) ) {
			foundWorker = guiWorkerMap.get(key);
		}
		return foundWorker;
	}
	
	private Map<Object, Worker> guiWorkerMap;
	private ModelContext context;
}
