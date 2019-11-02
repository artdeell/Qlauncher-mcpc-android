package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzb;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.Map;
import java.util.concurrent.Future;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzds implements zzdf {
    public zzds() {
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        int i;
        zzdp zzdp;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        zzdq zzbR = zzr.zzbR();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get("src");
            if (str == null) {
                zzin.zzaK("Precache video action is missing the src parameter.");
                return;
            }
            try {
                i = Integer.parseInt((String) map2.get("player"));
            } catch (NumberFormatException e) {
                NumberFormatException numberFormatException = e;
                i = 0;
            }
            String str2 = map2.containsKey(MimeTypeParser.ATTR_MIMETYPE) ? (String) map2.get(MimeTypeParser.ATTR_MIMETYPE) : LibrariesRepository.MOJANG_MAVEN_REPO;
            if (zzbR.zze(zzjp2)) {
                zzin.zzaK("Precache task already running.");
                return;
            }
            zzb.zzv(zzjp2.zzhR());
            zzdp zzdp2 = zzdp;
            zzdp zzdp3 = new zzdp(zzjp2, zzjp2.zzhR().zzpw.zza(zzjp2, i, str2), str);
            Future zzhn = zzdp2.zzgd();
        } else if (!zzbR.zzd(zzjp2)) {
            zzin.zzaK("Precache abort but no preload task running.");
        }
    }
}
