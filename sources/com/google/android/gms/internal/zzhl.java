package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzhb
public abstract class zzhl {
    public zzhl() {
    }

    public abstract void zza(Context context, zzhf zzhf, VersionInfoParcel versionInfoParcel);

    /* access modifiers changed from: protected */
    public void zze(zzhf zzhf) {
        zzhf zzhf2 = zzhf;
        zzhf2.zzgD();
        if (zzhf2.zzgB() != null) {
            zzhf2.zzgB().release();
        }
    }
}
