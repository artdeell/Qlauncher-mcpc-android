package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public class zzfo {
    private final boolean zzDp;
    private final String zzDq;
    private final zzjp zzpD;

    public zzfo(zzjp zzjp, Map<String, String> map) {
        Map<String, String> map2 = map;
        this.zzpD = zzjp;
        this.zzDq = (String) map2.get("forceOrientation");
        if (map2.containsKey("allowOrientationChange")) {
            this.zzDp = Boolean.parseBoolean((String) map2.get("allowOrientationChange"));
            return;
        }
        this.zzDp = true;
    }

    public void execute() {
        if (this.zzpD == null) {
            zzin.zzaK("AdWebView is null");
            return;
        }
        int zzhx = "portrait".equalsIgnoreCase(this.zzDq) ? zzr.zzbE().zzhw() : "landscape".equalsIgnoreCase(this.zzDq) ? zzr.zzbE().zzhv() : this.zzDp ? -1 : zzr.zzbE().zzhx();
        this.zzpD.setRequestedOrientation(zzhx);
    }
}
