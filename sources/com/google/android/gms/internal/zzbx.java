package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzhb
public class zzbx {
    @Nullable
    public static zzbz zza(@Nullable zzcb zzcb, long j) {
        zzcb zzcb2 = zzcb;
        long j2 = j;
        if (zzcb2 == null) {
            return null;
        }
        return zzcb2.zzb(j2);
    }

    public static boolean zza(@Nullable zzcb zzcb, @Nullable zzbz zzbz, long j, String... strArr) {
        zzcb zzcb2 = zzcb;
        zzbz zzbz2 = zzbz;
        long j2 = j;
        String[] strArr2 = strArr;
        if (zzcb2 == null || zzbz2 == null) {
            return false;
        }
        return zzcb2.zza(zzbz2, j2, strArr2);
    }

    public static boolean zza(@Nullable zzcb zzcb, @Nullable zzbz zzbz, String... strArr) {
        zzcb zzcb2 = zzcb;
        zzbz zzbz2 = zzbz;
        String[] strArr2 = strArr;
        if (zzcb2 == null || zzbz2 == null) {
            return false;
        }
        return zzcb2.zza(zzbz2, strArr2);
    }

    @Nullable
    public static zzbz zzb(@Nullable zzcb zzcb) {
        zzcb zzcb2 = zzcb;
        if (zzcb2 == null) {
            return null;
        }
        return zzcb2.zzdB();
    }
}
