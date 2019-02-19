package de.bug0r.plugin.xwin;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import de.bug0r.core.utils.String.StringUtils;

public class XWinContext {

	public static final String X_WIN_CMD = "!x";
	public XWinContext() {
		currentGames = new Hashtable<String, XWinGame>();
	}
	
	public String perform(String user, XWinCommandInterpreter interpreter) {
		String action = interpreter.getAction();
		if ( "start".equals(action) ) {
			return startGame(extractNick(user), interpreter.getRows(), interpreter.getCols(), interpreter.getWinToken(), interpreter.getPlayer());
		} else if ( "stop".equals(action) ) {
			return stopGame(extractNick(user));
		} else if ("stat".equals(action)) {
			return gameStat(extractNick(user));
		} else if ( containsGame(interpreter.getAction()) ) {
			if ( interpreter.getPlayToken() >= 1 ) {
				return playToken(interpreter.getAction(),extractNick(user), interpreter.getPlayToken());
			}
		}
		return StringUtils.EMPTY_STRING;
	}
	
	private String gameStat(String user) {
		String resString = StringUtils.EMPTY_STRING;
		if ( currentGames.containsKey(user) ) {
			XWinGame game = currentGames.get(user);
			resString = game.gameState();
		}
		return resString;
	}

	private String startGame(String user, int rows, int cols, int wintoken, List<String> player) {
		String shortName = extractNick(user);
		if ( containsGame(user) ) return  shortName + ": hat bereits ein Spiel angelegt.";
		try {
			currentGames.put(user, new XWinGame(rows, cols, wintoken, player));
			return "Das Spiel für " + shortName + " wurde erfolgreich angelegt. Teilnehmende Spieler: " + player;
		} catch (Exception e) {
			return "Fehler: " + e.getMessage();
		}
	}
	
	private String stopGame(String user) {
		if ( containsGame(user) ) {
			currentGames.remove(user);
		}
		return "Spiel von " + extractNick(user) + " wurde beendet";
	}
	
	private String playToken(String user, String playerName, int column) {
		XWinGame game = currentGames.get(user);
		boolean won = game.playTokenAndCheckIfWon(playerName, column);
		if ( won ) {
			currentGames.remove(user);
			return "The Winner of " + user + "'s Game is => " + playerName;
		} else {
			return "Next Player is: " + game.nextPlayerName();
		}
	}
	
	private String extractNick(String longUser) {
		return longUser.split("!")[0];
	}
	
	private boolean containsGame(String user) {
		return currentGames.containsKey(user);
	}
	
	private Map<String, XWinGame> currentGames;
}
