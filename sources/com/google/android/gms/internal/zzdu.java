package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzhb
public class zzdu extends zzdr {
    private static final Set<String> zzzX;
    private static final DecimalFormat zzzY;
    private boolean zzAa;
    private File zzzZ;

    static {
        HashSet hashSet;
        DecimalFormat decimalFormat;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        zzzX = Collections.synchronizedSet(hashSet2);
        DecimalFormat decimalFormat2 = decimalFormat;
        DecimalFormat decimalFormat3 = new DecimalFormat("#,###");
        zzzY = decimalFormat2;
    }

    public zzdu(zzjp zzjp) {
        File file;
        StringBuilder sb;
        StringBuilder sb2;
        super(zzjp);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzin.zzaK("Context.getCacheDir() returned null");
            return;
        }
        File file2 = file;
        File file3 = new File(cacheDir, "admobVideoStreams");
        this.zzzZ = file2;
        if (!this.zzzZ.isDirectory() && !this.zzzZ.mkdirs()) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            zzin.zzaK(sb3.append("Could not create preload cache directory at ").append(this.zzzZ.getAbsolutePath()).toString());
            this.zzzZ = null;
        } else if (!this.zzzZ.setReadable(true, false) || !this.zzzZ.setExecutable(true, false)) {
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            zzin.zzaK(sb5.append("Could not set cache file permissions at ").append(this.zzzZ.getAbsolutePath()).toString());
            this.zzzZ = null;
        }
    }

    private File zza(File file) {
        File file2;
        StringBuilder sb;
        File file3 = file;
        File file4 = file2;
        File file5 = this.zzzZ;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        File file6 = new File(file5, sb2.append(file3.getName()).append(".done").toString());
        return file4;
    }

    private static void zzb(File file) {
        File file2 = file;
        if (file2.isFile()) {
            boolean lastModified = file2.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            boolean createNewFile = file2.createNewFile();
        } catch (IOException e) {
            IOException iOException = e;
        }
    }

    public void abort() {
        this.zzAa = true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x04cd, code lost:
        throw r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x04ce, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x04cf, code lost:
        r12 = r50;
        r11 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x04df, code lost:
        if (r2.zzAa == false) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x04e1, code lost:
        r13 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r50 = r56;
        r51 = new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x04f2, code lost:
        throw r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x04f3, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x04f4, code lost:
        r12 = r50;
        r11 = r27;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0506, code lost:
        if (r36.tryAcquire() == false) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0508, code lost:
        zza(r3, r5.getAbsolutePath(), r31, r20, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x051d, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0528, code lost:
        if (com.google.android.gms.internal.zzin.zzQ(3) == false) goto L_0x0563;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x052a, code lost:
        r42 = zzzY.format((long) r31);
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaI(r50.append("Preloaded ").append(r42).append(" bytes from ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0563, code lost:
        r50 = r5.setReadable(true, false);
        zzb(r6);
        zza(r3, r5.getAbsolutePath(), r31);
        r50 = zzzX.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x058f, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzd(r50.append("Preload failed for URL \"").append(r3).append("\"").toString(), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x05b7, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x05b8, code lost:
        r17 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x05bc, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x05bd, code lost:
        r15 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x05c1, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x05c2, code lost:
        r12 = r50;
        r13 = "error";
        r14 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x05d2, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x05d3, code lost:
        r12 = r50;
        r14 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x05df, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x05e0, code lost:
        r12 = r50;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x05e8, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x05e9, code lost:
        r12 = r50;
        r13 = "error";
        r11 = r27;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x05f9, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x05fa, code lost:
        r12 = r50;
        r11 = r27;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0606, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0607, code lost:
        r12 = r50;
        r13 = "error";
        r14 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0617, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0618, code lost:
        r12 = r50;
        r14 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0624, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0625, code lost:
        r12 = r50;
        r13 = "error";
        r11 = r27;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0156, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r50 = r56;
        r51 = new java.net.URL(r3);
        r18 = r50.openConnection();
        r19 = ((java.lang.Integer) com.google.android.gms.internal.zzbt.zzvT.get()).intValue();
        r18.setConnectTimeout(r19);
        r18.setReadTimeout(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0191, code lost:
        if ((r18 instanceof java.net.HttpURLConnection) == false) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x019a, code lost:
        r47 = ((java.net.HttpURLConnection) r18).getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01a5, code lost:
        if (r47 < 400) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01a7, code lost:
        r13 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01c9, code lost:
        r14 = r50.append("HTTP request failed. Code: ").append(java.lang.Integer.toString(r47)).toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r50 = r56;
        r52 = r56;
        r53 = new java.lang.StringBuilder();
        r51 = new java.io.IOException(r52.append("HTTP status code ").append(r47).append(" at ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0202, code lost:
        throw r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0203, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0204, code lost:
        r12 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x020e, code lost:
        if ((r12 instanceof java.lang.RuntimeException) != false) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0210, code lost:
        com.google.android.gms.ads.internal.zzr.zzbF().zzb(r12, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0228, code lost:
        if (r2.zzAa == false) goto L_0x058f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x022a, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaJ(r50.append("Preload aborted for URL \"").append(r3).append("\"").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x025e, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaK(r50.append("Could not delete partial cache file at ").append(r5.getAbsolutePath()).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0280, code lost:
        zza(r3, r5.getAbsolutePath(), r13, r14);
        r50 = zzzX.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r20 = r18.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02a9, code lost:
        if (r20 >= 0) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02ab, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaK(r50.append("Stream cache aborted, missing content-length header at ").append(r3).toString());
        zza(r3, r5.getAbsolutePath(), "contentLengthMissing", null);
        r50 = zzzX.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02e8, code lost:
        r22 = zzzY.format((long) r20);
        r23 = ((java.lang.Integer) com.google.android.gms.internal.zzbt.zzvP.get()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x030d, code lost:
        if (r20 <= r23) goto L_0x0375;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x030f, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaK(r50.append("Content length ").append(r22).append(" exceeds limit at ").append(r3).toString());
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        zza(r3, r5.getAbsolutePath(), "sizeExceeded", r50.append("File too big for full file cache. Size: ").append(r22).toString());
        r50 = zzzX.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0375, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaI(r50.append("Caching ").append(r22).append(" bytes from ").append(r3).toString());
        r26 = java.nio.channels.Channels.newChannel(r18.getInputStream());
        r50 = r56;
        r51 = new java.io.FileOutputStream(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x03b8, code lost:
        r27 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r28 = r27.getChannel();
        r29 = java.nio.ByteBuffer.allocate(1048576);
        r30 = com.google.android.gms.ads.internal.zzr.zzbG();
        r31 = 0;
        r32 = r30.currentTimeMillis();
        r50 = r56;
        r51 = new com.google.android.gms.internal.zziz(((java.lang.Long) com.google.android.gms.internal.zzbt.zzvS.get()).longValue());
        r36 = r50;
        r37 = ((java.lang.Long) com.google.android.gms.internal.zzbt.zzvR.get()).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x040e, code lost:
        r39 = r26.read(r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0413, code lost:
        if (r39 < 0) goto L_0x051d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0415, code lost:
        r31 = r31 + r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0425, code lost:
        if (r31 <= r23) goto L_0x0467;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0427, code lost:
        r13 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0449, code lost:
        r14 = r50.append("File too big for full file cache. Size: ").append(java.lang.Integer.toString(r31)).toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r50 = r56;
        r51 = new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x045d, code lost:
        throw r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x045e, code lost:
        r50 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x045f, code lost:
        r12 = r50;
        r11 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r50 = r29.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0475, code lost:
        if (r28.write(r29) > 0) goto L_0x046d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0477, code lost:
        r50 = r29.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x048f, code lost:
        if ((r30.currentTimeMillis() - r32) <= (1000 * r37)) goto L_0x04d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0491, code lost:
        r13 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r50 = r56;
        r51 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x04b9, code lost:
        r14 = r50.append("Timeout exceeded. Limit: ").append(java.lang.Long.toString(r37)).append(" sec").toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r50 = r56;
        r51 = new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzU(java.lang.String r58) {
        /*
            r57 = this;
            r2 = r57
            r3 = r58
            r50 = r2
            r0 = r50
            java.io.File r0 = r0.zzzZ
            r50 = r0
            if (r50 != 0) goto L_0x0020
            r50 = r2
            r51 = r3
            r52 = 0
            java.lang.String r53 = "noCacheDir"
            r54 = 0
            r50.zza(r51, r52, r53, r54)
            r50 = 0
            r2 = r50
        L_0x001f:
            return r2
        L_0x0020:
            r50 = r2
            int r50 = r50.zzea()
            com.google.android.gms.internal.zzbp<java.lang.Integer> r51 = com.google.android.gms.internal.zzbt.zzvO
            java.lang.Object r51 = r51.get()
            java.lang.Integer r51 = (java.lang.Integer) r51
            int r51 = r51.intValue()
            r0 = r50
            r1 = r51
            if (r0 <= r1) goto L_0x0057
            r50 = r2
            boolean r50 = r50.zzeb()
            if (r50 != 0) goto L_0x0020
            java.lang.String r50 = "Unable to expire stream cache"
            com.google.android.gms.internal.zzin.zzaK(r50)
            r50 = r2
            r51 = r3
            r52 = 0
            java.lang.String r53 = "expireFailed"
            r54 = 0
            r50.zza(r51, r52, r53, r54)
            r50 = 0
            r2 = r50
            goto L_0x001f
        L_0x0057:
            r50 = r2
            r51 = r3
            java.lang.String r50 = r50.zzV(r51)
            r4 = r50
            java.io.File r50 = new java.io.File
            r56 = r50
            r50 = r56
            r51 = r56
            r52 = r2
            r0 = r52
            java.io.File r0 = r0.zzzZ
            r52 = r0
            r53 = r4
            r51.<init>(r52, r53)
            r5 = r50
            r50 = r2
            r51 = r5
            java.io.File r50 = r50.zza(r51)
            r6 = r50
            r50 = r5
            boolean r50 = r50.isFile()
            if (r50 == 0) goto L_0x00d2
            r50 = r6
            boolean r50 = r50.isFile()
            if (r50 == 0) goto L_0x00d2
            r50 = r5
            long r50 = r50.length()
            r0 = r50
            int r0 = (int) r0
            r50 = r0
            r49 = r50
            java.lang.StringBuilder r50 = new java.lang.StringBuilder
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()
            java.lang.String r51 = "Stream cache hit at "
            java.lang.StringBuilder r50 = r50.append(r51)
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r50 = r50.toString()
            com.google.android.gms.internal.zzin.zzaI(r50)
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()
            r53 = r49
            r50.zza(r51, r52, r53)
            r50 = 1
            r2 = r50
            goto L_0x001f
        L_0x00d2:
            java.lang.StringBuilder r50 = new java.lang.StringBuilder
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()
            r51 = r2
            r0 = r51
            java.io.File r0 = r0.zzzZ
            r51 = r0
            java.lang.String r51 = r51.getAbsolutePath()
            java.lang.StringBuilder r50 = r50.append(r51)
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r50 = r50.toString()
            r7 = r50
            java.util.Set<java.lang.String> r50 = zzzX
            r8 = r50
            r50 = r8
            monitor-enter(r50)
            java.util.Set<java.lang.String> r50 = zzzX     // Catch:{ all -> 0x0142 }
            r51 = r7
            boolean r50 = r50.contains(r51)     // Catch:{ all -> 0x0142 }
            if (r50 == 0) goto L_0x014b
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r51 = "Stream cache already in progress at "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ all -> 0x0142 }
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ all -> 0x0142 }
            java.lang.String r50 = r50.toString()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.zzin.zzaK(r50)     // Catch:{ all -> 0x0142 }
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            java.lang.String r53 = "inProgress"
            r54 = 0
            r50.zza(r51, r52, r53, r54)     // Catch:{ all -> 0x0142 }
            r50 = r8
            monitor-exit(r50)     // Catch:{ all -> 0x0142 }
            r50 = 0
            r2 = r50
            goto L_0x001f
        L_0x0142:
            r50 = move-exception
            r9 = r50
            r50 = r8
            monitor-exit(r50)     // Catch:{ all -> 0x0142 }
            r50 = r9
            throw r50
        L_0x014b:
            java.util.Set<java.lang.String> r50 = zzzX     // Catch:{ all -> 0x0142 }
            r51 = r7
            boolean r50 = r50.add(r51)     // Catch:{ all -> 0x0142 }
            r50 = r8
            monitor-exit(r50)     // Catch:{ all -> 0x0142 }
            r50 = 0
            r11 = r50
            java.net.URL r50 = new java.net.URL     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r52 = r3
            r51.<init>(r52)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.net.URLConnection r50 = r50.openConnection()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r18 = r50
            com.google.android.gms.internal.zzbp<java.lang.Integer> r50 = com.google.android.gms.internal.zzbt.zzvT     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.Object r50 = r50.get()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.Integer r50 = (java.lang.Integer) r50     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            int r50 = r50.intValue()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r19 = r50
            r50 = r18
            r51 = r19
            r50.setConnectTimeout(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = r18
            r51 = r19
            r50.setReadTimeout(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = r18
            r0 = r50
            boolean r0 = r0 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = r0
            if (r50 == 0) goto L_0x029f
            r50 = r18
            java.net.HttpURLConnection r50 = (java.net.HttpURLConnection) r50     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            int r50 = r50.getResponseCode()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r47 = r50
            r50 = r47
            r51 = 400(0x190, float:5.6E-43)
            r0 = r50
            r1 = r51
            if (r0 < r1) goto L_0x029f
            java.lang.String r50 = "badUrl"
            r13 = r50
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            java.lang.String r51 = "HTTP request failed. Code: "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            r51 = r47
            java.lang.String r51 = java.lang.Integer.toString(r51)     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0617, RuntimeException -> 0x05d2 }
            r48 = r50
            r50 = r48
            r14 = r50
            java.io.IOException r50 = new java.io.IOException     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            r56 = r50
            r50 = r56
            r51 = r56
            java.lang.StringBuilder r52 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            r56 = r52
            r52 = r56
            r53 = r56
            r53.<init>()     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            java.lang.String r53 = "HTTP status code "
            java.lang.StringBuilder r52 = r52.append(r53)     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            r53 = r47
            java.lang.StringBuilder r52 = r52.append(r53)     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            java.lang.String r53 = " at "
            java.lang.StringBuilder r52 = r52.append(r53)     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            r53 = r3
            java.lang.StringBuilder r52 = r52.append(r53)     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            java.lang.String r52 = r52.toString()     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            r51.<init>(r52)     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
            throw r50     // Catch:{ IOException -> 0x0203, RuntimeException -> 0x05df }
        L_0x0203:
            r50 = move-exception
            r12 = r50
        L_0x0206:
            r50 = r12
            r0 = r50
            boolean r0 = r0 instanceof java.lang.RuntimeException
            r50 = r0
            if (r50 == 0) goto L_0x021b
            com.google.android.gms.internal.zzih r50 = com.google.android.gms.ads.internal.zzr.zzbF()
            r51 = r12
            r52 = 1
            r50.zzb(r51, r52)
        L_0x021b:
            r50 = r11
            r50.close()     // Catch:{ IOException -> 0x05b7, NullPointerException -> 0x05bc }
        L_0x0220:
            r50 = r2
            r0 = r50
            boolean r0 = r0.zzAa
            r50 = r0
            if (r50 == 0) goto L_0x058f
            java.lang.StringBuilder r50 = new java.lang.StringBuilder
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()
            java.lang.String r51 = "Preload aborted for URL \""
            java.lang.StringBuilder r50 = r50.append(r51)
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r51 = "\""
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r50 = r50.toString()
            com.google.android.gms.internal.zzin.zzaJ(r50)
        L_0x024e:
            r50 = r5
            boolean r50 = r50.exists()
            if (r50 == 0) goto L_0x0280
            r50 = r5
            boolean r50 = r50.delete()
            if (r50 != 0) goto L_0x0280
            java.lang.StringBuilder r50 = new java.lang.StringBuilder
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()
            java.lang.String r51 = "Could not delete partial cache file at "
            java.lang.StringBuilder r50 = r50.append(r51)
            r51 = r5
            java.lang.String r51 = r51.getAbsolutePath()
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r50 = r50.toString()
            com.google.android.gms.internal.zzin.zzaK(r50)
        L_0x0280:
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()
            r53 = r13
            r54 = r14
            r50.zza(r51, r52, r53, r54)
            java.util.Set<java.lang.String> r50 = zzzX
            r51 = r7
            boolean r50 = r50.remove(r51)
            r50 = 0
            r2 = r50
            goto L_0x001f
        L_0x029f:
            r50 = r18
            int r50 = r50.getContentLength()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r20 = r50
            r50 = r20
            if (r50 >= 0) goto L_0x02e8
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = "Stream cache aborted, missing content-length header at "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            com.google.android.gms.internal.zzin.zzaK(r50)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r53 = "contentLengthMissing"
            r54 = 0
            r50.zza(r51, r52, r53, r54)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.util.Set<java.lang.String> r50 = zzzX     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r7
            boolean r50 = r50.remove(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = 0
            r2 = r50
            goto L_0x001f
        L_0x02e8:
            java.text.DecimalFormat r50 = zzzY     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r20
            r0 = r51
            long r0 = (long) r0     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r0
            java.lang.String r50 = r50.format(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r22 = r50
            com.google.android.gms.internal.zzbp<java.lang.Integer> r50 = com.google.android.gms.internal.zzbt.zzvP     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.Object r50 = r50.get()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.Integer r50 = (java.lang.Integer) r50     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            int r50 = r50.intValue()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r23 = r50
            r50 = r20
            r51 = r23
            r0 = r50
            r1 = r51
            if (r0 <= r1) goto L_0x0375
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = "Content length "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r22
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = " exceeds limit at "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            com.google.android.gms.internal.zzin.zzaK(r50)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = "File too big for full file cache. Size: "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r22
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r24 = r50
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r53 = "sizeExceeded"
            r54 = r24
            r50.zza(r51, r52, r53, r54)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.util.Set<java.lang.String> r50 = zzzX     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r7
            boolean r50 = r50.remove(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = 0
            r2 = r50
            goto L_0x001f
        L_0x0375:
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = "Caching "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r22
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r51 = " bytes from "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            com.google.android.gms.internal.zzin.zzaI(r50)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r50 = r18
            java.io.InputStream r50 = r50.getInputStream()     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            java.nio.channels.ReadableByteChannel r50 = java.nio.channels.Channels.newChannel(r50)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r26 = r50
            java.io.FileOutputStream r50 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r56 = r50
            r50 = r56
            r51 = r56
            r52 = r5
            r51.<init>(r52)     // Catch:{ IOException -> 0x0606, RuntimeException -> 0x05c1 }
            r27 = r50
            r50 = r27
            java.nio.channels.FileChannel r50 = r50.getChannel()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r28 = r50
            r50 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r50 = java.nio.ByteBuffer.allocate(r50)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r29 = r50
            com.google.android.gms.internal.zzmq r50 = com.google.android.gms.ads.internal.zzr.zzbG()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r30 = r50
            r50 = 0
            r31 = r50
            r50 = r30
            long r50 = r50.currentTimeMillis()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r32 = r50
            com.google.android.gms.internal.zzbp<java.lang.Long> r50 = com.google.android.gms.internal.zzbt.zzvS     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.Object r50 = r50.get()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.Long r50 = (java.lang.Long) r50     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            long r50 = r50.longValue()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r34 = r50
            com.google.android.gms.internal.zziz r50 = new com.google.android.gms.internal.zziz     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r56 = r50
            r50 = r56
            r51 = r56
            r52 = r34
            r51.<init>(r52)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r36 = r50
            com.google.android.gms.internal.zzbp<java.lang.Long> r50 = com.google.android.gms.internal.zzbt.zzvR     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.Object r50 = r50.get()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.Long r50 = (java.lang.Long) r50     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            long r50 = r50.longValue()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r37 = r50
        L_0x0407:
            r50 = r26
            r51 = r29
            int r50 = r50.read(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r39 = r50
            r50 = r39
            if (r50 < 0) goto L_0x051d
            r50 = r31
            r51 = r39
            int r50 = r50 + r51
            r31 = r50
            r50 = r31
            r51 = r23
            r0 = r50
            r1 = r51
            if (r0 <= r1) goto L_0x0467
            java.lang.String r50 = "sizeExceeded"
            r13 = r50
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.String r51 = "File too big for full file cache. Size: "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r51 = r31
            java.lang.String r51 = java.lang.Integer.toString(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r46 = r50
            r50 = r46
            r14 = r50
            java.io.IOException r50 = new java.io.IOException     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
            r56 = r50
            r50 = r56
            r51 = r56
            java.lang.String r52 = "stream cache file size limit exceeded"
            r51.<init>(r52)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
            throw r50     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
        L_0x045e:
            r50 = move-exception
            r12 = r50
            r50 = r27
            r11 = r50
            goto L_0x0206
        L_0x0467:
            r50 = r29
            java.nio.Buffer r50 = r50.flip()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
        L_0x046d:
            r50 = r28
            r51 = r29
            int r50 = r50.write(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            if (r50 > 0) goto L_0x046d
            r50 = r29
            java.nio.Buffer r50 = r50.clear()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = r30
            long r50 = r50.currentTimeMillis()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r52 = r32
            long r50 = r50 - r52
            r52 = 1000(0x3e8, double:4.94E-321)
            r54 = r37
            long r52 = r52 * r54
            int r50 = (r50 > r52 ? 1 : (r50 == r52 ? 0 : -1))
            if (r50 <= 0) goto L_0x04d7
            java.lang.String r50 = "downloadTimeout"
            r13 = r50
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.String r51 = "Timeout exceeded. Limit: "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r51 = r37
            java.lang.String r51 = java.lang.Long.toString(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.String r51 = " sec"
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r45 = r50
            r50 = r45
            r14 = r50
            java.io.IOException r50 = new java.io.IOException     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
            r56 = r50
            r50 = r56
            r51 = r56
            java.lang.String r52 = "stream cache time limit exceeded"
            r51.<init>(r52)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
            throw r50     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x04ce }
        L_0x04ce:
            r50 = move-exception
            r12 = r50
            r50 = r27
            r11 = r50
            goto L_0x0206
        L_0x04d7:
            r50 = r2
            r0 = r50
            boolean r0 = r0.zzAa     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = r0
            if (r50 == 0) goto L_0x0500
            java.lang.String r50 = "externalAbort"
            r13 = r50
            java.io.IOException r50 = new java.io.IOException     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            r56 = r50
            r50 = r56
            r51 = r56
            java.lang.String r52 = "abort requested"
            r51.<init>(r52)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
            throw r50     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x05f9 }
        L_0x04f3:
            r50 = move-exception
            r12 = r50
            r50 = r27
            r11 = r50
            r50 = 0
            r14 = r50
            goto L_0x0206
        L_0x0500:
            r50 = r36
            boolean r50 = r50.tryAcquire()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            if (r50 == 0) goto L_0x0407
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r53 = r31
            r54 = r20
            r55 = 0
            r50.zza(r51, r52, r53, r54, r55)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            goto L_0x0407
        L_0x051d:
            r50 = r27
            r50.close()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = 3
            boolean r50 = com.google.android.gms.internal.zzin.zzQ(r50)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            if (r50 == 0) goto L_0x0563
            java.text.DecimalFormat r50 = zzzY     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r51 = r31
            r0 = r51
            long r0 = (long) r0     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r51 = r0
            java.lang.String r50 = r50.format(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r42 = r50
            java.lang.StringBuilder r50 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.String r51 = "Preloaded "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r51 = r42
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.String r51 = " bytes from "
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.lang.String r50 = r50.toString()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            com.google.android.gms.internal.zzin.zzaI(r50)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
        L_0x0563:
            r50 = r5
            r51 = 1
            r52 = 0
            boolean r50 = r50.setReadable(r51, r52)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = r6
            zzb(r50)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = r2
            r51 = r3
            r52 = r5
            java.lang.String r52 = r52.getAbsolutePath()     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r53 = r31
            r50.zza(r51, r52, r53)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            java.util.Set<java.lang.String> r50 = zzzX     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r51 = r7
            boolean r50 = r50.remove(r51)     // Catch:{ IOException -> 0x0624, RuntimeException -> 0x05e8 }
            r50 = 1
            r2 = r50
            goto L_0x001f
        L_0x058f:
            java.lang.StringBuilder r50 = new java.lang.StringBuilder
            r56 = r50
            r50 = r56
            r51 = r56
            r51.<init>()
            java.lang.String r51 = "Preload failed for URL \""
            java.lang.StringBuilder r50 = r50.append(r51)
            r51 = r3
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r51 = "\""
            java.lang.StringBuilder r50 = r50.append(r51)
            java.lang.String r50 = r50.toString()
            r51 = r12
            com.google.android.gms.internal.zzin.zzd(r50, r51)
            goto L_0x024e
        L_0x05b7:
            r50 = move-exception
            r17 = r50
            goto L_0x0220
        L_0x05bc:
            r50 = move-exception
            r15 = r50
            goto L_0x0220
        L_0x05c1:
            r50 = move-exception
            r12 = r50
            java.lang.String r50 = "error"
            r13 = r50
            r50 = 0
            r14 = r50
            r50 = 0
            r11 = r50
            goto L_0x0206
        L_0x05d2:
            r50 = move-exception
            r12 = r50
            r50 = 0
            r14 = r50
            r50 = 0
            r11 = r50
            goto L_0x0206
        L_0x05df:
            r50 = move-exception
            r12 = r50
            r50 = 0
            r11 = r50
            goto L_0x0206
        L_0x05e8:
            r50 = move-exception
            r12 = r50
            java.lang.String r50 = "error"
            r13 = r50
            r50 = r27
            r11 = r50
            r50 = 0
            r14 = r50
            goto L_0x0206
        L_0x05f9:
            r50 = move-exception
            r12 = r50
            r50 = r27
            r11 = r50
            r50 = 0
            r14 = r50
            goto L_0x0206
        L_0x0606:
            r50 = move-exception
            r12 = r50
            java.lang.String r50 = "error"
            r13 = r50
            r50 = 0
            r14 = r50
            r50 = 0
            r11 = r50
            goto L_0x0206
        L_0x0617:
            r50 = move-exception
            r12 = r50
            r50 = 0
            r14 = r50
            r50 = 0
            r11 = r50
            goto L_0x0206
        L_0x0624:
            r50 = move-exception
            r12 = r50
            java.lang.String r50 = "error"
            r13 = r50
            r50 = r27
            r11 = r50
            r50 = 0
            r14 = r50
            goto L_0x0206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdu.zzU(java.lang.String):boolean");
    }

    public int zzea() {
        int i = 0;
        if (this.zzzZ != null) {
            File[] listFiles = this.zzzZ.listFiles();
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!listFiles[i2].getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzeb() {
        boolean z;
        long j;
        File file;
        if (this.zzzZ == null) {
            return false;
        }
        File file2 = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.zzzZ.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                j = file3.lastModified();
                if (j < j2) {
                    file = file3;
                    i++;
                    file2 = file;
                    j2 = j;
                }
            }
            j = j2;
            file = file2;
            i++;
            file2 = file;
            j2 = j;
        }
        if (file2 != null) {
            z = file2.delete();
            File zza = zza(file2);
            if (zza.isFile()) {
                z &= zza.delete();
            }
        } else {
            z = false;
        }
        return z;
    }
}
