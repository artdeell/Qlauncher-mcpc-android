package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzey.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzhb
public final class zzfe extends zza {
    private final MediationAdapter zzCI;
    private zzff zzCJ;

    public zzfe(MediationAdapter mediationAdapter) {
        this.zzCI = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        StringBuilder sb;
        RemoteException remoteException;
        Bundle bundle;
        JSONObject jSONObject;
        Bundle bundle2;
        String str3 = str;
        int i2 = i;
        String str4 = str2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzb.zzaK(sb2.append("Server parameters: ").append(str3).toString());
        try {
            Bundle bundle3 = bundle;
            Bundle bundle4 = new Bundle();
            Bundle bundle5 = bundle3;
            if (str3 != null) {
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject(str3);
                JSONObject jSONObject4 = jSONObject2;
                Bundle bundle6 = bundle2;
                Bundle bundle7 = new Bundle();
                Bundle bundle8 = bundle6;
                Iterator keys = jSONObject4.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    bundle8.putString(str5, jSONObject4.getString(str5));
                }
                bundle5 = bundle8;
            }
            if (this.zzCI instanceof AdMobAdapter) {
                bundle5.putString("adJson", str4);
                bundle5.putInt("tagForChildDirectedTreatment", i2);
            }
            return bundle5;
        } catch (Throwable th) {
            zzb.zzd("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException2 = remoteException;
            RemoteException remoteException3 = new RemoteException();
            throw remoteException2;
        }
    }

