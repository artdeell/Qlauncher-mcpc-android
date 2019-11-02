package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class CapabilityParcel implements SafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR;
    public final int versionCode;
    public final boolean zzIn;
    public final boolean zzIo;
    public final boolean zzIp;

    static {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi();
        CREATOR = zzi2;
    }

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        this.versionCode = i;
        this.zzIn = z4;
        this.zzIo = z5;
        this.zzIp = z6;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public int describeContents() {
        return 0;
    }

    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = bundle2;
        bundle4.putBoolean("iap_supported", this.zzIn);
        bundle4.putBoolean("default_iap_supported", this.zzIo);
        bundle4.putBoolean("app_streaming_supported", this.zzIp);
        return bundle4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
