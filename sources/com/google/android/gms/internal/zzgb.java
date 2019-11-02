package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzhb
public class zzgb implements zzfz {
    private final Context mContext;
    final Set<WebView> zzFr;

    public zzgb(Context context) {
        HashSet hashSet;
        Context context2 = context;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.zzFr = Collections.synchronizedSet(hashSet2);
        this.mContext = context2;
    }

    public void zza(String str, String str2, String str3) {
        C03741 r10;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        zzin.zzaI("Fetching assets for the given html");
        Handler handler = zzir.zzMc;
        C03741 r5 = r10;
        final String str7 = str5;
        final String str8 = str6;
        C03741 r6 = new Runnable(this) {
            final /* synthetic */ zzgb zzFu;

            {
                String str = r8;
                String str2 = r9;
                this.zzFu = r7;
            }

            public void run() {
                C03751 r8;
                WebView zzfR = this.zzFu.zzfR();
                WebView webView = zzfR;
                C03751 r3 = r8;
                final WebView webView2 = zzfR;
                C03751 r4 = new WebViewClient(this) {
                    final /* synthetic */ C03741 zzFv;

                    {
                        WebView webView = r7;
                        this.zzFv = r6;
                    }

                    public void onPageFinished(WebView webView, String str) {
                        WebView webView2 = webView;
                        String str2 = str;
                        zzin.zzaI("Loading assets have finished");
                        boolean remove = this.zzFv.zzFu.zzFr.remove(webView2);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        WebView webView2 = webView;
                        int i2 = i;
                        String str3 = str;
                        String str4 = str2;
                        zzin.zzaK("Loading assets have failed.");
                        boolean remove = this.zzFv.zzFu.zzFr.remove(webView2);
                    }
                };
                webView.setWebViewClient(r3);
                boolean add = this.zzFu.zzFr.add(zzfR);
                zzfR.loadDataWithBaseURL(str7, str8, "text/html", "UTF-8", null);
                zzin.zzaI("Fetching assets finished.");
            }
        };
        boolean post = handler.post(r5);
    }

    public WebView zzfR() {
        WebView webView;
        WebView webView2 = webView;
        WebView webView3 = new WebView(this.mContext);
        WebView webView4 = webView2;
        webView4.getSettings().setJavaScriptEnabled(true);
        return webView4;
    }
}
