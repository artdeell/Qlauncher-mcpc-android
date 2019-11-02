package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzew zzew) {
        Throwable th;
        Context context2 = context;
        zzew zzew2 = zzew;
        try {
            return zza.zzaa(((zzc) zzaB(context2)).zza(zze.zzC(context2), zzew2, 8487000));
        } catch (RemoteException e) {
            th = e;
            zzb.zzd("Could not get remote RewardedVideoAd.", th);
            return null;
        } catch (zzg.zza e2) {
            th = e2;
            zzb.zzd("Could not get remote RewardedVideoAd.", th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r4 == null) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.ads.internal.reward.client.zzb zza(android.content.Context r12, com.google.android.gms.internal.zzew r13) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r6 = r1
            boolean r5 = r5.zzU(r6)
            if (r5 == 0) goto L_0x0019
            r5 = r0
            r6 = r1
            r7 = r2
            com.google.android.gms.ads.internal.reward.client.zzb r5 = r5.zzb(r6, r7)
            r4 = r5
            r5 = r4
            if (r5 != 0) goto L_0x003a
        L_0x0019:
            java.lang.String r5 = "Using RewardedVideoAd from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaI(r5)
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = 8487000(0x818058, float:1.189282E-38)
            r8 = 8487000(0x818058, float:1.189282E-38)
            r9 = 1
            r6.<init>(r7, r8, r9)
            r3 = r5
            com.google.android.gms.ads.internal.client.zzl r5 = com.google.android.gms.ads.internal.client.zzn.zzcU()
            r6 = r1
            r7 = r2
            r8 = r3
            com.google.android.gms.ads.internal.reward.client.zzb r5 = r5.createRewardedVideoAd(r6, r7, r8)
            r4 = r5
        L_0x003a:
            r5 = r4
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.reward.client.zzf.zza(android.content.Context, com.google.android.gms.internal.zzew):com.google.android.gms.ads.internal.reward.client.zzb");
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzad */
    public zzc zzd(IBinder iBinder) {
        return zzc.zza.zzab(iBinder);
    }
}
