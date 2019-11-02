package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<WakeLockEvent> {
    public zzh() {
    }

    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        WakeLockEvent wakeLockEvent2 = wakeLockEvent;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, wakeLockEvent2.mVersionCode);
        zzb.zza(parcel2, 2, wakeLockEvent2.getTimeMillis());
        zzb.zza(parcel2, 4, wakeLockEvent2.zzrR(), false);
        zzb.zzc(parcel2, 5, wakeLockEvent2.zzrT());
        zzb.zzb(parcel2, 6, wakeLockEvent2.zzrU(), false);
        zzb.zza(parcel2, 8, wakeLockEvent2.zzrN());
        zzb.zza(parcel2, 10, wakeLockEvent2.zzrS(), false);
        zzb.zzc(parcel2, 11, wakeLockEvent2.getEventType());
        zzb.zza(parcel2, 12, wakeLockEvent2.zzrK(), false);
        zzb.zza(parcel2, 13, wakeLockEvent2.zzrW(), false);
        zzb.zzc(parcel2, 14, wakeLockEvent2.zzrV());
        zzb.zza(parcel2, 15, wakeLockEvent2.zzrX());
        zzb.zza(parcel2, 16, wakeLockEvent2.zzrY());
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaG */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        WakeLockEvent wakeLockEvent;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 6:
                    list = zza.zzD(parcel2, zzat);
                    break;
                case 8:
                    j2 = zza.zzi(parcel2, zzat);
                    break;
                case 10:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 11:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 12:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 13:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 14:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 15:
                    f = zza.zzl(parcel2, zzat);
                    break;
                case 16:
                    j3 = zza.zzi(parcel2, zzat);
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
        WakeLockEvent wakeLockEvent2 = wakeLockEvent;
        WakeLockEvent wakeLockEvent3 = new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        return wakeLockEvent2;
    }

    /* renamed from: zzcm */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
