package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzes.zza;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzer implements zza {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final String zzCd;
    private final long zzCe;
    private final zzeo zzCf;
    private final zzen zzCg;
    private final AdSizeParcel zzCh;
    /* access modifiers changed from: private */
    public zzey zzCi;
    /* access modifiers changed from: private */
    public int zzCj = -2;
    private zzfa zzCk;
    private final NativeAdOptionsParcel zzpP;
    private final List<String> zzpQ;
    private final VersionInfoParcel zzpT;
    /* access modifiers changed from: private */
    public final Object zzpV;
    private final zzex zzpn;
    private final AdRequestParcel zzqH;
    private final boolean zzsA;
    private final boolean zzuS;

    public zzer(Context context, String str, zzex zzex, zzeo zzeo, zzen zzen, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        Object obj;
        Context context2 = context;
        String str2 = str;
        zzex zzex2 = zzex;
        zzeo zzeo2 = zzeo;
        zzen zzen2 = zzen;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        boolean z3 = z;
        boolean z4 = z2;
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        List<String> list2 = list;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzpn = zzex2;
        this.zzCg = zzen2;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
            this.zzCd = zzey();
        } else {
            this.zzCd = str2;
        }
        this.zzCf = zzeo2;
        this.zzCe = zzeo2.zzBP != -1 ? zzeo2.zzBP : 10000;
        this.zzqH = adRequestParcel2;
        this.zzCh = adSizeParcel2;
        this.zzpT = versionInfoParcel2;
        this.zzsA = z3;
        this.zzuS = z4;
        this.zzpP = nativeAdOptionsParcel2;
        this.zzpQ = list2;
    }

    static /* synthetic */ zzey zza(zzer zzer, zzey zzey) {
        zzey zzey2 = zzey;
        zzer.zzCi = zzey2;
        return zzey2;
    }

    private void zza(long j, long j2, long j3, long j4) {
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        while (this.zzCj == -2) {
            zzb(j5, j6, j7, j8);
        }
    }

    /* access modifiers changed from: private */
    public void zza(zzeq zzeq) {
        NativeAdOptionsParcel nativeAdOptionsParcel;
        Bundle bundle;
        zzeq zzeq2 = zzeq;
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzCd)) {
            Bundle bundle2 = this.zzqH.zztM.getBundle(this.zzCd);
            if (bundle2 == null) {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle();
                bundle2 = bundle3;
            }
            bundle2.putString("sdk_less_network_id", this.zzCg.zzBA);
            this.zzqH.zztM.putBundle(this.zzCd, bundle2);
        }
        String zzac = zzac(this.zzCg.zzBG);
        try {
            if (this.zzpT.zzNa < 4100000) {
                if (this.zzCh.zzui) {
                    this.zzCi.zza(zze.zzC(this.mContext), this.zzqH, zzac, zzeq2);
                } else {
                    this.zzCi.zza(zze.zzC(this.mContext), this.zzCh, this.zzqH, zzac, (zzez) zzeq2);
                }
            } else if (this.zzsA) {
                this.zzCi.zza(zze.zzC(this.mContext), this.zzqH, zzac, this.zzCg.zzBz, zzeq2, this.zzpP, this.zzpQ);
            } else if (this.zzCh.zzui) {
                this.zzCi.zza(zze.zzC(this.mContext), this.zzqH, zzac, this.zzCg.zzBz, (zzez) zzeq2);
            } else if (!this.zzuS) {
                this.zzCi.zza(zze.zzC(this.mContext), this.zzCh, this.zzqH, zzac, this.zzCg.zzBz, zzeq2);
            } else if (this.zzCg.zzBJ != null) {
                zzey zzey = this.zzCi;
                zzd zzC = zze.zzC(this.mContext);
                AdRequestParcel adRequestParcel = this.zzqH;
                String str = zzac;
                String str2 = this.zzCg.zzBz;
                zzeq zzeq3 = zzeq2;
                NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
                NativeAdOptionsParcel nativeAdOptionsParcel3 = new NativeAdOptionsParcel(zzad(this.zzCg.zzBN));
                zzey.zza(zzC, adRequestParcel, str, str2, zzeq3, nativeAdOptionsParcel2, this.zzCg.zzBM);
            } else {
                this.zzCi.zza(zze.zzC(this.mContext), this.zzCh, this.zzqH, zzac, this.zzCg.zzBz, zzeq2);
            }
        } catch (RemoteException e) {
            zzin.zzd("Could not request ad from mediation adapter.", e);
            zzr(5);
        }
    }

    private String zzac(String str) {
        JSONObject jSONObject;
        String str2 = str;
        if (str2 == null || !zzeB() || zzs(2)) {
            return str2;
        }
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(str2);
            JSONObject jSONObject4 = jSONObject2;
            Object remove = jSONObject4.remove("cpm_floor_cents");
            return jSONObject4.toString();
        } catch (JSONException e) {
            JSONException jSONException = e;
            zzin.zzaK("Could not remove field. Returning the original value");
            return str2;
        }
    }

    private static NativeAdOptions zzad(String str) {
        Builder builder;
        JSONObject jSONObject;
        String str2 = str;
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        if (str2 == null) {
            return builder4.build();
        }
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(str2);
            JSONObject jSONObject4 = jSONObject2;
            Builder requestMultipleImages = builder4.setRequestMultipleImages(jSONObject4.optBoolean("multiple_images", false));
            Builder returnUrlsForImageAssets = builder4.setReturnUrlsForImageAssets(jSONObject4.optBoolean("only_urls", false));
            Builder imageOrientation = builder4.setImageOrientation(zzae(jSONObject4.optString("native_image_orientation", "any")));
        } catch (JSONException e) {
            zzin.zzd("Exception occurred when creating native ad options", e);
        }
        return builder4.build();
    }

    private static int zzae(String str) {
        String str2 = str;
        if ("landscape".equals(str2)) {
            return 2;
        }
        return "portrait".equals(str2) ? 1 : 0;
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j9 = j6 - (elapsedRealtime - j5);
        long j10 = j8 - (elapsedRealtime - j7);
        if (j9 <= 0 || j10 <= 0) {
            zzin.zzaJ("Timed out waiting for adapter.");
            this.zzCj = 3;
            return;
        }
        try {
            this.zzpV.wait(Math.min(j9, j10));
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            this.zzCj = -1;
        }
    }

    /* access modifiers changed from: private */
    public zzey zzeA() {
        StringBuilder sb;
        StringBuilder sb2;
        zzfe zzfe;
        AdUrlAdapter adUrlAdapter;
        zzfe zzfe2;
        AdMobAdapter adMobAdapter;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        zzin.zzaJ(sb3.append("Instantiating mediation adapter: ").append(this.zzCd).toString());
        if (((Boolean) zzbt.zzwV.get()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
            zzfe zzfe3 = zzfe2;
            AdMobAdapter adMobAdapter2 = adMobAdapter;
            AdMobAdapter adMobAdapter3 = new AdMobAdapter();
            zzfe zzfe4 = new zzfe(adMobAdapter2);
            return zzfe3;
        } else if (!((Boolean) zzbt.zzwW.get()).booleanValue() || !"com.google.ads.mediation.AdUrlAdapter".equals(this.zzCd)) {
            try {
                return this.zzpn.zzaf(this.zzCd);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                zzin.zza(sb5.append("Could not instantiate mediation adapter: ").append(this.zzCd).toString(), remoteException);
                return null;
            }
        } else {
            zzfe zzfe5 = zzfe;
            AdUrlAdapter adUrlAdapter2 = adUrlAdapter;
            AdUrlAdapter adUrlAdapter3 = new AdUrlAdapter();
            zzfe zzfe6 = new zzfe(adUrlAdapter2);
            return zzfe5;
        }
    }

    /* access modifiers changed from: private */
    public boolean zzeB() {
        return this.zzCf.zzBX != -1;
    }

    private int zzeC() {
        JSONObject jSONObject;
        int i;
        if (this.zzCg.zzBG == null) {
            i = 0;
        } else {
            try {
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject(this.zzCg.zzBG);
                JSONObject jSONObject4 = jSONObject2;
                if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
                    return jSONObject4.optInt("cpm_cents", 0);
                }
                i = zzs(2) ? jSONObject4.optInt("cpm_floor_cents", 0) : 0;
                if (i == 0) {
                    return jSONObject4.optInt("penalized_average_cpm_cents", 0);
                }
            } catch (JSONException e) {
                JSONException jSONException = e;
                zzin.zzaK("Could not convert to json. Returning 0");
                return 0;
            }
        }
        return i;
    }

    private String zzey() {
        try {
            if (!TextUtils.isEmpty(this.zzCg.zzBD)) {
                return this.zzpn.zzag(this.zzCg.zzBD) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzfa zzez() {
        if (this.zzCj != 0 || !zzeB()) {
            return null;
        }
        try {
            if (!(!zzs(4) || this.zzCk == null || this.zzCk.zzeD() == 0)) {
                return this.zzCk;
            }
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Could not get cpm value from MediationResponseMetadata");
        }
        return zzt(zzeC());
    }

    /* access modifiers changed from: private */
    public boolean zzs(int i) {
        int i2 = i;
        try {
            Bundle zzeH = this.zzsA ? this.zzCi.zzeI() : this.zzCh.zzui ? this.zzCi.getInterstitialAdapterInfo() : this.zzCi.zzeH();
            boolean z = false;
            if (zzeH != null) {
                z = (i2 & zzeH.getInt("capabilities", 0)) == i2;
            }
            return z;
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static zzfa zzt(int i) {
        C03522 r4;
        C03522 r1 = r4;
        final int i2 = i;
        C03522 r2 = new zzfa.zza() {
            public int zzeD() throws RemoteException {
                return i2;
            }
        };
        return r1;
    }

    public void cancel() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCi != null) {
                    this.zzCi.destroy();
                }
            } catch (RemoteException e) {
                zzin.zzd("Could not destroy mediation adapter.", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
            this.zzCj = -1;
            this.zzpV.notify();
        }
    }

    public zzes zza(long j, long j2) {
        zzeq zzeq;
        C03511 r23;
        zzes zzes;
        long j3 = j;
        long j4 = j2;
        zzes zzes2 = this.zzpV;
        synchronized (zzes2) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                zzeq zzeq2 = zzeq;
                zzeq zzeq3 = new zzeq();
                zzeq zzeq4 = zzeq2;
                Handler handler = zzir.zzMc;
                C03511 r15 = r23;
                final zzeq zzeq5 = zzeq4;
                C03511 r16 = new Runnable(this) {
                    final /* synthetic */ zzer zzCm;

                    {
                        zzeq zzeq = r7;
                        this.zzCm = r6;
                    }

                    public void run() {
                        StringBuilder sb;
                        Object zza = this.zzCm.zzpV;
                        synchronized (zza) {
                            try {
                                if (this.zzCm.zzCj == -2) {
                                    zzey zza2 = zzer.zza(this.zzCm, this.zzCm.zzeA());
                                    if (this.zzCm.zzCi == null) {
                                        this.zzCm.zzr(4);
                                    } else if (!this.zzCm.zzeB() || this.zzCm.zzs(1)) {
                                        zzeq5.zza((zza) this.zzCm);
                                        this.zzCm.zza(zzeq5);
                                    } else {
                                        StringBuilder sb2 = sb;
                                        StringBuilder sb3 = new StringBuilder();
                                        zzin.zzaK(sb2.append("Ignoring adapter ").append(this.zzCm.zzCd).append(" as delayed").append(" impression is not supported").toString());
                                        this.zzCm.zzr(2);
                                    }
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Object obj = zza;
                                throw th2;
                            }
                        }
                    }
                };
                boolean post = handler.post(r15);
                zza(elapsedRealtime, this.zzCe, j3, j4);
                zzes zzes3 = zzes;
                zzes zzes4 = new zzes(this.zzCg, this.zzCi, this.zzCd, zzeq4, this.zzCj, zzez());
                th = zzes3;
            } finally {
                Throwable th = th;
                zzes zzes5 = zzes2;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zza(int i, zzfa zzfa) {
        int i2 = i;
        zzfa zzfa2 = zzfa;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCj = i2;
                this.zzCk = zzfa2;
                this.zzpV.notify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzr(int i) {
        int i2 = i;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCj = i2;
                this.zzpV.notify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
