package de.bug0r.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bug0r
 *
 * @param <T> Event Type
 */
public abstract class AbstractListenerPool<T> implements IListenerPool<IListener<T>> {
	
	private List<IListener<T>> listenerList;
	
	public AbstractListenerPool() {
		this.listenerList = new ArrayList<IListener<T>>();
	}
	
	@Override
	public void appendListener(IListener<T> listener) {
		if ( listenerNotExistInPool(listener) ) {
			this.listenerList.add(listener);
		}
	}

	@Override
	public void removeListener(IListener<T> listener) {
		if ( listenerExistInPool(listener) ) {
			this.listenerList.remove(listener);
		}	
	}
	
	public void performEvent(T event) {
		for ( IListener<T> listener: this.listenerList ) {
			listener.perform(event);
		}
	}
	
	private boolean listenerExistInPool(IListener<T> listener) {
		return ( null != listener && this.listenerList.contains(listener));
	}

	private boolean listenerNotExistInPool(IListener<T> listener) {
		return !listenerExistInPool(listener);
	}
	
	
	
}
