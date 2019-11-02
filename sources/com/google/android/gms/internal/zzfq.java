package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfq {
    private final boolean zzDu;
    private final boolean zzDv;
    private final boolean zzDw;
    private final boolean zzDx;
    private final boolean zzDy;

    public static final class zza {
        /* access modifiers changed from: private */
        public boolean zzDu;
        /* access modifiers changed from: private */
        public boolean zzDv;
        /* access modifiers changed from: private */
        public boolean zzDw;
        /* access modifiers changed from: private */
        public boolean zzDx;
        /* access modifiers changed from: private */
        public boolean zzDy;

        public zza() {
        }

        public zzfq zzeP() {
            zzfq zzfq;
            zzfq zzfq2 = zzfq;
            zzfq zzfq3 = new zzfq(this, null);
            return zzfq2;
        }

        public zza zzq(boolean z) {
            this.zzDu = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzDv = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzDw = z;
            return this;
        }

        public zza zzt(boolean z) {
            this.zzDx = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzDy = z;
            return this;
        }
    }

    private zzfq(zza zza2) {
        zza zza3 = zza2;
        this.zzDu = zza3.zzDu;
        this.zzDv = zza3.zzDv;
        this.zzDw = zza3.zzDw;
        this.zzDx = zza3.zzDx;
        this.zzDy = zza3.zzDy;
    }

    /* synthetic */ zzfq(zza zza2, C03731 r7) {
        C03731 r2 = r7;
        this(zza2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            return jSONObject2.put("sms", this.zzDu).put("tel", this.zzDv).put("calendar", this.zzDw).put("storePicture", this.zzDx).put("inlineVideo", this.zzDy);
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
