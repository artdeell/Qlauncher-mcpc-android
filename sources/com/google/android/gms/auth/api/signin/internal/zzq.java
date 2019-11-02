package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzq {
    private static final Lock zzYa;
    private static zzq zzYb;
    private final Lock zzYc;
    private final SharedPreferences zzYd;

    static {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2 = reentrantLock;
        ReentrantLock reentrantLock3 = new ReentrantLock();
        zzYa = reentrantLock2;
    }

    zzq(Context context) {
        ReentrantLock reentrantLock;
        Context context2 = context;
        ReentrantLock reentrantLock2 = reentrantLock;
        ReentrantLock reentrantLock3 = new ReentrantLock();
        this.zzYc = reentrantLock2;
        this.zzYd = context2.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* JADX INFO: finally extract failed */
    public static zzq zzaf(Context context) {
        zzq zzq;
        Context context2 = context;
        Object zzz = zzx.zzz(context2);
        zzYa.lock();
        try {
            if (zzYb == null) {
                zzq zzq2 = zzq;
                zzq zzq3 = new zzq(context2.getApplicationContext());
                zzYb = zzq2;
            }
            zzq zzq4 = zzYb;
            zzYa.unlock();
            return zzq4;
        } catch (Throwable th) {
            Throwable th2 = th;
            zzYa.unlock();
            throw th2;
        }
    }

    private String zzs(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str3).append(":").append(str4).toString();
    }

    /* access modifiers changed from: 0000 */
    public void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        Object zzz = zzx.zzz(googleSignInAccount2);
        Object zzz2 = zzx.zzz(googleSignInOptions2);
        String zzmL = googleSignInAccount2.zzmL();
        zzr(zzs("googleSignInAccount", zzmL), googleSignInAccount2.zzmM());
        zzr(zzs("googleSignInOptions", zzmL), googleSignInOptions2.zzmI());
    }

    /* access modifiers changed from: 0000 */
    public void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        SignInAccount signInAccount2 = signInAccount;
        SignInConfiguration signInConfiguration2 = signInConfiguration;
        Object zzz = zzx.zzz(signInAccount2);
        Object zzz2 = zzx.zzz(signInConfiguration2);
        String userId = signInAccount2.getUserId();
        SignInAccount zzbP = zzbP(userId);
        if (!(zzbP == null || zzbP.zzmV() == null)) {
            zzbU(zzbP.zzmV().zzmL());
        }
        zzr(zzs("signInConfiguration", userId), signInConfiguration2.zzmI());
        zzr(zzs("signInAccount", userId), signInAccount2.zzmI());
        if (signInAccount2.zzmV() != null) {
            zza(signInAccount2.zzmV(), signInConfiguration2.zznm());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        Object zzz = zzx.zzz(googleSignInAccount2);
        Object zzz2 = zzx.zzz(googleSignInOptions2);
        zzr("defaultGoogleSignInAccount", googleSignInAccount2.zzmL());
        zza(googleSignInAccount2, googleSignInOptions2);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        SignInAccount signInAccount2 = signInAccount;
        SignInConfiguration signInConfiguration2 = signInConfiguration;
        Object zzz = zzx.zzz(signInAccount2);
        Object zzz2 = zzx.zzz(signInConfiguration2);
        zznq();
        zzr("defaultSignInAccount", signInAccount2.getUserId());
        if (signInAccount2.zzmV() != null) {
            zzr("defaultGoogleSignInAccount", signInAccount2.zzmV().zzmL());
        }
        zza(signInAccount2, signInConfiguration2);
    }

    /* access modifiers changed from: 0000 */
    public SignInAccount zzbP(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            String zzbS = zzbS(zzs("signInAccount", str2));
            if (!TextUtils.isEmpty(zzbS)) {
                try {
                    SignInAccount zzbM = SignInAccount.zzbM(zzbS);
                    if (zzbM.zzmV() != null) {
                        GoogleSignInAccount zzbQ = zzbQ(zzbM.zzmV().zzmL());
                        if (zzbQ != null) {
                            SignInAccount zza = zzbM.zza(zzbQ);
                        }
                    }
                    return zzbM;
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    return null;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public GoogleSignInAccount zzbQ(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            String zzbS = zzbS(zzs("googleSignInAccount", str2));
            if (zzbS != null) {
                try {
                    return GoogleSignInAccount.zzbH(zzbS);
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    return null;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public GoogleSignInOptions zzbR(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            String zzbS = zzbS(zzs("googleSignInOptions", str2));
            if (zzbS != null) {
                try {
                    return GoogleSignInOptions.zzbJ(zzbS);
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public String zzbS(String str) {
        String str2 = str;
        this.zzYc.lock();
        try {
            String string = this.zzYd.getString(str2, null);
            this.zzYc.unlock();
            return string;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzYc.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzbT(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            SignInAccount zzbP = zzbP(str2);
            zzbV(zzs("signInAccount", str2));
            zzbV(zzs("signInConfiguration", str2));
            if (zzbP != null && zzbP.zzmV() != null) {
                zzbU(zzbP.zzmV().zzmL());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzbU(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            zzbV(zzs("googleSignInAccount", str2));
            zzbV(zzs("googleSignInOptions", str2));
        }
    }

    /* access modifiers changed from: protected */
    public void zzbV(String str) {
        String str2 = str;
        this.zzYc.lock();
        try {
            this.zzYd.edit().remove(str2).apply();
            this.zzYc.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzYc.unlock();
            throw th2;
        }
    }

    public GoogleSignInAccount zzno() {
        return zzbQ(zzbS("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zznp() {
        return zzbR(zzbS("defaultGoogleSignInAccount"));
    }

    public void zznq() {
        String zzbS = zzbS("defaultSignInAccount");
        zzbV("defaultSignInAccount");
        zznr();
        zzbT(zzbS);
    }

    public void zznr() {
        String zzbS = zzbS("defaultGoogleSignInAccount");
        zzbV("defaultGoogleSignInAccount");
        zzbU(zzbS);
    }

    /* access modifiers changed from: protected */
    public void zzr(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.zzYc.lock();
        try {
            this.zzYd.edit().putString(str3, str4).apply();
            this.zzYc.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzYc.unlock();
            throw th2;
        }
    }
}
