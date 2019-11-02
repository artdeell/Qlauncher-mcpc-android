package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<TokenData> {
    public zze() {
    }

    static void zza(TokenData tokenData, Parcel parcel, int i) {
        TokenData tokenData2 = tokenData;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, tokenData2.mVersionCode);
        zzb.zza(parcel2, 2, tokenData2.getToken(), false);
        zzb.zza(parcel2, 3, tokenData2.zzmn(), false);
        zzb.zza(parcel2, 4, tokenData2.zzmo());
        zzb.zza(parcel2, 5, tokenData2.zzmp());
        zzb.zzb(parcel2, 6, tokenData2.zzmq(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzC */
    public TokenData createFromParcel(Parcel parcel) {
        TokenData tokenData;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        List list = null;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    l = zza.zzj(parcel2, zzat);
                    break;
                case 4:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    list = zza.zzD(parcel2, zzat);
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
        TokenData tokenData2 = tokenData;
        TokenData tokenData3 = new TokenData(i, str, l, z2, z, list);
        return tokenData2;
    }

    /* renamed from: zzax */
    public TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
