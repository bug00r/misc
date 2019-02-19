package de.bug0r.parser.argument;

public interface ArgumentParser<OPTIONS> {

	public OPTIONS parseArguments(String[] argv);
	
}
