package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzad<T extends IInterface> extends zzj<T> {
    private final zzd<T> zzamx;

    public zzad(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf, zzd zzd) {
        zzd zzd2 = zzd;
        super(context, looper, i, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzamx = zzd2;
    }

    /* access modifiers changed from: protected */
    public T zzW(IBinder iBinder) {
        return this.zzamx.zzW(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        int i2 = i;
        T t2 = t;
        this.zzamx.zza(i2, t2);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return this.zzamx.zzgu();
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return this.zzamx.zzgv();
    }
}
