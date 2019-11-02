package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<ScopeDetail> {
    public zzc() {
    }

    static void zza(ScopeDetail scopeDetail, Parcel parcel, int i) {
        ScopeDetail scopeDetail2 = scopeDetail;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, scopeDetail2.version);
        zzb.zza(parcel2, 2, scopeDetail2.description, false);
        zzb.zza(parcel2, 3, scopeDetail2.zzYw, false);
        zzb.zza(parcel2, 4, scopeDetail2.zzYx, false);
        zzb.zza(parcel2, 5, scopeDetail2.zzYy, false);
        zzb.zza(parcel2, 6, scopeDetail2.zzYz, false);
        zzb.zzb(parcel2, 7, scopeDetail2.zzYA, false);
        zzb.zza(parcel2, 8, (Parcelable) scopeDetail2.zzYB, i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzY */
    public ScopeDetail createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        ScopeDetail scopeDetail;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        FACLData fACLData = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    arrayList4 = zza.zzD(parcel2, zzat);
                    break;
                case 8:
                    fACLData = (FACLData) zza.zza(parcel2, zzat, (Creator<T>) FACLData.CREATOR);
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
        ScopeDetail scopeDetail2 = scopeDetail;
        ScopeDetail scopeDetail3 = new ScopeDetail(i, str5, str4, str3, str2, str, arrayList4, fACLData);
        return scopeDetail2;
    }

    /* renamed from: zzaV */
    public ScopeDetail[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
