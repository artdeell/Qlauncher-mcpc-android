package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public final class zzdd implements zzdf {
    public zzdd() {
    }

    private void zzb(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("label");
        String str2 = (String) map2.get("start_label");
        String str3 = (String) map2.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzin.zzaK("No timestamp given for CSI tick.");
        } else {
            try {
                long zzc = zzc(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                zzjp2.zzic().zza(str, str2, zzc);
            } catch (NumberFormatException e) {
                zzin.zzd("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private long zzc(long j) {
        return zzr.zzbG().elapsedRealtime() + (j - zzr.zzbG().currentTimeMillis());
    }

    private void zzc(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No value given for CSI experiment.");
            return;
        }
        zzcb zzdA = zzjp2.zzic().zzdA();
        if (zzdA == null) {
            zzin.zzaK("No ticker for WebView, dropping experiment ID.");
        } else {
            zzdA.zzc("e", str);
        }
    }

    private void zzd(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("name");
        String str2 = (String) map2.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzin.zzaK("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No name given for CSI extra.");
        } else {
            zzcb zzdA = zzjp2.zzic().zzdA();
            if (zzdA == null) {
                zzin.zzaK("No ticker for WebView, dropping extra parameter.");
            } else {
                zzdA.zzc(str, str2);
            }
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("action");
        if ("tick".equals(str)) {
            zzb(zzjp2, map2);
        } else if ("experiment".equals(str)) {
            zzc(zzjp2, map2);
        } else if ("extra".equals(str)) {
            zzd(zzjp2, map2);
        }
    }
}
