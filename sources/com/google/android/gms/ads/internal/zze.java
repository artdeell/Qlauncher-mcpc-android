package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;

@zzhb
public class zze {
    private boolean zzpA;
    private boolean zzpB;
    private zza zzpz;

    public interface zza {
        void zzr(String str);
    }

    @zzhb
    public static class zzb implements zza {
        private final com.google.android.gms.internal.zzif.zza zzpC;
        private final zzjp zzpD;

        public zzb(com.google.android.gms.internal.zzif.zza zza, zzjp zzjp) {
            zzjp zzjp2 = zzjp;
            this.zzpC = zza;
            this.zzpD = zzjp2;
        }

        public void zzr(String str) {
            Builder builder;
            String str2 = str;
            zzin.zzaI("An auto-clicking creative is blocked");
            Builder builder2 = builder;
            Builder builder3 = new Builder();
            Builder builder4 = builder2;
            Builder scheme = builder4.scheme("https");
            Builder path = builder4.path("//pagead2.googlesyndication.com/pagead/gen_204");
            Builder appendQueryParameter = builder4.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str2)) {
                Builder appendQueryParameter2 = builder4.appendQueryParameter("navigationURL", str2);
            }
            if (!(this.zzpC == null || this.zzpC.zzLe == null || TextUtils.isEmpty(this.zzpC.zzLe.zzHY))) {
                Builder appendQueryParameter3 = builder4.appendQueryParameter("debugDialog", this.zzpC.zzLe.zzHY);
            }
            zzr.zzbC().zzc(this.zzpD.getContext(), this.zzpD.zzhX().afmaVersion, builder4.toString());
        }
    }

    public zze() {
        this.zzpB = ((Boolean) zzbt.zzvI.get()).booleanValue();
    }

    public zze(boolean z) {
        this.zzpB = z;
    }

    public void recordClick() {
        this.zzpA = true;
    }

    public void zza(zza zza2) {
        zza zza3 = zza2;
        this.zzpz = zza3;
    }

    public boolean zzbh() {
        return !this.zzpB || this.zzpA;
    }

    public void zzq(String str) {
        String str2 = str;
        zzin.zzaI("Action was blocked because no click was detected.");
        if (this.zzpz != null) {
            this.zzpz.zzr(str2);
        }
    }
}
