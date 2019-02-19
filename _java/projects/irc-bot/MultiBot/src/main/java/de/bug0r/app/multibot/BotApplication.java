package de.bug0r.app.multibot;

import java.util.Map;

import de.bug0r.app.multibot.context.BotApplicationContext;
import de.bug0r.parser.argument.impl.ArgumentMapParser;

public class BotApplication {

	public BotApplication(String[] args) {
		options = new ArgumentMapParser("=").parseArguments(args);
	}
	
	public void start() {
		int clientPoolPort = Integer.parseInt(options.get("port"));
		this.appContext = new BotApplicationContext(clientPoolPort);
	}

	private BotApplicationContext appContext;
	private Map<String,String> options;
}
