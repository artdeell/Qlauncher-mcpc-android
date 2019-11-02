package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb.C0878zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzsz.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final zzd CREATOR;
    public final int versionCode;
    public PlayLoggerContext zzafh;
    public byte[] zzafi;
    public int[] zzafj;
    public final zzd zzafk;
    public final C0878zzb zzafl;
    public final C0878zzb zzafm;

    static {
        zzd zzd;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd();
        CREATOR = zzd2;
    }

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        byte[] bArr2 = bArr;
        int[] iArr2 = iArr;
        this.versionCode = i;
        this.zzafh = playLoggerContext2;
        this.zzafi = bArr2;
        this.zzafj = iArr2;
        this.zzafk = null;
        this.zzafl = null;
        this.zzafm = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzd zzd, C0878zzb zzb, C0878zzb zzb2, int[] iArr) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        zzd zzd2 = zzd;
        C0878zzb zzb3 = zzb;
        C0878zzb zzb4 = zzb2;
        int[] iArr2 = iArr;
        this.versionCode = 1;
        this.zzafh = playLoggerContext2;
        this.zzafk = zzd2;
        this.zzafl = zzb3;
        this.zzafm = zzb4;
        this.zzafj = iArr2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof LogEventParcelable)) {
                return false;
            }
            LogEventParcelable logEventParcelable = (LogEventParcelable) obj2;
            if (this.versionCode != logEventParcelable.versionCode || !zzw.equal(this.zzafh, logEventParcelable.zzafh) || !Arrays.equals(this.zzafi, logEventParcelable.zzafi) || !Arrays.equals(this.zzafj, logEventParcelable.zzafj) || !zzw.equal(this.zzafk, logEventParcelable.zzafk) || !zzw.equal(this.zzafl, logEventParcelable.zzafl) || !zzw.equal(this.zzafm, logEventParcelable.zzafm)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.zzafh, this.zzafi, this.zzafj, this.zzafk, this.zzafl, this.zzafm);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        String str2;
        String zza;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder("LogEventParcelable[");
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.versionCode);
        StringBuilder append2 = sb4.append(", ");
        StringBuilder append3 = sb4.append(this.zzafh);
        StringBuilder append4 = sb4.append(", ");
        if (this.zzafi == null) {
            str2 = null;
        } else {
            String str3 = str;
            String str4 = new String(this.zzafi);
            str2 = str3;
        }
        StringBuilder append5 = sb4.append(str2);
        StringBuilder append6 = sb4.append(", ");
        if (this.zzafj == null) {
            zza = null;
        } else {
            zza = zzv.zzcL(", ").zza(Arrays.asList(new int[][]{this.zzafj}));
        }
        StringBuilder append7 = sb4.append(zza);
        StringBuilder append8 = sb4.append(", ");
        StringBuilder append9 = sb4.append(this.zzafk);
        StringBuilder append10 = sb4.append(", ");
        StringBuilder append11 = sb4.append(this.zzafl);
        StringBuilder append12 = sb4.append(", ");
        StringBuilder append13 = sb4.append(this.zzafm);
        StringBuilder append14 = sb4.append("]");
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
