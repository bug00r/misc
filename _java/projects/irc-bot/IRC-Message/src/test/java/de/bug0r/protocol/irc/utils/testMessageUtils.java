package de.bug0r.protocol.irc.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.bug0r.message.irc.utils.IrcMessageUtils;

public class testMessageUtils {

	
	@Test()
	public void tes0rMessageUtils() {
		String testNick = "bug0r!~Bug0r@92.72.66.228";
		String erg = IrcMessageUtils.getNickNameFromCompleteSource(testNick);
		
		Assert.assertEquals("bug0r", erg);
		
	}
	
	@Test()
	public void tetTextResource() {
		String rawMessage = ":bug PRIVMSG #fraternized :Hollas wattn text!!:\r\n";
		
		String result = IrcMessageUtils.extractTextResourceFromMessage(rawMessage.trim());
		
		Assert.assertEquals(result, "Hollas wattn text!!:");
		
	}
	
}
