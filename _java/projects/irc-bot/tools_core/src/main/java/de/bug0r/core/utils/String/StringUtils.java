/**
 * 
 */
package de.bug0r.core.utils.String;

import java.util.List;

/**
 * @author bug0r
 * @version 0.1
 */
public class StringUtils {

	private StringUtils() {
	}
	
	public static final String EMPTY_STRING = "";
	public static final String SPACE = " ";
	
	public static boolean isEmtpy(String string) {
		return null == string || EMPTY_STRING.equals(string);
	}
	
	public static boolean isEmptyTrim(String string) {
		return string == null || isEmtpy(string.trim());
	}
	
	public static String collectionToSeparatedString(List<String> list, String separtor) {
		StringBuilder separatedString = new StringBuilder(StringUtils.EMPTY_STRING);
		String usedSeparator = (isEmptyTrim(separtor)?EMPTY_STRING:separtor);
		if ( null != list && !list.isEmpty() ) {
			if ( list.size() == 1 ) return list.get(0);
			for ( String listEntry: list) {
					separatedString.append(listEntry)
					.append(usedSeparator);
			}			
			separatedString.deleteCharAt(separatedString.lastIndexOf(usedSeparator));
		}
		return new String(separatedString);
	}

	public static String extractStringArea(String source, StringArea toExtractArea) {
		int foundStartIndex = searchCharacterIndex(source, toExtractArea.getStartPosition(), 
				toExtractArea.getBeginCharacter(), toExtractArea.getToSkipBeginCharacter());
		int beginEndIndex = foundStartIndex;
		++beginEndIndex;
		int foundEndIndex = searchCharacterIndex(source, beginEndIndex, 
				toExtractArea.getEndCharacter(), toExtractArea.getToSkipEndCharacter());
		
		return source.substring(++foundStartIndex, foundEndIndex);
		
	}
	
	public static int searchCharacterIndex(String source, int startPosition, int searchedCharacter, int skipFoundCharacter) {
		int indexStartPosition = startPosition;
		int foundIndex = indexStartPosition;
		int lastIndex = source.length();
		int result = lastIndex;
		if ( indexStartPosition > -1 ) {	
			do {	
				foundIndex = source.indexOf(searchedCharacter, indexStartPosition);
				if ( foundIndex > -1 ) {
					if ( skipFoundCharacter > 0 )  {
						--skipFoundCharacter;
						indexStartPosition = foundIndex;
						++indexStartPosition;
					} else {
						result = foundIndex;
						break;
					}
				} 
			} while (foundIndex > -1);
		} 
		return result;
	}
	
}
