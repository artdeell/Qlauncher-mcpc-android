package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class StringParcel implements SafeParcelable {
    public static final Creator<StringParcel> CREATOR;
    final int mVersionCode;
    String zzxG;

    static {
        zzn zzn;
        zzn zzn2 = zzn;
        zzn zzn3 = new zzn();
        CREATOR = zzn2;
    }

    StringParcel(int i, String str) {
        String str2 = str;
        this.mVersionCode = i;
        this.zzxG = str2;
    }

    public StringParcel(String str) {
        String str2 = str;
        this.mVersionCode = 1;
        this.zzxG = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public String zzgz() {
        return this.zzxG;
    }
}
