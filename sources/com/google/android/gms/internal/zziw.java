package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzhb
public class zziw {
    private static zzl zzMy;
    public static final zza<Void> zzMz;
    private static final Object zzqy;

    public interface zza<T> {
        T zzgp();

        T zzh(InputStream inputStream);
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzMD;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaG;

        public zzb(String str, zza<T> zza, com.google.android.gms.internal.zzm.zzb<T> zzb) {
            C04251 r11;
            zza<T> zza2 = zza;
            com.google.android.gms.internal.zzm.zzb<T> zzb2 = zzb;
            String str2 = str;
            C04251 r7 = r11;
            final com.google.android.gms.internal.zzm.zzb<T> zzb3 = zzb2;
            final zza<T> zza3 = zza2;
            C04251 r8 = new com.google.android.gms.internal.zzm.zza() {
                {
                    zza zza = r7;
                }

                public void zze(zzr zzr) {
                    zzr zzr2 = zzr;
                    zzb3.zzb(zza3.zzgp());
                }
            };
            super(0, str2, r7);
            this.zzMD = zza2;
            this.zzaG = zzb2;
        }

        /* access modifiers changed from: protected */
        public zzm<InputStream> zza(zzi zzi) {
            ByteArrayInputStream byteArrayInputStream;
            zzi zzi2 = zzi;
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(zzi2.data);
            return zzm.zza(byteArrayInputStream2, zzx.zzb(zzi2));
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzj */
        public void zza(InputStream inputStream) {
            this.zzaG.zzb(this.zzMD.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzjd<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        final /* synthetic */ zziw zzMB;

        private zzc(zziw zziw) {
            this.zzMB = zziw;
        }

        /* synthetic */ zzc(zziw zziw, C04221 r7) {
            C04221 r2 = r7;
            this(zziw);
        }

        public void zzb(T t) {
            super.zzg(t);
        }
    }

    static {
        Object obj;
        C04221 r2;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
        C04221 r0 = r2;
        C04221 r1 = new zza() {
            /* renamed from: zzhB */
            public Void zzgp() {
                return null;
            }

            /* renamed from: zzi */
            public Void zzh(InputStream inputStream) {
                InputStream inputStream2 = inputStream;
                return null;
            }
        };
        zzMz = r0;
    }

    public zziw(Context context) {
        zzMy = zzS(context);
    }

    private static zzl zzS(Context context) {
        zzl zzl;
        Context context2 = context;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzMy == null) {
                    zzMy = zzac.zza(context2.getApplicationContext());
                }
                th = zzMy;
            } finally {
                zzl = th;
                Object obj2 = obj;
                Throwable th = zzl;
            }
        }
        return zzl;
    }

    public <T> zzjg<T> zza(String str, zza<T> zza2) {
        zzc zzc2;
        zzb zzb2;
        String str2 = str;
        zza<T> zza3 = zza2;
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(this, null);
        zzc zzc5 = zzc3;
        zzl zzl = zzMy;
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(str2, zza3, zzc5);
        zzk zze = zzl.zze(zzb3);
        return zzc5;
    }

    public zzjg<String> zzb(String str, Map<String, String> map) {
        zzc zzc2;
        C04243 r15;
        C04232 r152;
        String str2 = str;
        Map<String, String> map2 = map;
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(this, null);
        zzc zzc5 = zzc3;
        C04243 r5 = r15;
        String str3 = str2;
        zzc zzc6 = zzc5;
        C04232 r10 = r152;
        final String str4 = str2;
        final zzc zzc7 = zzc5;
        C04232 r11 = new com.google.android.gms.internal.zzm.zza(this) {
            final /* synthetic */ zziw zzMB;

            {
                String str = r8;
                zzc zzc = r9;
                this.zzMB = r7;
            }

            public void zze(zzr zzr) {
                StringBuilder sb;
                zzr zzr2 = zzr;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Failed to load URL: ").append(str4).append("\n").append(zzr2.toString()).toString());
                zzc7.zzb(null);
            }
        };
        final Map<String, String> map3 = map2;
        C04243 r6 = new zzab(this, str3, zzc6, r10) {
            final /* synthetic */ zziw zzMB;

            {
                String str = r12;
                com.google.android.gms.internal.zzm.zzb zzb = r13;
                com.google.android.gms.internal.zzm.zza zza = r14;
                Map map = r15;
                this.zzMB = r11;
            }

            public Map<String, String> getHeaders() throws zza {
                return map3 == null ? super.getHeaders() : map3;
            }
        };
        zzk zze = zzMy.zze(r5);
        return zzc5;
    }
}
