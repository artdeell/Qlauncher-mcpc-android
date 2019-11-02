package com.google.gson;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    ;

    private static String modifyString(char c, String str, int i) {
        StringBuilder sb;
        char c2 = c;
        String str2 = str;
        int i2 = i;
        if (i2 >= str2.length()) {
            return String.valueOf(c2);
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(c2).append(str2.substring(i2)).toString();
    }

    /* access modifiers changed from: private */
    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        for (int i = 0; i < str3.length(); i++) {
            char charAt = str3.charAt(i);
            if (Character.isUpperCase(charAt) && sb4.length() != 0) {
                StringBuilder append = sb4.append(str4);
            }
            StringBuilder append2 = sb4.append(charAt);
        }
        return sb4.toString();
    }

    /* access modifiers changed from: private */
    public static String upperCaseFirstLetter(String str) {
        StringBuilder sb;
        char c;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        int i = 0;
        char charAt = str2.charAt(0);
        while (true) {
            c = charAt;
            if (i < -1 + str2.length() && !Character.isLetter(c)) {
                StringBuilder append = sb4.append(c);
                i++;
                charAt = str2.charAt(i);
            }
        }
        if (i == str2.length()) {
            str2 = sb4.toString();
        } else if (!Character.isUpperCase(c)) {
            return sb4.append(modifyString(Character.toUpperCase(c), str2, i + 1)).toString();
        }
        return str2;
    }
}
