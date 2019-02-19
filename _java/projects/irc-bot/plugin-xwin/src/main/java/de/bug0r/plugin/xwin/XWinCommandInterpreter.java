package de.bug0r.plugin.xwin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.bug0r.core.utils.String.StringUtils;

public class XWinCommandInterpreter {

	public XWinCommandInterpreter(String commandString, String user) {
		if ( StringUtils.isEmptyTrim(commandString)) throw new IllegalArgumentException("command should not be null");
		if ( StringUtils.isEmptyTrim(user)) throw new IllegalArgumentException("user should not be null");
		
		String[] parameter = commandString.split(StringUtils.SPACE);
		if ( parameter.length == 1 ) throw new IllegalArgumentException("empty command");
		if ( !(parameter.length == 2 || parameter.length == 3 || parameter.length == 6)  )
			throw new IllegalArgumentException("ungültige Anzahl parameter");
		setDefaultRaster();
		this.player = new ArrayList<String>();
		this.player.add(user);
		int paramIndex= 1;
		if ( parameter.length >= 2 ) {
			action = parameter[paramIndex];
		}
		if ( parameter.length == 3 ) {
			String curParameter = parameter[++paramIndex];
			try {
				playToken = Integer.parseInt(curParameter);
				if ( playToken <= 0 ) playToken = -1;
			} catch (NumberFormatException e) {
				player.add(curParameter);
			}
			
		} else if ( parameter.length == 6 ){
			try {
				rows = Integer.parseInt(parameter[++paramIndex]);
				cols = Integer.parseInt(parameter[++paramIndex]);
				winToken = Integer.parseInt(parameter[++paramIndex]);
			} catch (NumberFormatException e) {
				setDefaultRaster();
			}
			player.addAll(Arrays.asList(parameter[++paramIndex].split(",")));
		}
		
	}
	public String getAction() {
		return action;
	}
	public List<String> getPlayer() {
		return player;
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public int getWinToken() {
		return winToken;
	}
	
	public int getPlayToken() {
		return playToken;
	}
	private void setDefaultRaster() {
		rows = 5;
		cols = 5;
		winToken = 4;
	}
	private String action;
	private List<String> player;
	private int rows;
	private int cols;
	private int winToken;
	private int playToken;
	
}
