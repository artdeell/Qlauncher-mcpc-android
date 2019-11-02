package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class zzc implements Creator<FieldMappingDictionary> {
    public zzc() {
    }

    static void zza(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, fieldMappingDictionary2.getVersionCode());
        zzb.zzc(parcel2, 2, fieldMappingDictionary2.zzrA(), false);
        zzb.zza(parcel2, 3, fieldMappingDictionary2.zzrB(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaC */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel2, zzat, Entry.CREATOR);
                    break;
                case 3:
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
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary3 = new FieldMappingDictionary(i, arrayList, str);
        return fieldMappingDictionary2;
    }

    /* renamed from: zzci */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
