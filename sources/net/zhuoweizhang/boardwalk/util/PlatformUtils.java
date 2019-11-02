package net.zhuoweizhang.boardwalk.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class PlatformUtils {
    public PlatformUtils() {
    }

    public static int getAndroidVersion() {
        try {
            return Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getNumCores() {
        C07351 r6;
        File file;
        C07351 r3 = r6;
        C07351 r4 = new FileFilter() {
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]+", file.getName());
            }
        };
        C07351 r0 = r3;
        try {
            File file2 = file;
            File file3 = new File("/sys/devices/system/cpu/");
            return file2.listFiles(r0).length;
        } catch (Exception e) {
            Exception exc = e;
            return Math.max(1, Runtime.getRuntime().availableProcessors());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getTotalMemory() {
        /*
            r16 = 0
            r0 = r16
            r16 = 0
            r2 = r16
            java.io.BufferedReader r16 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0098, all -> 0x00b1 }
            r21 = r16
            r16 = r21
            r17 = r21
            java.io.FileReader r18 = new java.io.FileReader     // Catch:{ IOException -> 0x0098, all -> 0x00b1 }
            r21 = r18
            r18 = r21
            r19 = r21
            java.lang.String r20 = "/proc/meminfo"
            r19.<init>(r20)     // Catch:{ IOException -> 0x0098, all -> 0x00b1 }
            r17.<init>(r18)     // Catch:{ IOException -> 0x0098, all -> 0x00b1 }
            r3 = r16
            r16 = r3
            java.lang.String r16 = r16.readLine()     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            java.lang.String r16 = r16.trim()     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            r8 = r16
        L_0x002e:
            r16 = r8
            java.lang.String r17 = "  "
            java.lang.String r18 = " "
            java.lang.String r16 = r16.replaceAll(r17, r18)     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            r8 = r16
            r16 = r8
            java.lang.String r17 = "  "
            boolean r16 = r16.contains(r17)     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            if (r16 != 0) goto L_0x002e
            r16 = r8
            java.lang.String r17 = " "
            java.lang.String[] r16 = r16.split(r17)     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            r9 = r16
            r16 = r9
            r17 = 0
            r16 = r16[r17]     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            java.lang.String r17 = "MemTotal:"
            boolean r16 = r16.equals(r17)     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            r10 = r16
            r16 = r10
            if (r16 != 0) goto L_0x006e
            r16 = r3
            if (r16 == 0) goto L_0x0069
            r16 = r3
            r16.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x0069:
            r16 = r0
            r0 = r16
        L_0x006d:
            return r0
        L_0x006e:
            r16 = r9
            r17 = 1
            r16 = r16[r17]     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            long r16 = java.lang.Long.parseLong(r16)     // Catch:{ IOException -> 0x00d4, all -> 0x00cc }
            r11 = r16
            r16 = r11
            r18 = 1024(0x400, double:5.06E-321)
            long r16 = r16 * r18
            r0 = r16
            r16 = r3
            if (r16 == 0) goto L_0x0069
            r16 = r3
            r16.close()     // Catch:{ IOException -> 0x0090 }
            r16 = r0
            r0 = r16
            goto L_0x006d
        L_0x0090:
            r16 = move-exception
            r13 = r16
            r16 = r0
            r0 = r16
            goto L_0x006d
        L_0x0098:
            r16 = move-exception
            r15 = r16
        L_0x009b:
            r16 = r2
            if (r16 == 0) goto L_0x0069
            r16 = r2
            r16.close()     // Catch:{ IOException -> 0x00a9 }
            r16 = r0
            r0 = r16
            goto L_0x006d
        L_0x00a9:
            r16 = move-exception
            r5 = r16
            r16 = r0
            r0 = r16
            goto L_0x006d
        L_0x00b1:
            r16 = move-exception
            r6 = r16
        L_0x00b4:
            r16 = r2
            if (r16 == 0) goto L_0x00bd
            r16 = r2
            r16.close()     // Catch:{ IOException -> 0x00c8 }
        L_0x00bd:
            r16 = r6
            throw r16
        L_0x00c0:
            r16 = move-exception
            r14 = r16
            r16 = r0
            r0 = r16
            goto L_0x006d
        L_0x00c8:
            r16 = move-exception
            r7 = r16
            goto L_0x00bd
        L_0x00cc:
            r16 = move-exception
            r6 = r16
            r16 = r3
            r2 = r16
            goto L_0x00b4
        L_0x00d4:
            r16 = move-exception
            r4 = r16
            r16 = r3
            r2 = r16
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.util.PlatformUtils.getTotalMemory():long");
    }
}
