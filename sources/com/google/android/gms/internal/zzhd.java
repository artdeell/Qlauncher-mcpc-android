package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzeg.zzb;
import com.google.android.gms.internal.zzeg.zzc;
import com.google.android.gms.internal.zzeg.zzd;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import org.lwjgl.util.glu.GLU;

@zzhb
public final class zzhd extends zza {
    private static zzhd zzIQ;
    private static final Object zzqy;
    private final Context mContext;
    private final zzhc zzIR;
    private final zzbm zzIS;
    private final zzeg zzIT;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    zzhd(Context context, zzbm zzbm, zzhc zzhc) {
        zzeg zzeg;
        VersionInfoParcel versionInfoParcel;
        C03936 r14;
        zzc zzc;
        Context context2 = context;
        zzbm zzbm2 = zzbm;
        zzhc zzhc2 = zzhc;
        this.mContext = context2;
        this.zzIR = zzhc2;
        this.zzIS = zzbm2;
        zzeg zzeg2 = zzeg;
        Context applicationContext = context2.getApplicationContext() != null ? context2.getApplicationContext() : context2;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        VersionInfoParcel versionInfoParcel3 = new VersionInfoParcel(8487000, 8487000, true);
        String zzdp = zzbm2.zzdp();
        C03936 r11 = r14;
        C03936 r12 = new zzb<zzed>(this) {
            final /* synthetic */ zzhd zzJe;

            {
                this.zzJe = r5;
            }

            /* renamed from: zza */
            public void zze(zzed zzed) {
                zzed.zza("/log", zzde.zzzf);
            }
        };
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        zzeg zzeg3 = new zzeg(applicationContext, versionInfoParcel2, zzdp, r11, zzc2);
        this.zzIT = zzeg2;
    }

