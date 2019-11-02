package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public final class zzmf {
    public static final Api<NoOptions> API;
    public static final zzc<zzmj> zzUI;
    private static final zza<zzmj, NoOptions> zzUJ;
    public static final zzmg zzamA;

    static {
        zzc<zzmj> zzc;
        C04471 r5;
        Api<NoOptions> api;
        zzmh zzmh;
        zzc<zzmj> zzc2 = zzc;
        zzc<zzmj> zzc3 = new zzc<>();
        zzUI = zzc2;
        C04471 r0 = r5;
        C04471 r1 = new zza<zzmj, NoOptions>() {
            /* renamed from: zzf */
            public zzmj zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
                zzmj zzmj;
                NoOptions noOptions2 = noOptions;
                zzmj zzmj2 = zzmj;
                zzmj zzmj3 = new zzmj(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
                return zzmj2;
            }
        };
        zzUJ = r0;
        Api<NoOptions> api2 = api;
        Api<NoOptions> api3 = new Api<>("Common.API", zzUJ, zzUI);
        API = api2;
        zzmh zzmh2 = zzmh;
        zzmh zzmh3 = new zzmh();
        zzamA = zzmh2;
    }
}
