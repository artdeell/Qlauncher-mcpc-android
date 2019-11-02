package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public static final class Settings {
        private final zzae zzoM;

        public Settings() {
            zzae zzae;
            zzae zzae2 = zzae;
            zzae zzae3 = new zzae();
            this.zzoM = zzae2;
        }

        @Deprecated
        public String getTrackingId() {
            return this.zzoM.getTrackingId();
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return this.zzoM.isGoogleAnalyticsEnabled();
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            this.zzoM.zzm(z);
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            this.zzoM.zzJ(str);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public zzae zzaG() {
            return this.zzoM;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzad.zzdi().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        zzad.zzdi().initialize(context);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        Settings settings2 = settings;
        zzad.zzdi().zza(context, str, settings2 == null ? null : settings2.zzaG());
    }

    public static void setAppVolume(float f) {
        zzad.zzdi().setAppVolume(f);
    }
}
