package de.bug0r.plugin.xwin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.core.utils.collection.CollectionUtils;

public class XWinGame {

	public XWinGame(int rows, int cols, int wintoken, List<String> player) {
		if ( CollectionUtils.isEmpty(player) ) throw new IllegalArgumentException("need player for game");
		gameRaster = new XWin(cols, rows, wintoken);
		playerMapping = new HashMap<String, Integer>();
		playerList = new HashMap<Integer,String>();
		nextPlayer = 1;
		cntPlayer = player.size();
		initPlayerMapping(player);
	}
	
	public boolean playTokenAndCheckIfWon(String playerName, int column) throws IllegalArgumentException {
		if ( !containsPlayerName(playerName) ) return false;
		int playerNumber = playerMapping.get(playerName);
		if ( playerNumber == nextPlayer ) {
			switchNextPlayer();
		}
		return gameRaster.setTokenAndCheckIfWon(playerNumber, column);
	}
	
	public String nextPlayerName() {
		return playerList.get(nextPlayer);
	}
	
	public String gameState() {
		StringBuffer gameState = new StringBuffer();
		gameState.append("Spielstand: " + playerList.get(1));
		int [][]field = gameRaster.getField();
		for (int i=0;i<field.length;++i) {
			gameState.append("#");
			for (int j=0;j<field[0].length;++j) {
				gameState.append("")
						 .append(field[j][i])
						 .append(",")
						 .append(field[j][i])
						 .append("**")
						 .append("");
			}
		}
		gameState.append("#");
		for ( Integer key: playerList.keySet() ) {
			gameState.append("")
					 .append(key)
					 .append(",")
					 .append(key)
					 .append("**")
					 .append("")
					 .append("=")
					 .append(playerList.get(key))
					 .append(" ");
		}
		return new String(gameState);
	}
	
	private boolean containsPlayerName(String playerName) {
		if ( StringUtils.isEmptyTrim(playerName) ) return false;
		return playerMapping.containsKey(playerName);
	}
	
	private void initPlayerMapping(List<String> player) {
		int playerCount = 0;
		for ( String playerName: player ) {
			++playerCount;
			playerMapping.put(playerName, playerCount);
			playerList.put(playerCount, playerName);
		}
	}
	
	private void switchNextPlayer() {
		if ( nextPlayer == cntPlayer ) {
			nextPlayer = 1;
		} else {
			nextPlayer++;
		}
	}
	
	private XWin gameRaster;
	private Map<String, Integer> playerMapping;
	private Map<Integer,String> playerList;
	private int nextPlayer;
	private int cntPlayer;
}
