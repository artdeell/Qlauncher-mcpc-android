package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.api.internal.zzv;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzagx;

        public zza(R r) {
            R r2 = r;
            super(Looper.getMainLooper());
            this.zzagx = r2;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            UnsupportedOperationException unsupportedOperationException;
            if (status.getStatusCode() == this.zzagx.getStatus().getStatusCode()) {
                return this.zzagx;
            }
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Creating failed results is not supported");
            throw unsupportedOperationException2;
        }
    }

    private static final class zzb<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzagy;

        public zzb(GoogleApiClient googleApiClient, R r) {
            R r2 = r;
            super(googleApiClient);
            this.zzagy = r2;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            Status status2 = status;
            return this.zzagy;
        }
    }

    private static final class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            UnsupportedOperationException unsupportedOperationException;
            Status status2 = status;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Creating failed results is not supported");
            throw unsupportedOperationException2;
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzv zzv;
        zzv zzv2 = zzv;
        zzv zzv3 = new zzv(Looper.getMainLooper());
        zzv zzv4 = zzv2;
        zzv4.cancel();
        return zzv4;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zza zza2;
        R r2 = r;
        Object zzb2 = zzx.zzb(r2, (Object) "Result must not be null");
        zzx.zzb(r2.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        zza zza3 = zza2;
        zza zza4 = new zza(r2);
        zza zza5 = zza3;
        zza5.cancel();
        return zza5;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzc zzc2;
        zzr zzr;
        R r2 = r;
        Object zzb2 = zzx.zzb(r2, (Object) "Result must not be null");
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(null);
        zzc zzc5 = zzc3;
        zzc5.zza(r2);
        zzr zzr2 = zzr;
        zzr zzr3 = new zzr(zzc5);
        return zzr2;
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzv zzv;
        Status status2 = status;
        Object zzb2 = zzx.zzb(status2, (Object) "Result must not be null");
        zzv zzv2 = zzv;
        zzv zzv3 = new zzv(Looper.getMainLooper());
        zzv zzv4 = zzv2;
        zzv4.zza(status2);
        return zzv4;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzb zzb2;
        R r2 = r;
        GoogleApiClient googleApiClient2 = googleApiClient;
        Object zzb3 = zzx.zzb(r2, (Object) "Result must not be null");
        zzx.zzb(!r2.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        zzb zzb4 = zzb2;
        zzb zzb5 = new zzb(googleApiClient2, r2);
        zzb zzb6 = zzb4;
        zzb6.zza(r2);
        return zzb6;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzv zzv;
        Status status2 = status;
        GoogleApiClient googleApiClient2 = googleApiClient;
        Object zzb2 = zzx.zzb(status2, (Object) "Result must not be null");
        zzv zzv2 = zzv;
        zzv zzv3 = new zzv(googleApiClient2);
        zzv zzv4 = zzv2;
        zzv4.zza(status2);
        return zzv4;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzc zzc2;
        zzr zzr;
        R r2 = r;
        GoogleApiClient googleApiClient2 = googleApiClient;
        Object zzb2 = zzx.zzb(r2, (Object) "Result must not be null");
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(googleApiClient2);
        zzc zzc5 = zzc3;
        zzc5.zza(r2);
        zzr zzr2 = zzr;
        zzr zzr3 = new zzr(zzc5);
        return zzr2;
    }
}
