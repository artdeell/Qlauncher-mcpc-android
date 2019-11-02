package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
public final class zziq {
    private static final ExecutorService zzLU = Executors.newFixedThreadPool(10, zzaB("Default"));
    private static final ExecutorService zzLV = Executors.newFixedThreadPool(5, zzaB("Loader"));

    public static zzjg<Void> zza(int i, Runnable runnable) {
        C04122 r6;
        C04111 r62;
        Runnable runnable2 = runnable;
        if (i == 1) {
            ExecutorService executorService = zzLV;
            C04111 r3 = r62;
            final Runnable runnable3 = runnable2;
            C04111 r4 = new Callable<Void>() {
                /* renamed from: zzdt */
                public Void call() {
                    runnable3.run();
                    return null;
                }
            };
            return zza(executorService, (Callable<T>) r3);
        }
        ExecutorService executorService2 = zzLU;
        C04122 r32 = r6;
        final Runnable runnable4 = runnable2;
        C04122 r42 = new Callable<Void>() {
            /* renamed from: zzdt */
            public Void call() {
                runnable4.run();
                return null;
            }
        };
        return zza(executorService2, (Callable<T>) r32);
    }

    public static zzjg<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzjg<T> zza(Callable<T> callable) {
        return zza(zzLU, callable);
    }

    public static <T> zzjg<T> zza(ExecutorService executorService, Callable<T> callable) {
        zzjd zzjd;
        C04144 r13;
        C04133 r132;
        ExecutorService executorService2 = executorService;
        Callable<T> callable2 = callable;
        zzjd zzjd2 = zzjd;
        zzjd zzjd3 = new zzjd();
        zzjd zzjd4 = zzjd2;
        zzjd zzjd5 = zzjd4;
        try {
            C04144 r5 = r13;
            final zzjd zzjd6 = zzjd4;
            ExecutorService executorService3 = executorService2;
            C04133 r9 = r132;
            final zzjd zzjd7 = zzjd4;
            final Callable<T> callable3 = callable2;
            C04133 r10 = new Runnable() {
                {
                    Callable callable = r7;
                }

                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        zzjd7.zzg(callable3.call());
                    } catch (Exception e) {
                        zzr.zzbF().zzb((Throwable) e, true);
                        boolean cancel = zzjd7.cancel(true);
                    }
                }
            };
            final Future submit = executorService3.submit(r9);
            C04144 r6 = new Runnable() {
                {
                    Future future = r7;
                }

                public void run() {
                    if (zzjd6.isCancelled()) {
                        boolean cancel = submit.cancel(true);
                    }
                }
            };
            zzjd5.zzc(r5);
            return zzjd4;
        } catch (RejectedExecutionException e) {
            zzin.zzd("Thread execution is rejected.", e);
            boolean cancel = zzjd4.cancel(true);
            return zzjd4;
        }
    }

    private static ThreadFactory zzaB(String str) {
        C04155 r4;
        C04155 r1 = r4;
        final String str2 = str;
        C04155 r2 = new ThreadFactory() {
            private final AtomicInteger zzMa;

            {
                AtomicInteger atomicInteger;
                AtomicInteger atomicInteger2 = atomicInteger;
                AtomicInteger atomicInteger3 = new AtomicInteger(1);
                this.zzMa = atomicInteger2;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread;
                StringBuilder sb;
                Thread thread2 = thread;
                Runnable runnable2 = runnable;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                Thread thread3 = new Thread(runnable2, sb2.append("AdWorker(").append(str2).append(") #").append(this.zzMa.getAndIncrement()).toString());
                return thread2;
            }
        };
        return r1;
    }
}
