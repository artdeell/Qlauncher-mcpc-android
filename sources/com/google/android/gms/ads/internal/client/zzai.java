package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;

public class zzai implements zzm {
    public zzai() {
    }

    public zzs createAdLoaderBuilder(Context context, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzag zzag;
        Context context2 = context;
        String str2 = str;
        zzew zzew2 = zzew;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzag zzag2 = zzag;
        zzag zzag3 = new zzag();
        return zzag2;
    }

    @Nullable
    public zzfv createAdOverlay(Activity activity) {
        Activity activity2 = activity;
        return null;
    }

    public zzu createBannerAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzah zzah;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        zzew zzew2 = zzew;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzah zzah2 = zzah;
        zzah zzah3 = new zzah();
        return zzah2;
    }

    @Nullable
    public zzge createInAppPurchaseManager(Activity activity) {
        Activity activity2 = activity;
        return null;
    }

    public zzu createInterstitialAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzah zzah;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        zzew zzew2 = zzew;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzah zzah2 = zzah;
        zzah zzah3 = new zzah();
        return zzah2;
    }

    public zzcj createNativeAdViewDelegate(FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzak zzak;
        FrameLayout frameLayout3 = frameLayout;
        FrameLayout frameLayout4 = frameLayout2;
        zzak zzak2 = zzak;
        zzak zzak3 = new zzak();
        return zzak2;
    }

    public zzb createRewardedVideoAd(Context context, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzal zzal;
        Context context2 = context;
        zzew zzew2 = zzew;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzal zzal2 = zzal;
        zzal zzal3 = new zzal();
        return zzal2;
    }

    public zzy getMobileAdsSettingsManager(Context context) {
        zzaj zzaj;
        Context context2 = context;
        zzaj zzaj2 = zzaj;
        zzaj zzaj3 = new zzaj();
        return zzaj2;
    }
}
