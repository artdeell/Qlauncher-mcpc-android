package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;

public class zzc implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> zzagT;
    private final int zzagU;
    private zzl zzagV;

    public zzc(Api<?> api, int i) {
        int i2 = i;
        this.zzagT = api;
        this.zzagU = i2;
    }

    private void zzpi() {
        Object zzb = zzx.zzb(this.zzagV, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        zzpi();
        this.zzagV.onConnected(bundle2);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        zzpi();
        this.zzagV.zza(connectionResult2, this.zzagT, this.zzagU);
    }

    public void onConnectionSuspended(int i) {
        int i2 = i;
        zzpi();
        this.zzagV.onConnectionSuspended(i2);
    }

    public void zza(zzl zzl) {
        zzl zzl2 = zzl;
        this.zzagV = zzl2;
    }
}
