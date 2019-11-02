package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Creator<SignInResponse> CREATOR;
    final int mVersionCode;
    private final ConnectionResult zzams;
    private final ResolveAccountResponse zzbhk;

    static {
        zzj zzj;
        zzj zzj2 = zzj;
        zzj zzj3 = new zzj();
        CREATOR = zzj2;
    }

    public SignInResponse(int i) {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(i, null);
        this(connectionResult2, null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        ConnectionResult connectionResult2 = connectionResult;
        ResolveAccountResponse resolveAccountResponse2 = resolveAccountResponse;
        this.mVersionCode = i;
        this.zzams = connectionResult2;
        this.zzbhk = resolveAccountResponse2;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public ResolveAccountResponse zzFP() {
        return this.zzbhk;
    }

    public ConnectionResult zzqY() {
        return this.zzams;
    }
}
