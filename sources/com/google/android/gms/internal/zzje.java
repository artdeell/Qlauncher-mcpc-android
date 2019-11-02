package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzhb
public class zzje<T> implements zzjg<T> {
    private final T zzNc;
    private final zzjh zzNe;

    public zzje(T t) {
        zzjh zzjh;
        this.zzNc = t;
        zzjh zzjh2 = zzjh;
        zzjh zzjh3 = new zzjh();
        this.zzNe = zzjh2;
        this.zzNe.zzhK();
    }

    public boolean cancel(boolean z) {
        boolean z2 = z;
        return false;
    }

    public T get() {
        return this.zzNc;
    }

    public T get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        return this.zzNc;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void zzb(Runnable runnable) {
        Runnable runnable2 = runnable;
        this.zzNe.zzb(runnable2);
    }
}
