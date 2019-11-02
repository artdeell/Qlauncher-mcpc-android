package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Future;

@zzhb
public class zzd extends com.google.android.gms.internal.zzfv.zza implements zzs {
    static final int zzEg = Color.argb(0, 0, 0, 0);
    /* access modifiers changed from: private */
    public final Activity mActivity;
    RelativeLayout zzDm;
    AdOverlayInfoParcel zzEh;
    zzc zzEi;
    zzo zzEj;
    boolean zzEk = false;
    FrameLayout zzEl;
    CustomViewCallback zzEm;
    boolean zzEn = false;
    boolean zzEo = false;
    boolean zzEp = false;
    int zzEq = 0;
    zzl zzEr;
    private boolean zzEs;
    private boolean zzEt = false;
    private boolean zzEu = true;
    zzjp zzpD;

    @zzhb
    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzhb
    static final class zzb extends RelativeLayout {
        zziu zzrU;

        public zzb(Context context, String str) {
            zziu zziu;
            Context context2 = context;
            String str2 = str;
            super(context2);
            zziu zziu2 = zziu;
            zziu zziu3 = new zziu(context2, str2);
            this.zzrU = zziu2;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            MotionEvent motionEvent2 = motionEvent;
            this.zzrU.zze(motionEvent2);
            return false;
        }
    }

    @zzhb
    public static class zzc {
        public final Context context;
        public final int index;
        public final LayoutParams zzEw;
        public final ViewGroup zzEx;

        public zzc(zzjp zzjp) throws zza {
            zza zza;
            zzjp zzjp2 = zzjp;
            this.zzEw = zzjp2.getLayoutParams();
            ViewParent parent = zzjp2.getParent();
            this.context = zzjp2.zzhQ();
            if (parent == null || !(parent instanceof ViewGroup)) {
                zza zza2 = zza;
                zza zza3 = new zza("Could not get the parent of the WebView for an overlay.");
                throw zza2;
            }
            this.zzEx = (ViewGroup) parent;
            this.index = this.zzEx.indexOfChild(zzjp2.getView());
            this.zzEx.removeView(zzjp2.getView());
            zzjp2.zzD(true);
        }
    }

    @zzhb
    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd$zzd reason: collision with other inner class name */
    private class C0867zzd extends zzim {
        final /* synthetic */ zzd zzEv;

        private C0867zzd(zzd zzd) {
            this.zzEv = zzd;
        }

        /* synthetic */ C0867zzd(zzd zzd, C01801 r7) {
            C01801 r2 = r7;
            this(zzd);
        }

        public void onStop() {
        }

        public void zzbr() {
            C01811 r8;
            Bitmap zzf = zzr.zzbC().zzf(this.zzEv.mActivity, this.zzEv.zzEh.zzEM.zzqn);
            if (zzf != null) {
                Drawable zza = zzr.zzbE().zza(this.zzEv.mActivity, zzf, this.zzEv.zzEh.zzEM.zzqo, this.zzEv.zzEh.zzEM.zzqp);
                Handler handler = zzir.zzMc;
                C01811 r4 = r8;
                final Drawable drawable = zza;
                C01811 r5 = new Runnable(this) {
                    final /* synthetic */ C0867zzd zzEz;

                    {
                        Drawable drawable = r7;
                        this.zzEz = r6;
                    }

                    public void run() {
                        this.zzEz.zzEv.mActivity.getWindow().setBackgroundDrawable(drawable);
                    }
                };
                boolean post = handler.post(r4);
            }
        }
    }

    public zzd(Activity activity) {
        zzq zzq;
        Activity activity2 = activity;
        this.mActivity = activity2;
        zzq zzq2 = zzq;
        zzq zzq3 = new zzq();
        this.zzEr = zzq2;
    }

    public void close() {
        this.zzEq = 2;
        this.mActivity.finish();
    }

    public void onBackPressed() {
        this.zzEq = 0;
    }

