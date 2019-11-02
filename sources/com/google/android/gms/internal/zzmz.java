package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

public class zzmz {
    private static final Pattern zzaof = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzaog = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzaoh = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private static String decode(String str, String str2) {
        IllegalArgumentException illegalArgumentException;
        String str3 = str;
        String str4 = str2;
        if (str4 == null) {
            str4 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str3, str4);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(unsupportedEncodingException);
            throw illegalArgumentException2;
        }
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r11v32, types: [java.util.Map] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> zza(java.net.URI r15, java.lang.String r16) {
        /*
            r0 = r15
            r1 = r16
            java.util.Map r11 = java.util.Collections.emptyMap()
            r2 = r11
            r11 = r0
            java.lang.String r11 = r11.getRawQuery()
            r3 = r11
            r11 = r3
            if (r11 == 0) goto L_0x0080
            r11 = r3
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x0080
            java.util.HashMap r11 = new java.util.HashMap
            r14 = r11
            r11 = r14
            r12 = r14
            r12.<init>()
            r4 = r11
            java.util.Scanner r11 = new java.util.Scanner
            r14 = r11
            r11 = r14
            r12 = r14
            r13 = r3
            r12.<init>(r13)
            r5 = r11
            r11 = r5
            java.lang.String r12 = "&"
            java.util.Scanner r11 = r11.useDelimiter(r12)
        L_0x0032:
            r11 = r5
            boolean r11 = r11.hasNext()
            if (r11 == 0) goto L_0x007e
            r11 = r5
            java.lang.String r11 = r11.next()
            java.lang.String r12 = "="
            java.lang.String[] r11 = r11.split(r12)
            r7 = r11
            r11 = r7
            int r11 = r11.length
            if (r11 == 0) goto L_0x004e
            r11 = r7
            int r11 = r11.length
            r12 = 2
            if (r11 <= r12) goto L_0x0059
        L_0x004e:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r14 = r11
            r11 = r14
            r12 = r14
            java.lang.String r13 = "bad parameter"
            r12.<init>(r13)
            throw r11
        L_0x0059:
            r11 = r7
            r12 = 0
            r11 = r11[r12]
            r12 = r1
            java.lang.String r11 = decode(r11, r12)
            r8 = r11
            r11 = r7
            int r11 = r11.length
            r9 = r11
            r11 = 0
            r10 = r11
            r11 = r9
            r12 = 2
            if (r11 != r12) goto L_0x0076
            r11 = r7
            r12 = 1
            r11 = r11[r12]
            r12 = r1
            java.lang.String r11 = decode(r11, r12)
            r10 = r11
        L_0x0076:
            r11 = r4
            r12 = r8
            r13 = r10
            java.lang.Object r11 = r11.put(r12, r13)
            goto L_0x0032
        L_0x007e:
            r11 = r4
            r2 = r11
        L_0x0080:
            r11 = r2
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmz.zza(java.net.URI, java.lang.String):java.util.Map");
    }
}
