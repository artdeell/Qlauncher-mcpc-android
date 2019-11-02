package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzif.zza;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzhb
public class zzp extends zzb {
    public zzp(Context context, zzd zzd, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
    }

    private static zzd zza(zzfb zzfb) throws RemoteException {
        zzd zzd;
        zzfb zzfb2 = zzfb;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(zzfb2.getHeadline(), zzfb2.getImages(), zzfb2.getBody(), zzfb2.zzdK() != null ? zzfb2.zzdK() : null, zzfb2.getCallToAction(), zzfb2.getStarRating(), zzfb2.getStore(), zzfb2.getPrice(), null, zzfb2.getExtras());
        return zzd2;
    }

    private static zze zza(zzfc zzfc) throws RemoteException {
        zze zze;
        zzfc zzfc2 = zzfc;
        zze zze2 = zze;
        zze zze3 = new zze(zzfc2.getHeadline(), zzfc2.getImages(), zzfc2.getBody(), zzfc2.zzdO() != null ? zzfc2.zzdO() : null, zzfc2.getCallToAction(), zzfc2.getAdvertiser(), null, zzfc2.getExtras());
        return zze2;
    }

    private void zza(zzd zzd) {
        C02102 r7;
        zzd zzd2 = zzd;
        Handler handler = zzir.zzMc;
        C02102 r3 = r7;
        final zzd zzd3 = zzd2;
        C02102 r4 = new Runnable(this) {
            final /* synthetic */ zzp zzqC;

            {
                zzd zzd = r7;
                this.zzqC = r6;
            }

            public void run() {
                try {
                    this.zzqC.zzpj.zzrz.zza(zzd3);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        };
        boolean post = handler.post(r3);
    }

    private void zza(zze zze) {
        C02113 r7;
        zze zze2 = zze;
        Handler handler = zzir.zzMc;
        C02113 r3 = r7;
        final zze zze3 = zze2;
        C02113 r4 = new Runnable(this) {
            final /* synthetic */ zzp zzqC;

            {
                zze zze = r7;
                this.zzqC = r6;
            }

            public void run() {
                try {
                    this.zzqC.zzpj.zzrA.zza(zze3);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        };
        boolean post = handler.post(r3);
    }

    private void zza(zzif zzif, String str) {
        C02124 r9;
        zzif zzif2 = zzif;
        String str2 = str;
        Handler handler = zzir.zzMc;
        C02124 r4 = r9;
        final String str3 = str2;
        final zzif zzif3 = zzif2;
        C02124 r5 = new Runnable(this) {
            final /* synthetic */ zzp zzqC;

            {
                String str = r8;
                zzif zzif = r9;
                this.zzqC = r7;
            }

            public void run() {
                try {
                    ((zzcu) this.zzqC.zzpj.zzrC.get(str3)).zza((zzf) zzif3.zzLa);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        };
        boolean post = handler.post(r4);
    }

    public void pause() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Native Ad DOES NOT support pause().");
        throw illegalStateException2;
    }

    public void resume() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Native Ad DOES NOT support resume().");
        throw illegalStateException2;
    }

    public void showInterstitial() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
        throw illegalStateException2;
    }

    public void zza(SimpleArrayMap<String, zzcu> simpleArrayMap) {
        SimpleArrayMap<String, zzcu> simpleArrayMap2 = simpleArrayMap;
        zzx.zzcD("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzpj.zzrC = simpleArrayMap2;
    }

    public void zza(zzh zzh) {
        zzh zzh2 = zzh;
        if (this.zzpj.zzrq.zzKT != null) {
            zzau zza = zzr.zzbF().zzhh().zza(this.zzpj.zzrp, this.zzpj.zzrq, zzh2);
        }
    }

    public void zza(zzcf zzcf) {
        IllegalStateException illegalStateException;
        zzcf zzcf2 = zzcf;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
        throw illegalStateException2;
    }

    public void zza(zzgd zzgd) {
        IllegalStateException illegalStateException;
        zzgd zzgd2 = zzgd;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
        throw illegalStateException2;
    }

    public void zza(zza zza, zzcb zzcb) {
        StringBuilder sb;
        C02091 r13;
        zza zza2 = zza;
        zzcb zzcb2 = zzcb;
        if (zza2.zzrp != null) {
            this.zzpj.zzrp = zza2.zzrp;
        }
        if (zza2.errorCode != -2) {
            Handler handler = zzir.zzMc;
            C02091 r4 = r13;
            final zza zza3 = zza2;
            C02091 r5 = new Runnable(this) {
                final /* synthetic */ zzp zzqC;

                {
                    zza zza = r7;
                    this.zzqC = r6;
                }

                public void run() {
                    zzif zzif;
                    zzp zzp = this.zzqC;
                    zzif zzif2 = zzif;
                    zzif zzif3 = new zzif(zza3, null, null, null, null, null, null);
                    zzp.zzb(zzif2);
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this, zza2, this.zzpj.zzrk, null, this.zzpn, this, zzcb2);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("AdRenderer: ").append(this.zzpj.zzro.getClass().getName()).toString());
    }

    public void zza(List<String> list) {
        List<String> list2 = list;
        zzx.zzcD("setNativeTemplates must be called on the main UI thread.");
        this.zzpj.zzrH = list2;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzif zzif, boolean z) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzif zzif2 = zzif;
        boolean z2 = z;
        return this.zzpi.zzbw();
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzif zzif, zzif zzif2) {
        zzg zzg;
        zzg zzg2;
        IllegalStateException illegalStateException;
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        zza(null);
        if (!this.zzpj.zzbW()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
            throw illegalStateException2;
        }
        if (zzif4.zzHT) {
            try {
                zzfb zzeF = zzif4.zzCq.zzeF();
                zzfc zzeG = zzif4.zzCq.zzeG();
                if (zzeF != null) {
                    zzd zza = zza(zzeF);
                    zzd zzd = zza;
                    zzg zzg3 = zzg2;
                    zzg zzg4 = new zzg(this.zzpj.context, this, this.zzpj.zzrk, zzeF);
                    zzd.zzb(zzg3);
                    zza(zza);
                } else if (zzeG != null) {
                    zze zza2 = zza(zzeG);
                    zze zze = zza2;
                    zzg zzg5 = zzg;
                    zzg zzg6 = new zzg(this.zzpj.context, this, this.zzpj.zzrk, zzeG);
                    zze.zzb(zzg5);
                    zza(zza2);
                } else {
                    zzin.zzaK("No matching mapper for retrieved native ad template.");
                    zzf(0);
                    return false;
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to get native ad mapper", e);
            }
        } else {
            zzh.zza zza3 = zzif4.zzLa;
            if ((zza3 instanceof zze) && this.zzpj.zzrA != null) {
                zza((zze) zzif4.zzLa);
            } else if ((zza3 instanceof zzd) && this.zzpj.zzrz != null) {
                zza((zzd) zzif4.zzLa);
            } else if (!(zza3 instanceof zzf) || this.zzpj.zzrC == null || this.zzpj.zzrC.get(((zzf) zza3).getCustomTemplateId()) == null) {
                zzin.zzaK("No matching listener for retrieved native ad template.");
                zzf(0);
                return false;
            } else {
                zza(zzif4, ((zzf) zza3).getCustomTemplateId());
            }
        }
        return super.zza(zzif3, zzif4);
    }

    public void zzb(SimpleArrayMap<String, zzct> simpleArrayMap) {
        SimpleArrayMap<String, zzct> simpleArrayMap2 = simpleArrayMap;
        zzx.zzcD("setOnCustomClickListener must be called on the main UI thread.");
        this.zzpj.zzrB = simpleArrayMap2;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        zzx.zzcD("setNativeAdOptions must be called on the main UI thread.");
        this.zzpj.zzrD = nativeAdOptionsParcel2;
    }

    public void zzb(zzcr zzcr) {
        zzcr zzcr2 = zzcr;
        zzx.zzcD("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrz = zzcr2;
    }

    public void zzb(zzcs zzcs) {
        zzcs zzcs2 = zzcs;
        zzx.zzcD("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrA = zzcs2;
    }

    public SimpleArrayMap<String, zzcu> zzbv() {
        zzx.zzcD("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzpj.zzrC;
    }

    public zzct zzs(String str) {
        String str2 = str;
        zzx.zzcD("getOnCustomClickListener must be called on the main UI thread.");
        return (zzct) this.zzpj.zzrB.get(str2);
    }
}
