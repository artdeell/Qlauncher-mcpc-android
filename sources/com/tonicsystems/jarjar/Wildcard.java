package com.tonicsystems.jarjar;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Wildcard {
    private static Pattern dstar = Pattern.compile("\\*\\*");
    private static Pattern estar = Pattern.compile("\\+\\??\\)\\Z");
    private static Pattern star = Pattern.compile("\\*");
    private final int count;
    private final String directString;
    private final ArrayList<Object> parts;
    private final Pattern pattern;
    private final String patternBeginning;
    private final int[] refs;
    private final String[] strings;

    public Wildcard(String str, String str2) {
        ArrayList arrayList;
        StringBuilder sb;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb3;
        int i;
        IllegalArgumentException illegalArgumentException2;
        String str3;
        Integer num;
        String str4;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb4;
        IllegalArgumentException illegalArgumentException5;
        String str5 = str;
        String str6 = str2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(16);
        this.parts = arrayList2;
        if (str5.equals("**")) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException5;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("'**' is not a valid pattern");
            throw illegalArgumentException6;
        } else if (!checkIdentifierChars(str5, "/*")) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException4;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(sb5.append("Not a valid package pattern: ").append(str5).toString());
            throw illegalArgumentException8;
        } else if (str5.indexOf("***") >= 0) {
            IllegalArgumentException illegalArgumentException10 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException11 = new IllegalArgumentException("The sequence '***' is invalid in a package pattern");
            throw illegalArgumentException10;
        } else {
            if (str5.indexOf(42) < 0) {
                this.directString = str5;
            } else {
                this.directString = null;
            }
            String replaceAllLiteral = replaceAllLiteral(estar, replaceAllLiteral(star, replaceAllLiteral(dstar, str5, "(.+?)"), "([^/]+)"), "*)");
            StringBuilder sb7 = sb;
            StringBuilder sb8 = new StringBuilder();
            this.pattern = Pattern.compile(sb7.append("\\A").append(replaceAllLiteral).append("\\Z").toString());
            this.count = this.pattern.matcher("foo").groupCount();
            char[] charArray = str6.toCharArray();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            int length = charArray.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length + 1) {
                    char c = i5 == length ? '@' : charArray[i5];
                    if (z) {
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i = i5;
                                break;
                            default:
                                if (i5 != i3) {
                                    String str7 = str3;
                                    String str8 = new String(charArray, i3, i5 - i3);
                                    int parseInt = Integer.parseInt(str7);
                                    if (parseInt > i2) {
                                        i2 = parseInt;
                                    }
                                    ArrayList<Object> arrayList4 = this.parts;
                                    Integer num2 = num;
                                    Integer num3 = new Integer(parseInt);
                                    boolean add = arrayList4.add(num2);
                                    i = i5 - 1;
                                    i3 = i5;
                                    z = false;
                                    break;
                                } else {
                                    IllegalArgumentException illegalArgumentException12 = illegalArgumentException2;
                                    IllegalArgumentException illegalArgumentException13 = new IllegalArgumentException("Backslash not followed by a digit");
                                    throw illegalArgumentException12;
                                }
                        }
                    } else if (c == '@') {
                        ArrayList<Object> arrayList5 = this.parts;
                        String str9 = str4;
                        String str10 = new String(charArray, i3, i5 - i3);
                        boolean add2 = arrayList5.add(str9);
                        i3 = i5 + 1;
                        z = true;
                        i = i5;
                    } else {
                        i = i5;
                    }
                    i4 = i + 1;
                } else {
                    int size = this.parts.size();
                    this.strings = new String[size];
                    this.refs = new int[size];
                    Arrays.fill(this.refs, -1);
                    for (int i6 = 0; i6 < size; i6++) {
                        Object obj = this.parts.get(i6);
                        if (obj instanceof String) {
                            this.strings[i6] = ((String) obj).replace('.', ClassPathElement.SEPARATOR_CHAR);
                        } else {
                            this.refs[i6] = ((Integer) obj).intValue();
                        }
                    }
                    if (this.count < i2) {
                        IllegalArgumentException illegalArgumentException14 = illegalArgumentException;
                        StringBuilder sb9 = sb3;
                        StringBuilder sb10 = new StringBuilder();
                        IllegalArgumentException illegalArgumentException15 = new IllegalArgumentException(sb9.append("Result includes impossible placeholder \"@").append(i2).append("\": ").append(str6).toString());
                        throw illegalArgumentException14;
                    }
                    PrintStream printStream = System.err;
                    StringBuilder sb11 = sb2;
                    StringBuilder sb12 = new StringBuilder();
                    printStream.println(sb11.append("Pattern: ").append(str5).append(": ").append(this.strings[0]).toString());
                    int indexOf = str5.indexOf("*");
                    if (indexOf >= 0) {
                        str5 = str5.substring(0, indexOf);
                    }
                    this.patternBeginning = str5;
                    return;
                }
            }
        }
    }

    private static boolean checkIdentifierChars(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str3.endsWith("package-info")) {
            str3 = str3.substring(0, str3.length() - "package-info".length());
        }
        int length = str3.length();
        for (int i = 0; i < length; i++) {
            char charAt = str3.charAt(i);
            if (str4.indexOf(charAt) < 0 && !Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return true;
    }

    private Matcher getMatcher(String str) {
        Matcher matcher;
        String str2 = str;
        if (!str2.startsWith(this.patternBeginning)) {
            matcher = null;
        } else {
            matcher = this.pattern.matcher(str2);
            if (!matcher.matches() || !checkIdentifierChars(str2, "/")) {
                return null;
            }
        }
        return matcher;
    }

    private static String replaceAllLiteral(Pattern pattern2, String str, String str2) {
        Pattern pattern3 = pattern2;
        String str3 = str;
        return pattern3.matcher(str3).replaceAll(str2.replaceAll("([$\\\\])", "\\\\$0"));
    }

    public boolean matches(String str) {
        String str2 = str;
        return this.directString != null ? str2.equals(this.directString) : getMatcher(str2) != null;
    }

    public String replace(String str) {
        String str2;
        StringBuilder sb;
        String str3 = str;
        if (this.directString != null) {
            str2 = null;
            if (this.directString.equals(str3)) {
                str2 = this.strings[0];
            }
        } else {
            Matcher matcher = getMatcher(str3);
            str2 = null;
            if (matcher != null) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = sb2;
                int i = 0;
                while (i < this.strings.length) {
                    StringBuilder append = sb4.append(this.refs[i] >= 0 ? matcher.group(this.refs[i]) : this.strings[i]);
                    i++;
                }
                return sb4.toString();
            }
        }
        return str2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Wildcard{pattern=").append(this.pattern).append(",parts=").append(this.parts).append("}").toString();
    }
}
