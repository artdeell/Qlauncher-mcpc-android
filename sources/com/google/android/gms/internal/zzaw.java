package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzhb
public final class zzaw {
    private final boolean zzsA;
    private final String zzsv;
    private final JSONObject zzsw;
    private final String zzsx;
    private final String zzsy;
    private final boolean zzsz;

    public zzaw(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        String str3 = str;
        String str4 = str2;
        JSONObject jSONObject2 = jSONObject;
        boolean z3 = z;
        boolean z4 = z2;
        this.zzsy = versionInfoParcel.afmaVersion;
        this.zzsw = jSONObject2;
        this.zzsx = str3;
        this.zzsv = str4;
        this.zzsz = z3;
        this.zzsA = z4;
    }

    public String zzcr() {
        return this.zzsv;
    }

    public String zzcs() {
        return this.zzsy;
    }

    public JSONObject zzct() {
        return this.zzsw;
    }

    public String zzcu() {
        return this.zzsx;
    }

    public boolean zzcv() {
        return this.zzsz;
    }

    public boolean zzcw() {
        return this.zzsA;
    }
}
