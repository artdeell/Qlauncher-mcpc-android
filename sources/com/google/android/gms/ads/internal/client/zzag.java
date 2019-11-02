package com.google.android.gms.ads.internal.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;

public class zzag extends com.google.android.gms.ads.internal.client.zzs.zza {
    /* access modifiers changed from: private */
    public zzq zzpK;

    private class zza extends com.google.android.gms.ads.internal.client.zzr.zza {
        final /* synthetic */ zzag zzuY;

        private zza(zzag zzag) {
            this.zzuY = zzag;
        }

        /* synthetic */ zza(zzag zzag, C01621 r7) {
            C01621 r2 = r7;
            this(zzag);
        }

        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        public boolean isLoading() throws RemoteException {
            return false;
        }

        public void zzf(AdRequestParcel adRequestParcel) throws RemoteException {
            C01631 r6;
            AdRequestParcel adRequestParcel2 = adRequestParcel;
            zzb.m19e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
            C01631 r3 = r6;
            C01631 r4 = new Runnable(this) {
                final /* synthetic */ zza zzuZ;

                {
                    this.zzuZ = r5;
                }

                public void run() {
                    if (this.zzuZ.zzuY.zzpK != null) {
                        try {
                            this.zzuZ.zzuY.zzpK.onAdFailedToLoad(1);
                        } catch (RemoteException e) {
                            zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                        }
                    }
                }
            };
            boolean post = handler.post(r3);
        }
    }

    public zzag() {
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
    }

    public void zza(zzcr zzcr) throws RemoteException {
    }

    public void zza(zzcs zzcs) throws RemoteException {
    }

    public void zza(String str, zzcu zzcu, zzct zzct) throws RemoteException {
    }

    public void zzb(zzq zzq) throws RemoteException {
        zzq zzq2 = zzq;
        this.zzpK = zzq2;
    }

    public void zzb(zzx zzx) throws RemoteException {
    }

    public zzr zzbn() throws RemoteException {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, null);
        return zza3;
    }
}
