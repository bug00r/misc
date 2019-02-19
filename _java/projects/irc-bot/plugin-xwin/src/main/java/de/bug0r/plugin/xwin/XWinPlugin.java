package de.bug0r.plugin.xwin;

import java.util.ArrayList;
import java.util.List;

import de.bug0r.bot.context.impl.AbstractConfigurableContext;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.bot.context.response.impl.ObjectResponse;
import de.bug0r.bot.context.response.impl.StringResponse;
import de.bug0r.context.irc.context.utils.IrcContextUtils;
import de.bug0r.context.irc.manager.IrcConfigContext;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.message.irc.IrcMessage;
import de.bug0r.message.irc.impl.PrivmsgMessage;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.connection.config.impl.DefaultIrcConnectionConfiguration;

public class XWinPlugin extends AbstractConfigurableContext {
	
	public XWinPlugin() {
		this.xwinCtx = new XWinContext();
	}

	@Override
	public ContextResponse doPerform(ContextRequest request) {
		ContextResponse response = null;
		try {
			IIrcMessage ircRequest = (IIrcMessage)request.getParameter("");
			if ( ircRequest.getMessageId().equals(IrcMessage.PRIVMSG) ) {
				PrivmsgMessage privMsg = (PrivmsgMessage)ircRequest;
				if ( privMsg.get_message().startsWith(XWinContext.X_WIN_CMD) ) {
					String responseMessage;
					try {
						String nick = IrcMessageUtils.getNickNameFromCompleteSource(privMsg.get_source());
						responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(privMsg.get_message(), nick));
					} catch (Exception e) {
						responseMessage = e.getMessage();
					}
					if ( responseMessage.startsWith("Spielstand:") ) {
						List<IIrcMessage> messageList = new ArrayList<IIrcMessage>();
						for ( String statLine: responseMessage.split("#") ) {
							messageList.add(new PrivmsgMessage("", privMsg.get_target(), statLine));
						}
						response = new ObjectResponse(messageList);
					} else if (!StringUtils.isEmptyTrim(responseMessage)) {
						response = new ObjectResponse(new PrivmsgMessage("", privMsg.get_target(), responseMessage));
					}
				}
			}
		} catch(Exception e) {
			response = new StringResponse("fehler im xwin :( =>" + e.getMessage());
		}
		return response;
	}

	private XWinContext xwinCtx;
	
}
