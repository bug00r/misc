package de.bug0r.command.parser.impl.bot;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.command.parser.CommandLineParser;
import de.bug0r.core.utils.String.StringUtils;

public class CommandLineToMapParser implements CommandLineParser<Map<String,String>> {

	public CommandLineToMapParser(String parameterDelimiter,
			String keyValueDelimiter) {
		if ( StringUtils.isEmtpy(keyValueDelimiter) ) throw new IllegalArgumentException("no key value delimiter given");
		if ( StringUtils.isEmtpy(parameterDelimiter) ) throw new IllegalArgumentException("no parameter delimiter given");
		this.parameterDelimiter = parameterDelimiter;
		this.keyValueDelimiter = keyValueDelimiter;
	}
	
	@Override
	public Map<String, String> parse(String commandLine) {
		Map<String,String> parsedMap = new HashMap<String, String>();
		if ( !StringUtils.isEmptyTrim(commandLine) ) {
			String[] splittedParameter = commandLine.split(this.parameterDelimiter);
			Map<String,String> extractedPairs = this.extractKeyValuePairs(splittedParameter);
			parsedMap.putAll(extractedPairs);
		}
		return parsedMap;
	}

	private Map<String, String> extractKeyValuePairs(String[] splittedParameter) {
		Map<String, String> extractedMap = new HashMap<String, String>();
		String [] splitParameter;
		for ( String parameter: splittedParameter ) {
			splitParameter = parameter.split(keyValueDelimiter);
			if ( splitParameter.length == 1 ) {
				extractedMap.put(splitParameter[0], StringUtils.EMPTY_STRING);
			} else {
				extractedMap.put(splitParameter[0], splitParameter[1]);
			}
		}
		return extractedMap;
	}

	private String parameterDelimiter;
	private String keyValueDelimiter;
}
