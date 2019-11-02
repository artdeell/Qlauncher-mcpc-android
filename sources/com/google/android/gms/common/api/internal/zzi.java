package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import java.util.Collections;

public class zzi implements zzk {
    private final zzl zzahj;

    public zzi(zzl zzl) {
        this.zzahj = zzl;
    }

    public void begin() {
        this.zzahj.zzpM();
        this.zzahj.zzagW.zzahU = Collections.emptySet();
    }

    public void connect() {
        this.zzahj.zzpK();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public <A extends zzb, R extends Result, T extends C0879zza<R, A>> T zza(T t) {
        T t2 = t;
        boolean add = this.zzahj.zzagW.zzahN.add(t2);
        return t2;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends C0879zza<? extends Result, A>> T zzb(T t) {
        IllegalStateException illegalStateException;
        T t2 = t;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("GoogleApiClient is not connected yet.");
        throw illegalStateException2;
    }
}
