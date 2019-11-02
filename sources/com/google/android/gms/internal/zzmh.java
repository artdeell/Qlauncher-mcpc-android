package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;

public final class zzmh implements zzmg {

    private static class zza extends zzme {
        private final zzb<Status> zzamC;

        public zza(zzb<Status> zzb) {
            this.zzamC = zzb;
        }

        public void zzcb(int i) throws RemoteException {
            Status status;
            int i2 = i;
            zzb<Status> zzb = this.zzamC;
            Status status2 = status;
            Status status3 = new Status(i2);
            zzb.zzs(status2);
        }
    }

    public zzmh() {
    }

    public PendingResult<Status> zzf(GoogleApiClient googleApiClient) {
        C04481 r7;
        GoogleApiClient googleApiClient2 = googleApiClient;
        GoogleApiClient googleApiClient3 = googleApiClient2;
        C04481 r3 = r7;
        C04481 r4 = new zza(this, googleApiClient2) {
            final /* synthetic */ zzmh zzamB;

            {
                GoogleApiClient googleApiClient = r7;
                this.zzamB = r6;
            }

            /* access modifiers changed from: protected */
            public void zza(zzmj zzmj) throws RemoteException {
                zza zza;
                zzml zzml = (zzml) zzmj.zzqJ();
                zza zza2 = zza;
                zza zza3 = new zza(this);
                zzml.zza(zza2);
            }
        };
        return googleApiClient3.zzb(r3);
    }
}
