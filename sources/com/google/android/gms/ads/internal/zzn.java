package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzn extends zza {
    private static final Object zzqy;
    private static zzn zzqz;
    private final Context mContext;
    private final Object zzpV;
    private boolean zzqA;
    private float zzqB = -1.0f;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    zzn(Context context) {
        Object obj;
        Context context2 = context;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzqA = false;
    }

    public static zzn zzbs() {
        zzn zzn = zzqy;
        synchronized (zzn) {
            try {
                th = zzqz;
            } finally {
                Throwable th = th;
                zzn zzn2 = zzn;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static zzn zzr(Context context) {
        zzn zzn;
        zzn zzn2;
        Context context2 = context;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzqz == null) {
                    zzn zzn3 = zzn2;
                    zzn zzn4 = new zzn(context2.getApplicationContext());
                    zzqz = zzn3;
                }
                th = zzqz;
            } finally {
                zzn = th;
                Object obj2 = obj;
                Throwable th = zzn;
            }
        }
        return zzn;
    }

    public void setAppVolume(float f) {
        float f2 = f;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzqB = f2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza() {
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (this.zzqA) {
                    zzin.zzaK("Mobile ads is initialized already.");
                } else {
                    this.zzqA = true;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public float zzbt() {
        float f = this.zzpV;
        synchronized (f) {
            try {
                th = this.zzqB;
            } finally {
                Throwable th = th;
                float f2 = f;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean zzbu() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzqB >= 0.0f;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }
}
