package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Creator<SignInAccount> CREATOR;
    final int versionCode;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWk;
    private String zzXj;
    private GoogleSignInAccount zzXm;
    private String zzXn;
    private String zzrG;

    static {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        CREATOR = zze2;
    }

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        Uri uri2 = uri;
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        String str11 = str5;
        String str12 = str6;
        this.versionCode = i;
        this.zzWP = zzx.zzh(str9, "Email cannot be empty.");
        this.zzWQ = str10;
        this.zzWR = uri2;
        this.zzXj = str7;
        this.zzWk = str8;
        this.zzXm = googleSignInAccount2;
        this.zzrG = zzx.zzcM(str11);
        this.zzXn = str12;
    }

    public static SignInAccount zza(zzd zzd, String str, String str2, String str3, Uri uri, String str4, String str5) {
        SignInAccount signInAccount;
        zzd zzd2 = zzd;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        Uri uri2 = uri;
        String str9 = str4;
        String str10 = str5;
        String str11 = null;
        if (zzd2 != null) {
            str11 = zzd2.zzmT();
        }
        SignInAccount signInAccount2 = signInAccount;
        SignInAccount signInAccount3 = new SignInAccount(2, str11, str6, str7, str8, uri2, null, str9, str10);
        return signInAccount2;
    }

    public static SignInAccount zzbM(String str) throws JSONException {
        JSONObject jSONObject;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject(str2);
        JSONObject jSONObject4 = jSONObject2;
        String optString = jSONObject4.optString("photoUrl", null);
        return zza(zzd.zzbL(jSONObject4.optString("providerId", null)), jSONObject4.optString("tokenId", null), jSONObject4.getString("email"), jSONObject4.optString("displayName", null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject4.getString("localId"), jSONObject4.optString("refreshToken")).zza(GoogleSignInAccount.zzbH(jSONObject4.optString("googleSignInAccount")));
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject;
        RuntimeException runtimeException;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        try {
            JSONObject put = jSONObject4.put("email", getEmail());
            if (!TextUtils.isEmpty(this.zzWQ)) {
                JSONObject put2 = jSONObject4.put("displayName", this.zzWQ);
            }
            if (this.zzWR != null) {
                JSONObject put3 = jSONObject4.put("photoUrl", this.zzWR.toString());
            }
            if (!TextUtils.isEmpty(this.zzXj)) {
                JSONObject put4 = jSONObject4.put("providerId", this.zzXj);
            }
            if (!TextUtils.isEmpty(this.zzWk)) {
                JSONObject put5 = jSONObject4.put("tokenId", this.zzWk);
            }
            if (this.zzXm != null) {
                JSONObject put6 = jSONObject4.put("googleSignInAccount", this.zzXm.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXn)) {
                JSONObject put7 = jSONObject4.put("refreshToken", this.zzXn);
            }
            JSONObject put8 = jSONObject4.put("localId", getUserId());
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

    public String getDisplayName() {
        return this.zzWQ;
    }

    public String getEmail() {
        return this.zzWP;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    public String getUserId() {
        return this.zzrG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzXm = googleSignInAccount;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    /* access modifiers changed from: 0000 */
    public String zzmT() {
        return this.zzXj;
    }

    public zzd zzmU() {
        return zzd.zzbL(this.zzXj);
    }

    public GoogleSignInAccount zzmV() {
        return this.zzXm;
    }

    public String zzmW() {
        return this.zzXn;
    }
}
