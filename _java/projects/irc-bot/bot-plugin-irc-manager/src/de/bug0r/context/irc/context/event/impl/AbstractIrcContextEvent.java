package de.bug0r.context.irc.context.event.impl;

import de.bug0r.context.irc.context.event.IrcContextEvent;

public abstract class AbstractIrcContextEvent<T1,T2>
implements IrcContextEvent<T1, T2>{

	public AbstractIrcContextEvent(T1 data, T2 type) {
		if ( null == data ) throw new IllegalArgumentException("no data given");
		if ( null == type ) throw new IllegalArgumentException("no type given");
		this.data = data;
		this.type = type;
	}
	
	public T1 getData() {
		return data;
	}
	public T2 getType() {
		return type;
	}

	private T1 data;
	private T2 type;
}
