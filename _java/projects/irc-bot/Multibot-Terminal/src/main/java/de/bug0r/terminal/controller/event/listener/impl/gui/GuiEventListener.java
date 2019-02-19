package de.bug0r.terminal.controller.event.listener.impl.gui;

import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.listener.EventListener;
import de.bug0r.terminal.controller.event.listener.impl.gui.factory.GuiEventWorkerFactory;
import de.bug0r.terminal.controller.event.listener.worker.Worker;

public class GuiEventListener implements EventListener {

	public GuiEventListener() {
		this.guiWorker = new GuiEventWorkerFactory();
	}
	
	@Override
	public void perform(Event event) {
		Worker worker = this.guiWorker.getWorker(event.getId());
		worker.doIt(event.getData());
	}

	private GuiEventWorkerFactory guiWorker;
}
