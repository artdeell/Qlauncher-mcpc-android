package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<AdSizeParcel> {
    public zzi() {
    }

    static void zza(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, adSizeParcel2.versionCode);
        zzb.zza(parcel2, 2, adSizeParcel2.zzuh, false);
        zzb.zzc(parcel2, 3, adSizeParcel2.height);
        zzb.zzc(parcel2, 4, adSizeParcel2.heightPixels);
        zzb.zza(parcel2, 5, adSizeParcel2.zzui);
        zzb.zzc(parcel2, 6, adSizeParcel2.width);
        zzb.zzc(parcel2, 7, adSizeParcel2.widthPixels);
        zzb.zza(parcel2, 8, (T[]) adSizeParcel2.zzuj, i2, false);
        zzb.zza(parcel2, 9, adSizeParcel2.zzuk);
        zzb.zza(parcel2, 10, adSizeParcel2.zzul);
        zzb.zza(parcel2, 11, adSizeParcel2.zzum);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzc */
    public AdSizeParcel createFromParcel(Parcel parcel) {
        AdSizeParcel adSizeParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i5 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    z4 = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 7:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) zza.zzb(parcel2, zzat, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 10:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 11:
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
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        return adSizeParcel2;
    }

    /* renamed from: zzm */
    public AdSizeParcel[] newArray(int i) {
        return new AdSizeParcel[i];
    }
}
