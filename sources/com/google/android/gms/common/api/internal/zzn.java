package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.gms.common.zzc;

abstract class zzn extends BroadcastReceiver {
    protected Context mContext;

    zzn() {
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t) {
        return zza(context, t, zzc.zzoK());
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t, zzc zzc) {
        IntentFilter intentFilter;
        Context context2 = context;
        T t2 = t;
        zzc zzc2 = zzc;
        IntentFilter intentFilter2 = intentFilter;
        IntentFilter intentFilter3 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        IntentFilter intentFilter4 = intentFilter2;
        intentFilter4.addDataScheme("package");
        Intent registerReceiver = context2.registerReceiver(t2, intentFilter4);
        t2.mContext = context2;
        if (!zzc2.zzi(context2, "com.google.android.gms")) {
            t2.zzpJ();
            t2.unregister();
            t2 = null;
        }
        return t2;
    }

    public void onReceive(Context context, Intent intent) {
        Context context2 = context;
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            zzpJ();
            unregister();
        }
    }

    public void unregister() {
        synchronized (this) {
            try {
                if (this.mContext != null) {
                    this.mContext.unregisterReceiver(this);
                }
                this.mContext = null;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzpJ();
}
