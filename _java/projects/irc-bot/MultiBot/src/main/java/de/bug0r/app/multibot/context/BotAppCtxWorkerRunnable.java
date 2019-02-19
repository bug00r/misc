package de.bug0r.app.multibot.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.bug0r.bot.context.loader.exception.ContextLoadException;
import de.bug0r.bot.context.request.ContextRequest;
import de.bug0r.bot.context.request.impl.MapRequest;
import de.bug0r.bot.context.response.ContextResponse;
import de.bug0r.client.Response;
import de.bug0r.client.impl.StringResponse;
import de.bug0r.clientserver.ClientRequest;
import de.bug0r.clientserver.ClientResponse;
import de.bug0r.clientserver.impl.ClientResponseImpl;
import de.bug0r.command.parser.impl.bot.CommandLineToMapParser;
import de.bug0r.context.manager.ContextManager;

public class BotAppCtxWorkerRunnable implements Runnable {

	public BotAppCtxWorkerRunnable(ConcurrentLinkedQueue<ClientRequest> clientRequestQueue,	
				BotApplicationContext botAppContext, ContextManager contextManager) {
		if ( null == clientRequestQueue ) throw new IllegalArgumentException("no request queue given");
		if ( null == botAppContext ) throw new IllegalArgumentException("no bot context given");
		if ( null == contextManager ) throw new IllegalArgumentException("no context manager given");
		this.clientRequestQueue = clientRequestQueue;
		this.botContext = botAppContext;
		this.contextManager = contextManager;
		this.parser = new CommandLineToMapParser("\t", "=");
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		ClientRequest request;
		ClientResponse cliResponse;
		Response response = null;
		ContextRequest ctxRequest;
		ContextResponse ctxResponse;
		Map<String,String> requestMap = null;
		while(this.isRunning){
			try { Thread.sleep(10);} catch (InterruptedException e) {}
			if ( clientRequestQueue.isEmpty() ) {
				Thread.yield();
			} else {
				request = clientRequestQueue.remove();
				requestMap = parser.parse(request.getContent());
				ctxRequest = new MapRequest(requestMap);
				if ( "plugin".equals(ctxRequest.getParameter("control")) ) {
					String action = (String) ctxRequest.getParameter("action");
					if ("load".equals(action)) response = new StringResponse(this.loadPlugin(ctxRequest));
					else if ( "bind".equals(action) ) response = new StringResponse(this.bindPlugin(ctxRequest));
					else if ( "unbind".equals(action) ) response = new StringResponse(this.unbindPlugin(ctxRequest));
					else if ( "remove".equals(action) ) response = new StringResponse(this.removePlugin(ctxRequest));
				} else if ("context".equals(ctxRequest.getParameter("control"))) {
					ctxResponse = this.contextManager.perform((String)ctxRequest.getParameter("alias"), ctxRequest);
					String responseStr;
					if (ctxResponse == null) responseStr = "no response object";
					else responseStr = (String) ctxResponse.getContent();
					response = new StringResponse(responseStr);
					
				} else {
					response = new StringResponse("unknown or mising control");
				}
				cliResponse = new ClientResponseImpl(response,request.getClientId());
				this.botContext.doClientResponse(cliResponse);
			}
		}
	}

	public void stopWorking() {
		this.isRunning = false;
	}
	
	private String loadPlugin(ContextRequest request) {
		String result = "";
		String type = (String) request.getParameter("type");
		String alias = (String) request.getParameter("alias");
		String parent = (String) request.getParameter("parent");
		String contextSource = (String) request.getParameter("source");
		try {
			this.contextManager.loadContext(type, alias, contextSource, parent);
			result = "load context successful: " + alias + " " + contextSource;
		} catch (ContextLoadException e) {
			result = e.getMessage();
		}
		return result;
	}
	
	private String unbindPlugin(ContextRequest ctxRequest) {
		String result = "";
		try {
			List<String> sourceAliasList = Arrays.asList(((String)ctxRequest.getParameter("sourceList")).split(","));
			List<String> targetAlias = Arrays.asList(((String)ctxRequest.getParameter("targetList")).split(","));
			this.contextManager.removeDelegation(sourceAliasList, targetAlias);
			result = "unbind successful";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	private String bindPlugin(ContextRequest ctxRequest) {
		String result = "";
		try {
			List<String> sourceAliasList = Arrays.asList(((String)ctxRequest.getParameter("sourceList")).split(","));
			List<String> targetAlias = Arrays.asList(((String)ctxRequest.getParameter("targetList")).split(","));
			this.contextManager.delegateContext(sourceAliasList, targetAlias);
			result = "bind successful";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
	private String removePlugin(ContextRequest ctxRequest) {
		String result = "";
		try {
			List<String> aliasList = Arrays.asList(((String)ctxRequest.getParameter("list")).split(","));
			this.contextManager.removeContext(aliasList);
			result = "remove successful";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
	private ConcurrentLinkedQueue<ClientRequest> clientRequestQueue;
	private BotApplicationContext botContext;
	private boolean isRunning;
	private ContextManager contextManager;
	private CommandLineToMapParser parser;
}
