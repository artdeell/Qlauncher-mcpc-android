package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<StringParcel> {
    public zzn() {
    }

    static void zza(StringParcel stringParcel, Parcel parcel, int i) {
        StringParcel stringParcel2 = stringParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, stringParcel2.mVersionCode);
        zzb.zza(parcel2, 2, stringParcel2.zzxG, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzK */
    public StringParcel[] newArray(int i) {
        return new StringParcel[i];
    }

    /* renamed from: zzm */
    public StringParcel createFromParcel(Parcel parcel) {
        StringParcel stringParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
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
        StringParcel stringParcel2 = stringParcel;
        StringParcel stringParcel3 = new StringParcel(i, str);
        return stringParcel2;
    }
}
