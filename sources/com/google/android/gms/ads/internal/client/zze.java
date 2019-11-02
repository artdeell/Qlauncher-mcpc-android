package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zze extends zzg<zzv> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzew zzew, int i) {
        Throwable th;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        zzew zzew2 = zzew;
        int i2 = i;
        try {
            return zza.zzk(((zzv) zzaB(context2)).zza(com.google.android.gms.dynamic.zze.zzC(context2), adSizeParcel2, str2, zzew2, 8487000, i2));
        } catch (RemoteException e) {
            th = e;
            zzb.zza("Could not create remote AdManager.", th);
            return null;
        } catch (zzg.zza e2) {
            th = e2;
            zzb.zza("Could not create remote AdManager.", th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        if (r6 == null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.ads.internal.client.zzu zza(android.content.Context r15, com.google.android.gms.ads.internal.client.AdSizeParcel r16, java.lang.String r17, com.google.android.gms.internal.zzew r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            com.google.android.gms.ads.internal.util.client.zza r7 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r8 = r1
            boolean r7 = r7.zzU(r8)
            if (r7 == 0) goto L_0x0021
            r7 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = 1
            com.google.android.gms.ads.internal.client.zzu r7 = r7.zza(r8, r9, r10, r11, r12)
            r6 = r7
            r7 = r6
            if (r7 != 0) goto L_0x0044
        L_0x0021:
            java.lang.String r7 = "Using BannerAdManager from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaI(r7)
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r7 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            r13 = r7
            r7 = r13
            r8 = r13
            r9 = 8487000(0x818058, float:1.189282E-38)
            r10 = 8487000(0x818058, float:1.189282E-38)
            r11 = 1
            r8.<init>(r9, r10, r11)
            r5 = r7
            com.google.android.gms.ads.internal.client.zzl r7 = com.google.android.gms.ads.internal.client.zzn.zzcU()
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r5
            com.google.android.gms.ads.internal.client.zzu r7 = r7.createBannerAdManager(r8, r9, r10, r11, r12)
            r6 = r7
        L_0x0044:
            r7 = r6
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zze.zza(android.content.Context, com.google.android.gms.ads.internal.client.AdSizeParcel, java.lang.String, com.google.android.gms.internal.zzew):com.google.android.gms.ads.internal.client.zzu");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        if (r6 == null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.ads.internal.client.zzu zzb(android.content.Context r15, com.google.android.gms.ads.internal.client.AdSizeParcel r16, java.lang.String r17, com.google.android.gms.internal.zzew r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            com.google.android.gms.ads.internal.util.client.zza r7 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r8 = r1
            boolean r7 = r7.zzU(r8)
            if (r7 == 0) goto L_0x0021
            r7 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = 2
            com.google.android.gms.ads.internal.client.zzu r7 = r7.zza(r8, r9, r10, r11, r12)
            r6 = r7
            r7 = r6
            if (r7 != 0) goto L_0x0044
        L_0x0021:
            java.lang.String r7 = "Using InterstitialAdManager from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r7)
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r7 = new com.google.android.gms.ads.internal.util.client.VersionInfoParcel
            r13 = r7
            r7 = r13
            r8 = r13
            r9 = 8487000(0x818058, float:1.189282E-38)
            r10 = 8487000(0x818058, float:1.189282E-38)
            r11 = 1
            r8.<init>(r9, r10, r11)
            r5 = r7
            com.google.android.gms.ads.internal.client.zzl r7 = com.google.android.gms.ads.internal.client.zzn.zzcU()
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r5
            com.google.android.gms.ads.internal.client.zzu r7 = r7.createInterstitialAdManager(r8, r9, r10, r11, r12)
            r6 = r7
        L_0x0044:
            r7 = r6
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zze.zzb(android.content.Context, com.google.android.gms.ads.internal.client.AdSizeParcel, java.lang.String, com.google.android.gms.internal.zzew):com.google.android.gms.ads.internal.client.zzu");
    }

    /* access modifiers changed from: protected */
    /* renamed from: zze */
    public zzv zzd(IBinder iBinder) {
        return zzv.zza.zzl(iBinder);
    }
}
