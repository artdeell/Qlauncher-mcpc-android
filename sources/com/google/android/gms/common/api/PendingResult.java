package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    public interface zza {
        void zzu(Status status);
    }

    public PendingResult() {
    }

    @NonNull
    public abstract R await();

    @NonNull
    public abstract R await(long j, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        UnsupportedOperationException unsupportedOperationException;
        ResultTransform<? super R, ? extends S> resultTransform2 = resultTransform;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void zza(@NonNull zza zza2) {
        UnsupportedOperationException unsupportedOperationException;
        zza zza3 = zza2;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    @Nullable
    public Integer zzpa() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }
}
