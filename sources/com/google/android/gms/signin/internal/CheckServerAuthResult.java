package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR;
    final int mVersionCode;
    final boolean zzbhf;
    final List<Scope> zzbhg;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        boolean z2 = z;
        List<Scope> list2 = list;
        this.mVersionCode = i;
        this.zzbhf = z2;
        this.zzbhg = list2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
