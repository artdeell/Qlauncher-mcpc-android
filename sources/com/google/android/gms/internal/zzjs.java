package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzhb
class zzjs extends FrameLayout implements zzjp {
    private final zzjp zzNN;
    private final zzjo zzNO;

    public zzjs(zzjp zzjp) {
        zzjo zzjo;
        zzjp zzjp2 = zzjp;
        super(zzjp2.getContext());
        this.zzNN = zzjp2;
        zzjo zzjo2 = zzjo;
        zzjo zzjo3 = new zzjo(zzjp2.zzhQ(), this, this);
        this.zzNO = zzjo2;
        zzjq zzhU = this.zzNN.zzhU();
        if (zzhU != null) {
            zzhU.zzh((zzjp) this);
        }
        addView(this.zzNN.getView());
    }

    public void clearCache(boolean z) {
        boolean z2 = z;
        this.zzNN.clearCache(z2);
    }

    public void destroy() {
        this.zzNN.destroy();
    }

    public String getRequestId() {
        return this.zzNN.getRequestId();
    }

    public int getRequestedOrientation() {
        return this.zzNN.getRequestedOrientation();
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this.zzNN.getWebView();
    }

    public boolean isDestroyed() {
        return this.zzNN.isDestroyed();
    }

    public void loadData(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.zzNN.loadData(str4, str5, str6);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        this.zzNN.loadDataWithBaseURL(str6, str7, str8, str9, str10);
    }

    public void loadUrl(String str) {
        String str2 = str;
        this.zzNN.loadUrl(str2);
    }

    public void onPause() {
        this.zzNO.onPause();
        this.zzNN.onPause();
    }

    public void onResume() {
        this.zzNN.onResume();
    }

    public void setBackgroundColor(int i) {
        int i2 = i;
        this.zzNN.setBackgroundColor(i2);
    }

    public void setContext(Context context) {
        Context context2 = context;
        this.zzNN.setContext(context2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        OnClickListener onClickListener2 = onClickListener;
        this.zzNN.setOnClickListener(onClickListener2);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        OnTouchListener onTouchListener2 = onTouchListener;
        this.zzNN.setOnTouchListener(onTouchListener2);
    }

    public void setRequestedOrientation(int i) {
        int i2 = i;
        this.zzNN.setRequestedOrientation(i2);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = webChromeClient;
        this.zzNN.setWebChromeClient(webChromeClient2);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = webViewClient;
        this.zzNN.setWebViewClient(webViewClient2);
    }

    public void stopLoading() {
        this.zzNN.stopLoading();
    }

    public void zzD(boolean z) {
        boolean z2 = z;
        this.zzNN.zzD(z2);
    }

    public void zzE(boolean z) {
        boolean z2 = z;
        this.zzNN.zzE(z2);
    }

    public void zzF(boolean z) {
        boolean z2 = z;
        this.zzNN.zzF(z2);
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzcb zzcb) {
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzcb zzcb2 = zzcb;
        this.zzNN.zza(context2, adSizeParcel2, zzcb2);
    }

    public void zza(AdSizeParcel adSizeParcel) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        this.zzNN.zza(adSizeParcel2);
    }

    public void zza(zzau zzau, boolean z) {
        zzau zzau2 = zzau;
        boolean z2 = z;
        this.zzNN.zza(zzau2, z2);
    }

    public void zza(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzNN.zza(str2, zzdf2);
    }

    public void zza(String str, Map<String, ?> map) {
        String str2 = str;
        Map<String, ?> map2 = map;
        this.zzNN.zza(str2, map2);
    }

    public void zza(String str, JSONObject jSONObject) {
        String str2 = str;
        JSONObject jSONObject2 = jSONObject;
        this.zzNN.zza(str2, jSONObject2);
    }

    public void zzaL(String str) {
        String str2 = str;
        this.zzNN.zzaL(str2);
    }

    public void zzaM(String str) {
        String str2 = str;
        this.zzNN.zzaM(str2);
    }

    public AdSizeParcel zzaN() {
        return this.zzNN.zzaN();
    }

    public void zzb(zzd zzd) {
        zzd zzd2 = zzd;
        this.zzNN.zzb(zzd2);
    }

    public void zzb(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzNN.zzb(str2, zzdf2);
    }

    public void zzb(String str, JSONObject jSONObject) {
        String str2 = str;
        JSONObject jSONObject2 = jSONObject;
        this.zzNN.zzb(str2, jSONObject2);
    }

    public void zzc(zzd zzd) {
        zzd zzd2 = zzd;
        this.zzNN.zzc(zzd2);
    }

    public void zze(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.zzNN.zze(str3, str4);
    }

    public boolean zzfL() {
        return this.zzNN.zzfL();
    }

    public void zzfr() {
        this.zzNN.zzfr();
    }

    public void zzhN() {
        this.zzNN.zzhN();
    }

    public void zzhO() {
        this.zzNN.zzhO();
    }

    public Activity zzhP() {
        return this.zzNN.zzhP();
    }

    public Context zzhQ() {
        return this.zzNN.zzhQ();
    }

    public com.google.android.gms.ads.internal.zzd zzhR() {
        return this.zzNN.zzhR();
    }

    public zzd zzhS() {
        return this.zzNN.zzhS();
    }

    public zzd zzhT() {
        return this.zzNN.zzhT();
    }

    public zzjq zzhU() {
        return this.zzNN.zzhU();
    }

    public boolean zzhV() {
        return this.zzNN.zzhV();
    }

    public zzan zzhW() {
        return this.zzNN.zzhW();
    }

    public VersionInfoParcel zzhX() {
        return this.zzNN.zzhX();
    }

    public boolean zzhY() {
        return this.zzNN.zzhY();
    }

    public void zzhZ() {
        this.zzNO.onDestroy();
        this.zzNN.zzhZ();
    }

    public zzjo zzia() {
        return this.zzNO;
    }

    public zzbz zzib() {
        return this.zzNN.zzib();
    }

    public zzca zzic() {
        return this.zzNN.zzic();
    }

    public void zzid() {
        this.zzNN.zzid();
    }

    public void zzie() {
        this.zzNN.zzie();
    }

    public OnClickListener zzif() {
        return this.zzNN.zzif();
    }

    public void zzy(int i) {
        int i2 = i;
        this.zzNN.zzy(i2);
    }
}
