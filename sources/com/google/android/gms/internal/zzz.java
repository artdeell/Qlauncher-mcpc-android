package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz implements zzy {
    private final zza zzaE;
    private final SSLSocketFactory zzaF;

    public interface zza {
        String zzh(String str);
    }

    public zzz() {
        this(null);
    }

    public zzz(zza zza2) {
        this(zza2, null);
    }

    public zzz(zza zza2, SSLSocketFactory sSLSocketFactory) {
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        this.zzaE = zza2;
        this.zzaF = sSLSocketFactory2;
    }

    private HttpURLConnection zza(URL url, zzk<?> zzk) throws IOException {
        URL url2 = url;
        zzk<?> zzk2 = zzk;
        HttpURLConnection zza2 = zza(url2);
        int zzt = zzk2.zzt();
        zza2.setConnectTimeout(zzt);
        zza2.setReadTimeout(zzt);
        zza2.setUseCaches(false);
        zza2.setDoInput(true);
        if ("https".equals(url2.getProtocol()) && this.zzaF != null) {
            ((HttpsURLConnection) zza2).setSSLSocketFactory(this.zzaF);
        }
        return zza2;
    }

    private static HttpEntity zza(HttpURLConnection httpURLConnection) {
        BasicHttpEntity basicHttpEntity;
        InputStream errorStream;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        BasicHttpEntity basicHttpEntity2 = basicHttpEntity;
        BasicHttpEntity basicHttpEntity3 = new BasicHttpEntity();
        BasicHttpEntity basicHttpEntity4 = basicHttpEntity2;
        try {
            errorStream = httpURLConnection2.getInputStream();
        } catch (IOException e) {
            IOException iOException = e;
            errorStream = httpURLConnection2.getErrorStream();
        }
        basicHttpEntity4.setContent(errorStream);
        basicHttpEntity4.setContentLength((long) httpURLConnection2.getContentLength());
        basicHttpEntity4.setContentEncoding(httpURLConnection2.getContentEncoding());
        basicHttpEntity4.setContentType(httpURLConnection2.getContentType());
        return basicHttpEntity4;
    }

    static void zza(HttpURLConnection httpURLConnection, zzk<?> zzk) throws IOException, zza {
        DataOutputStream dataOutputStream;
        IllegalStateException illegalStateException;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        zzk<?> zzk2 = zzk;
        switch (zzk2.getMethod()) {
            case -1:
                byte[] zzm = zzk2.zzm();
                if (zzm != null) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.addRequestProperty("Content-Type", zzk2.zzl());
                    DataOutputStream dataOutputStream2 = dataOutputStream;
                    DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection2.getOutputStream());
                    DataOutputStream dataOutputStream4 = dataOutputStream2;
                    dataOutputStream4.write(zzm);
                    dataOutputStream4.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection2.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection2.setRequestMethod("POST");
                zzb(httpURLConnection2, zzk2);
                return;
            case 2:
                httpURLConnection2.setRequestMethod("PUT");
                zzb(httpURLConnection2, zzk2);
                return;
            case 3:
                httpURLConnection2.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection2.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection2.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection2.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection2.setRequestMethod("PATCH");
                zzb(httpURLConnection2, zzk2);
                return;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unknown method type.");
                throw illegalStateException2;
        }
    }

    private static void zzb(HttpURLConnection httpURLConnection, zzk<?> zzk) throws IOException, zza {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        zzk<?> zzk2 = zzk;
        byte[] zzq = zzk2.zzq();
        if (zzq != null) {
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.addRequestProperty("Content-Type", zzk2.zzp());
            DataOutputStream dataOutputStream2 = dataOutputStream;
            DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection2.getOutputStream());
            DataOutputStream dataOutputStream4 = dataOutputStream2;
            dataOutputStream4.write(zzq);
            dataOutputStream4.close();
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection zza(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse zza(zzk<?> zzk, Map<String, String> map) throws IOException, zza {
        HashMap hashMap;
        String str;
        URL url;
        ProtocolVersion protocolVersion;
        BasicHttpResponse basicHttpResponse;
        StatusLine statusLine;
        Header header;
        IOException iOException;
        IOException iOException2;
        StringBuilder sb;
        zzk<?> zzk2 = zzk;
        Map<String, String> map2 = map;
        String url2 = zzk2.getUrl();
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        hashMap4.putAll(zzk2.getHeaders());
        hashMap4.putAll(map2);
        if (this.zzaE != null) {
            str = this.zzaE.zzh(url2);
            if (str == null) {
                IOException iOException3 = iOException2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IOException iOException4 = new IOException(sb2.append("URL blocked by rewriter: ").append(url2).toString());
                throw iOException3;
            }
        } else {
            str = url2;
        }
        URL url3 = url;
        URL url4 = new URL(str);
        HttpURLConnection zza2 = zza(url3, zzk2);
        for (String str2 : hashMap4.keySet()) {
            zza2.addRequestProperty(str2, (String) hashMap4.get(str2));
        }
        zza(zza2, zzk2);
        ProtocolVersion protocolVersion2 = protocolVersion;
        ProtocolVersion protocolVersion3 = new ProtocolVersion("HTTP", 1, 1);
        ProtocolVersion protocolVersion4 = protocolVersion2;
        if (zza2.getResponseCode() == -1) {
            IOException iOException5 = iOException;
            IOException iOException6 = new IOException("Could not retrieve response code from HttpUrlConnection.");
            throw iOException5;
        }
        BasicHttpResponse basicHttpResponse2 = basicHttpResponse;
        StatusLine statusLine2 = statusLine;
        StatusLine basicStatusLine = new BasicStatusLine(protocolVersion4, zza2.getResponseCode(), zza2.getResponseMessage());
        BasicHttpResponse basicHttpResponse3 = new BasicHttpResponse(statusLine2);
        BasicHttpResponse basicHttpResponse4 = basicHttpResponse2;
        basicHttpResponse4.setEntity(zza(zza2));
        for (Entry entry : zza2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                BasicHttpResponse basicHttpResponse5 = basicHttpResponse4;
                Header header2 = header;
                Header basicHeader = new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
                basicHttpResponse5.addHeader(header2);
            }
        }
        return basicHttpResponse4;
    }
}
