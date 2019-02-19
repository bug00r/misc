package de.bug0r.protocol.irc.parser.listener;
import de.bug0r.listener.AbstractListenerPool;
import de.bug0r.listener.IListener;
import de.bug0r.message.irc.IIrcMessage;
import de.bug0r.protocol.irc.parser.IIrcParser;


public class IrcParsingRawMessageListener
extends AbstractListenerPool<IIrcMessage>
implements IListener<String> {

	public IrcParsingRawMessageListener(IIrcParser ircParser) {
		if ( null == ircParser ) throw new IllegalArgumentException("no irc parser given");
		this.ircParser = ircParser;
	}
	
	@Override
	public void perform(String listenerEvent) {
		IIrcMessage parsedMessage = this.ircParser.strToMsg(listenerEvent);
		System.out.println("parsed message: " + parsedMessage.toString());
		super.performEvent(parsedMessage);
	}

	private IIrcParser ircParser;
	
}
