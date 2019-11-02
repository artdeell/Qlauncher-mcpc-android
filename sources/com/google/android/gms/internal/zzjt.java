package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
class zzjt extends WebView implements OnGlobalLayoutListener, DownloadListener, zzjp {
    private AdSizeParcel zzCh;
    private int zzDC = -1;
    private int zzDD = -1;
    private int zzDF = -1;
    private int zzDG = -1;
    private String zzEY = LibrariesRepository.MOJANG_MAVEN_REPO;
    private Boolean zzLB;
    private final zza zzNP;
    private zzjq zzNQ;
    private zzd zzNR;
    private boolean zzNS;
    private boolean zzNT;
    private boolean zzNU;
    private boolean zzNV;
    private int zzNW;
    private boolean zzNX = true;
    private zzbz zzNY;
    private zzbz zzNZ;
    private zzbz zzOa;
    private zzca zzOb;
    private WeakReference<OnClickListener> zzOc;
    private zzd zzOd;
    private Map<String, zzdr> zzOe;
    private final VersionInfoParcel zzpT;
    private final Object zzpV;
    private final com.google.android.gms.ads.internal.zzd zzpm;
    private zzjc zzrV;
    private final WindowManager zzsb;
    private final zzan zzyt;

    @zzhb
    public static class zza extends MutableContextWrapper {
        private Activity zzMM;
        private Context zzOg;
        private Context zzsa;

        public zza(Context context) {
            Context context2 = context;
            super(context2);
            setBaseContext(context2);
        }

        public Object getSystemService(String str) {
            return this.zzOg.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            Context context2 = context;
            this.zzsa = context2.getApplicationContext();
            this.zzMM = context2 instanceof Activity ? (Activity) context2 : null;
            this.zzOg = context2;
            super.setBaseContext(this.zzsa);
        }

        public void startActivity(Intent intent) {
            Intent intent2 = intent;
            if (this.zzMM == null || zzne.isAtLeastL()) {
                Intent flags = intent2.setFlags(268435456);
                this.zzsa.startActivity(intent2);
                return;
            }
            this.zzMM.startActivity(intent2);
        }

        public Activity zzhP() {
            return this.zzMM;
        }

        public Context zzhQ() {
            return this.zzOg;
        }
    }

    protected zzjt(zza zza2, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel, zzcb zzcb, com.google.android.gms.ads.internal.zzd zzd) {
        Object obj;
        zzjc zzjc;
        zzju zzju;
        zza zza3 = zza2;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        boolean z3 = z;
        boolean z4 = z2;
        zzan zzan2 = zzan;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzcb zzcb2 = zzcb;
        com.google.android.gms.ads.internal.zzd zzd2 = zzd;
        super(zza3);
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzNP = zza3;
        this.zzCh = adSizeParcel2;
        this.zzNU = z3;
        this.zzNW = -1;
        this.zzyt = zzan2;
        this.zzpT = versionInfoParcel2;
        this.zzpm = zzd2;
        this.zzsb = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzr.zzbC().zza((Context) zza3, versionInfoParcel2.afmaVersion, settings);
        boolean zza4 = zzr.zzbE().zza(getContext(), settings);
        setDownloadListener(this);
        zziq();
        if (zzne.zzsi()) {
            zzju zzju2 = zzju;
            zzju zzju3 = new zzju(this);
            addJavascriptInterface(zzju2, "googleAdsJsInterface");
        }
        zzjc zzjc2 = zzjc;
        zzjc zzjc3 = new zzjc(this.zzNP.zzhP(), this, null);
        this.zzrV = zzjc2;
        zzd(zzcb2);
    }

