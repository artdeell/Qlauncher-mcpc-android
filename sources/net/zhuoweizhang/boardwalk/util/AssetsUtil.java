package net.zhuoweizhang.boardwalk.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetsUtil {
    public AssetsUtil() {
    }

    public static void extractDirFromAssets(Context context, String str, File file) throws IOException {
        String str2 = str;
        File file2 = file;
        AssetManager assets = context.getAssets();
        extractDirImpl(assets, str2, assets.list(str2), file2, new byte[16384]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extractDirImpl(android.content.res.AssetManager r25, java.lang.String r26, java.lang.String[] r27, java.io.File r28, byte[] r29) throws java.io.IOException {
        /*
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r17 = r4
            r0 = r17
            int r0 = r0.length
            r17 = r0
            r7 = r17
            r17 = 0
            r8 = r17
        L_0x0017:
            r17 = r8
            r18 = r7
            r0 = r17
            r1 = r18
            if (r0 >= r1) goto L_0x0134
            r17 = r4
            r18 = r8
            r17 = r17[r18]
            r9 = r17
            java.io.PrintStream r17 = java.lang.System.out
            r18 = r9
            r17.println(r18)
            r17 = r2
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r24 = r18
            r18 = r24
            r19 = r24
            r19.<init>()
            r19 = r3
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r19 = "/"
            java.lang.StringBuilder r18 = r18.append(r19)
            r19 = r9
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r18 = r18.toString()
            java.lang.String[] r17 = r17.list(r18)
            r10 = r17
            r17 = r10
            r0 = r17
            int r0 = r0.length
            r17 = r0
            r18 = 1
            r0 = r17
            r1 = r18
            if (r0 < r1) goto L_0x00a5
            r17 = r2
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r24 = r18
            r18 = r24
            r19 = r24
            r19.<init>()
            r19 = r3
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r19 = "/"
            java.lang.StringBuilder r18 = r18.append(r19)
            r19 = r9
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r18 = r18.toString()
            r19 = r10
            java.io.File r20 = new java.io.File
            r24 = r20
            r20 = r24
            r21 = r24
            r22 = r5
            r23 = r9
            r21.<init>(r22, r23)
            r21 = r6
            extractDirImpl(r17, r18, r19, r20, r21)
        L_0x00a1:
            int r8 = r8 + 1
            goto L_0x0017
        L_0x00a5:
            r17 = 0
            r11 = r17
            r17 = 0
            r12 = r17
            java.io.File r17 = new java.io.File
            r24 = r17
            r17 = r24
            r18 = r24
            r19 = r5
            r20 = r9
            r18.<init>(r19, r20)
            r13 = r17
            r17 = r13
            java.io.File r17 = r17.getParentFile()
            boolean r17 = r17.mkdirs()
            r17 = r2
            java.lang.StringBuilder r18 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r24 = r18
            r18 = r24
            r19 = r24
            r19.<init>()     // Catch:{ all -> 0x011c }
            r19 = r3
            java.lang.StringBuilder r18 = r18.append(r19)     // Catch:{ all -> 0x011c }
            java.lang.String r19 = "/"
            java.lang.StringBuilder r18 = r18.append(r19)     // Catch:{ all -> 0x011c }
            r19 = r9
            java.lang.StringBuilder r18 = r18.append(r19)     // Catch:{ all -> 0x011c }
            java.lang.String r18 = r18.toString()     // Catch:{ all -> 0x011c }
            java.io.InputStream r17 = r17.open(r18)     // Catch:{ all -> 0x011c }
            r12 = r17
            java.io.FileOutputStream r17 = new java.io.FileOutputStream     // Catch:{ all -> 0x011c }
            r24 = r17
            r17 = r24
            r18 = r24
            r19 = r13
            r18.<init>(r19)     // Catch:{ all -> 0x011c }
            r16 = r17
            r17 = r12
            r18 = r16
            r19 = r6
            net.zhuoweizhang.boardwalk.util.IoUtil.pipe(r17, r18, r19)     // Catch:{ all -> 0x0135 }
            r17 = r12
            if (r17 == 0) goto L_0x0112
            r17 = r12
            r17.close()
        L_0x0112:
            r17 = r16
            if (r17 == 0) goto L_0x00a1
            r17 = r16
            r17.close()
            goto L_0x00a1
        L_0x011c:
            r17 = move-exception
            r15 = r17
        L_0x011f:
            r17 = r12
            if (r17 == 0) goto L_0x0128
            r17 = r12
            r17.close()
        L_0x0128:
            r17 = r11
            if (r17 == 0) goto L_0x0131
            r17 = r11
            r17.close()
        L_0x0131:
            r17 = r15
            throw r17
        L_0x0134:
            return
        L_0x0135:
            r17 = move-exception
            r15 = r17
            r17 = r16
            r11 = r17
            goto L_0x011f
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.util.AssetsUtil.extractDirImpl(android.content.res.AssetManager, java.lang.String, java.lang.String[], java.io.File, byte[]):void");
    }

    public static void extractFileFromAssets(Context context, String str, File file) throws IOException {
        FileOutputStream fileOutputStream;
        String str2 = str;
        File file2 = file;
        byte[] bArr = new byte[8192];
        InputStream open = context.getAssets().open(str2);
        boolean mkdirs = file2.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        IoUtil.pipe(open, fileOutputStream4, bArr);
        open.close();
        fileOutputStream4.close();
    }
}
