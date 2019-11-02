package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzce.zza;

@zzhb
public final class zzcc extends zza {
    private final zzg zzxE;
    private final String zzxF;
    private final String zzxG;

    public zzcc(zzg zzg, String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.zzxE = zzg;
        this.zzxF = str3;
        this.zzxG = str4;
    }

    public String getContent() {
        return this.zzxG;
    }

    public void recordClick() {
        this.zzxE.zzbd();
    }

    public void recordImpression() {
        this.zzxE.zzbe();
    }

    public void zzb(zzd zzd) {
        zzd zzd2 = zzd;
        if (zzd2 != null) {
            this.zzxE.zzc((View) zze.zzp(zzd2));
        }
    }

    public String zzdF() {
        return this.zzxF;
    }
}
