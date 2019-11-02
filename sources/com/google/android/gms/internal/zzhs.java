package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;

@zzhb
public class zzhs extends zza {
    private final Context mContext;
    private final zzht zzKu;
    private final VersionInfoParcel zzpT;
    private final Object zzpV;

    public zzhs(Context context, zzd zzd, zzex zzex, VersionInfoParcel versionInfoParcel) {
        zzht zzht;
        Object obj;
        Context context2 = context;
        zzd zzd2 = zzd;
        zzex zzex2 = zzex;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        this.mContext = context2;
        this.zzpT = versionInfoParcel2;
        zzht zzht2 = zzht;
        zzht zzht3 = new zzht(context2, zzd2, AdSizeParcel.zzcP(), zzex2, versionInfoParcel2);
        this.zzKu = zzht2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    public void destroy() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.destroy();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean isLoaded() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzKu.isLoaded();
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void pause() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.pause();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void resume() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.resume();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setUserId(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.setUserId(str2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void show() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.zzgL();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.zza(rewardedVideoAdRequestParcel2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        com.google.android.gms.ads.internal.reward.client.zzd zzd2 = zzd;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKu.zza(zzd2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
