package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzmu {
    @TargetApi(20)
    public static boolean zzaw(Context context) {
        return zzne.zzsl() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static boolean zzb(Resources resources) {
        Resources resources2 = resources;
        if (resources2 != null) {
            boolean z = (15 & resources2.getConfiguration().screenLayout) > 3;
            if ((zzne.zzsd() && z) || zzc(resources2)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        boolean z = false;
        if (zzne.zzsf()) {
            z = false;
            if ((15 & configuration.screenLayout) <= 3) {
                z = false;
                if (configuration.smallestScreenWidthDp >= 600) {
                    z = true;
                }
            }
        }
        return z;
    }
}
