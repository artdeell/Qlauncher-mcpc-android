package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<LogEvent> {
    public zzc() {
    }

    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        LogEvent logEvent2 = logEvent;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, logEvent2.versionCode);
        zzb.zza(parcel2, 2, logEvent2.zzbdA);
        zzb.zza(parcel2, 3, logEvent2.tag, false);
        zzb.zza(parcel2, 4, logEvent2.zzbdC, false);
        zzb.zza(parcel2, 5, logEvent2.zzbdD, false);
        zzb.zza(parcel2, 6, logEvent2.zzbdB);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgy */
    public LogEvent createFromParcel(Parcel parcel) {
        LogEvent logEvent;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        long j = 0;
        Bundle bundle = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel2, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    bArr = zza.zzs(parcel2, zzat);
                    break;
                case 5:
                    bundle = zza.zzr(parcel2, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel2, zzat);
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
        LogEvent logEvent2 = logEvent;
        LogEvent logEvent3 = new LogEvent(i, j2, j, str, bArr, bundle);
        return logEvent2;
    }

    /* renamed from: zzjE */
    public LogEvent[] newArray(int i) {
        return new LogEvent[i];
    }
}
