package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzet {
    public zzet() {
    }

    public List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        ArrayList arrayList;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(optJSONArray.length());
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < optJSONArray.length(); i++) {
            boolean add = arrayList4.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList4);
    }

    public void zza(Context context, String str, zzif zzif, String str2, boolean z, List<String> list) {
        zziy zziy;
        Context context2 = context;
        String str3 = str;
        zzif zzif2 = zzif;
        String str4 = str2;
        boolean z2 = z;
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            String str5 = z2 ? "1" : "0";
            for (String replaceAll : list2) {
                String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", str4).replaceAll("@gw_adnetrefresh@", str5).replaceAll("@gw_qdata@", zzif2.zzKV.zzBT).replaceAll("@gw_sdkver@", str3).replaceAll("@gw_sessid@", zzr.zzbF().getSessionId()).replaceAll("@gw_seqnum@", zzif2.zzHw);
                if (zzif2.zzCp != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", zzif2.zzCp.zzBA).replaceAll("@gw_allocid@", zzif2.zzCp.zzBC);
                }
                zziy zziy2 = zziy;
                zziy zziy3 = new zziy(context2, str3, replaceAll2);
                Future zzhn = zziy2.zzgd();
            }
        }
    }
}
