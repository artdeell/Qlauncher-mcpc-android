package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<NativeAdOptionsParcel> {
    public zzj() {
    }

    static void zza(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, nativeAdOptionsParcel2.versionCode);
        zzb.zza(parcel2, 2, nativeAdOptionsParcel2.zzyA);
        zzb.zzc(parcel2, 3, nativeAdOptionsParcel2.zzyB);
        zzb.zza(parcel2, 4, nativeAdOptionsParcel2.zzyC);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zze */
    public NativeAdOptionsParcel createFromParcel(Parcel parcel) {
        NativeAdOptionsParcel nativeAdOptionsParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel2, zzat);
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
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        NativeAdOptionsParcel nativeAdOptionsParcel3 = new NativeAdOptionsParcel(i2, z2, i, z);
        return nativeAdOptionsParcel2;
    }

    /* renamed from: zzp */
    public NativeAdOptionsParcel[] newArray(int i) {
        return new NativeAdOptionsParcel[i];
    }
}
