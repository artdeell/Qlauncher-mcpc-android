package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class VersionInfoParcel implements SafeParcelable {
    public static final zzc CREATOR;
    public String afmaVersion;
    public final int versionCode;
    public int zzMZ;
    public int zzNa;
    public boolean zzNb;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    public VersionInfoParcel(int i, int i2, boolean z) {
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder append = sb2.append("afma-sdk-a-v").append(i3).append(".").append(i4).append(".");
        this(1, append.append(z2 ? "0" : "1").toString(), i3, i4, z2);
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        String str2 = str;
        int i4 = i2;
        int i5 = i3;
        boolean z2 = z;
        this.versionCode = i;
        this.afmaVersion = str2;
        this.zzMZ = i4;
        this.zzNa = i5;
        this.zzNb = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
