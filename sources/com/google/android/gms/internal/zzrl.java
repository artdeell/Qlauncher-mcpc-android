package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;

public final class zzrl {
    public static final Api<zzro> API;
    public static final zzc<zzh> zzUI;
    public static final com.google.android.gms.common.api.Api.zza<zzh, zzro> zzUJ;
    public static final Scope zzWW;
    public static final Scope zzWX;
    public static final Api<zza> zzaoG;
    public static final zzc<zzh> zzavN;
    static final com.google.android.gms.common.api.Api.zza<zzh, zza> zzbgS;
    public static final zzrm zzbgT;

    public static class zza implements HasOptions {
        private final Bundle zzbgU;

        public Bundle zzFF() {
            return this.zzbgU;
        }
    }

    static {
        zzc<zzh> zzc;
        zzc<zzh> zzc2;
        C04491 r5;
        C04502 r52;
        Scope scope;
        Scope scope2;
        Api<zzro> api;
        Api<zza> api2;
        zzg zzg;
        zzc<zzh> zzc3 = zzc;
        zzc<zzh> zzc4 = new zzc<>();
        zzUI = zzc3;
        zzc<zzh> zzc5 = zzc2;
        zzc<zzh> zzc6 = new zzc<>();
        zzavN = zzc5;
        C04491 r0 = r5;
        C04491 r1 = new com.google.android.gms.common.api.Api.zza<zzh, zzro>() {
            public zzh zza(Context context, Looper looper, zzf zzf, zzro zzro, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
                zzh zzh;
                zzro zzro2 = zzro;
                zzh zzh2 = zzh;
                zzh zzh3 = new zzh(context, looper, true, zzf, zzro2 == null ? zzro.zzbgV : zzro2, connectionCallbacks, onConnectionFailedListener);
                return zzh2;
            }
        };
        zzUJ = r0;
        C04502 r02 = r52;
        C04502 r12 = new com.google.android.gms.common.api.Api.zza<zzh, zza>() {
            public zzh zza(Context context, Looper looper, zzf zzf, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
                zzh zzh;
                zzh zzh2 = zzh;
                zzh zzh3 = new zzh(context, looper, false, zzf, zza.zzFF(), connectionCallbacks, onConnectionFailedListener);
                return zzh2;
            }
        };
        zzbgS = r02;
        Scope scope3 = scope;
        Scope scope4 = new Scope(Scopes.PROFILE);
        zzWW = scope3;
        Scope scope5 = scope2;
        Scope scope6 = new Scope("email");
        zzWX = scope5;
        Api<zzro> api3 = api;
        Api<zzro> api4 = new Api<>("SignIn.API", zzUJ, zzUI);
        API = api3;
        Api<zza> api5 = api2;
        Api<zza> api6 = new Api<>("SignIn.INTERNAL_API", zzbgS, zzavN);
        zzaoG = api5;
        zzg zzg2 = zzg;
        zzg zzg3 = new zzg();
        zzbgT = zzg2;
    }
}
