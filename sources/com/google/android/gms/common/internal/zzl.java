package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl {
    private static final Object zzalX;
    private static zzl zzalY;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzalX = obj2;
    }

    public zzl() {
    }

    public static zzl zzau(Context context) {
        zzm zzm;
        Context context2 = context;
        Object obj = zzalX;
        synchronized (obj) {
            try {
                if (zzalY == null) {
                    zzm zzm2 = zzm;
                    zzm zzm3 = new zzm(context2.getApplicationContext());
                    zzalY = zzm2;
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        return zzalY;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, ServiceConnection serviceConnection, String str2);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, ServiceConnection serviceConnection, String str2);
}
