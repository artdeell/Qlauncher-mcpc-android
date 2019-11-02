package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzhb
public class zzev implements zzem {
    private final Context mContext;
    private zzer zzCD;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    private final long zzCv;
    private final long zzCw;
    private boolean zzCy = false;
    private final Object zzpV;
    private final zzcb zzpe;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;

    public zzev(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzex, zzeo zzeo, boolean z, boolean z2, long j, long j2, zzcb zzcb) {
        Object obj;
        Context context2 = context;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        zzex zzex2 = zzex;
        zzeo zzeo2 = zzeo;
        boolean z3 = z;
        boolean z4 = z2;
        long j3 = j;
        long j4 = j2;
        zzcb zzcb2 = zzcb;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzCu = adRequestInfoParcel2;
        this.zzpn = zzex2;
        this.zzCf = zzeo2;
        this.zzsA = z3;
        this.zzuS = z4;
        this.zzCv = j3;
        this.zzCw = j4;
        this.zzpe = zzcb2;
    }

    public void cancel() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCy = true;
                if (this.zzCD != null) {
                    this.zzCD.cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0117, code lost:
        r14 = r2.zzCD.zza(r2.zzCv, r2.zzCw);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0132, code lost:
        if (r14.zzCo != 0) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0134, code lost:
        com.google.android.gms.internal.zzin.zzaI("Adapter succeeded.");
        r2.zzpe.zzc("mediation_network_succeed", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0148, code lost:
        if (r4.isEmpty() != false) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x014a, code lost:
        r2.zzpe.zzc("mediation_networks_fail", android.text.TextUtils.join(",", r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x015a, code lost:
        r15 = r2.zzpe;
        r16 = r10;
        r30 = new java.lang.String[1];
        r17 = r30;
        r30[0] = "mls";
        r15 = r15.zza(r16, r17);
        r15 = r2.zzpe;
        r16 = r5;
        r30 = new java.lang.String[1];
        r17 = r30;
        r30[0] = "ttm";
        r15 = r15.zza(r16, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x019e, code lost:
        r15 = r4.add(r9);
        r15 = r2.zzpe;
        r16 = r10;
        r30 = new java.lang.String[1];
        r17 = r30;
        r30[0] = "mlf";
        r15 = r15.zza(r16, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01c5, code lost:
        if (r14.zzCq == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01c7, code lost:
        r15 = com.google.android.gms.internal.zzir.zzMc;
        r16 = r30;
        r19 = r14;
        r17 = new com.google.android.gms.internal.zzev.C03551(r2);
        r15 = r15.post(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzes zzc(java.util.List<com.google.android.gms.internal.zzen> r32) {
        /*
            r31 = this;
            r2 = r31
            r3 = r32
            java.lang.String r15 = "Starting mediation."
            com.google.android.gms.internal.zzin.zzaI(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r30 = r15
            r15 = r30
            r16 = r30
            r16.<init>()
            r4 = r15
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            com.google.android.gms.internal.zzbz r15 = r15.zzdB()
            r5 = r15
            r15 = r3
            java.util.Iterator r15 = r15.iterator()
            r6 = r15
        L_0x0023:
            r15 = r6
            boolean r15 = r15.hasNext()
            if (r15 == 0) goto L_0x01de
            r15 = r6
            java.lang.Object r15 = r15.next()
            com.google.android.gms.internal.zzen r15 = (com.google.android.gms.internal.zzen) r15
            r7 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r30 = r15
            r15 = r30
            r16 = r30
            r16.<init>()
            java.lang.String r16 = "Trying mediation network: "
            java.lang.StringBuilder r15 = r15.append(r16)
            r16 = r7
            r0 = r16
            java.lang.String r0 = r0.zzBA
            r16 = r0
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.internal.zzin.zzaJ(r15)
            r15 = r7
            java.util.List<java.lang.String> r15 = r15.zzBB
            java.util.Iterator r15 = r15.iterator()
            r8 = r15
        L_0x005e:
            r15 = r8
            boolean r15 = r15.hasNext()
            if (r15 == 0) goto L_0x0023
            r15 = r8
            java.lang.Object r15 = r15.next()
            java.lang.String r15 = (java.lang.String) r15
            r9 = r15
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            com.google.android.gms.internal.zzbz r15 = r15.zzdB()
            r10 = r15
            r15 = r2
            java.lang.Object r15 = r15.zzpV
            r11 = r15
            r15 = r11
            monitor-enter(r15)
            r15 = r2
            boolean r15 = r15.zzCy     // Catch:{ all -> 0x0198 }
            if (r15 == 0) goto L_0x0093
            com.google.android.gms.internal.zzes r15 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x0198 }
            r30 = r15
            r15 = r30
            r16 = r30
            r17 = -1
            r16.<init>(r17)     // Catch:{ all -> 0x0198 }
            r13 = r15
            r15 = r11
            monitor-exit(r15)     // Catch:{ all -> 0x0198 }
            r15 = r13
            r2 = r15
        L_0x0092:
            return r2
        L_0x0093:
            r15 = r2
            com.google.android.gms.internal.zzer r16 = new com.google.android.gms.internal.zzer     // Catch:{ all -> 0x0198 }
            r30 = r16
            r16 = r30
            r17 = r30
            r18 = r2
            r0 = r18
            android.content.Context r0 = r0.mContext     // Catch:{ all -> 0x0198 }
            r18 = r0
            r19 = r9
            r20 = r2
            r0 = r20
            com.google.android.gms.internal.zzex r0 = r0.zzpn     // Catch:{ all -> 0x0198 }
            r20 = r0
            r21 = r2
            r0 = r21
            com.google.android.gms.internal.zzeo r0 = r0.zzCf     // Catch:{ all -> 0x0198 }
            r21 = r0
            r22 = r7
            r23 = r2
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzCu     // Catch:{ all -> 0x0198 }
            r23 = r0
            r0 = r23
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.zzHt     // Catch:{ all -> 0x0198 }
            r23 = r0
            r24 = r2
            r0 = r24
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzCu     // Catch:{ all -> 0x0198 }
            r24 = r0
            r0 = r24
            com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r0.zzrp     // Catch:{ all -> 0x0198 }
            r24 = r0
            r25 = r2
            r0 = r25
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzCu     // Catch:{ all -> 0x0198 }
            r25 = r0
            r0 = r25
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r0.zzrl     // Catch:{ all -> 0x0198 }
            r25 = r0
            r26 = r2
            r0 = r26
            boolean r0 = r0.zzsA     // Catch:{ all -> 0x0198 }
            r26 = r0
            r27 = r2
            r0 = r27
            boolean r0 = r0.zzuS     // Catch:{ all -> 0x0198 }
            r27 = r0
            r28 = r2
            r0 = r28
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzCu     // Catch:{ all -> 0x0198 }
            r28 = r0
            r0 = r28
            com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = r0.zzrD     // Catch:{ all -> 0x0198 }
            r28 = r0
            r29 = r2
            r0 = r29
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzCu     // Catch:{ all -> 0x0198 }
            r29 = r0
            r0 = r29
            java.util.List<java.lang.String> r0 = r0.zzrH     // Catch:{ all -> 0x0198 }
            r29 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0198 }
            r0 = r16
            r15.zzCD = r0     // Catch:{ all -> 0x0198 }
            r15 = r11
            monitor-exit(r15)     // Catch:{ all -> 0x0198 }
            r15 = r2
            com.google.android.gms.internal.zzer r15 = r15.zzCD
            r16 = r2
            r0 = r16
            long r0 = r0.zzCv
            r16 = r0
            r18 = r2
            r0 = r18
            long r0 = r0.zzCw
            r18 = r0
            com.google.android.gms.internal.zzes r15 = r15.zza(r16, r18)
            r14 = r15
            r15 = r14
            int r15 = r15.zzCo
            if (r15 != 0) goto L_0x019e
            java.lang.String r15 = "Adapter succeeded."
            com.google.android.gms.internal.zzin.zzaI(r15)
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            java.lang.String r16 = "mediation_network_succeed"
            r17 = r9
            r15.zzc(r16, r17)
            r15 = r4
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x015a
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            java.lang.String r16 = "mediation_networks_fail"
            java.lang.String r17 = ","
            r18 = r4
            java.lang.String r17 = android.text.TextUtils.join(r17, r18)
            r15.zzc(r16, r17)
        L_0x015a:
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            r16 = r10
            r17 = 1
            r0 = r17
            java.lang.String[] r0 = new java.lang.String[r0]
            r17 = r0
            r30 = r17
            r17 = r30
            r18 = r30
            r19 = 0
            java.lang.String r20 = "mls"
            r18[r19] = r20
            boolean r15 = r15.zza(r16, r17)
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            r16 = r5
            r17 = 1
            r0 = r17
            java.lang.String[] r0 = new java.lang.String[r0]
            r17 = r0
            r30 = r17
            r17 = r30
            r18 = r30
            r19 = 0
            java.lang.String r20 = "ttm"
            r18[r19] = r20
            boolean r15 = r15.zza(r16, r17)
            r15 = r14
            r2 = r15
            goto L_0x0092
        L_0x0198:
            r15 = move-exception
            r12 = r15
            r15 = r11
            monitor-exit(r15)     // Catch:{ all -> 0x0198 }
            r15 = r12
            throw r15
        L_0x019e:
            r15 = r4
            r16 = r9
            boolean r15 = r15.add(r16)
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            r16 = r10
            r17 = 1
            r0 = r17
            java.lang.String[] r0 = new java.lang.String[r0]
            r17 = r0
            r30 = r17
            r17 = r30
            r18 = r30
            r19 = 0
            java.lang.String r20 = "mlf"
            r18[r19] = r20
            boolean r15 = r15.zza(r16, r17)
            r15 = r14
            com.google.android.gms.internal.zzey r15 = r15.zzCq
            if (r15 == 0) goto L_0x005e
            android.os.Handler r15 = com.google.android.gms.internal.zzir.zzMc
            com.google.android.gms.internal.zzev$1 r16 = new com.google.android.gms.internal.zzev$1
            r30 = r16
            r16 = r30
            r17 = r30
            r18 = r2
            r19 = r14
            r17.<init>(r18, r19)
            boolean r15 = r15.post(r16)
            goto L_0x005e
        L_0x01de:
            r15 = r4
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x01f5
            r15 = r2
            com.google.android.gms.internal.zzcb r15 = r15.zzpe
            java.lang.String r16 = "mediation_networks_fail"
            java.lang.String r17 = ","
            r18 = r4
            java.lang.String r17 = android.text.TextUtils.join(r17, r18)
            r15.zzc(r16, r17)
        L_0x01f5:
            com.google.android.gms.internal.zzes r15 = new com.google.android.gms.internal.zzes
            r30 = r15
            r15 = r30
            r16 = r30
            r17 = 1
            r16.<init>(r17)
            r2 = r15
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzev.zzc(java.util.List):com.google.android.gms.internal.zzes");
    }
}
