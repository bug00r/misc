package de.bug0r.terminal.controller.event.listener.impl.gui.factory;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEventId;
import de.bug0r.terminal.controller.event.listener.impl.gui.worker.impl.ShowNewConnectionDialogWorker;
import de.bug0r.terminal.controller.event.listener.impl.gui.worker.impl.ShowTerminalFrameWorker;
import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.controller.event.listener.worker.impl.NullWorker;

public class GuiEventWorkerFactory {

	public GuiEventWorkerFactory() {
		this.guiWorkerMap = new HashMap<Object, Worker>();
		this.guiWorkerMap.put(GuiEventId.SHOW_MAIN_FRAME, new ShowTerminalFrameWorker());
		this.guiWorkerMap.put(GuiEventId.SHOW_NEW_CON_DLG, new ShowNewConnectionDialogWorker());
	}
	
	public Worker getWorker(Object key) {
		Worker foundWorker = new NullWorker();
		if ( key != null && guiWorkerMap.containsKey(key) ) {
			foundWorker = guiWorkerMap.get(key);
		}
		return foundWorker;
	}
	
	private Map<Object, Worker> guiWorkerMap;
}
