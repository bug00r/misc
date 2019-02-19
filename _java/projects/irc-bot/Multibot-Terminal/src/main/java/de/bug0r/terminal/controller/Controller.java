package de.bug0r.terminal.controller;

import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.listener.EventListener;

public interface Controller {

	public void addEventListener(EventListener eventListener);
	public void removeEventListener(EventListener eventListener);
	public void fire(Event event);
	
}
