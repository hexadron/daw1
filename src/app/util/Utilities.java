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

	public static String camelCase(String str) {
		if (str.indexOf("_") != -1) {
			String[] parts = str.split("_");
			String camelCase = "";
			for (int i = 0; i < parts.length; i++) {
				String part = parts[i];
				if (i == 0)
					camelCase += part.toLowerCase();
				else
					camelCase += Utilities.capitalize(part);
			}
			return camelCase;
		} else {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
	}
    
}
