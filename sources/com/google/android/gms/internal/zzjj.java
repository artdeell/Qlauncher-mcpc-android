package com.google.android.gms.internal;

import com.google.android.gms.internal.zzji.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzhb
public class zzjj<T> implements zzji<T> {
    protected int zzBc = 0;
    protected final BlockingQueue<zza> zzNq;
    protected T zzNr;
    private final Object zzpV;

    class zza {
        public final zzc<T> zzNs;
        public final com.google.android.gms.internal.zzji.zza zzNt;
        final /* synthetic */ zzjj zzNu;

        public zza(zzjj zzjj, zzc<T> zzc, com.google.android.gms.internal.zzji.zza zza) {
            zzc<T> zzc2 = zzc;
            com.google.android.gms.internal.zzji.zza zza2 = zza;
            this.zzNu = zzjj;
            this.zzNs = zzc2;
            this.zzNt = zza2;
        }
    }

    public zzjj() {
        Object obj;
        LinkedBlockingQueue linkedBlockingQueue;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        LinkedBlockingQueue linkedBlockingQueue2 = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        this.zzNq = linkedBlockingQueue2;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public void reject() {
        UnsupportedOperationException unsupportedOperationException;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzBc != 0) {
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                    throw unsupportedOperationException2;
                }
                this.zzBc = -1;
                for (zza zza2 : this.zzNq) {
                    zza2.zzNt.run();
                }
                this.zzNq.clear();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zza(zzc<T> zzc, com.google.android.gms.internal.zzji.zza zza2) {
        zza zza3;
        zzc<T> zzc2 = zzc;
        com.google.android.gms.internal.zzji.zza zza4 = zza2;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzBc == 1) {
                    zzc2.zze(this.zzNr);
                } else if (this.zzBc == -1) {
                    zza4.run();
                } else if (this.zzBc == 0) {
                    BlockingQueue<zza> blockingQueue = this.zzNq;
                    zza zza5 = zza3;
                    zza zza6 = new zza(this, zzc2, zza4);
                    boolean add = blockingQueue.add(zza5);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzh(T t) {
        UnsupportedOperationException unsupportedOperationException;
        T t2 = t;
        t2 = this.zzpV;
        synchronized (t2) {
            try {
                if (this.zzBc != 0) {
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                    throw unsupportedOperationException2;
                }
                this.zzNr = t2;
                this.zzBc = 1;
                for (zza zza2 : this.zzNq) {
                    zza2.zzNs.zze(t2);
                }
                this.zzNq.clear();
            } finally {
                Throwable th = th;
                T t3 = t2;
                Throwable th2 = th;
            }
        }
    }
}
