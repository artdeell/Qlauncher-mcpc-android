package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConverterWrapper> {
    public zza() {
    }

    static void zza(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        ConverterWrapper converterWrapper2 = converterWrapper;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, converterWrapper2.getVersionCode());
        zzb.zza(parcel2, 2, (Parcelable) converterWrapper2.zzrg(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzax */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel2, zzat, (Creator<T>) StringToIntConverter.CREATOR);
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
        ConverterWrapper converterWrapper2 = converterWrapper;
        ConverterWrapper converterWrapper3 = new ConverterWrapper(i, stringToIntConverter);
        return converterWrapper2;
    }

    /* renamed from: zzcd */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
