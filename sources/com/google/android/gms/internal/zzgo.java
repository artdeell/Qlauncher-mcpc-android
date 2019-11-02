package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzgo implements Runnable {
    /* access modifiers changed from: private */
    public final Handler zzGj;
    /* access modifiers changed from: private */
    public final long zzGk;
    /* access modifiers changed from: private */
    public long zzGl;
    /* access modifiers changed from: private */
    public com.google.android.gms.internal.zzjq.zza zzGm;
    protected boolean zzGn;
    protected boolean zzGo;
    /* access modifiers changed from: private */
    public final int zzoG;
    /* access modifiers changed from: private */
    public final int zzoH;
    protected final zzjp zzpD;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzGp;
        private Bitmap zzGq;
        final /* synthetic */ zzgo zzGr;

        public zza(zzgo zzgo, WebView webView) {
            WebView webView2 = webView;
            this.zzGr = zzgo;
            this.zzGp = webView2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Canvas canvas;
            synchronized (this) {
                try {
                    this.zzGq = Bitmap.createBitmap(this.zzGr.zzoG, this.zzGr.zzoH, Config.ARGB_8888);
                    this.zzGp.setVisibility(0);
                    this.zzGp.measure(MeasureSpec.makeMeasureSpec(this.zzGr.zzoG, 0), MeasureSpec.makeMeasureSpec(this.zzGr.zzoH, 0));
                    this.zzGp.layout(0, 0, this.zzGr.zzoG, this.zzGr.zzoH);
                    Canvas canvas2 = canvas;
                    Canvas canvas3 = new Canvas(this.zzGq);
                    this.zzGp.draw(canvas2);
                    this.zzGp.invalidate();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public Boolean doInBackground(Void... voidArr) {
            Boolean bool;
            Void[] voidArr2 = voidArr;
            synchronized (this) {
                try {
                    int width = this.zzGq.getWidth();
                    int height = this.zzGq.getHeight();
                    if (width == 0 || height == 0) {
                        th = Boolean.valueOf(false);
                    } else {
                        int i = 0;
                        for (int i2 = 0; i2 < width; i2 += 10) {
                            for (int i3 = 0; i3 < height; i3 += 10) {
                                if (this.zzGq.getPixel(i2, i3) != 0) {
                                    i++;
                                }
                            }
                        }
                        bool = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
                    }
                } finally {
                    Throwable th = th;
                    Throwable th2 = th;
                }
            }
            return bool;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            long zzc = zzgo.zzc(this.zzGr);
            if (bool2.booleanValue() || this.zzGr.zzgg() || this.zzGr.zzGl <= 0) {
                this.zzGr.zzGo = bool2.booleanValue();
                this.zzGr.zzGm.zza(this.zzGr.zzpD, true);
            } else if (this.zzGr.zzGl > 0) {
                if (zzin.zzQ(2)) {
                    zzin.zzaI("Ad not detected, scheduling another run.");
                }
                boolean postDelayed = this.zzGr.zzGj.postDelayed(this.zzGr, this.zzGr.zzGk);
            }
        }
    }

    public zzgo(com.google.android.gms.internal.zzjq.zza zza2, zzjp zzjp, int i, int i2) {
        this(zza2, zzjp, i, i2, 200, 50);
    }

    public zzgo(com.google.android.gms.internal.zzjq.zza zza2, zzjp zzjp, int i, int i2, long j, long j2) {
        Handler handler;
        com.google.android.gms.internal.zzjq.zza zza3 = zza2;
        zzjp zzjp2 = zzjp;
        int i3 = i;
        int i4 = i2;
        long j3 = j2;
        this.zzGk = j;
        this.zzGl = j3;
        Handler handler2 = handler;
        Handler handler3 = new Handler(Looper.getMainLooper());
        this.zzGj = handler2;
        this.zzpD = zzjp2;
        this.zzGm = zza3;
        this.zzGn = false;
        this.zzGo = false;
        this.zzoH = i4;
        this.zzoG = i3;
    }

    static /* synthetic */ long zzc(zzgo zzgo) {
        zzgo zzgo2 = zzgo;
        long j = zzgo2.zzGl - 1;
        zzgo2.zzGl = j;
        return j;
    }

    public void run() {
        zza zza2;
        if (this.zzpD == null || zzgg()) {
            this.zzGm.zza(this.zzpD, true);
            return;
        }
        zza zza3 = zza2;
        zza zza4 = new zza(this, this.zzpD.getWebView());
        AsyncTask execute = zza3.execute(new Void[0]);
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zzjy zzjy;
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        AdResponseParcel adResponseParcel3 = adResponseParcel2;
        zzjy zzjy2 = zzjy;
        zzjy zzjy3 = new zzjy(this, this.zzpD, adResponseParcel2.zzIa);
        zza(adResponseParcel3, zzjy2);
    }

    public void zza(AdResponseParcel adResponseParcel, zzjy zzjy) {
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        this.zzpD.setWebViewClient(zzjy);
        this.zzpD.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel2.zzEF) ? null : zzr.zzbC().zzaC(adResponseParcel2.zzEF), adResponseParcel2.body, "text/html", "UTF-8", null);
    }

    public void zzge() {
        boolean postDelayed = this.zzGj.postDelayed(this, this.zzGk);
    }

    public void zzgf() {
        synchronized (this) {
            try {
                this.zzGn = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public boolean zzgg() {
        boolean z;
        synchronized (this) {
            try {
                th = this.zzGn;
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public boolean zzgh() {
        return this.zzGo;
    }
}
