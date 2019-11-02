package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<AdOverlayInfoParcel> {
    public zzf() {
    }

    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, adOverlayInfoParcel2.versionCode);
        zzb.zza(parcel2, 2, (Parcelable) adOverlayInfoParcel2.zzEA, i2, false);
        zzb.zza(parcel2, 3, adOverlayInfoParcel2.zzfs(), false);
        zzb.zza(parcel2, 4, adOverlayInfoParcel2.zzft(), false);
        zzb.zza(parcel2, 5, adOverlayInfoParcel2.zzfu(), false);
        zzb.zza(parcel2, 6, adOverlayInfoParcel2.zzfv(), false);
        zzb.zza(parcel2, 7, adOverlayInfoParcel2.zzEF, false);
        zzb.zza(parcel2, 8, adOverlayInfoParcel2.zzEG);
        zzb.zza(parcel2, 9, adOverlayInfoParcel2.zzEH, false);
        zzb.zza(parcel2, 10, adOverlayInfoParcel2.zzfx(), false);
        zzb.zzc(parcel2, 11, adOverlayInfoParcel2.orientation);
        zzb.zzc(parcel2, 12, adOverlayInfoParcel2.zzEJ);
        zzb.zza(parcel2, 13, adOverlayInfoParcel2.url, false);
        zzb.zza(parcel2, 14, (Parcelable) adOverlayInfoParcel2.zzrl, i2, false);
        zzb.zza(parcel2, 15, adOverlayInfoParcel2.zzfw(), false);
        zzb.zza(parcel2, 17, (Parcelable) adOverlayInfoParcel2.zzEM, i2, false);
        zzb.zza(parcel2, 16, adOverlayInfoParcel2.zzEL, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzg */
    public AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel2, zzat, (Creator<T>) AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel2, zzat);
                    break;
                case 4:
                    iBinder2 = zza.zzq(parcel2, zzat);
                    break;
                case 5:
                    iBinder3 = zza.zzq(parcel2, zzat);
                    break;
                case 6:
                    iBinder4 = zza.zzq(parcel2, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 9:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    iBinder5 = zza.zzq(parcel2, zzat);
                    break;
                case 11:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 12:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 13:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel2, zzat, (Creator<T>) VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzq(parcel2, zzat);
                    break;
                case 16:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel2, zzat, (Creator<T>) InterstitialAdParameterParcel.CREATOR);
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
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        return adOverlayInfoParcel2;
    }

    /* renamed from: zzz */
    public AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
