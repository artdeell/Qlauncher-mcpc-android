package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<SafeParcelResponse> {
    public zze() {
    }

    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        SafeParcelResponse safeParcelResponse2 = safeParcelResponse;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, safeParcelResponse2.getVersionCode());
        zzb.zza(parcel2, 2, safeParcelResponse2.zzrD(), false);
        zzb.zza(parcel2, 3, (Parcelable) safeParcelResponse2.zzrE(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzaE */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        SafeParcelResponse safeParcelResponse;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        FieldMappingDictionary fieldMappingDictionary = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        Parcel parcel3 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    parcel3 = zza.zzE(parcel2, zzat);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel2, zzat, (Creator<T>) FieldMappingDictionary.CREATOR);
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
        SafeParcelResponse safeParcelResponse2 = safeParcelResponse;
        SafeParcelResponse safeParcelResponse3 = new SafeParcelResponse(i, parcel3, fieldMappingDictionary);
        return safeParcelResponse2;
    }

    /* renamed from: zzck */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
