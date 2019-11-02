package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;

public class zzb implements Creator<ConnectionResult> {
    public zzb() {
    }

    static void zza(ConnectionResult connectionResult, Parcel parcel, int i) {
        ConnectionResult connectionResult2 = connectionResult;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, connectionResult2.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 2, connectionResult2.getErrorCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, (Parcelable) connectionResult2.getResolution(), i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 4, connectionResult2.getErrorMessage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzag */
    public ConnectionResult createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult;
        C0881zza zza;
        StringBuilder sb;
        String zzp;
        PendingIntent pendingIntent;
        int i;
        int i2;
        Parcel parcel2 = parcel;
        String str = null;
        int i3 = 0;
        int zzau = zza.zzau(parcel2);
        PendingIntent pendingIntent2 = null;
        int i4 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = zza.zzg(parcel2, zzat);
                    zzp = str;
                    break;
                case 2:
                    i2 = i4;
                    i = zza.zzg(parcel2, zzat);
                    zzp = str;
                    pendingIntent = pendingIntent2;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    pendingIntent = (PendingIntent) zza.zza(parcel2, zzat, PendingIntent.CREATOR);
                    zzp = str;
                    break;
                case 4:
                    zzp = zza.zzp(parcel2, zzat);
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    zzp = str;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            pendingIntent2 = pendingIntent;
            str = zzp;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(i4, i3, pendingIntent2, str);
        return connectionResult2;
    }

    /* renamed from: zzbt */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
