package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR;
    final int mVersion;
    final long zzUZ;
    final String zzVa;
    final int zzVb;
    final int zzVc;
    final String zzVd;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        long j2 = j;
        String str3 = str;
        int i4 = i2;
        int i5 = i3;
        String str4 = str2;
        this.mVersion = i;
        this.zzUZ = j2;
        this.zzVa = (String) zzx.zzz(str3);
        this.zzVb = i4;
        this.zzVc = i5;
        this.zzVd = str4;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        long j2 = j;
        String str3 = str;
        int i3 = i;
        int i4 = i2;
        String str4 = str2;
        this.mVersion = 1;
        this.zzUZ = j2;
        this.zzVa = (String) zzx.zzz(str3);
        this.zzVb = i3;
        this.zzVc = i4;
        this.zzVd = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof AccountChangeEvent)) {
                return false;
            }
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj2;
            if (!(this.mVersion == accountChangeEvent.mVersion && this.zzUZ == accountChangeEvent.zzUZ && zzw.equal(this.zzVa, accountChangeEvent.zzVa) && this.zzVb == accountChangeEvent.zzVb && this.zzVc == accountChangeEvent.zzVc && zzw.equal(this.zzVd, accountChangeEvent.zzVd))) {
                return false;
            }
        }
        return true;
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public String getChangeData() {
        return this.zzVd;
    }

    public int getChangeType() {
        return this.zzVb;
    }

    public int getEventIndex() {
        return this.zzVc;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzUZ), this.zzVa, Integer.valueOf(this.zzVb), Integer.valueOf(this.zzVc), this.zzVd);
    }

    public String toString() {
        StringBuilder sb;
        String str = "UNKNOWN";
        switch (this.zzVb) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("AccountChangeEvent {accountName = ").append(this.zzVa).append(", changeType = ").append(str).append(", changeData = ").append(this.zzVd).append(", eventIndex = ").append(this.zzVc).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
