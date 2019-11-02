package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public abstract class zzbp<T> {
    private final int zzvr;
    private final String zzvs;
    private final T zzvt;

    private zzbp(int i, String str, T t) {
        String str2 = str;
        T t2 = t;
        this.zzvr = i;
        this.zzvs = str2;
        this.zzvt = t2;
        zzr.zzbK().zza(this);
    }

    /* synthetic */ zzbp(int i, String str, Object obj, C02741 r13) {
        C02741 r4 = r13;
        this(i, str, obj);
    }

    public static zzbp<String> zza(int i, String str) {
        zzbp zza = zza(i, str, (String) null);
        zzr.zzbK().zzb(zza);
        return zza;
    }

    public static zzbp<Integer> zza(int i, String str, int i2) {
        C02752 r8;
        C02752 r3 = r8;
        C02752 r4 = new zzbp<Integer>(i, str, Integer.valueOf(i2)) {
            /* renamed from: zzc */
            public Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdq()).intValue()));
            }
        };
        return r3;
    }

    public static zzbp<Long> zza(int i, String str, long j) {
        C02763 r10;
        C02763 r4 = r10;
        C02763 r5 = new zzbp<Long>(i, str, Long.valueOf(j)) {
            /* renamed from: zzd */
            public Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdq()).longValue()));
            }
        };
        return r4;
    }

    public static zzbp<Boolean> zza(int i, String str, Boolean bool) {
        C02741 r8;
        C02741 r3 = r8;
        C02741 r4 = new zzbp<Boolean>(i, str, bool) {
            /* renamed from: zzb */
            public Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdq()).booleanValue()));
            }
        };
        return r3;
    }

    public static zzbp<String> zza(int i, String str, String str2) {
        C02774 r8;
        C02774 r3 = r8;
        C02774 r4 = new zzbp<String>(i, str, str2) {
            /* renamed from: zze */
            public String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzdq());
            }
        };
        return r3;
    }

    public static zzbp<String> zzb(int i, String str) {
        zzbp zza = zza(i, str, (String) null);
        zzr.zzbK().zzc(zza);
        return zza;
    }

    public T get() {
        return zzr.zzbL().zzd(this);
    }

    public String getKey() {
        return this.zzvs;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public T zzdq() {
        return this.zzvt;
    }
}
