package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzhb
public class zzga extends Handler {
    private final zzfz zzFq;

    public zzga(Context context) {
        zzgb zzgb;
        Context context2 = context;
        if (context2.getApplicationContext() != null) {
            context2 = context2.getApplicationContext();
        }
        zzgb zzgb2 = zzgb;
        zzgb zzgb3 = new zzgb(context2);
        this((zzfz) zzgb2);
    }

    public zzga(zzfz zzfz) {
        this.zzFq = zzfz;
    }

    private void zzd(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            this.zzFq.zza(jSONObject2.getString("request_id"), jSONObject2.getString("base_url"), jSONObject2.getString("html"));
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public void handleMessage(Message message) {
        JSONObject jSONObject;
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject(data.getString("data"));
                JSONObject jSONObject4 = jSONObject2;
                if ("fetch_html".equals(jSONObject4.getString("message_name"))) {
                    zzd(jSONObject4);
                }
            }
        } catch (Exception e) {
            Exception exc = e;
        }
    }
}
