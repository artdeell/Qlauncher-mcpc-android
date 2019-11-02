package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzhb
public abstract class zzim implements zzit<Future> {
    private volatile Thread zzLM;
    private boolean zzLN;
    private final Runnable zzx;

    public zzim() {
        C04021 r5;
        C04021 r2 = r5;
        C04021 r3 = new Runnable(this) {
            final /* synthetic */ zzim zzLO;

            {
                this.zzLO = r5;
            }

            public final void run() {
                Thread zza = zzim.zza(this.zzLO, Thread.currentThread());
                this.zzLO.zzbr();
            }
        };
        this.zzx = r2;
        this.zzLN = false;
    }

    public zzim(boolean z) {
        C04021 r6;
        boolean z2 = z;
        C04021 r3 = r6;
        C04021 r4 = new Runnable(this) {
            final /* synthetic */ zzim zzLO;

            {
                this.zzLO = r5;
            }

            public final void run() {
                Thread zza = zzim.zza(this.zzLO, Thread.currentThread());
                this.zzLO.zzbr();
            }
        };
        this.zzx = r3;
        this.zzLN = z2;
    }

    static /* synthetic */ Thread zza(zzim zzim, Thread thread) {
        Thread thread2 = thread;
        zzim.zzLM = thread2;
        return thread2;
    }

    public final void cancel() {
        onStop();
        if (this.zzLM != null) {
            this.zzLM.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbr();

    /* renamed from: zzhn */
    public final Future zzgd() {
        return this.zzLN ? zziq.zza(1, this.zzx) : zziq.zza(this.zzx);
    }
}
