package de.bug0r.protocol.irc.parser;

import org.testng.annotations.Test;

import de.bug0r.message.irc.utils.IrcMessageUtils;

public class TestChannelRegex {

	@Test(groups="manual")
	public void testChannelRegexOk() {
		
		StringBuilder build = new StringBuilder();
		
		build.append("channel1,channel2,channel3,");
		
		build.deleteCharAt(build.lastIndexOf(IrcMessageUtils.MSG_PARAM_SEP));
		
		System.out.println(new String(build));
		
		
	}
	
}
