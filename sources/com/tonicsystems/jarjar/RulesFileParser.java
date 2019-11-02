package com.tonicsystems.jarjar;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

class RulesFileParser {
    private RulesFileParser() {
    }

    private static void error(int i, String[] strArr) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        String[] strArr2 = strArr;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Error on line ").append(i2).append(": ").append(Arrays.asList(strArr2)).toString());
        throw illegalArgumentException2;
    }

    public static List<PatternElement> parse(File file) throws IOException {
        FileReader fileReader;
        FileReader fileReader2 = fileReader;
        FileReader fileReader3 = new FileReader(file);
        return parse((Reader) fileReader2);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r12v32 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r12v34 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r12v35, types: [com.tonicsystems.jarjar.PatternElement] */
    /* JADX WARNING: type inference failed for: r13v14, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r12v41 */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r12v43 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tonicsystems.jarjar.PatternElement> parse(java.io.Reader r16) throws java.io.IOException {
        /*
            r0 = r16
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x00ab }
            r15 = r12
            r12 = r15
            r13 = r15
            r13.<init>()     // Catch:{ all -> 0x00ab }
            r1 = r12
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ all -> 0x00ab }
            r15 = r12
            r12 = r15
            r13 = r15
            r14 = r0
            r13.<init>(r14)     // Catch:{ all -> 0x00ab }
            r2 = r12
            r12 = 1
            r3 = r12
        L_0x0017:
            r12 = r2
            java.lang.String r12 = r12.readLine()     // Catch:{ all -> 0x00ab }
            r5 = r12
            r12 = r5
            if (r12 == 0) goto L_0x00b3
            r12 = r5
            java.lang.String r12 = stripComment(r12)     // Catch:{ all -> 0x00ab }
            r6 = r12
            java.lang.String r12 = ""
            r13 = r6
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x00ab }
            if (r12 != 0) goto L_0x0017
            r12 = r6
            java.lang.String r13 = "\\s+"
            java.lang.String[] r12 = r12.split(r13)     // Catch:{ all -> 0x00ab }
            r7 = r12
            r12 = r7
            int r12 = r12.length     // Catch:{ all -> 0x00ab }
            r13 = 2
            if (r12 >= r13) goto L_0x0041
            r12 = r3
            r13 = r7
            error(r12, r13)     // Catch:{ all -> 0x00ab }
        L_0x0041:
            r12 = r7
            r13 = 0
            r12 = r12[r13]     // Catch:{ all -> 0x00ab }
            r8 = r12
            r12 = r8
            java.lang.String r13 = "rule"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x00ab }
            if (r12 == 0) goto L_0x007d
            r12 = r7
            int r12 = r12.length     // Catch:{ all -> 0x00ab }
            r13 = 3
            if (r12 >= r13) goto L_0x0059
            r12 = r3
            r13 = r7
            error(r12, r13)     // Catch:{ all -> 0x00ab }
        L_0x0059:
            com.tonicsystems.jarjar.Rule r12 = new com.tonicsystems.jarjar.Rule     // Catch:{ all -> 0x00ab }
            r15 = r12
            r12 = r15
            r13 = r15
            r13.<init>()     // Catch:{ all -> 0x00ab }
            r11 = r12
            r12 = r11
            r13 = r7
            r14 = 2
            r13 = r13[r14]     // Catch:{ all -> 0x00ab }
            r12.setResult(r13)     // Catch:{ all -> 0x00ab }
            r12 = r11
            r9 = r12
        L_0x006c:
            r12 = r9
            r13 = r7
            r14 = 1
            r13 = r13[r14]     // Catch:{ all -> 0x00ab }
            r12.setPattern(r13)     // Catch:{ all -> 0x00ab }
            r12 = r1
            r13 = r9
            boolean r12 = r12.add(r13)     // Catch:{ all -> 0x00ab }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x007d:
            r12 = r8
            java.lang.String r13 = "zap"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x00ab }
            if (r12 == 0) goto L_0x0090
            com.tonicsystems.jarjar.Zap r12 = new com.tonicsystems.jarjar.Zap     // Catch:{ all -> 0x00ab }
            r15 = r12
            r12 = r15
            r13 = r15
            r13.<init>()     // Catch:{ all -> 0x00ab }
            r9 = r12
            goto L_0x006c
        L_0x0090:
            r12 = r8
            java.lang.String r13 = "keep"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x00ab }
            if (r12 == 0) goto L_0x00a3
            com.tonicsystems.jarjar.Keep r12 = new com.tonicsystems.jarjar.Keep     // Catch:{ all -> 0x00ab }
            r15 = r12
            r12 = r15
            r13 = r15
            r13.<init>()     // Catch:{ all -> 0x00ab }
            r9 = r12
            goto L_0x006c
        L_0x00a3:
            r12 = r3
            r13 = r7
            error(r12, r13)     // Catch:{ all -> 0x00ab }
            r12 = 0
            r9 = r12
            goto L_0x006c
        L_0x00ab:
            r12 = move-exception
            r4 = r12
            r12 = r0
            r12.close()
            r12 = r4
            throw r12
        L_0x00b3:
            r12 = r0
            r12.close()
            r12 = r1
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonicsystems.jarjar.RulesFileParser.parse(java.io.Reader):java.util.List");
    }

    public static List<PatternElement> parse(String str) throws IOException {
        StringReader stringReader;
        StringReader stringReader2 = stringReader;
        StringReader stringReader3 = new StringReader(str);
        return parse((Reader) stringReader2);
    }

    private static String stripComment(String str) {
        String str2 = str;
        int indexOf = str2.indexOf("#");
        return indexOf < 0 ? str2 : str2.substring(0, indexOf);
    }
}
