package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzin;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzOq;
    CustomEventInterstitial zzOr;
    CustomEventNative zzOs;
    private View zzbk;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzOt;
        private final MediationBannerListener zzbc;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            MediationBannerListener mediationBannerListener2 = mediationBannerListener;
            this.zzOt = customEventAdapter;
            this.zzbc = mediationBannerListener2;
        }

        public void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbc.onAdClicked(this.zzOt);
        }

        public void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbc.onAdClosed(this.zzOt);
        }

        public void onAdFailedToLoad(int i) {
            int i2 = i;
            zzin.zzaI("Custom event adapter called onAdFailedToLoad.");
            this.zzbc.onAdFailedToLoad(this.zzOt, i2);
        }

        public void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbc.onAdLeftApplication(this.zzOt);
        }

        public void onAdLoaded(View view) {
            View view2 = view;
            zzin.zzaI("Custom event adapter called onAdLoaded.");
            this.zzOt.zza(view2);
            this.zzbc.onAdLoaded(this.zzOt);
        }

        public void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbc.onAdOpened(this.zzOt);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzOt;
        final /* synthetic */ CustomEventAdapter zzOu;
        private final MediationInterstitialListener zzbd;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            CustomEventAdapter customEventAdapter3 = customEventAdapter2;
            MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
            this.zzOu = customEventAdapter;
            this.zzOt = customEventAdapter3;
            this.zzbd = mediationInterstitialListener2;
        }

        public void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbd.onAdClicked(this.zzOt);
        }

        public void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbd.onAdClosed(this.zzOt);
        }

        public void onAdFailedToLoad(int i) {
            int i2 = i;
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbd.onAdFailedToLoad(this.zzOt, i2);
        }

        public void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbd.onAdLeftApplication(this.zzOt);
        }

        public void onAdLoaded() {
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbd.onAdLoaded(this.zzOu);
        }

        public void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbd.onAdOpened(this.zzOt);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzOt;
        private final MediationNativeListener zzbe;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            MediationNativeListener mediationNativeListener2 = mediationNativeListener;
            this.zzOt = customEventAdapter;
            this.zzbe = mediationNativeListener2;
        }

        public void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbe.onAdClicked(this.zzOt);
        }

        public void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbe.onAdClosed(this.zzOt);
        }

        public void onAdFailedToLoad(int i) {
            int i2 = i;
            zzin.zzaI("Custom event adapter called onAdFailedToLoad.");
            this.zzbe.onAdFailedToLoad(this.zzOt, i2);
        }

        public void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbe.onAdLeftApplication(this.zzOt);
        }

        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            NativeAdMapper nativeAdMapper2 = nativeAdMapper;
            zzin.zzaI("Custom event adapter called onAdLoaded.");
            this.zzbe.onAdLoaded(this.zzOt, nativeAdMapper2);
        }

        public void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbe.onAdOpened(this.zzOt);
        }
    }

    public CustomEventAdapter() {
    }

    /* access modifiers changed from: private */
    public void zza(View view) {
        View view2 = view;
        this.zzbk = view2;
    }

    private static <T> T zzj(String str) {
        StringBuilder sb;
        String str2 = str;
        try {
            return Class.forName(str2).newInstance();
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Could not instantiate custom event adapter: ").append(str2).append(". ").append(th2.getMessage()).toString());
            return null;
        }
    }

    public View getBannerView() {
        return this.zzbk;
    }

    public void onDestroy() {
        if (this.zzOq != null) {
            this.zzOq.onDestroy();
        }
        if (this.zzOr != null) {
            this.zzOr.onDestroy();
        }
        if (this.zzOs != null) {
            this.zzOs.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzOq != null) {
            this.zzOq.onPause();
        }
        if (this.zzOr != null) {
            this.zzOr.onPause();
        }
        if (this.zzOs != null) {
            this.zzOs.onPause();
        }
    }

    public void onResume() {
        if (this.zzOq != null) {
            this.zzOq.onResume();
        }
        if (this.zzOr != null) {
            this.zzOr.onResume();
        }
        if (this.zzOs != null) {
            this.zzOs.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        zza zza2;
        Context context2 = context;
        MediationBannerListener mediationBannerListener2 = mediationBannerListener;
        Bundle bundle3 = bundle;
        AdSize adSize2 = adSize;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle4 = bundle2;
        this.zzOq = (CustomEventBanner) zzj(bundle3.getString("class_name"));
        if (this.zzOq == null) {
            mediationBannerListener2.onAdFailedToLoad(this, 0);
            return;
        }
        Bundle bundle5 = bundle4 == null ? null : bundle4.getBundle(bundle3.getString("class_name"));
        CustomEventBanner customEventBanner = this.zzOq;
        Context context3 = context2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, mediationBannerListener2);
        customEventBanner.requestBannerAd(context3, zza3, bundle3.getString("parameter"), adSize2, mediationAdRequest2, bundle5);
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Context context2 = context;
        MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
        Bundle bundle3 = bundle;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle4 = bundle2;
        this.zzOr = (CustomEventInterstitial) zzj(bundle3.getString("class_name"));
        if (this.zzOr == null) {
            mediationInterstitialListener2.onAdFailedToLoad(this, 0);
        } else {
            this.zzOr.requestInterstitialAd(context2, zza(mediationInterstitialListener2), bundle3.getString("parameter"), mediationAdRequest2, bundle4 == null ? null : bundle4.getBundle(bundle3.getString("class_name")));
        }
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zzc zzc2;
        Context context2 = context;
        MediationNativeListener mediationNativeListener2 = mediationNativeListener;
        Bundle bundle3 = bundle;
        NativeMediationAdRequest nativeMediationAdRequest2 = nativeMediationAdRequest;
        Bundle bundle4 = bundle2;
        this.zzOs = (CustomEventNative) zzj(bundle3.getString("class_name"));
        if (this.zzOs == null) {
            mediationNativeListener2.onAdFailedToLoad(this, 0);
            return;
        }
        Bundle bundle5 = bundle4 == null ? null : bundle4.getBundle(bundle3.getString("class_name"));
        CustomEventNative customEventNative = this.zzOs;
        Context context3 = context2;
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(this, mediationNativeListener2);
        customEventNative.requestNativeAd(context3, zzc3, bundle3.getString("parameter"), nativeMediationAdRequest2, bundle5);
    }

    public void showInterstitial() {
        this.zzOr.showInterstitial();
    }

    /* access modifiers changed from: 0000 */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        zzb zzb2;
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(this, this, mediationInterstitialListener);
        return zzb3;
    }
}
