package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.zza.C0868zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzb extends zzim implements com.google.android.gms.ads.internal.request.zzc.zza {
    private final Context mContext;
    zzeo zzCf;
    private AdRequestInfoParcel zzCu;
    AdResponseParcel zzGe;
    /* access modifiers changed from: private */
    public Runnable zzGf;
    /* access modifiers changed from: private */
    public final Object zzGg;
    private final C0868zza zzHg;
    /* access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzHh;
    zzit zzHi;
    private final zzan zzyt;

    @zzhb
    static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            int i2 = i;
            super(str);
            this.zzGu = i2;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    public zzb(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza2, zzan zzan, C0868zza zza3) {
        Object obj;
        Context context2 = context;
        com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza4 = zza2;
        zzan zzan2 = zzan;
        C0868zza zza5 = zza3;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzGg = obj2;
        this.zzHg = zza5;
        this.mContext = context2;
        this.zzHh = zza4;
        this.zzyt = zzan2;
    }

    /* access modifiers changed from: private */
    public void zzc(int i, String str) {
        AdResponseParcel adResponseParcel;
        AdRequestInfoParcel adRequestInfoParcel;
        AdRequestInfoParcel adRequestInfoParcel2;
        com.google.android.gms.internal.zzif.zza zza2;
        AdResponseParcel adResponseParcel2;
        int i2 = i;
        String str2 = str;
        if (i2 == 3 || i2 == -1) {
            zzin.zzaJ(str2);
        } else {
            zzin.zzaK(str2);
        }
        if (this.zzGe == null) {
            AdResponseParcel adResponseParcel3 = adResponseParcel2;
            AdResponseParcel adResponseParcel4 = new AdResponseParcel(i2);
            this.zzGe = adResponseParcel3;
        } else {
            AdResponseParcel adResponseParcel5 = adResponseParcel;
            AdResponseParcel adResponseParcel6 = new AdResponseParcel(i2, this.zzGe.zzBU);
            this.zzGe = adResponseParcel5;
        }
        if (this.zzCu != null) {
            adRequestInfoParcel2 = this.zzCu;
        } else {
            AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel;
            AdRequestInfoParcel adRequestInfoParcel4 = new AdRequestInfoParcel(this.zzHh, null, -1);
            adRequestInfoParcel2 = adRequestInfoParcel3;
        }
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        com.google.android.gms.internal.zzif.zza zza4 = new com.google.android.gms.internal.zzif.zza(adRequestInfoParcel2, this.zzGe, this.zzCf, null, i2, -1, this.zzGe.zzHX, null);
        this.zzHg.zza(zza3);
    }

    public void onStop() {
        Object obj = this.zzGg;
        synchronized (obj) {
            try {
                if (this.zzHi != null) {
                    this.zzHi.cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public zzit zza(VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji) {
        return zzc.zza(this.mContext, versionInfoParcel, zzji, this);
    }

    /* access modifiers changed from: protected */
    public AdSizeParcel zzb(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        zza zza2;
        StringBuilder sb;
        zza zza3;
        StringBuilder sb2;
        AdSizeParcel adSizeParcel;
        zza zza4;
        StringBuilder sb3;
        zza zza5;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        if (this.zzGe.zzHW == null) {
            zza zza6 = zza5;
            zza zza7 = new zza("The ad response must specify one of the supported ad sizes.", 0);
            throw zza6;
        }
        String[] split = this.zzGe.zzHW.split("x");
        if (split.length != 2) {
            zza zza8 = zza4;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            zza zza9 = new zza(sb4.append("Invalid ad size format from the ad response: ").append(this.zzGe.zzHW).toString(), 0);
            throw zza8;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            AdSizeParcel[] adSizeParcelArr = adRequestInfoParcel2.zzrp.zzuj;
            int length = adSizeParcelArr.length;
            for (int i = 0; i < length; i++) {
                AdSizeParcel adSizeParcel2 = adSizeParcelArr[i];
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i2 = adSizeParcel2.width == -1 ? (int) (((float) adSizeParcel2.widthPixels) / f) : adSizeParcel2.width;
                int i3 = adSizeParcel2.height == -2 ? (int) (((float) adSizeParcel2.heightPixels) / f) : adSizeParcel2.height;
                if (parseInt == i2 && parseInt2 == i3) {
                    AdSizeParcel adSizeParcel3 = adSizeParcel;
                    AdSizeParcel adSizeParcel4 = new AdSizeParcel(adSizeParcel2, adRequestInfoParcel2.zzrp.zzuj);
                    return adSizeParcel3;
                }
            }
            zza zza10 = zza3;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            zza zza11 = new zza(sb6.append("The ad size from the ad response was not one of the requested sizes: ").append(this.zzGe.zzHW).toString(), 0);
            throw zza10;
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            zza zza12 = zza2;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            zza zza13 = new zza(sb8.append("Invalid ad size number from the ad response: ").append(this.zzGe.zzHW).toString(), 0);
            throw zza12;
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzb(@NonNull AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        com.google.android.gms.internal.zzif.zza zza2;
        JSONObject jSONObject2;
        zza zza3;
        StringBuilder sb;
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        zzin.zzaI("Received ad response.");
        this.zzGe = adResponseParcel2;
        long elapsedRealtime = zzr.zzbG().elapsedRealtime();
        Object obj = this.zzGg;
        synchronized (obj) {
            try {
                this.zzHi = null;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        try {
            if (this.zzGe.errorCode == -2 || this.zzGe.errorCode == -3) {
                zzgq();
                AdSizeParcel adSizeParcel = this.zzCu.zzrp.zzuj != null ? zzb(this.zzCu) : null;
                zzr.zzbF().zzB(this.zzGe.zzId);
                if (!TextUtils.isEmpty(this.zzGe.zzIb)) {
                    try {
                        JSONObject jSONObject3 = jSONObject2;
                        JSONObject jSONObject4 = new JSONObject(this.zzGe.zzIb);
                        jSONObject = jSONObject3;
                    } catch (Exception e) {
                        zzin.zzb("Error parsing the JSON for Active View.", e);
                    }
                    com.google.android.gms.internal.zzif.zza zza4 = zza2;
                    com.google.android.gms.internal.zzif.zza zza5 = new com.google.android.gms.internal.zzif.zza(this.zzCu, this.zzGe, this.zzCf, adSizeParcel, -2, elapsedRealtime, this.zzGe.zzHX, jSONObject);
                    this.zzHg.zza(zza4);
                    zzir.zzMc.removeCallbacks(this.zzGf);
                    return;
                }
                jSONObject = null;
                com.google.android.gms.internal.zzif.zza zza42 = zza2;
                com.google.android.gms.internal.zzif.zza zza52 = new com.google.android.gms.internal.zzif.zza(this.zzCu, this.zzGe, this.zzCf, adSizeParcel, -2, elapsedRealtime, this.zzGe.zzHX, jSONObject);
                this.zzHg.zza(zza42);
                zzir.zzMc.removeCallbacks(this.zzGf);
                return;
            }
            zza zza6 = zza3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zza zza7 = new zza(sb2.append("There was a problem getting an ad response. ErrorCode: ").append(this.zzGe.errorCode).toString(), this.zzGe.errorCode);
            throw zza6;
        } catch (zza e2) {
            zza zza8 = e2;
            zzc(zza8.getErrorCode(), zza8.getMessage());
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    public void zzbr() {
        C01851 r14;
        zzjj zzjj;
        C01862 r142;
        AdRequestInfoParcel adRequestInfoParcel;
        zzin.zzaI("AdLoaderBackgroundTask started.");
        C01851 r8 = r14;
        C01851 r9 = new Runnable(this) {
            final /* synthetic */ zzb zzHj;

            {
                this.zzHj = r5;
            }

            public void run() {
                Object zza = this.zzHj.zzGg;
                synchronized (zza) {
                    try {
                        if (this.zzHj.zzHi != null) {
                            this.zzHj.onStop();
                            this.zzHj.zzc(2, "Timed out waiting for ad response.");
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        this.zzGf = r8;
        boolean postDelayed = zzir.zzMc.postDelayed(this.zzGf, ((Long) zzbt.zzwX.get()).longValue());
        zzjj zzjj2 = zzjj;
        zzjj zzjj3 = new zzjj();
        zzjj zzjj4 = zzjj2;
        long elapsedRealtime = zzr.zzbG().elapsedRealtime();
        C01862 r7 = r142;
        final zzjj zzjj5 = zzjj4;
        C01862 r82 = new Runnable(this) {
            final /* synthetic */ zzb zzHj;

            {
                zzji zzji = r7;
                this.zzHj = r6;
            }

            public void run() {
                Object zza = this.zzHj.zzGg;
                synchronized (zza) {
                    try {
                        this.zzHj.zzHi = this.zzHj.zza(this.zzHj.zzHh.zzrl, zzjj5);
                        if (this.zzHj.zzHi == null) {
                            this.zzHj.zzc(0, "Could not start the ad request service.");
                            zzir.zzMc.removeCallbacks(this.zzHj.zzGf);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        zzjg zza2 = zziq.zza((Runnable) r7);
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        AdRequestInfoParcel adRequestInfoParcel3 = new AdRequestInfoParcel(this.zzHh, this.zzyt.zzab().zzb(this.mContext), elapsedRealtime);
        this.zzCu = adRequestInfoParcel2;
        zzjj4.zzh(this.zzCu);
    }

    /* access modifiers changed from: protected */
    public void zzgq() throws zza {
        zza zza2;
        StringBuilder sb;
        zzeo zzeo;
        zza zza3;
        if (this.zzGe.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzGe.body)) {
                zza zza4 = zza3;
                zza zza5 = new zza("No fill from ad server.", 3);
                throw zza4;
            }
            Future zza6 = zzr.zzbF().zza(this.mContext, this.zzGe.zzHB);
            if (this.zzGe.zzHT) {
                try {
                    zzeo zzeo2 = zzeo;
                    zzeo zzeo3 = new zzeo(this.zzGe.body);
                    this.zzCf = zzeo2;
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    zza zza7 = zza2;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zza zza8 = new zza(sb2.append("Could not parse mediation config: ").append(this.zzGe.body).toString(), 0);
                    throw zza7;
                }
            }
        }
    }
}
