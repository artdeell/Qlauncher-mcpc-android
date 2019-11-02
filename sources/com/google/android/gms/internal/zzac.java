package com.google.android.gms.internal;

import android.content.Context;

public class zzac {
    public static zzl zza(Context context) {
        return zza(context, null);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r12v2, types: [com.google.android.gms.internal.zzy] */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r15v5 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzl zza(android.content.Context r16, com.google.android.gms.internal.zzy r17) {
        /*
            r0 = r16
            r1 = r17
            java.io.File r10 = new java.io.File
            r15 = r10
            r10 = r15
            r11 = r15
            r12 = r0
            java.io.File r12 = r12.getCacheDir()
            java.lang.String r13 = "volley"
            r11.<init>(r12, r13)
            r2 = r10
            java.lang.String r10 = "volley/0"
            r3 = r10
            r10 = r0
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x008f }
            r7 = r10
            r10 = r0
            android.content.pm.PackageManager r10 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008f }
            r11 = r7
            r12 = 0
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r11, r12)     // Catch:{ NameNotFoundException -> 0x008f }
            r8 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x008f }
            r15 = r10
            r10 = r15
            r11 = r15
            r11.<init>()     // Catch:{ NameNotFoundException -> 0x008f }
            r11 = r7
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ NameNotFoundException -> 0x008f }
            java.lang.String r11 = "/"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ NameNotFoundException -> 0x008f }
            r11 = r8
            int r11 = r11.versionCode     // Catch:{ NameNotFoundException -> 0x008f }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ NameNotFoundException -> 0x008f }
            java.lang.String r10 = r10.toString()     // Catch:{ NameNotFoundException -> 0x008f }
            r9 = r10
            r10 = r9
            r3 = r10
        L_0x004a:
            r10 = r1
            if (r10 != 0) goto L_0x005c
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 9
            if (r10 < r11) goto L_0x0080
            com.google.android.gms.internal.zzz r10 = new com.google.android.gms.internal.zzz
            r15 = r10
            r10 = r15
            r11 = r15
            r11.<init>()
            r1 = r10
        L_0x005c:
            com.google.android.gms.internal.zzt r10 = new com.google.android.gms.internal.zzt
            r15 = r10
            r10 = r15
            r11 = r15
            r12 = r1
            r11.<init>(r12)
            r5 = r10
            com.google.android.gms.internal.zzl r10 = new com.google.android.gms.internal.zzl
            r15 = r10
            r10 = r15
            r11 = r15
            com.google.android.gms.internal.zzv r12 = new com.google.android.gms.internal.zzv
            r15 = r12
            r12 = r15
            r13 = r15
            r14 = r2
            r13.<init>(r14)
            r13 = r5
            r11.<init>(r12, r13)
            r6 = r10
            r10 = r6
            r10.start()
            r10 = r6
            r0 = r10
            return r0
        L_0x0080:
            com.google.android.gms.internal.zzw r10 = new com.google.android.gms.internal.zzw
            r15 = r10
            r10 = r15
            r11 = r15
            r12 = r3
            android.net.http.AndroidHttpClient r12 = android.net.http.AndroidHttpClient.newInstance(r12)
            r11.<init>(r12)
            r1 = r10
            goto L_0x005c
        L_0x008f:
            r10 = move-exception
            r4 = r10
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzac.zza(android.content.Context, com.google.android.gms.internal.zzy):com.google.android.gms.internal.zzl");
    }
}