    static zzjt zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel, zzcb zzcb, com.google.android.gms.ads.internal.zzd zzd) {
        zzjt zzjt;
        zza zza2;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        boolean z3 = z;
        boolean z4 = z2;
        zzan zzan2 = zzan;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzcb zzcb2 = zzcb;
        com.google.android.gms.ads.internal.zzd zzd2 = zzd;
        zzjt zzjt2 = zzjt;
        zza zza3 = zza2;
        zza zza4 = new zza(context);
        zzjt zzjt3 = new zzjt(zza3, adSizeParcel2, z3, z4, zzan2, versionInfoParcel2, zzcb2, zzd2);
        return zzjt2;
    }

    private void zzd(zzcb zzcb) {
        zzca zzca;
        zzcb zzcb2;
        zzcb zzcb3 = zzcb;
        zziu();
        zzca zzca2 = zzca;
        zzcb zzcb4 = zzcb2;
        zzcb zzcb5 = new zzcb(true, "make_wv", this.zzCh.zzuh);
        zzca zzca3 = new zzca(zzcb4);
        this.zzOb = zzca2;
        this.zzOb.zzdA().zzc(zzcb3);
        this.zzNZ = zzbx.zzb(this.zzOb.zzdA());
        this.zzOb.zza("native:view_create", this.zzNZ);
        this.zzOa = null;
        this.zzNY = null;
    }

    /* JADX INFO: finally extract failed */
    private void zzio() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLB = zzr.zzbF().zzhg();
                if (this.zzLB == null) {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                }
            } catch (IllegalStateException e) {
                IllegalStateException illegalStateException = e;
                zzb(Boolean.valueOf(false));
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private void zzip() {
        zzcb zzdA = this.zzOb.zzdA();
        zzbz zzbz = this.zzNY;
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = "aeh";
        boolean zza2 = zzbx.zza(zzdA, zzbz, strArr2);
    }

    private void zziq() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzNU || this.zzCh.zzui) {
                    if (VERSION.SDK_INT < 14) {
                        zzin.zzaI("Disabling hardware acceleration on an overlay.");
                        zzir();
                    } else {
                        zzin.zzaI("Enabling hardware acceleration on an overlay.");
                        zzis();
                    }
                } else if (VERSION.SDK_INT < 18) {
                    zzin.zzaI("Disabling hardware acceleration on an AdView.");
                    zzir();
                } else {
                    zzin.zzaI("Enabling hardware acceleration on an AdView.");
                    zzis();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private void zzir() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzNV) {
                    boolean zzn = zzr.zzbE().zzn(this);
                }
                this.zzNV = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private void zzis() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzNV) {
                    boolean zzm = zzr.zzbE().zzm(this);
                }
                this.zzNV = false;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private void zzit() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzOe != null) {
                    for (zzdr release : this.zzOe.values()) {
                        release.release();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private void zziu() {
        if (this.zzOb != null) {
            zzcb zzdA = this.zzOb.zzdA();
            if (zzdA != null && zzr.zzbF().zzhb() != null) {
                boolean zza2 = zzr.zzbF().zzhb().zza(zzdA);
            }
        }
    }

    public void destroy() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zziu();
                this.zzrV.zzhF();
                if (this.zzNR != null) {
                    this.zzNR.close();
                    this.zzNR.onDestroy();
                    this.zzNR = null;
                }
                this.zzNQ.reset();
                if (!this.zzNT) {
                    boolean zzd = zzr.zzbR().zzd(this);
                    zzit();
                    this.zzNT = true;
                    zzin.m20v("Initiating WebView self destruct sequence in 3...");
                    this.zzNQ.zzii();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        String str2 = str;
        ValueCallback<String> valueCallback2 = valueCallback;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (isDestroyed()) {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                    }
                    return;
                }
                super.evaluateJavascript(str2, valueCallback2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzNT) {
                    boolean zzd = zzr.zzbR().zzd(this);
                    zzit();
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        super.finalize();
    }

    public String getRequestId() {
        String str = this.zzpV;
        synchronized (str) {
            try {
                th = this.zzEY;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public int getRequestedOrientation() {
        int i = this.zzpV;
        synchronized (i) {
            try {
                th = this.zzNW;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNT;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* JADX INFO: finally extract failed */
    public void loadData(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    super.loadData(str4, str5, str6);
                } else {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    super.loadDataWithBaseURL(str6, str7, str8, str9, str10);
                } else {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void loadUrl(String str) {
        StringBuilder sb;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    super.loadUrl(str2);
                } else {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                super.onAttachedToWindow();
                if (!isDestroyed()) {
                    this.zzrV.onAttachedToWindow();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    this.zzrV.onDetachedFromWindow();
                }
                super.onDetachedFromWindow();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        StringBuilder sb;
        Intent intent;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        long j2 = j;
        try {
            Intent intent2 = intent;
            Intent intent3 = new Intent("android.intent.action.VIEW");
            Intent intent4 = intent2;
            Intent dataAndType = intent4.setDataAndType(Uri.parse(str5), str8);
            zzr.zzbC().zzb(getContext(), intent4);
        } catch (ActivityNotFoundException e) {
            ActivityNotFoundException activityNotFoundException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaI(sb2.append("Couldn't find an Activity to view url/mimetype: ").append(str5).append(" / ").append(str8).toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas2.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas2);
            }
        }
    }

    public void onGlobalLayout() {
        boolean zzin = zzin();
        zzd zzhS = zzhS();
        if (zzhS != null && zzin) {
            zzhS.zzfq();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        StringBuilder sb;
        DisplayMetrics displayMetrics;
        int i3 = i;
        int i4 = i2;
        int i5 = Integer.MAX_VALUE;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (isDestroyed()) {
                    setMeasuredDimension(0, 0);
                } else if (isInEditMode() || this.zzNU || this.zzCh.zzuk || this.zzCh.zzul) {
                    super.onMeasure(i3, i4);
                } else if (this.zzCh.zzui) {
                    DisplayMetrics displayMetrics2 = displayMetrics;
                    DisplayMetrics displayMetrics3 = new DisplayMetrics();
                    DisplayMetrics displayMetrics4 = displayMetrics2;
                    this.zzsb.getDefaultDisplay().getMetrics(displayMetrics4);
                    setMeasuredDimension(displayMetrics4.widthPixels, displayMetrics4.heightPixels);
                } else {
                    int mode = MeasureSpec.getMode(i3);
                    int size = MeasureSpec.getSize(i3);
                    int mode2 = MeasureSpec.getMode(i4);
                    int size2 = MeasureSpec.getSize(i4);
                    int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
                    if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                        i5 = size2;
                    }
                    if (this.zzCh.widthPixels > i6 || this.zzCh.heightPixels > i5) {
                        float f = this.zzNP.getResources().getDisplayMetrics().density;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        zzin.zzaK(sb2.append("Not enough space to show ad. Needs ").append((int) (((float) this.zzCh.widthPixels) / f)).append("x").append((int) (((float) this.zzCh.heightPixels) / f)).append(" dp, but only has ").append((int) (((float) size) / f)).append("x").append((int) (((float) size2) / f)).append(" dp.").toString());
                        if (getVisibility() != 8) {
                            setVisibility(4);
                        }
                        setMeasuredDimension(0, 0);
                    } else {
                        if (getVisibility() != 8) {
                            setVisibility(0);
                        }
                        setMeasuredDimension(this.zzCh.widthPixels, this.zzCh.heightPixels);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (zzne.zzsd()) {
                    super.onPause();
                }
            } catch (Exception e) {
                zzin.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (zzne.zzsd()) {
                    super.onResume();
                }
            } catch (Exception e) {
                zzin.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (this.zzyt != null) {
            this.zzyt.zza(motionEvent2);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent2);
    }

    public void setContext(Context context) {
        this.zzNP.setBaseContext(context);
        this.zzrV.zzi(this.zzNP.zzhP());
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        WeakReference<OnClickListener> weakReference;
        OnClickListener onClickListener2 = onClickListener;
        WeakReference<OnClickListener> weakReference2 = weakReference;
        WeakReference<OnClickListener> weakReference3 = new WeakReference<>(onClickListener2);
        this.zzOc = weakReference2;
        super.setOnClickListener(onClickListener2);
    }

    public void setRequestedOrientation(int i) {
        int i2 = i;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNW = i2;
                if (this.zzNR != null) {
                    this.zzNR.setRequestedOrientation(this.zzNW);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = webViewClient;
        super.setWebViewClient(webViewClient2);
        if (webViewClient2 instanceof zzjq) {
            this.zzNQ = (zzjq) webViewClient2;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzin.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzD(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNU = z2;
                zziq();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzE(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzNR != null) {
                    this.zzNR.zza(this.zzNQ.zzcv(), z2);
                } else {
                    this.zzNS = z2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzF(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNX = z2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzcb zzcb) {
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzcb zzcb2 = zzcb;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzrV.zzhF();
                setContext(context2);
                this.zzNR = null;
                this.zzCh = adSizeParcel2;
                this.zzNU = false;
                this.zzNS = false;
                this.zzEY = LibrariesRepository.MOJANG_MAVEN_REPO;
                this.zzNW = -1;
                boolean zzj = zzr.zzbE().zzj(this);
                loadUrl("about:blank");
                this.zzNQ.reset();
                setOnTouchListener(null);
                setOnClickListener(null);
                this.zzNX = true;
                zzd(zzcb2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCh = adSizeParcel2;
                requestLayout();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(zzau zzau, boolean z) {
        HashMap hashMap;
        zzau zzau2 = zzau;
        boolean z2 = z;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("isVisible", z2 ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap4);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @TargetApi(19)
    public void zza(String str, ValueCallback<String> valueCallback) {
        String str2 = str;
        ValueCallback<String> valueCallback2 = valueCallback;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    evaluateJavascript(str2, valueCallback2);
                } else {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        if (this.zzNQ != null) {
            this.zzNQ.zza(str2, zzdf2);
        }
    }

    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzr.zzbC().zzG(map));
        } catch (JSONException e) {
            JSONException jSONException = e;
            zzin.zzaK("Could not convert parameters to JSON.");
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str2 = str;
        JSONObject jSONObject3 = jSONObject;
        if (jSONObject3 == null) {
            JSONObject jSONObject4 = jSONObject2;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject3 = jSONObject4;
        }
        zze(str2, jSONObject3.toString());
    }

    public void zzaL(String str) {
        StringBuilder sb;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                super.loadUrl(str2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzaM(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            if (str2 == null) {
                str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
            }
            try {
                this.zzEY = str2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel = this.zzpV;
        synchronized (adSizeParcel) {
            try {
                th = this.zzCh;
            } finally {
                Throwable th = th;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void zzaO(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isDestroyed()) {
                    loadUrl(str2);
                } else {
                    zzin.zzaK("The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaP(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        if (zzne.zzsk()) {
            if (zzhg() == null) {
                zzio();
            }
            if (zzhg().booleanValue()) {
                zza(str2, null);
                return;
            }
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            zzaO(sb3.append("javascript:").append(str2).toString());
            return;
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        zzaO(sb5.append("javascript:").append(str2).toString());
    }

    public void zzb(zzd zzd) {
        zzd zzd2 = zzd;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNR = zzd2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(Boolean bool) {
        Boolean bool2 = bool;
        Boolean bool3 = bool2;
        this.zzLB = bool3;
        zzr.zzbF().zzb(bool2);
    }

    public void zzb(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        if (this.zzNQ != null) {
            this.zzNQ.zzb(str2, zzdf2);
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        StringBuilder sb;
        StringBuilder sb2;
        JSONObject jSONObject2;
        String str2 = str;
        JSONObject jSONObject3 = jSONObject;
        if (jSONObject3 == null) {
            JSONObject jSONObject4 = jSONObject2;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject3 = jSONObject4;
        }
        String jSONObject6 = jSONObject3.toString();
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = sb3;
        StringBuilder append = sb5.append("AFMA_ReceiveMessage('");
        StringBuilder append2 = sb5.append(str2);
        StringBuilder append3 = sb5.append("'");
        StringBuilder append4 = sb5.append(",");
        StringBuilder append5 = sb5.append(jSONObject6);
        StringBuilder append6 = sb5.append(");");
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        zzin.m20v(sb6.append("Dispatching AFMA event: ").append(sb5.toString()).toString());
        zzaP(sb5.toString());
    }

    public void zzc(zzd zzd) {
        zzd zzd2 = zzd;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzOd = zzd2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zze(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzaP(sb2.append(str3).append("(").append(str4).append(");").toString());
    }

    public boolean zzfL() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                zzcb zzdA = this.zzOb.zzdA();
                zzbz zzbz = this.zzNY;
                String[] strArr = new String[1];
                String[] strArr2 = strArr;
                strArr[0] = "aebb";
                boolean zza2 = zzbx.zza(zzdA, zzbz, strArr2);
                th = this.zzNX;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzfr() {
        HashMap hashMap;
        if (this.zzNY == null) {
            zzcb zzdA = this.zzOb.zzdA();
            zzbz zzbz = this.zzOa;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "aes";
            boolean zza2 = zzbx.zza(zzdA, zzbz, strArr2);
            this.zzNY = zzbx.zzb(this.zzOb.zzdA());
            this.zzOb.zza("native:view_show", this.zzNY);
        }
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(1);
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("version", this.zzpT.afmaVersion);
        zza("onshow", (Map<String, ?>) hashMap4);
    }

    public void zzhN() {
        HashMap hashMap;
        zzip();
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(1);
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("version", this.zzpT.afmaVersion);
        zza("onhide", (Map<String, ?>) hashMap4);
    }

    public void zzhO() {
        HashMap hashMap;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(2);
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("app_volume", String.valueOf(zzr.zzbC().zzbt()));
        Object put2 = hashMap4.put("device_volume", String.valueOf(zzr.zzbC().zzQ(getContext())));
        zza("volume", (Map<String, ?>) hashMap4);
    }

    public Activity zzhP() {
        return this.zzNP.zzhP();
    }

    public Context zzhQ() {
        return this.zzNP.zzhQ();
    }

    public com.google.android.gms.ads.internal.zzd zzhR() {
        return this.zzpm;
    }

    public zzd zzhS() {
        zzd zzd = this.zzpV;
        synchronized (zzd) {
            try {
                th = this.zzNR;
            } finally {
                Throwable th = th;
                zzd zzd2 = zzd;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzd zzhT() {
        zzd zzd = this.zzpV;
        synchronized (zzd) {
            try {
                th = this.zzOd;
            } finally {
                Throwable th = th;
                zzd zzd2 = zzd;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzjq zzhU() {
        return this.zzNQ;
    }

    public boolean zzhV() {
        return this.zzNS;
    }

    public zzan zzhW() {
        return this.zzyt;
    }

    public VersionInfoParcel zzhX() {
        return this.zzpT;
    }

    public boolean zzhY() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNU;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzhZ() {
        C04301 r7;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzin.m20v("Destroying WebView!");
                Handler handler = zzir.zzMc;
                C04301 r4 = r7;
                C04301 r5 = new Runnable(this) {
                    final /* synthetic */ zzjt zzOf;

                    {
                        this.zzOf = r5;
                    }

                    public void run() {
                        zzjt.super.destroy();
                    }
                };
                boolean post = handler.post(r4);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Boolean zzhg() {
        Boolean bool = this.zzpV;
        synchronized (bool) {
            try {
                th = this.zzLB;
            } finally {
                Throwable th = th;
                Boolean bool2 = bool;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzjo zzia() {
        return null;
    }

    public zzbz zzib() {
        return this.zzOa;
    }

    public zzca zzic() {
        return this.zzOb;
    }

    public void zzid() {
        this.zzrV.zzhE();
    }

    public void zzie() {
        if (this.zzOa == null) {
            this.zzOa = zzbx.zzb(this.zzOb.zzdA());
            this.zzOb.zza("native:view_load", this.zzOa);
        }
    }

    public OnClickListener zzif() {
        return (OnClickListener) this.zzOc.get();
    }

    public boolean zzin() {
        int i;
        int i2;
        zzfs zzfs;
        if (zzhU().zzcv()) {
            DisplayMetrics zza2 = zzr.zzbC().zza(this.zzsb);
            int zzb = zzn.zzcS().zzb(zza2, zza2.widthPixels);
            int zzb2 = zzn.zzcS().zzb(zza2, zza2.heightPixels);
            Activity zzhP = zzhP();
            if (zzhP == null || zzhP.getWindow() == null) {
                i2 = zzb2;
                i = zzb;
            } else {
                int[] zze = zzr.zzbC().zze(zzhP);
                i = zzn.zzcS().zzb(zza2, zze[0]);
                i2 = zzn.zzcS().zzb(zza2, zze[1]);
            }
            if (!(this.zzDC == zzb && this.zzDD == zzb2 && this.zzDF == i && this.zzDG == i2)) {
                boolean z = (this.zzDC == zzb && this.zzDD == zzb2) ? false : true;
                this.zzDC = zzb;
                this.zzDD = zzb2;
                this.zzDF = i;
                this.zzDG = i2;
                zzfs zzfs2 = zzfs;
                zzfs zzfs3 = new zzfs(this);
                zzfs2.zza(zzb, zzb2, i, i2, zza2.density, this.zzsb.getDefaultDisplay().getRotation());
                return z;
            }
        }
        return false;
    }

    public void zzy(int i) {
        HashMap hashMap;
        int i2 = i;
        zzip();
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(2);
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("closetype", String.valueOf(i2));
        Object put2 = hashMap4.put("version", this.zzpT.afmaVersion);
        zza("onhide", (Map<String, ?>) hashMap4);
    }
}
