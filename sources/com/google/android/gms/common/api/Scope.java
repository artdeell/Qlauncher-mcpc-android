package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR;
    final int mVersionCode;
    private final String zzagB;

    static {
        zzb zzb;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
    }

    Scope(int i, String str) {
        int i2 = i;
        String str2 = str;
        String zzh = zzx.zzh(str2, "scopeUri must not be null or empty");
        this.mVersionCode = i2;
        this.zzagB = str2;
    }

    public Scope(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (!(obj2 instanceof Scope)) {
            return false;
        }
        return this.zzagB.equals(((Scope) obj2).zzagB);
    }

    public int hashCode() {
        return this.zzagB.hashCode();
    }

    public String toString() {
        return this.zzagB;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzpb() {
        return this.zzagB;
    }
}
