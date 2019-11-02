package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator<EmailSignInOptions> CREATOR;
    final int versionCode;
    private final Uri zzWL;
    private String zzWM;
    private Uri zzWN;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        int i2 = i;
        Uri uri3 = uri;
        String str2 = str;
        Uri uri4 = uri2;
        Object zzb = zzx.zzb(uri3, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        String zzh = zzx.zzh(uri3.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri3.toString()).matches(), (Object) "Invalid server widget url");
        this.versionCode = i2;
        this.zzWL = uri3;
        this.zzWM = str2;
        this.zzWN = uri4;
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject;
        RuntimeException runtimeException;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        try {
            JSONObject put = jSONObject4.put("serverWidgetUrl", this.zzWL.toString());
            if (!TextUtils.isEmpty(this.zzWM)) {
                JSONObject put2 = jSONObject4.put("modeQueryName", this.zzWM);
            }
            if (this.zzWN != null) {
                JSONObject put3 = jSONObject4.put("tosUrl", this.zzWN.toString());
            }
            return jSONObject4;
        } catch (JSONException e) {
            JSONException jSONException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(jSONException);
            throw runtimeException2;
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r3.zzmG() == null) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r5 = r1
            if (r5 != 0) goto L_0x0008
        L_0x0005:
            r5 = 0
            r0 = r5
        L_0x0007:
            return r0
        L_0x0008:
            r5 = r1
            com.google.android.gms.auth.api.signin.EmailSignInOptions r5 = (com.google.android.gms.auth.api.signin.EmailSignInOptions) r5     // Catch:{ ClassCastException -> 0x005d }
            r3 = r5
            r5 = r0
            android.net.Uri r5 = r5.zzWL     // Catch:{ ClassCastException -> 0x005d }
            r6 = r3
            android.net.Uri r6 = r6.zzmF()     // Catch:{ ClassCastException -> 0x005d }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x005d }
            if (r5 == 0) goto L_0x0005
            r5 = r0
            android.net.Uri r5 = r5.zzWN     // Catch:{ ClassCastException -> 0x005d }
            if (r5 != 0) goto L_0x003d
            r5 = r3
            android.net.Uri r5 = r5.zzmG()     // Catch:{ ClassCastException -> 0x005d }
            if (r5 != 0) goto L_0x0005
        L_0x0026:
            r5 = r0
            java.lang.String r5 = r5.zzWM     // Catch:{ ClassCastException -> 0x005d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x005d }
            if (r5 == 0) goto L_0x004c
            r5 = r3
            java.lang.String r5 = r5.zzmH()     // Catch:{ ClassCastException -> 0x005d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x005d }
            if (r5 == 0) goto L_0x0005
        L_0x003a:
            r5 = 1
            r0 = r5
            goto L_0x0007
        L_0x003d:
            r5 = r0
            android.net.Uri r5 = r5.zzWN     // Catch:{ ClassCastException -> 0x005d }
            r6 = r3
            android.net.Uri r6 = r6.zzmG()     // Catch:{ ClassCastException -> 0x005d }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x005d }
            if (r5 == 0) goto L_0x0005
            goto L_0x0026
        L_0x004c:
            r5 = r0
            java.lang.String r5 = r5.zzWM     // Catch:{ ClassCastException -> 0x005d }
            r6 = r3
            java.lang.String r6 = r6.zzmH()     // Catch:{ ClassCastException -> 0x005d }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x005d }
            r4 = r5
            r5 = r4
            if (r5 == 0) goto L_0x0005
            goto L_0x003a
        L_0x005d:
            r5 = move-exception
            r2 = r5
            r5 = 0
            r0 = r5
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.EmailSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        return zze2.zzp(this.zzWL).zzp(this.zzWN).zzp(this.zzWM).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzmF() {
        return this.zzWL;
    }

    public Uri zzmG() {
        return this.zzWN;
    }

    public String zzmH() {
        return this.zzWM;
    }

    public String zzmI() {
        return zzmJ().toString();
    }
}
