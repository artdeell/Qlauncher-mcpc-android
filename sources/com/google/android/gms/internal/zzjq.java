package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzjq extends WebViewClient {
    private static final String[] zzNy;
    private static final String[] zzNz;
    private zzft zzDk;
    private zza zzGm;
    private final HashMap<String, List<zzdf>> zzNA;
    private zzg zzNB;
    /* access modifiers changed from: private */
    public zzb zzNC;
    private boolean zzND;
    private boolean zzNE;
    private zzp zzNF;
    private final zzfr zzNG;
    private boolean zzNH;
    private boolean zzNI;
    private boolean zzNJ;
    private int zzNK;
    protected zzjp zzpD;
    private final Object zzpV;
    private boolean zzsz;
    private com.google.android.gms.ads.internal.client.zza zztz;
    private zzdb zzyW;
    private zze zzzA;
    private zzfn zzzB;
    private zzdh zzzD;
    private zzdj zzzy;

    public interface zza {
        void zza(zzjp zzjp, boolean z);
    }

    public interface zzb {
        void zzbi();
    }

    private static class zzc implements zzg {
        private zzg zzNB;
        private zzjp zzNM;

        public zzc(zzjp zzjp, zzg zzg) {
            zzg zzg2 = zzg;
            this.zzNM = zzjp;
            this.zzNB = zzg2;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzaW() {
            this.zzNB.zzaW();
            this.zzNM.zzhN();
        }

        public void zzaX() {
            this.zzNB.zzaX();
            this.zzNM.zzfr();
        }
    }

    private class zzd implements zzdf {
        final /* synthetic */ zzjq zzNL;

        private zzd(zzjq zzjq) {
            this.zzNL = zzjq;
        }

        /* synthetic */ zzd(zzjq zzjq, C04291 r7) {
            C04291 r2 = r7;
            this(zzjq);
        }

        public void zza(zzjp zzjp, Map<String, String> map) {
            zzjp zzjp2 = zzjp;
            Map<String, String> map2 = map;
            if (map2.keySet().contains("start")) {
                this.zzNL.zzij();
            } else if (map2.keySet().contains("stop")) {
                this.zzNL.zzik();
            } else if (map2.keySet().contains("cancel")) {
                this.zzNL.zzil();
            }
        }
    }

    static {
        String[] strArr = new String[15];
        String[] strArr2 = strArr;
        strArr[0] = "UNKNOWN";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "HOST_LOOKUP";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "UNSUPPORTED_AUTH_SCHEME";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "AUTHENTICATION";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "PROXY_AUTHENTICATION";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = "CONNECT";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "IO";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[7] = "TIMEOUT";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[8] = "REDIRECT_LOOP";
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[9] = "UNSUPPORTED_SCHEME";
        String[] strArr21 = strArr20;
        String[] strArr22 = strArr21;
        strArr21[10] = "FAILED_SSL_HANDSHAKE";
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[11] = "BAD_URL";
        String[] strArr25 = strArr24;
        String[] strArr26 = strArr25;
        strArr25[12] = "FILE";
        String[] strArr27 = strArr26;
        String[] strArr28 = strArr27;
        strArr27[13] = "FILE_NOT_FOUND";
        String[] strArr29 = strArr28;
        String[] strArr30 = strArr29;
        strArr29[14] = "TOO_MANY_REQUESTS";
        zzNy = strArr30;
        String[] strArr31 = new String[6];
        String[] strArr32 = strArr31;
        strArr31[0] = "NOT_YET_VALID";
        String[] strArr33 = strArr32;
        String[] strArr34 = strArr33;
        strArr33[1] = "EXPIRED";
        String[] strArr35 = strArr34;
        String[] strArr36 = strArr35;
        strArr35[2] = "ID_MISMATCH";
        String[] strArr37 = strArr36;
        String[] strArr38 = strArr37;
        strArr37[3] = "UNTRUSTED";
        String[] strArr39 = strArr38;
        String[] strArr40 = strArr39;
        strArr39[4] = "DATE_INVALID";
        String[] strArr41 = strArr40;
        String[] strArr42 = strArr41;
        strArr41[5] = "INVALID";
        zzNz = strArr42;
    }

    public zzjq(zzjp zzjp, boolean z) {
        zzfr zzfr;
        zzbl zzbl;
        zzjp zzjp2 = zzjp;
        zzjp zzjp3 = zzjp2;
        boolean z2 = z;
        zzfr zzfr2 = zzfr;
        zzjp zzjp4 = zzjp2;
        Context zzhQ = zzjp2.zzhQ();
        zzbl zzbl2 = zzbl;
        zzbl zzbl3 = new zzbl(zzjp2.getContext());
        zzfr zzfr3 = new zzfr(zzjp4, zzhQ, zzbl2);
        this(zzjp3, z2, zzfr2, null);
    }

    zzjq(zzjp zzjp, boolean z, zzfr zzfr, zzfn zzfn) {
        HashMap<String, List<zzdf>> hashMap;
        Object obj;
        zzjp zzjp2 = zzjp;
        boolean z2 = z;
        zzfr zzfr2 = zzfr;
        zzfn zzfn2 = zzfn;
        HashMap<String, List<zzdf>> hashMap2 = hashMap;
        HashMap<String, List<zzdf>> hashMap3 = new HashMap<>();
        this.zzNA = hashMap2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzND = false;
        this.zzpD = zzjp2;
        this.zzsz = z2;
        this.zzNG = zzfr2;
        this.zzzB = zzfn2;
    }

    static /* synthetic */ zzb zza(zzjq zzjq, zzb zzb2) {
        zzb zzb3 = zzb2;
        zzjq.zzNC = zzb3;
        return zzb3;
    }

    private void zza(Context context, String str, String str2, String str3) {
        Bundle bundle;
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (((Boolean) zzbt.zzwO.get()).booleanValue()) {
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            bundle4.putString("err", str4);
            bundle4.putString("code", str5);
            bundle4.putString("host", zzaN(str6));
            zzr.zzbC().zza(context2, this.zzpD.zzhX().afmaVersion, "gmob-apps", bundle4, true);
        }
    }

    private String zzaN(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        Uri parse = Uri.parse(str2);
        return parse.getHost() != null ? parse.getHost() : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: private */
    public void zzij() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNE = true;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        this.zzNK = 1 + this.zzNK;
        zzim();
    }

    /* access modifiers changed from: private */
    public void zzik() {
        this.zzNK = -1 + this.zzNK;
        zzim();
    }

    /* access modifiers changed from: private */
    public void zzil() {
        this.zzNJ = true;
        zzim();
    }

    public final void onLoadResource(WebView webView, String str) {
        StringBuilder sb;
        WebView webView2 = webView;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.m20v(sb2.append("Loading resource: ").append(str2).toString());
        Uri parse = Uri.parse(str2);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        WebView webView2 = webView;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzNH) {
                    zzin.m20v("Blank page loaded, 1...");
                    this.zzpD.zzhZ();
                    return;
                }
                this.zzNI = true;
                zzim();
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        WebView webView2 = webView;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        zza(this.zzpD.getContext(), "http_err", (i2 >= 0 || -1 + (-i2) >= zzNy.length) ? String.valueOf(i2) : zzNy[-1 + (-i2)], str4);
        super.onReceivedError(webView2, i2, str3, str4);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebView webView2 = webView;
        SslErrorHandler sslErrorHandler2 = sslErrorHandler;
        SslError sslError2 = sslError;
        if (sslError2 != null) {
            int primaryError = sslError2.getPrimaryError();
            zza(this.zzpD.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzNz.length) ? String.valueOf(primaryError) : zzNz[primaryError], zzr.zzbE().zza(sslError2));
        }
        super.onReceivedSslError(webView2, sslErrorHandler2, sslError2);
    }

    public final void reset() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzNA.clear();
                this.zztz = null;
                this.zzNB = null;
                this.zzGm = null;
                this.zzyW = null;
                this.zzND = false;
                this.zzsz = false;
                this.zzNE = false;
                this.zzzD = null;
                this.zzNF = null;
                this.zzNC = null;
                if (this.zzzB != null) {
                    this.zzzB.zzp(true);
                    this.zzzB = null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebView webView2 = webView;
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        Uri uri;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel;
        WebView webView2 = webView;
        String str2 = str;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        zzin.m20v(sb4.append("AdWebView shouldOverrideUrlLoading: ").append(str2).toString());
        Uri parse = Uri.parse(str2);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else if (this.zzND && webView2 == this.zzpD.getWebView() && zzg(parse)) {
            if (this.zztz != null && ((Boolean) zzbt.zzww.get()).booleanValue()) {
                this.zztz.onAdClicked();
                this.zztz = null;
            }
            return super.shouldOverrideUrlLoading(webView2, str2);
        } else if (!this.zzpD.getWebView().willNotDraw()) {
            try {
                zzan zzhW = this.zzpD.zzhW();
                if (zzhW != null && zzhW.zzb(parse)) {
                    parse = zzhW.zza(parse, this.zzpD.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                zzao zzao = e;
                StringBuilder sb6 = sb3;
                StringBuilder sb7 = new StringBuilder();
                zzin.zzaK(sb6.append("Unable to append parameter to URL: ").append(str2).toString());
                uri = parse;
            }
            if (this.zzzA == null || this.zzzA.zzbh()) {
                AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
                AdLauncherIntentInfoParcel adLauncherIntentInfoParcel3 = new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null);
                zza(adLauncherIntentInfoParcel2);
            } else {
                this.zzzA.zzq(str2);
            }
        } else {
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            zzin.zzaK(sb8.append("AdWebView unable to handle URL: ").append(str2).toString());
        }
        return true;
    }

    public void zzG(boolean z) {
        boolean z2 = z;
        this.zzND = z2;
    }

    public void zza(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        this.zzNG.zzf(i3, i4);
        if (this.zzzB != null) {
            this.zzzB.zza(i3, i4, z2);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        boolean zzhY = this.zzpD.zzhY();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null;
        zzg zzg = null;
        if (!zzhY) {
            zzg = this.zzNB;
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(adLauncherIntentInfoParcel2, zza2, zzg, this.zzNF, this.zzpD.zzhX());
        zza(adOverlayInfoParcel2);
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        boolean z = this.zzzB != null ? this.zzzB.zzeN() : false;
        com.google.android.gms.ads.internal.overlay.zze zzbA = zzr.zzbA();
        Context context = this.zzpD.getContext();
        boolean z2 = false;
        if (!z) {
            z2 = true;
        }
        zzbA.zza(context, adOverlayInfoParcel2, z2);
    }

    public void zza(zza zza2) {
        zza zza3 = zza2;
        this.zzGm = zza3;
    }

    public void zza(zzb zzb2) {
        zzb zzb3 = zzb2;
        this.zzNC = zzb3;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r6v9, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(java.lang.String r11, com.google.android.gms.internal.zzdf r12) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r6 = r0
            java.lang.Object r6 = r6.zzpV
            r3 = r6
            r6 = r3
            monitor-enter(r6)
            r6 = r0
            java.util.HashMap<java.lang.String, java.util.List<com.google.android.gms.internal.zzdf>> r6 = r6.zzNA     // Catch:{ all -> 0x0032 }
            r7 = r1
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0032 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0032 }
            r5 = r6
            r6 = r5
            if (r6 != 0) goto L_0x0029
            java.util.concurrent.CopyOnWriteArrayList r6 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x0032 }
            r9 = r6
            r6 = r9
            r7 = r9
            r7.<init>()     // Catch:{ all -> 0x0032 }
            r5 = r6
            r6 = r0
            java.util.HashMap<java.lang.String, java.util.List<com.google.android.gms.internal.zzdf>> r6 = r6.zzNA     // Catch:{ all -> 0x0032 }
            r7 = r1
            r8 = r5
            java.lang.Object r6 = r6.put(r7, r8)     // Catch:{ all -> 0x0032 }
        L_0x0029:
            r6 = r5
            r7 = r2
            boolean r6 = r6.add(r7)     // Catch:{ all -> 0x0032 }
            r6 = r3
            monitor-exit(r6)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r6 = move-exception
            r4 = r6
            r6 = r3
            monitor-exit(r6)     // Catch:{ all -> 0x0032 }
            r6 = r4
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjq.zza(java.lang.String, com.google.android.gms.internal.zzdf):void");
    }

    public final void zza(boolean z, int i) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel((!this.zzpD.zzhY() || this.zzpD.zzaN().zzui) ? this.zztz : null, this.zzNB, this.zzNF, this.zzpD, z, i, this.zzpD.zzhX());
        zza(adOverlayInfoParcel2);
    }

    public final void zza(boolean z, int i, String str) {
        zzc zzc2;
        AdOverlayInfoParcel adOverlayInfoParcel;
        boolean z2 = z;
        int i2 = i;
        String str2 = str;
        boolean zzhY = this.zzpD.zzhY();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null;
        zzc zzc3 = null;
        if (!zzhY) {
            zzc zzc4 = zzc2;
            zzc zzc5 = new zzc(this.zzpD, this.zzNB);
            zzc3 = zzc4;
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(zza2, zzc3, this.zzyW, this.zzNF, this.zzpD, z2, i2, str2, this.zzpD.zzhX(), this.zzzD);
        zza(adOverlayInfoParcel2);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzc zzc2;
        zzc zzc3;
        AdOverlayInfoParcel adOverlayInfoParcel;
        boolean z2 = z;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        boolean zzhY = this.zzpD.zzhY();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null;
        if (zzhY) {
            zzc3 = null;
        } else {
            zzc zzc4 = zzc2;
            zzc zzc5 = new zzc(this.zzpD, this.zzNB);
            zzc3 = zzc4;
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(zza2, zzc3, this.zzyW, this.zzNF, this.zzpD, z2, i2, str3, str4, this.zzpD.zzhX(), this.zzzD);
        zza(adOverlayInfoParcel2);
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zza2, zzg zzg, zzdb zzdb, zzp zzp, boolean z, zzdh zzdh, zzdj zzdj, zze zze, zzft zzft) {
        zzfn zzfn;
        zzda zzda;
        zzd zzd2;
        zzdl zzdl;
        zzdm zzdm;
        zzdi zzdi;
        zze zze2;
        com.google.android.gms.ads.internal.client.zza zza3 = zza2;
        zzg zzg2 = zzg;
        zzdb zzdb2 = zzdb;
        zzp zzp2 = zzp;
        boolean z2 = z;
        zzdh zzdh2 = zzdh;
        zzdj zzdj2 = zzdj;
        zze zze3 = zze;
        zzft zzft2 = zzft;
        if (zze3 == null) {
            zze zze4 = zze2;
            zze zze5 = new zze(false);
            zze3 = zze4;
        }
        zzfn zzfn2 = zzfn;
        zzfn zzfn3 = new zzfn(this.zzpD, zzft2);
        this.zzzB = zzfn2;
        zzda zzda2 = zzda;
        zzda zzda3 = new zzda(zzdb2);
        zza("/appEvent", (zzdf) zzda2);
        zza("/backButton", zzde.zzzh);
        zza("/canOpenURLs", zzde.zzyY);
        zza("/canOpenIntents", zzde.zzyZ);
        zza("/click", zzde.zzza);
        zza("/close", zzde.zzzb);
        zza("/customClose", zzde.zzzd);
        zza("/instrument", zzde.zzzk);
        zzd zzd3 = zzd2;
        zzd zzd4 = new zzd(this, null);
        zza("/delayPageLoaded", (zzdf) zzd3);
        zza("/httpTrack", zzde.zzze);
        zza("/log", zzde.zzzf);
        zzdl zzdl2 = zzdl;
        zzdl zzdl3 = new zzdl(zze3, this.zzzB);
        zza("/mraid", (zzdf) zzdl2);
        zza("/mraidLoaded", (zzdf) this.zzNG);
        zzdm zzdm2 = zzdm;
        zzdm zzdm3 = new zzdm(zzdh2, zze3, this.zzzB);
        zza("/open", (zzdf) zzdm2);
        zza("/precache", zzde.zzzj);
        zza("/touch", zzde.zzzg);
        zza("/video", zzde.zzzi);
        zza("/appStreaming", zzde.zzzc);
        if (zzdj2 != null) {
            zzdi zzdi2 = zzdi;
            zzdi zzdi3 = new zzdi(zzdj2);
            zza("/setInterstitialProperties", (zzdf) zzdi2);
        }
        this.zztz = zza3;
        this.zzNB = zzg2;
        this.zzyW = zzdb2;
        this.zzzD = zzdh2;
        this.zzNF = zzp2;
        this.zzzA = zze3;
        this.zzDk = zzft2;
        this.zzzy = zzdj2;
        zzG(z2);
    }

    /* JADX INFO: finally extract failed */
    public void zzb(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                List list = (List) this.zzNA.get(str2);
                if (list != null) {
                    boolean remove = list.remove(zzdf2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzcv() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzsz;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zze(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.zzzB != null) {
            this.zzzB.zze(i3, i4);
        }
    }

    public final void zzfo() {
        C04291 r6;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzND = false;
                this.zzsz = true;
                C04291 r3 = r6;
                C04291 r4 = new Runnable(this) {
                    final /* synthetic */ zzjq zzNL;

                    {
                        this.zzNL = r5;
                    }

                    public void run() {
                        this.zzNL.zzpD.zzid();
                        com.google.android.gms.ads.internal.overlay.zzd zzhS = this.zzNL.zzpD.zzhS();
                        if (zzhS != null) {
                            zzhS.zzfo();
                        }
                        if (this.zzNL.zzNC != null) {
                            this.zzNL.zzNC.zzbi();
                            zzb zza = zzjq.zza(this.zzNL, (zzb) null);
                        }
                    }
                };
                zzir.runOnUiThread(r3);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzh(Uri uri) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        Uri uri2 = uri;
        String path = uri2.getPath();
        List<zzdf> list = (List) this.zzNA.get(path);
        if (list != null) {
            Map zze = zzr.zzbC().zze(uri2);
            if (zzin.zzQ(2)) {
                StringBuilder sb4 = sb2;
                StringBuilder sb5 = new StringBuilder();
                zzin.m20v(sb4.append("Received GMSG: ").append(path).toString());
                for (String str : zze.keySet()) {
                    StringBuilder sb6 = sb3;
                    StringBuilder sb7 = new StringBuilder();
                    zzin.m20v(sb6.append("  ").append(str).append(": ").append((String) zze.get(str)).toString());
                }
            }
            for (zzdf zza2 : list) {
                zza2.zza(this.zzpD, zze);
            }
            return;
        }
        StringBuilder sb8 = sb;
        StringBuilder sb9 = new StringBuilder();
        zzin.m20v(sb8.append("No GMSG handler found for GMSG: ").append(uri2).toString());
    }

    public void zzh(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        this.zzpD = zzjp2;
    }

    public zze zzig() {
        return this.zzzA;
    }

    public boolean zzih() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNE;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzii() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzin.m20v("Loading blank page in WebView, 2...");
                this.zzNH = true;
                this.zzpD.zzaL("about:blank");
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public final void zzim() {
        if (this.zzGm != null && ((this.zzNI && this.zzNK <= 0) || this.zzNJ)) {
            this.zzGm.zza(this.zzpD, !this.zzNJ);
            this.zzGm = null;
        }
        this.zzpD.zzie();
    }
}
