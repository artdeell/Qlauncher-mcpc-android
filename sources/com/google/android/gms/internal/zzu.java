package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu {
    protected static final Comparator<byte[]> zzaw;
    private List<byte[]> zzas;
    private List<byte[]> zzat;
    private int zzau = 0;
    private final int zzav;

    static {
        C04521 r2;
        C04521 r0 = r2;
        C04521 r1 = new Comparator<byte[]>() {
            /* renamed from: zza */
            public int compare(byte[] bArr, byte[] bArr2) {
                return bArr.length - bArr2.length;
            }
        };
        zzaw = r0;
    }

    public zzu(int i) {
        LinkedList linkedList;
        ArrayList arrayList;
        int i2 = i;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzas = linkedList2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(64);
        this.zzat = arrayList2;
        this.zzav = i2;
    }

    /* JADX INFO: finally extract failed */
    private void zzy() {
        synchronized (this) {
            while (this.zzau > this.zzav) {
                try {
                    byte[] bArr = (byte[]) this.zzas.remove(0);
                    boolean remove = this.zzat.remove(bArr);
                    this.zzau -= bArr.length;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
    }

    public void zza(byte[] bArr) {
        byte[] bArr2 = bArr;
        synchronized (this) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length <= this.zzav) {
                        boolean add = this.zzas.add(bArr2);
                        int binarySearch = Collections.binarySearch(this.zzat, bArr2, zzaw);
                        if (binarySearch < 0) {
                            binarySearch = -1 + (-binarySearch);
                        }
                        this.zzat.add(binarySearch, bArr2);
                        this.zzau += bArr2.length;
                        zzy();
                    }
                } finally {
                    int i = th;
                    Throwable th = i;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r4 = new byte[r1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] zzb(int r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r5 = r0
            monitor-enter(r5)
            r5 = 0
            r2 = r5
        L_0x0006:
            r5 = r2
            r6 = r0
            java.util.List<byte[]> r6 = r6.zzat     // Catch:{ all -> 0x0046 }
            int r6 = r6.size()     // Catch:{ all -> 0x0046 }
            if (r5 >= r6) goto L_0x0041
            r5 = r0
            java.util.List<byte[]> r5 = r5.zzat     // Catch:{ all -> 0x0046 }
            r6 = r2
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0046 }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0046 }
            r4 = r5
            r5 = r4
            int r5 = r5.length     // Catch:{ all -> 0x0046 }
            r6 = r1
            if (r5 < r6) goto L_0x003e
            r5 = r0
            r6 = r0
            int r6 = r6.zzau     // Catch:{ all -> 0x0046 }
            r7 = r4
            int r7 = r7.length     // Catch:{ all -> 0x0046 }
            int r6 = r6 - r7
            r5.zzau = r6     // Catch:{ all -> 0x0046 }
            r5 = r0
            java.util.List<byte[]> r5 = r5.zzat     // Catch:{ all -> 0x0046 }
            r6 = r2
            java.lang.Object r5 = r5.remove(r6)     // Catch:{ all -> 0x0046 }
            r5 = r0
            java.util.List<byte[]> r5 = r5.zzas     // Catch:{ all -> 0x0046 }
            r6 = r4
            boolean r5 = r5.remove(r6)     // Catch:{ all -> 0x0046 }
        L_0x0039:
            r5 = r0
            monitor-exit(r5)
            r5 = r4
            r0 = r5
            return r0
        L_0x003e:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0041:
            r5 = r1
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0046 }
            r4 = r5
            goto L_0x0039
        L_0x0046:
            r5 = move-exception
            r3 = r5
            r5 = r0
            monitor-exit(r5)
            r5 = r3
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzu.zzb(int):byte[]");
    }
}
