package com.google.android.gms.auth.api.signin.internal;

public class zze {
    static int zzXy = 31;
    private int zzXz = 1;

    public zze() {
    }

    public zze zzP(boolean z) {
        this.zzXz = (z ? 1 : 0) + (zzXy * this.zzXz);
        return this;
    }

    public int zzne() {
        return this.zzXz;
    }

    public zze zzp(Object obj) {
        Object obj2 = obj;
        this.zzXz = (obj2 == null ? 0 : obj2.hashCode()) + (zzXy * this.zzXz);
        return this;
    }
}
