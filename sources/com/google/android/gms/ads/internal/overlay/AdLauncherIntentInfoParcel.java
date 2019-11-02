package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
    public static final zzb CREATOR;
    public final Intent intent;
    public final String intentAction;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final int versionCode;
    public final String zzDK;
    public final String zzDL;
    public final String zzDM;

    static {
        zzb zzb;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
    }

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent2) {
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        Intent intent3 = intent2;
        this.versionCode = i;
        this.intentAction = str8;
        this.url = str9;
        this.mimeType = str10;
        this.packageName = str11;
        this.zzDK = str12;
        this.zzDL = str13;
        this.zzDM = str14;
        this.intent = intent3;
    }

    public AdLauncherIntentInfoParcel(Intent intent2) {
        this(2, null, null, null, null, null, null, null, intent2);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
