package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zze extends zzj<zzj> {
    final int zzHr;

    public zze(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        Context context2 = context;
        int i2 = i;
        super(context2, looper, 8, zzf.zzat(context2), connectionCallbacks, onConnectionFailedListener);
        this.zzHr = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzV */
    public zzj zzW(IBinder iBinder) {
        return zza.zzX(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public zzj zzgw() throws DeadObjectException {
        return (zzj) super.zzqJ();
    }
}
