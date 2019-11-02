package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<SignInRequest> {
    public zzi() {
    }

    static void zza(SignInRequest signInRequest, Parcel parcel, int i) {
        SignInRequest signInRequest2 = signInRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, signInRequest2.mVersionCode);
        zzb.zza(parcel2, 2, (Parcelable) signInRequest2.zzFO(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgU */
    public SignInRequest createFromParcel(Parcel parcel) {
        SignInRequest signInRequest;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) zza.zza(parcel2, zzat, ResolveAccountRequest.CREATOR);
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
        SignInRequest signInRequest2 = signInRequest;
        SignInRequest signInRequest3 = new SignInRequest(i, resolveAccountRequest);
        return signInRequest2;
    }

    /* renamed from: zzkc */
    public SignInRequest[] newArray(int i) {
        return new SignInRequest[i];
    }
}
