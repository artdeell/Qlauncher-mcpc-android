package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public final class zzin extends zzb {
    /* renamed from: v */
    public static void m20v(String str) {
        String str2 = str;
        if (zzhp()) {
            int v = Log.v(AdRequest.LOGTAG, str2);
        }
    }

    public static boolean zzho() {
        return ((Boolean) zzbt.zzwK.get()).booleanValue();
    }

    private static boolean zzhp() {
        return zzQ(2) && zzho();
    }
}
