package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConnectionEvent> {
    public zza() {
    }

    static void zza(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        ConnectionEvent connectionEvent2 = connectionEvent;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, connectionEvent2.mVersionCode);
        zzb.zza(parcel2, 2, connectionEvent2.getTimeMillis());
        zzb.zza(parcel2, 4, connectionEvent2.zzrF(), false);
        zzb.zza(parcel2, 5, connectionEvent2.zzrG(), false);
        zzb.zza(parcel2, 6, connectionEvent2.zzrH(), false);
        zzb.zza(parcel2, 7, connectionEvent2.zzrI(), false);
        zzb.zza(parcel2, 8, connectionEvent2.zzrJ(), false);
        zzb.zza(parcel2, 10, connectionEvent2.zzrN());
        zzb.zza(parcel2, 11, connectionEvent2.zzrM());
        zzb.zzc(parcel2, 12, connectionEvent2.getEventType());
        zzb.zza(parcel2, 13, connectionEvent2.zzrK(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaF */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        ConnectionEvent connectionEvent;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
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
        ConnectionEvent connectionEvent2 = connectionEvent;
        ConnectionEvent connectionEvent3 = new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        return connectionEvent2;
    }

    /* renamed from: zzcl */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
