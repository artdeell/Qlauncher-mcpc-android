package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<Status> {
    public zzc() {
    }

    static void zza(Status status, Parcel parcel, int i) {
        Status status2 = status;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, status2.getStatusCode());
        zzb.zzc(parcel2, 1000, status2.getVersionCode());
        zzb.zza(parcel2, 2, status2.getStatusMessage(), false);
        zzb.zza(parcel2, 3, (Parcelable) status2.zzpc(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzai */
    public Status createFromParcel(Parcel parcel) {
        Status status;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        PendingIntent pendingIntent = null;
        int i = 0;
        int zzau = zza.zzau(parcel2);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) zza.zza(parcel2, zzat, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel2, zzat);
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
        Status status2 = status;
        Status status3 = new Status(i2, i, str, pendingIntent);
        return status2;
    }

    /* renamed from: zzby */
    public Status[] newArray(int i) {
        return new Status[i];
    }
}
