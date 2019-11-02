package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzr;

@TargetApi(11)
@zzhb
public class zzjv extends WebChromeClient {
    private final zzjp zzpD;

    /* renamed from: com.google.android.gms.internal.zzjv$7 */
    static /* synthetic */ class C04377 {
        static final /* synthetic */ int[] zzOk = new int[MessageLevel.values().length];

        static {
            try {
                zzOk[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
                NoSuchFieldError noSuchFieldError = e;
            }
            try {
                zzOk[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
                NoSuchFieldError noSuchFieldError2 = e2;
            }
            try {
                zzOk[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
                NoSuchFieldError noSuchFieldError3 = e3;
            }
            try {
                zzOk[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
                NoSuchFieldError noSuchFieldError4 = e4;
            }
            try {
                zzOk[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
                NoSuchFieldError noSuchFieldError5 = e5;
            }
        }
    }

    public zzjv(zzjp zzjp) {
        this.zzpD = zzjp;
    }

    private final Context zza(WebView webView) {
        Context zzhP;
        WebView webView2 = webView;
        if (!(webView2 instanceof zzjp)) {
            zzhP = webView2.getContext();
        } else {
            zzjp zzjp = (zzjp) webView2;
            zzhP = zzjp.zzhP();
            if (zzhP == null) {
                return zzjp.getContext();
            }
        }
        return zzhP;
    }

    private static void zza(Builder builder, String str, JsResult jsResult) {
        C04333 r8;
        C04322 r82;
        C04311 r83;
        JsResult jsResult2 = jsResult;
        Builder message = builder.setMessage(str);
        C04333 r5 = r8;
        final JsResult jsResult3 = jsResult2;
        C04333 r6 = new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                jsResult3.confirm();
            }
        };
        Builder positiveButton = message.setPositiveButton(17039370, r5);
        C04322 r52 = r82;
        final JsResult jsResult4 = jsResult2;
        C04322 r62 = new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                jsResult4.cancel();
            }
        };
        Builder negativeButton = positiveButton.setNegativeButton(17039360, r52);
        C04311 r4 = r83;
        final JsResult jsResult5 = jsResult2;
        C04311 r53 = new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                DialogInterface dialogInterface2 = dialogInterface;
                jsResult5.cancel();
            }
        };
        negativeButton.setOnCancelListener(r4).create().show();
    }

    private static void zza(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        LinearLayout linearLayout;
        TextView textView;
        EditText editText;
        C04366 r14;
        C04355 r142;
        C04344 r143;
        Context context2 = context;
        Builder builder2 = builder;
        String str3 = str;
        String str4 = str2;
        JsPromptResult jsPromptResult2 = jsPromptResult;
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = new LinearLayout(context2);
        LinearLayout linearLayout4 = linearLayout2;
        linearLayout4.setOrientation(1);
        TextView textView2 = textView;
        TextView textView3 = new TextView(context2);
        TextView textView4 = textView2;
        textView4.setText(str3);
        EditText editText2 = editText;
        EditText editText3 = new EditText(context2);
        EditText editText4 = editText2;
        editText4.setText(str4);
        linearLayout4.addView(textView4);
        linearLayout4.addView(editText4);
        Builder view = builder2.setView(linearLayout4);
        C04366 r10 = r14;
        final JsPromptResult jsPromptResult3 = jsPromptResult2;
        final EditText editText5 = editText4;
        C04366 r11 = new OnClickListener() {
            {
                EditText editText = r7;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                jsPromptResult3.confirm(editText5.getText().toString());
            }
        };
        Builder positiveButton = view.setPositiveButton(17039370, r10);
        C04355 r102 = r142;
        final JsPromptResult jsPromptResult4 = jsPromptResult2;
        C04355 r112 = new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                jsPromptResult4.cancel();
            }
        };
        Builder negativeButton = positiveButton.setNegativeButton(17039360, r102);
        C04344 r9 = r143;
        final JsPromptResult jsPromptResult5 = jsPromptResult2;
        C04344 r103 = new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                DialogInterface dialogInterface2 = dialogInterface;
                jsPromptResult5.cancel();
            }
        };
        negativeButton.setOnCancelListener(r9).create().show();
    }

    private final boolean zziv() {
        return zzr.zzbC().zza(this.zzpD.getContext().getPackageManager(), this.zzpD.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzr.zzbC().zza(this.zzpD.getContext().getPackageManager(), this.zzpD.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final void onCloseWindow(WebView webView) {
        WebView webView2 = webView;
        if (!(webView2 instanceof zzjp)) {
            zzin.zzaK("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzd zzhS = ((zzjp) webView2).zzhS();
        if (zzhS == null) {
            zzin.zzaK("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzhS.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        StringBuilder sb;
        ConsoleMessage consoleMessage2 = consoleMessage;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append("JS: ").append(consoleMessage2.message()).append(" (").append(consoleMessage2.sourceId()).append(":").append(consoleMessage2.lineNumber()).append(")").toString();
        if (sb4.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage2);
        }
        switch (C04377.zzOk[consoleMessage2.messageLevel().ordinal()]) {
            case 1:
                zzin.m19e(sb4);
                break;
            case 2:
                zzin.zzaK(sb4);
                break;
            case 3:
            case 4:
                zzin.zzaJ(sb4);
                break;
            case 5:
                zzin.zzaI(sb4);
                break;
            default:
                zzin.zzaJ(sb4);
                break;
        }
        return super.onConsoleMessage(consoleMessage2);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2;
        boolean z3 = z;
        boolean z4 = z2;
        Message message2 = message;
        WebViewTransport webViewTransport = (WebViewTransport) message2.obj;
        WebView webView3 = webView2;
        WebView webView4 = new WebView(webView.getContext());
        WebView webView5 = webView3;
        webView5.setWebViewClient(this.zzpD.zzhU());
        webViewTransport.setWebView(webView5);
        message2.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        String str3 = str;
        String str4 = str2;
        long j4 = j;
        long j5 = j2;
        QuotaUpdater quotaUpdater2 = quotaUpdater;
        long j6 = 5242880 - j3;
        if (j6 <= 0) {
            quotaUpdater2.updateQuota(j4);
            return;
        }
        if (j4 == 0) {
            if (j5 > j6 || j5 > 1048576) {
                j5 = 0;
            }
        } else if (j5 == 0) {
            j5 = Math.min(j4 + Math.min(131072, j6), 1048576);
        } else {
            if (j5 <= Math.min(1048576 - j4, j6)) {
                j4 += j5;
            }
            j5 = j4;
        }
        quotaUpdater2.updateQuota(j5);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        String str2 = str;
        Callback callback2 = callback;
        if (callback2 != null) {
            callback2.invoke(str2, zziv(), true);
        }
    }

    public final void onHideCustomView() {
        zzd zzhS = this.zzpD.zzhS();
        if (zzhS == null) {
            zzin.zzaK("Could not get ad overlay when hiding custom view.");
        } else {
            zzhS.zzfl();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        QuotaUpdater quotaUpdater2 = quotaUpdater;
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater2.updateQuota(0);
        } else {
            quotaUpdater2.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    /* access modifiers changed from: protected */
    public final void zza(View view, int i, CustomViewCallback customViewCallback) {
        View view2 = view;
        int i2 = i;
        CustomViewCallback customViewCallback2 = customViewCallback;
        zzd zzhS = this.zzpD.zzhS();
        if (zzhS == null) {
            zzin.zzaK("Could not get ad overlay when showing custom view.");
            customViewCallback2.onCustomViewHidden();
            return;
        }
        zzhS.zza(view2, customViewCallback2);
        zzhS.setRequestedOrientation(i2);
    }

    /* access modifiers changed from: protected */
    public boolean zza(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        Builder builder;
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        JsResult jsResult2 = jsResult;
        JsPromptResult jsPromptResult2 = jsPromptResult;
        boolean z2 = z;
        try {
            Builder builder2 = builder;
            Builder builder3 = new Builder(context2);
            Builder builder4 = builder2;
            Builder title = builder4.setTitle(str4);
            if (z2) {
                zza(context2, builder4, str5, str6, jsPromptResult2);
            } else {
                zza(builder4, str5, jsResult2);
            }
        } catch (BadTokenException e) {
            zzin.zzd("Fail to display Dialog.", e);
        }
        return true;
    }
}
