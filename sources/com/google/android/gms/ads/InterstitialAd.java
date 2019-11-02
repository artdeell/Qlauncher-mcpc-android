package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public final class InterstitialAd {
    private final zzac zzoL;

    public InterstitialAd(Context context) {
        zzac zzac;
        zzac zzac2 = zzac;
        zzac zzac3 = new zzac(context);
        this.zzoL = zzac2;
    }

    public AdListener getAdListener() {
        return this.zzoL.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzoL.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzoL.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoL.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zzoL.isLoaded();
    }

    public boolean isLoading() {
        return this.zzoL.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzoL.zza(adRequest.zzaE());
    }

    public void setAdListener(AdListener adListener) {
        AdListener adListener2 = adListener;
        this.zzoL.setAdListener(adListener2);
        if (adListener2 != null && (adListener2 instanceof zza)) {
            this.zzoL.zza((zza) adListener2);
        } else if (adListener2 == null) {
            this.zzoL.zza((zza) null);
        }
    }

    public void setAdUnitId(String str) {
        String str2 = str;
        this.zzoL.setAdUnitId(str2);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        InAppPurchaseListener inAppPurchaseListener2 = inAppPurchaseListener;
        this.zzoL.setInAppPurchaseListener(inAppPurchaseListener2);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        PlayStorePurchaseListener playStorePurchaseListener2 = playStorePurchaseListener;
        String str2 = str;
        this.zzoL.setPlayStorePurchaseParams(playStorePurchaseListener2, str2);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        RewardedVideoAdListener rewardedVideoAdListener2 = rewardedVideoAdListener;
        this.zzoL.setRewardedVideoAdListener(rewardedVideoAdListener2);
    }

    public void show() {
        this.zzoL.show();
    }

    public void zza(boolean z) {
        boolean z2 = z;
        this.zzoL.zza(z2);
    }

    public void zzm(String str) {
        String str2 = str;
        this.zzoL.setUserId(str2);
    }
}
