package de.bug0r.games.xwin.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import de.bug0r.plugin.xwin.XWinCommandInterpreter;

public class TestXWinInterpreter {

	@Test()
	public void testXwinInterpreterBotPlayerSuccess() {
		String cmd = "!x start player";
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
		
		Assert.assertEquals(interpreter.getCols(), 5);
		Assert.assertEquals(interpreter.getRows(), 5);
		Assert.assertEquals(interpreter.getWinToken(), 4);
		Assert.assertEquals(interpreter.getPlayer().get(0), "bug");
		Assert.assertEquals(interpreter.getPlayer().get(1), "player");
		Assert.assertTrue(interpreter.getPlayer().size() == 2);
	}
	
	@Test()
	public void testXwinInterpreterTwoPlayerSuccess() {
		String playerTwo = "Player2";
		String cmd = "!x start " + playerTwo;
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
		
		Assert.assertEquals(interpreter.getCols(), 5);
		Assert.assertEquals(interpreter.getRows(), 5);
		Assert.assertEquals(interpreter.getWinToken(), 4);
		Assert.assertEquals(interpreter.getPlayer().get(0), "bug");
		Assert.assertEquals(interpreter.getPlayer().get(1), playerTwo);
		Assert.assertTrue(interpreter.getPlayer().size() == 2);
	}
	
	@Test()
	public void testXwinInterpreterXPlayerSuccess() {
		String players = "Player2,Player3,Player4";
		String cmd = "!x start 10 10 5 " + players;
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
		
		Assert.assertEquals(interpreter.getCols(), 10);
		Assert.assertEquals(interpreter.getRows(), 10);
		Assert.assertEquals(interpreter.getWinToken(), 5);
		Assert.assertEquals(interpreter.getPlayer().get(0), "bug");
		Assert.assertEquals(interpreter.getPlayer().get(1), "Player2");
		Assert.assertEquals(interpreter.getPlayer().get(2), "Player3");
		Assert.assertEquals(interpreter.getPlayer().get(3), "Player4");
		Assert.assertTrue(interpreter.getPlayer().size() == 4);
	}
	
	@Test(expectedExceptions={IllegalArgumentException.class}, expectedExceptionsMessageRegExp="ungültige Anzahl parameter")
	public void testXwinInterpreterInvalidParameterCountFail() {
		String players = "";
		String cmd = "!x start 10 10 5 " + players;
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
	}
	
	@Test()
	public void testXwinInterpreterFail() {
		String cmd = "!x start 10"; //TODO unchecked error...could play with not existing user in Channel
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
	}
	
	@Test(expectedExceptions={IllegalArgumentException.class}, expectedExceptionsMessageRegExp="ungültige Anzahl parameter")
	public void testXwinInterpreterToMuchParameterCountFail() {
		String players = "";
		String cmd = "!x start 10 10 5  6  6  6 6 6 6  6 6 " + players;
		String nick = "bug!~bug@dslb-092-072-092-025.pools.arcor-ip.net";
		XWinCommandInterpreter interpreter = new XWinCommandInterpreter(cmd, nick);
	}
	
}
