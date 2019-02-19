package de.bug0r.terminal.controller.model.context;

import de.bug0r.core.utils.String.StringUtils;

public class ConnectionData {
	
	public ConnectionData(String alias, int port) {
		if ( StringUtils.isEmptyTrim(alias) ) 
			throw new IllegalArgumentException("no alias name given");
		this.alias = alias;
		this.port = port;
	}
	
	public String getAlias() {
		return alias;
	}
	public int getPort() {
		return port;
	}

	String alias;
	int port;
}
