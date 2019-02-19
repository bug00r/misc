package de.bug0r.bot.context;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.testng.annotations.Test;

import de.bug0r.bot.context.loader.item.impl.ClassFileLoaderItem;
import de.bug0r.bot.context.response.ContextResponse;

public class TestClassFileLoading {

	@Test()
	public void testClassFileLoadingAndExec() {
		Map<String, Context> loadedMap = new HashMap<String, Context>();
		ClassFileLoaderItem item = new ClassFileLoaderItem(loadedMap);
		Context context = item.load("file:/H:/apps/OrakelPluginItem.class");
		ContextResponse response = context.perform(null);
		Assert.assertNotNull(response);
		System.out.println(response.getContent());
	}
	
}
