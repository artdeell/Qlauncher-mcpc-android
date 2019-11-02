package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;

public class zzb implements Creator<StringToIntConverter> {
    public zzb() {
    }

    static void zza(StringToIntConverter stringToIntConverter, Parcel parcel, int i) {
        StringToIntConverter stringToIntConverter2 = stringToIntConverter;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, stringToIntConverter2.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 2, stringToIntConverter2.zzri(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzay */
    public StringToIntConverter createFromParcel(Parcel parcel) {
        StringToIntConverter stringToIntConverter;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
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
        StringToIntConverter stringToIntConverter2 = stringToIntConverter;
        StringToIntConverter stringToIntConverter3 = new StringToIntConverter(i, arrayList);
        return stringToIntConverter2;
    }

    /* renamed from: zzce */
    public StringToIntConverter[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
