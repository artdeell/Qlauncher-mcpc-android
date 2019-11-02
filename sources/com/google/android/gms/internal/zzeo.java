package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzeo {
    public final List<zzen> zzBO;
    public final long zzBP;
    public final List<String> zzBQ;
    public final List<String> zzBR;
    public final List<String> zzBS;
    public final String zzBT;
    public final long zzBU;
    public final String zzBV;
    public final int zzBW;
    public final int zzBX;
    public final long zzBY;
    public int zzBZ;
    public int zzCa;

    public zzeo(String str) throws JSONException {
        JSONObject jSONObject;
        ArrayList arrayList;
        zzen zzen;
        StringBuilder sb;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject(str);
        JSONObject jSONObject4 = jSONObject2;
        if (zzin.zzQ(2)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.m20v(sb2.append("Mediation Response JSON: ").append(jSONObject4.toString(2)).toString());
        }
        JSONArray jSONArray = jSONObject4.getJSONArray("ad_networks");
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        ArrayList arrayList4 = arrayList2;
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzen zzen2 = zzen;
            zzen zzen3 = new zzen(jSONArray.getJSONObject(i2));
            zzen zzen4 = zzen2;
            boolean add = arrayList4.add(zzen4);
            if (i < 0 && zza(zzen4)) {
                i = i2;
            }
        }
        this.zzBZ = i;
        this.zzCa = jSONArray.length();
        this.zzBO = Collections.unmodifiableList(arrayList4);
        this.zzBT = jSONObject4.getString("qdata");
        this.zzBX = jSONObject4.optInt("fs_model_type", -1);
        this.zzBY = jSONObject4.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject4.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzBP = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzBQ = zzr.zzbP().zza(optJSONObject, "click_urls");
            this.zzBR = zzr.zzbP().zza(optJSONObject, "imp_urls");
            this.zzBS = zzr.zzbP().zza(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzBU = optLong > 0 ? optLong * 1000 : -1;
            RewardItemParcel zza = RewardItemParcel.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzBV = null;
                this.zzBW = 0;
                return;
            }
            this.zzBV = zza.type;
            this.zzBW = zza.zzKS;
            return;
        }
        this.zzBP = -1;
        this.zzBQ = null;
        this.zzBR = null;
        this.zzBS = null;
        this.zzBU = -1;
        this.zzBV = null;
        this.zzBW = 0;
    }

    public zzeo(List<zzen> list, long j, List<String> list2, List<String> list3, List<String> list4, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3) {
        long j4 = j;
        List<String> list5 = list2;
        List<String> list6 = list3;
        List<String> list7 = list4;
        String str3 = str;
        long j5 = j2;
        int i5 = i;
        int i6 = i2;
        String str4 = str2;
        int i7 = i3;
        int i8 = i4;
        long j6 = j3;
        this.zzBO = list;
        this.zzBP = j4;
        this.zzBQ = list5;
        this.zzBR = list6;
        this.zzBS = list7;
        this.zzBT = str3;
        this.zzBU = j5;
        this.zzBZ = i5;
        this.zzCa = i6;
        this.zzBV = str4;
        this.zzBW = i7;
        this.zzBX = i8;
        this.zzBY = j6;
    }

    private boolean zza(zzen zzen) {
        for (String equals : zzen.zzBB) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
