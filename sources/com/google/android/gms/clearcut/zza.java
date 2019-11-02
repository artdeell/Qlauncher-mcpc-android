package com.google.android.gms.clearcut;

import android.content.Context;

public class zza {
    private static int zzaeO = -1;
    public static final zza zzaeP;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        zzaeP = zza2;
    }

    protected zza() {
    }

    public int zzah(Context context) {
        Context context2 = context;
        if (zzaeO < 0) {
            zzaeO = context2.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return zzaeO;
    }
}
