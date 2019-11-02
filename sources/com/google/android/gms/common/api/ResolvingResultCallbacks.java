package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzx;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity mActivity;
    private final int zzagz;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int i) {
        int i2 = i;
        this.mActivity = (Activity) zzx.zzb(activity, (Object) "Activity must not be null");
        this.zzagz = i2;
    }

    public final void onFailure(@NonNull Status status) {
        Status status2;
        Status status3 = status;
        if (status3.hasResolution()) {
            try {
                status3.startResolutionForResult(this.mActivity, this.zzagz);
            } catch (SendIntentException e) {
                int e2 = Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                Status status4 = status2;
                Status status5 = new Status(8);
                onUnresolvableFailure(status4);
            }
        } else {
            onUnresolvableFailure(status3);
        }
    }

    public abstract void onSuccess(@NonNull R r);

    public abstract void onUnresolvableFailure(@NonNull Status status);
}
