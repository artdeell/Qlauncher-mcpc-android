package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzmv {
    private static IntentFilter zzaob;
    private static long zzaoc;
    private static float zzaod = Float.NaN;

    static {
        IntentFilter intentFilter;
        IntentFilter intentFilter2 = intentFilter;
        IntentFilter intentFilter3 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        zzaob = intentFilter2;
    }

    @TargetApi(20)
    public static int zzax(Context context) {
        Context context2 = context;
        int i = 1;
        if (context2 == null || context2.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context2.getApplicationContext().registerReceiver(null, zzaob);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context2.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i2 = (zzne.zzsl() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (!z) {
            i = 0;
        }
        return i2 | i;
    }

    public static float zzay(Context context) {
        float f;
        Context context2 = context;
        synchronized (zzmv.class) {
            try {
                if (SystemClock.elapsedRealtime() - zzaoc >= 60000 || zzaod == Float.NaN) {
                    Intent registerReceiver = context2.getApplicationContext().registerReceiver(null, zzaob);
                    if (registerReceiver != null) {
                        zzaod = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                    }
                    zzaoc = SystemClock.elapsedRealtime();
                    f = zzaod;
                } else {
                    f = zzaod;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<zzmv> cls = zzmv.class;
                throw th2;
            }
        }
        return f;
    }
}
