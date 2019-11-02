package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzhb
public class zzaz extends zzau {
    private final zzeh zzsE;

    public zzaz(Context context, AdSizeParcel adSizeParcel, zzif zzif, VersionInfoParcel versionInfoParcel, zzbb zzbb, zzeh zzeh) {
        StringBuilder sb;
        zzeh zzeh2 = zzeh;
        super(context, adSizeParcel, zzif, versionInfoParcel, zzbb);
        this.zzsE = zzeh2;
        zzb(this.zzsE);
        zzcd();
        zzh(false);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("Tracking ad unit: ").append(this.zzrZ.zzcu()).toString());
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                super.destroy();
                zzc(this.zzsE);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        this.zzsE.zza("AFMA_updateActiveView", jSONObject2);
    }

    public void zzcf() {
        destroy();
    }

    /* access modifiers changed from: protected */
    public boolean zzcl() {
        return true;
    }
}
