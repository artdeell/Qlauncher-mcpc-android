package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;

@zzhb
class zzu implements Runnable {
    private boolean mCancelled = false;
    private zzk zzFo;

    zzu(zzk zzk) {
        zzk zzk2 = zzk;
        this.zzFo = zzk2;
    }

    public void cancel() {
        this.mCancelled = true;
        zzir.zzMc.removeCallbacks(this);
    }

    public void run() {
        if (!this.mCancelled) {
            this.zzFo.zzfF();
            zzfQ();
        }
    }

    public void zzfQ() {
        boolean postDelayed = zzir.zzMc.postDelayed(this, 250);
    }
}