    private static AdResponseParcel zza(Context context, zzeg zzeg, zzbm zzbm, zzhc zzhc, AdRequestInfoParcel adRequestInfoParcel) {
        zzcb zzcb;
        Bundle bundle;
        Future future;
        zzhf zzhf;
        C03903 r63;
        C03914 r632;
        AdResponseParcel adResponseParcel;
        C03914 r633;
        C03914 r634;
        AdResponseParcel adResponseParcel2;
        C03914 r635;
        AdResponseParcel adResponseParcel3;
        C03914 r636;
        C03872 r637;
        AdResponseParcel adResponseParcel4;
        Throwable th;
        AdResponseParcel adResponseParcel5;
        C03861 r638;
        Bundle bundle2;
        Context context2 = context;
        zzeg zzeg2 = zzeg;
        zzbm zzbm2 = zzbm;
        zzhc zzhc2 = zzhc;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        zzin.zzaI("Starting ad request from service.");
        zzbt.initialize(context2);
        zzcb zzcb2 = zzcb;
        zzcb zzcb3 = new zzcb(((Boolean) zzbt.zzwg.get()).booleanValue(), "load_ad", adRequestInfoParcel2.zzrp.zzuh);
        zzcb zzcb4 = zzcb2;
        if (adRequestInfoParcel2.versionCode > 10 && adRequestInfoParcel2.zzHL != -1) {
            zzcb zzcb5 = zzcb4;
            zzbz zzb = zzcb4.zzb(adRequestInfoParcel2.zzHL);
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "cts";
            boolean zza = zzcb5.zza(zzb, strArr2);
        }
        zzbz zzdB = zzcb4.zzdB();
        Bundle bundle3 = (adRequestInfoParcel2.versionCode < 4 || adRequestInfoParcel2.zzHA == null) ? null : adRequestInfoParcel2.zzHA;
        if (!((Boolean) zzbt.zzwp.get()).booleanValue() || zzhc2.zzIP == null) {
            bundle = bundle3;
            future = null;
        } else {
            if (bundle3 == null && ((Boolean) zzbt.zzwq.get()).booleanValue()) {
                zzin.m20v("contentInfo is not present, but we'll still launch the app index task");
                Bundle bundle4 = bundle2;
                Bundle bundle5 = new Bundle();
                bundle3 = bundle4;
            }
            if (bundle3 != null) {
                C03861 r53 = r638;
                final zzhc zzhc3 = zzhc2;
                final Context context3 = context2;
                final AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel2;
                final Bundle bundle6 = bundle3;
                C03861 r54 = new Callable<Void>() {
                    {
                        Context context = r9;
                        AdRequestInfoParcel adRequestInfoParcel = r10;
                        Bundle bundle = r11;
                    }

                    /* renamed from: zzdt */
                    public Void call() throws Exception {
                        zzhc3.zzIP.zza(context3, adRequestInfoParcel3.zzHu.packageName, bundle6);
                        return null;
                    }
                };
                bundle = bundle3;
                future = zziq.zza((Callable<T>) r53);
            } else {
                bundle = bundle3;
                future = null;
            }
        }
        zzhc2.zzIK.zzex();
        zzhj zzE = zzr.zzbI().zzE(context2);
        if (zzE.zzKc == -1) {
            zzin.zzaI("Device is offline.");
            AdResponseParcel adResponseParcel6 = adResponseParcel5;
            AdResponseParcel adResponseParcel7 = new AdResponseParcel(2);
            return adResponseParcel6;
        }
        String uuid = adRequestInfoParcel2.versionCode >= 7 ? adRequestInfoParcel2.zzHI : UUID.randomUUID().toString();
        zzhf zzhf2 = zzhf;
        zzhf zzhf3 = new zzhf(uuid, adRequestInfoParcel2.applicationInfo.packageName);
        zzhf zzhf4 = zzhf2;
        if (adRequestInfoParcel2.zzHt.extras != null) {
            String string = adRequestInfoParcel2.zzHt.extras.getString("_ad");
            if (string != null) {
                return zzhe.zza(context2, adRequestInfoParcel2, string);
            }
        }
        Location zzd = zzhc2.zzIK.zzd(250);
        String token = zzhc2.zzIL.getToken(context2, adRequestInfoParcel2.zzrj, adRequestInfoParcel2.zzHu.packageName);
        List zza2 = zzhc2.zzII.zza(adRequestInfoParcel2);
        String zzf = zzhc2.zzIM.zzf(adRequestInfoParcel2);
        zzhn.zza zzF = zzhc2.zzIN.zzF(context2);
        if (future != null) {
            try {
                zzin.m20v("Waiting for app index fetching task.");
                Object obj = future.get(((Long) zzbt.zzwr.get()).longValue(), TimeUnit.MILLISECONDS);
                zzin.m20v("App index fetching task completed.");
            } catch (ExecutionException e) {
                th = e;
                zzin.zzd("Failed to fetch app index signal", th);
            } catch (InterruptedException e2) {
                th = e2;
                zzin.zzd("Failed to fetch app index signal", th);
            } catch (TimeoutException e3) {
                TimeoutException timeoutException = e3;
                zzin.zzaI("Timed out waiting for app index fetching task");
            }
        }
        JSONObject zza3 = zzhe.zza(context2, adRequestInfoParcel2, zzE, zzF, zzd, zzbm2, token, zzf, zza2, bundle);
        if (adRequestInfoParcel2.versionCode < 7) {
            try {
                JSONObject put = zza3.put("request_id", uuid);
            } catch (JSONException e4) {
                JSONException jSONException = e4;
            }
        }
        if (zza3 == null) {
            AdResponseParcel adResponseParcel8 = adResponseParcel4;
            AdResponseParcel adResponseParcel9 = new AdResponseParcel(0);
            return adResponseParcel8;
        }
        String jSONObject = zza3.toString();
        zzcb zzcb6 = zzcb4;
        zzbz zzbz = zzdB;
        String[] strArr3 = new String[1];
        String[] strArr4 = strArr3;
        strArr3[0] = "arc";
        boolean zza4 = zzcb6.zza(zzbz, strArr4);
        zzbz zzdB2 = zzcb4.zzdB();
        if (((Boolean) zzbt.zzvC.get()).booleanValue()) {
            Handler handler = zzir.zzMc;
            C03872 r542 = r637;
            final zzeg zzeg3 = zzeg2;
            final zzhf zzhf5 = zzhf4;
            final zzcb zzcb7 = zzcb4;
            final zzbz zzbz2 = zzdB2;
            final String str = jSONObject;
            C03872 r55 = new Runnable() {
                {
                    zzhf zzhf = r10;
                    zzcb zzcb = r11;
                    zzbz zzbz = r12;
                    String str = r13;
                }

                public void run() {
                    C03881 r8;
                    C03892 r82;
                    zzd zzer = zzeg3.zzer();
                    zzhf5.zzb(zzer);
                    zzcb zzcb = zzcb7;
                    zzbz zzbz = zzbz2;
                    String[] strArr = new String[1];
                    String[] strArr2 = strArr;
                    strArr[0] = "rwc";
                    boolean zza = zzcb.zza(zzbz, strArr2);
                    zzd zzd = zzer;
                    C03881 r3 = r8;
                    final zzbz zzdB = zzcb7.zzdB();
                    C03881 r4 = new zzji.zzc<zzeh>(this) {
                        final /* synthetic */ C03872 zzJc;

                        {
                            zzbz zzbz = r7;
                            this.zzJc = r6;
                        }

                        /* renamed from: zzd */
                        public void zze(zzeh zzeh) {
                            zzeh zzeh2 = zzeh;
                            zzcb zzcb = zzcb7;
                            zzbz zzbz = zzdB;
                            String[] strArr = new String[1];
                            String[] strArr2 = strArr;
                            strArr[0] = "jsf";
                            boolean zza = zzcb.zza(zzbz, strArr2);
                            zzcb7.zzdC();
                            zzeh2.zza("/invalidRequest", zzhf5.zzJk);
                            zzeh2.zza("/loadAdURL", zzhf5.zzJl);
                            try {
                                zzeh2.zze("AFMA_buildAdURL", str);
                            } catch (Exception e) {
                                zzin.zzb("Error requesting an ad url", e);
                            }
                        }
                    };
                    C03892 r42 = r82;
                    C03892 r5 = new zzji.zza(this) {
                        final /* synthetic */ C03872 zzJc;

                        {
                            this.zzJc = r5;
                        }

                        public void run() {
                        }
                    };
                    zzd.zza(r3, r42);
                }
            };
            boolean post = handler.post(r542);
        } else {
            Handler handler2 = zzir.zzMc;
            C03903 r543 = r63;
            final Context context4 = context2;
            final AdRequestInfoParcel adRequestInfoParcel4 = adRequestInfoParcel2;
            final zzhf zzhf6 = zzhf4;
            final zzcb zzcb8 = zzcb4;
            final zzbz zzbz3 = zzdB2;
            final String str2 = jSONObject;
            final zzbm zzbm3 = zzbm2;
            C03903 r552 = new Runnable() {
                {
                    AdRequestInfoParcel adRequestInfoParcel = r12;
                    zzhf zzhf = r13;
                    zzcb zzcb = r14;
                    zzbz zzbz = r15;
                    String str = r16;
                    zzbm zzbm = r17;
                }

                public void run() {
                    AdSizeParcel adSizeParcel;
                    zzjr zzbD = zzr.zzbD();
                    Context context = context4;
                    AdSizeParcel adSizeParcel2 = adSizeParcel;
                    AdSizeParcel adSizeParcel3 = new AdSizeParcel();
                    zzjp zza = zzbD.zza(context, adSizeParcel2, false, false, null, adRequestInfoParcel4.zzrl);
                    if (zzr.zzbF().zzhi()) {
                        zza.clearCache(true);
                    }
                    zza.getWebView().setWillNotDraw(true);
                    zzhf6.zzh(zza);
                    zzcb zzcb = zzcb8;
                    zzbz zzbz = zzbz3;
                    String[] strArr = new String[1];
                    String[] strArr2 = strArr;
                    strArr[0] = "rwc";
                    boolean zza2 = zzcb.zza(zzbz, strArr2);
                    zzjq.zza zzb = zzhd.zza(str2, zzcb8, zzcb8.zzdB());
                    zzjq zzhU = zza.zzhU();
                    zzhU.zza("/invalidRequest", zzhf6.zzJk);
                    zzhU.zza("/loadAdURL", zzhf6.zzJl);
                    zzhU.zza("/log", zzde.zzzf);
                    zzhU.zza(zzb);
                    zzin.zzaI("Loading the JS library.");
                    zza.loadUrl(zzbm3.zzdp());
                }
            };
            boolean post2 = handler2.post(r543);
        }
        try {
            zzhi zzhi = (zzhi) zzhf4.zzgC().get(10, TimeUnit.SECONDS);
            if (zzhi == null) {
                AdResponseParcel adResponseParcel10 = adResponseParcel3;
                AdResponseParcel adResponseParcel11 = new AdResponseParcel(0);
                AdResponseParcel adResponseParcel12 = adResponseParcel10;
                Handler handler3 = zzir.zzMc;
                C03914 r544 = r636;
                final zzhc zzhc4 = zzhc2;
                final Context context5 = context2;
                final zzhf zzhf7 = zzhf4;
                final AdRequestInfoParcel adRequestInfoParcel5 = adRequestInfoParcel2;
                C03914 r553 = new Runnable() {
                    {
                        Context context = r9;
                        zzhf zzhf = r10;
                        AdRequestInfoParcel adRequestInfoParcel = r11;
                    }

                    public void run() {
                        r56.zzIJ.zza(r57, r58, r59.zzrl);
                    }
                };
                boolean post3 = handler3.post(r544);
                return adResponseParcel12;
            } else if (zzhi.getErrorCode() != -2) {
                AdResponseParcel adResponseParcel13 = adResponseParcel2;
                AdResponseParcel adResponseParcel14 = new AdResponseParcel(zzhi.getErrorCode());
                AdResponseParcel adResponseParcel15 = adResponseParcel13;
                Handler handler4 = zzir.zzMc;
                C03914 r545 = r635;
                final zzhc zzhc5 = zzhc2;
                final Context context6 = context2;
                final zzhf zzhf8 = zzhf4;
                final AdRequestInfoParcel adRequestInfoParcel6 = adRequestInfoParcel2;
                C03914 r554 = new Runnable() {
                    {
                        Context context = r9;
                        zzhf zzhf = r10;
                        AdRequestInfoParcel adRequestInfoParcel = r11;
                    }

                    public void run() {
                        r56.zzIJ.zza(r57, r58, r59.zzrl);
                    }
                };
                boolean post4 = handler4.post(r545);
                return adResponseParcel15;
            } else {
                if (zzcb4.zzdE() != null) {
                    zzcb zzcb9 = zzcb4;
                    zzbz zzdE = zzcb4.zzdE();
                    String[] strArr5 = new String[1];
                    String[] strArr6 = strArr5;
                    strArr5[0] = "rur";
                    boolean zza5 = zzcb9.zza(zzdE, strArr6);
                }
                String str3 = null;
                if (zzhi.zzgG()) {
                    str3 = zzhc2.zzIH.zzaz(adRequestInfoParcel2.zzHu.packageName);
                }
                AdResponseParcel zza6 = zza(adRequestInfoParcel2, context2, adRequestInfoParcel2.zzrl.afmaVersion, zzhi.getUrl(), str3, zzhi.zzgH() ? token : null, zzhi, zzcb4, zzhc2);
                if (zza6.zzIf == 1) {
                    zzhc2.zzIL.clearToken(context2, adRequestInfoParcel2.zzHu.packageName);
                }
                zzcb zzcb10 = zzcb4;
                zzbz zzbz4 = zzdB;
                String[] strArr7 = new String[1];
                String[] strArr8 = strArr7;
                strArr7[0] = "tts";
                boolean zza7 = zzcb10.zza(zzbz4, strArr8);
                zza6.zzIh = zzcb4.zzdD();
                Handler handler5 = zzir.zzMc;
                C03914 r546 = r634;
                final zzhc zzhc6 = zzhc2;
                final Context context7 = context2;
                final zzhf zzhf9 = zzhf4;
                final AdRequestInfoParcel adRequestInfoParcel7 = adRequestInfoParcel2;
                C03914 r555 = new Runnable() {
                    {
                        Context context = r9;
                        zzhf zzhf = r10;
                        AdRequestInfoParcel adRequestInfoParcel = r11;
                    }

                    public void run() {
                        r56.zzIJ.zza(r57, r58, r59.zzrl);
                    }
                };
                boolean post5 = handler5.post(r546);
                return zza6;
            }
        } catch (Exception e5) {
            Exception exc = e5;
            AdResponseParcel adResponseParcel16 = adResponseParcel;
            AdResponseParcel adResponseParcel17 = new AdResponseParcel(0);
            AdResponseParcel adResponseParcel18 = adResponseParcel16;
            Handler handler6 = zzir.zzMc;
            C03914 r547 = r633;
            final zzhc zzhc7 = zzhc2;
            final Context context8 = context2;
            final zzhf zzhf10 = zzhf4;
            final AdRequestInfoParcel adRequestInfoParcel8 = adRequestInfoParcel2;
            C03914 r556 = new Runnable() {
                {
                    Context context = r9;
                    zzhf zzhf = r10;
                    AdRequestInfoParcel adRequestInfoParcel = r11;
                }

                public void run() {
                    r56.zzIJ.zza(r57, r58, r59.zzrl);
                }
            };
            boolean post6 = handler6.post(r547);
            return adResponseParcel18;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            Handler handler7 = zzir.zzMc;
            C03914 r548 = r632;
            final zzhc zzhc8 = zzhc2;
            final Context context9 = context2;
            final zzhf zzhf11 = zzhf4;
            final AdRequestInfoParcel adRequestInfoParcel9 = adRequestInfoParcel2;
            C03914 r557 = new Runnable() {
                {
                    Context context = r9;
                    zzhf zzhf = r10;
                    AdRequestInfoParcel adRequestInfoParcel = r11;
                }

                public void run() {
                    zzhc8.zzIJ.zza(context9, zzhf11, adRequestInfoParcel9.zzrl);
                }
            };
            boolean post7 = handler7.post(r548);
            throw th3;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: used method not loaded: com.google.android.gms.internal.zzhg.zzj(long):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        r38 = r44;
        r39 = new java.lang.StringBuilder();
        com.google.android.gms.internal.zzin.zzaK(r38.append("Received error HTTP response code: ").append(r21).toString());
        r38 = r44;
        r39 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0316, code lost:
        r23 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r19.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x031f, code lost:
        if (r10 == null) goto L_0x032c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0321, code lost:
        r10.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0357, code lost:
        r38 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0358, code lost:
        r31 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        return r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        return r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        return r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0146, code lost:
        r29 = r18.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r38 = r44;
        r39 = new java.io.InputStreamReader(r19.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015a, code lost:
        r30 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0165, code lost:
        r32 = com.google.android.gms.ads.internal.zzr.zzbC().zza(r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        com.google.android.gms.internal.zzna.zzb(r30);
        zza(r29, r22, r32, r21);
        r12.zzb(r29, r22, r32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0185, code lost:
        if (r9 == null) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0187, code lost:
        r38 = r9;
        r39 = r11;
        r44 = new java.lang.String[1];
        r40 = r44;
        r44[0] = "ufe";
        r38 = r38.zza(r39, r40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01aa, code lost:
        r34 = r12.zzj(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r19.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01b4, code lost:
        if (r10 == null) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01b6, code lost:
        r10.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x022a, code lost:
        r38 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x022b, code lost:
        r31 = r38;
        r30 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.google.android.gms.internal.zzna.zzb(r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0238, code lost:
        throw r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x026e, code lost:
        com.google.android.gms.internal.zzin.zzaK("No location header to follow redirect.");
        r38 = r44;
        r39 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0280, code lost:
        r28 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r19.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0289, code lost:
        if (r10 == null) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x028b, code lost:
        r10.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02bd, code lost:
        com.google.android.gms.internal.zzin.zzaK("Too many redirects.");
        r38 = r44;
        r39 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02cf, code lost:
        r27 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r19.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02d8, code lost:
        if (r10 == null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02da, code lost:
        r10.zzIO.zzgK();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r45, android.content.Context r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, com.google.android.gms.internal.zzhi r51, com.google.android.gms.internal.zzcb r52, com.google.android.gms.internal.zzhc r53) {
        /*
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r8 = r51
            r9 = r52
            r10 = r53
            r38 = r9
            if (r38 == 0) goto L_0x01c6
            r38 = r9
            com.google.android.gms.internal.zzbz r38 = r38.zzdB()
            r11 = r38
        L_0x001e:
            com.google.android.gms.internal.zzhg r38 = new com.google.android.gms.internal.zzhg     // Catch:{ IOException -> 0x01f5 }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = r2
            r39.<init>(r40)     // Catch:{ IOException -> 0x01f5 }
            r12 = r38
            java.lang.StringBuilder r38 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01f5 }
            r44 = r38
            r38 = r44
            r39 = r44
            r39.<init>()     // Catch:{ IOException -> 0x01f5 }
            java.lang.String r39 = "AdRequestServiceImpl: Sending request: "
            java.lang.StringBuilder r38 = r38.append(r39)     // Catch:{ IOException -> 0x01f5 }
            r39 = r5
            java.lang.StringBuilder r38 = r38.append(r39)     // Catch:{ IOException -> 0x01f5 }
            java.lang.String r38 = r38.toString()     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.zzin.zzaI(r38)     // Catch:{ IOException -> 0x01f5 }
            java.net.URL r38 = new java.net.URL     // Catch:{ IOException -> 0x01f5 }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = r5
            r39.<init>(r40)     // Catch:{ IOException -> 0x01f5 }
            r14 = r38
            com.google.android.gms.internal.zzmq r38 = com.google.android.gms.ads.internal.zzr.zzbG()     // Catch:{ IOException -> 0x01f5 }
            long r38 = r38.elapsedRealtime()     // Catch:{ IOException -> 0x01f5 }
            r15 = r38
            r38 = 0
            r17 = r38
            r38 = r14
            r18 = r38
        L_0x006c:
            r38 = r10
            if (r38 == 0) goto L_0x007b
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgJ()     // Catch:{ IOException -> 0x01f5 }
        L_0x007b:
            r38 = r18
            java.net.URLConnection r38 = r38.openConnection()     // Catch:{ IOException -> 0x01f5 }
            java.net.HttpURLConnection r38 = (java.net.HttpURLConnection) r38     // Catch:{ IOException -> 0x01f5 }
            r19 = r38
            com.google.android.gms.internal.zzir r38 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x01db }
            r39 = r3
            r40 = r4
            r41 = 0
            r42 = r19
            r38.zza(r39, r40, r41, r42)     // Catch:{ all -> 0x01db }
            r38 = r6
            boolean r38 = android.text.TextUtils.isEmpty(r38)     // Catch:{ all -> 0x01db }
            if (r38 != 0) goto L_0x00a5
            r38 = r19
            java.lang.String r39 = "x-afma-drt-cookie"
            r40 = r6
            r38.addRequestProperty(r39, r40)     // Catch:{ all -> 0x01db }
        L_0x00a5:
            r38 = r7
            boolean r38 = android.text.TextUtils.isEmpty(r38)     // Catch:{ all -> 0x01db }
            if (r38 != 0) goto L_0x00cf
            r38 = r19
            java.lang.String r39 = "Authorization"
            java.lang.StringBuilder r40 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r44 = r40
            r40 = r44
            r41 = r44
            r41.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r41 = "Bearer "
            java.lang.StringBuilder r40 = r40.append(r41)     // Catch:{ all -> 0x01db }
            r41 = r7
            java.lang.StringBuilder r40 = r40.append(r41)     // Catch:{ all -> 0x01db }
            java.lang.String r40 = r40.toString()     // Catch:{ all -> 0x01db }
            r38.addRequestProperty(r39, r40)     // Catch:{ all -> 0x01db }
        L_0x00cf:
            r38 = r8
            if (r38 == 0) goto L_0x011d
            r38 = r8
            java.lang.String r38 = r38.zzgF()     // Catch:{ all -> 0x01db }
            boolean r38 = android.text.TextUtils.isEmpty(r38)     // Catch:{ all -> 0x01db }
            if (r38 != 0) goto L_0x011d
            r38 = r19
            r39 = 1
            r38.setDoOutput(r39)     // Catch:{ all -> 0x01db }
            r38 = r8
            java.lang.String r38 = r38.zzgF()     // Catch:{ all -> 0x01db }
            byte[] r38 = r38.getBytes()     // Catch:{ all -> 0x01db }
            r35 = r38
            r38 = r19
            r39 = r35
            r0 = r39
            int r0 = r0.length     // Catch:{ all -> 0x01db }
            r39 = r0
            r38.setFixedLengthStreamingMode(r39)     // Catch:{ all -> 0x01db }
            java.io.BufferedOutputStream r38 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x01cc }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = r19
            java.io.OutputStream r40 = r40.getOutputStream()     // Catch:{ all -> 0x01cc }
            r39.<init>(r40)     // Catch:{ all -> 0x01cc }
            r36 = r38
            r38 = r36
            r39 = r35
            r38.write(r39)     // Catch:{ all -> 0x035c }
            r38 = r36
            com.google.android.gms.internal.zzna.zzb(r38)     // Catch:{ all -> 0x01db }
        L_0x011d:
            r38 = r19
            int r38 = r38.getResponseCode()     // Catch:{ all -> 0x01db }
            r21 = r38
            r38 = r19
            java.util.Map r38 = r38.getHeaderFields()     // Catch:{ all -> 0x01db }
            r22 = r38
            r38 = r21
            r39 = 200(0xc8, float:2.8E-43)
            r0 = r38
            r1 = r39
            if (r0 < r1) goto L_0x0239
            r38 = r21
            r39 = 300(0x12c, float:4.2E-43)
            r0 = r38
            r1 = r39
            if (r0 >= r1) goto L_0x0239
            r38 = r18
            java.lang.String r38 = r38.toString()     // Catch:{ all -> 0x01db }
            r29 = r38
            java.io.InputStreamReader r38 = new java.io.InputStreamReader     // Catch:{ all -> 0x022a }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = r19
            java.io.InputStream r40 = r40.getInputStream()     // Catch:{ all -> 0x022a }
            r39.<init>(r40)     // Catch:{ all -> 0x022a }
            r30 = r38
            com.google.android.gms.internal.zzir r38 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x0357 }
            r39 = r30
            java.lang.String r38 = r38.zza(r39)     // Catch:{ all -> 0x0357 }
            r32 = r38
            r38 = r30
            com.google.android.gms.internal.zzna.zzb(r38)     // Catch:{ all -> 0x01db }
            r38 = r29
            r39 = r22
            r40 = r32
            r41 = r21
            zza(r38, r39, r40, r41)     // Catch:{ all -> 0x01db }
            r38 = r12
            r39 = r29
            r40 = r22
            r41 = r32
            r38.zzb(r39, r40, r41)     // Catch:{ all -> 0x01db }
            r38 = r9
            if (r38 == 0) goto L_0x01a3
            r38 = r9
            r39 = r11
            r40 = 1
            r0 = r40
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x01db }
            r40 = r0
            r44 = r40
            r40 = r44
            r41 = r44
            r42 = 0
            java.lang.String r43 = "ufe"
            r41[r42] = r43     // Catch:{ all -> 0x01db }
            boolean r38 = r38.zza(r39, r40)     // Catch:{ all -> 0x01db }
        L_0x01a3:
            r38 = r12
            r39 = r15
            com.google.android.gms.ads.internal.request.AdResponseParcel r38 = r38.zzj(r39)     // Catch:{ all -> 0x01db }
            r34 = r38
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x01c1
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x01c1:
            r38 = r34
            r2 = r38
        L_0x01c5:
            return r2
        L_0x01c6:
            r38 = 0
            r11 = r38
            goto L_0x001e
        L_0x01cc:
            r38 = move-exception
            r37 = r38
            r38 = 0
            r36 = r38
        L_0x01d3:
            r38 = r36
            com.google.android.gms.internal.zzna.zzb(r38)     // Catch:{ all -> 0x01db }
            r38 = r37
            throw r38     // Catch:{ all -> 0x01db }
        L_0x01db:
            r38 = move-exception
            r20 = r38
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x01f2
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x01f2:
            r38 = r20
            throw r38     // Catch:{ IOException -> 0x01f5 }
        L_0x01f5:
            r38 = move-exception
            r13 = r38
            java.lang.StringBuilder r38 = new java.lang.StringBuilder
            r44 = r38
            r38 = r44
            r39 = r44
            r39.<init>()
            java.lang.String r39 = "Error while connecting to ad server: "
            java.lang.StringBuilder r38 = r38.append(r39)
            r39 = r13
            java.lang.String r39 = r39.getMessage()
            java.lang.StringBuilder r38 = r38.append(r39)
            java.lang.String r38 = r38.toString()
            com.google.android.gms.internal.zzin.zzaK(r38)
            com.google.android.gms.ads.internal.request.AdResponseParcel r38 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = 2
            r39.<init>(r40)
            r2 = r38
            goto L_0x01c5
        L_0x022a:
            r38 = move-exception
            r31 = r38
            r38 = 0
            r30 = r38
        L_0x0231:
            r38 = r30
            com.google.android.gms.internal.zzna.zzb(r38)     // Catch:{ all -> 0x01db }
            r38 = r31
            throw r38     // Catch:{ all -> 0x01db }
        L_0x0239:
            r38 = r18
            java.lang.String r38 = r38.toString()     // Catch:{ all -> 0x01db }
            r39 = r22
            r40 = 0
            r41 = r21
            zza(r38, r39, r40, r41)     // Catch:{ all -> 0x01db }
            r38 = r21
            r39 = 300(0x12c, float:4.2E-43)
            r0 = r38
            r1 = r39
            if (r0 < r1) goto L_0x02eb
            r38 = r21
            r39 = 400(0x190, float:5.6E-43)
            r0 = r38
            r1 = r39
            if (r0 >= r1) goto L_0x02eb
            r38 = r19
            java.lang.String r39 = "Location"
            java.lang.String r38 = r38.getHeaderField(r39)     // Catch:{ all -> 0x01db }
            r24 = r38
            r38 = r24
            boolean r38 = android.text.TextUtils.isEmpty(r38)     // Catch:{ all -> 0x01db }
            if (r38 == 0) goto L_0x029c
            java.lang.String r38 = "No location header to follow redirect."
            com.google.android.gms.internal.zzin.zzaK(r38)     // Catch:{ all -> 0x01db }
            com.google.android.gms.ads.internal.request.AdResponseParcel r38 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x01db }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = 0
            r39.<init>(r40)     // Catch:{ all -> 0x01db }
            r28 = r38
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x0296
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x0296:
            r38 = r28
            r2 = r38
            goto L_0x01c5
        L_0x029c:
            java.net.URL r38 = new java.net.URL     // Catch:{ all -> 0x01db }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = r24
            r39.<init>(r40)     // Catch:{ all -> 0x01db }
            r25 = r38
            r38 = r17
            r39 = 1
            int r38 = r38 + 1
            r26 = r38
            r38 = r26
            r39 = 5
            r0 = r38
            r1 = r39
            if (r0 <= r1) goto L_0x0332
            java.lang.String r38 = "Too many redirects."
            com.google.android.gms.internal.zzin.zzaK(r38)     // Catch:{ all -> 0x01db }
            com.google.android.gms.ads.internal.request.AdResponseParcel r38 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x01db }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = 0
            r39.<init>(r40)     // Catch:{ all -> 0x01db }
            r27 = r38
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x02e5
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x02e5:
            r38 = r27
            r2 = r38
            goto L_0x01c5
        L_0x02eb:
            java.lang.StringBuilder r38 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r44 = r38
            r38 = r44
            r39 = r44
            r39.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r39 = "Received error HTTP response code: "
            java.lang.StringBuilder r38 = r38.append(r39)     // Catch:{ all -> 0x01db }
            r39 = r21
            java.lang.StringBuilder r38 = r38.append(r39)     // Catch:{ all -> 0x01db }
            java.lang.String r38 = r38.toString()     // Catch:{ all -> 0x01db }
            com.google.android.gms.internal.zzin.zzaK(r38)     // Catch:{ all -> 0x01db }
            com.google.android.gms.ads.internal.request.AdResponseParcel r38 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x01db }
            r44 = r38
            r38 = r44
            r39 = r44
            r40 = 0
            r39.<init>(r40)     // Catch:{ all -> 0x01db }
            r23 = r38
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x032c
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x032c:
            r38 = r23
            r2 = r38
            goto L_0x01c5
        L_0x0332:
            r38 = r12
            r39 = r22
            r38.zzj(r39)     // Catch:{ all -> 0x01db }
            r38 = r19
            r38.disconnect()     // Catch:{ IOException -> 0x01f5 }
            r38 = r10
            if (r38 == 0) goto L_0x034d
            r38 = r10
            r0 = r38
            com.google.android.gms.internal.zzhm r0 = r0.zzIO     // Catch:{ IOException -> 0x01f5 }
            r38 = r0
            r38.zzgK()     // Catch:{ IOException -> 0x01f5 }
        L_0x034d:
            r38 = r26
            r17 = r38
            r38 = r25
            r18 = r38
            goto L_0x006c
        L_0x0357:
            r38 = move-exception
            r31 = r38
            goto L_0x0231
        L_0x035c:
            r38 = move-exception
            r37 = r38
            goto L_0x01d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzhi, com.google.android.gms.internal.zzcb, com.google.android.gms.internal.zzhc):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    /* JADX INFO: finally extract failed */
    public static zzhd zza(Context context, zzbm zzbm, zzhc zzhc) {
        zzhd zzhd;
        zzhd zzhd2;
        Context context2 = context;
        zzbm zzbm2 = zzbm;
        zzhc zzhc2 = zzhc;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzIQ == null) {
                    if (context2.getApplicationContext() != null) {
                        context2 = context2.getApplicationContext();
                    }
                    zzhd zzhd3 = zzhd2;
                    zzhd zzhd4 = new zzhd(context2, zzbm2, zzhc2);
                    zzIQ = zzhd3;
                }
                zzhd = zzIQ;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return zzhd;
    }

    /* access modifiers changed from: private */
    public static zzjq.zza zza(String str, zzcb zzcb, zzbz zzbz) {
        C03925 r8;
        C03925 r3 = r8;
        final zzcb zzcb2 = zzcb;
        final zzbz zzbz2 = zzbz;
        final String str2 = str;
        C03925 r4 = new zzjq.zza() {
            {
                zzbz zzbz = r8;
                String str = r9;
            }

            public void zza(zzjp zzjp, boolean z) {
                zzjp zzjp2 = zzjp;
                boolean z2 = z;
                zzcb zzcb = zzcb2;
                zzbz zzbz = zzbz2;
                String[] strArr = new String[1];
                String[] strArr2 = strArr;
                strArr[0] = "jsf";
                boolean zza = zzcb.zza(zzbz, strArr2);
                zzcb2.zzdC();
                zzjp2.zze("AFMA_buildAdURL", str2);
            }
        };
        return r3;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str3 = str;
        Map<String, List<String>> map2 = map;
        String str4 = str2;
        int i2 = i;
        if (zzin.zzQ(2)) {
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            zzin.m20v(sb5.append("Http Response: {\n  URL:\n    ").append(str3).append("\n  Headers:").toString());
            if (map2 != null) {
                for (String str5 : map2.keySet()) {
                    StringBuilder sb7 = sb3;
                    StringBuilder sb8 = new StringBuilder();
                    zzin.m20v(sb7.append("    ").append(str5).append(":").toString());
                    for (String str6 : (List) map2.get(str5)) {
                        StringBuilder sb9 = sb4;
                        StringBuilder sb10 = new StringBuilder();
                        zzin.m20v(sb9.append("      ").append(str6).toString());
                    }
                }
            }
            zzin.m20v("  Body:");
            if (str4 != null) {
                for (int i3 = 0; i3 < Math.min(str4.length(), GLU.GLU_SMOOTH); i3 += 1000) {
                    zzin.m20v(str4.substring(i3, Math.min(str4.length(), i3 + 1000)));
                }
            } else {
                zzin.m20v("    null");
            }
            StringBuilder sb11 = sb2;
            StringBuilder sb12 = new StringBuilder();
            zzin.m20v(sb11.append("  Response Code:\n    ").append(i2).append("\n}").toString());
        }
    }

    public void zza(AdRequestInfoParcel adRequestInfoParcel, zzk zzk) {
        C03947 r8;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        zzk zzk2 = zzk;
        zzr.zzbF().zzb(this.mContext, adRequestInfoParcel2.zzrl);
        C03947 r3 = r8;
        final AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel2;
        final zzk zzk3 = zzk2;
        C03947 r4 = new Runnable(this) {
            final /* synthetic */ zzhd zzJe;

            {
                AdRequestInfoParcel adRequestInfoParcel = r8;
                zzk zzk = r9;
                this.zzJe = r7;
            }

            public void run() {
                AdResponseParcel adResponseParcel;
                AdResponseParcel adResponseParcel2;
                try {
                    adResponseParcel = this.zzJe.zzd(adRequestInfoParcel3);
                } catch (Exception e) {
                    Exception exc = e;
                    zzr.zzbF().zzb((Throwable) exc, true);
                    zzin.zzd("Could not fetch ad response due to an Exception.", exc);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    AdResponseParcel adResponseParcel3 = adResponseParcel2;
                    AdResponseParcel adResponseParcel4 = new AdResponseParcel(0);
                    adResponseParcel = adResponseParcel3;
                }
                try {
                    zzk3.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzin.zzd("Fail to forward ad response.", e2);
                }
            }
        };
        zzjg zza = zziq.zza((Runnable) r3);
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzIT, this.zzIS, this.zzIR, adRequestInfoParcel);
    }
}
