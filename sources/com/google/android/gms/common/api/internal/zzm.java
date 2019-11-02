package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zznk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzm {
    private static final ExecutorService zzaiv;

    static {
        zznk zznk;
        zznk zznk2 = zznk;
        zznk zznk3 = new zznk("GAC_Executor");
        zzaiv = Executors.newFixedThreadPool(2, zznk2);
    }

    public static ExecutorService zzpN() {
        return zzaiv;
    }
}
