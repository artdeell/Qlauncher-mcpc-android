package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zze;
import java.util.Map;

@zzhb
public class zzdl implements zzdf {
    static final Map<String, Integer> zzzC = zzmr.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    private final zze zzzA;
    private final zzfn zzzB;

    public zzdl(zze zze, zzfn zzfn) {
        zzfn zzfn2 = zzfn;
        this.zzzA = zze;
        this.zzzB = zzfn2;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzfo zzfo;
        zzfp zzfp;
        zzfm zzfm;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        int intValue = ((Integer) zzzC.get((String) map2.get("a"))).intValue();
        if (intValue == 5 || this.zzzA == null || this.zzzA.zzbh()) {
            switch (intValue) {
                case 1:
                    this.zzzB.zzi(map2);
                    return;
                case 3:
                    zzfp zzfp2 = zzfp;
                    zzfp zzfp3 = new zzfp(zzjp2, map2);
                    zzfp2.execute();
                    return;
                case 4:
                    zzfm zzfm2 = zzfm;
                    zzfm zzfm3 = new zzfm(zzjp2, map2);
                    zzfm2.execute();
                    return;
                case 5:
                    zzfo zzfo2 = zzfo;
                    zzfo zzfo3 = new zzfo(zzjp2, map2);
                    zzfo2.execute();
                    return;
                case 6:
                    this.zzzB.zzp(true);
                    return;
                default:
                    zzin.zzaJ("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzzA.zzq(null);
        }
    }
}
