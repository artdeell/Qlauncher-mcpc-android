package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzen {
    public final String zzBA;
    public final List<String> zzBB;
    public final String zzBC;
    public final String zzBD;
    public final List<String> zzBE;
    public final List<String> zzBF;
    public final String zzBG;
    public final List<String> zzBH;
    public final List<String> zzBI;
    public final String zzBJ;
    public final String zzBK;
    public final String zzBL;
    public final List<String> zzBM;
    public final String zzBN;
    public final String zzBz;

    public zzen(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10) {
        String str11 = str2;
        List<String> list7 = list;
        String str12 = str3;
        String str13 = str4;
        List<String> list8 = list2;
        List<String> list9 = list3;
        String str14 = str5;
        String str15 = str6;
        List<String> list10 = list4;
        List<String> list11 = list5;
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        List<String> list12 = list6;
        String str19 = str10;
        this.zzBz = str;
        this.zzBA = str11;
        this.zzBB = list7;
        this.zzBC = str12;
        this.zzBD = str13;
        this.zzBE = list8;
        this.zzBF = list9;
        this.zzBG = str14;
        this.zzBH = list10;
        this.zzBI = list11;
        this.zzBJ = str16;
        this.zzBK = str17;
        this.zzBL = str18;
        this.zzBM = list12;
        this.zzBN = str19;
    }

    public zzen(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList;
        JSONObject jSONObject2 = jSONObject;
        this.zzBA = jSONObject2.getString("id");
        JSONArray jSONArray = jSONObject2.getJSONArray("adapters");
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < jSONArray.length(); i++) {
            boolean add = arrayList4.add(jSONArray.getString(i));
        }
        this.zzBB = Collections.unmodifiableList(arrayList4);
        this.zzBC = jSONObject2.optString("allocation_id", null);
        this.zzBE = zzr.zzbP().zza(jSONObject2, "clickurl");
        this.zzBF = zzr.zzbP().zza(jSONObject2, "imp_urls");
        this.zzBH = zzr.zzbP().zza(jSONObject2, "video_start_urls");
        this.zzBI = zzr.zzbP().zza(jSONObject2, "video_complete_urls");
        JSONObject optJSONObject = jSONObject2.optJSONObject("ad");
        this.zzBz = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
        this.zzBG = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzBD = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzBJ = jSONObject2.optString("html_template", null);
        this.zzBK = jSONObject2.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject2.optJSONObject("assets");
        this.zzBL = optJSONObject3 != null ? optJSONObject3.toString() : null;
        this.zzBM = zzr.zzbP().zza(jSONObject2, "template_ids");
        JSONObject optJSONObject4 = jSONObject2.optJSONObject("ad_loader_options");
        String str = null;
        if (optJSONObject4 != null) {
            str = optJSONObject4.toString();
        }
        this.zzBN = str;
    }
}
