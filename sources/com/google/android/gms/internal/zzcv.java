package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzcj.zza;

@zzhb
public class zzcv extends zzg<zzck> {
    public zzcv() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzcj zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable th;
        Context context2 = context;
        FrameLayout frameLayout3 = frameLayout;
        FrameLayout frameLayout4 = frameLayout2;
        try {
            return zza.zzu(((zzck) zzaB(context2)).zza(zze.zzC(context2), zze.zzC(frameLayout3), zze.zzC(frameLayout4), 8487000));
        } catch (RemoteException e) {
            th = e;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", th);
            return null;
        } catch (zzg.zza e2) {
            th = e2;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzD */
    public zzck zzd(IBinder iBinder) {
        return zzck.zza.zzv(iBinder);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r4 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzcj zza(android.content.Context r10, android.widget.FrameLayout r11, android.widget.FrameLayout r12) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzn.zzcS()
            r6 = r1
            boolean r5 = r5.zzU(r6)
            if (r5 == 0) goto L_0x001b
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r3
            com.google.android.gms.internal.zzcj r5 = r5.zzb(r6, r7, r8)
            r4 = r5
            r5 = r4
            if (r5 != 0) goto L_0x002b
        L_0x001b:
            java.lang.String r5 = "Using NativeAdViewDelegate from the client jar."
            com.google.android.gms.ads.internal.util.client.zzb.zzaI(r5)
            com.google.android.gms.ads.internal.client.zzl r5 = com.google.android.gms.ads.internal.client.zzn.zzcU()
            r6 = r2
            r7 = r3
            com.google.android.gms.internal.zzcj r5 = r5.createNativeAdViewDelegate(r6, r7)
            r4 = r5
        L_0x002b:
            r5 = r4
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcv.zza(android.content.Context, android.widget.FrameLayout, android.widget.FrameLayout):com.google.android.gms.internal.zzcj");
    }
}
