package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<LargeParcelTeleporter> {
    public zzl() {
    }

    static void zza(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        LargeParcelTeleporter largeParcelTeleporter2 = largeParcelTeleporter;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, largeParcelTeleporter2.mVersionCode);
        zzb.zza(parcel2, 2, (Parcelable) largeParcelTeleporter2.zzIq, i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzJ */
    public LargeParcelTeleporter[] newArray(int i) {
        return new LargeParcelTeleporter[i];
    }

    /* renamed from: zzl */
    public LargeParcelTeleporter createFromParcel(Parcel parcel) {
        LargeParcelTeleporter largeParcelTeleporter;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel2, zzat, ParcelFileDescriptor.CREATOR);
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
        LargeParcelTeleporter largeParcelTeleporter2 = largeParcelTeleporter;
        LargeParcelTeleporter largeParcelTeleporter3 = new LargeParcelTeleporter(i, parcelFileDescriptor);
        return largeParcelTeleporter2;
    }
}
