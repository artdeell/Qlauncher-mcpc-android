package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Creator<LogEventParcelable> {
    public zzd() {
    }

    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        LogEventParcelable logEventParcelable2 = logEventParcelable;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, logEventParcelable2.versionCode);
        zzb.zza(parcel2, 2, (Parcelable) logEventParcelable2.zzafh, i2, false);
        zzb.zza(parcel2, 3, logEventParcelable2.zzafi, false);
        zzb.zza(parcel2, 4, logEventParcelable2.zzafj, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaf */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        LogEventParcelable logEventParcelable;
        C0881zza zza;
        StringBuilder sb;
        int[] zzv;
        byte[] bArr;
        PlayLoggerContext playLoggerContext;
        int i;
        Parcel parcel2 = parcel;
        int[] iArr = null;
        int zzau = zza.zzau(parcel2);
        int i2 = 0;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext2 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = zza.zzg(parcel2, zzat);
                    zzv = iArr;
                    break;
                case 2:
                    i = i2;
                    playLoggerContext = (PlayLoggerContext) zza.zza(parcel2, zzat, (Creator<T>) PlayLoggerContext.CREATOR);
                    zzv = iArr;
                    bArr = bArr2;
                    break;
                case 3:
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    bArr = zza.zzs(parcel2, zzat);
                    zzv = iArr;
                    break;
                case 4:
                    zzv = zza.zzv(parcel2, zzat);
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    zzv = iArr;
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
            }
            i2 = i;
            playLoggerContext2 = playLoggerContext;
            bArr2 = bArr;
            iArr = zzv;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        LogEventParcelable logEventParcelable2 = logEventParcelable;
        LogEventParcelable logEventParcelable3 = new LogEventParcelable(i2, playLoggerContext2, bArr2, iArr);
        return logEventParcelable2;
    }

    /* renamed from: zzbs */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
