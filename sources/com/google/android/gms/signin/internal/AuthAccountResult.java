package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements Result, SafeParcelable {
    public static final Creator<AuthAccountResult> CREATOR;
    final int mVersionCode;
    private int zzbhd;
    private Intent zzbhe;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        int i3 = i2;
        Intent intent2 = intent;
        this.mVersionCode = i;
        this.zzbhd = i3;
        this.zzbhe = intent2;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzbhd == 0 ? Status.zzagC : Status.zzagG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public int zzFK() {
        return this.zzbhd;
    }

    public Intent zzFL() {
        return this.zzbhe;
    }
}
