package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AuthAccountResult> {
    public zza() {
    }

    static void zza(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        AuthAccountResult authAccountResult2 = authAccountResult;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, authAccountResult2.mVersionCode);
        zzb.zzc(parcel2, 2, authAccountResult2.zzFK());
        zzb.zza(parcel2, 3, (Parcelable) authAccountResult2.zzFL(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgR */
    public AuthAccountResult createFromParcel(Parcel parcel) {
        AuthAccountResult authAccountResult;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        Intent intent = null;
        int i2 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    intent = (Intent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel2, zzat, Intent.CREATOR);
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
        AuthAccountResult authAccountResult2 = authAccountResult;
        AuthAccountResult authAccountResult3 = new AuthAccountResult(i2, i, intent);
        return authAccountResult2;
    }

    /* renamed from: zzjY */
    public AuthAccountResult[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
