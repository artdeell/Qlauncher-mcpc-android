package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;

public class zzb implements Creator<AccountChangeEventsRequest> {
    public zzb() {
    }

    static void zza(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        AccountChangeEventsRequest accountChangeEventsRequest2 = accountChangeEventsRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, accountChangeEventsRequest2.mVersion);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 2, accountChangeEventsRequest2.zzVc);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, accountChangeEventsRequest2.zzVa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 4, (Parcelable) accountChangeEventsRequest2.zzTI, i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzA */
    public AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        AccountChangeEventsRequest accountChangeEventsRequest;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        Account account = null;
        int i = 0;
        int zzau = zza.zzau(parcel2);
        String str = null;
        int i2 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel2, zzat, Account.CREATOR);
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
        AccountChangeEventsRequest accountChangeEventsRequest2 = accountChangeEventsRequest;
        AccountChangeEventsRequest accountChangeEventsRequest3 = new AccountChangeEventsRequest(i2, i, str, account);
        return accountChangeEventsRequest2;
    }

    /* renamed from: zzav */
    public AccountChangeEventsRequest[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
