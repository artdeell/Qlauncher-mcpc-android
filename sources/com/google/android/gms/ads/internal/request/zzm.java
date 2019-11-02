package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.zza.C0868zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeg.zzd;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@zzhb
public class zzm extends zzim {
    /* access modifiers changed from: private */
    public static zzdk zzIA = null;
    private static zzdf zzIB = null;
    static final long zzIw = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzIx = false;
    /* access modifiers changed from: private */
    public static zzeg zzIy = null;
    private static zzdg zzIz = null;
    private static final Object zzqy;
    private final Context mContext;
    private final Object zzGg;
    /* access modifiers changed from: private */
    public final C0868zza zzHg;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzHh;
    /* access modifiers changed from: private */
    public zzd zzIC;

    public static class zza implements com.google.android.gms.internal.zzeg.zzb<zzed> {
        public zza() {
        }

        /* renamed from: zza */
        public void zze(zzed zzed) {
            zzm.zzd(zzed);
        }
    }

    public static class zzb implements com.google.android.gms.internal.zzeg.zzb<zzed> {
        public zzb() {
        }

        /* renamed from: zza */
        public void zze(zzed zzed) {
            zzm.zzc(zzed);
        }
    }

    public static class zzc implements zzdf {
        public zzc() {
        }

        public void zza(zzjp zzjp, Map<String, String> map) {
            StringBuilder sb;
            zzjp zzjp2 = zzjp;
            Map<String, String> map2 = map;
            String str = (String) map2.get("request_id");
            String str2 = (String) map2.get("errors");
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Invalid request: ").append(str2).toString());
            zzm.zzIA.zzS(str);
        }
    }

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    public zzm(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza2, C0868zza zza3) {
        Object obj;
        zzdk zzdk;
        zzdg zzdg;
        zzc zzc2;
        zzeg zzeg;
        zzb zzb2;
        zza zza4;
        Context context2 = context;
        com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza5 = zza2;
        C0868zza zza6 = zza3;
        super(true);
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzGg = obj2;
        this.zzHg = zza6;
        this.mContext = context2;
        this.zzHh = zza5;
        Object obj4 = zzqy;
        synchronized (obj4) {
            try {
                if (!zzIx) {
                    zzdk zzdk2 = zzdk;
                    zzdk zzdk3 = new zzdk();
                    zzIA = zzdk2;
                    zzdg zzdg2 = zzdg;
                    zzdg zzdg3 = new zzdg(context2.getApplicationContext(), zza5.zzrl);
                    zzIz = zzdg2;
                    zzc zzc3 = zzc2;
                    zzc zzc4 = new zzc();
                    zzIB = zzc3;
                    zzeg zzeg2 = zzeg;
                    Context applicationContext = this.mContext.getApplicationContext();
                    VersionInfoParcel versionInfoParcel = this.zzHh.zzrl;
                    String str = (String) zzbt.zzvB.get();
                    zzb zzb3 = zzb2;
                    zzb zzb4 = new zzb();
                    zza zza7 = zza4;
                    zza zza8 = new zza();
                    zzeg zzeg3 = new zzeg(applicationContext, versionInfoParcel, str, zzb3, zza7);
                    zzIy = zzeg2;
                    zzIx = true;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj5 = obj4;
                throw th2;
            }
        }
    }

    static /* synthetic */ zzd zza(zzm zzm, zzd zzd) {
        zzd zzd2 = zzd;
        zzm.zzIC = zzd2;
        return zzd2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r32, java.lang.String r33) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            r3 = r33
            r20 = r2
            r0 = r20
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.zzHt
            r20 = r0
            r0 = r20
            android.os.Bundle r0 = r0.extras
            r20 = r0
            java.lang.String r21 = "sdk_less_server_data"
            android.os.Bundle r20 = r20.getBundle(r21)
            r4 = r20
            r20 = r2
            r0 = r20
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.zzHt
            r20 = r0
            r0 = r20
            android.os.Bundle r0 = r0.extras
            r20 = r0
            java.lang.String r21 = "sdk_less_network_id"
            java.lang.String r20 = r20.getString(r21)
            r5 = r20
            r20 = r4
            if (r20 != 0) goto L_0x003b
        L_0x0036:
            r20 = 0
            r1 = r20
        L_0x003a:
            return r1
        L_0x003b:
            r20 = r1
            r0 = r20
            android.content.Context r0 = r0.mContext
            r20 = r0
            r21 = r2
            com.google.android.gms.internal.zzhk r22 = com.google.android.gms.ads.internal.zzr.zzbI()
            r23 = r1
            r0 = r23
            android.content.Context r0 = r0.mContext
            r23 = r0
            com.google.android.gms.internal.zzhj r22 = r22.zzE(r23)
            r23 = 0
            r24 = 0
            com.google.android.gms.internal.zzbm r25 = new com.google.android.gms.internal.zzbm
            r30 = r25
            r25 = r30
            r26 = r30
            com.google.android.gms.internal.zzbp<java.lang.String> r27 = com.google.android.gms.internal.zzbt.zzvB
            java.lang.Object r27 = r27.get()
            java.lang.String r27 = (java.lang.String) r27
            r26.<init>(r27)
            r26 = 0
            r27 = 0
            java.util.ArrayList r28 = new java.util.ArrayList
            r30 = r28
            r28 = r30
            r29 = r30
            r29.<init>()
            r29 = 0
            org.json.JSONObject r20 = com.google.android.gms.internal.zzhe.zza(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r6 = r20
            r20 = r6
            if (r20 == 0) goto L_0x0036
            r20 = r1
            r0 = r20
            android.content.Context r0 = r0.mContext     // Catch:{ IOException -> 0x010c, IllegalStateException -> 0x012a, GooglePlayServicesNotAvailableException -> 0x012e, GooglePlayServicesRepairableException -> 0x0132 }
            r20 = r0
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r20 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r20)     // Catch:{ IOException -> 0x010c, IllegalStateException -> 0x012a, GooglePlayServicesNotAvailableException -> 0x012e, GooglePlayServicesRepairableException -> 0x0132 }
            r19 = r20
            r20 = r19
            r8 = r20
        L_0x0099:
            java.util.HashMap r20 = new java.util.HashMap
            r30 = r20
            r20 = r30
            r21 = r30
            r21.<init>()
            r9 = r20
            r20 = r9
            java.lang.String r21 = "request_id"
            r22 = r3
            java.lang.Object r20 = r20.put(r21, r22)
            r20 = r9
            java.lang.String r21 = "network_id"
            r22 = r5
            java.lang.Object r20 = r20.put(r21, r22)
            r20 = r9
            java.lang.String r21 = "request_param"
            r22 = r6
            java.lang.Object r20 = r20.put(r21, r22)
            r20 = r9
            java.lang.String r21 = "data"
            r22 = r4
            java.lang.Object r20 = r20.put(r21, r22)
            r20 = r8
            if (r20 == 0) goto L_0x00fa
            r20 = r9
            java.lang.String r21 = "adid"
            r22 = r8
            java.lang.String r22 = r22.getId()
            java.lang.Object r20 = r20.put(r21, r22)
            r20 = r8
            boolean r20 = r20.isLimitAdTrackingEnabled()
            if (r20 == 0) goto L_0x011c
            r20 = 1
            r17 = r20
        L_0x00ec:
            r20 = r9
            java.lang.String r21 = "lat"
            r22 = r17
            java.lang.Integer r22 = java.lang.Integer.valueOf(r22)
            java.lang.Object r20 = r20.put(r21, r22)
        L_0x00fa:
            com.google.android.gms.internal.zzir r20 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ JSONException -> 0x0121 }
            r21 = r9
            org.json.JSONObject r20 = r20.zzG(r21)     // Catch:{ JSONException -> 0x0121 }
            r15 = r20
            r20 = r15
            r1 = r20
            goto L_0x003a
        L_0x010c:
            r20 = move-exception
            r7 = r20
        L_0x010f:
            java.lang.String r20 = "Cannot get advertising id info"
            r21 = r7
            com.google.android.gms.internal.zzin.zzd(r20, r21)
            r20 = 0
            r8 = r20
            goto L_0x0099
        L_0x011c:
            r20 = 0
            r17 = r20
            goto L_0x00ec
        L_0x0121:
            r20 = move-exception
            r14 = r20
            r20 = 0
            r1 = r20
            goto L_0x003a
        L_0x012a:
            r20 = move-exception
            r7 = r20
            goto L_0x010f
        L_0x012e:
            r20 = move-exception
            r7 = r20
            goto L_0x010f
        L_0x0132:
            r20 = move-exception
            r7 = r20
            goto L_0x010f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzm.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):org.json.JSONObject");
    }

    protected static void zzc(zzed zzed) {
        zzed zzed2 = zzed;
        zzed2.zza("/loadAd", (zzdf) zzIA);
        zzed2.zza("/fetchHttpRequest", (zzdf) zzIz);
        zzed2.zza("/invalidRequest", zzIB);
    }

    protected static void zzd(zzed zzed) {
        zzed zzed2 = zzed;
        zzed2.zzb("/loadAd", (zzdf) zzIA);
        zzed2.zzb("/fetchHttpRequest", (zzdf) zzIz);
        zzed2.zzb("/invalidRequest", zzIB);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        C01912 r24;
        AdResponseParcel adResponseParcel;
        AdResponseParcel adResponseParcel2;
        AdResponseParcel adResponseParcel3;
        AdResponseParcel zza2;
        AdResponseParcel adResponseParcel4;
        AdResponseParcel adResponseParcel5;
        AdResponseParcel adResponseParcel6;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        String uuid = UUID.randomUUID().toString();
        JSONObject zza3 = zza(adRequestInfoParcel2, uuid);
        if (zza3 == null) {
            AdResponseParcel adResponseParcel7 = adResponseParcel6;
            AdResponseParcel adResponseParcel8 = new AdResponseParcel(0);
            zza2 = adResponseParcel7;
        } else {
            long elapsedRealtime = zzr.zzbG().elapsedRealtime();
            Future zzR = zzIA.zzR(uuid);
            Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
            C01912 r19 = r24;
            final JSONObject jSONObject = zza3;
            final String str = uuid;
            C01912 r20 = new Runnable(this) {
                final /* synthetic */ zzm zzID;

                {
                    JSONObject jSONObject = r8;
                    String str = r9;
                    this.zzID = r7;
                }

                public void run() {
                    C01921 r6;
                    C01932 r62;
                    zzd zza = zzm.zza(this.zzID, zzm.zzIy.zzer());
                    zzd zzb = this.zzID.zzIC;
                    C01921 r2 = r6;
                    C01921 r3 = new com.google.android.gms.internal.zzji.zzc<zzeh>(this) {
                        final /* synthetic */ C01912 zzIG;

                        {
                            this.zzIG = r5;
                        }

                        /* renamed from: zzd */
                        public void zze(zzeh zzeh) {
                            try {
                                zzeh.zza("AFMA_getAdapterLessMediationAd", jSONObject);
                            } catch (Exception e) {
                                zzin.zzb("Error requesting an ad url", e);
                                zzm.zzIA.zzS(str);
                            }
                        }
                    };
                    C01932 r32 = r62;
                    C01932 r4 = new com.google.android.gms.internal.zzji.zza(this) {
                        final /* synthetic */ C01912 zzIG;

                        {
                            this.zzIG = r5;
                        }

                        public void run() {
                            zzm.zzIA.zzS(str);
                        }
                    };
                    zzb.zza(r2, r32);
                }
            };
            boolean post = handler.post(r19);
            try {
                JSONObject jSONObject2 = (JSONObject) zzR.get(zzIw - (zzr.zzbG().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
                if (jSONObject2 == null) {
                    AdResponseParcel adResponseParcel9 = adResponseParcel5;
                    AdResponseParcel adResponseParcel10 = new AdResponseParcel(-1);
                    return adResponseParcel9;
                }
                zza2 = zzhe.zza(this.mContext, adRequestInfoParcel2, jSONObject2.toString());
                if (zza2.errorCode != -3 && TextUtils.isEmpty(zza2.body)) {
                    AdResponseParcel adResponseParcel11 = adResponseParcel4;
                    AdResponseParcel adResponseParcel12 = new AdResponseParcel(3);
                    return adResponseParcel11;
                }
            } catch (CancellationException e) {
                CancellationException cancellationException = e;
                AdResponseParcel adResponseParcel13 = adResponseParcel3;
                AdResponseParcel adResponseParcel14 = new AdResponseParcel(-1);
                return adResponseParcel13;
            } catch (InterruptedException e2) {
                InterruptedException interruptedException = e2;
                AdResponseParcel adResponseParcel132 = adResponseParcel3;
                AdResponseParcel adResponseParcel142 = new AdResponseParcel(-1);
                return adResponseParcel132;
            } catch (TimeoutException e3) {
                TimeoutException timeoutException = e3;
                AdResponseParcel adResponseParcel15 = adResponseParcel2;
                AdResponseParcel adResponseParcel16 = new AdResponseParcel(2);
                return adResponseParcel15;
            } catch (ExecutionException e4) {
                ExecutionException executionException = e4;
                AdResponseParcel adResponseParcel17 = adResponseParcel;
                AdResponseParcel adResponseParcel18 = new AdResponseParcel(0);
                return adResponseParcel17;
            }
        }
        return zza2;
    }

    public void onStop() {
        C01943 r7;
        Object obj = this.zzGg;
        synchronized (obj) {
            try {
                Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
                C01943 r4 = r7;
                C01943 r5 = new Runnable(this) {
                    final /* synthetic */ zzm zzID;

                    {
                        this.zzID = r5;
                    }

                    public void run() {
                        if (this.zzID.zzIC != null) {
                            this.zzID.zzIC.release();
                            zzd zza = zzm.zza(this.zzID, (zzd) null);
                        }
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

    public void zzbr() {
        AdRequestInfoParcel adRequestInfoParcel;
        com.google.android.gms.internal.zzif.zza zza2;
        C01901 r18;
        zzin.zzaI("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        AdRequestInfoParcel adRequestInfoParcel3 = new AdRequestInfoParcel(this.zzHh, null, -1);
        AdRequestInfoParcel adRequestInfoParcel4 = adRequestInfoParcel2;
        AdResponseParcel zze = zze(adRequestInfoParcel4);
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        com.google.android.gms.internal.zzif.zza zza4 = new com.google.android.gms.internal.zzif.zza(adRequestInfoParcel4, zze, null, null, zze.errorCode, zzr.zzbG().elapsedRealtime(), zze.zzHX, null);
        com.google.android.gms.internal.zzif.zza zza5 = zza3;
        Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
        C01901 r7 = r18;
        final com.google.android.gms.internal.zzif.zza zza6 = zza5;
        C01901 r8 = new Runnable(this) {
            final /* synthetic */ zzm zzID;

            {
                com.google.android.gms.internal.zzif.zza zza = r7;
                this.zzID = r6;
            }

            public void run() {
                this.zzID.zzHg.zza(zza6);
                if (this.zzID.zzIC != null) {
                    this.zzID.zzIC.release();
                    zzd zza = zzm.zza(this.zzID, (zzd) null);
                }
            }
        };
        boolean post = handler.post(r7);
    }
}
