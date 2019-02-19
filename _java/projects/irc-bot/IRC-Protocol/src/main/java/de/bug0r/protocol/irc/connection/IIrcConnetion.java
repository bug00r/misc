package de.bug0r.protocol.irc.connection;
import de.bug0r.protocol.irc.connection.listener.IIrcConnectionListener;
import de.bug0r.protocol.irc.connection.listener.event.IEvent;

/**
 * 
 */

/**
 * @author jessica
 *
 */
public interface IIrcConnetion {

	/**
	 * set message listener for RAW messages
	 * @param listener output listener
	 */
	public void addMessageListener(IIrcConnectionListener listener);
	/**
	 * remove outputlistener
	 */
	public void removeMessageListener(IIrcConnectionListener listener);
	/**
	 * connect to server
	 */
	public void start();
	/**
	 * disconnect the server
	 */
	public void stop();
	public void performMessageEvent(IEvent event);
	
	/**
	 * writes out event to server
	 * @param event ecentobject
	 */
	public void performOutputEvent(IEvent event);
	
}
