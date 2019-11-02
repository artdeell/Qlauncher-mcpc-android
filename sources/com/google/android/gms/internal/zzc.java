package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb.zza;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {
    private static final boolean DEBUG = zzs.DEBUG;
    private final BlockingQueue<zzk<?>> zzh;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzk<?>> zzi;
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb zzb, zzn zzn) {
        BlockingQueue<zzk<?>> blockingQueue3 = blockingQueue;
        BlockingQueue<zzk<?>> blockingQueue4 = blockingQueue2;
        zzb zzb2 = zzb;
        zzn zzn2 = zzn;
        this.zzh = blockingQueue3;
        this.zzi = blockingQueue4;
        this.zzj = zzb2;
        this.zzk = zzn2;
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    public void run() {
        zzi zzi2;
        C02841 r12;
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.zza();
        while (true) {
            try {
                zzk zzk2 = (zzk) this.zzh.take();
                zzk2.zzc("cache-queue-take");
                if (zzk2.isCanceled()) {
                    zzk2.zzd("cache-discard-canceled");
                } else {
                    zza zza = this.zzj.zza(zzk2.zzh());
                    if (zza == null) {
                        zzk2.zzc("cache-miss");
                        this.zzi.put(zzk2);
                    } else if (zza.zzb()) {
                        zzk2.zzc("cache-hit-expired");
                        zzk zza2 = zzk2.zza(zza);
                        this.zzi.put(zzk2);
                    } else {
                        zzk2.zzc("cache-hit");
                        zzk zzk3 = zzk2;
                        zzi zzi3 = zzi2;
                        zzi zzi4 = new zzi(zza.data, zza.zzg);
                        zzm zza3 = zzk3.zza(zzi3);
                        zzk2.zzc("cache-hit-parsed");
                        if (!zza.zzc()) {
                            this.zzk.zza(zzk2, zza3);
                        } else {
                            zzk2.zzc("cache-hit-refresh-needed");
                            zzk zza4 = zzk2.zza(zza);
                            zza3.zzai = true;
                            zzn zzn = this.zzk;
                            zzk zzk4 = zzk2;
                            zzm zzm = zza3;
                            C02841 r8 = r12;
                            final zzk zzk5 = zzk2;
                            C02841 r9 = new Runnable(this) {
                                final /* synthetic */ zzc zzn;

                                {
                                    zzk zzk = r7;
                                    this.zzn = r6;
                                }

                                public void run() {
                                    try {
                                        this.zzn.zzi.put(zzk5);
                                    } catch (InterruptedException e) {
                                        InterruptedException interruptedException = e;
                                    }
                                }
                            };
                            zzn.zza(zzk4, zzm, r8);
                        }
                    }
                }
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
