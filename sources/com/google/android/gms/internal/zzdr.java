package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.api.Releasable;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzhb
public abstract class zzdr implements Releasable {
    protected Context mContext;
    protected String zzzN;
    protected WeakReference<zzjp> zzzO;

    public zzdr(zzjp zzjp) {
        WeakReference<zzjp> weakReference;
        zzjp zzjp2 = zzjp;
        this.mContext = zzjp2.getContext();
        this.zzzN = zzr.zzbC().zze(this.mContext, zzjp2.zzhX().afmaVersion);
        WeakReference<zzjp> weakReference2 = weakReference;
        WeakReference<zzjp> weakReference3 = new WeakReference<>(zzjp2);
        this.zzzO = weakReference2;
    }

    /* access modifiers changed from: private */
    public String zzW(String str) {
        String str2 = str;
        boolean z = true;
        switch (str2.hashCode()) {
            case -1396664534:
                if (str2.equals("badUrl")) {
                    z = true;
                    break;
                }
                break;
            case -1347010958:
                if (str2.equals("inProgress")) {
                    z = true;
                    break;
                }
                break;
            case -918817863:
                if (str2.equals("downloadTimeout")) {
                    z = true;
                    break;
                }
                break;
            case -659376217:
                if (str2.equals("contentLengthMissing")) {
                    z = true;
                    break;
                }
                break;
            case -642208130:
                if (str2.equals("playerFailed")) {
                    z = true;
                    break;
                }
                break;
            case -354048396:
                if (str2.equals("sizeExceeded")) {
                    z = true;
                    break;
                }
                break;
            case -32082395:
                if (str2.equals("externalAbort")) {
                    z = true;
                    break;
                }
                break;
            case 96784904:
                if (str2.equals("error")) {
                    z = false;
                    break;
                }
                break;
            case 580119100:
                if (str2.equals("expireFailed")) {
                    z = true;
                    break;
                }
                break;
            case 725497484:
                if (str2.equals("noCacheDir")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
                return "internal";
            case true:
            case true:
                return "io";
            case true:
            case true:
                return "network";
            case true:
            case true:
                return "policy";
            default:
                return "internal";
        }
    }

    /* access modifiers changed from: private */
    public void zza(String str, Map<String, String> map) {
        String str2 = str;
        Map<String, String> map2 = map;
        zzjp zzjp = (zzjp) this.zzzO.get();
        if (zzjp != null) {
            zzjp.zza(str2, map2);
        }
    }

    public abstract void abort();

    public void release() {
    }

    public abstract boolean zzU(String str);

    /* access modifiers changed from: protected */
    public String zzV(String str) {
        return zzn.zzcS().zzaH(str);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, int i) {
        C03002 r11;
        String str3 = str;
        String str4 = str2;
        int i2 = i;
        Handler handler = zza.zzMS;
        C03002 r5 = r11;
        final String str5 = str3;
        final String str6 = str4;
        final int i3 = i2;
        C03002 r6 = new Runnable(this) {
            final /* synthetic */ zzdr zzzU;

            {
                String str = r9;
                String str2 = r10;
                int i = r11;
                this.zzzU = r8;
            }

            public void run() {
                HashMap hashMap;
                HashMap hashMap2 = hashMap;
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = hashMap2;
                Object put = hashMap4.put("event", "precacheComplete");
                Object put2 = hashMap4.put("src", str5);
                Object put3 = hashMap4.put("cachedSrc", str6);
                Object put4 = hashMap4.put("totalBytes", Integer.toString(i3));
                this.zzzU.zza("onPrecacheEvent", (Map<String, String>) hashMap4);
            }
        };
        boolean post = handler.post(r5);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, int i, int i2, boolean z) {
        C02991 r15;
        String str3 = str;
        String str4 = str2;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        Handler handler = zza.zzMS;
        C02991 r7 = r15;
        final String str5 = str3;
        final String str6 = str4;
        final int i5 = i3;
        final int i6 = i4;
        final boolean z3 = z2;
        C02991 r8 = new Runnable(this) {
            final /* synthetic */ zzdr zzzU;

            {
                String str = r11;
                String str2 = r12;
                int i = r13;
                int i2 = r14;
                boolean z = r15;
                this.zzzU = r10;
            }

            public void run() {
                HashMap hashMap;
                HashMap hashMap2 = hashMap;
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = hashMap2;
                Object put = hashMap4.put("event", "precacheProgress");
                Object put2 = hashMap4.put("src", str5);
                Object put3 = hashMap4.put("cachedSrc", str6);
                Object put4 = hashMap4.put("bytesLoaded", Integer.toString(i5));
                Object put5 = hashMap4.put("totalBytes", Integer.toString(i6));
                Object put6 = hashMap4.put("cacheReady", z3 ? "1" : "0");
                this.zzzU.zza("onPrecacheEvent", (Map<String, String>) hashMap4);
            }
        };
        boolean post = handler.post(r7);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, String str3, String str4) {
        C03013 r13;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        Handler handler = zza.zzMS;
        C03013 r6 = r13;
        final String str9 = str5;
        final String str10 = str6;
        final String str11 = str7;
        final String str12 = str8;
        C03013 r7 = new Runnable(this) {
            final /* synthetic */ zzdr zzzU;

            {
                String str = r10;
                String str2 = r11;
                String str3 = r12;
                String str4 = r13;
                this.zzzU = r9;
            }

            public void run() {
                HashMap hashMap;
                HashMap hashMap2 = hashMap;
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = hashMap2;
                Object put = hashMap4.put("event", "precacheCanceled");
                Object put2 = hashMap4.put("src", str9);
                if (!TextUtils.isEmpty(str10)) {
                    Object put3 = hashMap4.put("cachedSrc", str10);
                }
                Object put4 = hashMap4.put(MimeTypeParser.TAG_TYPE, this.zzzU.zzW(str11));
                Object put5 = hashMap4.put("reason", str11);
                if (!TextUtils.isEmpty(str12)) {
                    Object put6 = hashMap4.put("message", str12);
                }
                this.zzzU.zza("onPrecacheEvent", (Map<String, String>) hashMap4);
            }
        };
        boolean post = handler.post(r6);
    }
}
