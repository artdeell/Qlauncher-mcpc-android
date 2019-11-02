package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class zzx {
    public static int zza(int i, Object obj) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        Object obj2 = obj;
        if (i2 != 0) {
            return i2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.valueOf(obj2));
        throw illegalArgumentException2;
    }

    public static long zza(long j, Object obj) {
        IllegalArgumentException illegalArgumentException;
        long j2 = j;
        Object obj2 = obj;
        if (j2 != 0) {
            return j2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.valueOf(obj2));
        throw illegalArgumentException2;
    }

    public static void zza(boolean z, Object obj) {
        IllegalStateException illegalStateException;
        Object obj2 = obj;
        if (!z) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(String.valueOf(obj2));
            throw illegalStateException2;
        }
    }

    public static void zza(boolean z, String str, Object... objArr) {
        IllegalStateException illegalStateException;
        String str2 = str;
        Object[] objArr2 = objArr;
        if (!z) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(String.format(str2, objArr2));
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

    public static void zzac(boolean z) {
        IllegalArgumentException illegalArgumentException;
        if (!z) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
    }

    public static <T> T zzb(T t, Object obj) {
        NullPointerException nullPointerException;
        T t2 = t;
        Object obj2 = obj;
        if (t2 != null) {
            return t2;
        }
        NullPointerException nullPointerException2 = nullPointerException;
        NullPointerException nullPointerException3 = new NullPointerException(String.valueOf(obj2));
        throw nullPointerException2;
    }

    public static void zzb(boolean z, Object obj) {
        IllegalArgumentException illegalArgumentException;
        Object obj2 = obj;
        if (!z) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.valueOf(obj2));
            throw illegalArgumentException2;
        }
    }

    public static void zzb(boolean z, String str, Object... objArr) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        Object[] objArr2 = objArr;
        if (!z) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.format(str2, objArr2));
            throw illegalArgumentException2;
        }
    }

    public static int zzbV(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 != 0) {
            return i2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Given Integer is zero");
        throw illegalArgumentException2;
    }

    public static void zzcD(String str) {
        IllegalStateException illegalStateException;
        String str2 = str;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(str2);
            throw illegalStateException2;
        }
    }

    public static void zzcE(String str) {
        IllegalStateException illegalStateException;
        String str2 = str;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(str2);
            throw illegalStateException2;
        }
    }

    public static String zzcM(String str) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Given String is empty or null");
        throw illegalArgumentException2;
    }

    public static String zzh(String str, Object obj) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        Object obj2 = obj;
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(String.valueOf(obj2));
        throw illegalArgumentException2;
    }

    public static <T> T zzz(T t) {
        NullPointerException nullPointerException;
        T t2 = t;
        if (t2 != null) {
            return t2;
        }
        NullPointerException nullPointerException2 = nullPointerException;
        NullPointerException nullPointerException3 = new NullPointerException("null reference");
        throw nullPointerException2;
    }
}
