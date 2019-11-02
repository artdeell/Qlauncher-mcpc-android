package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<CapabilityParcel> {
    public zzi() {
    }

    static void zza(CapabilityParcel capabilityParcel, Parcel parcel, int i) {
        CapabilityParcel capabilityParcel2 = capabilityParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, capabilityParcel2.versionCode);
        zzb.zza(parcel2, 2, capabilityParcel2.zzIn);
        zzb.zza(parcel2, 3, capabilityParcel2.zzIo);
        zzb.zza(parcel2, 4, capabilityParcel2.zzIp);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzI */
    public CapabilityParcel[] newArray(int i) {
        return new CapabilityParcel[i];
    }

    /* renamed from: zzk */
    public CapabilityParcel createFromParcel(Parcel parcel) {
        CapabilityParcel capabilityParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel2, zzat);
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
        CapabilityParcel capabilityParcel2 = capabilityParcel;
        CapabilityParcel capabilityParcel3 = new CapabilityParcel(i, z3, z2, z);
        return capabilityParcel2;
    }
}
