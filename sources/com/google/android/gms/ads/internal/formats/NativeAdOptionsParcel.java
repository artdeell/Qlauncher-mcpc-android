package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final zzj CREATOR;
    public final int versionCode;
    public final boolean zzyA;
    public final int zzyB;
    public final boolean zzyC;

    static {
        zzj zzj;
        zzj zzj2 = zzj;
        zzj zzj3 = new zzj();
        CREATOR = zzj2;
    }

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        boolean z3 = z;
        int i3 = i2;
        boolean z4 = z2;
        this.versionCode = i;
        this.zzyA = z3;
        this.zzyB = i3;
        this.zzyC = z4;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        NativeAdOptions nativeAdOptions2 = nativeAdOptions;
        this(1, nativeAdOptions2.shouldReturnUrlsForImageAssets(), nativeAdOptions2.getImageOrientation(), nativeAdOptions2.shouldRequestMultipleImages());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
