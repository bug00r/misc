/**
 * 
 */
package de.bug0r.protocol.irc.connection.thread;

import java.io.IOException;
import java.io.OutputStream;

import de.bug0r.protocol.irc.connection.impl.IrcConnection;

/**
 * @author bug0r
 * @version 0.1
 *
 */
public class IrcOutputThread extends Thread {

	public IrcOutputThread(IrcConnection connection) {
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
		
			OutputStream outStream = connection.getOutputStream();
			
			while( connection.isRunning() && 
					connection.isConnected() && !connection.isInputShutdown()) {
				
				Thread.sleep(5);
				
				if ( connection.hasOutput() ) {
						outStream.write(connection.getNextOutput().getBytes());
				} else {
					IrcOutputThread.yield();
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			connection.stop();
		}
			
		
		
	}

	private IrcConnection connection;
	
}
