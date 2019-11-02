package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzaf extends zzg<zzz> {
    public zzaf() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    private zzy zzv(Context context) {
        Context context2 = context;
        try {
            return zza.zzo(((zzz) zzaB(context2)).zza(zze.zzC(context2), 8487000));
        } catch (RemoteException e) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzq */
    public zzz zzd(IBinder iBinder) {
        return zzz.zza.zzp(iBinder);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (r3 == null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.ads.internal.client.zzy zzu(android.content.Context r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            com.google.android.gms.ads.internal.util.client.zza r4 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r5 = r1
            boolean r4 = r4.zzU(r5)
            if (r4 == 0) goto L_0x0017
            r4 = r0
            r5 = r1
            com.google.android.gms.ads.internal.client.zzy r4 = r4.zzv(r5)
            r3 = r4
            r4 = r3
            if (r4 != 0) goto L_0x0035
        L_0x0017:
            java.lang.String r4 = "Using MobileAdsSettingManager from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaI(r4)
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = 8487000(0x818058, float:1.189282E-38)
            r7 = 8487000(0x818058, float:1.189282E-38)
            r8 = 1
            r5.<init>(r6, r7, r8)
            com.google.android.gms.ads.internal.client.zzl r4 = com.google.android.gms.ads.internal.client.zzn.zzcU()
            r5 = r1
            com.google.android.gms.ads.internal.client.zzy r4 = r4.getMobileAdsSettingsManager(r5)
            r3 = r4
        L_0x0035:
            r4 = r3
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzaf.zzu(android.content.Context):com.google.android.gms.ads.internal.client.zzy");
    }
}
