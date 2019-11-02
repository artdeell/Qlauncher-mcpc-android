package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzUX;
    private final PendingResult<?>[] zzagc;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        PendingResult<?>[] pendingResultArr2 = pendingResultArr;
        this.zzUX = status;
        this.zzagc = pendingResultArr2;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        BatchResultToken<R> batchResultToken2 = batchResultToken;
        zzx.zzb(batchResultToken2.mId < this.zzagc.length, (Object) "The result token does not belong to this batch");
        return this.zzagc[batchResultToken2.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
