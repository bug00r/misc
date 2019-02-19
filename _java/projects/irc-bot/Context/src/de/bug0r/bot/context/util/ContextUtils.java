package de.bug0r.bot.context.util;

import java.util.Map;

import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MapRequest;

public class ContextUtils {

	public static ContextRequest createMapRequest(Map<String,String> requestMap) {
		ContextRequest result = null;
		if ( requestMap != null ) {
			result = new MapRequest(requestMap);
		}
		return result;
	}
	
}
