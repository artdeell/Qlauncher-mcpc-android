package com.tonicsystems.jarjar;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.objectweb.asm.commons.Remapper;

class PackageRemapper extends Remapper {
    private static final Pattern ARRAY_FOR_NAME_PATTERN = Pattern.compile("\\[L[\\p{javaJavaIdentifierPart}\\.]+?;");
    private static final String RESOURCE_SUFFIX = "RESOURCE";
    private final Map<String, String> pathCache;
    private final Map<String, String> typeCache;
    private final Map<Object, String> valueCache;
    private final boolean verbose;
    private final List<Wildcard> wildcards;

    public PackageRemapper(List<Rule> list, boolean z) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        List<Rule> list2 = list;
        boolean z2 = z;
        HashMap hashMap4 = hashMap;
        HashMap hashMap5 = new HashMap();
        this.typeCache = hashMap4;
        HashMap hashMap6 = hashMap2;
        HashMap hashMap7 = new HashMap();
        this.pathCache = hashMap6;
        HashMap hashMap8 = hashMap3;
        HashMap hashMap9 = new HashMap();
        this.valueCache = hashMap8;
        this.verbose = z2;
        this.wildcards = PatternElement.createWildcards(list2);
    }

    static boolean isArrayForName(String str) {
        return ARRAY_FOR_NAME_PATTERN.matcher(str).matches();
    }

    private String replaceHelper(String str) {
        String str2 = str;
        for (Wildcard replace : this.wildcards) {
            String replace2 = replace.replace(str2);
            if (replace2 != null) {
                return replace2;
            }
        }
        return str2;
    }

    public String map(String str) {
        String str2 = str;
        String str3 = (String) this.typeCache.get(str2);
        if (str3 == null) {
            str3 = replaceHelper(str2);
            if (str2.equals(str3)) {
                str3 = null;
            }
            Object put = this.typeCache.put(str2, str3);
        }
        return str3;
    }

    public String mapPath(String str) {
        String substring;
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str2 = str;
        String str3 = (String) this.pathCache.get(str2);
        if (str3 == null) {
            int lastIndexOf = str2.lastIndexOf(47);
            if (lastIndexOf < 0) {
                substring = str2;
                sb2 = RESOURCE_SUFFIX;
            } else {
                substring = str2.substring(lastIndexOf + 1);
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                sb2 = sb5.append(str2.substring(0, lastIndexOf + 1)).append(RESOURCE_SUFFIX).toString();
            }
            boolean startsWith = sb2.startsWith("/");
            if (startsWith) {
                sb2 = sb2.substring(1);
            }
            String replaceHelper = replaceHelper(sb2);
            if (startsWith) {
                StringBuilder sb7 = sb4;
                StringBuilder sb8 = new StringBuilder();
                replaceHelper = sb7.append("/").append(replaceHelper).toString();
            }
            if (replaceHelper.indexOf(RESOURCE_SUFFIX) < 0) {
                return str2;
            }
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            str3 = sb9.append(replaceHelper.substring(0, replaceHelper.length() - RESOURCE_SUFFIX.length())).append(substring).toString();
            Object put = this.pathCache.put(str2, str3);
        }
        return str3;
    }

    public Object mapValue(Object obj) {
        StringBuilder sb;
        Object obj2 = obj;
        if (!(obj2 instanceof String)) {
            return super.mapValue(obj2);
        }
        String str = (String) this.valueCache.get(obj2);
        if (str == null) {
            str = (String) obj2;
            if (isArrayForName(str)) {
                String replace = str.replace('.', ClassPathElement.SEPARATOR_CHAR);
                String mapDesc = mapDesc(replace);
                if (!mapDesc.equals(replace)) {
                    str = mapDesc.replace(ClassPathElement.SEPARATOR_CHAR, '.');
                    return str;
                }
            } else {
                str = mapPath(str);
                if (str.equals(obj2)) {
                    boolean z = str.indexOf(46) >= 0;
                    boolean z2 = str.indexOf(47) >= 0;
                    if (!z || !z2) {
                        str = z ? replaceHelper(str.replace('.', ClassPathElement.SEPARATOR_CHAR)).replace(ClassPathElement.SEPARATOR_CHAR, '.') : replaceHelper(str);
                    }
                }
            }
            Object put = this.valueCache.put(obj2, str);
        }
        if (this.verbose && !str.equals(obj2)) {
            PrintStream printStream = System.err;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Changed \"").append(obj2).append("\" -> \"").append(str).append("\"").toString());
            return str;
        }
        return str;
    }
}
