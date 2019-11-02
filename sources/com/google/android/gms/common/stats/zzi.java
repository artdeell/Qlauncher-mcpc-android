package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc.zzb;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmv;
import java.util.List;

public class zzi {
    private static String TAG = "WakeLockTracker";
    private static zzi zzanY;
    private static Integer zzanv;

    static {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi();
        zzanY = zzi2;
    }

    public zzi() {
    }

    private static int getLogLevel() {
        try {
            return zzmp.zzkr() ? ((Integer) zzb.zzanz.get()).intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            SecurityException securityException = e;
            return zzd.LOG_LEVEL_OFF;
        }
    }

    private static boolean zzav(Context context) {
        Context context2 = context;
        if (zzanv == null) {
            zzanv = Integer.valueOf(getLogLevel());
        }
        return zzanv.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzrZ() {
        return zzanY;
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        zza(context, str, i, str2, str3, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        WakeLockEvent wakeLockEvent;
        Intent intent;
        StringBuilder sb;
        Context context2 = context;
        String str4 = str;
        int i3 = i;
        String str5 = str2;
        String str6 = str3;
        int i4 = i2;
        List<String> list2 = list;
        long j2 = j;
        if (zzav(context2)) {
            if (TextUtils.isEmpty(str4)) {
                String str7 = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e = Log.e(str7, sb2.append("missing wakeLock key. ").append(str4).toString());
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                WakeLockEvent wakeLockEvent2 = wakeLockEvent;
                WakeLockEvent wakeLockEvent3 = new WakeLockEvent(currentTimeMillis, i3, str5, i4, list2, str4, SystemClock.elapsedRealtime(), zzmv.zzax(context2), str6, context2.getPackageName(), zzmv.zzay(context2), j2);
                WakeLockEvent wakeLockEvent4 = wakeLockEvent2;
                Context context3 = context2;
                try {
                    Intent intent2 = intent;
                    Intent intent3 = new Intent();
                    ComponentName startService = context3.startService(intent2.setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent4));
                } catch (Exception e2) {
                    int wtf = Log.wtf(TAG, e2);
                }
            }
        }
    }
}
