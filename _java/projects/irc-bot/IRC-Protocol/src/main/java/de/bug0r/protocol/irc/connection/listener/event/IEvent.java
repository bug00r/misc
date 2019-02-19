/**
 * 
 */
package de.bug0r.protocol.irc.connection.listener.event;

import java.util.Date;

/**
 * @author bug0r
 * @version 0.1
 */
public interface IEvent {

	/**
	 * @return event destination
	 */
	public Object getDestination();
	/**
	 * 
	 * @return event source
	 */
	public Object getSource();
	/**
	 * 
	 * @return event data
	 */
	public Object getEventData();
	/**
	 * 
	 * @return current Event Date
	 */
	public Date getDate();
	/**
	 * 
	 * @return true if source exist otherwise false
	 */
	public boolean hasSource();
	/**
	 * 
	 * @return true if destiantion exist otherwise false
	 */
	public boolean hasDestination();
	/**
	 * 
	 * @return true if data exist otherwise false
	 */
	public boolean hasData();
	
	/**
	 * 
	 * @return event id
	 */
	public int getId();
}