    public void destroy() throws RemoteException {
        RemoteException remoteException;
        try {
            this.zzCI.onDestroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException2 = remoteException;
            RemoteException remoteException3 = new RemoteException();
            throw remoteException2;
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        StringBuilder sb;
        Bundle bundle;
        if (this.zzCI instanceof zzka) {
            return ((zzka) this.zzCI).getInterstitialAdapterInfo();
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzb.zzaK(sb2.append("MediationAdapter is not a v2 MediationInterstitialAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return bundle2;
    }

    public zzd getView() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationBannerAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        try {
            return zze.zzC(((MediationBannerAdapter) this.zzCI).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public boolean isInitialized() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzCI).isInitialized();
        } catch (Throwable th) {
            zzb.zzd("Could not check if adapter is initialized.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void pause() throws RemoteException {
        RemoteException remoteException;
        try {
            this.zzCI.onPause();
        } catch (Throwable th) {
            zzb.zzd("Could not pause adapter.", th);
            RemoteException remoteException2 = remoteException;
            RemoteException remoteException3 = new RemoteException();
            throw remoteException2;
        }
    }

    public void resume() throws RemoteException {
        RemoteException remoteException;
        try {
            this.zzCI.onResume();
        } catch (Throwable th) {
            zzb.zzd("Could not resume adapter.", th);
            RemoteException remoteException2 = remoteException;
            RemoteException remoteException3 = new RemoteException();
            throw remoteException2;
        }
    }

    public void showInterstitial() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationInterstitialAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCI).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void showVideo() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzCI).showVideo();
        } catch (Throwable th) {
            zzb.zzd("Could not show rewarded video ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
        RemoteException remoteException;
        HashSet hashSet;
        Date date;
        Date date2;
        zzfd zzfd;
        HashSet hashSet2;
        StringBuilder sb;
        RemoteException remoteException2;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            if (adRequestParcel2.zztE != null) {
                HashSet hashSet3 = hashSet2;
                HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
                hashSet = hashSet3;
            } else {
                hashSet = null;
            }
            if (adRequestParcel2.zztC == -1) {
                date2 = null;
            } else {
                Date date3 = date;
                Date date4 = new Date(adRequestParcel2.zztC);
                date2 = date3;
            }
            zzfd zzfd2 = zzfd;
            zzfd zzfd3 = new zzfd(date2, adRequestParcel2.zztD, hashSet, adRequestParcel2.zztK, adRequestParcel2.zztF, adRequestParcel2.zztG, adRequestParcel2.zztR);
            mediationRewardedVideoAdAdapter.loadAd(zzfd2, zza(str3, adRequestParcel2.zztG, str4), adRequestParcel2.zztM != null ? adRequestParcel2.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not load rewarded video ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza, String str2) throws RemoteException {
        RemoteException remoteException;
        HashSet hashSet;
        Date date;
        Date date2;
        zzfd zzfd;
        com.google.android.gms.ads.internal.reward.mediation.client.zzb zzb;
        HashSet hashSet2;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        com.google.android.gms.ads.internal.reward.mediation.client.zza zza2 = zza;
        String str4 = str2;
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            if (adRequestParcel2.zztE != null) {
                HashSet hashSet3 = hashSet2;
                HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
                hashSet = hashSet3;
            } else {
                hashSet = null;
            }
            if (adRequestParcel2.zztC == -1) {
                date2 = null;
            } else {
                Date date3 = date;
                Date date4 = new Date(adRequestParcel2.zztC);
                date2 = date3;
            }
            zzfd zzfd2 = zzfd;
            zzfd zzfd3 = new zzfd(date2, adRequestParcel2.zztD, hashSet, adRequestParcel2.zztK, adRequestParcel2.zztF, adRequestParcel2.zztG, adRequestParcel2.zztR);
            zzfd zzfd4 = zzfd2;
            Bundle bundle = adRequestParcel2.zztM != null ? adRequestParcel2.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter2 = mediationRewardedVideoAdAdapter;
            Context context = (Context) zze.zzp(zzd2);
            zzfd zzfd5 = zzfd4;
            String str5 = str3;
            com.google.android.gms.ads.internal.reward.mediation.client.zzb zzb2 = zzb;
            com.google.android.gms.ads.internal.reward.mediation.client.zzb zzb3 = new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zza2);
            mediationRewardedVideoAdAdapter2.initialize(context, zzfd5, str5, zzb2, zza(str4, adRequestParcel2.zztG, (String) null), bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not initialize rewarded video adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        RemoteException remoteException;
        HashSet hashSet;
        Date date;
        Date date2;
        zzfd zzfd;
        zzff zzff;
        HashSet hashSet2;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        zzez zzez2 = zzez;
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationInterstitialAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzCI;
            if (adRequestParcel2.zztE != null) {
                HashSet hashSet3 = hashSet2;
                HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
                hashSet = hashSet3;
            } else {
                hashSet = null;
            }
            if (adRequestParcel2.zztC == -1) {
                date2 = null;
            } else {
                Date date3 = date;
                Date date4 = new Date(adRequestParcel2.zztC);
                date2 = date3;
            }
            zzfd zzfd2 = zzfd;
            zzfd zzfd3 = new zzfd(date2, adRequestParcel2.zztD, hashSet, adRequestParcel2.zztK, adRequestParcel2.zztF, adRequestParcel2.zztG, adRequestParcel2.zztR);
            zzfd zzfd4 = zzfd2;
            Bundle bundle = adRequestParcel2.zztM != null ? adRequestParcel2.zztM.getBundle(mediationInterstitialAdapter.getClass().getName()) : null;
            MediationInterstitialAdapter mediationInterstitialAdapter2 = mediationInterstitialAdapter;
            Context context = (Context) zze.zzp(zzd2);
            zzff zzff2 = zzff;
            zzff zzff3 = new zzff(zzez2);
            mediationInterstitialAdapter2.requestInterstitialAd(context, zzff2, zza(str3, adRequestParcel2.zztG, str4), zzfd4, bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        RemoteException remoteException;
        HashSet hashSet;
        Date date;
        Date date2;
        zzfi zzfi;
        zzff zzff;
        HashSet hashSet2;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        zzez zzez2 = zzez;
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        List<String> list2 = list;
        if (!(this.zzCI instanceof MediationNativeAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationNativeAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzCI;
            if (adRequestParcel2.zztE != null) {
                HashSet hashSet3 = hashSet2;
                HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
                hashSet = hashSet3;
            } else {
                hashSet = null;
            }
            if (adRequestParcel2.zztC == -1) {
                date2 = null;
            } else {
                Date date3 = date;
                Date date4 = new Date(adRequestParcel2.zztC);
                date2 = date3;
            }
            zzfi zzfi2 = zzfi;
            zzfi zzfi3 = new zzfi(date2, adRequestParcel2.zztD, hashSet, adRequestParcel2.zztK, adRequestParcel2.zztF, adRequestParcel2.zztG, nativeAdOptionsParcel2, list2, adRequestParcel2.zztR);
            zzfi zzfi4 = zzfi2;
            Bundle bundle = adRequestParcel2.zztM != null ? adRequestParcel2.zztM.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            zzff zzff2 = zzff;
            zzff zzff3 = new zzff(zzez2);
            this.zzCJ = zzff2;
            mediationNativeAdapter.requestNativeAd((Context) zze.zzp(zzd2), this.zzCJ, zza(str3, adRequestParcel2.zztG, str4), zzfi4, bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not request native ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adSizeParcel, adRequestParcel, str, null, zzez);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        RemoteException remoteException;
        HashSet hashSet;
        Date date;
        Date date2;
        zzfd zzfd;
        zzff zzff;
        HashSet hashSet2;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        zzez zzez2 = zzez;
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationBannerAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzCI;
            if (adRequestParcel2.zztE != null) {
                HashSet hashSet3 = hashSet2;
                HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
                hashSet = hashSet3;
            } else {
                hashSet = null;
            }
            if (adRequestParcel2.zztC == -1) {
                date2 = null;
            } else {
                Date date3 = date;
                Date date4 = new Date(adRequestParcel2.zztC);
                date2 = date3;
            }
            zzfd zzfd2 = zzfd;
            zzfd zzfd3 = new zzfd(date2, adRequestParcel2.zztD, hashSet, adRequestParcel2.zztK, adRequestParcel2.zztF, adRequestParcel2.zztG, adRequestParcel2.zztR);
            zzfd zzfd4 = zzfd2;
            Bundle bundle = adRequestParcel2.zztM != null ? adRequestParcel2.zztM.getBundle(mediationBannerAdapter.getClass().getName()) : null;
            MediationBannerAdapter mediationBannerAdapter2 = mediationBannerAdapter;
            Context context = (Context) zze.zzp(zzd2);
            zzff zzff2 = zzff;
            zzff zzff3 = new zzff(zzez2);
            mediationBannerAdapter2.requestBannerAd(context, zzff2, zza(str3, adRequestParcel2.zztG, str4), com.google.android.gms.ads.zza.zza(adSizeParcel2.width, adSizeParcel2.height, adSizeParcel2.zzuh), zzfd4, bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        zza(adRequestParcel, str, (String) null);
    }

    public zzfb zzeF() {
        zzfg zzfg;
        NativeAdMapper zzeJ = this.zzCJ.zzeJ();
        if (!(zzeJ instanceof NativeAppInstallAdMapper)) {
            return null;
        }
        zzfg zzfg2 = zzfg;
        zzfg zzfg3 = new zzfg((NativeAppInstallAdMapper) zzeJ);
        return zzfg2;
    }

    public zzfc zzeG() {
        zzfh zzfh;
        NativeAdMapper zzeJ = this.zzCJ.zzeJ();
        if (!(zzeJ instanceof NativeContentAdMapper)) {
            return null;
        }
        zzfh zzfh2 = zzfh;
        zzfh zzfh3 = new zzfh((NativeContentAdMapper) zzeJ);
        return zzfh2;
    }

    public Bundle zzeH() {
        StringBuilder sb;
        Bundle bundle;
        if (this.zzCI instanceof zzjz) {
            return ((zzjz) this.zzCI).zzeH();
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzb.zzaK(sb2.append("MediationAdapter is not a v2 MediationBannerAdapter: ").append(this.zzCI.getClass().getCanonicalName()).toString());
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return bundle2;
    }

    public Bundle zzeI() {
        Bundle bundle;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return bundle2;
    }
}
