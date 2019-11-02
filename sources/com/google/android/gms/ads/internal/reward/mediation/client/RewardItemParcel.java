package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzhb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class RewardItemParcel implements SafeParcelable {
    public static final zzc CREATOR;
    public final String type;
    public final int versionCode;
    public final int zzKS;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    public RewardItemParcel(int i, String str, int i2) {
        String str2 = str;
        int i3 = i2;
        this.versionCode = i;
        this.type = str2;
        this.zzKS = i3;
    }

    public RewardItemParcel(RewardItem rewardItem) {
        RewardItem rewardItem2 = rewardItem;
        this(1, rewardItem2.getType(), rewardItem2.getAmount());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    @Nullable
    public static RewardItemParcel zza(JSONArray jSONArray) throws JSONException {
        RewardItemParcel rewardItemParcel;
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null || jSONArray2.length() == 0) {
            return null;
        }
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        RewardItemParcel rewardItemParcel3 = new RewardItemParcel(jSONArray2.getJSONObject(0).optString("rb_type"), jSONArray2.getJSONObject(0).optInt("rb_amount"));
        return rewardItemParcel2;
    }

    @Nullable
    public static RewardItemParcel zzay(@Nullable String str) {
        JSONArray jSONArray;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = jSONArray;
            JSONArray jSONArray3 = new JSONArray(str2);
            return zza(jSONArray2);
        } catch (JSONException e) {
            JSONException jSONException = e;
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != null && (obj2 instanceof RewardItemParcel)) {
            RewardItemParcel rewardItemParcel = (RewardItemParcel) obj2;
            if (zzw.equal(this.type, rewardItemParcel.type) && zzw.equal(Integer.valueOf(this.zzKS), Integer.valueOf(rewardItemParcel.zzKS))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.type, Integer.valueOf(this.zzKS));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public JSONArray zzgR() throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        JSONObject put = jSONObject4.put("rb_type", this.type);
        JSONObject put2 = jSONObject4.put("rb_amount", this.zzKS);
        JSONArray jSONArray2 = jSONArray;
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = jSONArray2;
        JSONArray put3 = jSONArray4.put(jSONObject4);
        return jSONArray4;
    }
}
