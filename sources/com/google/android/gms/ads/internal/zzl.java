package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<InterstitialAdParameterParcel> {
    public zzl() {
    }

    static void zza(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, interstitialAdParameterParcel2.versionCode);
        zzb.zza(parcel2, 2, interstitialAdParameterParcel2.zzql);
        zzb.zza(parcel2, 3, interstitialAdParameterParcel2.zzqm);
        zzb.zza(parcel2, 4, interstitialAdParameterParcel2.zzqn, false);
        zzb.zza(parcel2, 5, interstitialAdParameterParcel2.zzqo);
        zzb.zza(parcel2, 6, interstitialAdParameterParcel2.zzqp);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zza */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        InterstitialAdParameterParcel interstitialAdParameterParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    f = zza.zzl(parcel2, zzat);
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
        InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
        InterstitialAdParameterParcel interstitialAdParameterParcel3 = new InterstitialAdParameterParcel(i, z3, z2, str, z, f);
        return interstitialAdParameterParcel2;
    }

    /* renamed from: zzg */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
