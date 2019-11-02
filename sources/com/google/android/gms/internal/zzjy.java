package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzhb
public class zzjy extends WebViewClient {
    private final zzgo zzGs;
    private final String zzOl;
    private boolean zzOm = false;
    private final zzjp zzpD;

    public zzjy(zzgo zzgo, zzjp zzjp, String str) {
        zzgo zzgo2 = zzgo;
        zzjp zzjp2 = zzjp;
        this.zzOl = zzaR(str);
        this.zzpD = zzjp2;
        this.zzGs = zzgo2;
    }

    private String zzaR(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (str2.endsWith("/")) {
                    return str2.substring(0, -1 + str2.length());
                }
            } catch (IndexOutOfBoundsException e) {
                zzin.m19e(e.getMessage());
                return str2;
            }
        }
        return str2;
    }

    public void onLoadResource(WebView webView, String str) {
        StringBuilder sb;
        WebView webView2 = webView;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("JavascriptAdWebViewClient::onLoadResource: ").append(str2).toString());
        if (!zzaQ(str2)) {
            this.zzpD.zzhU().onLoadResource(this.zzpD.getWebView(), str2);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        StringBuilder sb;
        WebView webView2 = webView;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("JavascriptAdWebViewClient::onPageFinished: ").append(str2).toString());
        if (!this.zzOm) {
            this.zzGs.zzge();
            this.zzOm = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        WebView webView2 = webView;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("JavascriptAdWebViewClient::shouldOverrideUrlLoading: ").append(str2).toString());
        if (!zzaQ(str2)) {
            return this.zzpD.zzhU().shouldOverrideUrlLoading(this.zzpD.getWebView(), str2);
        }
        zzin.zzaI("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzaQ(String str) {
        URI uri;
        URI uri2;
        String zzaR = zzaR(str);
        if (!TextUtils.isEmpty(zzaR)) {
            try {
                URI uri3 = uri;
                URI uri4 = new URI(zzaR);
                URI uri5 = uri3;
                if ("passback".equals(uri5.getScheme())) {
                    zzin.zzaI("Passback received");
                    this.zzGs.zzgf();
                    return true;
                } else if (!TextUtils.isEmpty(this.zzOl)) {
                    URI uri6 = uri2;
                    URI uri7 = new URI(this.zzOl);
                    URI uri8 = uri6;
                    String host = uri8.getHost();
                    String host2 = uri5.getHost();
                    String path = uri8.getPath();
                    String path2 = uri5.getPath();
                    if (zzw.equal(host, host2) && zzw.equal(path, path2)) {
                        zzin.zzaI("Passback received");
                        this.zzGs.zzgf();
                        return true;
                    }
                }
            } catch (URISyntaxException e) {
                zzin.m19e(e.getMessage());
                return false;
            }
        }
        return false;
    }
}
