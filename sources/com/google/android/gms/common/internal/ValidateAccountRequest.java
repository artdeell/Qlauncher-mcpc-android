package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR;
    final int mVersionCode;
    private final String zzVO;
    private final Scope[] zzafT;
    final IBinder zzakA;
    private final int zzamy;
    private final Bundle zzamz;

    static {
        zzae zzae;
        zzae zzae2 = zzae;
        zzae zzae3 = new zzae();
        CREATOR = zzae2;
    }

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        int i3 = i2;
        IBinder iBinder2 = iBinder;
        Scope[] scopeArr2 = scopeArr;
        Bundle bundle2 = bundle;
        String str2 = str;
        this.mVersionCode = i;
        this.zzamy = i3;
        this.zzakA = iBinder2;
        this.zzafT = scopeArr2;
        this.zzamz = bundle2;
        this.zzVO = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.zzVO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public Scope[] zzrd() {
        return this.zzafT;
    }

    public int zzre() {
        return this.zzamy;
    }

    public Bundle zzrf() {
        return this.zzamz;
    }
}
