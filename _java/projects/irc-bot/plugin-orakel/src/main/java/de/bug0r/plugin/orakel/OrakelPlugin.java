package de.bug0r.plugin.orakel;

import java.util.Random;

import de.bug0r.bot.context.Context;
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
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class OrakelPlugin extends AbstractConfigurableContext{

	@Override
	public ContextResponse doPerform(ContextRequest request) {
		ContextResponse response = null;
		try {
			DefaultIrcConnectionConfiguration config = 
					IrcContextUtils.getDefaultIrcConfiguration((IrcConfigContext) configMap.get("contextconfig"));
			IIrcMessage ircRequest = (IIrcMessage)request.getParameter("");
			if ( ircRequest.getMessageId().equals(IrcMessage.PRIVMSG) ) {
				PrivmsgMessage privMsg = (PrivmsgMessage)ircRequest;
				if ( privMsg.get_message().endsWith("?") &&
						privMsg.get_message().startsWith(config.getNickName()+":") ) {
					String messageInput = (new Random().nextBoolean()?": ja":": nein");
					String nick = IrcMessageUtils.getNickNameFromCompleteSource(privMsg.get_source());
					IIrcMessage message = new PrivmsgMessage("", privMsg.get_target(), nick + messageInput);
					response = new ObjectResponse(message);
					try {Thread.sleep(2500);} catch (InterruptedException e) {}
				}
			} 
		} catch(Exception e) {
			response = new StringResponse("fehler im orakel :( =>" + e.getMessage());
		}
		return response;
	}


}
