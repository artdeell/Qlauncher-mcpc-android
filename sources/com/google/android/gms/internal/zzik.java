package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzik {
    private int zzLJ;
    private int zzLK;
    private final String zzLh;
    private final Object zzpV;
    private final zzih zzqV;

    zzik(zzih zzih, String str) {
        Object obj;
        zzih zzih2 = zzih;
        String str2 = str;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzqV = zzih2;
        this.zzLh = str2;
    }

    public zzik(String str) {
        this(zzr.zzbF(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2 = this.zzpV;
        synchronized (bundle2) {
            try {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle();
                th = bundle3;
                th.putInt("pmnli", this.zzLJ);
                th.putInt("pmnll", this.zzLK);
            } finally {
                Throwable th = th;
                Bundle bundle5 = bundle2;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzg(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLJ = i3;
                this.zzLK = i4;
                this.zzqV.zza(this.zzLh, this);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
