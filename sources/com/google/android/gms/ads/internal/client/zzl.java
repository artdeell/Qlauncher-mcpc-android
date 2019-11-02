package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzl {
    public static String zzuq = null;
    private zzm zzup;

    public zzl() {
        zzai zzai;
        zzai zzai2;
        ClientApi.retainReference();
        if (zzuq != null) {
            try {
                this.zzup = (zzm) zzl.class.getClassLoader().loadClass(zzuq).newInstance();
            } catch (Exception e) {
                zzb.zzd("Failed to instantiate ClientApi class.", e);
                zzai zzai3 = zzai2;
                zzai zzai4 = new zzai();
                this.zzup = zzai3;
            }
        } else {
            zzb.zzaK("No client jar implementation found.");
            zzai zzai5 = zzai;
            zzai zzai6 = new zzai();
            this.zzup = zzai5;
        }
    }

    public zzs createAdLoaderBuilder(Context context, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        return this.zzup.createAdLoaderBuilder(context, str, zzew, versionInfoParcel);
    }

    @Nullable
    public zzfv createAdOverlay(Activity activity) {
        return this.zzup.createAdOverlay(activity);
    }

    public zzu createBannerAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        return this.zzup.createBannerAdManager(context, adSizeParcel, str, zzew, versionInfoParcel);
    }

    @Nullable
    public zzge createInAppPurchaseManager(Activity activity) {
        return this.zzup.createInAppPurchaseManager(activity);
    }

    public zzu createInterstitialAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        return this.zzup.createInterstitialAdManager(context, adSizeParcel, str, zzew, versionInfoParcel);
    }

    public zzcj createNativeAdViewDelegate(FrameLayout frameLayout, FrameLayout frameLayout2) {
        return this.zzup.createNativeAdViewDelegate(frameLayout, frameLayout2);
    }

    public com.google.android.gms.ads.internal.reward.client.zzb createRewardedVideoAd(Context context, zzew zzew, VersionInfoParcel versionInfoParcel) {
        return this.zzup.createRewardedVideoAd(context, zzew, versionInfoParcel);
    }

    public zzy getMobileAdsSettingsManager(Context context) {
        return this.zzup.getMobileAdsSettingsManager(context);
    }
}
