package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class zzv implements zzb {
    private final int zzaA;
    private final Map<String, zza> zzax;
    private long zzay;
    private final File zzaz;

    static class zza {
        public String key;
        public long zzaB;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map<String, String> zzg;

        private zza() {
        }

        public zza(String str, com.google.android.gms.internal.zzb.zza zza) {
            com.google.android.gms.internal.zzb.zza zza2 = zza;
            this.key = str;
            this.zzaB = (long) zza2.data.length;
            this.zzb = zza2.zzb;
            this.zzc = zza2.zzc;
            this.zzd = zza2.zzd;
            this.zze = zza2.zze;
            this.zzf = zza2.zzf;
            this.zzg = zza2.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza;
            IOException iOException;
            InputStream inputStream2 = inputStream;
            zza zza2 = zza;
            zza zza3 = new zza();
            zza zza4 = zza2;
            if (zzv.zzb(inputStream2) != 538247942) {
                IOException iOException2 = iOException;
                IOException iOException3 = new IOException();
                throw iOException2;
            }
            zza4.key = zzv.zzd(inputStream2);
            zza4.zzb = zzv.zzd(inputStream2);
            if (zza4.zzb.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zza4.zzb = null;
            }
            zza4.zzc = zzv.zzc(inputStream2);
            zza4.zzd = zzv.zzc(inputStream2);
            zza4.zze = zzv.zzc(inputStream2);
            zza4.zzf = zzv.zzc(inputStream2);
            zza4.zzg = zzv.zze(inputStream2);
            return zza4;
        }

        public boolean zza(OutputStream outputStream) {
            OutputStream outputStream2 = outputStream;
            try {
                zzv.zza(outputStream2, 538247942);
                zzv.zza(outputStream2, this.key);
                zzv.zza(outputStream2, this.zzb == null ? LibrariesRepository.MOJANG_MAVEN_REPO : this.zzb);
                zzv.zza(outputStream2, this.zzc);
                zzv.zza(outputStream2, this.zzd);
                zzv.zza(outputStream2, this.zze);
                zzv.zza(outputStream2, this.zzf);
                zzv.zza(this.zzg, outputStream2);
                outputStream2.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public com.google.android.gms.internal.zzb.zza zzb(byte[] bArr) {
            com.google.android.gms.internal.zzb.zza zza;
            byte[] bArr2 = bArr;
            com.google.android.gms.internal.zzb.zza zza2 = zza;
            com.google.android.gms.internal.zzb.zza zza3 = new com.google.android.gms.internal.zzb.zza();
            com.google.android.gms.internal.zzb.zza zza4 = zza2;
            zza4.data = bArr2;
            zza4.zzb = this.zzb;
            zza4.zzc = this.zzc;
            zza4.zzd = this.zzd;
            zza4.zze = this.zze;
            zza4.zzf = this.zzf;
            zza4.zzg = this.zzg;
            return zza4;
        }
    }

    private static class zzb extends FilterInputStream {
        /* access modifiers changed from: private */
        public int zzaC;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaC = 0;
        }

        /* synthetic */ zzb(InputStream inputStream, C04531 r7) {
            C04531 r2 = r7;
            this(inputStream);
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaC = 1 + this.zzaC;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaC = read + this.zzaC;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        LinkedHashMap linkedHashMap;
        File file2 = file;
        int i2 = i;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(16, 0.75f, true);
        this.zzax = linkedHashMap2;
        this.zzay = 0;
        this.zzaz = file2;
        this.zzaA = i2;
    }

    private void removeEntry(String str) {
        String str2 = str;
        zza zza2 = (zza) this.zzax.get(str2);
        if (zza2 != null) {
            this.zzay -= zza2.zzaB;
            Object remove = this.zzax.remove(str2);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        EOFException eOFException;
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        EOFException eOFException2 = eOFException;
        EOFException eOFException3 = new EOFException();
        throw eOFException2;
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        OutputStream outputStream2 = outputStream;
        int i2 = i;
        outputStream2.write(255 & (i2 >> 0));
        outputStream2.write(255 & (i2 >> 8));
        outputStream2.write(255 & (i2 >> 16));
        outputStream2.write(255 & (i2 >> 24));
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        OutputStream outputStream2 = outputStream;
        long j2 = j;
        outputStream2.write((byte) ((int) (j2 >>> 0)));
        outputStream2.write((byte) ((int) (j2 >>> 8)));
        outputStream2.write((byte) ((int) (j2 >>> 16)));
        outputStream2.write((byte) ((int) (j2 >>> 24)));
        outputStream2.write((byte) ((int) (j2 >>> 32)));
        outputStream2.write((byte) ((int) (j2 >>> 40)));
        outputStream2.write((byte) ((int) (j2 >>> 48)));
        outputStream2.write((byte) ((int) (j2 >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        OutputStream outputStream2 = outputStream;
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream2, (long) bytes.length);
        outputStream2.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        String str2 = str;
        zza zza3 = zza2;
        if (!this.zzax.containsKey(str2)) {
            this.zzay += zza3.zzaB;
        } else {
            this.zzay = this.zzay + (zza3.zzaB - ((zza) this.zzax.get(str2)).zzaB);
        }
        Object put = this.zzax.put(str2, zza3);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        Map<String, String> map2 = map;
        OutputStream outputStream2 = outputStream;
        if (map2 != null) {
            zza(outputStream2, map2.size());
            for (Entry entry : map2.entrySet()) {
                zza(outputStream2, (String) entry.getKey());
                zza(outputStream2, (String) entry.getValue());
            }
            return;
        }
        zza(outputStream2, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        int i2;
        IOException iOException;
        StringBuilder sb;
        InputStream inputStream2 = inputStream;
        int i3 = i;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i2 >= i3) {
                break;
            }
            int read = inputStream2.read(bArr, i2, i3 - i2);
            if (read == -1) {
                break;
            }
            i4 = i2 + read;
        }
        if (i2 == i3) {
            return bArr;
        }
        IOException iOException2 = iOException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IOException iOException3 = new IOException(sb2.append("Expected ").append(i3).append(" bytes, read ").append(i2).append(" bytes").toString());
        throw iOException2;
    }

    static int zzb(InputStream inputStream) throws IOException {
        InputStream inputStream2 = inputStream;
        return 0 | (zza(inputStream2) << 0) | (zza(inputStream2) << 8) | (zza(inputStream2) << 16) | (zza(inputStream2) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        InputStream inputStream2 = inputStream;
        return 0 | ((255 & ((long) zza(inputStream2))) << 0) | ((255 & ((long) zza(inputStream2))) << 8) | ((255 & ((long) zza(inputStream2))) << 16) | ((255 & ((long) zza(inputStream2))) << 24) | ((255 & ((long) zza(inputStream2))) << 32) | ((255 & ((long) zza(inputStream2))) << 40) | ((255 & ((long) zza(inputStream2))) << 48) | ((255 & ((long) zza(inputStream2))) << 56);
    }

    private void zzc(int i) {
        int i2;
        int i3 = i;
        if (this.zzay + ((long) i3) >= ((long) this.zzaA)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzay;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.zzax.entrySet().iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    i2 = i5;
                    break;
                }
                zza zza2 = (zza) ((Entry) it.next()).getValue();
                if (zzf(zza2.key).delete()) {
                    this.zzay -= zza2.zzaB;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza2.key, zze(zza2.key));
                }
                it.remove();
                i2 = i5 + 1;
                if (((float) (this.zzay + ((long) i3))) < 0.9f * ((float) this.zzaA)) {
                    break;
                }
                i4 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        String str;
        InputStream inputStream2 = inputStream;
        String str2 = str;
        String str3 = new String(zza(inputStream2, (int) zzc(inputStream2)), "UTF-8");
        return str2;
    }

    private String zze(String str) {
        StringBuilder sb;
        String str2 = str;
        int length = str2.length() / 2;
        String valueOf = String.valueOf(str2.substring(0, length).hashCode());
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(valueOf).append(String.valueOf(str2.substring(length).hashCode())).toString();
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map<java.lang.String, java.lang.String> zze(java.io.InputStream r8) throws java.io.IOException {
        /*
            r0 = r8
            r4 = r0
            int r4 = zzb(r4)
            r1 = r4
            r4 = r1
            if (r4 != 0) goto L_0x002f
            java.util.Map r4 = java.util.Collections.emptyMap()
            r2 = r4
        L_0x000f:
            r4 = 0
            r3 = r4
        L_0x0011:
            r4 = r3
            r5 = r1
            if (r4 >= r5) goto L_0x003a
            r4 = r2
            r5 = r0
            java.lang.String r5 = zzd(r5)
            java.lang.String r5 = r5.intern()
            r6 = r0
            java.lang.String r6 = zzd(r6)
            java.lang.String r6 = r6.intern()
            java.lang.Object r4 = r4.put(r5, r6)
            int r3 = r3 + 1
            goto L_0x0011
        L_0x002f:
            java.util.HashMap r4 = new java.util.HashMap
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r1
            r5.<init>(r6)
            r2 = r4
            goto L_0x000f
        L_0x003a:
            r4 = r2
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zze(java.io.InputStream):java.util.Map");
    }

    /* JADX INFO: finally extract failed */
    public void remove(String str) {
        String str2 = str;
        synchronized (this) {
            try {
                boolean delete = zzf(str2).delete();
                removeEntry(str2);
                if (!delete) {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str2, zze(str2));
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzb.zza zza(java.lang.String r25) {
        /*
            r24 = this;
            r2 = r24
            r3 = r25
            r17 = r2
            monitor-enter(r17)
            r17 = r2
            r0 = r17
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r0.zzax     // Catch:{ all -> 0x00f3 }
            r17 = r0
            r18 = r3
            java.lang.Object r17 = r17.get(r18)     // Catch:{ all -> 0x00f3 }
            com.google.android.gms.internal.zzv$zza r17 = (com.google.android.gms.internal.zzv.zza) r17     // Catch:{ all -> 0x00f3 }
            r5 = r17
            r17 = r5
            if (r17 != 0) goto L_0x0029
            r17 = 0
            r11 = r17
        L_0x0021:
            r17 = r2
            monitor-exit(r17)
            r17 = r11
            r2 = r17
            return r2
        L_0x0029:
            r17 = r2
            r18 = r3
            java.io.File r17 = r17.zzf(r18)     // Catch:{ all -> 0x00f3 }
            r6 = r17
            com.google.android.gms.internal.zzv$zzb r17 = new com.google.android.gms.internal.zzv$zzb     // Catch:{ IOException -> 0x0091, all -> 0x00e0 }
            r23 = r17
            r17 = r23
            r18 = r23
            java.io.FileInputStream r19 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0091, all -> 0x00e0 }
            r23 = r19
            r19 = r23
            r20 = r23
            r21 = r6
            r20.<init>(r21)     // Catch:{ IOException -> 0x0091, all -> 0x00e0 }
            r20 = 0
            r18.<init>(r19, r20)     // Catch:{ IOException -> 0x0091, all -> 0x00e0 }
            r7 = r17
            r17 = r7
            com.google.android.gms.internal.zzv$zza r17 = com.google.android.gms.internal.zzv.zza.zzf(r17)     // Catch:{ IOException -> 0x0109 }
            r17 = r5
            r18 = r7
            r19 = r6
            long r19 = r19.length()     // Catch:{ IOException -> 0x0109 }
            r21 = r7
            int r21 = r21.zzaC     // Catch:{ IOException -> 0x0109 }
            r0 = r21
            long r0 = (long) r0     // Catch:{ IOException -> 0x0109 }
            r21 = r0
            long r19 = r19 - r21
            r0 = r19
            int r0 = (int) r0     // Catch:{ IOException -> 0x0109 }
            r19 = r0
            byte[] r18 = zza(r18, r19)     // Catch:{ IOException -> 0x0109 }
            com.google.android.gms.internal.zzb$zza r17 = r17.zzb(r18)     // Catch:{ IOException -> 0x0109 }
            r15 = r17
            r17 = r15
            r11 = r17
            r17 = r7
            if (r17 == 0) goto L_0x0021
            r17 = r7
            r17.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0021
        L_0x0089:
            r17 = move-exception
            r16 = r17
            r17 = 0
            r11 = r17
            goto L_0x0021
        L_0x0091:
            r17 = move-exception
            r8 = r17
            r17 = 0
            r7 = r17
        L_0x0098:
            r17 = 2
            r0 = r17
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0105 }
            r17 = r0
            r12 = r17
            r17 = r12
            r18 = 0
            r19 = r6
            java.lang.String r19 = r19.getAbsolutePath()     // Catch:{ all -> 0x0105 }
            r17[r18] = r19     // Catch:{ all -> 0x0105 }
            r17 = r12
            r18 = 1
            r19 = r8
            java.lang.String r19 = r19.toString()     // Catch:{ all -> 0x0105 }
            r17[r18] = r19     // Catch:{ all -> 0x0105 }
            java.lang.String r17 = "%s: %s"
            r18 = r12
            com.google.android.gms.internal.zzs.zzb(r17, r18)     // Catch:{ all -> 0x0105 }
            r17 = r2
            r18 = r3
            r17.remove(r18)     // Catch:{ all -> 0x0105 }
            r17 = r7
            if (r17 == 0) goto L_0x00d1
            r17 = r7
            r17.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00d1:
            r17 = 0
            r11 = r17
            goto L_0x0021
        L_0x00d7:
            r17 = move-exception
            r13 = r17
            r17 = 0
            r11 = r17
            goto L_0x0021
        L_0x00e0:
            r17 = move-exception
            r9 = r17
            r17 = 0
            r7 = r17
        L_0x00e7:
            r17 = r7
            if (r17 == 0) goto L_0x00f0
            r17 = r7
            r17.close()     // Catch:{ IOException -> 0x00fc }
        L_0x00f0:
            r17 = r9
            throw r17     // Catch:{ all -> 0x00f3 }
        L_0x00f3:
            r17 = move-exception
            r4 = r17
            r17 = r2
            monitor-exit(r17)
            r17 = r4
            throw r17
        L_0x00fc:
            r17 = move-exception
            r10 = r17
            r17 = 0
            r11 = r17
            goto L_0x0021
        L_0x0105:
            r17 = move-exception
            r9 = r17
            goto L_0x00e7
        L_0x0109:
            r17 = move-exception
            r8 = r17
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00c5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza() {
        /*
            r27 = this;
            r3 = r27
            r21 = r3
            monitor-enter(r21)
            r21 = r3
            r0 = r21
            java.io.File r0 = r0.zzaz     // Catch:{ all -> 0x00f6 }
            r21 = r0
            boolean r21 = r21.exists()     // Catch:{ all -> 0x00f6 }
            if (r21 != 0) goto L_0x0048
            r21 = r3
            r0 = r21
            java.io.File r0 = r0.zzaz     // Catch:{ all -> 0x00f6 }
            r21 = r0
            boolean r21 = r21.mkdirs()     // Catch:{ all -> 0x00f6 }
            if (r21 != 0) goto L_0x0044
            r21 = 1
            r0 = r21
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00f6 }
            r21 = r0
            r20 = r21
            r21 = r20
            r22 = 0
            r23 = r3
            r0 = r23
            java.io.File r0 = r0.zzaz     // Catch:{ all -> 0x00f6 }
            r23 = r0
            java.lang.String r23 = r23.getAbsolutePath()     // Catch:{ all -> 0x00f6 }
            r21[r22] = r23     // Catch:{ all -> 0x00f6 }
            java.lang.String r21 = "Unable to create cache dir %s"
            r22 = r20
            com.google.android.gms.internal.zzs.zzc(r21, r22)     // Catch:{ all -> 0x00f6 }
        L_0x0044:
            r21 = r3
            monitor-exit(r21)
            return
        L_0x0048:
            r21 = r3
            r0 = r21
            java.io.File r0 = r0.zzaz     // Catch:{ all -> 0x00f6 }
            r21 = r0
            java.io.File[] r21 = r21.listFiles()     // Catch:{ all -> 0x00f6 }
            r5 = r21
            r21 = r5
            if (r21 == 0) goto L_0x0044
            r21 = r5
            r0 = r21
            int r0 = r0.length     // Catch:{ all -> 0x00f6 }
            r21 = r0
            r6 = r21
            r21 = 0
            r7 = r21
        L_0x0067:
            r21 = r7
            r22 = r6
            r0 = r21
            r1 = r22
            if (r0 >= r1) goto L_0x0044
            r21 = r5
            r22 = r7
            r21 = r21[r22]     // Catch:{ all -> 0x00f6 }
            r8 = r21
            r21 = 0
            r9 = r21
            java.io.BufferedInputStream r21 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00c8, all -> 0x00e7 }
            r26 = r21
            r21 = r26
            r22 = r26
            java.io.FileInputStream r23 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00c8, all -> 0x00e7 }
            r26 = r23
            r23 = r26
            r24 = r26
            r25 = r8
            r24.<init>(r25)     // Catch:{ IOException -> 0x00c8, all -> 0x00e7 }
            r22.<init>(r23)     // Catch:{ IOException -> 0x00c8, all -> 0x00e7 }
            r10 = r21
            r21 = r10
            com.google.android.gms.internal.zzv$zza r21 = com.google.android.gms.internal.zzv.zza.zzf(r21)     // Catch:{ IOException -> 0x0113 }
            r17 = r21
            r21 = r17
            r22 = r8
            long r22 = r22.length()     // Catch:{ IOException -> 0x0113 }
            r0 = r22
            r2 = r21
            r2.zzaB = r0     // Catch:{ IOException -> 0x0113 }
            r21 = r3
            r22 = r17
            r0 = r22
            java.lang.String r0 = r0.key     // Catch:{ IOException -> 0x0113 }
            r22 = r0
            r23 = r17
            r21.zza(r22, r23)     // Catch:{ IOException -> 0x0113 }
            r21 = r10
            if (r21 == 0) goto L_0x00c5
            r21 = r10
            r21.close()     // Catch:{ IOException -> 0x00ff }
        L_0x00c5:
            int r7 = r7 + 1
            goto L_0x0067
        L_0x00c8:
            r21 = move-exception
            r19 = r21
            r21 = 0
            r10 = r21
        L_0x00cf:
            r21 = r8
            if (r21 == 0) goto L_0x00d9
            r21 = r8
            boolean r21 = r21.delete()     // Catch:{ all -> 0x0107 }
        L_0x00d9:
            r21 = r10
            if (r21 == 0) goto L_0x00c5
            r21 = r10
            r21.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00c5
        L_0x00e3:
            r21 = move-exception
            r12 = r21
            goto L_0x00c5
        L_0x00e7:
            r21 = move-exception
            r14 = r21
        L_0x00ea:
            r21 = r9
            if (r21 == 0) goto L_0x00f3
            r21 = r9
            r21.close()     // Catch:{ IOException -> 0x0103 }
        L_0x00f3:
            r21 = r14
            throw r21     // Catch:{ all -> 0x00f6 }
        L_0x00f6:
            r21 = move-exception
            r4 = r21
            r21 = r3
            monitor-exit(r21)
            r21 = r4
            throw r21
        L_0x00ff:
            r21 = move-exception
            r18 = r21
            goto L_0x00c5
        L_0x0103:
            r21 = move-exception
            r15 = r21
            goto L_0x00f3
        L_0x0107:
            r21 = move-exception
            r13 = r21
            r21 = r10
            r9 = r21
            r21 = r13
            r14 = r21
            goto L_0x00ea
        L_0x0113:
            r21 = move-exception
            r11 = r21
            goto L_0x00cf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza():void");
    }

    public void zza(String str, com.google.android.gms.internal.zzb.zza zza2) {
        FileOutputStream fileOutputStream;
        zza zza3;
        IOException iOException;
        String str2 = str;
        this = zza2;
        synchronized (this) {
            try {
                zzc(this.data.length);
                this = zzf(str2);
                FileOutputStream fileOutputStream2 = fileOutputStream;
                FileOutputStream fileOutputStream3 = new FileOutputStream(this);
                e = fileOutputStream2;
                zza zza4 = zza3;
                zza zza5 = new zza(str2, this);
                zza zza6 = zza4;
                if (!zza6.zza(e)) {
                    e.close();
                    zzs.zzb("Failed to write header for %s", this.getAbsolutePath());
                    IOException iOException2 = iOException;
                    IOException iOException3 = new IOException();
                    throw iOException2;
                }
                e.write(this.data);
                e.close();
                zza(str2, zza6);
            } catch (IOException e) {
                if (!this.delete()) {
                    zzs.zzb("Could not clean up file %s", this.getAbsolutePath());
                }
            } finally {
                FileOutputStream fileOutputStream4 = e;
                Throwable th = fileOutputStream4;
            }
        }
    }

    public File zzf(String str) {
        File file;
        File file2 = file;
        File file3 = new File(this.zzaz, zze(str));
        return file2;
    }
}
