package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR;
    public final String tag;
    public final int versionCode;
    public final long zzbdA;
    public final long zzbdB;
    public final byte[] zzbdC;
    public final Bundle zzbdD;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        long j3 = j;
        long j4 = j2;
        String str2 = str;
        byte[] bArr2 = bArr;
        Bundle bundle2 = bundle;
        this.versionCode = i;
        this.zzbdA = j3;
        this.zzbdB = j4;
        this.tag = str2;
        this.zzbdC = bArr2;
        this.zzbdD = bundle2;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        long j3 = j;
        long j4 = j2;
        String str2 = str;
        byte[] bArr2 = bArr;
        String[] strArr2 = strArr;
        this.versionCode = 1;
        this.zzbdA = j3;
        this.zzbdB = j4;
        this.tag = str2;
        this.zzbdC = bArr2;
        this.zzbdD = zzd(strArr2);
    }

    private static Bundle zzd(String... strArr) {
        Bundle bundle;
        IllegalArgumentException illegalArgumentException;
        String[] strArr2 = strArr;
        Bundle bundle2 = null;
        if (strArr2 != null) {
            if (strArr2.length % 2 != 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("extras must have an even number of elements");
                throw illegalArgumentException2;
            }
            int length = strArr2.length / 2;
            bundle2 = null;
            if (length != 0) {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle(length);
                bundle2 = bundle3;
                for (int i = 0; i < length; i++) {
                    bundle2.putString(strArr2[i * 2], strArr2[1 + (i * 2)]);
                }
            }
        }
        return bundle2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("tag=").append(this.tag).append(",");
        StringBuilder append2 = sb4.append("eventTime=").append(this.zzbdA).append(",");
        StringBuilder append3 = sb4.append("eventUptime=").append(this.zzbdB).append(",");
        if (this.zzbdD != null && !this.zzbdD.isEmpty()) {
            StringBuilder append4 = sb4.append("keyValues=");
            for (String str : this.zzbdD.keySet()) {
                StringBuilder append5 = sb4.append("(").append(str).append(",");
                StringBuilder append6 = sb4.append(this.zzbdD.getString(str)).append(")");
                StringBuilder append7 = sb4.append(" ");
            }
        }
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
