package com.google.android.gms.internal;

import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.internal.zzgw.zza;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzgz implements zza<zzf> {
    private final boolean zzHc;

    public zzgz(boolean z) {
        this.zzHc = z;
    }

    private void zza(zzgw zzgw, JSONObject jSONObject, SimpleArrayMap<String, Future<zzc>> simpleArrayMap) throws JSONException {
        zzgw zzgw2 = zzgw;
        JSONObject jSONObject2 = jSONObject;
        Object put = simpleArrayMap.put(jSONObject2.getString("name"), zzgw2.zza(jSONObject2, "image_value", this.zzHc));
    }

    private void zza(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        Object put = simpleArrayMap.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
    }

    private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap simpleArrayMap2;
        SimpleArrayMap<K, Future<V>> simpleArrayMap3 = simpleArrayMap;
        SimpleArrayMap simpleArrayMap4 = simpleArrayMap2;
        SimpleArrayMap simpleArrayMap5 = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap6 = simpleArrayMap4;
        for (int i = 0; i < simpleArrayMap3.size(); i++) {
            Object put = simpleArrayMap6.put(simpleArrayMap3.keyAt(i), ((Future) simpleArrayMap3.valueAt(i)).get());
        }
        return simpleArrayMap6;
    }

    /* renamed from: zzd */
    public zzf zza(zzgw zzgw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap simpleArrayMap2;
        zzf zzf;
        StringBuilder sb;
        zzgw zzgw2 = zzgw;
        JSONObject jSONObject2 = jSONObject;
        SimpleArrayMap simpleArrayMap3 = simpleArrayMap;
        SimpleArrayMap simpleArrayMap4 = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap5 = simpleArrayMap3;
        SimpleArrayMap simpleArrayMap6 = simpleArrayMap2;
        SimpleArrayMap simpleArrayMap7 = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap8 = simpleArrayMap6;
        zzjg zzf2 = zzgw2.zzf(jSONObject2);
        JSONArray jSONArray = jSONObject2.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            String string = jSONObject3.getString(MimeTypeParser.TAG_TYPE);
            if ("string".equals(string)) {
                zza(jSONObject3, simpleArrayMap8);
            } else if ("image".equals(string)) {
                zza(zzgw2, jSONObject3, simpleArrayMap5);
            } else {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Unknown custom asset type: ").append(string).toString());
            }
        }
        zzf zzf3 = zzf;
        zzf zzf4 = new zzf(jSONObject2.getString("custom_template_id"), zzc(simpleArrayMap5), simpleArrayMap8, (com.google.android.gms.ads.internal.formats.zza) zzf2.get());
        return zzf3;
    }
}
