package de.bug0r.parser;

public interface IParser<T> {

	public T strToMsg(String rawMsg);
	public String msgToStr(T message);
	
}
