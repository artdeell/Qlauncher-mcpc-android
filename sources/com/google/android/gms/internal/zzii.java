package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import org.lwjgl.LWJGLUtil;

@zzhb
public class zzii {
    long zzLE = -1;
    long zzLF = -1;
    int zzLG = -1;
    int zzLH;
    int zzLI;
    final String zzLq;
    private final Object zzpV;

    public zzii(String str) {
        Object obj;
        String str2 = str;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzLH = 0;
        this.zzLI = 0;
        this.zzLq = str2;
    }

    public static boolean zzH(Context context) {
        ComponentName componentName;
        Context context2 = context;
        int identifier = context2.getResources().getIdentifier("Theme.Translucent", "style", LWJGLUtil.PLATFORM_ANDROID_NAME);
        if (identifier == 0) {
            zzin.zzaJ("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        ComponentName componentName2 = componentName;
        ComponentName componentName3 = new ComponentName(context2.getPackageName(), AdActivity.CLASS_NAME);
        try {
            if (identifier == context2.getPackageManager().getActivityInfo(componentName2, 0).theme) {
                return true;
            }
            zzin.zzaJ("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            zzin.zzaK("Fail to fetch AdActivity theme");
            zzin.zzaJ("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzb(AdRequestParcel adRequestParcel, long j) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        long j2 = j;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLF == -1) {
                    this.zzLF = j2;
                    this.zzLE = this.zzLF;
                } else {
                    this.zzLE = j2;
                }
                if (adRequestParcel2.extras == null || adRequestParcel2.extras.getInt("gw", 2) != 1) {
                    this.zzLG = 1 + this.zzLG;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public Bundle zzc(Context context, String str) {
        Bundle bundle;
        Context context2 = context;
        String str2 = str;
        Bundle bundle2 = this.zzpV;
        synchronized (bundle2) {
            try {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle();
                th = bundle3;
                th.putString("session_id", this.zzLq);
                th.putLong("basets", this.zzLF);
                th.putLong("currts", this.zzLE);
                th.putString("seq_num", str2);
                th.putInt("preqs", this.zzLG);
                th.putInt("pclick", this.zzLH);
                th.putInt("pimp", this.zzLI);
                th.putBoolean("support_transparent_background", zzH(context2));
            } finally {
                Throwable th = th;
                Bundle bundle5 = bundle2;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzgS() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLI = 1 + this.zzLI;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzgT() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLH = 1 + this.zzLH;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public long zzhl() {
        return this.zzLF;
    }
}
