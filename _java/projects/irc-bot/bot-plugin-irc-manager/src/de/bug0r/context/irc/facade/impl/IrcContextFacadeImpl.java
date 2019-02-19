package de.bug0r.context.irc.facade.impl;

import de.bug0r.context.irc.IrcContext;
import de.bug0r.context.irc.facade.IrcContextFacade;

public class IrcContextFacadeImpl implements IrcContextFacade {

	public IrcContextFacadeImpl(IrcContext ircContext) {
		if ( null == ircContext ) throw new IllegalArgumentException("no irc context given");
		this.ircContext = ircContext;
	}

	@Override
	public String me() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNickIn(String channel) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private IrcContext ircContext;
}
