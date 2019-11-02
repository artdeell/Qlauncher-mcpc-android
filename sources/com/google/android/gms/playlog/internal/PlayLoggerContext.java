package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR;
    public final String packageName;
    public final int versionCode;
    public final int zzbdL;
    public final int zzbdM;
    public final String zzbdN;
    public final String zzbdO;
    public final boolean zzbdP;
    public final String zzbdQ;
    public final boolean zzbdR;
    public final int zzbdS;

    static {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        CREATOR = zze2;
    }

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        String str5 = str;
        int i5 = i2;
        int i6 = i3;
        String str6 = str2;
        String str7 = str3;
        boolean z3 = z;
        String str8 = str4;
        boolean z4 = z2;
        int i7 = i4;
        this.versionCode = i;
        this.packageName = str5;
        this.zzbdL = i5;
        this.zzbdM = i6;
        this.zzbdN = str6;
        this.zzbdO = str7;
        this.zzbdP = z3;
        this.zzbdQ = str8;
        this.zzbdR = z4;
        this.zzbdS = i7;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        String str5 = str;
        int i4 = i;
        int i5 = i2;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        boolean z2 = z;
        int i6 = i3;
        this.versionCode = 1;
        this.packageName = (String) zzx.zzz(str5);
        this.zzbdL = i4;
        this.zzbdM = i5;
        this.zzbdQ = str6;
        this.zzbdN = str7;
        this.zzbdO = str8;
        this.zzbdP = !z2;
        this.zzbdR = z2;
        this.zzbdS = i6;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        String str4 = str;
        int i3 = i;
        int i4 = i2;
        String str5 = str2;
        String str6 = str3;
        boolean z2 = z;
        this.versionCode = 1;
        this.packageName = (String) zzx.zzz(str4);
        this.zzbdL = i3;
        this.zzbdM = i4;
        this.zzbdQ = null;
        this.zzbdN = str5;
        this.zzbdO = str6;
        this.zzbdP = z2;
        this.zzbdR = false;
        this.zzbdS = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof PlayLoggerContext)) {
                return false;
            }
            PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj2;
            if (!(this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzbdL == playLoggerContext.zzbdL && this.zzbdM == playLoggerContext.zzbdM && zzw.equal(this.zzbdQ, playLoggerContext.zzbdQ) && zzw.equal(this.zzbdN, playLoggerContext.zzbdN) && zzw.equal(this.zzbdO, playLoggerContext.zzbdO) && this.zzbdP == playLoggerContext.zzbdP && this.zzbdR == playLoggerContext.zzbdR && this.zzbdS == playLoggerContext.zzbdS)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzbdL), Integer.valueOf(this.zzbdM), this.zzbdQ, this.zzbdN, this.zzbdO, Boolean.valueOf(this.zzbdP), Boolean.valueOf(this.zzbdR), Integer.valueOf(this.zzbdS));
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("PlayLoggerContext[");
        StringBuilder append2 = sb4.append("versionCode=").append(this.versionCode).append(',');
        StringBuilder append3 = sb4.append("package=").append(this.packageName).append(',');
        StringBuilder append4 = sb4.append("packageVersionCode=").append(this.zzbdL).append(',');
        StringBuilder append5 = sb4.append("logSource=").append(this.zzbdM).append(',');
        StringBuilder append6 = sb4.append("logSourceName=").append(this.zzbdQ).append(',');
        StringBuilder append7 = sb4.append("uploadAccount=").append(this.zzbdN).append(',');
        StringBuilder append8 = sb4.append("loggingId=").append(this.zzbdO).append(',');
        StringBuilder append9 = sb4.append("logAndroidId=").append(this.zzbdP).append(',');
        StringBuilder append10 = sb4.append("isAnonymous=").append(this.zzbdR).append(',');
        StringBuilder append11 = sb4.append("qosTier=").append(this.zzbdS);
        StringBuilder append12 = sb4.append("]");
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
