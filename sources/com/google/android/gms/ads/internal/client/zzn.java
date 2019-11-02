package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzn {
    private static final Object zzqy;
    private static zzn zzur;
    private final zza zzus;
    private final zze zzut;
    private final zzl zzuu;
    private final zzaf zzuv;
    private final zzcv zzuw;
    private final zzf zzux;

    static {
        Object obj;
        zzn zzn;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
        zzn zzn2 = zzn;
        zzn zzn3 = new zzn();
        zza(zzn2);
    }

    protected zzn() {
        zza zza;
        zze zze;
        zzl zzl;
        zzaf zzaf;
        zzcv zzcv;
        zzf zzf;
        zza zza2 = zza;
        zza zza3 = new zza();
        this.zzus = zza2;
        zze zze2 = zze;
        zze zze3 = new zze();
        this.zzut = zze2;
        zzl zzl2 = zzl;
        zzl zzl3 = new zzl();
        this.zzuu = zzl2;
        zzaf zzaf2 = zzaf;
        zzaf zzaf3 = new zzaf();
        this.zzuv = zzaf2;
        zzcv zzcv2 = zzcv;
        zzcv zzcv3 = new zzcv();
        this.zzuw = zzcv2;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf();
        this.zzux = zzf2;
    }

    protected static void zza(zzn zzn) {
        zzn zzn2 = zzn;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                zzur = zzn2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static zzn zzcR() {
        zzn zzn = zzqy;
        synchronized (zzn) {
            try {
                th = zzur;
            } finally {
                Throwable th = th;
                zzn zzn2 = zzn;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static zza zzcS() {
        return zzcR().zzus;
    }

    public static zze zzcT() {
        return zzcR().zzut;
    }

    public static zzl zzcU() {
        return zzcR().zzuu;
    }

    public static zzaf zzcV() {
        return zzcR().zzuv;
    }

    public static zzcv zzcW() {
        return zzcR().zzuw;
    }

    public static zzf zzcX() {
        return zzcR().zzux;
    }
}
