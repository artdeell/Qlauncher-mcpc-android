package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzjr {
    public zzjr() {
    }

    public zzjp zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzan, versionInfoParcel, null, null);
    }

    public zzjp zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel, zzcb zzcb, zzd zzd) {
        zzjs zzjs;
        boolean z3 = z2;
        zzjs zzjs2 = zzjs;
        zzjs zzjs3 = new zzjs(zzjt.zzb(context, adSizeParcel, z, z3, zzan, versionInfoParcel, zzcb, zzd));
        zzjs zzjs4 = zzjs2;
        zzjs4.setWebViewClient(zzr.zzbE().zzb((zzjp) zzjs4, z3));
        zzjs4.setWebChromeClient(zzr.zzbE().zzk(zzjs4));
        return zzjs4;
    }
}
