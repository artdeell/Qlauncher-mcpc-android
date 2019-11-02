package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;

public class zzb implements Creator<FACLData> {
    public zzb() {
    }

    static void zza(FACLData fACLData, Parcel parcel, int i) {
        FACLData fACLData2 = fACLData;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, fACLData2.version);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 2, (Parcelable) fACLData2.zzYs, i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, fACLData2.zzYt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 4, fACLData2.zzYu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 5, fACLData2.zzYv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzX */
    public FACLData createFromParcel(Parcel parcel) {
        FACLData fACLData;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel2);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    fACLConfig = (FACLConfig) zza.zza(parcel2, zzat, (Creator<T>) FACLConfig.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel2, zzat);
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
        FACLData fACLData2 = fACLData;
        FACLData fACLData3 = new FACLData(i, fACLConfig, str2, z, str);
        return fACLData2;
    }

    /* renamed from: zzaU */
    public FACLData[] newArray(int i) {
        return new FACLData[i];
    }
}
