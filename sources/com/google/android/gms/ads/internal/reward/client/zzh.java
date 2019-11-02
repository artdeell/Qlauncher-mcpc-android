package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<RewardedVideoAdRequestParcel> {
    public zzh() {
    }

    static void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, rewardedVideoAdRequestParcel2.versionCode);
        zzb.zza(parcel2, 2, (Parcelable) rewardedVideoAdRequestParcel2.zzHt, i2, false);
        zzb.zza(parcel2, 3, rewardedVideoAdRequestParcel2.zzrj, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzM */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    /* renamed from: zzn */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel;
        C0881zza zza;
        StringBuilder sb;
        String zzp;
        AdRequestParcel adRequestParcel;
        int i;
        Parcel parcel2 = parcel;
        String str = null;
        int zzau = zza.zzau(parcel2);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    adRequestParcel = adRequestParcel2;
                    i = zza.zzg(parcel2, zzat);
                    zzp = str;
                    break;
                case 2:
                    i = i2;
                    zzp = str;
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel2, zzat, (Creator<T>) AdRequestParcel.CREATOR);
                    break;
                case 3:
                    zzp = zza.zzp(parcel2, zzat);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    zzp = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = zzp;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel3 = new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
        return rewardedVideoAdRequestParcel2;
    }
}
