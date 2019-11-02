package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzdk implements zzdf {
    final HashMap<String, zzjd<JSONObject>> zzzz;

    public zzdk() {
        HashMap<String, zzjd<JSONObject>> hashMap;
        HashMap<String, zzjd<JSONObject>> hashMap2 = hashMap;
        HashMap<String, zzjd<JSONObject>> hashMap3 = new HashMap<>();
        this.zzzz = hashMap2;
    }

    public Future<JSONObject> zzR(String str) {
        zzjd zzjd;
        String str2 = str;
        zzjd zzjd2 = zzjd;
        zzjd zzjd3 = new zzjd();
        zzjd zzjd4 = zzjd2;
        Object put = this.zzzz.put(str2, zzjd4);
        return zzjd4;
    }

    public void zzS(String str) {
        String str2 = str;
        zzjd zzjd = (zzjd) this.zzzz.get(str2);
        if (zzjd == null) {
            zzin.m19e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzjd.isDone()) {
            boolean cancel = zzjd.cancel(true);
        }
        Object remove = this.zzzz.remove(str2);
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        zzd((String) map2.get("request_id"), (String) map2.get("fetched_ad"));
    }

    public void zzd(String str, String str2) {
        JSONObject jSONObject;
        String str3 = str;
        String str4 = str2;
        zzin.zzaI("Received ad from the cache.");
        zzjd zzjd = (zzjd) this.zzzz.get(str3);
        if (zzjd == null) {
            zzin.m19e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        zzjd zzjd2 = zzjd;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(str4);
            zzjd2.zzg(jSONObject2);
            Object remove = this.zzzz.remove(str3);
        } catch (JSONException e) {
            zzin.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzjd.zzg(null);
            Object remove2 = this.zzzz.remove(str3);
        } catch (Throwable th) {
            Throwable th2 = th;
            Object remove3 = this.zzzz.remove(str3);
            throw th2;
        }
    }
}
