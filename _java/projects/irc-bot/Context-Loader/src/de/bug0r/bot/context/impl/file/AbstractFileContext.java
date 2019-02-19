package de.bug0r.bot.context.impl.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;

public abstract class AbstractFileContext implements Context {
	
	@Override
	public ContextResponse perform(ContextRequest request) {
		ContextResponse response = null;
		String action = (String) request.getParameter(ACTION);
		if ( LOAD.equalsIgnoreCase(action) ) {
			String fileURI = (String) request.getParameter(SOURCE);
			try {
				createFileFromUri(fileURI);
			} catch (URISyntaxException e) {
				response = new StringResponse("file load error: " + e.getMessage());
			}
		}
		
		if ( null == response )
			response = doPerform(request);
		
		return response;
	}

	private void createFileFromUri(String fileURI) throws URISyntaxException {
		URI uri = new URI(fileURI);
		this.file = new File(uri);
	}
	
	protected abstract ContextResponse doPerform(ContextRequest request);
	
	protected File file;
}
