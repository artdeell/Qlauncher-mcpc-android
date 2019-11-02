package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR;
    final int versionCode;
    private final String zzXL;
    private EmailSignInOptions zzXM;
    private GoogleSignInOptions zzXN;
    private String zzXO;
    private String zzXd;

    static {
        zzp zzp;
        zzp zzp2 = zzp;
        zzp zzp3 = new zzp();
        CREATOR = zzp2;
    }

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        String str4 = str;
        String str5 = str2;
        EmailSignInOptions emailSignInOptions2 = emailSignInOptions;
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        String str6 = str3;
        this.versionCode = i;
        this.zzXL = zzx.zzcM(str4);
        this.zzXd = str5;
        this.zzXM = emailSignInOptions2;
        this.zzXN = googleSignInOptions2;
        this.zzXO = str6;
    }

    public SignInConfiguration(String str) {
        this(2, str, null, null, null, null);
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject;
        RuntimeException runtimeException;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        try {
            JSONObject put = jSONObject4.put("consumerPackageName", this.zzXL);
            if (!TextUtils.isEmpty(this.zzXd)) {
                JSONObject put2 = jSONObject4.put("serverClientId", this.zzXd);
            }
            if (this.zzXM != null) {
                JSONObject put3 = jSONObject4.put("emailSignInOptions", this.zzXM.zzmI());
            }
            if (this.zzXN != null) {
                JSONObject put4 = jSONObject4.put("googleSignInOptions", this.zzXN.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXO)) {
                JSONObject put5 = jSONObject4.put("apiKey", this.zzXO);
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (android.text.TextUtils.isEmpty(r3.zzmR()) != false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (android.text.TextUtils.isEmpty(r3.zznn()) != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r3.zznl() == null) goto L_0x004e;
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
            com.google.android.gms.auth.api.signin.internal.SignInConfiguration r5 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r5     // Catch:{ ClassCastException -> 0x009b }
            r3 = r5
            r5 = r0
            java.lang.String r5 = r5.zzXL     // Catch:{ ClassCastException -> 0x009b }
            r6 = r3
            java.lang.String r6 = r6.zznk()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
            r5 = r0
            java.lang.String r5 = r5.zzXd     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x005d
            r5 = r3
            java.lang.String r5 = r5.zzmR()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
        L_0x002e:
            r5 = r0
            java.lang.String r5 = r5.zzXO     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x006c
            r5 = r3
            java.lang.String r5 = r5.zznn()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
        L_0x0042:
            r5 = r0
            com.google.android.gms.auth.api.signin.EmailSignInOptions r5 = r5.zzXM     // Catch:{ ClassCastException -> 0x009b }
            if (r5 != 0) goto L_0x007b
            r5 = r3
            com.google.android.gms.auth.api.signin.EmailSignInOptions r5 = r5.zznl()     // Catch:{ ClassCastException -> 0x009b }
            if (r5 != 0) goto L_0x0005
        L_0x004e:
            r5 = r0
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = r5.zzXN     // Catch:{ ClassCastException -> 0x009b }
            if (r5 != 0) goto L_0x008a
            r5 = r3
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = r5.zznm()     // Catch:{ ClassCastException -> 0x009b }
            if (r5 != 0) goto L_0x0005
        L_0x005a:
            r5 = 1
            r0 = r5
            goto L_0x0007
        L_0x005d:
            r5 = r0
            java.lang.String r5 = r5.zzXd     // Catch:{ ClassCastException -> 0x009b }
            r6 = r3
            java.lang.String r6 = r6.zzmR()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
            goto L_0x002e
        L_0x006c:
            r5 = r0
            java.lang.String r5 = r5.zzXO     // Catch:{ ClassCastException -> 0x009b }
            r6 = r3
            java.lang.String r6 = r6.zznn()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
            goto L_0x0042
        L_0x007b:
            r5 = r0
            com.google.android.gms.auth.api.signin.EmailSignInOptions r5 = r5.zzXM     // Catch:{ ClassCastException -> 0x009b }
            r6 = r3
            com.google.android.gms.auth.api.signin.EmailSignInOptions r6 = r6.zznl()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x009b }
            if (r5 == 0) goto L_0x0005
            goto L_0x004e
        L_0x008a:
            r5 = r0
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = r5.zzXN     // Catch:{ ClassCastException -> 0x009b }
            r6 = r3
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r6 = r6.zznm()     // Catch:{ ClassCastException -> 0x009b }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x009b }
            r4 = r5
            r5 = r4
            if (r5 == 0) goto L_0x0005
            goto L_0x005a
        L_0x009b:
            r5 = move-exception
            r2 = r5
            r5 = 0
            r0 = r5
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInConfiguration.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        return zze2.zzp(this.zzXL).zzp(this.zzXd).zzp(this.zzXO).zzp(this.zzXM).zzp(this.zzXN).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public SignInConfiguration zzj(GoogleSignInOptions googleSignInOptions) {
        this.zzXN = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public String zzmR() {
        return this.zzXd;
    }

    public String zznk() {
        return this.zzXL;
    }

    public EmailSignInOptions zznl() {
        return this.zzXM;
    }

    public GoogleSignInOptions zznm() {
        return this.zzXN;
    }

    public String zznn() {
        return this.zzXO;
    }
}
