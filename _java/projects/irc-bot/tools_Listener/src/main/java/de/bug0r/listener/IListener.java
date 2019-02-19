package de.bug0r.listener;

public interface IListener<T> {

	void perform(T listenerEvent);
	
}
