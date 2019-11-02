package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjq.zza;
import java.util.concurrent.atomic.AtomicBoolean;

@zzhb
public abstract class zzgn implements zzit<Void>, zza {
    protected final Context mContext;
    protected final zzgr.zza zzGc;
    protected final zzif.zza zzGd;
    protected AdResponseParcel zzGe = this.zzGd.zzLe;
    private Runnable zzGf;
    protected final Object zzGg;
    /* access modifiers changed from: private */
    public AtomicBoolean zzGh;
    protected final zzjp zzpD;

    protected zzgn(Context context, zzif.zza zza, zzjp zzjp, zzgr.zza zza2) {
        Object obj;
        AtomicBoolean atomicBoolean;
        Context context2 = context;
        zzif.zza zza3 = zza;
        zzjp zzjp2 = zzjp;
        zzgr.zza zza4 = zza2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzGg = obj2;
        AtomicBoolean atomicBoolean2 = atomicBoolean;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(true);
        this.zzGh = atomicBoolean2;
        this.mContext = context2;
        this.zzGd = zza3;
        this.zzpD = zzjp2;
        this.zzGc = zza4;
    }

    private zzif zzD(int i) {
        zzif zzif;
        int i2 = i;
        AdRequestInfoParcel adRequestInfoParcel = this.zzGd.zzLd;
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(adRequestInfoParcel.zzHt, this.zzpD, this.zzGe.zzBQ, i2, this.zzGe.zzBR, this.zzGe.zzHV, this.zzGe.orientation, this.zzGe.zzBU, adRequestInfoParcel.zzHw, this.zzGe.zzHT, null, null, null, null, null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, this.zzGe.zzIj, this.zzGe.zzIk, this.zzGe.zzIl, this.zzGe.zzIm);
        return zzif2;
    }

    public void cancel() {
        if (this.zzGh.getAndSet(false)) {
            this.zzpD.stopLoading();
            boolean zzi = zzr.zzbE().zzi(this.zzpD);
            zzC(-1);
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    /* access modifiers changed from: protected */
    public void zzC(int i) {
        AdResponseParcel adResponseParcel;
        int i2 = i;
        if (i2 != -2) {
            AdResponseParcel adResponseParcel2 = adResponseParcel;
            AdResponseParcel adResponseParcel3 = new AdResponseParcel(i2, this.zzGe.zzBU);
            this.zzGe = adResponseParcel2;
        }
        this.zzpD.zzhO();
        this.zzGc.zzb(zzD(i2));
    }

    public void zza(zzjp zzjp, boolean z) {
        zzjp zzjp2 = zzjp;
        boolean z2 = z;
        zzin.zzaI("WebView finished loading.");
        if (this.zzGh.getAndSet(false)) {
            zzC(z2 ? zzgc() : -1);
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    /* renamed from: zzga */
    public final Void zzgd() {
        C03761 r5;
        zzx.zzcD("Webview render task needs to be called on UI thread.");
        C03761 r2 = r5;
        C03761 r3 = new Runnable(this) {
            final /* synthetic */ zzgn zzGi;

            {
                this.zzGi = r5;
            }

            public void run() {
                if (this.zzGi.zzGh.get()) {
                    zzin.m19e("Timed out waiting for WebView to finish loading.");
                    this.zzGi.cancel();
                }
            }
        };
        this.zzGf = r2;
        boolean postDelayed = zzir.zzMc.postDelayed(this.zzGf, ((Long) zzbt.zzwY.get()).longValue());
        zzgb();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zzgb();

    /* access modifiers changed from: protected */
    public int zzgc() {
        return -2;
    }
}
