package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zza {

    /* renamed from: com.google.android.gms.common.api.internal.zza$zza reason: collision with other inner class name */
    public static abstract class C0879zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzb<R> implements zzb<R>, zze<A> {
        private final zzc<A> zzaeE;
        private AtomicReference<zzd> zzagH;

        protected C0879zza(zzc<A> zzc, GoogleApiClient googleApiClient) {
            AtomicReference<zzd> atomicReference;
            zzc<A> zzc2 = zzc;
            super((GoogleApiClient) zzx.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            AtomicReference<zzd> atomicReference2 = atomicReference;
            AtomicReference<zzd> atomicReference3 = new AtomicReference<>();
            this.zzagH = atomicReference2;
            this.zzaeE = (zzc) zzx.zzz(zzc2);
        }

        private void zza(RemoteException remoteException) {
            Status status;
            Status status2 = status;
            Status status3 = new Status(8, remoteException.getLocalizedMessage(), null);
            zzw(status2);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(A a) throws RemoteException;

        public void zza(zzd zzd) {
            zzd zzd2 = zzd;
            this.zzagH.set(zzd2);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                DeadObjectException deadObjectException = e;
                zza((RemoteException) deadObjectException);
                throw deadObjectException;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public final zzc<A> zzoR() {
            return this.zzaeE;
        }

        public void zzpe() {
            setResultCallback(null);
        }

        /* access modifiers changed from: protected */
        public void zzpf() {
            zzd zzd = (zzd) this.zzagH.getAndSet(null);
            if (zzd != null) {
                zzd.zzc(this);
            }
        }

        public /* synthetic */ void zzs(Object obj) {
            super.zza((Result) obj);
        }

        public final void zzw(Status status) {
            Status status2 = status;
            zzx.zzb(!status2.isSuccess(), (Object) "Failed result must not be success");
            zza(zzc(status2));
        }
    }

    public interface zzb<R> {
        void zzs(R r);

        void zzw(Status status);
    }
}
