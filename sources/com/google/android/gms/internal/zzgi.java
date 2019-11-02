package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgd.zza;

@zzhb
public final class zzgi extends zza {
    private final InAppPurchaseListener zzuO;

    public zzgi(InAppPurchaseListener inAppPurchaseListener) {
        this.zzuO = inAppPurchaseListener;
    }

    public void zza(zzgc zzgc) {
        zzgl zzgl;
        zzgc zzgc2 = zzgc;
        InAppPurchaseListener inAppPurchaseListener = this.zzuO;
        zzgl zzgl2 = zzgl;
        zzgl zzgl3 = new zzgl(zzgc2);
        inAppPurchaseListener.onInAppPurchaseRequested(zzgl2);
    }
}
