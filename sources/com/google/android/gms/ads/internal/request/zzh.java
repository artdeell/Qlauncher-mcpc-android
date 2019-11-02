package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<AdResponseParcel> {
    public zzh() {
    }

    static void zza(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, adResponseParcel2.versionCode);
        zzb.zza(parcel2, 2, adResponseParcel2.zzEF, false);
        zzb.zza(parcel2, 3, adResponseParcel2.body, false);
        zzb.zzb(parcel2, 4, adResponseParcel2.zzBQ, false);
        zzb.zzc(parcel2, 5, adResponseParcel2.errorCode);
        zzb.zzb(parcel2, 6, adResponseParcel2.zzBR, false);
        zzb.zza(parcel2, 7, adResponseParcel2.zzHS);
        zzb.zza(parcel2, 8, adResponseParcel2.zzHT);
        zzb.zza(parcel2, 9, adResponseParcel2.zzHU);
        zzb.zzb(parcel2, 10, adResponseParcel2.zzHV, false);
        zzb.zza(parcel2, 11, adResponseParcel2.zzBU);
        zzb.zzc(parcel2, 12, adResponseParcel2.orientation);
        zzb.zza(parcel2, 13, adResponseParcel2.zzHW, false);
        zzb.zza(parcel2, 14, adResponseParcel2.zzHX);
        zzb.zza(parcel2, 15, adResponseParcel2.zzHY, false);
        zzb.zza(parcel2, 19, adResponseParcel2.zzIa, false);
        zzb.zza(parcel2, 18, adResponseParcel2.zzHZ);
        zzb.zza(parcel2, 21, adResponseParcel2.zzIb, false);
        zzb.zza(parcel2, 23, adResponseParcel2.zzuk);
        zzb.zza(parcel2, 22, adResponseParcel2.zzIc);
        zzb.zza(parcel2, 25, adResponseParcel2.zzId);
        zzb.zza(parcel2, 24, adResponseParcel2.zzHB);
        zzb.zzc(parcel2, 27, adResponseParcel2.zzIf);
        zzb.zza(parcel2, 26, adResponseParcel2.zzIe);
        zzb.zza(parcel2, 29, adResponseParcel2.zzIh, false);
        zzb.zza(parcel2, 28, (Parcelable) adResponseParcel2.zzIg, i2, false);
        zzb.zza(parcel2, 31, adResponseParcel2.zzul);
        zzb.zza(parcel2, 30, adResponseParcel2.zzIi, false);
        zzb.zzb(parcel2, 34, adResponseParcel2.zzIk, false);
        zzb.zzb(parcel2, 35, adResponseParcel2.zzIl, false);
        zzb.zza(parcel2, 32, adResponseParcel2.zzum);
        zzb.zza(parcel2, 33, (Parcelable) adResponseParcel2.zzIj, i2, false);
        zzb.zza(parcel2, 36, adResponseParcel2.zzIm);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzH */
    public AdResponseParcel[] newArray(int i) {
        return new AdResponseParcel[i];
    }

    /* renamed from: zzj */
    public AdResponseParcel createFromParcel(Parcel parcel) {
        AdResponseParcel adResponseParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        RewardItemParcel rewardItemParcel = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
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
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    list = zza.zzD(parcel2, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 6:
                    list2 = zza.zzD(parcel2, zzat);
                    break;
                case 7:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 8:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 9:
                    j2 = zza.zzi(parcel2, zzat);
                    break;
                case 10:
                    list3 = zza.zzD(parcel2, zzat);
                    break;
                case 11:
                    j3 = zza.zzi(parcel2, zzat);
                    break;
                case 12:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 13:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 14:
                    j4 = zza.zzi(parcel2, zzat);
                    break;
                case 15:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 18:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 19:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 21:
                    str6 = zza.zzp(parcel2, zzat);
                    break;
                case 22:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 23:
                    z4 = zza.zzc(parcel2, zzat);
                    break;
                case 24:
                    z5 = zza.zzc(parcel2, zzat);
                    break;
                case 25:
                    z6 = zza.zzc(parcel2, zzat);
                    break;
                case 26:
                    z7 = zza.zzc(parcel2, zzat);
                    break;
                case 27:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) zza.zza(parcel2, zzat, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = zza.zzp(parcel2, zzat);
                    break;
                case 30:
                    str8 = zza.zzp(parcel2, zzat);
                    break;
                case 31:
                    z8 = zza.zzc(parcel2, zzat);
                    break;
                case 32:
                    z9 = zza.zzc(parcel2, zzat);
                    break;
                case 33:
                    rewardItemParcel = (RewardItemParcel) zza.zza(parcel2, zzat, (Creator<T>) RewardItemParcel.CREATOR);
                    break;
                case 34:
                    list4 = zza.zzD(parcel2, zzat);
                    break;
                case 35:
                    list5 = zza.zzD(parcel2, zzat);
                    break;
                case 36:
                    z10 = zza.zzc(parcel2, zzat);
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
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        AdResponseParcel adResponseParcel3 = new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, list4, list5, z10);
        return adResponseParcel2;
    }
}
