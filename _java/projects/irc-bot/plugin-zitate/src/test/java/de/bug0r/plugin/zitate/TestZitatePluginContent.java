package de.bug0r.plugin.zitate;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class TestZitatePluginContent {

	
	@Test
	public void testZitateContent() {
		URL zitateUrlObj;
		try {
			zitateUrlObj = new URL("http://zitate.net/zitate.html");
		
			InputStream zitateInput = zitateUrlObj.openConnection().getInputStream();
			byte[] zitateBuffer=new byte[zitateInput.available()];
			zitateInput.read(zitateBuffer);
			System.out.println("found: " + new String(zitateBuffer));
			Matcher zitateMatcher = Pattern.compile(("(ote\">)(.+)(<p)(.+)(Zitate\">)(.+)(</a>)")).matcher(new String(zitateBuffer));
			System.out.println("found matches: " + zitateMatcher.groupCount());
			zitateMatcher.find();
			
		} catch (Exception e) {
			
		}
	}
}
