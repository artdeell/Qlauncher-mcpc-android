package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;

public class zzb implements Creator<Scope> {
    public zzb() {
    }

    static void zza(Scope scope, Parcel parcel, int i) {
        Scope scope2 = scope;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, scope2.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 2, scope2.zzpb(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzah */
    public Scope createFromParcel(Parcel parcel) {
        Scope scope;
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
        Scope scope2 = scope;
        Scope scope3 = new Scope(i, str);
        return scope2;
    }

    /* renamed from: zzbx */
    public Scope[] newArray(int i) {
        return new Scope[i];
    }
}
