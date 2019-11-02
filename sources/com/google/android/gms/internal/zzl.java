package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {
    private AtomicInteger zzY;
    private final Map<String, Queue<zzk<?>>> zzZ;
    private final Set<zzk<?>> zzaa;
    private final PriorityBlockingQueue<zzk<?>> zzab;
    private final PriorityBlockingQueue<zzk<?>> zzac;
    private zzg[] zzad;
    private zzc zzae;
    private List<zza> zzaf;
    private final zzb zzj;
    private final zzn zzk;
    private final zzf zzz;

    public interface zza<T> {
        void zzg(zzk<T> zzk);
    }

    public zzl(zzb zzb, zzf zzf) {
        this(zzb, zzf, 4);
    }

    public zzl(zzb zzb, zzf zzf, int i) {
        zze zze;
        Handler handler;
        zzb zzb2 = zzb;
        zzf zzf2 = zzf;
        int i2 = i;
        zze zze2 = zze;
        Handler handler2 = handler;
        Handler handler3 = new Handler(Looper.getMainLooper());
        zze zze3 = new zze(handler2);
        this(zzb2, zzf2, i2, zze2);
    }

    public zzl(zzb zzb, zzf zzf, int i, zzn zzn) {
        AtomicInteger atomicInteger;
        HashMap hashMap;
        HashSet hashSet;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue2;
        ArrayList arrayList;
        zzb zzb2 = zzb;
        zzf zzf2 = zzf;
        int i2 = i;
        zzn zzn2 = zzn;
        AtomicInteger atomicInteger2 = atomicInteger;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        this.zzY = atomicInteger2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzZ = hashMap2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.zzaa = hashSet2;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue3 = priorityBlockingQueue;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue4 = new PriorityBlockingQueue<>();
        this.zzab = priorityBlockingQueue3;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue5 = priorityBlockingQueue2;
        PriorityBlockingQueue<zzk<?>> priorityBlockingQueue6 = new PriorityBlockingQueue<>();
        this.zzac = priorityBlockingQueue5;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.zzaf = arrayList2;
        this.zzj = zzb2;
        this.zzz = zzf2;
        this.zzad = new zzg[i2];
        this.zzk = zzn2;
    }

    public int getSequenceNumber() {
        return this.zzY.incrementAndGet();
    }

    public void start() {
        zzc zzc;
        zzg zzg;
        stop();
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc(this.zzab, this.zzac, this.zzj, this.zzk);
        this.zzae = zzc2;
        this.zzae.start();
        for (int i = 0; i < this.zzad.length; i++) {
            zzg zzg2 = zzg;
            zzg zzg3 = new zzg(this.zzac, this.zzz, this.zzj, this.zzk);
            zzg zzg4 = zzg2;
            this.zzad[i] = zzg4;
            zzg4.start();
        }
    }

    public void stop() {
        if (this.zzae != null) {
            this.zzae.quit();
        }
        for (int i = 0; i < this.zzad.length; i++) {
            if (this.zzad[i] != null) {
                this.zzad[i].quit();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r13v39, types: [java.util.Queue] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r13v40 */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r13v41, types: [java.util.Queue] */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r13v49 */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.android.gms.internal.zzk<T> zze(com.google.android.gms.internal.zzk<T> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r13 = r1
            r14 = r0
            com.google.android.gms.internal.zzk r13 = r13.zza(r14)
            r13 = r0
            java.util.Set<com.google.android.gms.internal.zzk<?>> r13 = r13.zzaa
            r3 = r13
            r13 = r3
            monitor-enter(r13)
            r13 = r0
            java.util.Set<com.google.android.gms.internal.zzk<?>> r13 = r13.zzaa     // Catch:{ all -> 0x003c }
            r14 = r1
            boolean r13 = r13.add(r14)     // Catch:{ all -> 0x003c }
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x003c }
            r13 = r1
            r14 = r0
            int r14 = r14.getSequenceNumber()
            com.google.android.gms.internal.zzk r13 = r13.zza(r14)
            r13 = r1
            java.lang.String r14 = "add-to-queue"
            r13.zzc(r14)
            r13 = r1
            boolean r13 = r13.zzr()
            if (r13 != 0) goto L_0x0042
            r13 = r0
            java.util.concurrent.PriorityBlockingQueue<com.google.android.gms.internal.zzk<?>> r13 = r13.zzac
            r14 = r1
            boolean r13 = r13.add(r14)
            r13 = r1
            r0 = r13
        L_0x003b:
            return r0
        L_0x003c:
            r13 = move-exception
            r4 = r13
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x003c }
            r13 = r4
            throw r13
        L_0x0042:
            r13 = r0
            java.util.Map<java.lang.String, java.util.Queue<com.google.android.gms.internal.zzk<?>>> r13 = r13.zzZ
            r7 = r13
            r13 = r7
            monitor-enter(r13)
            r13 = r1
            java.lang.String r13 = r13.zzh()     // Catch:{ all -> 0x009e }
            r9 = r13
            r13 = r0
            java.util.Map<java.lang.String, java.util.Queue<com.google.android.gms.internal.zzk<?>>> r13 = r13.zzZ     // Catch:{ all -> 0x009e }
            r14 = r9
            boolean r13 = r13.containsKey(r14)     // Catch:{ all -> 0x009e }
            if (r13 == 0) goto L_0x00a4
            r13 = r0
            java.util.Map<java.lang.String, java.util.Queue<com.google.android.gms.internal.zzk<?>>> r13 = r13.zzZ     // Catch:{ all -> 0x009e }
            r14 = r9
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x009e }
            java.util.Queue r13 = (java.util.Queue) r13     // Catch:{ all -> 0x009e }
            r12 = r13
            r13 = r12
            if (r13 != 0) goto L_0x0072
            java.util.LinkedList r13 = new java.util.LinkedList     // Catch:{ all -> 0x009e }
            r18 = r13
            r13 = r18
            r14 = r18
            r14.<init>()     // Catch:{ all -> 0x009e }
            r12 = r13
        L_0x0072:
            r13 = r12
            r14 = r1
            boolean r13 = r13.add(r14)     // Catch:{ all -> 0x009e }
            r13 = r0
            java.util.Map<java.lang.String, java.util.Queue<com.google.android.gms.internal.zzk<?>>> r13 = r13.zzZ     // Catch:{ all -> 0x009e }
            r14 = r9
            r15 = r12
            java.lang.Object r13 = r13.put(r14, r15)     // Catch:{ all -> 0x009e }
            boolean r13 = com.google.android.gms.internal.zzs.DEBUG     // Catch:{ all -> 0x009e }
            if (r13 == 0) goto L_0x0099
            java.lang.String r13 = "Request for cacheKey=%s is in flight, putting on hold."
            r14 = 1
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ all -> 0x009e }
            r18 = r14
            r14 = r18
            r15 = r18
            r16 = 0
            r17 = r9
            r15[r16] = r17     // Catch:{ all -> 0x009e }
            com.google.android.gms.internal.zzs.zza(r13, r14)     // Catch:{ all -> 0x009e }
        L_0x0099:
            r13 = r7
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r1
            r0 = r13
            goto L_0x003b
        L_0x009e:
            r13 = move-exception
            r8 = r13
            r13 = r7
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r8
            throw r13
        L_0x00a4:
            r13 = r0
            java.util.Map<java.lang.String, java.util.Queue<com.google.android.gms.internal.zzk<?>>> r13 = r13.zzZ     // Catch:{ all -> 0x009e }
            r14 = r9
            r15 = 0
            java.lang.Object r13 = r13.put(r14, r15)     // Catch:{ all -> 0x009e }
            r13 = r0
            java.util.concurrent.PriorityBlockingQueue<com.google.android.gms.internal.zzk<?>> r13 = r13.zzab     // Catch:{ all -> 0x009e }
            r14 = r1
            boolean r13 = r13.add(r14)     // Catch:{ all -> 0x009e }
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzl.zze(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzk");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public <T> void zzf(zzk<T> zzk2) {
        zzk<T> zzk3 = zzk2;
        List<zza> list = this.zzaa;
        synchronized (list) {
            try {
                boolean remove = this.zzaa.remove(zzk3);
            } finally {
                while (true) {
                    Throwable th = th;
                    List<zza> list2 = list;
                    Throwable th2 = th;
                }
            }
        }
        th = this.zzaf;
        synchronized (list) {
            try {
                for (zza zzg : this.zzaf) {
                    zzg.zzg(zzk3);
                }
            } finally {
                Throwable th3 = th;
                Map<String, Queue<zzk<?>>> map = list;
                Throwable th4 = th3;
            }
        }
        if (zzk3.zzr()) {
            th = this.zzZ;
            synchronized (r8) {
                try {
                    String zzh = zzk3.zzh();
                    Queue queue = (Queue) this.zzZ.remove(zzh);
                    if (queue != null) {
                        if (zzs.DEBUG) {
                            zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), zzh);
                        }
                        boolean addAll = this.zzab.addAll(queue);
                    }
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    Map<String, Queue<zzk<?>>> map2 = r8;
                    throw th6;
                }
            }
        }
    }
}
