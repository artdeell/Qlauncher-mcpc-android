package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

@zzhb
public abstract class zzgq extends zzim {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzgr.zza zzGc;
    protected final com.google.android.gms.internal.zzif.zza zzGd;
    protected AdResponseParcel zzGe;
    protected final Object zzGg;
    protected final Object zzpV;

    protected static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            int i2 = i;
            super(str);
            this.zzGu = i2;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    protected zzgq(Context context, com.google.android.gms.internal.zzif.zza zza2, com.google.android.gms.internal.zzgr.zza zza3) {
        Object obj;
        Object obj2;
        Context context2 = context;
        com.google.android.gms.internal.zzif.zza zza4 = zza2;
        com.google.android.gms.internal.zzgr.zza zza5 = zza3;
        super(true);
        Object obj3 = obj;
        Object obj4 = new Object();
        this.zzpV = obj3;
        Object obj5 = obj2;
        Object obj6 = new Object();
        this.zzGg = obj5;
        this.mContext = context2;
        this.zzGd = zza4;
        this.zzGe = zza4.zzLe;
        this.zzGc = zza5;
    }

    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public abstract zzif zzD(int i);

    /* JADX INFO: finally extract failed */
    public void zzbr() {
        int i;
        AdResponseParcel adResponseParcel;
        C03771 r14;
        AdResponseParcel adResponseParcel2;
        C03782 r142;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzin.zzaI("AdRendererBackgroundTask started.");
                i = this.zzGd.errorCode;
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                zza zza2 = e;
                int errorCode = zza2.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzin.zzaJ(zza2.getMessage());
                } else {
                    zzin.zzaK(zza2.getMessage());
                }
                if (this.zzGe == null) {
                    AdResponseParcel adResponseParcel3 = adResponseParcel2;
                    AdResponseParcel adResponseParcel4 = new AdResponseParcel(errorCode);
                    this.zzGe = adResponseParcel3;
                } else {
                    AdResponseParcel adResponseParcel5 = adResponseParcel;
                    AdResponseParcel adResponseParcel6 = new AdResponseParcel(errorCode, this.zzGe.zzBU);
                    this.zzGe = adResponseParcel5;
                }
                Handler handler = zzir.zzMc;
                C03771 r9 = r14;
                C03771 r10 = new Runnable(this) {
                    final /* synthetic */ zzgq zzGt;

                    {
                        this.zzGt = r5;
                    }

                    public void run() {
                        this.zzGt.onStop();
                    }
                };
                boolean post = handler.post(r9);
                i = errorCode;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
            zzif zzD = zzD(i);
            Handler handler2 = zzir.zzMc;
            C03782 r92 = r142;
            final zzif zzif = zzD;
            C03782 r102 = new Runnable(this) {
                final /* synthetic */ zzgq zzGt;

                {
                    zzif zzif = r7;
                    this.zzGt = r6;
                }

                public void run() {
                    Object obj = this.zzGt.zzpV;
                    synchronized (obj) {
                        try {
                            this.zzGt.zzm(zzif);
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Object obj2 = obj;
                            throw th2;
                        }
                    }
                }
            };
            boolean post2 = handler2.post(r92);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzh(long j) throws zza;

    /* access modifiers changed from: protected */
    public void zzm(zzif zzif) {
        zzif zzif2 = zzif;
        this.zzGc.zzb(zzif2);
    }
}
