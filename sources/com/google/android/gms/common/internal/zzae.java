package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<ValidateAccountRequest> {
    public zzae() {
    }

    static void zza(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        ValidateAccountRequest validateAccountRequest2 = validateAccountRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, validateAccountRequest2.mVersionCode);
        zzb.zzc(parcel2, 2, validateAccountRequest2.zzre());
        zzb.zza(parcel2, 3, validateAccountRequest2.zzakA, false);
        zzb.zza(parcel2, 4, (T[]) validateAccountRequest2.zzrd(), i2, false);
        zzb.zza(parcel2, 5, validateAccountRequest2.zzrf(), false);
        zzb.zza(parcel2, 6, validateAccountRequest2.getCallingPackage(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzas */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        ValidateAccountRequest validateAccountRequest;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel2);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = zza.zzq(parcel2, zzat);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel2, zzat, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.zzr(parcel2, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel2, zzat);
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
        ValidateAccountRequest validateAccountRequest2 = validateAccountRequest;
        ValidateAccountRequest validateAccountRequest3 = new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        return validateAccountRequest2;
    }

    /* renamed from: zzbZ */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
