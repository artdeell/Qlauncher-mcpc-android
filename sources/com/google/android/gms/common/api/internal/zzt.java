package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public class zzt<R extends Result> extends PendingResult<R> {
    private final Status zzUX;

    public zzt(Status status) {
        Status status2 = status;
        Object zzb = zzx.zzb(status2, (Object) "Status must not be null");
        zzx.zzb(!status2.isSuccess(), (Object) "Status must not be success");
        this.zzUX = status2;
    }

    @NonNull
    public R await() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    @NonNull
    public R await(long j, @NonNull TimeUnit timeUnit) {
        UnsupportedOperationException unsupportedOperationException;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    public void cancel() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public Status getStatus() {
        return this.zzUX;
    }

    public boolean isCanceled() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    public void setResultCallback(@NonNull ResultCallback<? super R> resultCallback) {
        UnsupportedOperationException unsupportedOperationException;
        ResultCallback<? super R> resultCallback2 = resultCallback;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    public void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        UnsupportedOperationException unsupportedOperationException;
        ResultCallback<? super R> resultCallback2 = resultCallback;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        UnsupportedOperationException unsupportedOperationException;
        ResultTransform<? super R, ? extends S> resultTransform2 = resultTransform;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    public void zza(@NonNull zza zza) {
        UnsupportedOperationException unsupportedOperationException;
        zza zza2 = zza;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }

    @Nullable
    public Integer zzpa() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
        throw unsupportedOperationException2;
    }
}
