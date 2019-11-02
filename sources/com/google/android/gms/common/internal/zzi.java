package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<GetServiceRequest> {
    public zzi() {
    }

    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        GetServiceRequest getServiceRequest2 = getServiceRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, getServiceRequest2.version);
        zzb.zzc(parcel2, 2, getServiceRequest2.zzall);
        zzb.zzc(parcel2, 3, getServiceRequest2.zzalm);
        zzb.zza(parcel2, 4, getServiceRequest2.zzaln, false);
        zzb.zza(parcel2, 5, getServiceRequest2.zzalo, false);
        zzb.zza(parcel2, 6, (T[]) getServiceRequest2.zzalp, i2, false);
        zzb.zza(parcel2, 7, getServiceRequest2.zzalq, false);
        zzb.zza(parcel2, 8, (Parcelable) getServiceRequest2.zzalr, i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzao */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        GetServiceRequest getServiceRequest;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i = 0;
        Account account = null;
        int zzau = zza.zzau(parcel2);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    iBinder = zza.zzq(parcel2, zzat);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.zzb(parcel2, zzat, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.zzr(parcel2, zzat);
                    break;
                case 8:
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
        GetServiceRequest getServiceRequest2 = getServiceRequest;
        GetServiceRequest getServiceRequest3 = new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        return getServiceRequest2;
    }

    /* renamed from: zzbR */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
