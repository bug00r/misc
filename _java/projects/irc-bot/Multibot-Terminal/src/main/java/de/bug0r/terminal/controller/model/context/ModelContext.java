package de.bug0r.terminal.controller.model.context;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.client.Client;
import de.bug0r.core.utils.String.StringUtils;

public class ModelContext {
	
	public ModelContext() {
		this.clientMap = new HashMap<String, Client>();
	}

	public void addClient(String alias, Client client) {
		if (StringUtils.isEmptyTrim(alias)) throw new IllegalArgumentException("no alias given");
		if ( client == null ) throw new IllegalArgumentException("no client gien :/ hä?!");
		String usedAlias = alias;
		if ( clientMap.containsKey(usedAlias) )  usedAlias += "+";
		this.clientMap.put(usedAlias, client);
	}
	// TESTHACK
	public Client getFirstClient() {
		for ( String key: clientMap.keySet() ) {
			return clientMap.get(key);
		}
		return null;
	}

	private Map<String, Client> clientMap;

}
