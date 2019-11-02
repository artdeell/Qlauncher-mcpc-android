package com.google.android.gms.internal;

public class zzd implements zzo {
    private int zzo;
    private int zzp;
    private final int zzq;
    private final float zzr;

    public zzd() {
        this(2500, 1, 1.0f);
    }

    public zzd(int i, int i2, float f) {
        int i3 = i2;
        float f2 = f;
        this.zzo = i;
        this.zzq = i3;
        this.zzr = f2;
    }

    public void zza(zzr zzr2) throws zzr {
        zzr zzr3 = zzr2;
        this.zzp = 1 + this.zzp;
        this.zzo = (int) (((float) this.zzo) + (((float) this.zzo) * this.zzr));
        if (!zzf()) {
            throw zzr3;
        }
    }

    public int zzd() {
        return this.zzo;
    }

    public int zze() {
        return this.zzp;
    }

    /* access modifiers changed from: protected */
    public boolean zzf() {
        return this.zzp <= this.zzq;
    }
}
