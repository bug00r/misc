package de.bug0r.core.factory;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFactory<K,V> {
	
	protected AbstractFactory() {
		factoryMap = new HashMap<K, V>();
		init();
	}
	
	protected void add(K key, V value) {
		if ( null != key || null != value ) {
			factoryMap.put(key, value);
		}
	}
	
	protected V getValue(K key) {
		V result = null;
		if ( null != key ) {
			result = factoryMap.get(key);
		}
		return result;
	}
	
	protected abstract void init();
	private Map<K,V> factoryMap;
}
