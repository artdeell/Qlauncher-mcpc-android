package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzgw.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzgy implements zza<zze> {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgy(boolean z, boolean z2) {
        boolean z3 = z2;
        this.zzHc = z;
        this.zzHd = z3;
    }

    /* renamed from: zzc */
    public zze zza(zzgw zzgw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        ArrayList arrayList;
        zze zze;
        Bundle bundle;
        zzgw zzgw2 = zzgw;
        JSONObject jSONObject2 = jSONObject;
        List<zzjg> zza = zzgw2.zza(jSONObject2, "images", true, this.zzHc, this.zzHd);
        zzjg zza2 = zzgw2.zza(jSONObject2, "secondary_image", false, this.zzHc);
        zzjg zzf = zzgw2.zzf(jSONObject2);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzjg zzjg : zza) {
            boolean add = arrayList4.add(zzjg.get());
        }
        zze zze2 = zze;
        String string = jSONObject2.getString("headline");
        ArrayList arrayList5 = arrayList4;
        String string2 = jSONObject2.getString("body");
        zzch zzch = (zzch) zza2.get();
        String string3 = jSONObject2.getString("call_to_action");
        String string4 = jSONObject2.getString("advertiser");
        com.google.android.gms.ads.internal.formats.zza zza3 = (com.google.android.gms.ads.internal.formats.zza) zzf.get();
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        zze zze3 = new zze(string, arrayList5, string2, zzch, string3, string4, zza3, bundle2);
        return zze2;
    }
}
