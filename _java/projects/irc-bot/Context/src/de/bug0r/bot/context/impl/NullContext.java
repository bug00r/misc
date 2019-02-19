package de.bug0r.bot.context.impl;

import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;

public class NullContext extends AbstractConfigurableContext {

	@Override
	protected ContextResponse doPerform(ContextRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
