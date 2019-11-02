package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzgw.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzgx implements zza<zzd> {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgx(boolean z, boolean z2) {
        boolean z3 = z2;
        this.zzHc = z;
        this.zzHd = z3;
    }

    /* renamed from: zzb */
    public zzd zza(zzgw zzgw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        ArrayList arrayList;
        zzd zzd;
        Bundle bundle;
        zzgw zzgw2 = zzgw;
        JSONObject jSONObject2 = jSONObject;
        List<zzjg> zza = zzgw2.zza(jSONObject2, "images", true, this.zzHc, this.zzHd);
        zzjg zza2 = zzgw2.zza(jSONObject2, "app_icon", true, this.zzHc);
        zzjg zzf = zzgw2.zzf(jSONObject2);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzjg zzjg : zza) {
            boolean add = arrayList4.add(zzjg.get());
        }
        zzd zzd2 = zzd;
        String string = jSONObject2.getString("headline");
        ArrayList arrayList5 = arrayList4;
        String string2 = jSONObject2.getString("body");
        zzch zzch = (zzch) zza2.get();
        String string3 = jSONObject2.getString("call_to_action");
        double optDouble = jSONObject2.optDouble("rating", -1.0d);
        String optString = jSONObject2.optString("store");
        String optString2 = jSONObject2.optString("price");
        com.google.android.gms.ads.internal.formats.zza zza3 = (com.google.android.gms.ads.internal.formats.zza) zzf.get();
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        zzd zzd3 = new zzd(string, arrayList5, string2, zzch, string3, optDouble, optString, optString2, zza3, bundle2);
        return zzd2;
    }
}
