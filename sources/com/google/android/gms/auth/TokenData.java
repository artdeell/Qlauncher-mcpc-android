package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zze CREATOR;
    final int mVersionCode;
    private final String zzVo;
    private final Long zzVp;
    private final boolean zzVq;
    private final boolean zzVr;
    private final List<String> zzVs;

    static {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        CREATOR = zze2;
    }

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        String str2 = str;
        Long l2 = l;
        boolean z3 = z;
        boolean z4 = z2;
        List<String> list2 = list;
        this.mVersionCode = i;
        this.zzVo = zzx.zzcM(str2);
        this.zzVp = l2;
        this.zzVq = z3;
        this.zzVr = z4;
        this.zzVs = list2;
    }

    @Nullable
    public static TokenData zzc(Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        String str2 = str;
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle3 = bundle2.getBundle(str2);
        if (bundle3 == null) {
            return null;
        }
        bundle3.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle3.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof TokenData) {
            TokenData tokenData = (TokenData) obj2;
            if (TextUtils.equals(this.zzVo, tokenData.zzVo) && zzw.equal(this.zzVp, tokenData.zzVp) && this.zzVq == tokenData.zzVq && this.zzVr == tokenData.zzVr && zzw.equal(this.zzVs, tokenData.zzVs)) {
                return true;
            }
        }
        return false;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzVo, this.zzVp, Boolean.valueOf(this.zzVq), Boolean.valueOf(this.zzVr), this.zzVs);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    @Nullable
    public Long zzmn() {
        return this.zzVp;
    }

    public boolean zzmo() {
        return this.zzVq;
    }

    public boolean zzmp() {
        return this.zzVr;
    }

    @Nullable
    public List<String> zzmq() {
        return this.zzVs;
    }
}
