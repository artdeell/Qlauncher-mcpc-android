package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzhb;

@zzhb
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        super(adSizeParcel2.versionCode, adSizeParcel2.zzuh, adSizeParcel2.height, adSizeParcel2.heightPixels, adSizeParcel2.zzui, adSizeParcel2.width, adSizeParcel2.widthPixels, adSizeParcel2.zzuj, adSizeParcel2.zzuk, adSizeParcel2.zzul, adSizeParcel2.zzum);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, this.versionCode);
        zzb.zza(parcel2, 2, this.zzuh, false);
        zzb.zzc(parcel2, 3, this.height);
        zzb.zzc(parcel2, 6, this.width);
        zzb.zzI(parcel2, zzav);
    }
}
