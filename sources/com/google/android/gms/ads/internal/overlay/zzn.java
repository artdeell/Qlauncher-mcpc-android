package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public class zzn extends zzj {
    public zzn() {
    }

    @Nullable
    public zzi zza(Context context, zzjp zzjp, int i, zzcb zzcb, zzbz zzbz) {
        zzc zzc;
        zzt zzt;
        Context context2 = context;
        zzjp zzjp2 = zzjp;
        int i2 = i;
        zzcb zzcb2 = zzcb;
        zzbz zzbz2 = zzbz;
        if (!zzx(context2)) {
            return null;
        }
        zzc zzc2 = zzc;
        Context context3 = context2;
        zzt zzt2 = zzt;
        zzt zzt3 = new zzt(context2, zzjp2.zzhX(), zzjp2.getRequestId(), zzcb2, zzbz2);
        zzc zzc3 = new zzc(context3, zzt2);
        return zzc2;
    }
}
