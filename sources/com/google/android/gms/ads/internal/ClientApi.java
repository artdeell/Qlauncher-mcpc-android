package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.zzk;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhs;

public class ClientApi implements zzm {
    public ClientApi() {
    }

    public static void retainReference() {
        zzl.zzuq = ClientApi.class.getName();
    }

    public zzs createAdLoaderBuilder(Context context, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzj zzj;
        zzj zzj2 = zzj;
        zzj zzj3 = new zzj(context, str, zzew, versionInfoParcel, zzd.zzbg());
        return zzj2;
    }

    public zzfv createAdOverlay(Activity activity) {
        zzd zzd;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(activity);
        return zzd2;
    }

    public zzu createBannerAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf(context, adSizeParcel, str, zzew, versionInfoParcel, zzd.zzbg());
        return zzf2;
    }

    public zzge createInAppPurchaseManager(Activity activity) {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze(activity);
        return zze2;
    }

    public zzu createInterstitialAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzk zzk;
        zzeb zzeb;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        zzew zzew2 = zzew;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        if (((Boolean) zzbt.zzwE.get()).booleanValue()) {
            zzeb zzeb2 = zzeb;
            zzeb zzeb3 = new zzeb(context2, str2, zzew2, versionInfoParcel2, zzd.zzbg());
            return zzeb2;
        }
        zzk zzk2 = zzk;
        zzk zzk3 = new zzk(context2, adSizeParcel2, str2, zzew2, versionInfoParcel2, zzd.zzbg());
        return zzk2;
    }

    public zzcj createNativeAdViewDelegate(FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzk zzk;
        zzk zzk2 = zzk;
        zzk zzk3 = new zzk(frameLayout, frameLayout2);
        return zzk2;
    }

    public zzb createRewardedVideoAd(Context context, zzew zzew, VersionInfoParcel versionInfoParcel) {
        zzhs zzhs;
        zzhs zzhs2 = zzhs;
        zzhs zzhs3 = new zzhs(context, zzd.zzbg(), zzew, versionInfoParcel);
        return zzhs2;
    }

    public zzy getMobileAdsSettingsManager(Context context) {
        return zzn.zzr(context);
    }
}
