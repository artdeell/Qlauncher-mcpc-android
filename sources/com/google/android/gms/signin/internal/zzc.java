package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<CheckServerAuthResult> {
    public zzc() {
    }

    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        CheckServerAuthResult checkServerAuthResult2 = checkServerAuthResult;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, checkServerAuthResult2.mVersionCode);
        zzb.zza(parcel2, 2, checkServerAuthResult2.zzbhf);
        zzb.zzc(parcel2, 3, checkServerAuthResult2.zzbhg, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgS */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        CheckServerAuthResult checkServerAuthResult;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        List list = null;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel2, zzat, Scope.CREATOR);
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
        CheckServerAuthResult checkServerAuthResult2 = checkServerAuthResult;
        CheckServerAuthResult checkServerAuthResult3 = new CheckServerAuthResult(i, z, list);
        return checkServerAuthResult2;
    }

    /* renamed from: zzjZ */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
