package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqt;

public final class zzo {
    public static final int zzaml = (23 - " PII_LOG".length());
    private static final String zzamm = null;
    private final String zzamn;
    private final String zzamo;

    public zzo(String str) {
        this(str, zzamm);
    }

    public zzo(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Object zzb = zzx.zzb(str3, (Object) "log tag cannot be null");
        zzx.zzb(str3.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str3, Integer.valueOf(23));
        this.zzamn = str3;
        if (str4 == null || str4.length() <= 0) {
            this.zzamo = zzamm;
        } else {
            this.zzamo = str4;
        }
    }

    private String zzcK(String str) {
        String str2 = str;
        return this.zzamo == null ? str2 : this.zzamo.concat(str2);
    }

    public void zzA(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (zzbU(6)) {
            int e = Log.e(str3, zzcK(str4));
        }
    }

    public void zza(Context context, String str, String str2, Throwable th) {
        StringBuilder sb;
        zzqt zzqt;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        Throwable th2 = th;
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            StringBuilder append = sb4.append(stackTrace[i].toString());
            StringBuilder append2 = sb4.append("\n");
            i++;
        }
        zzqt zzqt2 = zzqt;
        zzqt zzqt3 = new zzqt(context2, 10);
        zzqt zzqt4 = zzqt2;
        zzqt4.zza("GMS_WTF", null, "GMS_WTF", sb4.toString());
        zzqt4.send();
        if (zzbU(7)) {
            int e = Log.e(str3, zzcK(str4), th2);
            int wtf = Log.wtf(str3, zzcK(str4), th2);
        }
    }

    public void zza(String str, String str2, Throwable th) {
        String str3 = str;
        String str4 = str2;
        Throwable th2 = th;
        if (zzbU(4)) {
            int i = Log.i(str3, zzcK(str4), th2);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        String str3 = str;
        String str4 = str2;
        Throwable th2 = th;
        if (zzbU(5)) {
            int w = Log.w(str3, zzcK(str4), th2);
        }
    }

    public boolean zzbU(int i) {
        return Log.isLoggable(this.zzamn, i);
    }

    public void zzc(String str, String str2, Throwable th) {
        String str3 = str;
        String str4 = str2;
        Throwable th2 = th;
        if (zzbU(6)) {
            int e = Log.e(str3, zzcK(str4), th2);
        }
    }

    public void zzy(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (zzbU(3)) {
            int d = Log.d(str3, zzcK(str4));
        }
    }

    public void zzz(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (zzbU(5)) {
            int w = Log.w(str3, zzcK(str4));
        }
    }
}
