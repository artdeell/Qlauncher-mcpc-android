package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig implements SafeParcelable {
    public static final zza CREATOR;
    final int version;
    boolean zzYm;
    String zzYn;
    boolean zzYo;
    boolean zzYp;
    boolean zzYq;
    boolean zzYr;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = z;
        String str2 = str;
        boolean z7 = z2;
        boolean z8 = z3;
        boolean z9 = z4;
        boolean z10 = z5;
        this.version = i;
        this.zzYm = z6;
        this.zzYn = str2;
        this.zzYo = z7;
        this.zzYp = z8;
        this.zzYq = z9;
        this.zzYr = z10;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        boolean z = false;
        if (obj2 instanceof FACLConfig) {
            FACLConfig fACLConfig = (FACLConfig) obj2;
            z = false;
            if (this.zzYm == fACLConfig.zzYm) {
                z = false;
                if (TextUtils.equals(this.zzYn, fACLConfig.zzYn)) {
                    z = false;
                    if (this.zzYo == fACLConfig.zzYo) {
                        z = false;
                        if (this.zzYp == fACLConfig.zzYp) {
                            z = false;
                            if (this.zzYq == fACLConfig.zzYq) {
                                z = false;
                                if (this.zzYr == fACLConfig.zzYr) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzYm), this.zzYn, Boolean.valueOf(this.zzYo), Boolean.valueOf(this.zzYp), Boolean.valueOf(this.zzYq), Boolean.valueOf(this.zzYr));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
