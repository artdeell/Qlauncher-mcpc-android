package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class zzb {
    public static void zza(boolean z, Object obj) {
        IllegalStateException illegalStateException;
        Object obj2 = obj;
        if (!z) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(String.valueOf(obj2));
            throw illegalStateException2;
        }
    }

    public static void zzab(boolean z) {
        IllegalStateException illegalStateException;
        if (!z) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException();
            throw illegalStateException2;
        }
    }

    public static void zzcD(String str) {
        StringBuilder sb;
        IllegalStateException illegalStateException;
        String str2 = str;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e = Log.e("Asserts", sb2.append("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!").toString());
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(str2);
            throw illegalStateException2;
        }
    }

    public static void zzcE(String str) {
        StringBuilder sb;
        IllegalStateException illegalStateException;
        String str2 = str;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e = Log.e("Asserts", sb2.append("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!").toString());
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(str2);
            throw illegalStateException2;
        }
    }

    public static void zzv(Object obj) {
        IllegalArgumentException illegalArgumentException;
        if (obj == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("null reference");
            throw illegalArgumentException2;
        }
    }
}
