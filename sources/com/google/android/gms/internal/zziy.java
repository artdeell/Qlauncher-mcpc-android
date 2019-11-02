package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzhb
public final class zziy extends zzim {
    private final Context mContext;
    private final String zzF;
    private final String zzsy;
    private String zzzN = null;

    public zziy(Context context, String str, String str2) {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        this.mContext = context2;
        this.zzsy = str3;
        this.zzF = str4;
    }

    public zziy(Context context, String str, String str2, String str3) {
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.mContext = context2;
        this.zzsy = str4;
        this.zzF = str5;
        this.zzzN = str6;
    }

    public void onStop() {
    }

    public void zzbr() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        URL url;
        HttpURLConnection httpURLConnection;
        StringBuilder sb5;
        try {
            StringBuilder sb6 = sb4;
            StringBuilder sb7 = new StringBuilder();
            zzin.m20v(sb6.append("Pinging URL: ").append(this.zzF).toString());
            URL url2 = url;
            URL url3 = new URL(this.zzF);
            httpURLConnection = (HttpURLConnection) url2.openConnection();
            if (TextUtils.isEmpty(this.zzzN)) {
                zzr.zzbC().zza(this.mContext, this.zzsy, true, httpURLConnection);
            } else {
                zzr.zzbC().zza(this.mContext, this.zzsy, true, httpURLConnection, this.zzzN);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb8 = sb5;
                StringBuilder sb9 = new StringBuilder();
                zzin.zzaK(sb8.append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(this.zzF).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            StringBuilder sb10 = sb3;
            StringBuilder sb11 = new StringBuilder();
            zzin.zzaK(sb10.append("Error while parsing ping URL: ").append(this.zzF).append(". ").append(indexOutOfBoundsException.getMessage()).toString());
        } catch (IOException e2) {
            IOException iOException = e2;
            StringBuilder sb12 = sb2;
            StringBuilder sb13 = new StringBuilder();
            zzin.zzaK(sb12.append("Error while pinging URL: ").append(this.zzF).append(". ").append(iOException.getMessage()).toString());
        } catch (RuntimeException e3) {
            RuntimeException runtimeException = e3;
            StringBuilder sb14 = sb;
            StringBuilder sb15 = new StringBuilder();
            zzin.zzaK(sb14.append("Error while pinging URL: ").append(this.zzF).append(". ").append(runtimeException.getMessage()).toString());
        } catch (Throwable th) {
            Throwable th2 = th;
            httpURLConnection.disconnect();
            throw th2;
        }
    }
}
