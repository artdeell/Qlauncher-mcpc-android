package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzey.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzhb
public final class zzfj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzCO;
    private final NETWORK_EXTRAS zzCP;

    public zzfj(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        NETWORK_EXTRAS network_extras2 = network_extras;
        this.zzCO = mediationAdapter;
        this.zzCP = network_extras2;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        HashMap hashMap2;
        RemoteException remoteException;
        JSONObject jSONObject;
        HashMap hashMap3;
        String str3 = str;
        int i2 = i;
        String str4 = str2;
        if (str3 != null) {
            try {
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject(str3);
                JSONObject jSONObject4 = jSONObject2;
                HashMap hashMap4 = hashMap3;
                HashMap hashMap5 = new HashMap(jSONObject4.length());
                hashMap = hashMap4;
                Iterator keys = jSONObject4.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    Object put = hashMap.put(str5, jSONObject4.getString(str5));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                RemoteException remoteException2 = remoteException;
                RemoteException remoteException3 = new RemoteException();
                throw remoteException2;
            }
        } else {
            HashMap hashMap6 = hashMap2;
            HashMap hashMap7 = new HashMap(0);
            hashMap = hashMap6;
        }
        Class serverParametersType = this.zzCO.getServerParametersType();
        SERVER_PARAMETERS server_parameters = null;
        if (serverParametersType != null) {
            server_parameters = (MediationServerParameters) serverParametersType.newInstance();
            server_parameters.load(hashMap);
        }
        return server_parameters;
    }

    public void destroy() throws RemoteException {
        RemoteException remoteException;
        try {
            this.zzCO.destroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException2 = remoteException;
            RemoteException remoteException3 = new RemoteException();
            throw remoteException2;
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        Bundle bundle;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return bundle2;
    }

    public zzd getView() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationBannerAdapter: ").append(this.zzCO.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        try {
            return zze.zzC(((MediationBannerAdapter) this.zzCO).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() throws RemoteException {
        RemoteException remoteException;
        RemoteException remoteException2 = remoteException;
        RemoteException remoteException3 = new RemoteException();
        throw remoteException2;
    }

    public void resume() throws RemoteException {
        RemoteException remoteException;
        RemoteException remoteException2 = remoteException;
        RemoteException remoteException3 = new RemoteException();
        throw remoteException2;
    }

    public void showInterstitial() throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        RemoteException remoteException2;
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationInterstitialAdapter: ").append(this.zzCO.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCO).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza, String str2) throws RemoteException {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        RemoteException remoteException;
        zzfk zzfk;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        zzez zzez2 = zzez;
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationInterstitialAdapter: ").append(this.zzCO.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzCO;
            zzfk zzfk2 = zzfk;
            zzfk zzfk3 = new zzfk(zzez2);
            mediationInterstitialAdapter.requestInterstitialAd(zzfk2, (Activity) zze.zzp(zzd2), zzb(str3, adRequestParcel2.zztG, str4), zzfl.zzj(adRequestParcel2), this.zzCP);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adSizeParcel, adRequestParcel, str, null, zzez);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        RemoteException remoteException;
        zzfk zzfk;
        StringBuilder sb;
        RemoteException remoteException2;
        zzd zzd2 = zzd;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str3 = str;
        String str4 = str2;
        zzez zzez2 = zzez;
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("MediationAdapter is not a MediationBannerAdapter: ").append(this.zzCO.getClass().getCanonicalName()).toString());
            RemoteException remoteException3 = remoteException2;
            RemoteException remoteException4 = new RemoteException();
            throw remoteException3;
        }
        zzb.zzaI("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzCO;
            zzfk zzfk2 = zzfk;
            zzfk zzfk3 = new zzfk(zzez2);
            mediationBannerAdapter.requestBannerAd(zzfk2, (Activity) zze.zzp(zzd2), zzb(str3, adRequestParcel2.zztG, str4), zzfl.zzb(adSizeParcel2), zzfl.zzj(adRequestParcel2), this.zzCP);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            RemoteException remoteException5 = remoteException;
            RemoteException remoteException6 = new RemoteException();
            throw remoteException5;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, String str) {
    }

    public zzfb zzeF() {
        return null;
    }

    public zzfc zzeG() {
        return null;
    }

    public Bundle zzeH() {
        Bundle bundle;
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
