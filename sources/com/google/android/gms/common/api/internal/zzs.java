package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zznk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzs {
    private static final ExecutorService zzaiv;

    static {
        ThreadPoolExecutor threadPoolExecutor;
        LinkedBlockingQueue linkedBlockingQueue;
        zznk zznk;
        ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue2 = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        zznk zznk2 = zznk;
        zznk zznk3 = new zznk("GAC_Transform");
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(0, 4, 60, timeUnit, linkedBlockingQueue2, zznk2);
        zzaiv = threadPoolExecutor2;
    }

    public static ExecutorService zzpN() {
        return zzaiv;
    }
}
