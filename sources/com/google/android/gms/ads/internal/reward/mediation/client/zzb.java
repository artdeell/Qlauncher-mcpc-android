package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzKR;

    public zzb(zza zza) {
        this.zzKR = zza;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClicked.");
        try {
            this.zzKR.zzl(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClosed.");
        try {
            this.zzKR.zzk(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        int i2 = i;
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdFailedToLoad.");
        try {
            this.zzKR.zzc(zze.zzC(mediationRewardedVideoAdAdapter2), i2);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzKR.zzm(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLoaded.");
        try {
            this.zzKR.zzh(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdOpened.");
        try {
            this.zzKR.zzi(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        int i2 = i;
        zzx.zzcD("onInitializationFailed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationFailed.");
        try {
            this.zzKR.zzb(zze.zzC(mediationRewardedVideoAdAdapter2), i2);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onInitializationSucceeded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationSucceeded.");
        try {
            this.zzKR.zzg(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        RewardItemParcel rewardItemParcel;
        RewardItemParcel rewardItemParcel2;
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        RewardItem rewardItem2 = rewardItem;
        zzx.zzcD("onRewarded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onRewarded.");
        if (rewardItem2 != null) {
            try {
                zza zza = this.zzKR;
                zzd zzC = zze.zzC(mediationRewardedVideoAdAdapter2);
                RewardItemParcel rewardItemParcel3 = rewardItemParcel2;
                RewardItemParcel rewardItemParcel4 = new RewardItemParcel(rewardItem2);
                zza.zza(zzC, rewardItemParcel3);
            } catch (RemoteException e) {
                zzin.zzd("Could not call onRewarded.", e);
            }
        } else {
            zza zza2 = this.zzKR;
            zzd zzC2 = zze.zzC(mediationRewardedVideoAdAdapter2);
            RewardItemParcel rewardItemParcel5 = rewardItemParcel;
            RewardItemParcel rewardItemParcel6 = new RewardItemParcel(mediationRewardedVideoAdAdapter2.getClass().getName(), 1);
            zza2.zza(zzC2, rewardItemParcel5);
        }
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
        zzx.zzcD("onVideoStarted must be called on the main UI thread.");
        zzin.zzaI("Adapter called onVideoStarted.");
        try {
            this.zzKR.zzj(zze.zzC(mediationRewardedVideoAdAdapter2));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onVideoStarted.", e);
        }
    }
}
