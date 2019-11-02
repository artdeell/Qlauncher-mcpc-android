package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.zzct.zza;

@zzhb
public class zzcy extends zza {
    private final OnCustomClickListener zzyU;

    public zzcy(OnCustomClickListener onCustomClickListener) {
        this.zzyU = onCustomClickListener;
    }

    public void zza(zzcp zzcp, String str) {
        zzcq zzcq;
        zzcp zzcp2 = zzcp;
        String str2 = str;
        OnCustomClickListener onCustomClickListener = this.zzyU;
        zzcq zzcq2 = zzcq;
        zzcq zzcq3 = new zzcq(zzcp2);
        onCustomClickListener.onCustomClick(zzcq2, str2);
    }
}
