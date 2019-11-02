package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzde {
    public static final zzdf zzyX;
    public static final zzdf zzyY;
    public static final zzdf zzyZ;
    public static final zzdf zzza;
    public static final zzdf zzzb;
    public static final zzdf zzzc;
    public static final zzdf zzzd;
    public static final zzdf zzze;
    public static final zzdf zzzf;
    public static final zzdf zzzg;
    public static final zzdf zzzh;
    public static final zzdf zzzi;
    public static final zzdf zzzj;
    public static final zzdf zzzk;

    static {
        C02851 r2;
        C02904 r22;
        C02915 r23;
        C02926 r24;
        C02937 r25;
        C02948 r26;
        C02959 r27;
        C028610 r28;
        C028711 r29;
        C02882 r210;
        C02893 r211;
        zzdo zzdo;
        zzds zzds;
        zzdd zzdd;
        C02851 r0 = r2;
        C02851 r1 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
            }
        };
        zzyX = r0;
        C02904 r02 = r22;
        C02904 r12 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                HashMap hashMap;
                Intent intent;
                zzjp zzjp2 = zzjp;
                String str = (String) map.get("urls");
                if (TextUtils.isEmpty(str)) {
                    zzin.zzaK("URLs missing in canOpenURLs GMSG.");
                    return;
                }
                String[] split = str.split(",");
                HashMap hashMap2 = hashMap;
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = hashMap2;
                PackageManager packageManager = zzjp2.getContext().getPackageManager();
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    String str2 = split[i];
                    String[] split2 = str2.split(";", 2);
                    PackageManager packageManager2 = packageManager;
                    Intent intent2 = intent;
                    Intent intent3 = new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim()));
                    Object put = hashMap4.put(str2, Boolean.valueOf(packageManager2.resolveActivity(intent2, 65536) != null));
                }
                zzjp2.zza("openableURLs", (Map<String, ?>) hashMap4);
            }
        };
        zzyY = r02;
        C02915 r03 = r23;
        C02915 r13 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                JSONObject jSONObject;
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                JSONObject jSONObject4;
                Intent intent;
                ComponentName componentName;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                PackageManager packageManager = zzjp2.getContext().getPackageManager();
                try {
                    JSONObject jSONObject5 = jSONObject2;
                    JSONObject jSONObject6 = new JSONObject((String) map2.get("data"));
                    try {
                        JSONArray jSONArray = jSONObject5.getJSONArray("intents");
                        JSONObject jSONObject7 = jSONObject4;
                        JSONObject jSONObject8 = new JSONObject();
                        JSONObject jSONObject9 = jSONObject7;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject10 = jSONArray.getJSONObject(i);
                                String optString = jSONObject10.optString("id");
                                String optString2 = jSONObject10.optString("u");
                                String optString3 = jSONObject10.optString("i");
                                String optString4 = jSONObject10.optString("m");
                                String optString5 = jSONObject10.optString("p");
                                String optString6 = jSONObject10.optString("c");
                                String optString7 = jSONObject10.optString("f");
                                String optString8 = jSONObject10.optString("e");
                                Intent intent2 = intent;
                                Intent intent3 = new Intent();
                                Intent intent4 = intent2;
                                if (!TextUtils.isEmpty(optString2)) {
                                    Intent data = intent4.setData(Uri.parse(optString2));
                                }
                                if (!TextUtils.isEmpty(optString3)) {
                                    Intent action = intent4.setAction(optString3);
                                }
                                if (!TextUtils.isEmpty(optString4)) {
                                    Intent type = intent4.setType(optString4);
                                }
                                if (!TextUtils.isEmpty(optString5)) {
                                    Intent intent5 = intent4.setPackage(optString5);
                                }
                                if (!TextUtils.isEmpty(optString6)) {
                                    String[] split = optString6.split("/", 2);
                                    if (split.length == 2) {
                                        Intent intent6 = intent4;
                                        ComponentName componentName2 = componentName;
                                        ComponentName componentName3 = new ComponentName(split[0], split[1]);
                                        Intent component = intent6.setComponent(componentName2);
                                    }
                                }
                                try {
                                    JSONObject put = jSONObject9.put(optString, packageManager.resolveActivity(intent4, 65536) != null);
                                } catch (JSONException e) {
                                    zzin.zzb("Error constructing openable urls response.", e);
                                }
                            } catch (JSONException e2) {
                                zzin.zzb("Error parsing the intent data.", e2);
                            }
                        }
                        zzjp2.zzb("openableIntents", jSONObject9);
                    } catch (JSONException e3) {
                        JSONException jSONException = e3;
                        JSONObject jSONObject11 = jSONObject3;
                        JSONObject jSONObject12 = new JSONObject();
                        zzjp2.zzb("openableIntents", jSONObject11);
                    }
                } catch (JSONException e4) {
                    JSONException jSONException2 = e4;
                    JSONObject jSONObject13 = jSONObject;
                    JSONObject jSONObject14 = new JSONObject();
                    zzjp2.zzb("openableIntents", jSONObject13);
                }
            }
        };
        zzyZ = r03;
        C02926 r04 = r24;
        C02926 r14 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                Uri uri;
                StringBuilder sb;
                zziy zziy;
                zzjp zzjp2 = zzjp;
                String str = (String) map.get("u");
                if (str == null) {
                    zzin.zzaK("URL missing from click GMSG.");
                    return;
                }
                Uri parse = Uri.parse(str);
                try {
                    zzan zzhW = zzjp2.zzhW();
                    if (zzhW != null && zzhW.zzb(parse)) {
                        uri = zzhW.zza(parse, zzjp2.getContext());
                        zziy zziy2 = zziy;
                        zziy zziy3 = new zziy(zzjp2.getContext(), zzjp2.zzhX().afmaVersion, uri.toString());
                        Future zzhn = zziy2.zzgd();
                    }
                } catch (zzao e) {
                    zzao zzao = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzaK(sb2.append("Unable to append parameter to URL: ").append(str).toString());
                }
                uri = parse;
                zziy zziy22 = zziy;
                zziy zziy32 = new zziy(zzjp2.getContext(), zzjp2.zzhX().afmaVersion, uri.toString());
                Future zzhn2 = zziy22.zzgd();
            }
        };
        zzza = r04;
        C02937 r05 = r25;
        C02937 r15 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                zzd zzhS = zzjp2.zzhS();
                if (zzhS != null) {
                    zzhS.close();
                    return;
                }
                zzd zzhT = zzjp2.zzhT();
                if (zzhT != null) {
                    zzhT.close();
                } else {
                    zzin.zzaK("A GMSG tried to close something that wasn't an overlay.");
                }
            }
        };
        zzzb = r05;
        C02948 r06 = r26;
        C02948 r16 = new zzdf() {
            private void zzc(zzjp zzjp) {
                JSONObject jSONObject;
                zzjp zzjp2 = zzjp;
                zzin.zzaJ("Received support message, responding.");
                com.google.android.gms.ads.internal.zzd zzhR = zzjp2.zzhR();
                boolean z = false;
                if (zzhR != null) {
                    zzm zzm = zzhR.zzpy;
                    z = false;
                    if (zzm != null) {
                        z = zzm.zzfM();
                    }
                }
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONObject2;
                try {
                    JSONObject put = jSONObject4.put("event", "checkSupport");
                    JSONObject put2 = jSONObject4.put("supports", z);
                    zzjp2.zzb("appStreaming", jSONObject4);
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                if ("checkSupport".equals(map2.get("action"))) {
                    zzc(zzjp2);
                    return;
                }
                zzd zzhS = zzjp2.zzhS();
                if (zzhS != null) {
                    zzhS.zzg(zzjp2, map2);
                }
            }
        };
        zzzc = r06;
        C02959 r07 = r27;
        C02959 r17 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp.zzE("1".equals(map.get("custom_close")));
            }
        };
        zzzd = r07;
        C028610 r08 = r28;
        C028610 r18 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zziy zziy;
                zzjp zzjp2 = zzjp;
                String str = (String) map.get("u");
                if (str == null) {
                    zzin.zzaK("URL missing from httpTrack GMSG.");
                    return;
                }
                zziy zziy2 = zziy;
                zziy zziy3 = new zziy(zzjp2.getContext(), zzjp2.zzhX().afmaVersion, str);
                Future zzhn = zziy2.zzgd();
            }
        };
        zzze = r08;
        C028711 r09 = r29;
        C028711 r19 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                StringBuilder sb;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaJ(sb2.append("Received log message: ").append((String) map2.get("string")).toString());
            }
        };
        zzzf = r09;
        C02882 r010 = r210;
        C02882 r110 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                String str = (String) map2.get("ty");
                String str2 = (String) map2.get("td");
                try {
                    int parseInt = Integer.parseInt((String) map2.get("tx"));
                    int parseInt2 = Integer.parseInt(str);
                    int parseInt3 = Integer.parseInt(str2);
                    zzan zzhW = zzjp2.zzhW();
                    if (zzhW != null) {
                        zzhW.zzab().zza(parseInt, parseInt2, parseInt3);
                    }
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    zzin.zzaK("Could not parse touch parameters from gmsg.");
                }
            }
        };
        zzzg = r010;
        C02893 r011 = r211;
        C02893 r111 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                if (((Boolean) zzbt.zzwT.get()).booleanValue()) {
                    zzjp2.zzF(!Boolean.parseBoolean((String) map2.get("disabled")));
                }
            }
        };
        zzzh = r011;
        zzdo zzdo2 = zzdo;
        zzdo zzdo3 = new zzdo();
        zzzi = zzdo2;
        zzds zzds2 = zzds;
        zzds zzds3 = new zzds();
        zzzj = zzds2;
        zzdd zzdd2 = zzdd;
        zzdd zzdd3 = new zzdd();
        zzzk = zzdd2;
    }
}
