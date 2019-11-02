package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzqu.zza;

public class zzd implements ConnectionCallbacks, OnConnectionFailedListener {
    private final zza zzbdJ;
    private boolean zzbdK = true;
    private zzf zzbdy = null;

    public zzd(zza zza) {
        this.zzbdJ = zza;
    }

    public void onConnected(Bundle bundle) {
        Bundle bundle2 = bundle;
        this.zzbdy.zzau(false);
        if (this.zzbdK && this.zzbdJ != null) {
            this.zzbdJ.zzES();
        }
        this.zzbdK = false;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        this.zzbdy.zzau(true);
        if (this.zzbdK && this.zzbdJ != null) {
            if (connectionResult2.hasResolution()) {
                this.zzbdJ.zzc(connectionResult2.getResolution());
            } else {
                this.zzbdJ.zzET();
            }
        }
        this.zzbdK = false;
    }

    public void onConnectionSuspended(int i) {
        int i2 = i;
        this.zzbdy.zzau(true);
    }

    public void zza(zzf zzf) {
        zzf zzf2 = zzf;
        this.zzbdy = zzf2;
    }

    public void zzat(boolean z) {
        boolean z2 = z;
        this.zzbdK = z2;
    }
}
