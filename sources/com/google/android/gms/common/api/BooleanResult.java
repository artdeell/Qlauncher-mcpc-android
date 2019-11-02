package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult implements Result {
    private final Status zzUX;
    private final boolean zzagf;

    public BooleanResult(Status status, boolean z) {
        boolean z2 = z;
        this.zzUX = (Status) zzx.zzb(status, (Object) "Status must not be null");
        this.zzagf = z2;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof BooleanResult)) {
                return false;
            }
            BooleanResult booleanResult = (BooleanResult) obj2;
            if (!this.zzUX.equals(booleanResult.zzUX) || this.zzagf != booleanResult.zzagf) {
                return false;
            }
        }
        return true;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public boolean getValue() {
        return this.zzagf;
    }

    public final int hashCode() {
        return (this.zzagf ? 1 : 0) + (31 * (527 + this.zzUX.hashCode()));
    }
}
