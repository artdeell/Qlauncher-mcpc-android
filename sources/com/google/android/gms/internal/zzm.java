package com.google.android.gms.internal;

public class zzm<T> {
    public final T result;
    public final com.google.android.gms.internal.zzb.zza zzag;
    public final zzr zzah;
    public boolean zzai;

    public interface zza {
        void zze(zzr zzr);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzr) {
        zzr zzr2 = zzr;
        this.zzai = false;
        this.result = null;
        this.zzag = null;
        this.zzah = zzr2;
    }

    private zzm(T t, com.google.android.gms.internal.zzb.zza zza2) {
        T t2 = t;
        com.google.android.gms.internal.zzb.zza zza3 = zza2;
        this.zzai = false;
        this.result = t2;
        this.zzag = zza3;
        this.zzah = null;
    }

    public static <T> zzm<T> zza(T t, com.google.android.gms.internal.zzb.zza zza2) {
        zzm zzm;
        zzm zzm2 = zzm;
        zzm zzm3 = new zzm(t, zza2);
        return zzm2;
    }

    public static <T> zzm<T> zzd(zzr zzr) {
        zzm zzm;
        zzm zzm2 = zzm;
        zzm zzm3 = new zzm(zzr);
        return zzm2;
    }

    public boolean isSuccess() {
        return this.zzah == null;
    }
}
