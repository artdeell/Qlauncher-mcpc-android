package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.WeakHashMap;

@zzhb
public final class zzhk {
    private WeakHashMap<Context, zza> zzKm;

    private class zza {
        public final long zzKn = zzr.zzbG().currentTimeMillis();
        public final zzhj zzKo;
        final /* synthetic */ zzhk zzKp;

        public zza(zzhk zzhk, zzhj zzhj) {
            zzhj zzhj2 = zzhj;
            this.zzKp = zzhk;
            this.zzKo = zzhj2;
        }

        public boolean hasExpired() {
            return this.zzKn + ((Long) zzbt.zzwM.get()).longValue() < zzr.zzbG().currentTimeMillis();
        }
    }

    public zzhk() {
        WeakHashMap<Context, zza> weakHashMap;
        WeakHashMap<Context, zza> weakHashMap2 = weakHashMap;
        WeakHashMap<Context, zza> weakHashMap3 = new WeakHashMap<>();
        this.zzKm = weakHashMap2;
    }

    public zzhj zzE(Context context) {
        com.google.android.gms.internal.zzhj.zza zza2;
        zzhj zzgI;
        zza zza3;
        com.google.android.gms.internal.zzhj.zza zza4;
        Context context2 = context;
        zza zza5 = (zza) this.zzKm.get(context2);
        if (zza5 == null || zza5.hasExpired() || !((Boolean) zzbt.zzwL.get()).booleanValue()) {
            com.google.android.gms.internal.zzhj.zza zza6 = zza2;
            com.google.android.gms.internal.zzhj.zza zza7 = new com.google.android.gms.internal.zzhj.zza(context2);
            zzgI = zza6.zzgI();
        } else {
            com.google.android.gms.internal.zzhj.zza zza8 = zza4;
            com.google.android.gms.internal.zzhj.zza zza9 = new com.google.android.gms.internal.zzhj.zza(context2, zza5.zzKo);
            zzgI = zza8.zzgI();
        }
        WeakHashMap<Context, zza> weakHashMap = this.zzKm;
        Context context3 = context2;
        zza zza10 = zza3;
        zza zza11 = new zza(this, zzgI);
        Object put = weakHashMap.put(context3, zza10);
        return zzgI;
    }
}
