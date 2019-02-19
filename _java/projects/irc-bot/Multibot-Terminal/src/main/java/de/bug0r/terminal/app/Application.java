package de.bug0r.terminal.app;

import de.bug0r.terminal.controller.Controller;
import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEvent;
import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEventId;
import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEventListener;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEventListener;
import de.bug0r.terminal.controller.impl.ControllerImpl;

public class Application {

	public synchronized static Application getInstance() {
		if ( instance == null ) instance = new Application();
		return instance;
	}
	
	public void start() {
		this.controller.fire(new GuiEvent(GuiEventId.SHOW_MAIN_FRAME, null));
	}
	
	private Application() {
		this.controller = ControllerImpl.getInstance();
		this.controller.addEventListener(new GuiEventListener());
		this.controller.addEventListener(new ModelEventListener());
	}
	
	private static Application instance;
	private Controller controller;
}
