/**
 * 
 */
package de.bug0r.protocol.irc.connection.thread;

import java.util.Date;
import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.utils.IrcMessageUtils;
import de.bug0r.protocol.irc.connection.impl.IrcConnection;
import de.bug0r.protocol.irc.connection.listener.event.impl.EIrcEvents;
import de.bug0r.protocol.irc.connection.listener.event.impl.IrcEvent;
import de.bug0r.protocol.irc.connection.message.impl.IrcRawMessage;

/**
 * @author jessica
 *
 */
public class IrcDelegateThread extends Thread {

	public IrcDelegateThread(IrcConnection connection) {
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		StringTokenizer tokenizer;
		String nextToken;
		String lastPiece = StringUtils.EMPTY_STRING;
		String nextPart;
		boolean completeBunch = false;
		try {
			while( connection.isRunning() && 
					connection.isConnected() && !connection.isInputShutdown()) {
				
					Thread.sleep(5);

				if ( connection.hasInput() ) {
					nextPart = connection.getNextInput();
					completeBunch = nextPart.endsWith(IrcMessageUtils.IRC_MESSAGE_DELIMITER);
					System.out.println("in irc:" + nextPart);
					System.out.println("completeBunch:" + completeBunch);
					tokenizer = new StringTokenizer(lastPiece + nextPart,
							IrcMessageUtils.IRC_MESSAGE_DELIMITER);
					while ( tokenizer.hasMoreTokens() ) {
						nextToken = tokenizer.nextToken();
						System.out.println("next Token: " + nextToken);
						if (StringUtils.isEmptyTrim(nextToken) ) continue;
						System.out.println("send message: " + nextToken);
						connection.performMessageEvent(
								new IrcEvent(new IrcRawMessage(nextToken),
								new Date(System.currentTimeMillis()),
								EIrcEvents.CONNECTION_EVENT));
						if ( !tokenizer.hasMoreTokens() ) {
							if ( !completeBunch ) {
								System.out.println("set last piece: " + nextToken);
								lastPiece = nextToken;
							} else{
								System.out.println("reset lastPiece");
								lastPiece = StringUtils.EMPTY_STRING;
							}
						}
					}
				} else {
					IrcDelegateThread.yield();
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private IrcConnection connection;
	
}
