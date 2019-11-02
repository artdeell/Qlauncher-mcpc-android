package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@TargetApi(11)
@zzhb
public class zzjw extends zzjq {
    public zzjw(zzjp zzjp, boolean z) {
        super(zzjp, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Exception exc;
        StringBuilder sb;
        File file;
        StringBuilder sb2;
        WebView webView2 = webView;
        String str2 = str;
        String str3 = "mraid.js";
        try {
            File file2 = file;
            File file3 = new File(str2);
            if (!str3.equalsIgnoreCase(file2.getName())) {
                return super.shouldInterceptRequest(webView2, str2);
            }
            if (!(webView2 instanceof zzjp)) {
                zzin.zzaK("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView2, str2);
            }
            zzjp zzjp = (zzjp) webView2;
            zzjp.zzhU().zzfo();
            String str4 = zzjp.zzaN().zzui ? (String) zzbt.zzwf.get() : zzjp.zzhY() ? (String) zzbt.zzwe.get() : (String) zzbt.zzwd.get();
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            zzin.m20v(sb3.append("shouldInterceptRequest(").append(str4).append(")").toString());
            return zzd(zzjp.getContext(), this.zzpD.zzhX().afmaVersion, str4);
        } catch (IOException e) {
            exc = e;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            zzin.zzaK(sb5.append("Could not fetch MRAID JS. ").append(exc.getMessage()).toString());
            return super.shouldInterceptRequest(webView2, str2);
        } catch (ExecutionException e2) {
            exc = e2;
            StringBuilder sb52 = sb;
            StringBuilder sb62 = new StringBuilder();
            zzin.zzaK(sb52.append("Could not fetch MRAID JS. ").append(exc.getMessage()).toString());
            return super.shouldInterceptRequest(webView2, str2);
        } catch (InterruptedException e3) {
            exc = e3;
            StringBuilder sb522 = sb;
            StringBuilder sb622 = new StringBuilder();
            zzin.zzaK(sb522.append("Could not fetch MRAID JS. ").append(exc.getMessage()).toString());
            return super.shouldInterceptRequest(webView2, str2);
        } catch (TimeoutException e4) {
            exc = e4;
            StringBuilder sb5222 = sb;
            StringBuilder sb6222 = new StringBuilder();
            zzin.zzaK(sb5222.append("Could not fetch MRAID JS. ").append(exc.getMessage()).toString());
            return super.shouldInterceptRequest(webView2, str2);
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap;
        zziw zziw;
        WebResourceResponse webResourceResponse;
        ByteArrayInputStream byteArrayInputStream;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("User-Agent", zzr.zzbC().zze(context2, str3));
        Object put2 = hashMap4.put("Cache-Control", "max-stale=3600");
        zziw zziw2 = zziw;
        zziw zziw3 = new zziw(context2);
        String str5 = (String) zziw2.zzb(str4, hashMap4).get(60, TimeUnit.SECONDS);
        if (str5 == null) {
            return null;
        }
        WebResourceResponse webResourceResponse2 = webResourceResponse;
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(str5.getBytes("UTF-8"));
        WebResourceResponse webResourceResponse3 = new WebResourceResponse("application/javascript", "UTF-8", byteArrayInputStream2);
        return webResourceResponse2;
    }
}
