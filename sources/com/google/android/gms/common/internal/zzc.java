package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AuthAccountRequest> {
    public zzc() {
    }

    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        AuthAccountRequest authAccountRequest2 = authAccountRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, authAccountRequest2.mVersionCode);
        zzb.zza(parcel2, 2, authAccountRequest2.zzakA, false);
        zzb.zza(parcel2, 3, (T[]) authAccountRequest2.zzafT, i2, false);
        zzb.zza(parcel2, 4, authAccountRequest2.zzakB, false);
        zzb.zza(parcel2, 5, authAccountRequest2.zzakC, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzam */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        AuthAccountRequest authAccountRequest;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        Integer num = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel2, zzat);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel2, zzat, Scope.CREATOR);
                    break;
                case 4:
                    num2 = zza.zzh(parcel2, zzat);
                    break;
                case 5:
                    num = zza.zzh(parcel2, zzat);
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
        AuthAccountRequest authAccountRequest2 = authAccountRequest;
        AuthAccountRequest authAccountRequest3 = new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        return authAccountRequest2;
    }

    /* renamed from: zzbP */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
