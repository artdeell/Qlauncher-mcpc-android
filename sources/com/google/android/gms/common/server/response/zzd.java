package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import java.util.ArrayList;

public class zzd implements Creator<Entry> {
    public zzd() {
    }

    static void zza(Entry entry, Parcel parcel, int i) {
        Entry entry2 = entry;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, entry2.versionCode);
        zzb.zza(parcel2, 2, entry2.className, false);
        zzb.zzc(parcel2, 3, entry2.zzamY, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaD */
    public Entry createFromParcel(Parcel parcel) {
        Entry entry;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        ArrayList arrayList = null;
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
                    arrayList = zza.zzc(parcel2, zzat, FieldMapPair.CREATOR);
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
        Entry entry2 = entry;
        Entry entry3 = new Entry(i, str, arrayList);
        return entry2;
    }

    /* renamed from: zzcj */
    public Entry[] newArray(int i) {
        return new Entry[i];
    }
}
