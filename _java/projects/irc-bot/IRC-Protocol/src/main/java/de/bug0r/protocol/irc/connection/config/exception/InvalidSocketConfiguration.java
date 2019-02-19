/**
 * 
 */
package de.bug0r.protocol.irc.connection.config.exception;

/**
 * @author bug0r
 *
 */
public class InvalidSocketConfiguration extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidSocketConfiguration() {
	}

	/**
	 * @param arg0
	 */
	public InvalidSocketConfiguration(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public InvalidSocketConfiguration(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public InvalidSocketConfiguration(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
