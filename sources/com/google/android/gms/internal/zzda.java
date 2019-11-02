package com.google.android.gms.internal;

import java.util.Map;

@zzhb
public final class zzda implements zzdf {
    private final zzdb zzyW;

    public zzda(zzdb zzdb) {
        this.zzyW = zzdb;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("name");
        if (str == null) {
            zzin.zzaK("App event with no name parameter.");
        } else {
            this.zzyW.onAppEvent(str, (String) map2.get("info"));
        }
    }
}
