package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.zzcu.zza;

@zzhb
public class zzcz extends zza {
    private final OnCustomTemplateAdLoadedListener zzyV;

    public zzcz(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzyV = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzcp zzcp) {
        zzcq zzcq;
        zzcp zzcp2 = zzcp;
        OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener = this.zzyV;
        zzcq zzcq2 = zzcq;
        zzcq zzcq3 = new zzcq(zzcp2);
        onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded(zzcq2);
    }
}
