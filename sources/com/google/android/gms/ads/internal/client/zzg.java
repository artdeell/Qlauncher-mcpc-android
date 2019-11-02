package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<AdRequestParcel> {
    public zzg() {
    }

    static void zza(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, adRequestParcel2.versionCode);
        zzb.zza(parcel2, 2, adRequestParcel2.zztC);
        zzb.zza(parcel2, 3, adRequestParcel2.extras, false);
        zzb.zzc(parcel2, 4, adRequestParcel2.zztD);
        zzb.zzb(parcel2, 5, adRequestParcel2.zztE, false);
        zzb.zza(parcel2, 6, adRequestParcel2.zztF);
        zzb.zzc(parcel2, 7, adRequestParcel2.zztG);
        zzb.zza(parcel2, 8, adRequestParcel2.zztH);
        zzb.zza(parcel2, 9, adRequestParcel2.zztI, false);
        zzb.zza(parcel2, 10, (Parcelable) adRequestParcel2.zztJ, i2, false);
        zzb.zza(parcel2, 11, (Parcelable) adRequestParcel2.zztK, i2, false);
        zzb.zza(parcel2, 12, adRequestParcel2.zztL, false);
        zzb.zza(parcel2, 13, adRequestParcel2.zztM, false);
        zzb.zza(parcel2, 14, adRequestParcel2.zztN, false);
        zzb.zzb(parcel2, 15, adRequestParcel2.zztO, false);
        zzb.zza(parcel2, 17, adRequestParcel2.zztQ, false);
        zzb.zza(parcel2, 16, adRequestParcel2.zztP, false);
        zzb.zza(parcel2, 18, adRequestParcel2.zztR);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzb */
    public AdRequestParcel createFromParcel(Parcel parcel) {
        AdRequestParcel adRequestParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 3:
                    bundle = zza.zzr(parcel2, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    list = zza.zzD(parcel2, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 7:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 8:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) zza.zza(parcel2, zzat, (Creator<T>) SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel2, zzat, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 13:
                    bundle2 = zza.zzr(parcel2, zzat);
                    break;
                case 14:
                    bundle3 = zza.zzr(parcel2, zzat);
                    break;
                case 15:
                    list2 = zza.zzD(parcel2, zzat);
                    break;
                case 16:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 17:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 18:
                    z3 = zza.zzc(parcel2, zzat);
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
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        AdRequestParcel adRequestParcel3 = new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        return adRequestParcel2;
    }

    /* renamed from: zzl */
    public AdRequestParcel[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
