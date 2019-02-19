package de.bug0r.context.irc.context.event;

public interface IrcContextEvent<T,T1> {
	public T getData();
	public T1 getType();
}
