package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR;
    String description;
    final int version;
    List<String> zzYA;
    public FACLData zzYB;
    String zzYw;
    String zzYx;
    String zzYy;
    String zzYz;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        List<String> list2 = list;
        FACLData fACLData2 = fACLData;
        this.version = i;
        this.description = str6;
        this.zzYw = str7;
        this.zzYx = str8;
        this.zzYy = str9;
        this.zzYz = str10;
        this.zzYA = list2;
        this.zzYB = fACLData2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
