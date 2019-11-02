package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzk.zza;
import com.google.android.gms.internal.zzhb;
import java.lang.ref.WeakReference;

@zzhb
public final class zzg extends zza {
    private final WeakReference<zzc.zza> zzHR;

    public zzg(zzc.zza zza) {
        WeakReference<zzc.zza> weakReference;
        WeakReference<zzc.zza> weakReference2 = weakReference;
        WeakReference<zzc.zza> weakReference3 = new WeakReference<>(zza);
        this.zzHR = weakReference2;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        zzc.zza zza = (zzc.zza) this.zzHR.get();
        if (zza != null) {
            zza.zzb(adResponseParcel2);
        }
    }
}
