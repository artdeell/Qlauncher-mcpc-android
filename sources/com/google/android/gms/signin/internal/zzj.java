package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<SignInResponse> {
    public zzj() {
    }

    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        SignInResponse signInResponse2 = signInResponse;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, signInResponse2.mVersionCode);
        zzb.zza(parcel2, 2, (Parcelable) signInResponse2.zzqY(), i2, false);
        zzb.zza(parcel2, 3, (Parcelable) signInResponse2.zzFP(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgV */
    public SignInResponse createFromParcel(Parcel parcel) {
        SignInResponse signInResponse;
        C0881zza zza;
        StringBuilder sb;
        ResolveAccountResponse resolveAccountResponse;
        ConnectionResult connectionResult;
        int i;
        Parcel parcel2 = parcel;
        ResolveAccountResponse resolveAccountResponse2 = null;
        int zzau = zza.zzau(parcel2);
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    connectionResult = connectionResult2;
                    i = zza.zzg(parcel2, zzat);
                    resolveAccountResponse = resolveAccountResponse2;
                    break;
                case 2:
                    i = i2;
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = (ConnectionResult) zza.zza(parcel2, zzat, ConnectionResult.CREATOR);
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) zza.zza(parcel2, zzat, ResolveAccountResponse.CREATOR);
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
            }
            i2 = i;
            connectionResult2 = connectionResult;
            resolveAccountResponse2 = resolveAccountResponse;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        SignInResponse signInResponse2 = signInResponse;
        SignInResponse signInResponse3 = new SignInResponse(i2, connectionResult2, resolveAccountResponse2);
        return signInResponse2;
    }

    /* renamed from: zzkd */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
