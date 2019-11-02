package com.google.android.gms.internal;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.internal.zzb.zza;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzao = CommonStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private static int zzap = 4096;
    protected final zzy zzaq;
    protected final zzu zzar;

    public zzt(zzy zzy) {
        zzu zzu;
        zzy zzy2 = zzy;
        zzu zzu2 = zzu;
        zzu zzu3 = new zzu(zzap);
        this(zzy2, zzu2);
    }

    public zzt(zzy zzy, zzu zzu) {
        zzu zzu2 = zzu;
        this.zzaq = zzy;
        this.zzar = zzu2;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap;
        Header[] headerArr2 = headerArr;
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        TreeMap treeMap4 = treeMap2;
        for (int i = 0; i < headerArr2.length; i++) {
            Object put = treeMap4.put(headerArr2[i].getName(), headerArr2[i].getValue());
        }
        return treeMap4;
    }

    private void zza(long j, zzk<?> zzk, byte[] bArr, StatusLine statusLine) {
        long j2 = j;
        zzk<?> zzk2 = zzk;
        byte[] bArr2 = bArr;
        StatusLine statusLine2 = statusLine;
        if (DEBUG || j2 > ((long) zzao)) {
            Object[] objArr = new Object[5];
            objArr[0] = zzk2;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = bArr2 != null ? Integer.valueOf(bArr2.length) : "null";
            objArr[3] = Integer.valueOf(statusLine2.getStatusCode());
            objArr[4] = Integer.valueOf(zzk2.zzu().zze());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void zza(String str, zzk<?> zzk, zzr zzr) throws zzr {
        String str2 = str;
        zzk<?> zzk2 = zzk;
        zzr zzr2 = zzr;
        zzo zzu = zzk2.zzu();
        int zzt = zzk2.zzt();
        try {
            zzu.zza(zzr2);
            zzk2.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str2, Integer.valueOf(zzt)}));
        } catch (zzr e) {
            zzr zzr3 = e;
            zzk2.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str2, Integer.valueOf(zzt)}));
            throw zzr3;
        }
    }

    private void zza(Map<String, String> map, zza zza) {
        Date date;
        Map<String, String> map2 = map;
        zza zza2 = zza;
        if (zza2 != null) {
            if (zza2.zzb != null) {
                Object put = map2.put("If-None-Match", zza2.zzb);
            }
            if (zza2.zzd > 0) {
                Date date2 = date;
                Date date3 = new Date(zza2.zzd);
                Object put2 = map2.put("If-Modified-Since", DateUtils.formatDate(date2));
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaa;
        zzp zzp;
        HttpEntity httpEntity2 = httpEntity;
        zzaa zzaa2 = zzaa;
        zzaa zzaa3 = new zzaa(this.zzar, (int) httpEntity2.getContentLength());
        zzaa zzaa4 = zzaa2;
        byte[] bArr = null;
        try {
            InputStream content = httpEntity2.getContent();
            bArr = null;
            if (content == null) {
                zzp zzp2 = zzp;
                zzp zzp3 = new zzp();
                throw zzp2;
            }
            byte[] zzb = this.zzar.zzb(1024);
            while (true) {
                int read = content.read(zzb);
                if (read == -1) {
                    break;
                }
                zzaa4.write(zzb, 0, read);
            }
            byte[] byteArray = zzaa4.toByteArray();
            try {
                httpEntity2.consumeContent();
            } catch (IOException e) {
                IOException iOException = e;
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzar.zza(zzb);
            zzaa4.close();
            return byteArray;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                httpEntity2.consumeContent();
            } catch (IOException e2) {
                IOException iOException2 = e2;
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzar.zza(bArr);
            zzaa4.close();
            throw th2;
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.zzh.<init>(com.google.android.gms.internal.zzi):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0114, code lost:
        r26 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0115, code lost:
        r16 = r26;
        r27 = r3;
        r28 = r36;
        r29 = new com.google.android.gms.internal.zzq();
        zza("socket", r27, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x015d, code lost:
        r26 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015e, code lost:
        r15 = r26;
        r27 = r3;
        r28 = r36;
        r29 = new com.google.android.gms.internal.zzq();
        zza("connection", r27, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0174, code lost:
        r26 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0175, code lost:
        r14 = r26;
        r26 = r36;
        r28 = r36;
        r29 = new java.lang.StringBuilder();
        r27 = new java.lang.RuntimeException(r28.append("Bad URL ").append(r3.getUrl()).toString(), r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01a3, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01a4, code lost:
        r26 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a5, code lost:
        r9 = r26;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01af, code lost:
        r11 = r6.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzs.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r11), r3.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01e6, code lost:
        if (r10 != null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01e8, code lost:
        r26 = r36;
        r27 = new com.google.android.gms.internal.zzi(r11, r10, r7, false, android.os.SystemClock.elapsedRealtime() - r4);
        r13 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x020d, code lost:
        if (r11 == 401) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0219, code lost:
        r27 = r3;
        r28 = r36;
        r29 = new com.google.android.gms.internal.zza(r13);
        zza("auth", r27, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x022f, code lost:
        r26 = r36;
        r27 = new com.google.android.gms.internal.zzj(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x023c, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x023d, code lost:
        r26 = r36;
        r27 = new com.google.android.gms.internal.zzp(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x024a, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x024b, code lost:
        r26 = r36;
        r27 = new com.google.android.gms.internal.zzh((com.google.android.gms.internal.zzi) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0258, code lost:
        throw r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0259, code lost:
        r26 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x025a, code lost:
        r9 = r26;
        r6 = r17;
        r10 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0114 A[ExcHandler: SocketTimeoutException (r26v31 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015d A[ExcHandler: ConnectTimeoutException (r26v29 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0174 A[ExcHandler: MalformedURLException (r26v26 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x022f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk<?> r38) throws com.google.android.gms.internal.zzr {
        /*
            r37 = this;
            r2 = r37
            r3 = r38
            long r26 = android.os.SystemClock.elapsedRealtime()
            r4 = r26
        L_0x000a:
            r26 = 0
            r6 = r26
            java.util.Map r26 = java.util.Collections.emptyMap()
            r7 = r26
            java.util.HashMap r26 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r36 = r26
            r26 = r36
            r27 = r36
            r27.<init>()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r8 = r26
            r26 = r2
            r27 = r8
            r28 = r3
            com.google.android.gms.internal.zzb$zza r28 = r28.zzi()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r26.zza(r27, r28)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r26 = r2
            r0 = r26
            com.google.android.gms.internal.zzy r0 = r0.zzaq     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r26 = r0
            r27 = r3
            r28 = r8
            org.apache.http.HttpResponse r26 = r26.zza(r27, r28)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x01a4 }
            r17 = r26
            r26 = r17
            org.apache.http.StatusLine r26 = r26.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r18 = r26
            r26 = r18
            int r26 = r26.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r19 = r26
            r26 = r17
            org.apache.http.Header[] r26 = r26.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            java.util.Map r26 = zza(r26)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r7 = r26
            r26 = r19
            r27 = 304(0x130, float:4.26E-43)
            r0 = r26
            r1 = r27
            if (r0 != r1) goto L_0x00c7
            r26 = r3
            com.google.android.gms.internal.zzb$zza r26 = r26.zzi()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r20 = r26
            r26 = r20
            if (r26 != 0) goto L_0x0090
            com.google.android.gms.internal.zzi r26 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = 304(0x130, float:4.26E-43)
            r29 = 0
            r30 = r7
            r31 = 1
            long r32 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r34 = r4
            long r32 = r32 - r34
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r2 = r26
        L_0x008f:
            return r2
        L_0x0090:
            r26 = r20
            r0 = r26
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.zzg     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r26 = r0
            r27 = r7
            r26.putAll(r27)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            com.google.android.gms.internal.zzi r26 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = 304(0x130, float:4.26E-43)
            r29 = r20
            r0 = r29
            byte[] r0 = r0.data     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r29 = r0
            r30 = r20
            r0 = r30
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.zzg     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r30 = r0
            r31 = 1
            long r32 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r34 = r4
            long r32 = r32 - r34
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r2 = r26
            goto L_0x008f
        L_0x00c7:
            r26 = r17
            org.apache.http.HttpEntity r26 = r26.getEntity()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            if (r26 == 0) goto L_0x012b
            r26 = r2
            r27 = r17
            org.apache.http.HttpEntity r27 = r27.getEntity()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            byte[] r26 = r26.zza(r27)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r25 = r26
            r26 = r25
            r21 = r26
        L_0x00e1:
            r26 = r2
            long r27 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r29 = r4
            long r27 = r27 - r29
            r29 = r3
            r30 = r21
            r31 = r18
            r26.zza(r27, r29, r30, r31)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r26 = r19
            r27 = 200(0xc8, float:2.8E-43)
            r0 = r26
            r1 = r27
            if (r0 < r1) goto L_0x0108
            r26 = r19
            r27 = 299(0x12b, float:4.19E-43)
            r0 = r26
            r1 = r27
            if (r0 <= r1) goto L_0x0136
        L_0x0108:
            java.io.IOException r26 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r36 = r26
            r26 = r36
            r27 = r36
            r27.<init>()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            throw r26     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
        L_0x0114:
            r26 = move-exception
            r16 = r26
            java.lang.String r26 = "socket"
            r27 = r3
            com.google.android.gms.internal.zzq r28 = new com.google.android.gms.internal.zzq
            r36 = r28
            r28 = r36
            r29 = r36
            r29.<init>()
            zza(r26, r27, r28)
            goto L_0x000a
        L_0x012b:
            r26 = 0
            r0 = r26
            byte[] r0 = new byte[r0]     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0259 }
            r26 = r0
            r21 = r26
            goto L_0x00e1
        L_0x0136:
            long r26 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r28 = r4
            long r26 = r26 - r28
            r22 = r26
            com.google.android.gms.internal.zzi r26 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = r19
            r29 = r21
            r30 = r7
            r31 = 0
            r32 = r22
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ SocketTimeoutException -> 0x0114, ConnectTimeoutException -> 0x015d, MalformedURLException -> 0x0174, IOException -> 0x0266 }
            r24 = r26
            r26 = r24
            r2 = r26
            goto L_0x008f
        L_0x015d:
            r26 = move-exception
            r15 = r26
            java.lang.String r26 = "connection"
            r27 = r3
            com.google.android.gms.internal.zzq r28 = new com.google.android.gms.internal.zzq
            r36 = r28
            r28 = r36
            r29 = r36
            r29.<init>()
            zza(r26, r27, r28)
            goto L_0x000a
        L_0x0174:
            r26 = move-exception
            r14 = r26
            java.lang.RuntimeException r26 = new java.lang.RuntimeException
            r36 = r26
            r26 = r36
            r27 = r36
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r36 = r28
            r28 = r36
            r29 = r36
            r29.<init>()
            java.lang.String r29 = "Bad URL "
            java.lang.StringBuilder r28 = r28.append(r29)
            r29 = r3
            java.lang.String r29 = r29.getUrl()
            java.lang.StringBuilder r28 = r28.append(r29)
            java.lang.String r28 = r28.toString()
            r29 = r14
            r27.<init>(r28, r29)
            throw r26
        L_0x01a4:
            r26 = move-exception
            r9 = r26
            r26 = 0
            r10 = r26
        L_0x01ab:
            r26 = r6
            if (r26 == 0) goto L_0x022f
            r26 = r6
            org.apache.http.StatusLine r26 = r26.getStatusLine()
            int r26 = r26.getStatusCode()
            r11 = r26
            r26 = 2
            r0 = r26
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r26 = r0
            r12 = r26
            r26 = r12
            r27 = 0
            r28 = r11
            java.lang.Integer r28 = java.lang.Integer.valueOf(r28)
            r26[r27] = r28
            r26 = r12
            r27 = 1
            r28 = r3
            java.lang.String r28 = r28.getUrl()
            r26[r27] = r28
            java.lang.String r26 = "Unexpected response code %d for %s"
            r27 = r12
            com.google.android.gms.internal.zzs.zzc(r26, r27)
            r26 = r10
            if (r26 == 0) goto L_0x024b
            com.google.android.gms.internal.zzi r26 = new com.google.android.gms.internal.zzi
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = r11
            r29 = r10
            r30 = r7
            r31 = 0
            long r32 = android.os.SystemClock.elapsedRealtime()
            r34 = r4
            long r32 = r32 - r34
            r27.<init>(r28, r29, r30, r31, r32)
            r13 = r26
            r26 = r11
            r27 = 401(0x191, float:5.62E-43)
            r0 = r26
            r1 = r27
            if (r0 == r1) goto L_0x0219
            r26 = r11
            r27 = 403(0x193, float:5.65E-43)
            r0 = r26
            r1 = r27
            if (r0 != r1) goto L_0x023d
        L_0x0219:
            java.lang.String r26 = "auth"
            r27 = r3
            com.google.android.gms.internal.zza r28 = new com.google.android.gms.internal.zza
            r36 = r28
            r28 = r36
            r29 = r36
            r30 = r13
            r29.<init>(r30)
            zza(r26, r27, r28)
            goto L_0x000a
        L_0x022f:
            com.google.android.gms.internal.zzj r26 = new com.google.android.gms.internal.zzj
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = r9
            r27.<init>(r28)
            throw r26
        L_0x023d:
            com.google.android.gms.internal.zzp r26 = new com.google.android.gms.internal.zzp
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = r13
            r27.<init>(r28)
            throw r26
        L_0x024b:
            com.google.android.gms.internal.zzh r26 = new com.google.android.gms.internal.zzh
            r36 = r26
            r26 = r36
            r27 = r36
            r28 = 0
            r27.<init>(r28)
            throw r26
        L_0x0259:
            r26 = move-exception
            r9 = r26
            r26 = r17
            r6 = r26
            r26 = 0
            r10 = r26
            goto L_0x01ab
        L_0x0266:
            r26 = move-exception
            r9 = r26
            r26 = r21
            r10 = r26
            r26 = r17
            r6 = r26
            goto L_0x01ab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
