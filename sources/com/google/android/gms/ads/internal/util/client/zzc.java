package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<VersionInfoParcel> {
    public zzc() {
    }

    static void zza(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, versionInfoParcel2.versionCode);
        zzb.zza(parcel2, 2, versionInfoParcel2.afmaVersion, false);
        zzb.zzc(parcel2, 3, versionInfoParcel2.zzMZ);
        zzb.zzc(parcel2, 4, versionInfoParcel2.zzNa);
        zzb.zza(parcel2, 5, versionInfoParcel2.zzNb);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzR */
    public VersionInfoParcel[] newArray(int i) {
        return new VersionInfoParcel[i];
    }

    /* renamed from: zzp */
    public VersionInfoParcel createFromParcel(Parcel parcel) {
        VersionInfoParcel versionInfoParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
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
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        VersionInfoParcel versionInfoParcel3 = new VersionInfoParcel(i3, str, i2, i, z);
        return versionInfoParcel2;
    }
}
