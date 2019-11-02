package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

@zzhb
public final class zzfu extends zzg<zzfw> {
    private static final zzfu zzFp;

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    static {
        zzfu zzfu;
        zzfu zzfu2 = zzfu;
        zzfu zzfu3 = new zzfu();
        zzFp = zzfu2;
    }

    private zzfu() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r3 == null) goto L_0x0013;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzfv createAdOverlay(android.app.Activity r6) {
        /*
            r0 = r6
            r4 = r0
            boolean r4 = zzb(r4)     // Catch:{ zza -> 0x0027 }
            if (r4 != 0) goto L_0x0013
            com.google.android.gms.internal.zzfu r4 = zzFp     // Catch:{ zza -> 0x0027 }
            r5 = r0
            com.google.android.gms.internal.zzfv r4 = r4.zzc(r5)     // Catch:{ zza -> 0x0027 }
            r3 = r4
            r4 = r3
            if (r4 != 0) goto L_0x0024
        L_0x0013:
            java.lang.String r4 = "Using AdOverlay from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaI(r4)     // Catch:{ zza -> 0x0027 }
            com.google.android.gms.ads.internal.client.zzl r4 = com.google.android.gms.ads.internal.client.zzn.zzcU()     // Catch:{ zza -> 0x0027 }
            r5 = r0
            com.google.android.gms.internal.zzfv r4 = r4.createAdOverlay(r5)     // Catch:{ zza -> 0x0027 }
            r2 = r4
            r4 = r2
            r3 = r4
        L_0x0024:
            r4 = r3
            r0 = r4
        L_0x0026:
            return r0
        L_0x0027:
            r4 = move-exception
            r1 = r4
            r4 = r1
            java.lang.String r4 = r4.getMessage()
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r4)
            r4 = 0
            r0 = r4
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfu.createAdOverlay(android.app.Activity):com.google.android.gms.internal.zzfv");
    }

    private static boolean zzb(Activity activity) throws zza {
        zza zza2;
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        zza zza3 = zza2;
        zza zza4 = new zza("Ad overlay requires the useClientJar flag in intent extras.");
        throw zza3;
    }

    private zzfv zzc(Activity activity) {
        Activity activity2 = activity;
        try {
            return com.google.android.gms.internal.zzfv.zza.zzL(((zzfw) zzaB(activity2)).zze(zze.zzC(activity2)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzK */
    public zzfw zzd(IBinder iBinder) {
        return com.google.android.gms.internal.zzfw.zza.zzM(iBinder);
    }
}
