/**
 * 
 */
package de.bug0r.protocol.irc.connection.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.protocol.irc.connection.IIrcConnetion;
import de.bug0r.protocol.irc.connection.config.IIrc;
import de.bug0r.protocol.irc.connection.config.exception.InvalidSocketConfiguration;
import de.bug0r.protocol.irc.connection.listener.IIrcConnectionListener;
import de.bug0r.protocol.irc.connection.listener.event.IEvent;
import de.bug0r.protocol.irc.connection.thread.IrcDelegateThread;
import de.bug0r.protocol.irc.connection.thread.IrcInputThread;
import de.bug0r.protocol.irc.connection.thread.IrcOutputThread;

/**
 * 
 * this is an irc socket :P.
 * 
 * @author bug0r
 * @version 0.1 
 *
 */
public class IrcConnection 
extends Socket 
implements IIrcConnetion
{
	
	public IrcConnection(IIrc socketConfig) {
		if ( null == socketConfig )
			throw new NullPointerException();
		this.run = false;
		this.socketConfig = socketConfig;
		
		this._inQueue = new Vector<String>();
		this._outQueue = new Vector<String>();
		this._messageListener = new Vector<IIrcConnectionListener>();
	}


	private void connect() throws IOException {
		
		if ( !socketConfig.isValidConfiguration() )
			throw new InvalidSocketConfiguration();
		
		if ( socketConfig.useTimeout() ) 
			connect(new InetSocketAddress(
					socketConfig.getServerAddress(),
					socketConfig.getPort().intValue()),
					socketConfig.getTimeout().intValue());
		else 
			connect(new InetSocketAddress(socketConfig.getServerAddress(), socketConfig.getPort().intValue()));
		
		this.run = true;
	
	}

	private void disconnect() {
		this.run = false;
		_inQueue.clear();
		_outQueue.clear();
	}
	
	@Override
	public void start() {
		try {
			
			connect();
			
			new IrcInputThread(this).start();
			new IrcDelegateThread(this).start();
			new IrcOutputThread(this).start();
			
		} catch (IOException e) {
			disconnect();
			e.printStackTrace();
		}
		
	}

	@Override
	public void stop() {
		disconnect();
	}
	
	public boolean isRunning() {
		return run;
	}
	
	public void addInput(String input) {
		_inQueue.add(input);
	}
	
	public String getNextInput() {
		if ( _inQueue.isEmpty() ) return new String();
		return _inQueue.remove(0);
	}
	
	public boolean hasInput() {
		return null!=_inQueue && !_inQueue.isEmpty();
	}
	
	public boolean hasOutput() {
		return null!=_outQueue && !_outQueue.isEmpty();
	}
	
	public String getNextOutput() {
		if ( _outQueue.isEmpty() ) return new String();
		return _outQueue.remove(0);
	}
	
	@Override
	public void addMessageListener(IIrcConnectionListener listener) {
		if ( null == listener ) return;
		if ( _messageListener.contains(listener) ) return;
		
		_messageListener.add(listener);
	}


	@Override
	public void removeMessageListener(IIrcConnectionListener listener) {
		if ( null == listener ) return;
		if ( !_messageListener.contains(listener) ) return;
		
		_messageListener.remove(listener);
	}
	
	@Override
	public void performMessageEvent(IEvent event) {
		if ( null != _messageListener &&
				!_messageListener.isEmpty())
			for ( IIrcConnectionListener listener: _messageListener ) {
				listener.process(event);
			}
	}
	
	@Override
	public void performOutputEvent(IEvent event) {
		if ( null != event )
			_outQueue.add((String) event.getEventData());
	}
	
	/** listener from out comes from server. Server output is socket input :) */
	private IIrc socketConfig;
	/** outgoing messages to server */
	private volatile Vector<String> _outQueue;
	/** incoming messages from server */
	private volatile Vector<String> _inQueue;
	/** is running flag */
	private boolean run;

	private Vector<IIrcConnectionListener> _messageListener;

}
