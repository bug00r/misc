package de.bug0r.plugin.zitate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.ObjectResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.context.irc.manager.IrcConfigContext;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class ZitatePluginItem extends AbstractConfigurableContext {

	private final String zitateUrl = "http://zitate.net/zitate.html";
	private final Pattern zizatePattern = Pattern.compile(("(ote\">)(.+)(<p)(.+)(Zitate\">)(.+)(</a>)"));

	@Override
	protected ContextResponse doPerform(ContextRequest request) {
		ContextResponse response = null;
		try {
			DefaultIrcConnectionConfiguration config = 
					IrcContextUtils.getDefaultIrcConfiguration((IrcConfigContext) configMap.get("contextconfig"));
			IIrcMessage ircRequest = (IIrcMessage)request.getParameter("");
			if ( ircRequest.getMessageId().equals(IrcMessage.PRIVMSG) ) {
				PrivmsgMessage privMsg = (PrivmsgMessage)ircRequest;
				if ( privMsg.get_message().startsWith("!zitat") ) {
					try {
						StringBuilder messageBuilder = new StringBuilder();
						URL zitateUrlObj = new URL(zitateUrl);
						InputStream zitateInput = zitateUrlObj.openConnection().getInputStream();
						byte[] zitateBuffer=new byte[zitateInput.available()];
						zitateInput.read(zitateBuffer);
						Matcher zitateMatcher = zizatePattern.matcher(new String(zitateBuffer));
						zitateMatcher.find();
							messageBuilder.append("12Zitat: ")
							.append(zitateMatcher.group(2))
							.append(" (")
							.append(zitateMatcher.group(6))
							.append(")");
							
							if ( null != messageBuilder ) {
								IIrcMessage message = new PrivmsgMessage(null,privMsg.get_target(),new String(messageBuilder));
								response = new ObjectResponse(message);
								try {Thread.sleep(2500);} catch (InterruptedException e) {}
							}
						
					} catch (IllegalStateException e) {
						System.err.println(e.getMessage());
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
				}
			} 
		} catch(Exception e) {
			response = new StringResponse("fehler im zitat :( =>" + e.getMessage());
		}
		return response;
	}
}
