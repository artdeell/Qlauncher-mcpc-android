package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzalh;
    private static ClassLoader zzali = null;
    private static Integer zzalj = null;
    private boolean zzalk = false;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzalh = obj2;
    }

    public DowngradeableSafeParcel() {
    }

    private static boolean zza(Class<?> cls) {
        Class<?> cls2 = cls;
        try {
            return SafeParcelable.NULL.equals(cls2.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
            NoSuchFieldException noSuchFieldException = e;
            return false;
        } catch (IllegalAccessException e2) {
            IllegalAccessException illegalAccessException = e2;
            return false;
        }
    }

    protected static boolean zzcF(String str) {
        String str2 = str;
        ClassLoader zzqA = zzqA();
        if (zzqA == null) {
            return true;
        }
        try {
            return zza(zzqA.loadClass(str2));
        } catch (Exception e) {
            Exception exc = e;
            return false;
        }
    }

    protected static ClassLoader zzqA() {
        ClassLoader classLoader = zzalh;
        synchronized (classLoader) {
            try {
                th = zzali;
            } finally {
                Throwable th = th;
                ClassLoader classLoader2 = classLoader;
                Throwable th2 = th;
            }
        }
        return th;
    }

    protected static Integer zzqB() {
        Integer num = zzalh;
        synchronized (num) {
            try {
                th = zzalj;
            } finally {
                Throwable th = th;
                Integer num2 = num;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: protected */
    public boolean zzqC() {
        return this.zzalk;
    }
}
