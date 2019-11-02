package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzhb
public class zzgl implements InAppPurchase {
    private final zzgc zzFL;

    public zzgl(zzgc zzgc) {
        this.zzFL = zzgc;
    }

    public String getProductId() {
        try {
            return this.zzFL.getProductId();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzFL.recordPlayBillingResolution(i);
        } catch (RemoteException e) {
            zzin.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzFL.recordResolution(i);
        } catch (RemoteException e) {
            zzin.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
