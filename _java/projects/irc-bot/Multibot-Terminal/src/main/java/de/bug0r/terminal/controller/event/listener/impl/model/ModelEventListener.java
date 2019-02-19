package de.bug0r.terminal.controller.event.listener.impl.model;

import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.listener.EventListener;
import de.bug0r.terminal.controller.event.listener.impl.model.factory.ModelEventWorkerFactory;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.model.context.ModelContext;

public class ModelEventListener implements EventListener {

	public ModelEventListener() {
		this.context = new ModelContext();
		this.eventWorker = new ModelEventWorkerFactory(this.context);
	}
	
	@Override
	public void perform(Event event) {
		Worker worker = this.eventWorker.getWorker(event.getId());
		worker.doIt(event.getData());
	}

	private ModelContext context;
	private ModelEventWorkerFactory eventWorker;
}
