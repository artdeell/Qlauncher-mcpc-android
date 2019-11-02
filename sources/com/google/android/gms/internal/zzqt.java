package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqu.zza;

@Deprecated
public class zzqt implements zza {
    private final zzqu zzbdw;
    private boolean zzbdx;

    public zzqt(Context context, int i) {
        this(context, i, null);
    }

    public zzqt(Context context, int i, String str) {
        this(context, i, str, null, true);
    }

    public zzqt(Context context, int i, String str, String str2, boolean z) {
        zzqu zzqu;
        Context context2 = context;
        zzqu zzqu2 = zzqu;
        zzqu zzqu3 = new zzqu(context2, i, str, str2, this, z, context2 != context2.getApplicationContext() ? context2.getClass().getName() : "OneTimePlayLogger");
        this.zzbdw = zzqu2;
        this.zzbdx = true;
    }

    private void zzER() {
        IllegalStateException illegalStateException;
        if (!this.zzbdx) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Cannot reuse one-time logger after sending.");
            throw illegalStateException2;
        }
    }

    public void send() {
        zzER();
        this.zzbdw.start();
        this.zzbdx = false;
    }

    public void zzES() {
        this.zzbdw.stop();
    }

    public void zzET() {
        int w = Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        String str2 = str;
        byte[] bArr2 = bArr;
        String[] strArr2 = strArr;
        zzER();
        this.zzbdw.zzb(str2, bArr2, strArr2);
    }

    public void zzc(PendingIntent pendingIntent) {
        StringBuilder sb;
        PendingIntent pendingIntent2 = pendingIntent;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int w = Log.w("OneTimePlayLogger", sb2.append("logger connection failed: ").append(pendingIntent2).toString());
    }
}
