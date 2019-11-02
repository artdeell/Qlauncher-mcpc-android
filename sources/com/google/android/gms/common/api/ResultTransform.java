package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzt;

public abstract class ResultTransform<R extends Result, S extends Result> {
    public ResultTransform() {
    }

    @NonNull
    public final PendingResult<S> createFailedResult(@NonNull Status status) {
        zzt zzt;
        zzt zzt2 = zzt;
        zzt zzt3 = new zzt(status);
        return zzt2;
    }

    @NonNull
    public Status onFailure(@NonNull Status status) {
        return status;
    }

    @Nullable
    @WorkerThread
    public abstract PendingResult<S> onSuccess(@NonNull R r);
}
