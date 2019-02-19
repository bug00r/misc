package de.bug0r.plugin.xwin;

public class XWin {
	public XWin(int xFields, int yFields, int needWinToken) {
		if ( xFields < needWinToken && yFields < needWinToken )
			throw new IllegalArgumentException("not enough field elements(x/y): (" + xFields + "/" + yFields + ")");
		this.xFields = xFields;
		this.yFields = yFields;
		this.needWinToken = needWinToken;
		field = new int[xFields][yFields];
	}
	public boolean setTokenAndCheckIfWon(int playerNumber, int column) {
		if ( playerNumber < 1 ) throw new IllegalArgumentException("playernumber should be greater 0");
		int curColumn = column -1;
		if ( curColumn < 0 || curColumn > xFields-1 ) throw new IllegalArgumentException("invalid column: " + curColumn);
		if ( field[curColumn][0] != 0 ) throw new IllegalArgumentException("colum full please choose another one");
		int curRow = yFields - 1;
		for ( ; curRow >= 0; --curRow ) {
			if ( field[curColumn][curRow] == 0 ) {
				field[curColumn][curRow] = playerNumber;
				break;
			}
		}
		return hasWon(playerNumber,curColumn,curRow);
	}
	public int [][] getField() {
		return field;
	}
	private boolean hasWon(int playerNumber,int playedXPos, int playedYPos) {
		return checkIntervallType(playerNumber, playedXPos, playedYPos, -1, 0, 1, 0) ||
				checkIntervallType(playerNumber, playedXPos, playedYPos, 0, -1, 0, 1) ||
				checkIntervallType(playerNumber, playedXPos, playedYPos, -1, 1, 1, -1) ||
				checkIntervallType(playerNumber, playedXPos, playedYPos, -1, -1, 1, 1);
	}
	private boolean checkIntervallType(int playerNumber,int playedXPos, int playedYPos, int leftXStep, int leftYStep, int rightXStep, int rightYStep) {
		int self = 0;
		self = cntNeighbourTokenLikePlayer(playerNumber,0,playedXPos,playedYPos,leftXStep,leftYStep);
		self = cntNeighbourTokenLikePlayer(playerNumber,--self,playedXPos,playedYPos,rightXStep,rightYStep); 
		if ( self >= this.needWinToken ) return true;
		return false;
	}
	private int cntNeighbourTokenLikePlayer(int playerNumber,int foundNeightbours ,int playedXPos, int playedYPos,int xStep, int yStep) {
		int result = foundNeightbours;
		if ( playedXPos < 0 || playedXPos > xFields-1 || playedYPos < 0 || playedYPos > yFields-1) return foundNeightbours;
		if ( field[playedXPos][playedYPos] == playerNumber ) {
			result = cntNeighbourTokenLikePlayer(playerNumber,++foundNeightbours,playedXPos+xStep,playedYPos+yStep,xStep,yStep);
		}
		return result;
	}
	private int xFields;
	private int yFields;
	private int needWinToken;
	private int[][] field;
}
