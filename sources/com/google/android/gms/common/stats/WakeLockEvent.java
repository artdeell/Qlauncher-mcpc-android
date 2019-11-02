package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR;
    private final long mTimeout;
    final int mVersionCode;
    private final String zzanQ;
    private final int zzanR;
    private final List<String> zzanS;
    private final String zzanT;
    private int zzanU;
    private final String zzanV;
    private final String zzanW;
    private final float zzanX;
    private final long zzane;
    private int zzanf;
    private final long zzanm;
    private long zzano;

    static {
        zzh zzh;
        zzh zzh2 = zzh;
        zzh zzh3 = new zzh();
        CREATOR = zzh2;
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        long j4 = j;
        int i5 = i2;
        String str5 = str;
        int i6 = i3;
        List<String> list2 = list;
        String str6 = str2;
        long j5 = j2;
        int i7 = i4;
        String str7 = str3;
        String str8 = str4;
        float f2 = f;
        long j6 = j3;
        this.mVersionCode = i;
        this.zzane = j4;
        this.zzanf = i5;
        this.zzanQ = str5;
        this.zzanV = str7;
        this.zzanR = i6;
        this.zzano = -1;
        this.zzanS = list2;
        this.zzanT = str6;
        this.zzanm = j5;
        this.zzanU = i7;
        this.zzanW = str8;
        this.zzanX = f2;
        this.mTimeout = j6;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.zzanf;
    }

    public long getTimeMillis() {
        return this.zzane;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String zzrK() {
        return this.zzanT;
    }

    public long zzrL() {
        return this.zzano;
    }

    public long zzrN() {
        return this.zzanm;
    }

    public String zzrO() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("\t").append(zzrR()).append("\t").append(zzrT()).append("\t").append(zzrU() == null ? LibrariesRepository.MOJANG_MAVEN_REPO : TextUtils.join(",", zzrU())).append("\t").append(zzrV()).append("\t").append(zzrS() == null ? LibrariesRepository.MOJANG_MAVEN_REPO : zzrS()).append("\t").append(zzrW() == null ? LibrariesRepository.MOJANG_MAVEN_REPO : zzrW()).append("\t").append(zzrX()).toString();
    }

    public String zzrR() {
        return this.zzanQ;
    }

    public String zzrS() {
        return this.zzanV;
    }

    public int zzrT() {
        return this.zzanR;
    }

    public List<String> zzrU() {
        return this.zzanS;
    }

    public int zzrV() {
        return this.zzanU;
    }

    public String zzrW() {
        return this.zzanW;
    }

    public float zzrX() {
        return this.zzanX;
    }

    public long zzrY() {
        return this.mTimeout;
    }
}
