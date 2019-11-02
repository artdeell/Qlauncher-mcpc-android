package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcf.zza;

@zzhb
public final class zzcg extends zza {
    private final OnCustomRenderedAdLoadedListener zzuQ;

    public zzcg(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuQ = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzce zzce) {
        zzcd zzcd;
        zzce zzce2 = zzce;
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener = this.zzuQ;
        zzcd zzcd2 = zzcd;
        zzcd zzcd3 = new zzcd(zzce2);
        onCustomRenderedAdLoadedListener.onCustomRenderedAdLoaded(zzcd2);
    }
}
