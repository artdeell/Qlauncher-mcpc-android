package com.google.android.gms.ads.internal.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzal extends zza {
    /* access modifiers changed from: private */
    public zzd zzvb;

    public zzal() {
    }

    public void destroy() throws RemoteException {
    }

    public boolean isLoaded() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
    }

    public void resume() throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
    }

    public void show() throws RemoteException {
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) throws RemoteException {
        C01651 r6;
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        zzb.m19e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
        C01651 r3 = r6;
        C01651 r4 = new Runnable(this) {
            final /* synthetic */ zzal zzvc;

            {
                this.zzvc = r5;
            }

            public void run() {
                if (this.zzvc.zzvb != null) {
                    try {
                        this.zzvc.zzvb.onRewardedVideoAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzb.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                    }
                }
            }
        };
        boolean post = handler.post(r3);
    }

    public void zza(zzd zzd) throws RemoteException {
        zzd zzd2 = zzd;
        this.zzvb = zzd2;
    }
}
