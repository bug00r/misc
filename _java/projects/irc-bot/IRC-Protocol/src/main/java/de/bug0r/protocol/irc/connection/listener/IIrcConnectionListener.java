/**
 * 
 */
package de.bug0r.protocol.irc.connection.listener;

import de.bug0r.protocol.irc.connection.listener.event.IEvent;

/**
 * @author bug0r
 * @version 0.1
 */
public interface IIrcConnectionListener {

	/**
	 * this function get all events which should processed.
	 * @param event event object
	 */
	public void process(IEvent event);
	
}
