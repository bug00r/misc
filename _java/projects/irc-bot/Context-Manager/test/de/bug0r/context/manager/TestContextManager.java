package de.bug0r.context.manager;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.Test;

import de.bug0r.context.manager.impl.ContextManagerImpl;

public class TestContextManager {

	@Test()
	public void testContextManager() {
		
		ContextManager ctxMgr = new ContextManagerImpl();
		ctxMgr.loadContext("jar", "MyJar", "jar:file:/H:/apps/bot/plugins/bot/xwin.jar!/","");
		ctxMgr.loadContext("property", "MyProperty", "file:/apps/bot2/testdata/test.properties","");
		ctxMgr.loadContext("class", "MyClass", "file:/H:/apps/OrakelPluginItem.class","");

		List<String> sourceList = new ArrayList<String>();
		sourceList.add("MyProperty");
		sourceList.add("MyClass");
		List<String> targetList = new ArrayList<String>();
		targetList.add("MyJar");
		
		ctxMgr.delegateContext(sourceList, targetList);
		Object[] delegs = ctxMgr.getDelegationsFromContext("MyJar");
		Assert.assertEquals(2, delegs.length);
		sourceList.remove(0);
		ctxMgr.removeDelegation(sourceList, targetList);
		delegs = ctxMgr.getDelegationsFromContext("MyJar");
		Assert.assertEquals(1, delegs.length);
	}
	
	
	
	
}
