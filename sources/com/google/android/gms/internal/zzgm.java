package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzgh.zza;

@zzhb
public final class zzgm extends zza {
    private final PlayStorePurchaseListener zzuP;

    public zzgm(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzuP = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.zzuP.isValidPurchase(str);
    }

    public void zza(zzgg zzgg) {
        zzgk zzgk;
        zzgg zzgg2 = zzgg;
        PlayStorePurchaseListener playStorePurchaseListener = this.zzuP;
        zzgk zzgk2 = zzgk;
        zzgk zzgk3 = new zzgk(zzgg2);
        playStorePurchaseListener.onInAppPurchaseFinished(zzgk2);
    }
}
