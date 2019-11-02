package com.google.android.gms.internal;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfs {
    private final String zzDJ;
    private final zzjp zzpD;

    public zzfs(zzjp zzjp) {
        this(zzjp, LibrariesRepository.MOJANG_MAVEN_REPO);
    }

    public zzfs(zzjp zzjp, String str) {
        String str2 = str;
        this.zzpD = zzjp;
        this.zzDJ = str2;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        JSONObject jSONObject;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        float f2 = f;
        int i10 = i5;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onScreenInfoChanged", jSONObject2.put("width", i6).put("height", i7).put("maxSizeWidth", i8).put("maxSizeHeight", i9).put("density", (double) f2).put("rotation", i10));
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzam(String str) {
        JSONObject jSONObject;
        String str2 = str;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onError", jSONObject2.put("message", str2).put("action", this.zzDJ));
        } catch (JSONException e) {
            zzin.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzan(String str) {
        JSONObject jSONObject;
        String str2 = str;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onReadyEventReceived", jSONObject2.put("js", str2));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzao(String str) {
        JSONObject jSONObject;
        String str2 = str;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onStateChanged", jSONObject2.put("state", str2));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        JSONObject jSONObject;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onSizeChanged", jSONObject2.put("x", i5).put("y", i6).put("width", i7).put("height", i8));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        JSONObject jSONObject;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            this.zzpD.zzb("onDefaultPositionReceived", jSONObject2.put("x", i5).put("y", i6).put("width", i7).put("height", i8));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching default position.", e);
        }
    }
}