    public void onCreate(Bundle bundle) {
        zzb zzb2;
        zzc zzc2;
        zza zza2;
        C0867zzd zzd;
        zza zza3;
        Bundle bundle2 = bundle;
        boolean z = false;
        if (bundle2 != null) {
            z = bundle2.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.zzEn = z;
        try {
            this.zzEh = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzEh == null) {
                zza zza4 = zza3;
                zza zza5 = new zza("Could not get info for ad overlay.");
                throw zza4;
            }
            if (this.zzEh.zzrl.zzNa > 7500000) {
                this.zzEq = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzEu = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzEh.zzEM != null) {
                this.zzEo = this.zzEh.zzEM.zzql;
            } else {
                this.zzEo = false;
            }
            if (((Boolean) zzbt.zzxe.get()).booleanValue() && this.zzEo && this.zzEh.zzEM.zzqn != null) {
                C0867zzd zzd2 = zzd;
                C0867zzd zzd3 = new C0867zzd(this, null);
                Future zzhn = zzd2.zzgd();
            }
            if (bundle2 == null) {
                if (this.zzEh.zzEC != null && this.zzEu) {
                    this.zzEh.zzEC.zzaX();
                }
                if (!(this.zzEh.zzEJ == 1 || this.zzEh.zzEB == null)) {
                    this.zzEh.zzEB.onAdClicked();
                }
            }
            zzb zzb3 = zzb2;
            zzb zzb4 = new zzb(this.mActivity, this.zzEh.zzEL);
            this.zzDm = zzb3;
            this.zzDm.setId(1000);
            switch (this.zzEh.zzEJ) {
                case 1:
                    zzx(false);
                    return;
                case 2:
                    zzc zzc3 = zzc2;
                    zzc zzc4 = new zzc(this.zzEh.zzED);
                    this.zzEi = zzc3;
                    zzx(false);
                    return;
                case 3:
                    zzx(true);
                    return;
                case 4:
                    if (this.zzEn) {
                        this.zzEq = 3;
                        this.mActivity.finish();
                        return;
                    } else if (!zzr.zzbz().zza((Context) this.mActivity, this.zzEh.zzEA, this.zzEh.zzEI)) {
                        this.zzEq = 3;
                        this.mActivity.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    zza zza6 = zza2;
                    zza zza7 = new zza("Could not determine ad overlay type.");
                    throw zza6;
            }
        } catch (zza e) {
            zzin.zzaK(e.getMessage());
            this.zzEq = 3;
            this.mActivity.finish();
        }
    }

    public void onDestroy() {
        if (this.zzpD != null) {
            this.zzDm.removeView(this.zzpD.getView());
        }
        zzfp();
    }

    public void onPause() {
        this.zzEr.pause();
        zzfl();
        if (this.zzEh.zzEC != null) {
            this.zzEh.zzEC.onPause();
        }
        if (this.zzpD != null && (!this.mActivity.isFinishing() || this.zzEi == null)) {
            boolean zzi = zzr.zzbE().zzi(this.zzpD);
        }
        zzfp();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.zzEh != null && this.zzEh.zzEJ == 4) {
            if (this.zzEn) {
                this.zzEq = 3;
                this.mActivity.finish();
            } else {
                this.zzEn = true;
            }
        }
        if (this.zzEh.zzEC != null) {
            this.zzEh.zzEC.onResume();
        }
        if (this.zzpD == null || this.zzpD.isDestroyed()) {
            zzin.zzaK("The webview does not exit. Ignoring action.");
        } else {
            boolean zzj = zzr.zzbE().zzj(this.zzpD);
        }
        this.zzEr.resume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzEn);
    }

    public void onStart() {
    }

    public void onStop() {
        zzfp();
    }

    public void setRequestedOrientation(int i) {
        int i2 = i;
        this.mActivity.setRequestedOrientation(i2);
    }

    public void zza(View view, CustomViewCallback customViewCallback) {
        FrameLayout frameLayout;
        View view2 = view;
        CustomViewCallback customViewCallback2 = customViewCallback;
        FrameLayout frameLayout2 = frameLayout;
        FrameLayout frameLayout3 = new FrameLayout(this.mActivity);
        this.zzEl = frameLayout2;
        this.zzEl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzEl.addView(view2, -1, -1);
        this.mActivity.setContentView(this.zzEl);
        zzaD();
        this.zzEm = customViewCallback2;
        this.zzEk = true;
    }

    public void zza(boolean z, boolean z2) {
        boolean z3 = z;
        boolean z4 = z2;
        if (this.zzEj != null) {
            this.zzEj.zza(z3, z4);
        }
    }

    public void zzaD() {
        this.zzEs = true;
    }

    public void zzfl() {
        if (this.zzEh != null && this.zzEk) {
            setRequestedOrientation(this.zzEh.orientation);
        }
        if (this.zzEl != null) {
            this.mActivity.setContentView(this.zzDm);
            zzaD();
            this.zzEl.removeAllViews();
            this.zzEl = null;
        }
        if (this.zzEm != null) {
            this.zzEm.onCustomViewHidden();
            this.zzEm = null;
        }
        this.zzEk = false;
    }

    public void zzfm() {
        this.zzEq = 1;
        this.mActivity.finish();
    }

    public boolean zzfn() {
        boolean z = true;
        this.zzEq = 0;
        if (this.zzpD != null) {
            if (!this.zzpD.zzfL() || !this.zzEr.zzfL()) {
                z = false;
            }
            if (!z) {
                this.zzpD.zza("onbackblocked", Collections.emptyMap());
                return z;
            }
        }
        return z;
    }

    public void zzfo() {
        this.zzDm.removeView(this.zzEj);
        zzw(true);
    }

    /* access modifiers changed from: protected */
    public void zzfp() {
        if (this.mActivity.isFinishing() && !this.zzEt) {
            this.zzEt = true;
            if (this.zzpD != null) {
                zzy(this.zzEq);
                this.zzDm.removeView(this.zzpD.getView());
                if (this.zzEi != null) {
                    this.zzpD.setContext(this.zzEi.context);
                    this.zzpD.zzD(false);
                    this.zzEi.zzEx.addView(this.zzpD.getView(), this.zzEi.index, this.zzEi.zzEw);
                    this.zzEi = null;
                } else if (this.mActivity.getApplicationContext() != null) {
                    this.zzpD.setContext(this.mActivity.getApplicationContext());
                }
                this.zzpD = null;
            }
            if (!(this.zzEh == null || this.zzEh.zzEC == null)) {
                this.zzEh.zzEC.zzaW();
            }
            this.zzEr.destroy();
        }
    }

    public void zzfq() {
        if (this.zzEp) {
            this.zzEp = false;
            zzfr();
        }
    }

    /* access modifiers changed from: protected */
    public void zzfr() {
        this.zzpD.zzfr();
    }

    public void zzg(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        this.zzEr.zzg(zzjp2, map2);
    }

    public void zzw(boolean z) {
        zzo zzo;
        RelativeLayout.LayoutParams layoutParams;
        boolean z2 = z;
        zzo zzo2 = zzo;
        zzo zzo3 = new zzo(this.mActivity, z2 ? 50 : 32, this);
        this.zzEj = zzo2;
        RelativeLayout.LayoutParams layoutParams2 = layoutParams;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams4 = layoutParams2;
        layoutParams4.addRule(10);
        layoutParams4.addRule(z2 ? 11 : 9);
        this.zzEj.zza(z2, this.zzEh.zzEG);
        this.zzDm.addView(this.zzEj, layoutParams4);
    }

    /* access modifiers changed from: protected */
    public void zzx(boolean z) throws zza {
        StringBuilder sb;
        C01801 r20;
        zza zza2;
        zza zza3;
        boolean z2 = z;
        if (!this.zzEs) {
            boolean requestWindowFeature = this.mActivity.requestWindowFeature(1);
        }
        Window window = this.mActivity.getWindow();
        if (window == null) {
            zza zza4 = zza3;
            zza zza5 = new zza("Invalid activity, no window available.");
            throw zza4;
        }
        if (!this.zzEo || (this.zzEh.zzEM != null && this.zzEh.zzEM.zzqm)) {
            window.setFlags(1024, 1024);
        }
        boolean zzcv = this.zzEh.zzED.zzhU().zzcv();
        this.zzEp = false;
        if (zzcv) {
            if (this.zzEh.orientation == zzr.zzbE().zzhv()) {
                this.zzEp = this.mActivity.getResources().getConfiguration().orientation == 1;
            } else if (this.zzEh.orientation == zzr.zzbE().zzhw()) {
                this.zzEp = this.mActivity.getResources().getConfiguration().orientation == 2;
            }
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("Delay onShow to next orientation change: ").append(this.zzEp).toString());
        setRequestedOrientation(this.zzEh.orientation);
        if (zzr.zzbE().zza(window)) {
            zzin.zzaI("Hardware acceleration on the AdActivity window enabled.");
        }
        if (!this.zzEo) {
            this.zzDm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            this.zzDm.setBackgroundColor(zzEg);
        }
        this.mActivity.setContentView(this.zzDm);
        zzaD();
        if (z2) {
            this.zzpD = zzr.zzbD().zza(this.mActivity, this.zzEh.zzED.zzaN(), true, zzcv, null, this.zzEh.zzrl, null, this.zzEh.zzED.zzhR());
            this.zzpD.zzhU().zzb(null, null, this.zzEh.zzEE, this.zzEh.zzEI, true, this.zzEh.zzEK, null, this.zzEh.zzED.zzhU().zzig(), null);
            zzjq zzhU = this.zzpD.zzhU();
            C01801 r11 = r20;
            C01801 r12 = new com.google.android.gms.internal.zzjq.zza(this) {
                final /* synthetic */ zzd zzEv;

                {
                    this.zzEv = r5;
                }

                public void zza(zzjp zzjp, boolean z) {
                    boolean z2 = z;
                    zzjp.zzfr();
                }
            };
            zzhU.zza((com.google.android.gms.internal.zzjq.zza) r11);
            if (this.zzEh.url != null) {
                this.zzpD.loadUrl(this.zzEh.url);
            } else if (this.zzEh.zzEH != null) {
                this.zzpD.loadDataWithBaseURL(this.zzEh.zzEF, this.zzEh.zzEH, "text/html", "UTF-8", null);
            } else {
                zza zza6 = zza2;
                zza zza7 = new zza("No URL or HTML to display in ad overlay.");
                throw zza6;
            }
            if (this.zzEh.zzED != null) {
                this.zzEh.zzED.zzc(this);
            }
        } else {
            this.zzpD = this.zzEh.zzED;
            this.zzpD.setContext(this.mActivity);
        }
        this.zzpD.zzb(this);
        ViewParent parent = this.zzpD.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzpD.getView());
        }
        if (this.zzEo) {
            this.zzpD.setBackgroundColor(zzEg);
        }
        this.zzDm.addView(this.zzpD.getView(), -1, -1);
        if (!z2 && !this.zzEp) {
            zzfr();
        }
        zzw(zzcv);
        if (this.zzpD.zzhV()) {
            zza(zzcv, true);
        }
        com.google.android.gms.ads.internal.zzd zzhR = this.zzpD.zzhR();
        zzm zzm = zzhR != null ? zzhR.zzpy : null;
        if (zzm != null) {
            this.zzEr = zzm.zza(this.mActivity, this.zzpD, this.zzDm);
        } else {
            zzin.zzaK("Appstreaming controller is null.");
        }
    }

    /* access modifiers changed from: protected */
    public void zzy(int i) {
        int i2 = i;
        this.zzpD.zzy(i2);
    }
}
