package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<FavaDiagnosticsEntity> {
    public zza() {
    }

    static void zza(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel, int i) {
        FavaDiagnosticsEntity favaDiagnosticsEntity2 = favaDiagnosticsEntity;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, favaDiagnosticsEntity2.mVersionCode);
        zzb.zza(parcel2, 2, favaDiagnosticsEntity2.zzamD, false);
        zzb.zzc(parcel2, 3, favaDiagnosticsEntity2.zzamE);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaw */
    public FavaDiagnosticsEntity createFromParcel(Parcel parcel) {
        FavaDiagnosticsEntity favaDiagnosticsEntity;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        String str = null;
        int i2 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
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
        FavaDiagnosticsEntity favaDiagnosticsEntity2 = favaDiagnosticsEntity;
        FavaDiagnosticsEntity favaDiagnosticsEntity3 = new FavaDiagnosticsEntity(i2, str, i);
        return favaDiagnosticsEntity2;
    }

    /* renamed from: zzcc */
    public FavaDiagnosticsEntity[] newArray(int i) {
        return new FavaDiagnosticsEntity[i];
    }
}
