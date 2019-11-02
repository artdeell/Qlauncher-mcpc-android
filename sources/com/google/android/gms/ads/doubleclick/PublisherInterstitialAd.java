package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzac;

public final class PublisherInterstitialAd {
    private final zzac zzoL;

    public PublisherInterstitialAd(Context context) {
        zzac zzac;
        zzac zzac2 = zzac;
        zzac zzac3 = new zzac(context, this);
        this.zzoL = zzac2;
    }

    public AdListener getAdListener() {
        return this.zzoL.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzoL.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzoL.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoL.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzoL.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.zzoL.isLoaded();
    }

    public boolean isLoading() {
        return this.zzoL.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzoL.zza(publisherAdRequest.zzaE());
    }

    public void setAdListener(AdListener adListener) {
        AdListener adListener2 = adListener;
        this.zzoL.setAdListener(adListener2);
    }

    public void setAdUnitId(String str) {
        String str2 = str;
        this.zzoL.setAdUnitId(str2);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        AppEventListener appEventListener2 = appEventListener;
        this.zzoL.setAppEventListener(appEventListener2);
    }

    public void setCorrelator(Correlator correlator) {
        Correlator correlator2 = correlator;
        this.zzoL.setCorrelator(correlator2);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener2 = onCustomRenderedAdLoadedListener;
        this.zzoL.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener2);
    }

    public void show() {
        this.zzoL.show();
    }
}
