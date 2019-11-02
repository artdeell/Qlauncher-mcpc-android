package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
    public zza() {
    }

    static void zza(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel2 = gInAppPurchaseManagerInfoParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, gInAppPurchaseManagerInfoParcel2.versionCode);
        zzb.zza(parcel2, 3, gInAppPurchaseManagerInfoParcel2.zzfT(), false);
        zzb.zza(parcel2, 4, gInAppPurchaseManagerInfoParcel2.zzfU(), false);
        zzb.zza(parcel2, 5, gInAppPurchaseManagerInfoParcel2.zzfV(), false);
        zzb.zza(parcel2, 6, gInAppPurchaseManagerInfoParcel2.zzfS(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzA */
    public GInAppPurchaseManagerInfoParcel[] newArray(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    /* renamed from: zzh */
    public GInAppPurchaseManagerInfoParcel createFromParcel(Parcel parcel) {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        IBinder iBinder = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 3:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel2, zzat);
                    break;
                case 4:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel2, zzat);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel2, zzat);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel2, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel2, zzat);
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
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel2 = gInAppPurchaseManagerInfoParcel;
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel3 = new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        return gInAppPurchaseManagerInfoParcel2;
    }
}
