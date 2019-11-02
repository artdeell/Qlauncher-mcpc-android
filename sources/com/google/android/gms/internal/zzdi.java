package com.google.android.gms.internal;

import java.util.Map;

@zzhb
public class zzdi implements zzdf {
    private final zzdj zzzy;

    public zzdi(zzdj zzdj) {
        this.zzzy = zzdj;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        float f;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        boolean equals = "1".equals(map2.get("transparentBackground"));
        boolean equals2 = "1".equals(map2.get("blur"));
        try {
            if (map2.get("blurRadius") != null) {
                f = Float.parseFloat((String) map2.get("blurRadius"));
                this.zzzy.zzd(equals);
                this.zzzy.zza(equals2, f);
            }
        } catch (NumberFormatException e) {
            zzin.zzb("Fail to parse float", e);
        }
        f = 0.0f;
        this.zzzy.zzd(equals);
        this.zzzy.zza(equals2, f);
    }
}
