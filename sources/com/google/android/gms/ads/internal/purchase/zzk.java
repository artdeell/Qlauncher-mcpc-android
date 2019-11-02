package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzk {
    private final String zzuM;

    public zzk(String str) {
        this.zzuM = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        String str2 = str;
        int i2 = i;
        Intent intent2 = intent;
        if (!(str2 == null || intent2 == null)) {
            String zze = zzr.zzbM().zze(intent2);
            String zzf = zzr.zzbM().zzf(intent2);
            if (!(zze == null || zzf == null)) {
                if (!str2.equals(zzr.zzbM().zzaq(zze))) {
                    zzin.zzaK("Developer payload not match.");
                    return false;
                } else if (this.zzuM == null || zzl.zzc(this.zzuM, zze, zzf)) {
                    return true;
                } else {
                    zzin.zzaK("Fail to verify signature.");
                    return false;
                }
            }
        }
        return false;
    }

    public String zzfZ() {
        return zzr.zzbC().zzhs();
    }
}
