package de.bug0r.plugin.auth;

import java.util.HashMap;
import java.util.Map;

import de.bug0r.bot.context.Context;
import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MapRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.ObjectResponse;
import de.bug0r.context.irc.impl.IrcContextConfiguration;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.impl.AbstractTargetMessage;
import de.bug0r.message.irc.impl.NickMessage;
import de.bug0r.message.irc.impl.NoticeMessage;
import de.bug0r.message.irc.impl.PassMessage;
import de.bug0r.message.irc.impl.UserMessage;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class AuthPlugin extends AbstractConfigurableContext{

	//TODO Es fehlen Nachrichten...irgendwie werden sie verschluckt oder kommen nicht bei den Plugins an?!
	@Override
	public ContextResponse doPerform(ContextRequest request) {
		ContextResponse response = null;
		IIrcMessage answer = null;
		IIrcMessage message = (IIrcMessage)request.getParameter("");
		if (IrcMessage.NOTICE.equals(message.getMessageId())) {	
			AbstractTargetMessage notice = (NoticeMessage) message;
			if ( "AUTH".equals(notice.get_target())){
				Context configObj = configMap.get("contextconfig");
				Map<String,String> requestMap = new HashMap<String, String>();
				requestMap.put("action", "get");
				requestMap.put("get", "ircconfig");
				ObjectResponse responseObj = (ObjectResponse) configObj.perform(new MapRequest(requestMap));
				IrcContextConfiguration configCtx = (IrcContextConfiguration) responseObj.getContent();
				DefaultIrcConnectionConfiguration config = configCtx.getConnectionConfiguration();
				if ( notice.get_message().contains("hostname") ) {
					if ( notice.get_message().contains("Found") ) {
						try { Thread.sleep(400); } catch (InterruptedException e) {}
						answer = new NickMessage(config.getNickName());
					} else if ( notice.get_message().contains("Looking") ) {
						try { Thread.sleep(200); } catch (InterruptedException e) {}
						answer = new PassMessage(config.getPassword());
					}
				} else if ( notice.get_message().contains("Ident") ) {
					try {
						Thread.sleep(800);} catch (InterruptedException e) {}
					answer = new UserMessage(config.getNickName(),
							config.getUsermode(),
							config.getRealName());
				}				
			}
		}
		if ( answer != null ) response = new ObjectResponse(answer);
		return response;
	}


}
