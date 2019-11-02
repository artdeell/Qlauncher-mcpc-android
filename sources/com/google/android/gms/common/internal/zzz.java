package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Creator<ResolveAccountResponse> {
    public zzz() {
    }

    static void zza(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        ResolveAccountResponse resolveAccountResponse2 = resolveAccountResponse;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, resolveAccountResponse2.mVersionCode);
        zzb.zza(parcel2, 2, resolveAccountResponse2.zzakA, false);
        zzb.zza(parcel2, 3, (Parcelable) resolveAccountResponse2.zzqY(), i2, false);
        zzb.zza(parcel2, 4, resolveAccountResponse2.zzqZ());
        zzb.zza(parcel2, 5, resolveAccountResponse2.zzra());
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaq */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) zza.zza(parcel2, zzat, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
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
        ResolveAccountResponse resolveAccountResponse2 = resolveAccountResponse;
        ResolveAccountResponse resolveAccountResponse3 = new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        return resolveAccountResponse2;
    }

    /* renamed from: zzbX */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
