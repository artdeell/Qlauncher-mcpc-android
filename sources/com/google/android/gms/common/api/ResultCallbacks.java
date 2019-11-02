package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzb;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public ResultCallbacks() {
    }

    public abstract void onFailure(@NonNull Status status);

    public final void onResult(@NonNull R r) {
        R r2 = r;
        Status status = r2.getStatus();
        if (status.isSuccess()) {
            onSuccess(r2);
            return;
        }
        onFailure(status);
        zzb.zzc((Result) r2);
    }

    public abstract void onSuccess(@NonNull R r);
}
