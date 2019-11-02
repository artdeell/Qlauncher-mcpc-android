package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzhb
public class zzeu implements zzem {
    private final Context mContext;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    /* access modifiers changed from: private */
    public final long zzCv;
    /* access modifiers changed from: private */
    public final long zzCw;
    private final int zzCx;
    /* access modifiers changed from: private */
    public boolean zzCy = false;
    /* access modifiers changed from: private */
    public final Map<zzjg<zzes>, zzer> zzCz;
    /* access modifiers changed from: private */
    public final Object zzpV;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;

    public zzeu(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzex, zzeo zzeo, boolean z, boolean z2, long j, long j2, int i) {
        Object obj;
        HashMap hashMap;
        Context context2 = context;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        zzex zzex2 = zzex;
        zzeo zzeo2 = zzeo;
        boolean z3 = z;
        boolean z4 = z2;
        long j3 = j;
        long j4 = j2;
        int i2 = i;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzCz = hashMap2;
        this.mContext = context2;
        this.zzCu = adRequestInfoParcel2;
        this.zzpn = zzex2;
        this.zzCf = zzeo2;
        this.zzsA = z3;
        this.zzuS = z4;
        this.zzCv = j3;
        this.zzCw = j4;
        this.zzCx = i2;
    }

    private void zza(zzjg<zzes> zzjg) {
        C03542 r7;
        zzjg<zzes> zzjg2 = zzjg;
        Handler handler = zzir.zzMc;
        C03542 r3 = r7;
        final zzjg<zzes> zzjg3 = zzjg2;
        C03542 r4 = new Runnable(this) {
            final /* synthetic */ zzeu zzCB;

            {
                zzjg zzjg = r7;
                this.zzCB = r6;
            }

            public void run() {
                for (zzjg zzjg : this.zzCB.zzCz.keySet()) {
                    if (zzjg != zzjg3) {
                        ((zzer) this.zzCB.zzCz.get(zzjg)).cancel();
                    }
                }
            }
        };
        boolean post = handler.post(r3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r5 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r5.hasNext() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r6 = (com.google.android.gms.internal.zzjg) r5.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r8 = (com.google.android.gms.internal.zzes) r6.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r8 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r8.zzCo != 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        com.google.android.gms.internal.zzin.zzd("Exception while processing an adapter; continuing with other adapters", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        zza(null);
        r9 = r12;
        r10 = new com.google.android.gms.internal.zzes(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzes zzd(java.util.List<com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>> r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r9 = r0
            java.lang.Object r9 = r9.zzpV
            r2 = r9
            r9 = r2
            monitor-enter(r9)
            r9 = r0
            boolean r9 = r9.zzCy     // Catch:{ all -> 0x0054 }
            if (r9 == 0) goto L_0x001c
            com.google.android.gms.internal.zzes r9 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x0054 }
            r12 = r9
            r9 = r12
            r10 = r12
            r11 = -1
            r10.<init>(r11)     // Catch:{ all -> 0x0054 }
            r4 = r9
            r9 = r2
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            r9 = r4
            r0 = r9
        L_0x001b:
            return r0
        L_0x001c:
            r9 = r2
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            r9 = r1
            java.util.Iterator r9 = r9.iterator()
            r5 = r9
        L_0x0024:
            r9 = r5
            boolean r9 = r9.hasNext()
            if (r9 == 0) goto L_0x005a
            r9 = r5
            java.lang.Object r9 = r9.next()
            com.google.android.gms.internal.zzjg r9 = (com.google.android.gms.internal.zzjg) r9
            r6 = r9
            r9 = r6
            java.lang.Object r9 = r9.get()     // Catch:{ InterruptedException -> 0x004b, ExecutionException -> 0x006a }
            com.google.android.gms.internal.zzes r9 = (com.google.android.gms.internal.zzes) r9     // Catch:{ InterruptedException -> 0x004b, ExecutionException -> 0x006a }
            r8 = r9
            r9 = r8
            if (r9 == 0) goto L_0x0024
            r9 = r8
            int r9 = r9.zzCo     // Catch:{ InterruptedException -> 0x004b, ExecutionException -> 0x006a }
            if (r9 != 0) goto L_0x0024
            r9 = r0
            r10 = r6
            r9.zza(r10)     // Catch:{ InterruptedException -> 0x004b, ExecutionException -> 0x006a }
            r9 = r8
            r0 = r9
            goto L_0x001b
        L_0x004b:
            r9 = move-exception
            r7 = r9
        L_0x004d:
            java.lang.String r9 = "Exception while processing an adapter; continuing with other adapters"
            r10 = r7
            com.google.android.gms.internal.zzin.zzd(r9, r10)
            goto L_0x0024
        L_0x0054:
            r9 = move-exception
            r3 = r9
            r9 = r2
            monitor-exit(r9)     // Catch:{ all -> 0x0054 }
            r9 = r3
            throw r9
        L_0x005a:
            r9 = r0
            r10 = 0
            r9.zza(r10)
            com.google.android.gms.internal.zzes r9 = new com.google.android.gms.internal.zzes
            r12 = r9
            r9 = r12
            r10 = r12
            r11 = 1
            r10.<init>(r11)
            r0 = r9
            goto L_0x001b
        L_0x006a:
            r9 = move-exception
            r7 = r9
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zzd(java.util.List):com.google.android.gms.internal.zzes");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r7 = -1;
        r8 = null;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r2.zzCf.zzBY == -1) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        r10 = r2.zzCf.zzBY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
        r12 = r3.iterator();
        r34 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0124, code lost:
        r10 = 10000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzes zze(java.util.List<com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>> r42) {
        /*
            r41 = this;
            r2 = r41
            r3 = r42
            r34 = r2
            r0 = r34
            java.lang.Object r0 = r0.zzpV
            r34 = r0
            r4 = r34
            r34 = r4
            monitor-enter(r34)
            r34 = r2
            r0 = r34
            boolean r0 = r0.zzCy     // Catch:{ all -> 0x011b }
            r34 = r0
            if (r34 == 0) goto L_0x0032
            com.google.android.gms.internal.zzes r34 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x011b }
            r40 = r34
            r34 = r40
            r35 = r40
            r36 = -1
            r35.<init>(r36)     // Catch:{ all -> 0x011b }
            r6 = r34
            r34 = r4
            monitor-exit(r34)     // Catch:{ all -> 0x011b }
            r34 = r6
            r2 = r34
        L_0x0031:
            return r2
        L_0x0032:
            r34 = r4
            monitor-exit(r34)     // Catch:{ all -> 0x011b }
            r34 = -1
            r7 = r34
            r34 = 0
            r8 = r34
            r34 = 0
            r9 = r34
            r34 = r2
            r0 = r34
            com.google.android.gms.internal.zzeo r0 = r0.zzCf
            r34 = r0
            r0 = r34
            long r0 = r0.zzBY
            r34 = r0
            r36 = -1
            int r34 = (r34 > r36 ? 1 : (r34 == r36 ? 0 : -1))
            if (r34 == 0) goto L_0x0124
            r34 = r2
            r0 = r34
            com.google.android.gms.internal.zzeo r0 = r0.zzCf
            r34 = r0
            r0 = r34
            long r0 = r0.zzBY
            r34 = r0
            r10 = r34
        L_0x0065:
            r34 = r3
            java.util.Iterator r34 = r34.iterator()
            r12 = r34
            r34 = r10
            r13 = r34
        L_0x0071:
            r34 = r12
            boolean r34 = r34.hasNext()
            if (r34 == 0) goto L_0x0179
            r34 = r12
            java.lang.Object r34 = r34.next()
            com.google.android.gms.internal.zzjg r34 = (com.google.android.gms.internal.zzjg) r34
            r15 = r34
            com.google.android.gms.internal.zzmq r34 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r34 = r34.currentTimeMillis()
            r16 = r34
            r34 = r13
            r36 = 0
            int r34 = (r34 > r36 ? 1 : (r34 == r36 ? 0 : -1))
            if (r34 != 0) goto L_0x012a
            r34 = r15
            boolean r34 = r34.isDone()     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            if (r34 == 0) goto L_0x012a
            r34 = r15
            java.lang.Object r34 = r34.get()     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            com.google.android.gms.internal.zzes r34 = (com.google.android.gms.internal.zzes) r34     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r24 = r34
        L_0x00a7:
            r34 = r24
            if (r34 == 0) goto L_0x01a1
            r34 = r24
            r0 = r34
            int r0 = r0.zzCo     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r34 = r0
            if (r34 != 0) goto L_0x01a1
            r34 = r24
            r0 = r34
            com.google.android.gms.internal.zzfa r0 = r0.zzCt     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r34 = r0
            r31 = r34
            r34 = r31
            if (r34 == 0) goto L_0x01a1
            r34 = r31
            int r34 = r34.zzeD()     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r35 = r7
            r0 = r34
            r1 = r35
            if (r0 <= r1) goto L_0x01a1
            r34 = r31
            int r34 = r34.zzeD()     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r32 = r34
            r34 = r32
            r27 = r34
            r34 = r24
            r33 = r34
            r34 = r15
            r26 = r34
            r34 = r33
            r25 = r34
        L_0x00e9:
            r34 = r13
            com.google.android.gms.internal.zzmq r36 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r36 = r36.currentTimeMillis()
            r38 = r16
            long r36 = r36 - r38
            long r34 = r34 - r36
            r36 = 0
            long r34 = java.lang.Math.max(r34, r36)
            r28 = r34
            r34 = r26
            r8 = r34
            r34 = r25
            r30 = r34
            r34 = r28
            r22 = r34
            r34 = r27
            r7 = r34
            r34 = r30
            r9 = r34
        L_0x0115:
            r34 = r22
            r13 = r34
            goto L_0x0071
        L_0x011b:
            r34 = move-exception
            r5 = r34
            r34 = r4
            monitor-exit(r34)     // Catch:{ all -> 0x011b }
            r34 = r5
            throw r34
        L_0x0124:
            r34 = 10000(0x2710, double:4.9407E-320)
            r10 = r34
            goto L_0x0065
        L_0x012a:
            r34 = r15
            r35 = r13
            java.util.concurrent.TimeUnit r37 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            java.lang.Object r34 = r34.get(r35, r37)     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            com.google.android.gms.internal.zzes r34 = (com.google.android.gms.internal.zzes) r34     // Catch:{ InterruptedException -> 0x013a, ExecutionException -> 0x0199, RemoteException -> 0x019d, TimeoutException -> 0x0195 }
            r24 = r34
            goto L_0x00a7
        L_0x013a:
            r34 = move-exception
            r18 = r34
        L_0x013d:
            java.lang.String r34 = "Exception while processing an adapter; continuing with other adapters"
            r35 = r18
            com.google.android.gms.internal.zzin.zzd(r34, r35)     // Catch:{ all -> 0x015d }
            r34 = r13
            com.google.android.gms.internal.zzmq r36 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r36 = r36.currentTimeMillis()
            r38 = r16
            long r36 = r36 - r38
            long r34 = r34 - r36
            r36 = 0
            long r34 = java.lang.Math.max(r34, r36)
            r22 = r34
            goto L_0x0115
        L_0x015d:
            r34 = move-exception
            r19 = r34
            r34 = r13
            com.google.android.gms.internal.zzmq r36 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r36 = r36.currentTimeMillis()
            r38 = r16
            long r36 = r36 - r38
            long r34 = r34 - r36
            r36 = 0
            long r34 = java.lang.Math.max(r34, r36)
            r34 = r19
            throw r34
        L_0x0179:
            r34 = r2
            r35 = r8
            r34.zza(r35)
            r34 = r9
            if (r34 != 0) goto L_0x01af
            com.google.android.gms.internal.zzes r34 = new com.google.android.gms.internal.zzes
            r40 = r34
            r34 = r40
            r35 = r40
            r36 = 1
            r35.<init>(r36)
            r2 = r34
            goto L_0x0031
        L_0x0195:
            r34 = move-exception
            r18 = r34
            goto L_0x013d
        L_0x0199:
            r34 = move-exception
            r18 = r34
            goto L_0x013d
        L_0x019d:
            r34 = move-exception
            r18 = r34
            goto L_0x013d
        L_0x01a1:
            r34 = r9
            r25 = r34
            r34 = r8
            r26 = r34
            r34 = r7
            r27 = r34
            goto L_0x00e9
        L_0x01af:
            r34 = r9
            r2 = r34
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zze(java.util.List):com.google.android.gms.internal.zzes");
    }

    public void cancel() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCy = true;
                for (zzer cancel : this.zzCz.values()) {
                    cancel.cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public zzes zzc(List<zzen> list) {
        ArrayList arrayList;
        StringBuilder sb;
        zzer zzer;
        C03531 r25;
        List<zzen> list2 = list;
        zzin.zzaI("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzen zzen : list2) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaJ(sb2.append("Trying mediation network: ").append(zzen.zzBA).toString());
            for (String zzer2 : zzen.zzBB) {
                zzer zzer3 = zzer;
                zzer zzer4 = new zzer(this.mContext, zzer2, this.zzpn, this.zzCf, zzen, this.zzCu.zzHt, this.zzCu.zzrp, this.zzCu.zzrl, this.zzsA, this.zzuS, this.zzCu.zzrD, this.zzCu.zzrH);
                zzer zzer5 = zzer3;
                ExecutorService executorService = newCachedThreadPool;
                C03531 r12 = r25;
                final zzer zzer6 = zzer5;
                C03531 r13 = new Callable<zzes>(this) {
                    final /* synthetic */ zzeu zzCB;

                    {
                        zzer zzer = r7;
                        this.zzCB = r6;
                    }

                    /* renamed from: zzeE */
                    public zzes call() throws Exception {
                        Object zza = this.zzCB.zzpV;
                        synchronized (zza) {
                            try {
                                if (this.zzCB.zzCy) {
                                    return null;
                                }
                                return zzer6.zza(this.zzCB.zzCv, this.zzCB.zzCw);
                            } catch (Throwable th) {
                                while (true) {
                                    Throwable th2 = th;
                                    Object obj = zza;
                                    throw th2;
                                }
                            }
                        }
                    }
                };
                zzjg zza = zziq.zza(executorService, (Callable<T>) r12);
                Object put = this.zzCz.put(zza, zzer5);
                boolean add = arrayList4.add(zza);
            }
        }
        switch (this.zzCx) {
            case 2:
                return zze((List<zzjg<zzes>>) arrayList4);
            default:
                return zzd((List<zzjg<zzes>>) arrayList4);
        }
    }
}
