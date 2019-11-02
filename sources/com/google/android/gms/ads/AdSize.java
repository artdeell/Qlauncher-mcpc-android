package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final AdSize FLUID;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final int zzoG;
    private final int zzoH;
    private final String zzoI;

    static {
        AdSize adSize;
        AdSize adSize2;
        AdSize adSize3;
        AdSize adSize4;
        AdSize adSize5;
        AdSize adSize6;
        AdSize adSize7;
        AdSize adSize8;
        AdSize adSize9 = adSize;
        AdSize adSize10 = new AdSize(320, 50, "320x50_mb");
        BANNER = adSize9;
        AdSize adSize11 = adSize2;
        AdSize adSize12 = new AdSize(NativeDefinitions.KEY_FN_F3, 60, "468x60_as");
        FULL_BANNER = adSize11;
        AdSize adSize13 = adSize3;
        AdSize adSize14 = new AdSize(320, 100, "320x100_as");
        LARGE_BANNER = adSize13;
        AdSize adSize15 = adSize4;
        AdSize adSize16 = new AdSize(728, 90, "728x90_as");
        LEADERBOARD = adSize15;
        AdSize adSize17 = adSize5;
        AdSize adSize18 = new AdSize(300, 250, "300x250_as");
        MEDIUM_RECTANGLE = adSize17;
        AdSize adSize19 = adSize6;
        AdSize adSize20 = new AdSize(160, 600, "160x600_as");
        WIDE_SKYSCRAPER = adSize19;
        AdSize adSize21 = adSize7;
        AdSize adSize22 = new AdSize(-1, -2, "smart_banner");
        SMART_BANNER = adSize21;
        AdSize adSize23 = adSize8;
        AdSize adSize24 = new AdSize(-3, -4, "fluid");
        FLUID = adSize23;
    }

    public AdSize(int i, int i2) {
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder append = sb2.append(i3 == -1 ? "FULL" : String.valueOf(i3)).append("x");
        this(i3, i4, append.append(i4 == -2 ? "AUTO" : String.valueOf(i4)).append("_as").toString());
    }

    AdSize(int i, int i2, String str) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        int i3 = i;
        int i4 = i2;
        String str2 = str;
        if (i3 < 0 && i3 != -1 && i3 != -3) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("Invalid width for AdSize: ").append(i3).toString());
            throw illegalArgumentException3;
        } else if (i4 >= 0 || i4 == -2 || i4 == -4) {
            this.zzoG = i3;
            this.zzoH = i4;
            this.zzoI = str2;
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Invalid height for AdSize: ").append(i4).toString());
            throw illegalArgumentException5;
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof AdSize)) {
                return false;
            }
            AdSize adSize = (AdSize) obj2;
            if (!(this.zzoG == adSize.zzoG && this.zzoH == adSize.zzoH && this.zzoI.equals(adSize.zzoI))) {
                return false;
            }
        }
        return true;
    }

    public int getHeight() {
        return this.zzoH;
    }

    public int getHeightInPixels(Context context) {
        Context context2 = context;
        switch (this.zzoH) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.zzb(context2.getResources().getDisplayMetrics());
            default:
                return zzn.zzcS().zzb(context2, this.zzoH);
        }
    }

    public int getWidth() {
        return this.zzoG;
    }

    public int getWidthInPixels(Context context) {
        Context context2 = context;
        switch (this.zzoG) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.zza(context2.getResources().getDisplayMetrics());
            default:
                return zzn.zzcS().zzb(context2, this.zzoG);
        }
    }

    public int hashCode() {
        return this.zzoI.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzoH == -2;
    }

    public boolean isFluid() {
        return this.zzoG == -3 && this.zzoH == -4;
    }

    public boolean isFullWidth() {
        return this.zzoG == -1;
    }

    public String toString() {
        return this.zzoI;
    }
}
