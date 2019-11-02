package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzd extends zzg<zzt> {
    private static final zzd zztB;

    static {
        zzd zzd;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd();
        zztB = zzd2;
    }

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r4 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.client.zzs zza(android.content.Context r11, java.lang.String r12, com.google.android.gms.internal.zzew r13) {
        /*
            r0 = r11
            r1 = r12
            r2 = r13
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r6 = r0
            boolean r5 = r5.zzU(r6)
            if (r5 == 0) goto L_0x001b
            com.google.android.gms.ads.internal.client.zzd r5 = zztB
            r6 = r0
            r7 = r1
            r8 = r2
            com.google.android.gms.ads.internal.client.zzs r5 = r5.zzb(r6, r7, r8)
            r4 = r5
            r5 = r4
            if (r5 != 0) goto L_0x003d
        L_0x001b:
            java.lang.String r5 = "Using AdLoader from the client jar."
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
            r6 = r0
            r7 = r1
            r8 = r2
            r9 = r3
            com.google.android.gms.ads.internal.client.zzs r5 = r5.createAdLoaderBuilder(r6, r7, r8, r9)
            r4 = r5
        L_0x003d:
            r5 = r4
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzd.zza(android.content.Context, java.lang.String, com.google.android.gms.internal.zzew):com.google.android.gms.ads.internal.client.zzs");
    }

    private zzs zzb(Context context, String str, zzew zzew) {
        Context context2 = context;
        String str2 = str;
        zzew zzew2 = zzew;
        try {
            return zza.zzi(((zzt) zzaB(context2)).zza(zze.zzC(context2), str2, zzew2, 8487000));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzc */
    public zzt zzd(IBinder iBinder) {
        return zzt.zza.zzj(iBinder);
    }
}
