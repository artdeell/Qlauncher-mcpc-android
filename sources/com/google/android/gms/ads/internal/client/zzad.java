package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzad {
    private static final Object zzqy;
    private static zzad zzuV;
    private zzy zzuW;
    private RewardedVideoAd zzuX;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    private zzad() {
    }

    public static zzad zzdi() {
        zzad zzad;
        zzad zzad2;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzuV == null) {
                    zzad zzad3 = zzad2;
                    zzad zzad4 = new zzad();
                    zzuV = zzad3;
                }
                th = zzuV;
            } finally {
                zzad = th;
                Object obj2 = obj;
                Throwable th = zzad;
            }
        }
        return zzad;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        zzew zzew;
        zzi zzi;
        Context context2 = context;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (this.zzuX != null) {
                    th = this.zzuX;
                    return rewardedVideoAd;
                }
                zzew zzew2 = zzew;
                zzew zzew3 = new zzew();
                zzew zzew4 = zzew2;
                zzi zzi2 = zzi;
                zzi zzi3 = new zzi(context2, zzn.zzcX().zza(context2, zzew4));
                this.zzuX = zzi2;
                RewardedVideoAd rewardedVideoAd2 = this.zzuX;
                return rewardedVideoAd2;
            } finally {
                rewardedVideoAd = th;
                Object obj2 = obj;
                Throwable th = rewardedVideoAd;
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize(android.content.Context r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            java.lang.Object r5 = zzqy
            r2 = r5
            r5 = r2
            monitor-enter(r5)
            r5 = r0
            com.google.android.gms.ads.internal.client.zzy r5 = r5.zzuW     // Catch:{ all -> 0x001d }
            if (r5 == 0) goto L_0x000f
            r5 = r2
            monitor-exit(r5)     // Catch:{ all -> 0x001d }
        L_0x000e:
            return
        L_0x000f:
            r5 = r1
            if (r5 != 0) goto L_0x0023
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x001d }
            r8 = r5
            r5 = r8
            r6 = r8
            java.lang.String r7 = "Context cannot be null."
            r6.<init>(r7)     // Catch:{ all -> 0x001d }
            throw r5     // Catch:{ all -> 0x001d }
        L_0x001d:
            r5 = move-exception
            r3 = r5
            r5 = r2
            monitor-exit(r5)     // Catch:{ all -> 0x001d }
            r5 = r3
            throw r5
        L_0x0023:
            r5 = r0
            com.google.android.gms.ads.internal.client.zzaf r6 = com.google.android.gms.ads.internal.client.zzn.zzcV()     // Catch:{ RemoteException -> 0x0038 }
            r7 = r1
            com.google.android.gms.ads.internal.client.zzy r6 = r6.zzu(r7)     // Catch:{ RemoteException -> 0x0038 }
            r5.zzuW = r6     // Catch:{ RemoteException -> 0x0038 }
            r5 = r0
            com.google.android.gms.ads.internal.client.zzy r5 = r5.zzuW     // Catch:{ RemoteException -> 0x0038 }
            r5.zza()     // Catch:{ RemoteException -> 0x0038 }
        L_0x0035:
            r5 = r2
            monitor-exit(r5)     // Catch:{ all -> 0x001d }
            goto L_0x000e
        L_0x0038:
            r5 = move-exception
            r4 = r5
            java.lang.String r5 = "Fail to initialize mobile ads setting manager"
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r5)     // Catch:{ all -> 0x001d }
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzad.initialize(android.content.Context):void");
    }

    public void setAppVolume(float f) {
        float f2 = f;
        boolean z = true;
        zzx.zzb(0.0f <= f2 && f2 <= 1.0f, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzuW == null) {
            z = false;
        }
        zzx.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzuW.setAppVolume(f2);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzae zzae) {
        String str2 = str;
        zzae zzae2 = zzae;
        initialize(context);
    }
}
