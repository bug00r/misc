package de.bug0r.terminal.controller.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.terminal.controller.Controller;
import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.listener.EventListener;

public class ControllerImpl implements Controller {

	public synchronized static ControllerImpl getInstance() {
		if ( instance == null ) instance = new ControllerImpl();
		return instance;
	}
	
	@Override
	public void addEventListener(EventListener eventListener) {
		if ( eventListener != null ) {
			this.eventListener.add(eventListener);
		}
	}
	
	@Override
	public void fire(Event event) {	
		if (event != null) {
			this.eventQueue.add(event);
		}
	}
	
	@Override
	public void removeEventListener(EventListener eventListener) {
		if ( eventListener != null ) {
			this.eventListener.remove(eventListener);
		}
	}
	
	private ControllerImpl() {
		this.eventListener = new ConcurrentLinkedQueue<EventListener>();
		this.eventQueue = new ConcurrentLinkedQueue<Event>();
		this.eventDelegationRunnable = new EventDelegationRunnable(eventListener, eventQueue);
		new Thread(eventDelegationRunnable).start();
	}
	
	private static ControllerImpl instance;
	private ConcurrentLinkedQueue<EventListener> eventListener;
	private ConcurrentLinkedQueue<Event> eventQueue;
	private EventDelegationRunnable eventDelegationRunnable;
	
}
