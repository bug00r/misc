package de.bug0r.message.irc.utils;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import de.bug0r.core.utils.String.StringArea;
import de.bug0r.core.utils.String.StringUtils;
import de.bug0r.message.irc.IrcMessage;

public class IrcMessageUtils {

	private IrcMessageUtils() {
	}
	
	public static final String IRC_MESSAGE_DELIMITER = "\r\n";
	public static final char IRC_MESSAGE_CR = '\r';
	public static final char IRC_MESSAGE_LF = '\n';
	/** irc space separator */
	public static final String SPACE = " ";
	public static final char SPACE_CHR = ' ';
	/** irc command end */
	public static final String MSG_END = IRC_MESSAGE_DELIMITER;
	/** irc command prefix ":" */
	public static final String MSG_PARAM_PREFIX = ":";
	/** irc command prefix ":" */
	public static final char MSG_PARAM_PREFIX_CHAR = ':';
	/** irc parameter separator "," */
	public static final String MSG_PARAM_SEP = ",";
	/** irc command wildcard Aterix */
	public static final String MSG_PARAM_ASTERIX = "*";
	/** irc command wildcard Aterix */
	public static final String SOURCE_NICK_DELIM = "!";
	/** irc command wildcard Aterix */
	public static final String SOURCE_REALNAMEADRESS_DELIM = "@";
	
	
	public static boolean messageHasSource(String ircRawMessage) {
		return ircRawMessage.charAt(0) == MSG_PARAM_PREFIX_CHAR;
	}
	
	public static boolean messageHasSource(String ircRawMessage, boolean trim) {
		if ( trim ) return messageHasSource(ircRawMessage.trim());
		return messageHasSource(ircRawMessage);
	}
	
	public static boolean messageHasNoSource(String ircRawMessage) {
		return ircRawMessage.charAt(0) != MSG_PARAM_PREFIX_CHAR;
	}
	
	public static boolean messageHasNoSource(String ircRawMessage, boolean trim) {
		if ( trim ) return messageHasNoSource(ircRawMessage.trim());
		return messageHasNoSource(ircRawMessage);
	}
	
	public static IrcMessage getIrcMessageByRawMessage(String rawMessage) {
		StringTokenizer messageTokenizer = new StringTokenizer(rawMessage);
		String token = messageTokenizer.nextToken(SPACE);
		String currentCommand = null;
		IrcMessage currentMessage = IrcMessage.NULL;
		try {
			if (token.charAt(0) != MSG_PARAM_PREFIX_CHAR ) {
				currentCommand = token;
			} else {
				currentCommand = messageTokenizer.nextToken(SPACE);
			}
			
			if ( IrcMessageUtils.commandStringIsNumeric(currentCommand) ) {
				currentMessage = IrcMessage.NUMERIC;
			} else {
				currentMessage = IrcMessage.reverse(currentCommand);
			}
			
		} catch ( NoSuchElementException e ) {
		} finally {
		}
		return currentMessage;
	}
	
	public static boolean commandStringIsNumeric(String command) {
		boolean isNumeric = true;
		try {
			Integer.parseInt(command);
		} catch (NumberFormatException e) {
			isNumeric = false;
		}
		return isNumeric;
	}
	
	public static boolean messageHasParameter(String rawMessage) {
		return rawMessage.trim().split(IrcMessageUtils.SPACE).length > 1;
	}
	
	public static boolean rawMessageContainsTextResource(String rawMessage) {
		return rawMessage.lastIndexOf(MSG_PARAM_PREFIX) > 0;
	}
	
	public static String extractTextResourceFromMessage(String rawMessage) {
		return StringUtils.extractStringArea(rawMessage, END_TEXT);
	}
	
	public static String extractTextResourceFromMessageWithoutSource(String rawMessage) {
		return StringUtils.extractStringArea(rawMessage, END_TEXT_WITHOUTSOURCE);
	}
	
	public static String getNickNameFromCompleteUsername(String source) {
		return StringUtils.extractStringArea(source, SOURCE_TEXT);
	}

	public static String getNickNameFromCompleteSource(String source) {
		return source.split(SOURCE_NICK_DELIM)[0];
	}
	
	public static String getParamByIndex(String source, int counter) {
		StringArea paramArea = new StringArea(0,SPACE_CHR,counter,SPACE_CHR, 0);
		return StringUtils.extractStringArea(source, paramArea);
	}
	
	private static final StringArea END_TEXT = new StringArea(0,MSG_PARAM_PREFIX_CHAR,1,IRC_MESSAGE_CR, 0);
	private static final StringArea END_TEXT_WITHOUTSOURCE = new StringArea(0,MSG_PARAM_PREFIX_CHAR,0,IRC_MESSAGE_CR, 0);
	private static final StringArea SOURCE_TEXT = new StringArea(0,MSG_PARAM_PREFIX_CHAR,0, SPACE_CHR, 0);
}
