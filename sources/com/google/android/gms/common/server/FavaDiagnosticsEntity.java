package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final zza CREATOR;
    final int mVersionCode;
    public final String zzamD;
    public final int zzamE;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        String str2 = str;
        int i3 = i2;
        this.mVersionCode = i;
        this.zzamD = str2;
        this.zzamE = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
