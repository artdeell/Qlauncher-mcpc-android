package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlz<T> {
    /* access modifiers changed from: private */
    public static zza zzaiV = null;
    private static int zzaiW = 0;
    private static String zzaiX = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzqy;
    private T zzSC = null;
    protected final String zzvs;
    protected final T zzvt;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    protected zzlz(String str, T t) {
        String str2 = str;
        T t2 = t;
        this.zzvs = str2;
        this.zzvt = t2;
    }

    public static boolean isInitialized() {
        return zzaiV != null;
    }

    public static zzlz<Float> zza(String str, Float f) {
        C04454 r6;
        C04454 r2 = r6;
        C04454 r3 = new zzlz<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcx */
            public Float zzct(String str) {
                String str2 = str;
                return zzlz.zzaiV.zzb(this.zzvs, (Float) this.zzvt);
            }
        };
        return r2;
    }

    public static zzlz<Integer> zza(String str, Integer num) {
        C04443 r6;
        C04443 r2 = r6;
        C04443 r3 = new zzlz<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcw */
            public Integer zzct(String str) {
                String str2 = str;
                return zzlz.zzaiV.zzb(this.zzvs, (Integer) this.zzvt);
            }
        };
        return r2;
    }

    public static zzlz<Long> zza(String str, Long l) {
        C04432 r6;
        C04432 r2 = r6;
        C04432 r3 = new zzlz<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcv */
            public Long zzct(String str) {
                String str2 = str;
                return zzlz.zzaiV.getLong(this.zzvs, (Long) this.zzvt);
            }
        };
        return r2;
    }

    public static zzlz<Boolean> zzk(String str, boolean z) {
        C04421 r6;
        C04421 r2 = r6;
        C04421 r3 = new zzlz<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcu */
            public Boolean zzct(String str) {
                String str2 = str;
                return zzlz.zzaiV.zza(this.zzvs, (Boolean) this.zzvt);
            }
        };
        return r2;
    }

    public static int zzpW() {
        return zzaiW;
    }

    public static zzlz<String> zzv(String str, String str2) {
        C04465 r6;
        C04465 r2 = r6;
        C04465 r3 = new zzlz<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcy */
            public String zzct(String str) {
                String str2 = str;
                return zzlz.zzaiV.getString(this.zzvs, (String) this.zzvt);
            }
        };
        return r2;
    }

    public final T get() {
        return this.zzSC != null ? this.zzSC : zzct(this.zzvs);
    }

    /* access modifiers changed from: protected */
    public abstract T zzct(String str);

    /* JADX INFO: finally extract failed */
    public final T zzpX() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Object obj = get();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return obj;
        } catch (Throwable th) {
            Throwable th2 = th;
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th2;
        }
    }
}
