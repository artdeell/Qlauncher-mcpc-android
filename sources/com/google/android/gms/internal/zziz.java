package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zziz {
    private long zzMJ;
    private long zzMK = Long.MIN_VALUE;
    private Object zzpV;

    public zziz(long j) {
        Object obj;
        long j2 = j;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzMJ = j2;
    }

    /* JADX INFO: finally extract failed */
    public boolean tryAcquire() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                long elapsedRealtime = zzr.zzbG().elapsedRealtime();
                if (this.zzMK + this.zzMJ > elapsedRealtime) {
                    return false;
                }
                this.zzMK = elapsedRealtime;
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
