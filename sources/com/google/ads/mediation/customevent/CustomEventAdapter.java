package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzin;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzbk;
    CustomEventBanner zzbl;
    CustomEventInterstitial zzbm;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzbn;
        private final MediationBannerListener zzbo;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            MediationBannerListener mediationBannerListener2 = mediationBannerListener;
            this.zzbn = customEventAdapter;
            this.zzbo = mediationBannerListener2;
        }

        public void onClick() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onClick(this.zzbn);
        }

        public void onDismissScreen() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onDismissScreen(this.zzbn);
        }

        public void onFailedToReceiveAd() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onFailedToReceiveAd(this.zzbn, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onLeaveApplication(this.zzbn);
        }

        public void onPresentScreen() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onPresentScreen(this.zzbn);
        }

        public void onReceivedAd(View view) {
            View view2 = view;
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbn.zza(view2);
            this.zzbo.onReceivedAd(this.zzbn);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzbn;
        private final MediationInterstitialListener zzbp;
        final /* synthetic */ CustomEventAdapter zzbq;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            CustomEventAdapter customEventAdapter3 = customEventAdapter2;
            MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
            this.zzbq = customEventAdapter;
            this.zzbn = customEventAdapter3;
            this.zzbp = mediationInterstitialListener2;
        }

        public void onDismissScreen() {
            zzin.zzaI("Custom event adapter called onDismissScreen.");
            this.zzbp.onDismissScreen(this.zzbn);
        }

        public void onFailedToReceiveAd() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbp.onFailedToReceiveAd(this.zzbn, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzin.zzaI("Custom event adapter called onLeaveApplication.");
            this.zzbp.onLeaveApplication(this.zzbn);
        }

        public void onPresentScreen() {
            zzin.zzaI("Custom event adapter called onPresentScreen.");
            this.zzbp.onPresentScreen(this.zzbn);
        }

        public void onReceivedAd() {
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbp.onReceivedAd(this.zzbq);
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

    public void destroy() {
        if (this.zzbl != null) {
            this.zzbl.destroy();
        }
        if (this.zzbm != null) {
            this.zzbm.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzbk;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        zza zza2;
        MediationBannerListener mediationBannerListener2 = mediationBannerListener;
        Activity activity2 = activity;
        CustomEventServerParameters customEventServerParameters2 = customEventServerParameters;
        AdSize adSize2 = adSize;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        CustomEventExtras customEventExtras2 = customEventExtras;
        this.zzbl = (CustomEventBanner) zzj(customEventServerParameters2.className);
        if (this.zzbl == null) {
            mediationBannerListener2.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
            return;
        }
        Object extra = customEventExtras2 == null ? null : customEventExtras2.getExtra(customEventServerParameters2.label);
        CustomEventBanner customEventBanner = this.zzbl;
        zza zza3 = zza2;
        zza zza4 = new zza(this, mediationBannerListener2);
        customEventBanner.requestBannerAd(zza3, activity2, customEventServerParameters2.label, customEventServerParameters2.parameter, adSize2, mediationAdRequest2, extra);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
        Activity activity2 = activity;
        CustomEventServerParameters customEventServerParameters2 = customEventServerParameters;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        CustomEventExtras customEventExtras2 = customEventExtras;
        this.zzbm = (CustomEventInterstitial) zzj(customEventServerParameters2.className);
        if (this.zzbm == null) {
            mediationInterstitialListener2.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzbm.requestInterstitialAd(zza(mediationInterstitialListener2), activity2, customEventServerParameters2.label, customEventServerParameters2.parameter, mediationAdRequest2, customEventExtras2 == null ? null : customEventExtras2.getExtra(customEventServerParameters2.label));
        }
    }

    public void showInterstitial() {
        this.zzbm.showInterstitial();
    }

    /* access modifiers changed from: 0000 */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        zzb zzb2;
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(this, this, mediationInterstitialListener);
        return zzb3;
    }
}
