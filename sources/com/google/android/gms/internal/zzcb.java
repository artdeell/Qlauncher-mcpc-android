package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzhb
public class zzcb {
    private final Object zzpV;
    private final Map<String, String> zzxA;
    private String zzxB;
    private zzbz zzxC;
    private zzcb zzxD;
    boolean zzxi;
    private final List<zzbz> zzxz;

    public zzcb(boolean z, String str, String str2) {
        LinkedList linkedList;
        LinkedHashMap linkedHashMap;
        Object obj;
        boolean z2 = z;
        String str3 = str;
        String str4 = str2;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzxz = linkedList2;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.zzxA = linkedHashMap2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzxi = z2;
        Object put = this.zzxA.put("action", str3);
        Object put2 = this.zzxA.put("ad_format", str4);
    }

    public void zzN(String str) {
        String str2 = str;
        if (this.zzxi) {
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    this.zzxB = str2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public boolean zza(zzbz zzbz, long j, String... strArr) {
        zzbz zzbz2;
        zzbz zzbz3 = zzbz;
        long j2 = j;
        String[] strArr2 = strArr;
        int i = this.zzpV;
        synchronized (i) {
            try {
                i = strArr2.length;
                for (int i2 = 0; th < i; i2 = th + 1) {
                    zzbz zzbz4 = zzbz2;
                    zzbz zzbz5 = new zzbz(j2, strArr2[th], zzbz3);
                    boolean add = this.zzxz.add(zzbz4);
                }
            } finally {
                int i3 = th;
                int i4 = i;
                Throwable th = i3;
            }
        }
        return true;
    }

    public boolean zza(zzbz zzbz, String... strArr) {
        zzbz zzbz2 = zzbz;
        String[] strArr2 = strArr;
        if (!this.zzxi || zzbz2 == null) {
            return false;
        }
        return zza(zzbz2, zzr.zzbG().elapsedRealtime(), strArr2);
    }

    public zzbz zzb(long j) {
        zzbz zzbz;
        long j2 = j;
        if (!this.zzxi) {
            return null;
        }
        zzbz zzbz2 = zzbz;
        zzbz zzbz3 = new zzbz(j2, null, null);
        return zzbz2;
    }

    public void zzc(zzcb zzcb) {
        zzcb zzcb2 = zzcb;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzxD = zzcb2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzc(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (this.zzxi && !TextUtils.isEmpty(str4)) {
            zzbv zzhb = zzr.zzbF().zzhb();
            if (zzhb != null) {
                Object obj = this.zzpV;
                synchronized (obj) {
                    try {
                        zzhb.zzL(str3).zza(this.zzxA, str3, str4);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
        }
    }

    public zzbz zzdB() {
        return zzb(zzr.zzbG().elapsedRealtime());
    }

    public void zzdC() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzxC = zzdB();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public String zzdD() {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = sb3;
        zzbz zzbz = this.zzpV;
        synchronized (zzbz) {
            try {
                for (zzbz zzbz2 : this.zzxz) {
                    long time = zzbz2.getTime();
                    String zzdy = zzbz2.zzdy();
                    th = zzbz2.zzdz();
                    if (zzbz != null && time > 0) {
                        StringBuilder append = sb5.append(zzdy).append('.').append(time - zzbz.getTime()).append(',');
                    }
                }
                this.zzxz.clear();
                if (!TextUtils.isEmpty(this.zzxB)) {
                    StringBuilder append2 = sb5.append(this.zzxB);
                } else if (sb5.length() > 0) {
                    sb5.setLength(-1 + sb5.length());
                }
                sb2 = sb5.toString();
            } finally {
                Throwable th = th;
                zzbz zzbz3 = zzbz;
                Throwable th2 = th;
            }
        }
        return sb2;
    }

    public zzbz zzdE() {
        zzbz zzbz = this.zzpV;
        synchronized (zzbz) {
            try {
                th = this.zzxC;
            } finally {
                Throwable th = th;
                zzbz zzbz2 = zzbz;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> zzn() {
        Map<String, String> map;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzbv zzhb = zzr.zzbF().zzhb();
                if (zzhb == null || this.zzxD == null) {
                    th = this.zzxA;
                    return map;
                }
                Map zza = zzhb.zza(this.zzxA, this.zzxD.zzn());
                return zza;
            } finally {
                map = th;
                Object obj2 = obj;
                Throwable th = map;
            }
        }
    }
}
