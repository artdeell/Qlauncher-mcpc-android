package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzdp extends zzim {
    final zzjp zzpD;
    final zzdr zzzJ;
    private final String zzzK;

    zzdp(zzjp zzjp, zzdr zzdr, String str) {
        zzdr zzdr2 = zzdr;
        String str2 = str;
        this.zzpD = zzjp;
        this.zzzJ = zzdr2;
        this.zzzK = str2;
        zzr.zzbR().zza(this);
    }

    public void onStop() {
        this.zzzJ.abort();
    }

    public void zzbr() {
        C02981 r6;
        C02981 r62;
        try {
            boolean zzU = this.zzzJ.zzU(this.zzzK);
            Handler handler = zzir.zzMc;
            C02981 r3 = r62;
            C02981 r4 = new Runnable(this) {
                final /* synthetic */ zzdp zzzL;

                {
                    this.zzzL = r5;
                }

                public void run() {
                    zzr.zzbR().zzb(this.zzzL);
                }
            };
            boolean post = handler.post(r3);
        } catch (Throwable th) {
            Throwable th2 = th;
            Handler handler2 = zzir.zzMc;
            C02981 r32 = r6;
            C02981 r42 = new Runnable(this) {
                final /* synthetic */ zzdp zzzL;

                {
                    this.zzzL = r5;
                }

                public void run() {
                    zzr.zzbR().zzb(this.zzzL);
                }
            };
            boolean post2 = handler2.post(r32);
            throw th2;
        }
    }
}
