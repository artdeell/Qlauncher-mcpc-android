package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final zzb CREATOR;
    final int version;
    FACLConfig zzYs;
    String zzYt;
    boolean zzYu;
    String zzYv;

    static {
        zzb zzb;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
    }

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        FACLConfig fACLConfig2 = fACLConfig;
        String str3 = str;
        boolean z2 = z;
        String str4 = str2;
        this.version = i;
        this.zzYs = fACLConfig2;
        this.zzYt = str3;
        this.zzYu = z2;
        this.zzYv = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
