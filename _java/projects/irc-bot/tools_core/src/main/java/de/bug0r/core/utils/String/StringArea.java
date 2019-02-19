package de.bug0r.core.utils.String;

public class StringArea {
	
	private final int startPosition;
	private final int beginCharacter;
	private final int toSkipBeginCharacter;
	private final int endCharacter;
	private final int toSkipEndCharacter;
	
	public StringArea(int startPosition,
					  int beginCharacter,
	                  int toSkipBeginCharacter,
	                  int endCharacter,
	                  int toSkipEndCharacter) {
		
		this.beginCharacter = beginCharacter;
		this.endCharacter = endCharacter;
		this.startPosition= startPosition;
		this.toSkipBeginCharacter = toSkipBeginCharacter;
		this.toSkipEndCharacter = toSkipEndCharacter;		
	}

	public int getStartPosition() {
		return startPosition;
	}

	public int getBeginCharacter() {
		return beginCharacter;
	}

	public int getToSkipBeginCharacter() {
		return toSkipBeginCharacter;
	}

	public int getEndCharacter() {
		return endCharacter;
	}

	public int getToSkipEndCharacter() {
		return toSkipEndCharacter;
	}

}