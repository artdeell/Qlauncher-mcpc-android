package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzka;
import java.util.Date;
import java.util.Set;

@zzhb
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzka {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzaQ;
    protected InterstitialAd zzaR;
    private AdLoader zzaS;
    private Context zzaT;
    private InterstitialAd zzaU;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzaV;
    private String zzaW;
    final RewardedVideoAdListener zzaX;

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzaZ;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            NativeAppInstallAd nativeAppInstallAd2 = nativeAppInstallAd;
            this.zzaZ = nativeAppInstallAd2;
            setHeadline(nativeAppInstallAd2.getHeadline().toString());
            setImages(nativeAppInstallAd2.getImages());
            setBody(nativeAppInstallAd2.getBody().toString());
            setIcon(nativeAppInstallAd2.getIcon());
            setCallToAction(nativeAppInstallAd2.getCallToAction().toString());
            setStarRating(nativeAppInstallAd2.getStarRating().doubleValue());
            setStore(nativeAppInstallAd2.getStore().toString());
            setPrice(nativeAppInstallAd2.getPrice().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            View view2 = view;
            if (view2 instanceof NativeAdView) {
                ((NativeAdView) view2).setNativeAd(this.zzaZ);
            }
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzba;

        public zzb(NativeContentAd nativeContentAd) {
            NativeContentAd nativeContentAd2 = nativeContentAd;
            this.zzba = nativeContentAd2;
            setHeadline(nativeContentAd2.getHeadline().toString());
            setImages(nativeContentAd2.getImages());
            setBody(nativeContentAd2.getBody().toString());
            setLogo(nativeContentAd2.getLogo());
            setCallToAction(nativeContentAd2.getCallToAction().toString());
            setAdvertiser(nativeContentAd2.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            View view2 = view;
            if (view2 instanceof NativeAdView) {
                ((NativeAdView) view2).setNativeAd(this.zzba);
            }
        }
    }

    static final class zzc extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final MediationBannerListener zzbc;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            MediationBannerListener mediationBannerListener2 = mediationBannerListener;
            this.zzbb = abstractAdViewAdapter;
            this.zzbc = mediationBannerListener2;
        }

        public void onAdClicked() {
            this.zzbc.onAdClicked(this.zzbb);
        }

        public void onAdClosed() {
            this.zzbc.onAdClosed(this.zzbb);
        }

        public void onAdFailedToLoad(int i) {
            this.zzbc.onAdFailedToLoad(this.zzbb, i);
        }

        public void onAdLeftApplication() {
            this.zzbc.onAdLeftApplication(this.zzbb);
        }

        public void onAdLoaded() {
            this.zzbc.onAdLoaded(this.zzbb);
        }

        public void onAdOpened() {
            this.zzbc.onAdOpened(this.zzbb);
        }
    }

    static final class zzd extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final MediationInterstitialListener zzbd;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
            this.zzbb = abstractAdViewAdapter;
            this.zzbd = mediationInterstitialListener2;
        }

        public void onAdClicked() {
            this.zzbd.onAdClicked(this.zzbb);
        }

        public void onAdClosed() {
            this.zzbd.onAdClosed(this.zzbb);
        }

        public void onAdFailedToLoad(int i) {
            this.zzbd.onAdFailedToLoad(this.zzbb, i);
        }

        public void onAdLeftApplication() {
            this.zzbd.onAdLeftApplication(this.zzbb);
        }

        public void onAdLoaded() {
            this.zzbd.onAdLoaded(this.zzbb);
        }

        public void onAdOpened() {
            this.zzbd.onAdOpened(this.zzbb);
        }
    }

    static final class zze extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final MediationNativeListener zzbe;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            MediationNativeListener mediationNativeListener2 = mediationNativeListener;
            this.zzbb = abstractAdViewAdapter;
            this.zzbe = mediationNativeListener2;
        }

        public void onAdClicked() {
            this.zzbe.onAdClicked(this.zzbb);
        }

        public void onAdClosed() {
            this.zzbe.onAdClosed(this.zzbb);
        }

        public void onAdFailedToLoad(int i) {
            this.zzbe.onAdFailedToLoad(this.zzbb, i);
        }

        public void onAdLeftApplication() {
            this.zzbe.onAdLeftApplication(this.zzbb);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.zzbe.onAdOpened(this.zzbb);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            zza zza;
            NativeAppInstallAd nativeAppInstallAd2 = nativeAppInstallAd;
            MediationNativeListener mediationNativeListener = this.zzbe;
            AbstractAdViewAdapter abstractAdViewAdapter = this.zzbb;
            zza zza2 = zza;
            zza zza3 = new zza(nativeAppInstallAd2);
            mediationNativeListener.onAdLoaded(abstractAdViewAdapter, zza2);
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            zzb zzb;
            NativeContentAd nativeContentAd2 = nativeContentAd;
            MediationNativeListener mediationNativeListener = this.zzbe;
            AbstractAdViewAdapter abstractAdViewAdapter = this.zzbb;
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb(nativeContentAd2);
            mediationNativeListener.onAdLoaded(abstractAdViewAdapter, zzb2);
        }
    }

    public AbstractAdViewAdapter() {
        C01561 r5;
        C01561 r2 = r5;
        C01561 r3 = new RewardedVideoAdListener(this) {
            final /* synthetic */ AbstractAdViewAdapter zzaY;

            {
                this.zzaY = r5;
            }

            public void onRewarded(RewardItem rewardItem) {
                this.zzaY.zzaV.onRewarded(this.zzaY, rewardItem);
            }

            public void onRewardedVideoAdClosed() {
                this.zzaY.zzaV.onAdClosed(this.zzaY);
                InterstitialAd zza = AbstractAdViewAdapter.zza(this.zzaY, (InterstitialAd) null);
            }

            public void onRewardedVideoAdFailedToLoad(int i) {
                this.zzaY.zzaV.onAdFailedToLoad(this.zzaY, i);
            }

            public void onRewardedVideoAdLeftApplication() {
                this.zzaY.zzaV.onAdLeftApplication(this.zzaY);
            }

            public void onRewardedVideoAdLoaded() {
                this.zzaY.zzaV.onAdLoaded(this.zzaY);
            }

            public void onRewardedVideoAdOpened() {
                this.zzaY.zzaV.onAdOpened(this.zzaY);
            }

            public void onRewardedVideoStarted() {
                this.zzaY.zzaV.onVideoStarted(this.zzaY);
            }
        };
        this.zzaX = r2;
    }

    static /* synthetic */ InterstitialAd zza(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        InterstitialAd interstitialAd2 = interstitialAd;
        abstractAdViewAdapter.zzaU = interstitialAd2;
        return interstitialAd2;
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzaQ;
    }

    public Bundle getInterstitialAdapterInfo() {
        com.google.android.gms.ads.mediation.MediationAdapter.zza zza2;
        com.google.android.gms.ads.mediation.MediationAdapter.zza zza3 = zza2;
        com.google.android.gms.ads.mediation.MediationAdapter.zza zza4 = new com.google.android.gms.ads.mediation.MediationAdapter.zza();
        return zza3.zzS(1).zziw();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        String str2 = str;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2 = mediationRewardedVideoAdListener;
        Bundle bundle3 = bundle;
        Bundle bundle4 = bundle2;
        this.zzaT = context.getApplicationContext();
        this.zzaW = str2;
        this.zzaV = mediationRewardedVideoAdListener2;
        this.zzaV.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzaV != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        InterstitialAd interstitialAd;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle3 = bundle;
        Bundle bundle4 = bundle2;
        if (this.zzaT == null || this.zzaV == null) {
            zzin.m19e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        InterstitialAd interstitialAd2 = interstitialAd;
        InterstitialAd interstitialAd3 = new InterstitialAd(this.zzaT);
        this.zzaU = interstitialAd2;
        this.zzaU.zza(true);
        this.zzaU.setAdUnitId(getAdUnitId(bundle3));
        this.zzaU.setRewardedVideoAdListener(this.zzaX);
        this.zzaU.zzm(this.zzaW);
        this.zzaU.loadAd(zza(this.zzaT, mediationAdRequest2, bundle4, bundle3));
    }

    public void onDestroy() {
        if (this.zzaQ != null) {
            this.zzaQ.destroy();
            this.zzaQ = null;
        }
        if (this.zzaR != null) {
            this.zzaR = null;
        }
        if (this.zzaS != null) {
            this.zzaS = null;
        }
        if (this.zzaU != null) {
            this.zzaU = null;
        }
    }

    public void onPause() {
        if (this.zzaQ != null) {
            this.zzaQ.pause();
        }
    }

    public void onResume() {
        if (this.zzaQ != null) {
            this.zzaQ.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView;
        AdSize adSize2;
        zzc zzc2;
        Context context2 = context;
        MediationBannerListener mediationBannerListener2 = mediationBannerListener;
        Bundle bundle3 = bundle;
        AdSize adSize3 = adSize;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle4 = bundle2;
        AdView adView2 = adView;
        AdView adView3 = new AdView(context2);
        this.zzaQ = adView2;
        AdView adView4 = this.zzaQ;
        AdSize adSize4 = adSize2;
        AdSize adSize5 = new AdSize(adSize3.getWidth(), adSize3.getHeight());
        adView4.setAdSize(adSize4);
        this.zzaQ.setAdUnitId(getAdUnitId(bundle3));
        AdView adView5 = this.zzaQ;
        zzc zzc3 = zzc2;
        zzc zzc4 = new zzc(this, mediationBannerListener2);
        adView5.setAdListener(zzc3);
        this.zzaQ.loadAd(zza(context2, mediationAdRequest2, bundle4, bundle3));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd;
        zzd zzd2;
        Context context2 = context;
        MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
        Bundle bundle3 = bundle;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle4 = bundle2;
        InterstitialAd interstitialAd2 = interstitialAd;
        InterstitialAd interstitialAd3 = new InterstitialAd(context2);
        this.zzaR = interstitialAd2;
        this.zzaR.setAdUnitId(getAdUnitId(bundle3));
        InterstitialAd interstitialAd4 = this.zzaR;
        zzd zzd3 = zzd2;
        zzd zzd4 = new zzd(this, mediationInterstitialListener2);
        interstitialAd4.setAdListener(zzd3);
        this.zzaR.loadAd(zza(context2, mediationAdRequest2, bundle4, bundle3));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2;
        Context context2 = context;
        Bundle bundle3 = bundle;
        NativeMediationAdRequest nativeMediationAdRequest2 = nativeMediationAdRequest;
        Bundle bundle4 = bundle2;
        zze zze3 = zze2;
        zze zze4 = new zze(this, mediationNativeListener);
        zze zze5 = zze3;
        Builder withAdListener = zza(context2, bundle3.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze5);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest2.getNativeAdOptions();
        if (nativeAdOptions != null) {
            Builder withNativeAdOptions = withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest2.isAppInstallAdRequested()) {
            Builder forAppInstallAd = withAdListener.forAppInstallAd(zze5);
        }
        if (nativeMediationAdRequest2.isContentAdRequested()) {
            Builder forContentAd = withAdListener.forContentAd(zze5);
        }
        this.zzaS = withAdListener.build();
        this.zzaS.loadAd(zza(context2, nativeMediationAdRequest2, bundle4, bundle3));
    }

    public void showInterstitial() {
        this.zzaR.show();
    }

    public void showVideo() {
        this.zzaU.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    /* access modifiers changed from: 0000 */
    public Builder zza(Context context, String str) {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder(context, str);
        return builder2;
    }

    /* access modifiers changed from: 0000 */
    public AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder;
        Context context2 = context;
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Bundle bundle3 = bundle;
        Bundle bundle4 = bundle2;
        AdRequest.Builder builder2 = builder;
        AdRequest.Builder builder3 = new AdRequest.Builder();
        AdRequest.Builder builder4 = builder2;
        Date birthday = mediationAdRequest2.getBirthday();
        if (birthday != null) {
            AdRequest.Builder birthday2 = builder4.setBirthday(birthday);
        }
        int gender = mediationAdRequest2.getGender();
        if (gender != 0) {
            AdRequest.Builder gender2 = builder4.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest2.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                AdRequest.Builder addKeyword2 = builder4.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest2.getLocation();
        if (location != null) {
            AdRequest.Builder location2 = builder4.setLocation(location);
        }
        if (mediationAdRequest2.isTesting()) {
            AdRequest.Builder addTestDevice = builder4.addTestDevice(zzn.zzcS().zzT(context2));
        }
        if (mediationAdRequest2.taggedForChildDirectedTreatment() != -1) {
            AdRequest.Builder tagForChildDirectedTreatment = builder4.tagForChildDirectedTreatment(mediationAdRequest2.taggedForChildDirectedTreatment() == 1);
        }
        AdRequest.Builder isDesignedForFamilies = builder4.setIsDesignedForFamilies(mediationAdRequest2.isDesignedForFamilies());
        AdRequest.Builder addNetworkExtrasBundle = builder4.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle3, bundle4));
        return builder4.build();
    }
}
