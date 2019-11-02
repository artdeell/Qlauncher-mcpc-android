package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<AccountChangeEventsResponse> {
    public zzc() {
    }

    static void zza(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        AccountChangeEventsResponse accountChangeEventsResponse2 = accountChangeEventsResponse;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, accountChangeEventsResponse2.mVersion);
        zzb.zzc(parcel2, 2, accountChangeEventsResponse2.zzpH, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzB */
    public AccountChangeEventsResponse createFromParcel(Parcel parcel) {
        AccountChangeEventsResponse accountChangeEventsResponse;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        List list = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel2, zzat, AccountChangeEvent.CREATOR);
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
        AccountChangeEventsResponse accountChangeEventsResponse2 = accountChangeEventsResponse;
        AccountChangeEventsResponse accountChangeEventsResponse3 = new AccountChangeEventsResponse(i, list);
        return accountChangeEventsResponse2;
    }

    /* renamed from: zzaw */
    public AccountChangeEventsResponse[] newArray(int i) {
        return new AccountChangeEventsResponse[i];
    }
}
