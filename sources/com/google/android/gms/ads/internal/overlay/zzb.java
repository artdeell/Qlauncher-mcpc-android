package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;

public class zzb implements Creator<AdLauncherIntentInfoParcel> {
    public zzb() {
    }

    static void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, adLauncherIntentInfoParcel2.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 2, adLauncherIntentInfoParcel2.intentAction, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, adLauncherIntentInfoParcel2.url, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 4, adLauncherIntentInfoParcel2.mimeType, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 5, adLauncherIntentInfoParcel2.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 6, adLauncherIntentInfoParcel2.zzDK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 7, adLauncherIntentInfoParcel2.zzDL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 8, adLauncherIntentInfoParcel2.zzDM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 9, (Parcelable) adLauncherIntentInfoParcel2.intent, i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzf */
    public AdLauncherIntentInfoParcel createFromParcel(Parcel parcel) {
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        Intent intent = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str7 = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str6 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 9:
                    intent = (Intent) zza.zza(parcel2, zzat, Intent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel3 = new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        return adLauncherIntentInfoParcel2;
    }

    /* renamed from: zzv */
    public AdLauncherIntentInfoParcel[] newArray(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }
}
