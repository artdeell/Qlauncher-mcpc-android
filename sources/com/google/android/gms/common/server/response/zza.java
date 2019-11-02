package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class zza implements Creator<Field> {
    public zza() {
    }

    static void zza(Field field, Parcel parcel, int i) {
        Field field2 = field;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, field2.getVersionCode());
        zzb.zzc(parcel2, 2, field2.zzrj());
        zzb.zza(parcel2, 3, field2.zzrp());
        zzb.zzc(parcel2, 4, field2.zzrk());
        zzb.zza(parcel2, 5, field2.zzrq());
        zzb.zza(parcel2, 6, field2.zzrr(), false);
        zzb.zzc(parcel2, 7, field2.zzrs());
        zzb.zza(parcel2, 8, field2.zzru(), false);
        zzb.zza(parcel2, 9, (Parcelable) field2.zzrw(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaA */
    public Field createFromParcel(Parcel parcel) {
        Field field;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel2, zzat, (Creator<T>) ConverterWrapper.CREATOR);
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
        Field field2 = field;
        Field field3 = new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        return field2;
    }

    /* renamed from: zzcg */
    public Field[] newArray(int i) {
        return new Field[i];
    }
}
