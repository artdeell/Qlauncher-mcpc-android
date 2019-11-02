package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;

public abstract class zzg<T> {
    private final String zzavI;
    private T zzavJ;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.zzavI = str;
    }

    /* access modifiers changed from: protected */
    public final T zzaB(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        Context context2 = context;
        if (this.zzavJ == null) {
            Object zzz = zzx.zzz(context2);
            Context remoteContext = zze.getRemoteContext(context2);
            if (remoteContext == null) {
                zza zza6 = zza5;
                zza zza7 = new zza("Could not get remote context.");
                throw zza6;
            }
            try {
                this.zzavJ = zzd((IBinder) remoteContext.getClassLoader().loadClass(this.zzavI).newInstance());
            } catch (ClassNotFoundException e) {
                ClassNotFoundException classNotFoundException = e;
                zza zza8 = zza4;
                zza zza9 = new zza("Could not load creator class.", classNotFoundException);
                throw zza8;
            } catch (InstantiationException e2) {
                InstantiationException instantiationException = e2;
                zza zza10 = zza3;
                zza zza11 = new zza("Could not instantiate creator.", instantiationException);
                throw zza10;
            } catch (IllegalAccessException e3) {
                IllegalAccessException illegalAccessException = e3;
                zza zza12 = zza2;
                zza zza13 = new zza("Could not access creator.", illegalAccessException);
                throw zza12;
            }
        }
        return this.zzavJ;
    }

    /* access modifiers changed from: protected */
    public abstract T zzd(IBinder iBinder);
}
