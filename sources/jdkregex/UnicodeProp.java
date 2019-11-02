package jdkregex;

import java.util.HashMap;
import java.util.Locale;

enum UnicodeProp {
    ;
    
    private static final HashMap<String, String> aliases = null;
    private static final HashMap<String, String> posix = null;

    static {
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        HashMap<String, String> hashMap3 = hashMap;
        HashMap<String, String> hashMap4 = new HashMap<>();
        posix = hashMap3;
        HashMap<String, String> hashMap5 = hashMap2;
        HashMap<String, String> hashMap6 = new HashMap<>();
        aliases = hashMap5;
        Object put = posix.put("ALPHA", "ALPHABETIC");
        Object put2 = posix.put("LOWER", "LOWERCASE");
        Object put3 = posix.put("UPPER", "UPPERCASE");
        Object put4 = posix.put("SPACE", "WHITE_SPACE");
        Object put5 = posix.put("PUNCT", "PUNCTUATION");
        Object put6 = posix.put("XDIGIT", "HEX_DIGIT");
        Object put7 = posix.put("ALNUM", "ALNUM");
        Object put8 = posix.put("CNTRL", "CONTROL");
        Object put9 = posix.put("DIGIT", "DIGIT");
        Object put10 = posix.put("BLANK", "BLANK");
        Object put11 = posix.put("GRAPH", "GRAPH");
        Object put12 = posix.put("PRINT", "PRINT");
        Object put13 = aliases.put("WHITESPACE", "WHITE_SPACE");
        Object put14 = aliases.put("HEXDIGIT", "HEX_DIGIT");
        Object put15 = aliases.put("NONCHARACTERCODEPOINT", "NONCHARACTER_CODE_POINT");
    }

    public static UnicodeProp forName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String str2 = (String) aliases.get(upperCase);
        if (str2 == null) {
            str2 = upperCase;
        }
        try {
            return valueOf(str2);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            return null;
        }
    }

    public static UnicodeProp forPOSIXName(String str) {
        String str2 = (String) posix.get(str.toUpperCase(Locale.ENGLISH));
        if (str2 == null) {
            return null;
        }
        return valueOf(str2);
    }

    /* renamed from: is */
    public abstract boolean mo7641is(int i);
}
