package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze implements zzn {
    private final Executor zzs;

    private class zza implements Runnable {
        final /* synthetic */ zze zzu;
        private final zzk zzv;
        private final zzm zzw;
        private final Runnable zzx;

        public zza(zze zze, zzk zzk, zzm zzm, Runnable runnable) {
            zzk zzk2 = zzk;
            zzm zzm2 = zzm;
            Runnable runnable2 = runnable;
            this.zzu = zze;
            this.zzv = zzk2;
            this.zzw = zzm2;
            this.zzx = runnable2;
        }

        public void run() {
            if (this.zzv.isCanceled()) {
                this.zzv.zzd("canceled-at-delivery");
                return;
            }
            if (this.zzw.isSuccess()) {
                this.zzv.zza(this.zzw.result);
            } else {
                this.zzv.zzc(this.zzw.zzah);
            }
            if (this.zzw.zzai) {
                this.zzv.zzc("intermediate-response");
            } else {
                this.zzv.zzd("done");
            }
            if (this.zzx != null) {
                this.zzx.run();
            }
        }
    }

    public zze(Handler handler) {
        C03251 r7;
        C03251 r3 = r7;
        final Handler handler2 = handler;
        C03251 r4 = new Executor(this) {
            final /* synthetic */ zze zzu;

            {
                Handler handler = r7;
                this.zzu = r6;
            }

            public void execute(Runnable runnable) {
                Runnable runnable2 = runnable;
                boolean post = handler2.post(runnable2);
            }
        };
        this.zzs = r3;
    }

    public void zza(zzk<?> zzk, zzm<?> zzm) {
        zza(zzk, zzm, null);
    }

    public void zza(zzk<?> zzk, zzm<?> zzm, Runnable runnable) {
        zza zza2;
        zzk<?> zzk2 = zzk;
        zzm<?> zzm2 = zzm;
        Runnable runnable2 = runnable;
        zzk2.zzv();
        zzk2.zzc("post-response");
        Executor executor = this.zzs;
        zza zza3 = zza2;
        zza zza4 = new zza(this, zzk2, zzm2, runnable2);
        executor.execute(zza3);
    }

    public void zza(zzk<?> zzk, zzr zzr) {
        zza zza2;
        zzk<?> zzk2 = zzk;
        zzr zzr2 = zzr;
        zzk2.zzc("post-error");
        zzm zzd = zzm.zzd(zzr2);
        Executor executor = this.zzs;
        zza zza3 = zza2;
        zza zza4 = new zza(this, zzk2, zzd, null);
        executor.execute(zza3);
    }
}
