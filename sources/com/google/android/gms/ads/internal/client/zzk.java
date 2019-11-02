package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.C0157R;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzk {
    private final String zzpS;
    private final AdSize[] zzuo;

    public zzk(Context context, AttributeSet attributeSet) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        boolean z = true;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0157R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(C0157R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C0157R.styleable.AdsAttrs_adSizes);
        boolean z2 = !TextUtils.isEmpty(string);
        if (TextUtils.isEmpty(string2)) {
            z = false;
        }
        if (z2 && !z) {
            this.zzuo = zzz(string);
        } else if (!z2 && z) {
            this.zzuo = zzz(string2);
        } else if (!z2 || !z) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
            throw illegalArgumentException4;
        } else {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            throw illegalArgumentException6;
        }
        this.zzpS = obtainAttributes.getString(C0157R.styleable.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.zzpS)) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
            throw illegalArgumentException8;
        }
    }

    private static AdSize[] zzz(String str) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb3;
        AdSize adSize;
        String str2 = str;
        String[] split = str2.split("\\s*,\\s*");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    AdSize[] adSizeArr2 = adSizeArr;
                    int i2 = i;
                    AdSize adSize2 = adSize;
                    AdSize adSize3 = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                    adSizeArr2[i2] = adSize2;
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(sb4.append("Could not parse XML attribute \"adSize\": ").append(trim).toString());
                    throw illegalArgumentException4;
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(trim)) {
                adSizeArr[i] = AdSize.FLUID;
            } else {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(sb6.append("Could not parse XML attribute \"adSize\": ").append(trim).toString());
                throw illegalArgumentException6;
            }
        }
        if (adSizeArr.length != 0) {
            return adSizeArr;
        }
        IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
        StringBuilder sb8 = sb;
        StringBuilder sb9 = new StringBuilder();
        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(sb8.append("Could not parse XML attribute \"adSize\": ").append(str2).toString());
        throw illegalArgumentException8;
    }

    public String getAdUnitId() {
        return this.zzpS;
    }

    public AdSize[] zzj(boolean z) {
        IllegalArgumentException illegalArgumentException;
        if (z || this.zzuo.length == 1) {
            return this.zzuo;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        throw illegalArgumentException2;
    }
}
