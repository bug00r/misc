package de.bug0r.terminal.controller.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.terminal.controller.event.Event;
import de.bug0r.terminal.controller.event.listener.EventListener;

public class EventDelegationRunnable implements Runnable {

	public EventDelegationRunnable(
			ConcurrentLinkedQueue<EventListener> eventListener,
			ConcurrentLinkedQueue<Event> eventQueue) {
		if ( eventListener == null ) throw new IllegalArgumentException("no event listener queue given");
		if ( eventQueue == null ) throw new IllegalArgumentException("no event event queue given");
		this.eventListener = eventListener;
		this.eventQueue = eventQueue;
	}
	@Override
	public void run() {
		while(true) {
			try { Thread.sleep(10);} catch (InterruptedException e) {}
			if ( eventQueue.isEmpty() ) {
				Thread.yield();
			} else {
				Event event = eventQueue.remove();
				for ( EventListener listener: eventListener ) {
					listener.perform(event);
				}
			}
		}
	}

	private ConcurrentLinkedQueue<EventListener> eventListener;
	private ConcurrentLinkedQueue<Event> eventQueue;
	
}
