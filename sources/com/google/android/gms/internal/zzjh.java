package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

@zzhb
class zzjh {
    private final Object zzNm;
    private final List<Runnable> zzNn;
    private final List<Runnable> zzNo;
    private boolean zzNp = false;

    public zzjh() {
        Object obj;
        ArrayList arrayList;
        ArrayList arrayList2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzNm = obj2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        this.zzNn = arrayList3;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        this.zzNo = arrayList5;
    }

    private void zzd(Runnable runnable) {
        zzjg zza = zziq.zza(runnable);
    }

    private void zze(Runnable runnable) {
        boolean post = zza.zzMS.post(runnable);
    }

    /* JADX INFO: finally extract failed */
    public void zzb(Runnable runnable) {
        Runnable runnable2 = runnable;
        Object obj = this.zzNm;
        synchronized (obj) {
            try {
                if (this.zzNp) {
                    zzd(runnable2);
                } else {
                    boolean add = this.zzNn.add(runnable2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzc(Runnable runnable) {
        Runnable runnable2 = runnable;
        Object obj = this.zzNm;
        synchronized (obj) {
            try {
                if (this.zzNp) {
                    zze(runnable2);
                } else {
                    boolean add = this.zzNo.add(runnable2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzhK() {
        Object obj = this.zzNm;
        synchronized (obj) {
            try {
                if (!this.zzNp) {
                    for (Runnable zzd : this.zzNn) {
                        zzd(zzd);
                    }
                    for (Runnable zze : this.zzNo) {
                        zze(zze);
                    }
                    this.zzNn.clear();
                    this.zzNo.clear();
                    this.zzNp = true;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
