package de.bug0r.parser.argument.impl;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.parser.argument.ArgumentParser;

public class ArgumentMapParser implements ArgumentParser<Map<String,String>> {

	public ArgumentMapParser(String argumentdelimiter) {
		if ( StringUtils.isEmptyTrim(argumentdelimiter) ) throw new IllegalArgumentException("no argumentdelimiter given");
		this.argDelimiter = argumentdelimiter;
	}
	
	@Override
	public Map<String, String> parseArguments(String[] argv) {
		Map<String, String> parsedOptions = new HashMap<String, String>();
		if ( null != argv ) {
			for ( String option: argv ) {
				String[] parameter = option.split(argDelimiter);
				if ( parameter.length == 1 ) {
					parsedOptions.put(parameter[0], StringUtils.EMPTY_STRING);
				} else {
					parsedOptions.put(parameter[0], parameter[1]);
				}
				
			}
		}
		return parsedOptions;
	}

	private String argDelimiter;
	
}
