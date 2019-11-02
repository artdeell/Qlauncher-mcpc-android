package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.util.concurrent.Callable;

@zzhb
public class zzjb {
    public static <T> T zzb(Callable<T> callable) {
        Builder builder;
        Callable<T> callable2 = callable;
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            Builder builder2 = builder;
            Builder builder3 = new Builder(threadPolicy);
            StrictMode.setThreadPolicy(builder2.permitDiskReads().permitDiskWrites().build());
            Object call = callable2.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            Throwable th2 = th;
            StrictMode.setThreadPolicy(threadPolicy);
            throw th2;
        }
    }
}
