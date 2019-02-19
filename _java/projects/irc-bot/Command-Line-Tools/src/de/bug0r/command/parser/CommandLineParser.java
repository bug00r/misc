package de.bug0r.command.parser;

public interface CommandLineParser<T> {

	public T parse(String commandLine);
	
}
