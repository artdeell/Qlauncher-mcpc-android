package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<PlayLoggerContext> {
    public zze() {
    }

    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, playLoggerContext2.versionCode);
        zzb.zza(parcel2, 2, playLoggerContext2.packageName, false);
        zzb.zzc(parcel2, 3, playLoggerContext2.zzbdL);
        zzb.zzc(parcel2, 4, playLoggerContext2.zzbdM);
        zzb.zza(parcel2, 5, playLoggerContext2.zzbdN, false);
        zzb.zza(parcel2, 6, playLoggerContext2.zzbdO, false);
        zzb.zza(parcel2, 7, playLoggerContext2.zzbdP);
        zzb.zza(parcel2, 8, playLoggerContext2.zzbdQ, false);
        zzb.zza(parcel2, 9, playLoggerContext2.zzbdR);
        zzb.zzc(parcel2, 10, playLoggerContext2.zzbdS);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgz */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        PlayLoggerContext playLoggerContext;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel2);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 9:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 10:
                    i = zza.zzg(parcel2, zzat);
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
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        PlayLoggerContext playLoggerContext3 = new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        return playLoggerContext2;
    }

    /* renamed from: zzjF */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
