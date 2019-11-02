package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.auth.zzd;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions implements Optional, SafeParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    private static Comparator<Scope> zzWV;
    public static final Scope zzWW;
    public static final Scope zzWX;
    public static final Scope zzWY;
    final int versionCode;
    /* access modifiers changed from: private */
    public Account zzTI;
    /* access modifiers changed from: private */
    public final ArrayList<Scope> zzWZ;
    /* access modifiers changed from: private */
    public boolean zzXa;
    /* access modifiers changed from: private */
    public final boolean zzXb;
    /* access modifiers changed from: private */
    public final boolean zzXc;
    /* access modifiers changed from: private */
    public String zzXd;
    /* access modifiers changed from: private */
    public String zzXe;

    public static final class Builder {
        private Account zzTI;
        private boolean zzXa;
        private boolean zzXb;
        private boolean zzXc;
        private String zzXd;
        private String zzXe;
        private Set<Scope> zzXf;

        public Builder() {
            HashSet hashSet;
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet();
            this.zzXf = hashSet2;
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            HashSet hashSet;
            HashSet hashSet2;
            GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
            HashSet hashSet3 = hashSet;
            HashSet hashSet4 = new HashSet();
            this.zzXf = hashSet3;
            Object zzz = zzx.zzz(googleSignInOptions2);
            HashSet hashSet5 = hashSet2;
            HashSet hashSet6 = new HashSet(googleSignInOptions2.zzWZ);
            this.zzXf = hashSet5;
            this.zzXb = googleSignInOptions2.zzXb;
            this.zzXc = googleSignInOptions2.zzXc;
            this.zzXa = googleSignInOptions2.zzXa;
            this.zzXd = googleSignInOptions2.zzXd;
            this.zzTI = googleSignInOptions2.zzTI;
            this.zzXe = googleSignInOptions2.zzXe;
        }

        private String zzbK(String str) {
            String str2 = str;
            String zzcM = zzx.zzcM(str2);
            zzx.zzb(this.zzXd == null || this.zzXd.equals(str2), (Object) "two different server client ids provided");
            return str2;
        }

        public GoogleSignInOptions build() {
            GoogleSignInOptions googleSignInOptions;
            if (this.zzXa && (this.zzTI == null || !this.zzXf.isEmpty())) {
                Builder requestId = requestId();
            }
            GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
            GoogleSignInOptions googleSignInOptions3 = new GoogleSignInOptions((Set) this.zzXf, this.zzTI, this.zzXa, this.zzXb, this.zzXc, this.zzXd, this.zzXe, (C02161) null);
            return googleSignInOptions2;
        }

        public Builder requestEmail() {
            boolean add = this.zzXf.add(GoogleSignInOptions.zzWX);
            return this;
        }

        public Builder requestId() {
            boolean add = this.zzXf.add(GoogleSignInOptions.zzWY);
            return this;
        }

        public Builder requestIdToken(String str) {
            String str2 = str;
            this.zzXa = true;
            this.zzXd = zzbK(str2);
            return this;
        }

        public Builder requestProfile() {
            boolean add = this.zzXf.add(GoogleSignInOptions.zzWW);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            Scope[] scopeArr2 = scopeArr;
            boolean add = this.zzXf.add(scope);
            boolean addAll = this.zzXf.addAll(Arrays.asList(scopeArr2));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            String str2 = str;
            boolean z2 = z;
            this.zzXb = true;
            this.zzXd = zzbK(str2);
            this.zzXc = z2;
            return this;
        }

        public Builder setAccountName(String str) {
            Account account;
            Account account2 = account;
            Account account3 = new Account(zzx.zzcM(str), zzd.GOOGLE_ACCOUNT_TYPE);
            this.zzTI = account2;
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.zzXe = zzx.zzcM(str);
            return this;
        }
    }

    static {
        Scope scope;
        Scope scope2;
        Scope scope3;
        Builder builder;
        zzc zzc;
        C02161 r3;
        Scope scope4 = scope;
        Scope scope5 = new Scope(Scopes.PROFILE);
        zzWW = scope4;
        Scope scope6 = scope2;
        Scope scope7 = new Scope("email");
        zzWX = scope6;
        Scope scope8 = scope3;
        Scope scope9 = new Scope("openid");
        zzWY = scope8;
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        DEFAULT_SIGN_IN = builder2.requestId().requestProfile().build();
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
        C02161 r0 = r3;
        C02161 r1 = new Comparator<Scope>() {
            /* renamed from: zza */
            public int compare(Scope scope, Scope scope2) {
                return scope.zzpb().compareTo(scope2.zzpb());
            }
        };
        zzWV = r0;
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        ArrayList<Scope> arrayList2 = arrayList;
        Account account2 = account;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        String str3 = str;
        String str4 = str2;
        this.versionCode = i;
        this.zzWZ = arrayList2;
        this.zzTI = account2;
        this.zzXa = z4;
        this.zzXb = z5;
        this.zzXc = z6;
        this.zzXd = str3;
        this.zzXe = str4;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        ArrayList arrayList;
        Account account2 = account;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        String str3 = str;
        String str4 = str2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(set);
        this(2, arrayList2, account2, z4, z5, z6, str3, str4);
    }

    /* synthetic */ GoogleSignInOptions(Set set, Account account, boolean z, boolean z2, boolean z3, String str, String str2, C02161 r25) {
        C02161 r8 = r25;
        this(set, account, z, z2, z3, str, str2);
    }

    @Nullable
    public static GoogleSignInOptions zzbJ(@Nullable String str) throws JSONException {
        JSONObject jSONObject;
        HashSet hashSet;
        Account account;
        GoogleSignInOptions googleSignInOptions;
        Account account2;
        Scope scope;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject(str2);
        JSONObject jSONObject4 = jSONObject2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        JSONArray jSONArray = jSONObject4.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            HashSet hashSet5 = hashSet4;
            Scope scope2 = scope;
            Scope scope3 = new Scope(jSONArray.getString(i));
            boolean add = hashSet5.add(scope2);
        }
        String optString = jSONObject4.optString("accountName", null);
        if (!TextUtils.isEmpty(optString)) {
            Account account3 = account2;
            Account account4 = new Account(optString, zzd.GOOGLE_ACCOUNT_TYPE);
            account = account3;
        } else {
            account = null;
        }
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        GoogleSignInOptions googleSignInOptions3 = new GoogleSignInOptions(hashSet4, account, jSONObject4.getBoolean("idTokenRequested"), jSONObject4.getBoolean("serverAuthRequested"), jSONObject4.getBoolean("forceCodeForRefreshToken"), jSONObject4.optString("serverClientId", null), jSONObject4.optString("hostedDomain", null));
        return googleSignInOptions2;
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject;
        RuntimeException runtimeException;
        JSONArray jSONArray;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        try {
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = jSONArray2;
            Collections.sort(this.zzWZ, zzWV);
            Iterator it = this.zzWZ.iterator();
            while (it.hasNext()) {
                JSONArray put = jSONArray4.put(((Scope) it.next()).zzpb());
            }
            JSONObject put2 = jSONObject4.put("scopes", jSONArray4);
            if (this.zzTI != null) {
                JSONObject put3 = jSONObject4.put("accountName", this.zzTI.name);
            }
            JSONObject put4 = jSONObject4.put("idTokenRequested", this.zzXa);
            JSONObject put5 = jSONObject4.put("forceCodeForRefreshToken", this.zzXc);
            JSONObject put6 = jSONObject4.put("serverAuthRequested", this.zzXb);
            if (!TextUtils.isEmpty(this.zzXd)) {
                JSONObject put7 = jSONObject4.put("serverClientId", this.zzXd);
            }
            if (!TextUtils.isEmpty(this.zzXe)) {
                JSONObject put8 = jSONObject4.put("hostedDomain", this.zzXe);
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

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r3.getAccount() == null) goto L_0x0038;
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
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r5     // Catch:{ ClassCastException -> 0x008d }
            r3 = r5
            r5 = r0
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r5 = r5.zzWZ     // Catch:{ ClassCastException -> 0x008d }
            int r5 = r5.size()     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            java.util.ArrayList r6 = r6.zzmN()     // Catch:{ ClassCastException -> 0x008d }
            int r6 = r6.size()     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != r6) goto L_0x0005
            r5 = r0
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r5 = r5.zzWZ     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            java.util.ArrayList r6 = r6.zzmN()     // Catch:{ ClassCastException -> 0x008d }
            boolean r5 = r5.containsAll(r6)     // Catch:{ ClassCastException -> 0x008d }
            if (r5 == 0) goto L_0x0005
            r5 = r0
            android.accounts.Account r5 = r5.zzTI     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != 0) goto L_0x006d
            r5 = r3
            android.accounts.Account r5 = r5.getAccount()     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != 0) goto L_0x0005
        L_0x0038:
            r5 = r0
            java.lang.String r5 = r5.zzXd     // Catch:{ ClassCastException -> 0x008d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x008d }
            if (r5 == 0) goto L_0x007c
            r5 = r3
            java.lang.String r5 = r5.zzmR()     // Catch:{ ClassCastException -> 0x008d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ ClassCastException -> 0x008d }
            if (r5 == 0) goto L_0x0005
        L_0x004c:
            r5 = r0
            boolean r5 = r5.zzXc     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            boolean r6 = r6.zzmQ()     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != r6) goto L_0x0005
            r5 = r0
            boolean r5 = r5.zzXa     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            boolean r6 = r6.zzmO()     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != r6) goto L_0x0005
            r5 = r0
            boolean r5 = r5.zzXb     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            boolean r6 = r6.zzmP()     // Catch:{ ClassCastException -> 0x008d }
            if (r5 != r6) goto L_0x0005
            r5 = 1
            r0 = r5
            goto L_0x0007
        L_0x006d:
            r5 = r0
            android.accounts.Account r5 = r5.zzTI     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            android.accounts.Account r6 = r6.getAccount()     // Catch:{ ClassCastException -> 0x008d }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x008d }
            if (r5 == 0) goto L_0x0005
            goto L_0x0038
        L_0x007c:
            r5 = r0
            java.lang.String r5 = r5.zzXd     // Catch:{ ClassCastException -> 0x008d }
            r6 = r3
            java.lang.String r6 = r6.zzmR()     // Catch:{ ClassCastException -> 0x008d }
            boolean r5 = r5.equals(r6)     // Catch:{ ClassCastException -> 0x008d }
            r4 = r5
            r5 = r4
            if (r5 == 0) goto L_0x0005
            goto L_0x004c
        L_0x008d:
            r5 = move-exception
            r2 = r5
            r5 = 0
            r0 = r5
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.zzWZ.toArray(new Scope[this.zzWZ.size()]);
    }

    public int hashCode() {
        ArrayList arrayList;
        zze zze;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Iterator it = this.zzWZ.iterator();
        while (it.hasNext()) {
            boolean add = arrayList4.add(((Scope) it.next()).zzpb());
        }
        Collections.sort(arrayList4);
        zze zze2 = zze;
        zze zze3 = new zze();
        return zze2.zzp(arrayList4).zzp(this.zzTI).zzp(this.zzXd).zzP(this.zzXc).zzP(this.zzXa).zzP(this.zzXb).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public ArrayList<Scope> zzmN() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.zzWZ);
        return arrayList2;
    }

    public boolean zzmO() {
        return this.zzXa;
    }

    public boolean zzmP() {
        return this.zzXb;
    }

    public boolean zzmQ() {
        return this.zzXc;
    }

    public String zzmR() {
        return this.zzXd;
    }

    public String zzmS() {
        return this.zzXe;
    }
}
