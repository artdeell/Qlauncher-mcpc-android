package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzam implements Creator<SearchAdRequestParcel> {
    public zzam() {
    }

    static void zza(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        SearchAdRequestParcel searchAdRequestParcel2 = searchAdRequestParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, searchAdRequestParcel2.versionCode);
        zzb.zzc(parcel2, 2, searchAdRequestParcel2.zzvd);
        zzb.zzc(parcel2, 3, searchAdRequestParcel2.backgroundColor);
        zzb.zzc(parcel2, 4, searchAdRequestParcel2.zzve);
        zzb.zzc(parcel2, 5, searchAdRequestParcel2.zzvf);
        zzb.zzc(parcel2, 6, searchAdRequestParcel2.zzvg);
        zzb.zzc(parcel2, 7, searchAdRequestParcel2.zzvh);
        zzb.zzc(parcel2, 8, searchAdRequestParcel2.zzvi);
        zzb.zzc(parcel2, 9, searchAdRequestParcel2.zzvj);
        zzb.zza(parcel2, 10, searchAdRequestParcel2.zzvk, false);
        zzb.zzc(parcel2, 11, searchAdRequestParcel2.zzvl);
        zzb.zza(parcel2, 12, searchAdRequestParcel2.zzvm, false);
        zzb.zzc(parcel2, 13, searchAdRequestParcel2.zzvn);
        zzb.zzc(parcel2, 14, searchAdRequestParcel2.zzvo);
        zzb.zza(parcel2, 15, searchAdRequestParcel2.zzvp, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzd */
    public SearchAdRequestParcel createFromParcel(Parcel parcel) {
        SearchAdRequestParcel searchAdRequestParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    i5 = zza.zzg(parcel2, zzat);
                    break;
                case 6:
                    i6 = zza.zzg(parcel2, zzat);
                    break;
                case 7:
                    i7 = zza.zzg(parcel2, zzat);
                    break;
                case 8:
                    i8 = zza.zzg(parcel2, zzat);
                    break;
                case 9:
                    i9 = zza.zzg(parcel2, zzat);
                    break;
                case 10:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 11:
                    i10 = zza.zzg(parcel2, zzat);
                    break;
                case 12:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 13:
                    i11 = zza.zzg(parcel2, zzat);
                    break;
                case 14:
                    i12 = zza.zzg(parcel2, zzat);
                    break;
                case 15:
                    str3 = zza.zzp(parcel2, zzat);
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
        SearchAdRequestParcel searchAdRequestParcel2 = searchAdRequestParcel;
        SearchAdRequestParcel searchAdRequestParcel3 = new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        return searchAdRequestParcel2;
    }

    /* renamed from: zzo */
    public SearchAdRequestParcel[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
