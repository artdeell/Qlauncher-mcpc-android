package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<FACLConfig> {
    public zza() {
    }

    static void zza(FACLConfig fACLConfig, Parcel parcel, int i) {
        FACLConfig fACLConfig2 = fACLConfig;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, fACLConfig2.version);
        zzb.zza(parcel2, 2, fACLConfig2.zzYm);
        zzb.zza(parcel2, 3, fACLConfig2.zzYn, false);
        zzb.zza(parcel2, 4, fACLConfig2.zzYo);
        zzb.zza(parcel2, 5, fACLConfig2.zzYp);
        zzb.zza(parcel2, 6, fACLConfig2.zzYq);
        zzb.zza(parcel2, 7, fACLConfig2.zzYr);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzW */
    public FACLConfig createFromParcel(Parcel parcel) {
        FACLConfig fACLConfig;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel2, zzat);
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
        FACLConfig fACLConfig2 = fACLConfig;
        FACLConfig fACLConfig3 = new FACLConfig(i, z5, str, z4, z3, z2, z);
        return fACLConfig2;
    }

    /* renamed from: zzaT */
    public FACLConfig[] newArray(int i) {
        return new FACLConfig[i];
    }
}
