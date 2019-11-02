package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.zzd;

public class zzmp {
    public static boolean zzk(Context context, String str) {
        try {
            boolean z = false;
            if ((context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0) {
                z = true;
            }
            return z;
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            return false;
        }
    }

    public static boolean zzkr() {
        return zzd.zzakE && zzlz.isInitialized() && zzlz.zzpW() == Process.myUid();
    }
}
