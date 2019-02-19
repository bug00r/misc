package de.bug0r.bot.context.impl.file.property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import de.bug0r.bot.context.impl.file.AbstractFileContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.core.utils.String.StringUtils;

public class PropertyFileContext extends AbstractFileContext {

	public PropertyFileContext() {
		this.properties = new Properties();
	}
	
	@Override
	protected ContextResponse doPerform(ContextRequest request) {
		String action = (String) request.getParameter(ACTION);
		String response = null;
		if (LOAD.equalsIgnoreCase(action)) {
			response = readFile();
		} else if (RELOAD.equalsIgnoreCase(action)) {
			this.properties.clear();
			response = readFile();
		} else if (UNLOAD.equalsIgnoreCase(action)) {
			this.properties.clear();
			response = "unload success";
		} else if ("get".equalsIgnoreCase(action)) {
			response = getParameter(request);
		} else if ("delete".equalsIgnoreCase(action)) {
			response = deleteParameter(request);
		} else if ("set".equalsIgnoreCase(action)) {
			response = setParameter(request);
		}
		
		if ( response == null ) {
			response = "invalid action: " + action;
		}
		
		return new StringResponse(response);
	}

	private static final String PARAM = "param";
	
	private String readFile() {
		String response = "reading success: " + file.getName();
		FileReader reader;
		try {
			reader = new FileReader(file);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			response = e.getMessage();
		} catch (IOException e) {
			response = e.getMessage();
		}
		return response;
	}
	
	private String getParameter(ContextRequest request) {
		String parameter =(String)request.getParameter(PARAM);
		return this.properties.getProperty(parameter, "parameter not found: " + parameter);
	}
	
	private String setParameter(ContextRequest request) {
		String parameter =(String)request.getParameter(PARAM);
		String value =(String)request.getParameter("value");
		String response = null;
		if ( StringUtils.isEmptyTrim(parameter) ) response = "parameter is empty";
		if ( StringUtils.isEmptyTrim(value) ) response = "value is empty";
		if ( response == null ) {
			properties.put(parameter, value);
			response = "saved: " + parameter + "=" + value;
		}
		return response;
	}

	private String deleteParameter(ContextRequest request) {
		String parameter =(String)request.getParameter(PARAM);
		String response = null;
		if ( StringUtils.isEmptyTrim(parameter) ) response = "parameter is empty";
		else if ( properties.containsKey(parameter) ) {
			properties.remove(parameter);
			response = "removed: " + parameter;
		} else {
			response = "not exist: " + parameter;
		}
		return response;
	}
	
	private Properties properties;
	
}
