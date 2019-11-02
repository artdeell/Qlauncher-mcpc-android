package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.zze;
import java.util.concurrent.Callable;

@zzhb
public class zzbs {
    private final Object zzpV;
    private boolean zzqA = false;
    /* access modifiers changed from: private */
    public SharedPreferences zzvx = null;

    public zzbs() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    public void initialize(Context context) {
        Context context2 = context;
        Context context3 = this.zzpV;
        synchronized (context3) {
            try {
                if (!this.zzqA) {
                    th = zze.getRemoteContext(context2);
                    if (context3 != null) {
                        this.zzvx = zzr.zzbJ().zzw(context3);
                        this.zzqA = true;
                    }
                }
            } finally {
                Throwable th = th;
                Context context4 = context3;
                Throwable th2 = th;
            }
        }
    }

    public <T> T zzd(zzbp<T> zzbp) {
        Object obj;
        C02781 r9;
        zzbp<T> zzbp2 = zzbp;
        Object obj2 = this.zzpV;
        synchronized (obj2) {
            try {
                if (!this.zzqA) {
                    th = zzbp2.zzdq();
                    return obj;
                }
                C02781 r5 = r9;
                final zzbp<T> zzbp3 = zzbp2;
                C02781 r6 = new Callable<T>(this) {
                    final /* synthetic */ zzbs zzvz;

                    {
                        zzbp zzbp = r7;
                        this.zzvz = r6;
                    }

                    public T call() {
                        return zzbp3.zza(this.zzvz.zzvx);
                    }
                };
                return zzjb.zzb(r5);
            } finally {
                while (true) {
                    obj = th;
                    Object obj3 = obj2;
                    Throwable th = obj;
                }
            }
        }
    }
}
