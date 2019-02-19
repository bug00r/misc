package de.bug0r.bot.context;

import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;

public interface Context {

	public static final String ACTION = "action";
	public static final String TARGET = "target";
	public static final String SOURCE = "source";
	public static final String LOAD = "load";
	public static final String RELOAD = "reload";
	public static final String UNLOAD = "unload";
	public ContextResponse perform(ContextRequest request);
	
}
