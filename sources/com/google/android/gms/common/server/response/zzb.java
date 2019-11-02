package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public class zzb implements Creator<FieldMapPair> {
    public zzb() {
    }

    static void zza(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        FieldMapPair fieldMapPair2 = fieldMapPair;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, fieldMapPair2.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 2, fieldMapPair2.key, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, (Parcelable) fieldMapPair2.zzamZ, i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaB */
    public FieldMapPair createFromParcel(Parcel parcel) {
        FieldMapPair fieldMapPair;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        Field field = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        String str = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    field = (Field) zza.zza(parcel2, zzat, (Creator<T>) Field.CREATOR);
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
        FieldMapPair fieldMapPair2 = fieldMapPair;
        FieldMapPair fieldMapPair3 = new FieldMapPair(i, str, field);
        return fieldMapPair2;
    }

    /* renamed from: zzch */
    public FieldMapPair[] newArray(int i) {
        return new FieldMapPair[i];
    }
}
