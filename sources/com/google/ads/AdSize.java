package com.google.ads;

import android.content.Context;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER;
    public static final AdSize IAB_LEADERBOARD;
    public static final AdSize IAB_MRECT;
    public static final AdSize IAB_WIDE_SKYSCRAPER;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER;
    private final com.google.android.gms.ads.AdSize zzaJ;

    static {
        AdSize adSize;
        AdSize adSize2;
        AdSize adSize3;
        AdSize adSize4;
        AdSize adSize5;
        AdSize adSize6;
        AdSize adSize7 = adSize;
        AdSize adSize8 = new AdSize(-1, -2, "mb");
        SMART_BANNER = adSize7;
        AdSize adSize9 = adSize2;
        AdSize adSize10 = new AdSize(320, 50, "mb");
        BANNER = adSize9;
        AdSize adSize11 = adSize3;
        AdSize adSize12 = new AdSize(300, 250, "as");
        IAB_MRECT = adSize11;
        AdSize adSize13 = adSize4;
        AdSize adSize14 = new AdSize(NativeDefinitions.KEY_FN_F3, 60, "as");
        IAB_BANNER = adSize13;
        AdSize adSize15 = adSize5;
        AdSize adSize16 = new AdSize(728, 90, "as");
        IAB_LEADERBOARD = adSize15;
        AdSize adSize17 = adSize6;
        AdSize adSize18 = new AdSize(160, 600, "as");
        IAB_WIDE_SKYSCRAPER = adSize17;
    }

    public AdSize(int i, int i2) {
        com.google.android.gms.ads.AdSize adSize;
        com.google.android.gms.ads.AdSize adSize2 = adSize;
        com.google.android.gms.ads.AdSize adSize3 = new com.google.android.gms.ads.AdSize(i, i2);
        this(adSize2);
    }

    private AdSize(int i, int i2, String str) {
        com.google.android.gms.ads.AdSize adSize;
        String str2 = str;
        com.google.android.gms.ads.AdSize adSize2 = adSize;
        com.google.android.gms.ads.AdSize adSize3 = new com.google.android.gms.ads.AdSize(i, i2);
        this(adSize2);
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.zzaJ = adSize;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof AdSize)) {
            return false;
        }
        return this.zzaJ.equals(((AdSize) obj2).zzaJ);
    }

    public AdSize findBestSize(AdSize... adSizeArr) {
        float f;
        AdSize adSize;
        AdSize[] adSizeArr2 = adSizeArr;
        AdSize adSize2 = null;
        if (adSizeArr2 != null) {
            float f2 = 0.0f;
            int width = getWidth();
            int height = getHeight();
            int length = adSizeArr2.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = adSizeArr2[i];
                int width2 = adSize3.getWidth();
                int height2 = adSize3.getHeight();
                if (isSizeAppropriate(width2, height2)) {
                    f = ((float) (width2 * height2)) / ((float) (width * height));
                    if (f > 1.0f) {
                        f = 1.0f / f;
                    }
                    if (f > f2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        f2 = f;
                    }
                }
                f = f2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                f2 = f;
            }
        }
        return adSize2;
    }

    public int getHeight() {
        return this.zzaJ.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.zzaJ.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zzaJ.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.zzaJ.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zzaJ.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzaJ.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zzaJ.isFullWidth();
    }

    public boolean isSizeAppropriate(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int width = getWidth();
        int height = getHeight();
        return ((float) i3) <= 1.25f * ((float) width) && ((float) i3) >= 0.8f * ((float) width) && ((float) i4) <= 1.25f * ((float) height) && ((float) i4) >= 0.8f * ((float) height);
    }

    public String toString() {
        return this.zzaJ.toString();
    }
}
