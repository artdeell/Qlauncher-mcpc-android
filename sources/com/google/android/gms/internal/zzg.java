package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzk<?>> zzy;
    private final zzf zzz;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf zzf, zzb zzb, zzn zzn) {
        BlockingQueue<zzk<?>> blockingQueue2 = blockingQueue;
        zzf zzf2 = zzf;
        zzb zzb2 = zzb;
        zzn zzn2 = zzn;
        this.zzy = blockingQueue2;
        this.zzz = zzf2;
        this.zzj = zzb2;
        this.zzk = zzn2;
    }

    @TargetApi(14)
    private void zzb(zzk<?> zzk2) {
        zzk<?> zzk3 = zzk2;
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzk3.zzg());
        }
    }

    private void zzb(zzk<?> zzk2, zzr zzr) {
        zzk<?> zzk3 = zzk2;
        this.zzk.zza(zzk3, zzk3.zzb(zzr));
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    public void run() {
        zzr zzr;
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk zzk2 = (zzk) this.zzy.take();
                try {
                    zzk2.zzc("network-queue-take");
                    if (zzk2.isCanceled()) {
                        zzk2.zzd("network-discard-cancelled");
                    } else {
                        zzb(zzk2);
                        zzi zza = this.zzz.zza(zzk2);
                        zzk2.zzc("network-http-complete");
                        if (!zza.zzB || !zzk2.zzw()) {
                            zzm zza2 = zzk2.zza(zza);
                            zzk2.zzc("network-parse-complete");
                            if (zzk2.zzr() && zza2.zzag != null) {
                                this.zzj.zza(zzk2.zzh(), zza2.zzag);
                                zzk2.zzc("network-cache-written");
                            }
                            zzk2.zzv();
                            this.zzk.zza(zzk2, zza2);
                        } else {
                            zzk2.zzd("not-modified");
                        }
                    }
                } catch (zzr e) {
                    zzr zzr2 = e;
                    zzr2.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    zzb(zzk2, zzr2);
                } catch (Exception e2) {
                    Exception exc = e2;
                    zzs.zza(exc, "Unhandled exception %s", exc.toString());
                    zzr zzr3 = zzr;
                    zzr zzr4 = new zzr((Throwable) exc);
                    zzr zzr5 = zzr3;
                    zzr5.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzk.zza(zzk2, zzr5);
                }
            } catch (InterruptedException e3) {
                InterruptedException interruptedException = e3;
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
