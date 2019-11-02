package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.C0876zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzhb
public class zzhx extends C0876zza {
    private zzhy zzKC;
    private zzhv zzKJ;
    private zzhw zzKK;

    public zzhx(zzhw zzhw) {
        this.zzKK = zzhw;
    }

    public void zza(zzd zzd, RewardItemParcel rewardItemParcel) {
        zzd zzd2 = zzd;
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        if (this.zzKK != null) {
            this.zzKK.zzc(rewardItemParcel2);
        }
    }

    public void zza(zzhv zzhv) {
        zzhv zzhv2 = zzhv;
        this.zzKJ = zzhv2;
    }

    public void zza(zzhy zzhy) {
        zzhy zzhy2 = zzhy;
        this.zzKC = zzhy2;
    }

    public void zzb(zzd zzd, int i) {
        zzd zzd2 = zzd;
        int i2 = i;
        if (this.zzKJ != null) {
            this.zzKJ.zzN(i2);
        }
    }

    public void zzc(zzd zzd, int i) {
        zzd zzd2 = zzd;
        int i2 = i;
        if (this.zzKC != null) {
            this.zzKC.zza(zze.zzp(zzd2).getClass().getName(), i2);
        }
    }

    public void zzg(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKJ != null) {
            this.zzKJ.zzgN();
        }
    }

    public void zzh(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKC != null) {
            this.zzKC.zzax(zze.zzp(zzd2).getClass().getName());
        }
    }

    public void zzi(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdOpened();
        }
    }

    public void zzj(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoStarted();
        }
    }

    public void zzk(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdClosed();
        }
    }

    public void zzl(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKK != null) {
            this.zzKK.zzgM();
        }
    }

    public void zzm(zzd zzd) {
        zzd zzd2 = zzd;
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdLeftApplication();
        }
    }
}
