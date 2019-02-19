package de.bugor.parser.argument;

import java.util.Map;

import org.testng.annotations.Test;

import junit.framework.Assert;

import de.bug0r.parser.argument.impl.ArgumentMapParser;

public class TestArgumentMapParser {

	@Test()
	public void testArgumentToMapParser() {
		String[] arguments = new String[] { "param1", "param2=value2", "param3", "param4=value4" };
		ArgumentMapParser parser = new ArgumentMapParser("=");
		Map<String,String> result = parser.parseArguments(arguments);
		Assert.assertFalse(result.isEmpty());
		Assert.assertTrue(result.containsKey("param1"));
		Assert.assertTrue(result.containsKey("param2"));
		Assert.assertTrue(result.containsKey("param3"));
		Assert.assertTrue(result.containsKey("param4"));
		Assert.assertTrue(!result.containsKey("param5"));
		Assert.assertEquals(4, result.size());
		Assert.assertEquals("", result.get("param1"));
		Assert.assertEquals("value2", result.get("param2"));
		Assert.assertEquals("", result.get("param3"));
		Assert.assertEquals("value4", result.get("param4"));
	}
	
}
