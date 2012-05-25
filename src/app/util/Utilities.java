package app.util;

import org.apache.commons.lang.StringEscapeUtils;

public abstract class Utilities {
    
    public static String capitalize(String string) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(string.substring(0, 1).toUpperCase());
    	builder.append(string.subSequence(1, string.length()));
		return builder.toString();
	}
	
    public static String encode(String value) {
    	return StringEscapeUtils.escapeHtml(value);
    }
    
    public static String decode(String value) {
    	return StringEscapeUtils.unescapeHtml(value);
    }
    
}
