package de.bug0r.plugin.orakel.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import junit.framework.Assert;

import org.testng.annotations.Test;

import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.ObjectRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.context.irc.impl.IrcContextConfiguration;
import de.bug0r.context.irc.manager.IrcConfigContext;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.message.irc.impl.UserMessage.EUserMode;
import de.bug0r.plugin.orakel.OrakelPlugin;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;


public class TestOrakelPlugin {

	@Test()
	public void testOrakelPlugin() throws UnknownHostException {
		AbstractConfigurableContext plugin = new OrakelPlugin();
		DefaultIrcConnectionConfiguration ircConConfig = 
				new DefaultIrcConnectionConfiguration(InetAddress.getByName("localhost"), 6667, "bug0rHost", "Bug0rBot", "realBug0r", "12345", EUserMode.MODE_1);
		IrcContextConfiguration config = new IrcContextConfiguration(ircConConfig);
		IrcConfigContext ircConfContext = IrcContextUtils.createContextFromConfig(config);
		plugin.addConfig("contextconfig", ircConfContext, true);
		PrivmsgMessage requestData = new PrivmsgMessage("bug0r!@bla.org", "#fraternized", "Bug0rBot: BLALBLAB?");
		ContextRequest request = new ObjectRequest(requestData); 
		ContextResponse response = plugin.perform(request);
		Assert.assertNotNull(response);
		
		requestData = new PrivmsgMessage("bug0r!@bla.org", "#fraternized", "Bug0rBotyyyyyyy: BLALBLAB?");
		request = new ObjectRequest(requestData); 
		response = plugin.perform(request);
		Assert.assertNull(response);
		
		requestData = new PrivmsgMessage("bug0r!@bla.org", "#fraternized", "Bug0rBot: BLALBLAB");
		request = new ObjectRequest(requestData); 
		response = plugin.perform(request);
		Assert.assertNull(response);
	}
	
}
