package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AccountChangeEvent> {
    public zza() {
    }

    static void zza(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        AccountChangeEvent accountChangeEvent2 = accountChangeEvent;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, accountChangeEvent2.mVersion);
        zzb.zza(parcel2, 2, accountChangeEvent2.zzUZ);
        zzb.zza(parcel2, 3, accountChangeEvent2.zzVa, false);
        zzb.zzc(parcel2, 4, accountChangeEvent2.zzVb);
        zzb.zzc(parcel2, 5, accountChangeEvent2.zzVc);
        zzb.zza(parcel2, 6, accountChangeEvent2.zzVd, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzau */
    public AccountChangeEvent[] newArray(int i) {
        return new AccountChangeEvent[i];
    }

    /* renamed from: zzz */
    public AccountChangeEvent createFromParcel(Parcel parcel) {
        AccountChangeEvent accountChangeEvent;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
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
        AccountChangeEvent accountChangeEvent2 = accountChangeEvent;
        AccountChangeEvent accountChangeEvent3 = new AccountChangeEvent(i3, j, str2, i2, i, str);
        return accountChangeEvent2;
    }
}
