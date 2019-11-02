package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zznk implements ThreadFactory {
    private final int mPriority;
    private final String zzaoq;
    private final AtomicInteger zzaor;
    private final ThreadFactory zzaos;

    public zznk(String str) {
        this(str, 0);
    }

    public zznk(String str, int i) {
        AtomicInteger atomicInteger;
        String str2 = str;
        int i2 = i;
        AtomicInteger atomicInteger2 = atomicInteger;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        this.zzaor = atomicInteger2;
        this.zzaos = Executors.defaultThreadFactory();
        this.zzaoq = (String) zzx.zzb(str2, (Object) "Name must not be null");
        this.mPriority = i2;
    }

    public Thread newThread(Runnable runnable) {
        zznl zznl;
        StringBuilder sb;
        Runnable runnable2 = runnable;
        ThreadFactory threadFactory = this.zzaos;
        zznl zznl2 = zznl;
        zznl zznl3 = new zznl(runnable2, this.mPriority);
        Thread newThread = threadFactory.newThread(zznl2);
        Thread thread = newThread;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        thread.setName(sb2.append(this.zzaoq).append("[").append(this.zzaor.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
