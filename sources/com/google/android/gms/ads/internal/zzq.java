package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;

@zzhb
public class zzq {
    private final zza zzqG;
    /* access modifiers changed from: private */
    public AdRequestParcel zzqH;
    private boolean zzqI;
    private boolean zzqJ;
    private long zzqK;
    private final Runnable zzx;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            Runnable runnable2 = runnable;
            this.mHandler.removeCallbacks(runnable2);
        }
    }

    public zzq(zza zza2) {
        zza zza3;
        zza zza4 = zza2;
        zza zza5 = zza3;
        zza zza6 = new zza(zzir.zzMc);
        this(zza4, zza5);
    }

    zzq(zza zza2, zza zza3) {
        C02131 r10;
        WeakReference weakReference;
        zza zza4 = zza2;
        zza zza5 = zza3;
        this.zzqI = false;
        this.zzqJ = false;
        this.zzqK = 0;
        this.zzqG = zza5;
        C02131 r4 = r10;
        final WeakReference weakReference2 = weakReference;
        WeakReference weakReference3 = new WeakReference(zza4);
        C02131 r5 = new Runnable(this) {
            final /* synthetic */ zzq zzqM;

            {
                WeakReference weakReference = r7;
                this.zzqM = r6;
            }

            public void run() {
                boolean zza = zzq.zza(this.zzqM, false);
                zza zza2 = (zza) weakReference2.get();
                if (zza2 != null) {
                    zza2.zzd(this.zzqM.zzqH);
                }
            }
        };
        this.zzx = r4;
    }

    static /* synthetic */ boolean zza(zzq zzq, boolean z) {
        boolean z2 = z;
        zzq.zzqI = z2;
        return z2;
    }

    public void cancel() {
        this.zzqI = false;
        this.zzqG.removeCallbacks(this.zzx);
    }

    public void pause() {
        this.zzqJ = true;
        if (this.zzqI) {
            this.zzqG.removeCallbacks(this.zzx);
        }
    }

    public void resume() {
        this.zzqJ = false;
        if (this.zzqI) {
            this.zzqI = false;
            zza(this.zzqH, this.zzqK);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        StringBuilder sb;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        long j2 = j;
        if (this.zzqI) {
            zzin.zzaK("An ad refresh is already scheduled.");
            return;
        }
        this.zzqH = adRequestParcel2;
        this.zzqI = true;
        this.zzqK = j2;
        if (!this.zzqJ) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaJ(sb2.append("Scheduling ad refresh ").append(j2).append(" milliseconds from now.").toString());
            boolean postDelayed = this.zzqG.postDelayed(this.zzx, j2);
        }
    }

    public boolean zzbw() {
        return this.zzqI;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
