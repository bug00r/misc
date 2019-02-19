package de.bug0r.bot.context;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.bug0r.bot.context.impl.file.property.PropertyFileContext;
import de.bug0r.bot.context.request.impl.MapRequest;
import de.bug0r.bot.context.response.ContextResponse;

public class TestPropertyFileContext {
	@Test()
	public void testLoadFileSuccessful() {
		PropertyFileContext ctx = new PropertyFileContext();
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("action", "load");
		parameter.put("source", "file:/apps/bot2/testdata/test.properties");
		ContextResponse response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertTrue(((String)response.getContent()).startsWith("reading success"));
		
		parameter.clear();
		parameter.put("action", "get");
		parameter.put("param", "parameter2");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getContent(),"value2");
		
		parameter.clear();
		parameter.put("action", "unload");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getContent(),"unload success");
		
		parameter.clear();
		parameter.put("action", "set");
		parameter.put("param", "NeuParam1");
		parameter.put("value", "NeuValue1");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertTrue(((String)response.getContent()).startsWith("saved"));
		
		parameter.clear();
		parameter.put("action", "set");
		parameter.put("param", "NeuParam2");
		parameter.put("value", "NeuValue2");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertTrue(((String)response.getContent()).startsWith("saved"));
		
		parameter.clear();
		parameter.put("action", "delete");
		parameter.put("param", "NeuParam1");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertTrue(((String)response.getContent()).startsWith("removed"));
		
		parameter.clear();
		parameter.put("action", "reload");
		parameter.put("source", "file:/apps/bot2/testdata/test.properties");
		response = ctx.perform(new MapRequest(parameter));
		Assert.assertNotNull(response);
		Assert.assertTrue(((String)response.getContent()).startsWith("reading success"));
		
	}

}
