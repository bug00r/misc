package de.bug0r.bot.context.loader.item.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.file.property.PropertyFileContext;
import de.bug0r.bot.context.loader.exception.ContextLoadException;
import de.bug0r.bot.context.loader.item.LoaderItem;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MapRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;

public class PropertyFileLoaderItem implements LoaderItem {

	@Override
	public Context load(String source) {
		Context propertyContext = new PropertyFileContext();
		Map<String,String> command = new HashMap<String, String>();
		command.put(Context.ACTION, Context.LOAD);
		command.put(Context.SOURCE, source);
		ContextRequest request = new MapRequest(command);
		ContextResponse response = (StringResponse) propertyContext.perform(request);
		if (((String)response.getContent()).contains("success")) {
			return propertyContext;
		} else {
			return null;
		}
		
	}

	@Override
	public Context load(String source, String parent)
			throws ContextLoadException {
		return load(source);
	}

}
