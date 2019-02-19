/**
 * 
 */
package de.bug0r.protocol.irc.connection.thread;

import java.io.IOException;
import java.io.InputStream;

import de.bug0r.protocol.irc.connection.impl.IrcConnection;

/**
 * @author bug0r
 * @version 0.1
 */
public class IrcInputThread extends Thread{

	public IrcInputThread(IrcConnection connection) {
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		try {
			InputStream inStream = connection.getInputStream();
			
			while( connection.isRunning() && 
					connection.isConnected() && !connection.isInputShutdown()) {
				
				Thread.sleep(5);
				

				if ( inStream.available() > 0) {		
					byte [] buffer = new byte[inStream.available()];
					inStream.read(buffer);
					connection.addInput(new String(buffer));
				} else {
						IrcInputThread.yield();
				}
				
			}
			
		} catch (IOException e) {
		} catch (InterruptedException e) {
		} finally {
			connection.stop();
		}
		
	}

	private IrcConnection connection;
	
}
