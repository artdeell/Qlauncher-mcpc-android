package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final zzl CREATOR;
    public final int versionCode;
    public final boolean zzql;
    public final boolean zzqm;
    public final String zzqn;
    public final boolean zzqo;
    public final float zzqp;

    static {
        zzl zzl;
        zzl zzl2 = zzl;
        zzl zzl3 = new zzl();
        CREATOR = zzl2;
    }

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f) {
        boolean z4 = z;
        boolean z5 = z2;
        String str2 = str;
        boolean z6 = z3;
        float f2 = f;
        this.versionCode = i;
        this.zzql = z4;
        this.zzqm = z5;
        this.zzqn = str2;
        this.zzqo = z6;
        this.zzqp = f2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, String str, boolean z3, float f) {
        this(2, z, z2, str, z3, f);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
