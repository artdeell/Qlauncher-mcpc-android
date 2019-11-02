package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzif.zza;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzhb
public class zzgu extends zzgq {
    private zzeo zzCf;
    private boolean zzGA;
    private zzem zzGy;
    protected zzes zzGz;
    /* access modifiers changed from: private */
    public final zzjp zzpD;
    private final zzcb zzpe;
    private zzex zzpn;

    zzgu(Context context, zza zza, zzex zzex, zzgr.zza zza2, zzcb zzcb, zzjp zzjp) {
        zza zza3 = zza;
        zzex zzex2 = zzex;
        zzcb zzcb2 = zzcb;
        zzjp zzjp2 = zzjp;
        super(context, zza3, zza2);
        this.zzpn = zzex2;
        this.zzCf = zza3.zzKV;
        this.zzpe = zzcb2;
        this.zzpD = zzjp2;
    }

    static /* synthetic */ boolean zza(zzgu zzgu, boolean z) {
        boolean z2 = z;
        zzgu.zzGA = z2;
        return z2;
    }

    private void zzgk() throws zza {
        CountDownLatch countDownLatch;
        C03791 r12;
        zza zza;
        StringBuilder sb;
        zza zza2;
        zza zza3;
        CountDownLatch countDownLatch2 = countDownLatch;
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        CountDownLatch countDownLatch4 = countDownLatch2;
        Handler handler = zzir.zzMc;
        C03791 r8 = r12;
        final CountDownLatch countDownLatch5 = countDownLatch4;
        C03791 r9 = new Runnable(this) {
            final /* synthetic */ zzgu zzGB;

            {
                CountDownLatch countDownLatch = r7;
                this.zzGB = r6;
            }

            public void run() {
                Object obj = this.zzGB.zzGg;
                synchronized (obj) {
                    try {
                        boolean zza = zzgu.zza(this.zzGB, zzm.zza(this.zzGB.zzpD, this.zzGB.zzGz, countDownLatch5));
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
        };
        boolean post = handler.post(r8);
        try {
            boolean await = countDownLatch4.await(10, TimeUnit.SECONDS);
            Object obj = this.zzGg;
            synchronized (obj) {
                try {
                    if (!this.zzGA) {
                        zza zza4 = zza3;
                        zza zza5 = new zza("View could not be prepared", 0);
                        throw zza4;
                    } else if (this.zzpD.isDestroyed()) {
                        zza zza6 = zza2;
                        zza zza7 = new zza("Assets not loaded, web view is destroyed", 0);
                        throw zza6;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            zza zza8 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zza zza9 = new zza(sb2.append("Interrupted while waiting for latch : ").append(interruptedException).toString(), 0);
            throw zza8;
        }
    }

    public void onStop() {
        Object obj = this.zzGg;
        synchronized (obj) {
            try {
                super.onStop();
                if (this.zzGy != null) {
                    this.zzGy.cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzif zzD(int i) {
        zzen zzen;
        zzey zzey;
        String name;
        zzeq zzeq;
        zzif zzif;
        int i2 = i;
        AdRequestInfoParcel adRequestInfoParcel = this.zzGd.zzLd;
        AdRequestParcel adRequestParcel = adRequestInfoParcel.zzHt;
        zzjp zzjp = this.zzpD;
        List<String> list = this.zzGe.zzBQ;
        List<String> list2 = this.zzGe.zzBR;
        List<String> list3 = this.zzGe.zzHV;
        int i3 = this.zzGe.orientation;
        long j = this.zzGe.zzBU;
        String str = adRequestInfoParcel.zzHw;
        boolean z = this.zzGe.zzHT;
        if (this.zzGz != null) {
            zzen = this.zzGz.zzCp;
        } else {
            zzen = null;
        }
        if (this.zzGz != null) {
            zzey = this.zzGz.zzCq;
        } else {
            zzey = null;
        }
        if (this.zzGz != null) {
            name = this.zzGz.zzCr;
        } else {
            name = AdMobAdapter.class.getName();
        }
        zzeo zzeo = this.zzCf;
        if (this.zzGz != null) {
            zzeq = this.zzGz.zzCs;
        } else {
            zzeq = null;
        }
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(adRequestParcel, zzjp, list, i2, list2, list3, i3, j, str, z, zzen, zzey, name, zzeo, zzeq, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, this.zzGe.zzIj, this.zzGe.zzIk, this.zzGe.zzIl, this.zzGe.zzIm);
        return zzif2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void zzh(long j) throws zza {
        zza zza;
        zza zza2;
        StringBuilder sb;
        long j2 = j;
        Object obj = this.zzGg;
        synchronized (obj) {
            try {
                this.zzGy = zzi(j2);
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        this.zzGz = this.zzGy.zzc(this.zzCf.zzBO);
        switch (this.zzGz.zzCo) {
            case 0:
                if (this.zzGz.zzCp != null && this.zzGz.zzCp.zzBJ != null) {
                    zzgk();
                    return;
                }
                return;
            case 1:
                zza zza3 = zza;
                zza zza4 = new zza("No fill from any mediation ad networks.", 3);
                throw zza3;
            default:
                zza zza5 = zza2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zza zza6 = new zza(sb2.append("Unexpected mediation result: ").append(this.zzGz.zzCo).toString(), 0);
                throw zza5;
        }
    }

    /* access modifiers changed from: 0000 */
    public zzem zzi(long j) {
        zzev zzev;
        zzeu zzeu;
        long j2 = j;
        if (this.zzCf.zzBX != -1) {
            zzeu zzeu2 = zzeu;
            zzeu zzeu3 = new zzeu(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j2, ((Long) zzbt.zzwY.get()).longValue(), 2);
            return zzeu2;
        }
        zzev zzev2 = zzev;
        zzev zzev3 = new zzev(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j2, ((Long) zzbt.zzwY.get()).longValue(), this.zzpe);
        return zzev2;
    }
}
