package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

@zzhb
public final class zzgj extends zzg<zzgf> {
    private static final zzgj zzGa;

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    static {
        zzgj zzgj;
        zzgj zzgj2 = zzgj;
        zzgj zzgj3 = new zzgj();
        zzGa = zzgj2;
    }

    private zzgj() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r3 == null) goto L_0x0013;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzge createInAppPurchaseManager(android.app.Activity r6) {
        /*
            r0 = r6
            r4 = r0
            boolean r4 = zzb(r4)     // Catch:{ zza -> 0x0027 }
            if (r4 != 0) goto L_0x0013
            com.google.android.gms.internal.zzgj r4 = zzGa     // Catch:{ zza -> 0x0027 }
            r5 = r0
            com.google.android.gms.internal.zzge r4 = r4.zzd(r5)     // Catch:{ zza -> 0x0027 }
            r3 = r4
            r4 = r3
            if (r4 != 0) goto L_0x0024
        L_0x0013:
            java.lang.String r4 = "Using AdOverlay from the client jar."
            com.google.android.gms.internal.zzin.zzaI(r4)     // Catch:{ zza -> 0x0027 }
            com.google.android.gms.ads.internal.client.zzl r4 = com.google.android.gms.ads.internal.client.zzn.zzcU()     // Catch:{ zza -> 0x0027 }
            r5 = r0
            com.google.android.gms.internal.zzge r4 = r4.createInAppPurchaseManager(r5)     // Catch:{ zza -> 0x0027 }
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
            com.google.android.gms.internal.zzin.zzaK(r4)
            r4 = 0
            r0 = r4
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgj.createInAppPurchaseManager(android.app.Activity):com.google.android.gms.internal.zzge");
    }

    private static boolean zzb(Activity activity) throws zza {
        zza zza2;
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        zza zza3 = zza2;
        zza zza4 = new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        throw zza3;
    }

    private zzge zzd(Activity activity) {
        Activity activity2 = activity;
        try {
            return com.google.android.gms.internal.zzge.zza.zzQ(((zzgf) zzaB(activity2)).zzf(zze.zzC(activity2)));
        } catch (RemoteException e) {
            zzin.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            zzin.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzU */
    public zzgf zzd(IBinder iBinder) {
        return com.google.android.gms.internal.zzgf.zza.zzR(iBinder);
    }
}
