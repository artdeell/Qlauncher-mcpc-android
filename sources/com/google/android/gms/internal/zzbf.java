package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@zzhb
public class zzbf extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzpV;
    private final int zzsK;
    private final int zzsM;
    private boolean zzsY = false;
    private final zzbe zzsZ;
    private final zzbd zzta;
    private final zzha zztb;
    private final int zztc;
    private final int zztd;
    private final int zzte;

    @zzhb
    class zza {
        final /* synthetic */ zzbf zztg;
        final int zztm;
        final int zztn;

        zza(zzbf zzbf, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.zztg = zzbf;
            this.zztm = i3;
            this.zztn = i4;
        }
    }

    public zzbf(zzbe zzbe, zzbd zzbd, zzha zzha) {
        Object obj;
        zzbe zzbe2 = zzbe;
        zzbd zzbd2 = zzbd;
        zzha zzha2 = zzha;
        this.zzsZ = zzbe2;
        this.zzta = zzbd2;
        this.zztb = zzha2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzsK = ((Integer) zzbt.zzwk.get()).intValue();
        this.zztd = ((Integer) zzbt.zzwl.get()).intValue();
        this.zzsM = ((Integer) zzbt.zzwm.get()).intValue();
        this.zzte = ((Integer) zzbt.zzwn.get()).intValue();
        this.zztc = ((Integer) zzbt.zzwo.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcH()) {
                    Activity activity = this.zzsZ.getActivity();
                    if (activity == null) {
                        zzin.zzaI("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzin.zzaI("ContentFetchTask: sleeping");
                    zzcJ();
                }
                Thread.sleep((long) (1000 * this.zztc));
            } catch (Throwable th) {
                Throwable th2 = th;
                zzin.zzb("Error in ContentFetchTask", th2);
                this.zztb.zza(th2, true);
            }
            boolean z = this.zzpV;
            synchronized (z) {
                while (true) {
                    try {
                        th = this.zzsY;
                        if (!th) {
                            break;
                        }
                        try {
                            zzin.zzaI("ContentFetchTask: waiting");
                            this.zzpV.wait();
                        } catch (InterruptedException e) {
                            InterruptedException interruptedException = e;
                        }
                    } finally {
                        Throwable th3 = th;
                        boolean z2 = z;
                        Throwable th4 = th3;
                    }
                }
            }
        }
    }

    public void wakeup() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsY = false;
                this.zzpV.notifyAll();
                zzin.zzaI("ContentFetchThread: wakeup");
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public zza zza(View view, zzbc zzbc) {
        Rect rect;
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        zza zza6;
        zza zza7;
        zza zza8;
        View view2 = view;
        zzbc zzbc2 = zzbc;
        if (view2 == null) {
            zza zza9 = zza8;
            zza zza10 = new zza(this, 0, 0);
            return zza9;
        }
        View view3 = view2;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view3.getGlobalVisibleRect(rect2);
        if ((view2 instanceof TextView) && !(view2 instanceof EditText)) {
            CharSequence text = ((TextView) view2).getText();
            if (!TextUtils.isEmpty(text)) {
                zzbc2.zzd(text.toString(), globalVisibleRect);
                zza zza11 = zza7;
                zza zza12 = new zza(this, 1, 0);
                return zza11;
            }
            zza zza13 = zza6;
            zza zza14 = new zza(this, 0, 0);
            return zza13;
        } else if ((view2 instanceof WebView) && !(view2 instanceof zzjp)) {
            zzbc2.zzcC();
            if (zza((WebView) view2, zzbc2, globalVisibleRect)) {
                zza zza15 = zza5;
                zza zza16 = new zza(this, 0, 1);
                return zza15;
            }
            zza zza17 = zza4;
            zza zza18 = new zza(this, 0, 0);
            return zza17;
        } else if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zza zza19 = zza(viewGroup.getChildAt(i3), zzbc2);
                i2 += zza19.zztm;
                i += zza19.zztn;
            }
            zza zza20 = zza3;
            zza zza21 = new zza(this, i2, i);
            return zza20;
        } else {
            zza zza22 = zza2;
            zza zza23 = new zza(this, 0, 0);
            return zza22;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(Activity activity) {
        Activity activity2 = activity;
        if (activity2 != null) {
            View view = null;
            if (activity2.getWindow() != null) {
                view = null;
                if (activity2.getWindow().getDecorView() != null) {
                    view = activity2.getWindow().getDecorView().findViewById(16908290);
                }
            }
            if (view != null) {
                boolean zze = zze(view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzbc zzbc, WebView webView, String str, boolean z) {
        JSONObject jSONObject;
        StringBuilder sb;
        zzbc zzbc2 = zzbc;
        WebView webView2 = webView;
        String str2 = str;
        boolean z2 = z;
        zzbc2.zzcB();
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject(str2);
                String optString = jSONObject2.optString("text");
                if (!TextUtils.isEmpty(webView2.getTitle())) {
                    zzbc zzbc3 = zzbc2;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzbc3.zzc(sb2.append(webView2.getTitle()).append("\n").append(optString).toString(), z2);
                } else {
                    zzbc2.zzc(optString, z2);
                }
            }
            if (zzbc2.zzcx()) {
                boolean zzb = this.zzta.zzb(zzbc2);
            }
        } catch (JSONException e) {
            JSONException jSONException = e;
            zzin.zzaI("Json string may be malformed.");
        } catch (Throwable th) {
            Throwable th2 = th;
            zzin.zza("Failed to get webview content.", th2);
            this.zztb.zza(th2, true);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(19)
    public boolean zza(WebView webView, zzbc zzbc, boolean z) {
        C02702 r11;
        WebView webView2 = webView;
        zzbc zzbc2 = zzbc;
        boolean z2 = z;
        if (!zzne.zzsk()) {
            return false;
        }
        zzbc2.zzcC();
        WebView webView3 = webView2;
        C02702 r5 = r11;
        final zzbc zzbc3 = zzbc2;
        final WebView webView4 = webView2;
        final boolean z3 = z2;
        C02702 r6 = new Runnable(this) {
            final /* synthetic */ zzbf zztg;
            ValueCallback<String> zzth;

            {
                C02711 r9;
                zzbc zzbc = r12;
                WebView webView = r13;
                boolean z = r14;
                this.zztg = r11;
                C02711 r6 = r9;
                C02711 r7 = new ValueCallback<String>(this) {
                    final /* synthetic */ C02702 zztl;

                    {
                        this.zztl = r5;
                    }

                    /* renamed from: zzt */
                    public void onReceiveValue(String str) {
                        this.zztl.zztg.zza(zzbc3, webView4, str, z3);
                    }
                };
                this.zzth = r6;
            }

            public void run() {
                if (webView4.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView4.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzth);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        this.zzth.onReceiveValue(LibrariesRepository.MOJANG_MAVEN_REPO);
                    }
                }
            }
        };
        boolean post = webView3.post(r5);
        return true;
    }

    public void zzcG() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.mStarted) {
                    zzin.zzaI("Content hash thread already started, quiting...");
                    return;
                }
                this.mStarted = true;
                start();
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzcH() {
        try {
            Context context = this.zzsZ.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzs(context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            return false;
        }
    }

    public zzbc zzcI() {
        return this.zzta.zzcF();
    }

    public void zzcJ() {
        StringBuilder sb;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsY = true;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaI(sb2.append("ContentFetchThread: paused, mPause = ").append(this.zzsY).toString());
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzcK() {
        return this.zzsY;
    }

    /* access modifiers changed from: 0000 */
    public boolean zze(View view) {
        C02691 r7;
        View view2 = view;
        if (view2 == null) {
            return false;
        }
        View view3 = view2;
        C02691 r3 = r7;
        final View view4 = view2;
        C02691 r4 = new Runnable(this) {
            final /* synthetic */ zzbf zztg;

            {
                View view = r7;
                this.zztg = r6;
            }

            public void run() {
                this.zztg.zzf(view4);
            }
        };
        boolean post = view3.post(r3);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void zzf(View view) {
        zzbc zzbc;
        View view2 = view;
        try {
            zzbc zzbc2 = zzbc;
            zzbc zzbc3 = new zzbc(this.zzsK, this.zztd, this.zzsM, this.zzte);
            zzbc zzbc4 = zzbc2;
            zza zza2 = zza(view2, zzbc4);
            zzbc4.zzcD();
            if (zza2.zztm != 0 || zza2.zztn != 0) {
                if (zza2.zztn != 0 || zzbc4.zzcE() != 0) {
                    if (zza2.zztn != 0 || !this.zzta.zza(zzbc4)) {
                        this.zzta.zzc(zzbc4);
                    }
                }
            }
        } catch (Exception e) {
            Exception exc = e;
            zzin.zzb("Exception in fetchContentOnUIThread", exc);
            this.zztb.zza(exc, true);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
