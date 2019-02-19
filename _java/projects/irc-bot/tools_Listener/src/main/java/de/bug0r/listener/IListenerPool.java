package de.bug0r.listener;

public interface IListenerPool<T> {

	void appendListener(T listener);
	void removeListener(T listener);
	
}
