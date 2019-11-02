package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzdg implements zzdf {
    private final Context mContext;
    private final VersionInfoParcel zzpT;

    @zzhb
    static class zza {
        private final String mValue;
        private final String zzvs;

        public zza(String str, String str2) {
            String str3 = str2;
            this.zzvs = str;
            this.mValue = str3;
        }

        public String getKey() {
            return this.zzvs;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzhb
    static class zzb {
        private final String zzzp;
        private final URL zzzq;
        private final ArrayList<zza> zzzr;
        private final String zzzs;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            ArrayList<zza> arrayList2;
            URL url2 = url;
            ArrayList<zza> arrayList3 = arrayList;
            String str3 = str2;
            this.zzzp = str;
            this.zzzq = url2;
            if (arrayList3 == null) {
                ArrayList<zza> arrayList4 = arrayList2;
                ArrayList<zza> arrayList5 = new ArrayList<>();
                this.zzzr = arrayList4;
            } else {
                this.zzzr = arrayList3;
            }
            this.zzzs = str3;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public URL zzdV() {
            return this.zzzq;
        }

        public ArrayList<zza> zzdW() {
            return this.zzzr;
        }

        public String zzdX() {
            return this.zzzs;
        }
    }

    @zzhb
    class zzc {
        final /* synthetic */ zzdg zzzm;
        private final zzd zzzt;
        private final boolean zzzu;
        private final String zzzv;

        public zzc(zzdg zzdg, boolean z, zzd zzd, String str) {
            boolean z2 = z;
            zzd zzd2 = zzd;
            String str2 = str;
            this.zzzm = zzdg;
            this.zzzu = z2;
            this.zzzt = zzd2;
            this.zzzv = str2;
        }

        public String getReason() {
            return this.zzzv;
        }

        public boolean isSuccess() {
            return this.zzzu;
        }

        public zzd zzdY() {
            return this.zzzt;
        }
    }

    @zzhb
    static class zzd {
        private final String zzxY;
        private final String zzzp;
        private final int zzzw;
        private final List<zza> zzzx;

        public zzd(String str, int i, List<zza> list, String str2) {
            ArrayList arrayList;
            int i2 = i;
            List<zza> list2 = list;
            String str3 = str2;
            this.zzzp = str;
            this.zzzw = i2;
            if (list2 == null) {
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                this.zzzx = arrayList2;
            } else {
                this.zzzx = list2;
            }
            this.zzxY = str3;
        }

        public String getBody() {
            return this.zzxY;
        }

        public int getResponseCode() {
            return this.zzzw;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public Iterable<zza> zzdZ() {
            return this.zzzx;
        }
    }

    public zzdg(Context context, VersionInfoParcel versionInfoParcel) {
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        this.mContext = context;
        this.zzpT = versionInfoParcel2;
    }

    public JSONObject zzQ(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        try {
            JSONObject jSONObject7 = jSONObject3;
            JSONObject jSONObject8 = new JSONObject(str);
            JSONObject jSONObject9 = jSONObject7;
            JSONObject jSONObject10 = jSONObject4;
            JSONObject jSONObject11 = new JSONObject();
            JSONObject jSONObject12 = jSONObject10;
            String str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
            try {
                str2 = jSONObject9.optString("http_request_id");
                zzc zza2 = zza(zzc(jSONObject9));
                if (zza2.isSuccess()) {
                    JSONObject put = jSONObject12.put("response", zza(zza2.zzdY()));
                    JSONObject put2 = jSONObject12.put("success", true);
                    return jSONObject12;
                }
                JSONObject jSONObject13 = jSONObject12;
                String str3 = "response";
                JSONObject jSONObject14 = jSONObject6;
                JSONObject jSONObject15 = new JSONObject();
                JSONObject put3 = jSONObject13.put(str3, jSONObject14.put("http_request_id", str2));
                JSONObject put4 = jSONObject12.put("success", false);
                JSONObject put5 = jSONObject12.put("reason", zza2.getReason());
                return jSONObject12;
            } catch (Exception e) {
                Exception exc = e;
                JSONObject jSONObject16 = jSONObject12;
                String str4 = "response";
                try {
                    JSONObject jSONObject17 = jSONObject5;
                    JSONObject jSONObject18 = new JSONObject();
                    JSONObject put6 = jSONObject16.put(str4, jSONObject17.put("http_request_id", str2));
                    JSONObject put7 = jSONObject12.put("success", false);
                    JSONObject put8 = jSONObject12.put("reason", exc.toString());
                    return jSONObject12;
                } catch (JSONException e2) {
                    JSONException jSONException = e2;
                    return jSONObject12;
                }
            }
        } catch (JSONException e3) {
            JSONException jSONException2 = e3;
            zzin.m19e("The request is not a valid JSON.");
            try {
                JSONObject jSONObject19 = jSONObject2;
                JSONObject jSONObject20 = new JSONObject();
                return jSONObject19.put("success", false);
            } catch (JSONException e4) {
                JSONException jSONException3 = e4;
                JSONObject jSONObject21 = jSONObject;
                JSONObject jSONObject22 = new JSONObject();
                return jSONObject21;
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzc zza(zzb zzb2) {
        zzc zzc2;
        ArrayList arrayList;
        zzc zzc3;
        zzd zzd2;
        InputStreamReader inputStreamReader;
        zza zza2;
        BufferedOutputStream bufferedOutputStream;
        zzb zzb3 = zzb2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzb3.zzdV().openConnection();
            zzr.zzbC().zza(this.mContext, this.zzpT.afmaVersion, false, httpURLConnection);
            Iterator it = zzb3.zzdW().iterator();
            while (it.hasNext()) {
                zza zza3 = (zza) it.next();
                httpURLConnection.addRequestProperty(zza3.getKey(), zza3.getValue());
            }
            if (!TextUtils.isEmpty(zzb3.zzdX())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzb3.zzdX().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                BufferedOutputStream bufferedOutputStream4 = bufferedOutputStream2;
                bufferedOutputStream4.write(bytes);
                bufferedOutputStream4.close();
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String zza4 : (List) entry.getValue()) {
                        ArrayList arrayList5 = arrayList4;
                        zza zza5 = zza2;
                        zza zza6 = new zza((String) entry.getKey(), zza4);
                        boolean add = arrayList5.add(zza5);
                    }
                }
            }
            zzc zzc4 = zzc3;
            zzd zzd3 = zzd2;
            String zzdU = zzb3.zzdU();
            int responseCode = httpURLConnection.getResponseCode();
            ArrayList arrayList6 = arrayList4;
            zzir zzbC = zzr.zzbC();
            InputStreamReader inputStreamReader2 = inputStreamReader;
            InputStreamReader inputStreamReader3 = new InputStreamReader(httpURLConnection.getInputStream());
            zzd zzd4 = new zzd(zzdU, responseCode, arrayList6, zzbC.zza(inputStreamReader2));
            zzc zzc5 = new zzc(this, true, zzd3, null);
            return zzc4;
        } catch (Exception e) {
            Exception exc = e;
            zzc zzc6 = zzc2;
            zzc zzc7 = new zzc(this, false, null, exc.toString());
            return zzc6;
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zza(zzd zzd2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        zzd zzd3 = zzd2;
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = jSONObject3;
        try {
            JSONObject put = jSONObject5.put("http_request_id", zzd3.zzdU());
            if (zzd3.getBody() != null) {
                JSONObject put2 = jSONObject5.put("body", zzd3.getBody());
            }
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = jSONArray2;
            for (zza zza2 : zzd3.zzdZ()) {
                JSONArray jSONArray5 = jSONArray4;
                JSONObject jSONObject6 = jSONObject2;
                JSONObject jSONObject7 = new JSONObject();
                JSONArray put3 = jSONArray5.put(jSONObject6.put("key", zza2.getKey()).put("value", zza2.getValue()));
            }
            JSONObject put4 = jSONObject5.put("headers", jSONArray4);
            JSONObject put5 = jSONObject5.put("response_code", zzd3.getResponseCode());
            return jSONObject5;
        } catch (JSONException e) {
            zzin.zzb("Error constructing JSON for http response.", e);
            return jSONObject5;
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        C02961 r8;
        C02961 r3 = r8;
        final Map<String, String> map2 = map;
        final zzjp zzjp2 = zzjp;
        C02961 r4 = new Runnable(this) {
            final /* synthetic */ zzdg zzzm;

            {
                Map map = r8;
                zzjp zzjp = r9;
                this.zzzm = r7;
            }

            public void run() {
                C02971 r8;
                zzin.zzaI("Received Http request.");
                JSONObject zzQ = this.zzzm.zzQ((String) map2.get("http_request"));
                if (zzQ == null) {
                    zzin.m19e("Response should not be null.");
                    return;
                }
                Handler handler = zzir.zzMc;
                C02971 r4 = r8;
                final JSONObject jSONObject = zzQ;
                C02971 r5 = new Runnable(this) {
                    final /* synthetic */ C02961 zzzo;

                    {
                        JSONObject jSONObject = r7;
                        this.zzzo = r6;
                    }

                    public void run() {
                        zzjp2.zzb("fetchHttpRequestCompleted", jSONObject);
                        zzin.zzaI("Dispatched http response.");
                    }
                };
                boolean post = handler.post(r4);
            }
        };
        zzjg zza2 = zziq.zza((Runnable) r3);
    }

    /* access modifiers changed from: protected */
    public zzb zzc(JSONObject jSONObject) {
        URL url;
        ArrayList arrayList;
        zzb zzb2;
        zza zza2;
        JSONArray jSONArray;
        URL url2;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("http_request_id");
        String optString2 = jSONObject2.optString("url");
        String optString3 = jSONObject2.optString("post_body", null);
        try {
            URL url3 = url2;
            URL url4 = new URL(optString2);
            url = url3;
        } catch (MalformedURLException e) {
            zzin.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        JSONArray optJSONArray = jSONObject2.optJSONArray("headers");
        if (optJSONArray == null) {
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray();
            optJSONArray = jSONArray2;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                ArrayList arrayList5 = arrayList4;
                zza zza3 = zza2;
                zza zza4 = new zza(optJSONObject.optString("key"), optJSONObject.optString("value"));
                boolean add = arrayList5.add(zza3);
            }
        }
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(optString, url, arrayList4, optString3);
        return zzb3;
    }
}
