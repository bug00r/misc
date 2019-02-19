package de.bug0r.context.irc.manager;

import org.testng.annotations.Test;

import de.bug0r.context.irc.manager.impl.IrcManagerImpl;

public class TestIrcContextManager {

	@Test()
	public void testIrcContextManager() {
		IrcManager manager = (IrcManager) new IrcManagerImpl();
		String newContextMessage = "context=irc\taction=new\tserver=irc.quakenet.org\tport=6667\thost=bug0rHost\tnick=bug0rBot\trealName=RealBug0rBot";
		manager.send(newContextMessage);
		
		String activateMessage = "context=irc\taction=activate\tserver=irc.quakenet.org";
		manager.send(activateMessage);
		
		String joinMessage = "context=irc\taction=rawmsg\tserver=irc.quakenet.org\tmsg=JOIN #fraternized";
		manager.send(joinMessage);
		
		String helloMessage = "context=irc\taction=rawmsg\tserver=irc.quakenet.org\tmsg=PRIVMSG #fraternized :test-msg:bug0rBot v1.56::build0023 beta";
		manager.send(helloMessage);
		
		String byeMessage = "context=irc\taction=rawmsg\tserver=irc.quakenet.org\tmsg=PRIVMSG #fraternized :test-quit";
		manager.send(byeMessage);
		
		String quitMessage = "context=irc\taction=rawmsg\tserver=irc.quakenet.org\tmsg=QUIT :bug0rBot forced quit";
		manager.send(quitMessage);
		
	}
	
	@Test()
	public void testContextPluginMechanism() {
		//Here should tests places wich test Plugin control for each context
		//should set multiple fictive contexts..no real plugin test. 
	}
	
}
