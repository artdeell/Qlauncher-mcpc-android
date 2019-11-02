package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR;
    public static zzmq zzWO = zzmt.zzsc();
    private static Comparator<Scope> zzWV;
    final int versionCode;
    List<Scope> zzVs;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWS;
    private long zzWT;
    private String zzWU;
    private String zzWk;
    private String zzyv;

    static {
        zzb zzb;
        C02151 r2;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
        C02151 r0 = r2;
        C02151 r1 = new Comparator<Scope>() {
            /* renamed from: zza */
            public int compare(Scope scope, Scope scope2) {
                return scope.zzpb().compareTo(scope2.zzpb());
            }
        };
        zzWV = r0;
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        Uri uri2 = uri;
        String str11 = str5;
        long j2 = j;
        String str12 = str6;
        List<Scope> list2 = list;
        this.versionCode = i;
        this.zzyv = str7;
        this.zzWk = str8;
        this.zzWP = str9;
        this.zzWQ = str10;
        this.zzWR = uri2;
        this.zzWS = str11;
        this.zzWT = j2;
        this.zzWU = str12;
        this.zzVs = list2;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable Long l, @NonNull String str5, @NonNull Set<Scope> set) {
        GoogleSignInAccount googleSignInAccount;
        ArrayList arrayList;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        Uri uri2 = uri;
        Long l2 = l;
        String str10 = str5;
        Set<Scope> set2 = set;
        if (l2 == null) {
            l2 = Long.valueOf(zzWO.currentTimeMillis() / 1000);
        }
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        String str11 = str6;
        String str12 = str7;
        String str13 = str8;
        String str14 = str9;
        Uri uri3 = uri2;
        long longValue = l2.longValue();
        String zzcM = zzx.zzcM(str10);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList((Collection) zzx.zzz(set2));
        GoogleSignInAccount googleSignInAccount3 = new GoogleSignInAccount(2, str11, str12, str13, str14, uri3, null, longValue, zzcM, arrayList2);
        return googleSignInAccount2;
    }

    @Nullable
    public static GoogleSignInAccount zzbH(@Nullable String str) throws JSONException {
        JSONObject jSONObject;
        HashSet hashSet;
        Scope scope;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject(str2);
        JSONObject jSONObject4 = jSONObject2;
        String optString = jSONObject4.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject4.getString("expirationTime"));
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        JSONArray jSONArray = jSONObject4.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            HashSet hashSet5 = hashSet4;
            Scope scope2 = scope;
            Scope scope3 = new Scope(jSONArray.getString(i));
            boolean add = hashSet5.add(scope2);
        }
        return zza(jSONObject4.optString("id"), jSONObject4.optString("tokenId", null), jSONObject4.optString("email", null), jSONObject4.optString("displayName", null), uri, Long.valueOf(parseLong), jSONObject4.getString("obfuscatedIdentifier"), hashSet4).zzbI(jSONObject4.optString("serverAuthCode", null));
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject;
        RuntimeException runtimeException;
        JSONArray jSONArray;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        try {
            if (getId() != null) {
                JSONObject put = jSONObject4.put("id", getId());
            }
            if (getIdToken() != null) {
                JSONObject put2 = jSONObject4.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                JSONObject put3 = jSONObject4.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                JSONObject put4 = jSONObject4.put("displayName", getDisplayName());
            }
            if (getPhotoUrl() != null) {
                JSONObject put5 = jSONObject4.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                JSONObject put6 = jSONObject4.put("serverAuthCode", getServerAuthCode());
            }
            JSONObject put7 = jSONObject4.put("expirationTime", this.zzWT);
            JSONObject put8 = jSONObject4.put("obfuscatedIdentifier", zzmL());
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = jSONArray2;
            Collections.sort(this.zzVs, zzWV);
            for (Scope zzpb : this.zzVs) {
                JSONArray put9 = jSONArray4.put(zzpb.zzpb());
            }
            JSONObject put10 = jSONObject4.put("grantedScopes", jSONArray4);
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

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj2).zzmI().equals(zzmI());
    }

    @Nullable
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Nullable
    public String getEmail() {
        return this.zzWP;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        HashSet hashSet;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(this.zzVs);
        return hashSet2;
    }

    @Nullable
    public String getId() {
        return this.zzyv;
    }

    @Nullable
    public String getIdToken() {
        return this.zzWk;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.zzWS;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public boolean zzb() {
        return zzWO.currentTimeMillis() / 1000 >= this.zzWT - 300;
    }

    public GoogleSignInAccount zzbI(String str) {
        this.zzWS = str;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public long zzmK() {
        return this.zzWT;
    }

    @NonNull
    public String zzmL() {
        return this.zzWU;
    }

    public String zzmM() {
        JSONObject zzmJ = zzmJ();
        Object remove = zzmJ.remove("serverAuthCode");
        return zzmJ.toString();
    }
}
