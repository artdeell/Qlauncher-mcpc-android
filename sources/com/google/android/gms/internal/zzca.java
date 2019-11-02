package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@zzhb
public class zzca {
    @Nullable
    private final zzcb zzpe;
    private final Map<String, zzbz> zzxy;

    public zzca(@Nullable zzcb zzcb) {
        HashMap hashMap;
        this.zzpe = zzcb;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzxy = hashMap2;
    }

    public void zza(String str, zzbz zzbz) {
        String str2 = str;
        zzbz zzbz2 = zzbz;
        Object put = this.zzxy.put(str2, zzbz2);
    }

    public void zza(String str, String str2, long j) {
        String str3 = str;
        String str4 = str2;
        long j2 = j;
        zzcb zzcb = this.zzpe;
        zzbz zzbz = (zzbz) this.zzxy.get(str4);
        long j3 = j2;
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = str3;
        boolean zza = zzbx.zza(zzcb, zzbz, j3, strArr2);
        Object put = this.zzxy.put(str3, zzbx.zza(this.zzpe, j2));
    }

    @Nullable
    public zzcb zzdA() {
        return this.zzpe;
    }
}
