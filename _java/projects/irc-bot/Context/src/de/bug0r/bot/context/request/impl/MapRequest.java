package de.bug0r.bot.context.request.impl;

import java.util.Map;

import de.bug0r.bot.context.request.ContextRequest;

public class MapRequest implements ContextRequest {

	public MapRequest(Map<String,String> requestMap) {
		if ( null == requestMap ) throw new NullPointerException("no request map given");
		this.requestMap = requestMap;
	}
	
	@Override
	public Object getParameter(String parameterName) {
		if ( null == parameterName ) return null;
		return requestMap.get(parameterName);
	}

	@Override
	public String toString() {
		return requestMap.toString();
	}
	
	private Map<String,String> requestMap;
	
}
