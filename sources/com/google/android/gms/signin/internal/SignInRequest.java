package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInRequest implements SafeParcelable {
    public static final Creator<SignInRequest> CREATOR;
    final int mVersionCode;
    final ResolveAccountRequest zzbhj;

    static {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi();
        CREATOR = zzi2;
    }

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        ResolveAccountRequest resolveAccountRequest2 = resolveAccountRequest;
        this.mVersionCode = i;
        this.zzbhj = resolveAccountRequest2;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public ResolveAccountRequest zzFO() {
        return this.zzbhj;
    }
}
