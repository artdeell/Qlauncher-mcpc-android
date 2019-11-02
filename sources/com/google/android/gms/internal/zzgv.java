package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
public class zzgv extends zzim {
    private final zzgw zzGC;
    private Future<zzif> zzGD;
    /* access modifiers changed from: private */
    public final zza zzGc;
    private final zzif.zza zzGd;
    private final AdResponseParcel zzGe;
    private final Object zzpV;

    public zzgv(Context context, zzp zzp, zzee zzee, zzif.zza zza, zzan zzan, zza zza2) {
        zzgw zzgw;
        zziw zziw;
        Context context2 = context;
        zzif.zza zza3 = zza;
        zzan zzan2 = zzan;
        zzif.zza zza4 = zza3;
        zza zza5 = zza2;
        zzgw zzgw2 = zzgw;
        Context context3 = context2;
        zzp zzp2 = zzp;
        zzee zzee2 = zzee;
        zziw zziw2 = zziw;
        zziw zziw3 = new zziw(context2);
        zzgw zzgw3 = new zzgw(context3, zzp2, zzee2, zziw2, zzan2, zza3);
        this(zza4, zza5, zzgw2);
    }

    zzgv(zzif.zza zza, zza zza2, zzgw zzgw) {
        Object obj;
        zzif.zza zza3 = zza;
        zza zza4 = zza2;
        zzgw zzgw2 = zzgw;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzGd = zza3;
        this.zzGe = zza3.zzLe;
        this.zzGc = zza4;
        this.zzGC = zzgw2;
    }

    private zzif zzE(int i) {
        zzif zzif;
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(this.zzGd.zzLd.zzHt, null, null, i, null, null, this.zzGe.orientation, this.zzGe.zzBU, this.zzGd.zzLd.zzHw, false, null, null, null, null, null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, null, null, null, this.zzGd.zzLe.zzIm);
        return zzif2;
    }

    public void onStop() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzGD != null) {
                    boolean cancel = this.zzGD.cancel(true);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzbr() {
        int i;
        zzif zzif;
        C03801 r16;
        Object obj;
        Throwable th;
        try {
            obj = this.zzpV;
            synchronized (obj) {
                this.zzGD = zziq.zza((Callable<T>) this.zzGC);
            }
            zzif = (zzif) this.zzGD.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            TimeoutException timeoutException = e;
            zzin.zzaK("Timed out waiting for native ad.");
            boolean cancel = this.zzGD.cancel(true);
            i = 2;
            zzif = null;
        } catch (ExecutionException e2) {
            ExecutionException executionException = e2;
            zzif = null;
            i = 0;
        } catch (InterruptedException e3) {
            InterruptedException interruptedException = e3;
            i = -1;
            zzif = null;
        } catch (CancellationException e4) {
            CancellationException cancellationException = e4;
            i = -1;
            zzif = null;
        } catch (Throwable th2) {
            while (true) {
                th = th2;
                Object obj2 = obj;
            }
            throw th;
        }
        if (zzif == null) {
            zzif = zzE(i);
        }
        Handler handler = zzir.zzMc;
        C03801 r12 = r16;
        final zzif zzif2 = zzif;
        C03801 r13 = new Runnable(this) {
            final /* synthetic */ zzgv zzGE;

            {
                zzif zzif = r7;
                this.zzGE = r6;
            }

            public void run() {
                this.zzGE.zzGc.zzb(zzif2);
            }
        };
        boolean post = handler.post(r12);
    }
}
