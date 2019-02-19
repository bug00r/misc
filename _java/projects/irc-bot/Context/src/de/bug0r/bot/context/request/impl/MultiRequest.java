package de.bug0r.bot.context.request.impl;

import java.util.Map;

import de.bug0r.bot.context.request.ContextRequest;

public class MultiRequest implements ContextRequest {

	public MultiRequest(Map<String,String> parameter, Object data) {
		if ( parameter == null ) throw new IllegalArgumentException("no parameter map given");
		if ( data == null ) throw new IllegalArgumentException("no data given");
		this.data = data;
		this.parameter = parameter;
	}
	
	@Override
	public Object getParameter(String parameterName) {
		if ( "data".equals(parameterName) ) return data;
		return this.parameter.get(parameterName);
	}

	private Object data;
	private Map<String, String> parameter;
	
}
