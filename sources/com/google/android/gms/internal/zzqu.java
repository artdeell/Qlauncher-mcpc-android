package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;
import com.google.android.gms.playlog.internal.zzf;

@Deprecated
public class zzqu {
    private final zzf zzbdy;
    private PlayLoggerContext zzbdz;

    public interface zza {
        void zzES();

        void zzET();

        void zzc(PendingIntent pendingIntent);
    }

    public zzqu(Context context, int i, String str, String str2, zza zza2, boolean z, String str3) {
        int i2;
        PlayLoggerContext playLoggerContext;
        zzf zzf;
        zzd zzd;
        com.google.android.gms.common.internal.zzf zzf2;
        Context context2 = context;
        int i3 = i;
        String str4 = str;
        String str5 = str2;
        zza zza3 = zza2;
        boolean z2 = z;
        String str6 = str3;
        String packageName = context2.getPackageName();
        try {
            i2 = context2.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            int wtf = Log.wtf("PlayLogger", "This can't happen.", e);
            i2 = 0;
        }
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        PlayLoggerContext playLoggerContext3 = new PlayLoggerContext(packageName, i2, i3, str4, str5, z2);
        this.zzbdz = playLoggerContext2;
        zzf zzf3 = zzf;
        Context context3 = context2;
        Looper mainLooper = context2.getMainLooper();
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(zza3);
        com.google.android.gms.common.internal.zzf zzf4 = zzf2;
        com.google.android.gms.common.internal.zzf zzf5 = new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, packageName, str6, null);
        zzf zzf6 = new zzf(context3, mainLooper, zzd2, zzf4);
        this.zzbdy = zzf3;
    }

    public void start() {
        this.zzbdy.start();
    }

    public void stop() {
        this.zzbdy.stop();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        LogEvent logEvent;
        long j2 = j;
        String str2 = str;
        byte[] bArr2 = bArr;
        String[] strArr2 = strArr;
        zzf zzf = this.zzbdy;
        PlayLoggerContext playLoggerContext = this.zzbdz;
        LogEvent logEvent2 = logEvent;
        LogEvent logEvent3 = new LogEvent(j2, 0, str2, bArr2, strArr2);
        zzf.zzb(playLoggerContext, logEvent2);
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
