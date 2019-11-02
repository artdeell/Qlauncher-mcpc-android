package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {
    protected final HttpClient zzaD;

    public static final class zza extends HttpEntityEnclosingRequestBase {
        public zza() {
        }

        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public zzw(HttpClient httpClient) {
        this.zzaD = httpClient;
    }

    private static void zza(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzk<?> zzk) throws zza {
        HttpEntity httpEntity;
        HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase2 = httpEntityEnclosingRequestBase;
        byte[] zzq = zzk.zzq();
        if (zzq != null) {
            HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase3 = httpEntityEnclosingRequestBase2;
            HttpEntity httpEntity2 = httpEntity;
            HttpEntity byteArrayEntity = new ByteArrayEntity(zzq);
            httpEntityEnclosingRequestBase3.setEntity(httpEntity2);
        }
    }

    private static void zza(HttpUriRequest httpUriRequest, Map<String, String> map) {
        HttpUriRequest httpUriRequest2 = httpUriRequest;
        Map<String, String> map2 = map;
        for (String str : map2.keySet()) {
            httpUriRequest2.setHeader(str, (String) map2.get(str));
        }
    }

    static HttpUriRequest zzb(zzk<?> zzk, Map<String, String> map) throws zza {
        zza zza2;
        HttpTrace httpTrace;
        HttpOptions httpOptions;
        HttpHead httpHead;
        HttpPut httpPut;
        HttpPost httpPost;
        HttpDelete httpDelete;
        HttpGet httpGet;
        HttpGet httpGet2;
        HttpPost httpPost2;
        HttpEntity httpEntity;
        IllegalStateException illegalStateException;
        zzk<?> zzk2 = zzk;
        Map<String, String> map2 = map;
        switch (zzk2.getMethod()) {
            case -1:
                byte[] zzm = zzk2.zzm();
                if (zzm != null) {
                    HttpPost httpPost3 = httpPost2;
                    HttpPost httpPost4 = new HttpPost(zzk2.getUrl());
                    HttpPost httpPost5 = httpPost3;
                    httpPost5.addHeader("Content-Type", zzk2.zzl());
                    HttpPost httpPost6 = httpPost5;
                    HttpEntity httpEntity2 = httpEntity;
                    HttpEntity byteArrayEntity = new ByteArrayEntity(zzm);
                    httpPost6.setEntity(httpEntity2);
                    return httpPost5;
                }
                HttpGet httpGet3 = httpGet2;
                HttpGet httpGet4 = new HttpGet(zzk2.getUrl());
                return httpGet3;
            case 0:
                HttpGet httpGet5 = httpGet;
                HttpGet httpGet6 = new HttpGet(zzk2.getUrl());
                return httpGet5;
            case 1:
                HttpPost httpPost7 = httpPost;
                HttpPost httpPost8 = new HttpPost(zzk2.getUrl());
                HttpPost httpPost9 = httpPost7;
                httpPost9.addHeader("Content-Type", zzk2.zzp());
                zza((HttpEntityEnclosingRequestBase) httpPost9, zzk2);
                return httpPost9;
            case 2:
                HttpPut httpPut2 = httpPut;
                HttpPut httpPut3 = new HttpPut(zzk2.getUrl());
                HttpPut httpPut4 = httpPut2;
                httpPut4.addHeader("Content-Type", zzk2.zzp());
                zza((HttpEntityEnclosingRequestBase) httpPut4, zzk2);
                return httpPut4;
            case 3:
                HttpDelete httpDelete2 = httpDelete;
                HttpDelete httpDelete3 = new HttpDelete(zzk2.getUrl());
                return httpDelete2;
            case 4:
                HttpHead httpHead2 = httpHead;
                HttpHead httpHead3 = new HttpHead(zzk2.getUrl());
                return httpHead2;
            case 5:
                HttpOptions httpOptions2 = httpOptions;
                HttpOptions httpOptions3 = new HttpOptions(zzk2.getUrl());
                return httpOptions2;
            case 6:
                HttpTrace httpTrace2 = httpTrace;
                HttpTrace httpTrace3 = new HttpTrace(zzk2.getUrl());
                return httpTrace2;
            case 7:
                zza zza3 = zza2;
                zza zza4 = new zza(zzk2.getUrl());
                zza zza5 = zza3;
                zza5.addHeader("Content-Type", zzk2.zzp());
                zza((HttpEntityEnclosingRequestBase) zza5, zzk2);
                return zza5;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unknown request method.");
                throw illegalStateException2;
        }
    }

    public HttpResponse zza(zzk<?> zzk, Map<String, String> map) throws IOException, zza {
        zzk<?> zzk2 = zzk;
        Map<String, String> map2 = map;
        HttpUriRequest zzb = zzb(zzk2, map2);
        zza(zzb, map2);
        zza(zzb, zzk2.getHeaders());
        zza(zzb);
        HttpParams params = zzb.getParams();
        int zzt = zzk2.zzt();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzt);
        return this.zzaD.execute(zzb);
    }

    /* access modifiers changed from: protected */
    public void zza(HttpUriRequest httpUriRequest) throws IOException {
    }
}
