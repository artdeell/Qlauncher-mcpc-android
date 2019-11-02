package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;

@zzhb
class zzdx {
    zzw zzAq;
    zzgd zzAr;
    zzcf zzAs;
    zzp zzAt;
    zzd zzAu;
    zzq zzpK;

    private class zza extends com.google.android.gms.ads.internal.client.zzq.zza {
        zzq zzAv;
        final /* synthetic */ zzdx zzAw;

        zza(zzdx zzdx, zzq zzq) {
            zzq zzq2 = zzq;
            this.zzAw = zzdx;
            this.zzAv = zzq2;
        }

        public void onAdClosed() throws RemoteException {
            this.zzAv.onAdClosed();
            zzr.zzbN().zzee();
        }

        public void onAdFailedToLoad(int i) throws RemoteException {
            int i2 = i;
            this.zzAv.onAdFailedToLoad(i2);
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzAv.onAdLeftApplication();
        }

        public void onAdLoaded() throws RemoteException {
            this.zzAv.onAdLoaded();
        }

        public void onAdOpened() throws RemoteException {
            this.zzAv.onAdOpened();
        }
    }

    zzdx() {
    }

    /* access modifiers changed from: 0000 */
    public void zzc(zzk zzk) {
        zza zza2;
        zzk zzk2 = zzk;
        if (this.zzpK != null) {
            zzk zzk3 = zzk2;
            zza zza3 = zza2;
            zza zza4 = new zza(this, this.zzpK);
            zzk3.zza((zzq) zza3);
        }
        if (this.zzAq != null) {
            zzk2.zza(this.zzAq);
        }
        if (this.zzAr != null) {
            zzk2.zza(this.zzAr);
        }
        if (this.zzAs != null) {
            zzk2.zza(this.zzAs);
        }
        if (this.zzAt != null) {
            zzk2.zza(this.zzAt);
        }
        if (this.zzAu != null) {
            zzk2.zza(this.zzAu);
        }
    }
}
