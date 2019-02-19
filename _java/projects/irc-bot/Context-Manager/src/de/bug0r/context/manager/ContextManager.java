package de.bug0r.context.manager;

import java.util.List;

import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.response.ContextResponse;

public interface ContextManager {
	public void loadContext(String type, String alias, String contextSource, String parent);
	public void removeContext(List<String> aliasList);
	public void delegateContext(List<String> sourceAliasList, List<String> targetAlias);
	public void removeDelegation(List<String> fromAliasList, List<String> whatAliasList);
	public Object[] getDelegationsFromContext(String alias);
	public ContextResponse perform(String alias, ContextRequest request);
}
