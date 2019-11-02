package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzgw implements Callable<zzif> {
    private static final long zzGF = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zziw zzGG;
    /* access modifiers changed from: private */
    public final zzp zzGH;
    private final zzee zzGI;
    private boolean zzGJ = false;
    private List<String> zzGK = null;
    private JSONObject zzGL;
    private final com.google.android.gms.internal.zzif.zza zzGd;
    private int zzGu = -2;
    private final Object zzpV;
    private final zzan zzyt;

    public interface zza<T extends com.google.android.gms.ads.internal.formats.zzh.zza> {
        T zza(zzgw zzgw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        final /* synthetic */ zzgw zzGP;
        public zzdf zzHb;

        zzb(zzgw zzgw) {
            this.zzGP = zzgw;
        }
    }

    public zzgw(Context context, zzp zzp, zzee zzee, zziw zziw, zzan zzan, com.google.android.gms.internal.zzif.zza zza2) {
        Object obj;
        Context context2 = context;
        zzp zzp2 = zzp;
        zzee zzee2 = zzee;
        zziw zziw2 = zziw;
        zzan zzan2 = zzan;
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzGH = zzp2;
        this.zzGG = zziw2;
        this.zzGI = zzee2;
        this.zzGd = zza3;
        this.zzyt = zzan2;
    }

    private com.google.android.gms.ads.internal.formats.zzh.zza zza(zzed zzed, zza zza2, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        zzi zzi;
        zzed zzed2 = zzed;
        zza zza3 = zza2;
        JSONObject jSONObject2 = jSONObject;
        if (zzgn()) {
            return null;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("tracking_urls_and_actions");
        String[] zzc = zzc(jSONObject3, "impression_tracking_urls");
        this.zzGK = zzc == null ? null : Arrays.asList(zzc);
        this.zzGL = jSONObject3.optJSONObject("active_view");
        com.google.android.gms.ads.internal.formats.zzh.zza zza4 = zza3.zza(this, jSONObject2);
        if (zza4 == null) {
            zzin.m19e("Failed to retrieve ad assets.");
            return null;
        }
        com.google.android.gms.ads.internal.formats.zzh.zza zza5 = zza4;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi(this.mContext, this.zzGH, zzed2, this.zzyt, jSONObject2, zza4, this.zzGd.zzLd.zzrl);
        zza5.zzb(zzi2);
        return zza4;
    }

    /* JADX INFO: finally extract failed */
    private zzif zza(com.google.android.gms.ads.internal.formats.zzh.zza zza2) {
        int i;
        zzif zzif;
        com.google.android.gms.ads.internal.formats.zzh.zza zza3 = zza2;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                i = this.zzGu;
                if (zza3 == null && this.zzGu == -2) {
                    i = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(this.zzGd.zzLd.zzHt, null, this.zzGd.zzLe.zzBQ, i, this.zzGd.zzLe.zzBR, this.zzGK, this.zzGd.zzLe.orientation, this.zzGd.zzLe.zzBU, this.zzGd.zzLd.zzHw, false, null, null, null, null, null, 0, this.zzGd.zzrp, this.zzGd.zzLe.zzHS, this.zzGd.zzKY, this.zzGd.zzKZ, this.zzGd.zzLe.zzHY, this.zzGL, i != -2 ? null : zza3, null, null, null, this.zzGd.zzLe.zzIm);
        return zzif2;
    }

    private zzjg<zzc> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        C03855 r16;
        zzje zzje;
        zzc zzc;
        zzje zzje2;
        JSONObject jSONObject2 = jSONObject;
        boolean z3 = z;
        boolean z4 = z2;
        String optString = z3 ? jSONObject2.getString("url") : jSONObject2.optString("url");
        double optDouble = jSONObject2.optDouble("scale", 1.0d);
        if (TextUtils.isEmpty(optString)) {
            zza(0, z3);
            zzje zzje3 = zzje2;
            zzje zzje4 = new zzje(null);
            return zzje3;
        } else if (z4) {
            zzje zzje5 = zzje;
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc(null, Uri.parse(optString), optDouble);
            zzje zzje6 = new zzje(zzc2);
            return zzje5;
        } else {
            zziw zziw = this.zzGG;
            String str = optString;
            C03855 r9 = r16;
            final boolean z5 = z3;
            final double d = optDouble;
            final String str2 = optString;
            C03855 r10 = new com.google.android.gms.internal.zziw.zza<zzc>(this) {
                final /* synthetic */ zzgw zzGP;

                {
                    boolean z = r11;
                    double d = r12;
                    String str = r14;
                    this.zzGP = r10;
                }

                /* renamed from: zzg */
                public zzc zzh(InputStream inputStream) {
                    byte[] bArr;
                    zzc zzc;
                    BitmapDrawable bitmapDrawable;
                    try {
                        bArr = zzna.zzk(inputStream);
                    } catch (IOException e) {
                        IOException iOException = e;
                        bArr = null;
                    }
                    if (bArr == null) {
                        this.zzGP.zza(2, z5);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray == null) {
                        this.zzGP.zza(2, z5);
                        return null;
                    }
                    decodeByteArray.setDensity((int) (160.0d * d));
                    zzc zzc2 = zzc;
                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                    BitmapDrawable bitmapDrawable3 = new BitmapDrawable(Resources.getSystem(), decodeByteArray);
                    zzc zzc3 = new zzc(bitmapDrawable2, Uri.parse(str2), d);
                    return zzc2;
                }

                /* renamed from: zzgo */
                public zzc zzgp() {
                    this.zzGP.zza(2, z5);
                    return null;
                }
            };
            return zziw.zza(str, r9);
        }
    }

    private void zza(com.google.android.gms.ads.internal.formats.zzh.zza zza2, zzed zzed) {
        zzb zzb2;
        C03833 r10;
        com.google.android.gms.ads.internal.formats.zzh.zza zza3 = zza2;
        zzed zzed2 = zzed;
        if (zza3 instanceof zzf) {
            zzf zzf = (zzf) zza3;
            zzb zzb3 = zzb2;
            zzb zzb4 = new zzb(this);
            zzb zzb5 = zzb3;
            C03833 r6 = r10;
            final zzf zzf2 = zzf;
            C03833 r7 = new zzdf(this) {
                final /* synthetic */ zzgw zzGP;

                {
                    zzf zzf = r7;
                    this.zzGP = r6;
                }

                public void zza(zzjp zzjp, Map<String, String> map) {
                    zzjp zzjp2 = zzjp;
                    this.zzGP.zzb((zzcp) zzf2, (String) map.get("asset"));
                }
            };
            C03833 r5 = r6;
            zzb5.zzHb = r5;
            zzed2.zza("/nativeAdCustomClick", (zzdf) r5);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            JSONException jSONException = e;
            return null;
        }
    }

    private JSONObject zzb(zzed zzed) throws TimeoutException, JSONException {
        zzjd zzjd;
        zzb zzb2;
        C03811 r11;
        JSONObject jSONObject;
        zzed zzed2 = zzed;
        if (zzgn()) {
            return null;
        }
        zzjd zzjd2 = zzjd;
        zzjd zzjd3 = new zzjd();
        zzjd zzjd4 = zzjd2;
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(this);
        zzb zzb5 = zzb3;
        C03811 r5 = r11;
        final zzed zzed3 = zzed2;
        final zzb zzb6 = zzb5;
        final zzjd zzjd5 = zzjd4;
        C03811 r6 = new zzdf(this) {
            final /* synthetic */ zzgw zzGP;

            {
                zzed zzed = r9;
                zzb zzb = r10;
                zzjd zzjd = r11;
                this.zzGP = r8;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                JSONObject jSONObject;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                zzed3.zzb("/nativeAdPreProcess", zzb6.zzHb);
                try {
                    String str = (String) map2.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        zzjd zzjd = zzjd5;
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject(str);
                        zzjd.zzg(jSONObject2.getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (JSONException e) {
                    zzin.zzb("Malformed native JSON response.", e);
                }
                this.zzGP.zzF(0);
                zzx.zza(this.zzGP.zzgn(), (Object) "Unable to set the ad state error!");
                zzjd5.zzg(null);
            }
        };
        C03811 r4 = r5;
        zzb5.zzHb = r4;
        zzed2.zza("/nativeAdPreProcess", (zzdf) r4);
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject(this.zzGd.zzLe.body);
        zzed2.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject2);
        return (JSONObject) zzjd4.get(zzGF, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public void zzb(zzcp zzcp, String str) {
        StringBuilder sb;
        zzcp zzcp2 = zzcp;
        String str2 = str;
        try {
            zzct zzs = this.zzGH.zzs(zzcp2.getCustomTemplateId());
            if (zzs != null) {
                zzs.zza(zzcp2, str2);
            }
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzd(sb2.append("Failed to call onCustomClick for asset ").append(str2).append(".").toString(), remoteException);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public static List<Drawable> zzf(List<zzc> list) throws RemoteException {
        ArrayList arrayList;
        List<zzc> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzc zzdJ : list2) {
            boolean add = arrayList4.add((Drawable) zze.zzp(zzdJ.zzdJ()));
        }
        return arrayList4;
    }

    private zzed zzgm() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        StringBuilder sb;
        if (zzgn()) {
            return null;
        }
        String str = (String) zzbt.zzwC.get();
        String str2 = this.zzGd.zzLe.zzEF.indexOf("https") == 0 ? "https:" : "http:";
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzed zzed = (zzed) this.zzGI.zza(this.mContext, this.zzGd.zzLd.zzrl, sb2.append(str2).append(str).toString(), this.zzyt).get(zzGF, TimeUnit.MILLISECONDS);
        zzed.zza(this.zzGH, this.zzGH, this.zzGH, this.zzGH, false, null, null, null, null);
        return zzed;
    }

    public void zzF(int i) {
        int i2 = i;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzGJ = true;
                this.zzGu = i2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public zzjg<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        JSONObject optJSONObject = z3 ? jSONObject3.getJSONObject(str2) : jSONObject3.optJSONObject(str2);
        if (optJSONObject == null) {
            JSONObject jSONObject4 = jSONObject2;
            JSONObject jSONObject5 = new JSONObject();
            optJSONObject = jSONObject4;
        }
        return zza(optJSONObject, z3, z4);
    }

    public List<zzjg<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        ArrayList arrayList;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        String str2 = str;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        JSONArray optJSONArray = z4 ? jSONObject3.getJSONArray(str2) : jSONObject3.optJSONArray(str2);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zza(0, z4);
            return arrayList4;
        }
        int i = z6 ? optJSONArray.length() : 1;
        for (int i2 = 0; i2 < i; i2++) {
            JSONObject jSONObject4 = optJSONArray.getJSONObject(i2);
            if (jSONObject4 == null) {
                JSONObject jSONObject5 = jSONObject2;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject4 = jSONObject5;
            }
            boolean add = arrayList4.add(zza(jSONObject4, z4, z5));
        }
        return arrayList4;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2;
        boolean z2 = z;
        JSONObject jSONObject3 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject3.optBoolean("require", true);
        if (jSONObject3 == null) {
            JSONObject jSONObject4 = jSONObject2;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject3 = jSONObject4;
        }
        return zza(jSONObject3, optBoolean, z2);
    }

    public void zza(int i, boolean z) {
        int i2 = i;
        if (z) {
            zzF(i2);
        }
    }

    /* access modifiers changed from: protected */
    public zza zze(JSONObject jSONObject) throws JSONException, TimeoutException {
        zzjd zzjd;
        C03822 r13;
        StringBuilder sb;
        zzgz zzgz;
        zzgy zzgy;
        zzgx zzgx;
        JSONObject jSONObject2 = jSONObject;
        if (zzgn()) {
            return null;
        }
        String string = jSONObject2.getString("template_id");
        boolean z = this.zzGd.zzLd.zzrD != null ? this.zzGd.zzLd.zzrD.zzyA : false;
        boolean z2 = this.zzGd.zzLd.zzrD != null ? this.zzGd.zzLd.zzrD.zzyC : false;
        if ("2".equals(string)) {
            zzgx zzgx2 = zzgx;
            zzgx zzgx3 = new zzgx(z, z2);
            return zzgx2;
        } else if ("1".equals(string)) {
            zzgy zzgy2 = zzgy;
            zzgy zzgy3 = new zzgy(z, z2);
            return zzgy2;
        } else {
            if ("3".equals(string)) {
                String string2 = jSONObject2.getString("custom_template_id");
                zzjd zzjd2 = zzjd;
                zzjd zzjd3 = new zzjd();
                zzjd zzjd4 = zzjd2;
                Handler handler = zzir.zzMc;
                C03822 r8 = r13;
                final zzjd zzjd5 = zzjd4;
                final String str = string2;
                C03822 r9 = new Runnable(this) {
                    final /* synthetic */ zzgw zzGP;

                    {
                        zzjd zzjd = r8;
                        String str = r9;
                        this.zzGP = r7;
                    }

                    public void run() {
                        zzjd5.zzg(this.zzGP.zzGH.zzbv().get(str));
                    }
                };
                boolean post = handler.post(r8);
                if (zzjd4.get(zzGF, TimeUnit.MILLISECONDS) != null) {
                    zzgz zzgz2 = zzgz;
                    zzgz zzgz3 = new zzgz(z);
                    return zzgz2;
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.m19e(sb2.append("No handler for custom template: ").append(jSONObject2.getString("custom_template_id")).toString());
            } else {
                zzF(0);
            }
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r10v19, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r10v21, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r10v25, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzjg<com.google.android.gms.ads.internal.formats.zza> zzf(org.json.JSONObject r22) throws org.json.JSONException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r10 = r1
            java.lang.String r11 = "attribution"
            org.json.JSONObject r10 = r10.optJSONObject(r11)
            r2 = r10
            r10 = r2
            if (r10 != 0) goto L_0x001d
            com.google.android.gms.internal.zzje r10 = new com.google.android.gms.internal.zzje
            r20 = r10
            r10 = r20
            r11 = r20
            r12 = 0
            r11.<init>(r12)
            r0 = r10
        L_0x001c:
            return r0
        L_0x001d:
            r10 = r2
            java.lang.String r11 = "text"
            java.lang.String r10 = r10.optString(r11)
            r3 = r10
            r10 = r2
            java.lang.String r11 = "text_size"
            r12 = -1
            int r10 = r10.optInt(r11, r12)
            r4 = r10
            r10 = r0
            r11 = r2
            java.lang.String r12 = "text_color"
            java.lang.Integer r10 = r10.zzb(r11, r12)
            r5 = r10
            r10 = r0
            r11 = r2
            java.lang.String r12 = "bg_color"
            java.lang.Integer r10 = r10.zzb(r11, r12)
            r6 = r10
            r10 = r2
            java.lang.String r11 = "animation_ms"
            r12 = 1000(0x3e8, float:1.401E-42)
            int r10 = r10.optInt(r11, r12)
            r7 = r10
            r10 = r2
            java.lang.String r11 = "presentation_ms"
            r12 = 4000(0xfa0, float:5.605E-42)
            int r10 = r10.optInt(r11, r12)
            r8 = r10
            java.util.ArrayList r10 = new java.util.ArrayList
            r20 = r10
            r10 = r20
            r11 = r20
            r11.<init>()
            r9 = r10
            r10 = r2
            java.lang.String r11 = "images"
            org.json.JSONArray r10 = r10.optJSONArray(r11)
            if (r10 == 0) goto L_0x0096
            r10 = r0
            r11 = r2
            java.lang.String r12 = "images"
            r13 = 0
            r14 = 0
            r15 = 1
            java.util.List r10 = r10.zza(r11, r12, r13, r14, r15)
            r9 = r10
        L_0x0075:
            r10 = r9
            com.google.android.gms.internal.zzjg r10 = com.google.android.gms.internal.zzjf.zzl(r10)
            com.google.android.gms.internal.zzgw$4 r11 = new com.google.android.gms.internal.zzgw$4
            r20 = r11
            r11 = r20
            r12 = r20
            r13 = r0
            r14 = r3
            r15 = r6
            r16 = r5
            r17 = r4
            r18 = r8
            r19 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            com.google.android.gms.internal.zzjg r10 = com.google.android.gms.internal.zzjf.zza(r10, r11)
            r0 = r10
            goto L_0x001c
        L_0x0096:
            r10 = r9
            r11 = r0
            r12 = r2
            java.lang.String r13 = "image"
            r14 = 0
            r15 = 0
            com.google.android.gms.internal.zzjg r11 = r11.zza(r12, r13, r14, r15)
            boolean r10 = r10.add(r11)
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgw.zzf(org.json.JSONObject):com.google.android.gms.internal.zzjg");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0039  */
    /* renamed from: zzgl */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzif call() {
        /*
            r14 = this;
            r0 = r14
            r10 = r0
            com.google.android.gms.internal.zzed r10 = r10.zzgm()     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r6 = r10
            r10 = r0
            r11 = r6
            org.json.JSONObject r10 = r10.zzb(r11)     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r7 = r10
            r10 = r0
            r11 = r6
            r12 = r0
            r13 = r7
            com.google.android.gms.internal.zzgw$zza r12 = r12.zze(r13)     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r13 = r7
            com.google.android.gms.ads.internal.formats.zzh$zza r10 = r10.zza(r11, r12, r13)     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r8 = r10
            r10 = r0
            r11 = r8
            r12 = r6
            r10.zza(r11, r12)     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r10 = r0
            r11 = r8
            com.google.android.gms.internal.zzif r10 = r10.zza(r11)     // Catch:{ CancellationException -> 0x0055, ExecutionException -> 0x0052, InterruptedException -> 0x004f, JSONException -> 0x002c, TimeoutException -> 0x0046 }
            r9 = r10
            r10 = r9
            r0 = r10
        L_0x002b:
            return r0
        L_0x002c:
            r10 = move-exception
            r5 = r10
            java.lang.String r10 = "Malformed native JSON response."
            r11 = r5
            com.google.android.gms.internal.zzin.zzd(r10, r11)
        L_0x0034:
            r10 = r0
            boolean r10 = r10.zzGJ
            if (r10 != 0) goto L_0x003e
            r10 = r0
            r11 = 0
            r10.zzF(r11)
        L_0x003e:
            r10 = r0
            r11 = 0
            com.google.android.gms.internal.zzif r10 = r10.zza(r11)
            r0 = r10
            goto L_0x002b
        L_0x0046:
            r10 = move-exception
            r4 = r10
            java.lang.String r10 = "Timeout when loading native ad."
            r11 = r4
            com.google.android.gms.internal.zzin.zzd(r10, r11)
            goto L_0x0034
        L_0x004f:
            r10 = move-exception
            r3 = r10
            goto L_0x0034
        L_0x0052:
            r10 = move-exception
            r2 = r10
            goto L_0x0034
        L_0x0055:
            r10 = move-exception
            r1 = r10
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgw.call():com.google.android.gms.internal.zzif");
    }

    public boolean zzgn() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzGJ;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }
}
