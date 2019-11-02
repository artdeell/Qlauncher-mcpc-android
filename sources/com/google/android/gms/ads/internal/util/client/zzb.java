package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzb {
    /* renamed from: e */
    public static void m19e(String str) {
        String str2 = str;
        if (zzQ(6)) {
            int e = Log.e(AdRequest.LOGTAG, str2);
        }
    }

    public static boolean zzQ(int i) {
        int i2 = i;
        return i2 >= 5 || Log.isLoggable(AdRequest.LOGTAG, i2);
    }

    public static void zza(String str, Throwable th) {
        String str2 = str;
        Throwable th2 = th;
        if (zzQ(3)) {
            int d = Log.d(AdRequest.LOGTAG, str2, th2);
        }
    }

    public static void zzaI(String str) {
        String str2 = str;
        if (zzQ(3)) {
            int d = Log.d(AdRequest.LOGTAG, str2);
        }
    }

    public static void zzaJ(String str) {
        String str2 = str;
        if (zzQ(4)) {
            int i = Log.i(AdRequest.LOGTAG, str2);
        }
    }

    public static void zzaK(String str) {
        String str2 = str;
        if (zzQ(5)) {
            int w = Log.w(AdRequest.LOGTAG, str2);
        }
    }

    public static void zzb(String str, Throwable th) {
        String str2 = str;
        Throwable th2 = th;
        if (zzQ(6)) {
            int e = Log.e(AdRequest.LOGTAG, str2, th2);
        }
    }

    public static void zzc(String str, Throwable th) {
        String str2 = str;
        Throwable th2 = th;
        if (zzQ(4)) {
            int i = Log.i(AdRequest.LOGTAG, str2, th2);
        }
    }

    public static void zzd(String str, Throwable th) {
        String str2 = str;
        Throwable th2 = th;
        if (zzQ(5)) {
            int w = Log.w(AdRequest.LOGTAG, str2, th2);
        }
    }
}
