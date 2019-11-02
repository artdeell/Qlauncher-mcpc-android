package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public abstract class zzau implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object zzpV;
    private boolean zzqJ = false;
    private zziz zzrQ;
    private final WeakReference<zzif> zzrW;
    private WeakReference<ViewTreeObserver> zzrX;
    private final zzbb zzrY;
    protected final zzaw zzrZ;
    private final Context zzsa;
    private final WindowManager zzsb;
    private final PowerManager zzsc;
    private final KeyguardManager zzsd;
    private zzay zzse;
    private boolean zzsf;
    private boolean zzsg = false;
    private boolean zzsh;
    private boolean zzsi;
    private boolean zzsj;
    BroadcastReceiver zzsk;
    private final HashSet<zzav> zzsl;
    private final zzdf zzsm;
    private final zzdf zzsn;
    private final zzdf zzso;

    public static class zza implements zzbb {
        private WeakReference<zzh> zzsq;

        public zza(zzh zzh) {
            WeakReference<zzh> weakReference;
            WeakReference<zzh> weakReference2 = weakReference;
            WeakReference<zzh> weakReference3 = new WeakReference<>(zzh);
            this.zzsq = weakReference2;
        }

        public View zzco() {
            zzh zzh = (zzh) this.zzsq.get();
            if (zzh != null) {
                return zzh.zzdS();
            }
            return null;
        }

        public boolean zzcp() {
            return this.zzsq.get() == null;
        }

        public zzbb zzcq() {
            zzb zzb;
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb((zzh) this.zzsq.get());
            return zzb2;
        }
    }

    public static class zzb implements zzbb {
        private zzh zzsr;

        public zzb(zzh zzh) {
            this.zzsr = zzh;
        }

        public View zzco() {
            return this.zzsr.zzdS();
        }

        public boolean zzcp() {
            return this.zzsr == null;
        }

        public zzbb zzcq() {
            return this;
        }
    }

    public static class zzc implements zzbb {
        private final View mView;
        private final zzif zzss;

        public zzc(View view, zzif zzif) {
            zzif zzif2 = zzif;
            this.mView = view;
            this.zzss = zzif2;
        }

        public View zzco() {
            return this.mView;
        }

        public boolean zzcp() {
            return this.zzss == null || this.mView == null;
        }

        public zzbb zzcq() {
            return this;
        }
    }

    public static class zzd implements zzbb {
        private final WeakReference<View> zzst;
        private final WeakReference<zzif> zzsu;

        public zzd(View view, zzif zzif) {
            WeakReference<View> weakReference;
            WeakReference<zzif> weakReference2;
            zzif zzif2 = zzif;
            WeakReference<View> weakReference3 = weakReference;
            WeakReference<View> weakReference4 = new WeakReference<>(view);
            this.zzst = weakReference3;
            WeakReference<zzif> weakReference5 = weakReference2;
            WeakReference<zzif> weakReference6 = new WeakReference<>(zzif2);
            this.zzsu = weakReference5;
        }

        public View zzco() {
            return (View) this.zzst.get();
        }

        public boolean zzcp() {
            return this.zzst.get() == null || this.zzsu.get() == null;
        }

        public zzbb zzcq() {
            zzc zzc;
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc((View) this.zzst.get(), (zzif) this.zzsu.get());
            return zzc2;
        }
    }

    public zzau(Context context, AdSizeParcel adSizeParcel, zzif zzif, VersionInfoParcel versionInfoParcel, zzbb zzbb) {
        Object obj;
        HashSet<zzav> hashSet;
        C02602 r15;
        C02613 r152;
        C02624 r153;
        WeakReference<zzif> weakReference;
        WeakReference<ViewTreeObserver> weakReference2;
        zziz zziz;
        zzaw zzaw;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzif zzif2 = zzif;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzbb zzbb2 = zzbb;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        HashSet<zzav> hashSet2 = hashSet;
        HashSet<zzav> hashSet3 = new HashSet<>();
        this.zzsl = hashSet2;
        C02602 r7 = r15;
        C02602 r8 = new zzdf(this) {
            final /* synthetic */ zzau zzsp;

            {
                this.zzsp = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                if (this.zzsp.zzb(map2)) {
                    this.zzsp.zza(zzjp2.getView(), map2);
                }
            }
        };
        this.zzsm = r7;
        C02613 r72 = r152;
        C02613 r82 = new zzdf(this) {
            final /* synthetic */ zzau zzsp;

            {
                this.zzsp = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                StringBuilder sb;
                zzjp zzjp2 = zzjp;
                if (this.zzsp.zzb(map)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzaI(sb2.append("Received request to untrack: ").append(this.zzsp.zzrZ.zzcu()).toString());
                    this.zzsp.destroy();
                }
            }
        };
        this.zzsn = r72;
        C02624 r73 = r153;
        C02624 r83 = new zzdf(this) {
            final /* synthetic */ zzau zzsp;

            {
                this.zzsp = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                if (this.zzsp.zzb(map2) && map2.containsKey("isVisible")) {
                    this.zzsp.zzg(Boolean.valueOf("1".equals(map2.get("isVisible")) || "true".equals(map2.get("isVisible"))).booleanValue());
                }
            }
        };
        this.zzso = r73;
        WeakReference<zzif> weakReference3 = weakReference;
        WeakReference<zzif> weakReference4 = new WeakReference<>(zzif2);
        this.zzrW = weakReference3;
        this.zzrY = zzbb2;
        WeakReference<ViewTreeObserver> weakReference5 = weakReference2;
        WeakReference<ViewTreeObserver> weakReference6 = new WeakReference<>(null);
        this.zzrX = weakReference5;
        this.zzsh = true;
        this.zzsj = false;
        zziz zziz2 = zziz;
        zziz zziz3 = new zziz(200);
        this.zzrQ = zziz2;
        zzaw zzaw2 = zzaw;
        zzaw zzaw3 = new zzaw(UUID.randomUUID().toString(), versionInfoParcel2, adSizeParcel2.zzuh, zzif2.zzKT, zzif2.zzcv(), adSizeParcel2.zzuk);
        this.zzrZ = zzaw2;
        this.zzsb = (WindowManager) context2.getSystemService("window");
        this.zzsc = (PowerManager) context2.getApplicationContext().getSystemService("power");
        this.zzsd = (KeyguardManager) context2.getSystemService("keyguard");
        this.zzsa = context2;
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzcj();
                zzce();
                this.zzsh = false;
                zzcg();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isScreenOn() {
        return this.zzsc.isScreenOn();
    }

    public void onGlobalLayout() {
        zzh(false);
    }

    public void onScrollChanged() {
        zzh(true);
    }

    public void pause() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzqJ = true;
                zzh(false);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void resume() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzqJ = false;
                zzh(false);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void stop() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsg = true;
                zzh(false);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int zza(int i, DisplayMetrics displayMetrics) {
        int i2 = i;
        return (int) (((float) i2) / displayMetrics.density);
    }

    /* access modifiers changed from: protected */
    public void zza(View view, Map<String, String> map) {
        View view2 = view;
        Map<String, String> map2 = map;
        zzh(false);
    }

    public void zza(zzav zzav) {
        zzav zzav2 = zzav;
        boolean add = this.zzsl.add(zzav2);
    }

    public void zza(zzay zzay) {
        zzay zzay2 = zzay;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzse = zzay2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        try {
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = jSONArray2;
            JSONObject jSONObject4 = jSONObject2;
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = jSONObject4;
            JSONArray put = jSONArray4.put(jSONObject3);
            JSONObject put2 = jSONObject6.put("units", jSONArray4);
            zzb(jSONObject6);
        } catch (Throwable th) {
            zzin.zzb("Skipping active view message.", th);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(zzeh zzeh) {
        zzeh zzeh2 = zzeh;
        zzeh2.zza("/updateActiveView", this.zzsm);
        zzeh2.zza("/untrackActiveViewUnit", this.zzsn);
        zzeh2.zza("/visibilityChanged", this.zzso);
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public boolean zzb(Map<String, String> map) {
        Map<String, String> map2 = map;
        if (map2 == null) {
            return false;
        }
        String str = (String) map2.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzrZ.zzcu());
    }

    /* access modifiers changed from: protected */
    public void zzc(zzeh zzeh) {
        zzeh zzeh2 = zzeh;
        zzeh2.zzb("/visibilityChanged", this.zzso);
        zzeh2.zzb("/untrackActiveViewUnit", this.zzsn);
        zzeh2.zzb("/updateActiveView", this.zzsm);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void zzcd() {
        IntentFilter intentFilter;
        C02591 r8;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsk == null) {
                    IntentFilter intentFilter2 = intentFilter;
                    IntentFilter intentFilter3 = new IntentFilter();
                    IntentFilter intentFilter4 = intentFilter2;
                    intentFilter4.addAction("android.intent.action.SCREEN_ON");
                    intentFilter4.addAction("android.intent.action.SCREEN_OFF");
                    C02591 r5 = r8;
                    C02591 r6 = new BroadcastReceiver(this) {
                        final /* synthetic */ zzau zzsp;

                        {
                            this.zzsp = r5;
                        }

                        public void onReceive(Context context, Intent intent) {
                            Context context2 = context;
                            Intent intent2 = intent;
                            this.zzsp.zzh(false);
                        }
                    };
                    this.zzsk = r5;
                    Intent registerReceiver = this.zzsa.registerReceiver(this.zzsk, intentFilter4);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzce() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsk != null) {
                    this.zzsa.unregisterReceiver(this.zzsk);
                    this.zzsk = null;
                }
            } catch (IllegalStateException e) {
                zzin.zzb("Failed trying to unregister the receiver", e);
            } catch (Exception e2) {
                zzr.zzbF().zzb((Throwable) e2, true);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzcf() {
        StringBuilder sb;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsh) {
                    this.zzsi = true;
                    zza(zzcn());
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzaI(sb2.append("Untracking ad unit: ").append(this.zzrZ.zzcu()).toString());
                }
            } catch (JSONException e) {
                zzin.zzb("JSON failure while processing active view data.", e);
            } catch (RuntimeException e2) {
                zzin.zzb("Failure while processing active view data.", e2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzcg() {
        if (this.zzse != null) {
            this.zzse.zza(this);
        }
    }

    public boolean zzch() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzsh;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: protected */
    public void zzci() {
        WeakReference<ViewTreeObserver> weakReference;
        View zzco = this.zzrY.zzcq().zzco();
        if (zzco != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzrX.get();
            ViewTreeObserver viewTreeObserver2 = zzco.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                zzcj();
                if (!this.zzsf || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.zzsf = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                WeakReference<ViewTreeObserver> weakReference2 = weakReference;
                WeakReference<ViewTreeObserver> weakReference3 = new WeakReference<>(viewTreeObserver2);
                this.zzrX = weakReference2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzcj() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzrX.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zzck() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        JSONObject put = jSONObject4.put("afmaVersion", this.zzrZ.zzcs()).put("activeViewJSON", this.zzrZ.zzct()).put("timestamp", zzr.zzbG().elapsedRealtime()).put("adFormat", this.zzrZ.zzcr()).put("hashCode", this.zzrZ.zzcu()).put("isMraid", this.zzrZ.zzcv()).put("isStopped", this.zzsg).put("isPaused", this.zzqJ).put("isScreenOn", isScreenOn()).put("isNative", this.zzrZ.zzcw());
        return jSONObject4;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzcl();

    /* access modifiers changed from: protected */
    public JSONObject zzcm() throws JSONException {
        return zzck().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    /* access modifiers changed from: protected */
    public JSONObject zzcn() throws JSONException {
        JSONObject zzck = zzck();
        JSONObject put = zzck.put("doneReasonCode", "u");
        return zzck;
    }

    /* access modifiers changed from: protected */
    public JSONObject zzd(View view) throws JSONException {
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        Rect rect5;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        View view2 = view;
        if (view2 == null) {
            return zzcm();
        }
        boolean isAttachedToWindow = zzr.zzbE().isAttachedToWindow(view2);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view2.getLocationOnScreen(iArr);
            view2.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzin.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view2.getContext().getResources().getDisplayMetrics();
        Rect rect6 = rect;
        Rect rect7 = new Rect();
        Rect rect8 = rect6;
        rect8.left = iArr[0];
        rect8.top = iArr[1];
        rect8.right = rect8.left + view2.getWidth();
        rect8.bottom = rect8.top + view2.getHeight();
        Rect rect9 = rect2;
        Rect rect10 = new Rect();
        Rect rect11 = rect9;
        rect11.right = this.zzsb.getDefaultDisplay().getWidth();
        rect11.bottom = this.zzsb.getDefaultDisplay().getHeight();
        Rect rect12 = rect3;
        Rect rect13 = new Rect();
        Rect rect14 = rect12;
        boolean globalVisibleRect = view2.getGlobalVisibleRect(rect14, null);
        Rect rect15 = rect4;
        Rect rect16 = new Rect();
        Rect rect17 = rect15;
        boolean localVisibleRect = view2.getLocalVisibleRect(rect17);
        Rect rect18 = rect5;
        Rect rect19 = new Rect();
        Rect rect20 = rect18;
        view2.getHitRect(rect20);
        JSONObject zzck = zzck();
        JSONObject jSONObject6 = jSONObject;
        JSONObject jSONObject7 = new JSONObject();
        JSONObject jSONObject8 = jSONObject2;
        JSONObject jSONObject9 = new JSONObject();
        JSONObject jSONObject10 = jSONObject3;
        JSONObject jSONObject11 = new JSONObject();
        JSONObject jSONObject12 = jSONObject4;
        JSONObject jSONObject13 = new JSONObject();
        JSONObject jSONObject14 = jSONObject5;
        JSONObject jSONObject15 = new JSONObject();
        JSONObject put = zzck.put("windowVisibility", view2.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", jSONObject6.put("top", zza(rect11.top, displayMetrics)).put("bottom", zza(rect11.bottom, displayMetrics)).put("left", zza(rect11.left, displayMetrics)).put("right", zza(rect11.right, displayMetrics))).put("adBox", jSONObject8.put("top", zza(rect8.top, displayMetrics)).put("bottom", zza(rect8.bottom, displayMetrics)).put("left", zza(rect8.left, displayMetrics)).put("right", zza(rect8.right, displayMetrics))).put("globalVisibleBox", jSONObject10.put("top", zza(rect14.top, displayMetrics)).put("bottom", zza(rect14.bottom, displayMetrics)).put("left", zza(rect14.left, displayMetrics)).put("right", zza(rect14.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", jSONObject12.put("top", zza(rect17.top, displayMetrics)).put("bottom", zza(rect17.bottom, displayMetrics)).put("left", zza(rect17.left, displayMetrics)).put("right", zza(rect17.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", jSONObject14.put("top", zza(rect20.top, displayMetrics)).put("bottom", zza(rect20.bottom, displayMetrics)).put("left", zza(rect20.left, displayMetrics)).put("right", zza(rect20.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzr.zzbC().zza(view2, this.zzsc, this.zzsd));
        return zzck;
    }

    /* access modifiers changed from: protected */
    public void zzg(boolean z) {
        boolean z2 = z;
        Iterator it = this.zzsl.iterator();
        while (it.hasNext()) {
            ((zzav) it.next()).zza(this, z2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[Catch:{ JSONException -> 0x0095, RuntimeException -> 0x008c, all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzh(boolean r13) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r7 = r0
            java.lang.Object r7 = r7.zzpV
            r2 = r7
            r7 = r2
            monitor-enter(r7)
            r7 = r0
            boolean r7 = r7.zzcl()     // Catch:{ all -> 0x005a }
            if (r7 == 0) goto L_0x0014
            r7 = r0
            boolean r7 = r7.zzsh     // Catch:{ all -> 0x005a }
            if (r7 != 0) goto L_0x0017
        L_0x0014:
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x005a }
        L_0x0016:
            return
        L_0x0017:
            r7 = r0
            com.google.android.gms.internal.zzbb r7 = r7.zzrY     // Catch:{ all -> 0x005a }
            android.view.View r7 = r7.zzco()     // Catch:{ all -> 0x005a }
            r4 = r7
            r7 = r4
            if (r7 == 0) goto L_0x0060
            com.google.android.gms.internal.zzir r7 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x005a }
            r8 = r4
            r9 = r0
            android.os.PowerManager r9 = r9.zzsc     // Catch:{ all -> 0x005a }
            r10 = r0
            android.app.KeyguardManager r10 = r10.zzsd     // Catch:{ all -> 0x005a }
            boolean r7 = r7.zza(r8, r9, r10)     // Catch:{ all -> 0x005a }
            if (r7 == 0) goto L_0x0060
            r7 = r4
            android.graphics.Rect r8 = new android.graphics.Rect     // Catch:{ all -> 0x005a }
            r11 = r8
            r8 = r11
            r9 = r11
            r9.<init>()     // Catch:{ all -> 0x005a }
            r9 = 0
            boolean r7 = r7.getGlobalVisibleRect(r8, r9)     // Catch:{ all -> 0x005a }
            if (r7 == 0) goto L_0x0060
            r7 = 1
            r5 = r7
        L_0x0045:
            r7 = r1
            if (r7 == 0) goto L_0x0063
            r7 = r0
            com.google.android.gms.internal.zziz r7 = r7.zzrQ     // Catch:{ all -> 0x005a }
            boolean r7 = r7.tryAcquire()     // Catch:{ all -> 0x005a }
            if (r7 != 0) goto L_0x0063
            r7 = r5
            r8 = r0
            boolean r8 = r8.zzsj     // Catch:{ all -> 0x005a }
            if (r7 != r8) goto L_0x0063
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x005a }
            goto L_0x0016
        L_0x005a:
            r7 = move-exception
            r3 = r7
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x005a }
            r7 = r3
            throw r7
        L_0x0060:
            r7 = 0
            r5 = r7
            goto L_0x0045
        L_0x0063:
            r7 = r0
            r8 = r5
            r7.zzsj = r8     // Catch:{ all -> 0x005a }
            r7 = r0
            com.google.android.gms.internal.zzbb r7 = r7.zzrY     // Catch:{ all -> 0x005a }
            boolean r7 = r7.zzcp()     // Catch:{ all -> 0x005a }
            if (r7 == 0) goto L_0x0077
            r7 = r0
            r7.zzcf()     // Catch:{ all -> 0x005a }
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x005a }
            goto L_0x0016
        L_0x0077:
            r7 = r0
            r8 = r0
            r9 = r4
            org.json.JSONObject r8 = r8.zzd(r9)     // Catch:{ JSONException -> 0x0095, RuntimeException -> 0x008c }
            r7.zza(r8)     // Catch:{ JSONException -> 0x0095, RuntimeException -> 0x008c }
        L_0x0081:
            r7 = r0
            r7.zzci()     // Catch:{ all -> 0x005a }
            r7 = r0
            r7.zzcg()     // Catch:{ all -> 0x005a }
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x005a }
            goto L_0x0016
        L_0x008c:
            r7 = move-exception
            r6 = r7
        L_0x008e:
            java.lang.String r7 = "Active view update failed."
            r8 = r6
            com.google.android.gms.internal.zzin.zza(r7, r8)     // Catch:{ all -> 0x005a }
            goto L_0x0081
        L_0x0095:
            r7 = move-exception
            r6 = r7
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzau.zzh(boolean):void");
    }
}
