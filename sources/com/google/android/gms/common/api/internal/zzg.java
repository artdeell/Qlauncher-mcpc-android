package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.C0879zza;

public class zzg implements zzk {
    /* access modifiers changed from: private */
    public final zzl zzahj;
    private boolean zzahk = false;

    public zzg(zzl zzl) {
        zzl zzl2 = zzl;
        this.zzahj = zzl2;
    }

    private <A extends zzb> void zza(zze<A> zze) throws DeadObjectException {
        Status status;
        zze<A> zze2 = zze;
        this.zzahj.zzagW.zzb(zze2);
        zzb zza = this.zzahj.zzagW.zza(zze2.zzoR());
        if (zza.isConnected() || !this.zzahj.zzaio.containsKey(zze2.zzoR())) {
            zze2.zzb(zza);
            return;
        }
        zze<A> zze3 = zze2;
        Status status2 = status;
        Status status3 = new Status(17);
        zze3.zzw(status2);
    }

    public void begin() {
    }

    public void connect() {
        C02272 r6;
        if (this.zzahk) {
            this.zzahk = false;
            zzl zzl = this.zzahj;
            C02272 r2 = r6;
            C02272 r3 = new zza(this, this) {
                final /* synthetic */ zzg zzahl;

                {
                    zzk zzk = r7;
                    this.zzahl = r6;
                }

                public void zzpt() {
                    this.zzahl.zzahj.zzais.zzi(null);
                }
            };
            zzl.zza((zza) r2);
        }
    }

    public boolean disconnect() {
        if (this.zzahk) {
            return false;
        }
        if (this.zzahj.zzagW.zzpG()) {
            this.zzahk = true;
            for (zzx zzpU : this.zzahj.zzagW.zzaia) {
                zzpU.zzpU();
            }
            return false;
        }
        this.zzahj.zzh(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        int i2 = i;
        this.zzahj.zzh(null);
        this.zzahj.zzais.zzc(i2, this.zzahk);
    }

    public <A extends zzb, R extends Result, T extends C0879zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends C0879zza<? extends Result, A>> T zzb(T t) {
        C02261 r8;
        T t2 = t;
        try {
            zza((zze<A>) t2);
            return t2;
        } catch (DeadObjectException e) {
            DeadObjectException deadObjectException = e;
            zzl zzl = this.zzahj;
            C02261 r4 = r8;
            C02261 r5 = new zza(this, this) {
                final /* synthetic */ zzg zzahl;

                {
                    zzk zzk = r7;
                    this.zzahl = r6;
                }

                public void zzpt() {
                    this.zzahl.onConnectionSuspended(1);
                }
            };
            zzl.zza((zza) r4);
            return t2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzps() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zzagW.zzaa(false);
            boolean disconnect = disconnect();
        }
    }
}
