package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR;
    final int mVersionCode;
    private final long zzane;
    private int zzanf;
    private final String zzang;
    private final String zzanh;
    private final String zzani;
    private final String zzanj;
    private final String zzank;
    private final String zzanl;
    private final long zzanm;
    private final long zzann;
    private long zzano;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        long j4 = j;
        int i3 = i2;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        long j5 = j2;
        long j6 = j3;
        this.mVersionCode = i;
        this.zzane = j4;
        this.zzanf = i3;
        this.zzang = str7;
        this.zzanh = str8;
        this.zzani = str9;
        this.zzanj = str10;
        this.zzano = -1;
        this.zzank = str11;
        this.zzanl = str12;
        this.zzanm = j5;
        this.zzann = j6;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
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
        zza.zza(this, parcel, i);
    }

    public String zzrF() {
        return this.zzang;
    }

    public String zzrG() {
        return this.zzanh;
    }

    public String zzrH() {
        return this.zzani;
    }

    public String zzrI() {
        return this.zzanj;
    }

    public String zzrJ() {
        return this.zzank;
    }

    public String zzrK() {
        return this.zzanl;
    }

    public long zzrL() {
        return this.zzano;
    }

    public long zzrM() {
        return this.zzann;
    }

    public long zzrN() {
        return this.zzanm;
    }

    public String zzrO() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("\t").append(zzrF()).append("/").append(zzrG()).append("\t").append(zzrH()).append("/").append(zzrI()).append("\t").append(this.zzank == null ? LibrariesRepository.MOJANG_MAVEN_REPO : this.zzank).append("\t").append(zzrM()).toString();
    }
}
