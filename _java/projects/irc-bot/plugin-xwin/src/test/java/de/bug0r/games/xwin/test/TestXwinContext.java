package de.bug0r.games.xwin.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import de.bug0r.plugin.xwin.XWinCommandInterpreter;
import de.bug0r.plugin.xwin.XWinContext;

public class TestXwinContext {

	@Test()
	public void testXWinGameStartSuccessful() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, player]", responseMessage);
	}
	
	@Test()
	public void testXWinGameStartDoubleFail() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, player]", responseMessage);
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("bug: hat bereits ein Spiel angelegt.", responseMessage);
	}
	
	@Test(expectedExceptions={IllegalArgumentException.class})
	public void testXWinGameStartStopError() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	}
	
	@Test(expectedExceptions={IllegalArgumentException.class})
	public void testXWinGameStartStopSuccess() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, player]", responseMessage);
		
		cmd = "!x stop";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Spiel von bug wurde beendet", responseMessage);
	}
	
	@Test()
	public void testXWinGamePlaysSuccessfulBug() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, player]", responseMessage);
		
		cmd = "!x bug 1";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 1";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 2";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 2";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 3";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 3";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 4";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("The Winner of bug's Game is => bug",responseMessage);
		
	}
	
	@Test()
	public void testXWinGamePlaysSuccessfulBug0rBot() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, player]", responseMessage);
		
		cmd = "!x bug 5";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 1";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 5";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 2";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 5";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x bug 3";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		cmd = "!x bug 3";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: player",responseMessage);
		
		cmd = "!x stat";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		
		cmd = "!x bug 4";
		nick = "player!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("The Winner of bug's Game is => player",responseMessage);
		
	}
	
	@Test()
	public void testXWinGamePlaysSuccessfulMulti() {
		XWinContext xwinCtx = new XWinContext();
		String cmd = "!x start 10 10 5 Carpe,Phil,Haxx";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		String responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Das Spiel für bug wurde erfolgreich angelegt. Teilnehmende Spieler: [bug, Carpe, Phil, Haxx]", responseMessage);
		
		cmd = "!x bug 5";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Carpe",responseMessage);
		
		cmd = "!x bug 5";
		nick = "Carpe!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Phil",responseMessage);
		
		cmd = "!x bug 5";
		nick = "Phil!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Haxx",responseMessage);
		
		cmd = "!x bug 5";
		nick = "Haxx!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		
		//2 
		
		cmd = "!x bug 4";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Carpe",responseMessage);
		
		cmd = "!x bug 4";
		nick = "Carpe!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Phil",responseMessage);
		
		cmd = "!x bug 4";
		nick = "Phil!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Haxx",responseMessage);
		
		cmd = "!x bug 4";
		nick = "Haxx!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		//3
		
		cmd = "!x bug 3";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Carpe",responseMessage);
		
		cmd = "!x bug 3";
		nick = "Carpe!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Phil",responseMessage);
		
		cmd = "!x bug 3";
		nick = "Phil!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Haxx",responseMessage);
		
		cmd = "!x bug 3";
		nick = "Haxx!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		//NEXT
		cmd = "!x bug 2";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Carpe",responseMessage);
		
		cmd = "!x bug 2";
		nick = "Carpe!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Phil",responseMessage);
		
		cmd = "!x bug 2";
		nick = "Phil!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: Haxx",responseMessage);
		
		cmd = "!x bug 2";
		nick = "Haxx!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("Next Player is: bug",responseMessage);
		
		//finish
		cmd = "!x bug 1";
		nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		responseMessage = xwinCtx.perform( nick, new XWinCommandInterpreter(cmd, nick));
	   
		Assert.assertNotNull(responseMessage);
		Assert.assertEquals("The Winner of bug's Game is => bug",responseMessage);
			
	}
	
	
}
