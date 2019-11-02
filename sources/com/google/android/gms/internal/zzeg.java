package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

@zzhb
public class zzeg {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzAY;
    /* access modifiers changed from: private */
    public zzb<zzed> zzAZ;
    private zzb<zzed> zzBa;
    /* access modifiers changed from: private */
    public zze zzBb;
    /* access modifiers changed from: private */
    public int zzBc;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzpT;
    /* access modifiers changed from: private */
    public final Object zzpV;

    static class zza {
        static int zzBm = 60000;
        static int zzBn = IDirectInputDevice.DI_FFNOMINALMAX;
    }

    public interface zzb<T> {
        void zze(T t);
    }

    public static class zzc<T> implements zzb<T> {
        public zzc() {
        }

        public void zze(T t) {
        }
    }

    public static class zzd extends zzjj<zzeh> {
        /* access modifiers changed from: private */
        public final zze zzBo;
        private boolean zzBp;
        private final Object zzpV;

        public zzd(zze zze) {
            Object obj;
            zze zze2 = zze;
            Object obj2 = obj;
            Object obj3 = new Object();
            this.zzpV = obj2;
            this.zzBo = zze2;
        }

        public void release() {
            C03441 r8;
            com.google.android.gms.internal.zzji.zzb zzb;
            C03452 r82;
            C03463 r83;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (!this.zzBp) {
                        this.zzBp = true;
                        C03441 r4 = r8;
                        C03441 r5 = new com.google.android.gms.internal.zzji.zzc<zzeh>(this) {
                            final /* synthetic */ zzd zzBq;

                            {
                                this.zzBq = r5;
                            }

                            /* renamed from: zzd */
                            public void zze(zzeh zzeh) {
                                zzeh zzeh2 = zzeh;
                                zzin.m20v("Ending javascript session.");
                                ((zzei) zzeh2).zzew();
                            }
                        };
                        com.google.android.gms.internal.zzji.zzb zzb2 = zzb;
                        com.google.android.gms.internal.zzji.zzb zzb3 = new com.google.android.gms.internal.zzji.zzb();
                        zza(r4, zzb2);
                        C03452 r42 = r82;
                        C03452 r52 = new com.google.android.gms.internal.zzji.zzc<zzeh>(this) {
                            final /* synthetic */ zzd zzBq;

                            {
                                this.zzBq = r5;
                            }

                            /* renamed from: zzd */
                            public void zze(zzeh zzeh) {
                                zzeh zzeh2 = zzeh;
                                zzin.m20v("Releasing engine reference.");
                                this.zzBq.zzBo.zzet();
                            }
                        };
                        C03463 r53 = r83;
                        C03463 r6 = new com.google.android.gms.internal.zzji.zza(this) {
                            final /* synthetic */ zzd zzBq;

                            {
                                this.zzBq = r5;
                            }

                            public void run() {
                                this.zzBq.zzBo.zzet();
                            }
                        };
                        zza(r42, r53);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public static class zze extends zzjj<zzed> {
        /* access modifiers changed from: private */
        public zzb<zzed> zzBa;
        private boolean zzBr = false;
        private int zzBs = 0;
        private final Object zzpV;

        public zze(zzb<zzed> zzb) {
            Object obj;
            zzb<zzed> zzb2 = zzb;
            Object obj2 = obj;
            Object obj3 = new Object();
            this.zzpV = obj2;
            this.zzBa = zzb2;
        }

        public zzd zzes() {
            zzd zzd;
            C03471 r11;
            C03482 r112;
            zzd zzd2 = zzd;
            zzd zzd3 = new zzd(this);
            th = zzd2;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    C03471 r6 = r11;
                    final zzd zzd4 = th;
                    C03471 r7 = new com.google.android.gms.internal.zzji.zzc<zzed>(this) {
                        final /* synthetic */ zze zzBu;

                        {
                            zzd zzd = r7;
                            this.zzBu = r6;
                        }

                        /* renamed from: zza */
                        public void zze(zzed zzed) {
                            zzed zzed2 = zzed;
                            zzin.m20v("Getting a new session for JS Engine.");
                            zzd4.zzh(zzed2.zzen());
                        }
                    };
                    C03482 r72 = r112;
                    final zzd zzd5 = th;
                    C03482 r8 = new com.google.android.gms.internal.zzji.zza(this) {
                        final /* synthetic */ zze zzBu;

                        {
                            zzd zzd = r7;
                            this.zzBu = r6;
                        }

                        public void run() {
                            zzin.m20v("Rejecting reference for JS Engine.");
                            zzd5.reject();
                        }
                    };
                    zza(r6, r72);
                    zzx.zzab(this.zzBs >= 0);
                    this.zzBs = 1 + this.zzBs;
                } finally {
                    Throwable th = th;
                    Object obj2 = obj;
                    Throwable th2 = th;
                }
            }
            return th;
        }

        /* access modifiers changed from: protected */
        public void zzet() {
            boolean z = true;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (this.zzBs < 1) {
                        z = false;
                    }
                    zzx.zzab(z);
                    zzin.m20v("Releasing 1 reference for JS Engine");
                    this.zzBs = -1 + this.zzBs;
                    zzev();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }

        public void zzeu() {
            boolean z = true;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (this.zzBs < 0) {
                        z = false;
                    }
                    zzx.zzab(z);
                    zzin.m20v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                    this.zzBr = true;
                    zzev();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void zzev() {
            C03493 r8;
            com.google.android.gms.internal.zzji.zzb zzb;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    zzx.zzab(this.zzBs >= 0);
                    if (!this.zzBr || this.zzBs != 0) {
                        zzin.m20v("There are still references to the engine. Not destroying.");
                    } else {
                        zzin.m20v("No reference is left (including root). Cleaning up engine.");
                        C03493 r5 = r8;
                        C03493 r6 = new com.google.android.gms.internal.zzji.zzc<zzed>(this) {
                            final /* synthetic */ zze zzBu;

                            {
                                this.zzBu = r5;
                            }

                            /* renamed from: zza */
                            public void zze(zzed zzed) {
                                C03501 r6;
                                C03501 r2 = r6;
                                final zzed zzed2 = zzed;
                                C03501 r3 = new Runnable(this) {
                                    final /* synthetic */ C03493 zzBw;

                                    {
                                        zzed zzed = r7;
                                        this.zzBw = r6;
                                    }

                                    public void run() {
                                        this.zzBw.zzBu.zzBa.zze(zzed2);
                                        zzed2.destroy();
                                    }
                                };
                                zzir.runOnUiThread(r2);
                            }
                        };
                        com.google.android.gms.internal.zzji.zzb zzb2 = zzb;
                        com.google.android.gms.internal.zzji.zzb zzb3 = new com.google.android.gms.internal.zzji.zzb();
                        zza(r5, zzb2);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public zzeg(Context context, VersionInfoParcel versionInfoParcel, String str) {
        Object obj;
        zzc zzc2;
        zzc zzc3;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        String str2 = str;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzBc = 1;
        this.zzAY = str2;
        this.mContext = context2.getApplicationContext();
        this.zzpT = versionInfoParcel2;
        zzc zzc4 = zzc2;
        zzc zzc5 = new zzc();
        this.zzAZ = zzc4;
        zzc zzc6 = zzc3;
        zzc zzc7 = new zzc();
        this.zzBa = zzc6;
    }

    public zzeg(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzed> zzb2, zzb<zzed> zzb3) {
        zzb<zzed> zzb4 = zzb2;
        zzb<zzed> zzb5 = zzb3;
        this(context, versionInfoParcel, str);
        this.zzAZ = zzb4;
        this.zzBa = zzb5;
    }

    static /* synthetic */ int zza(zzeg zzeg, int i) {
        int i2 = i;
        zzeg.zzBc = i2;
        return i2;
    }

    static /* synthetic */ zze zza(zzeg zzeg, zze zze2) {
        zze zze3 = zze2;
        zzeg.zzBb = zze3;
        return zze3;
    }

    private zze zzep() {
        zze zze2;
        C03341 r6;
        zze zze3 = zze2;
        zze zze4 = new zze(this.zzBa);
        zze zze5 = zze3;
        C03341 r2 = r6;
        final zze zze6 = zze5;
        C03341 r3 = new Runnable(this) {
            final /* synthetic */ zzeg zzBe;

            {
                zze zze = r7;
                this.zzBe = r6;
            }

            public void run() {
                C03351 r10;
                C03382 r102;
                zzja zzja;
                C03393 r103;
                C03404 r104;
                zzed zza = this.zzBe.zza(this.zzBe.mContext, this.zzBe.zzpT);
                zzed zzed = zza;
                C03351 r5 = r10;
                final zzed zzed2 = zza;
                C03351 r6 = new com.google.android.gms.internal.zzed.zza(this) {
                    final /* synthetic */ C03341 zzBg;

                    {
                        zzed zzed = r7;
                        this.zzBg = r6;
                    }

                    public void zzeo() {
                        C03361 r5;
                        Handler handler = zzir.zzMc;
                        C03361 r2 = r5;
                        C03361 r3 = new Runnable(this) {
                            final /* synthetic */ C03351 zzBh;

                            {
                                this.zzBh = r5;
                            }

                            public void run() {
                                C03371 r6;
                                Object zzc = this.zzBh.zzBg.zzBe.zzpV;
                                synchronized (zzc) {
                                    try {
                                        if (zze6.getStatus() != -1 && zze6.getStatus() != 1) {
                                            zze6.reject();
                                            C03371 r3 = r6;
                                            C03371 r4 = new Runnable(this) {
                                                final /* synthetic */ C03361 zzBi;

                                                {
                                                    this.zzBi = r5;
                                                }

                                                public void run() {
                                                    zzed2.destroy();
                                                }
                                            };
                                            zzir.runOnUiThread(r3);
                                            zzin.m20v("Could not receive loaded message in a timely manner. Rejecting.");
                                        }
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        Object obj = zzc;
                                        throw th2;
                                    }
                                }
                            }
                        };
                        boolean postDelayed = handler.postDelayed(r2, (long) zza.zzBn);
                    }
                };
                zzed.zza(r5);
                C03382 r62 = r102;
                final zzed zzed3 = zza;
                C03382 r7 = new zzdf(this) {
                    final /* synthetic */ C03341 zzBg;

                    {
                        zzed zzed = r7;
                        this.zzBg = r6;
                    }

                    public void zza(zzjp zzjp, Map<String, String> map) {
                        zzjp zzjp2 = zzjp;
                        Map<String, String> map2 = map;
                        Object zzc = this.zzBg.zzBe.zzpV;
                        synchronized (zzc) {
                            try {
                                if (zze6.getStatus() != -1 && zze6.getStatus() != 1) {
                                    int zza = zzeg.zza(this.zzBg.zzBe, 0);
                                    this.zzBg.zzBe.zzAZ.zze(zzed3);
                                    zze6.zzh(zzed3);
                                    zze zza2 = zzeg.zza(this.zzBg.zzBe, zze6);
                                    zzin.m20v("Successfully loaded JS Engine.");
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Object obj = zzc;
                                throw th2;
                            }
                        }
                    }
                };
                zza.zza("/jsLoaded", (zzdf) r62);
                zzja zzja2 = zzja;
                zzja zzja3 = new zzja();
                zzja zzja4 = zzja2;
                C03393 r4 = r103;
                final zzed zzed4 = zza;
                final zzja zzja5 = zzja4;
                C03393 r52 = new zzdf(this) {
                    final /* synthetic */ C03341 zzBg;

                    {
                        zzed zzed = r8;
                        zzja zzja = r9;
                        this.zzBg = r7;
                    }

                    public void zza(zzjp zzjp, Map<String, String> map) {
                        zzjp zzjp2 = zzjp;
                        Map<String, String> map2 = map;
                        Object zzc = this.zzBg.zzBe.zzpV;
                        synchronized (zzc) {
                            try {
                                zzin.zzaJ("JS Engine is requesting an update");
                                if (this.zzBg.zzBe.zzBc == 0) {
                                    zzin.zzaJ("Starting reload.");
                                    int zza = zzeg.zza(this.zzBg.zzBe, 2);
                                    zze zzeq = this.zzBg.zzBe.zzeq();
                                }
                                zzed4.zzb("/requestReload", (zzdf) zzja5.get());
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Object obj = zzc;
                                throw th2;
                            }
                        }
                    }
                };
                C03393 r3 = r4;
                zzja4.set(r3);
                zza.zza("/requestReload", (zzdf) r3);
                if (this.zzBe.zzAY.endsWith(".js")) {
                    zza.zzZ(this.zzBe.zzAY);
                } else if (this.zzBe.zzAY.startsWith("<html>")) {
                    zza.zzab(this.zzBe.zzAY);
                } else {
                    zza.zzaa(this.zzBe.zzAY);
                }
                Handler handler = zzir.zzMc;
                C03404 r53 = r104;
                final zzed zzed5 = zza;
                C03404 r63 = new Runnable(this) {
                    final /* synthetic */ C03341 zzBg;

                    {
                        zzed zzed = r7;
                        this.zzBg = r6;
                    }

                    public void run() {
                        C03411 r6;
                        Object zzc = this.zzBg.zzBe.zzpV;
                        synchronized (zzc) {
                            try {
                                if (zze6.getStatus() != -1 && zze6.getStatus() != 1) {
                                    zze6.reject();
                                    C03411 r3 = r6;
                                    C03411 r4 = new Runnable(this) {
                                        final /* synthetic */ C03404 zzBk;

                                        {
                                            this.zzBk = r5;
                                        }

                                        public void run() {
                                            zzed5.destroy();
                                        }
                                    };
                                    zzir.runOnUiThread(r3);
                                    zzin.m20v("Could not receive loaded message in a timely manner. Rejecting.");
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Object obj = zzc;
                                throw th2;
                            }
                        }
                    }
                };
                boolean postDelayed = handler.postDelayed(r53, (long) zza.zzBm);
            }
        };
        zzir.runOnUiThread(r2);
        return zze5;
    }

    /* access modifiers changed from: protected */
    public zzed zza(Context context, VersionInfoParcel versionInfoParcel) {
        zzef zzef;
        zzef zzef2 = zzef;
        zzef zzef3 = new zzef(context, versionInfoParcel, null);
        return zzef2;
    }

    /* access modifiers changed from: protected */
    public zze zzeq() {
        C03422 r8;
        C03433 r82;
        zze zzep = zzep();
        zze zze2 = zzep;
        C03422 r3 = r8;
        final zze zze3 = zzep;
        C03422 r4 = new com.google.android.gms.internal.zzji.zzc<zzed>(this) {
            final /* synthetic */ zzeg zzBe;

            {
                zze zze = r7;
                this.zzBe = r6;
            }

            /* renamed from: zza */
            public void zze(zzed zzed) {
                zzed zzed2 = zzed;
                Object zzc = this.zzBe.zzpV;
                synchronized (zzc) {
                    try {
                        int zza = zzeg.zza(this.zzBe, 0);
                        if (!(this.zzBe.zzBb == null || zze3 == this.zzBe.zzBb)) {
                            zzin.m20v("New JS engine is loaded, marking previous one as destroyable.");
                            this.zzBe.zzBb.zzeu();
                        }
                        zze zza2 = zzeg.zza(this.zzBe, zze3);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zzc;
                        throw th2;
                    }
                }
            }
        };
        C03433 r42 = r82;
        final zze zze4 = zzep;
        C03433 r5 = new com.google.android.gms.internal.zzji.zza(this) {
            final /* synthetic */ zzeg zzBe;

            {
                zze zze = r7;
                this.zzBe = r6;
            }

            public void run() {
                Object zzc = this.zzBe.zzpV;
                synchronized (zzc) {
                    try {
                        int zza = zzeg.zza(this.zzBe, 1);
                        zzin.m20v("Failed loading new engine. Marking new engine destroyable.");
                        zze4.zzeu();
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zzc;
                        throw th2;
                    }
                }
            }
        };
        zze2.zza(r3, r42);
        return zzep;
    }

    public zzd zzer() {
        zzd zzd2;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzBb == null || this.zzBb.getStatus() == -1) {
                    this.zzBc = 2;
                    this.zzBb = zzeq();
                    th = this.zzBb.zzes();
                    return zzd2;
                } else if (this.zzBc == 0) {
                    zzd zzes = this.zzBb.zzes();
                    return zzes;
                } else if (this.zzBc == 1) {
                    this.zzBc = 2;
                    zze zzeq = zzeq();
                    zzd zzes2 = this.zzBb.zzes();
                    return zzes2;
                } else if (this.zzBc == 2) {
                    zzd zzes3 = this.zzBb.zzes();
                    return zzes3;
                } else {
                    zzd zzes4 = this.zzBb.zzes();
                    return zzes4;
                }
            } finally {
                zzd2 = th;
                Object obj2 = obj;
                Throwable th = zzd2;
            }
        }
    }
}
