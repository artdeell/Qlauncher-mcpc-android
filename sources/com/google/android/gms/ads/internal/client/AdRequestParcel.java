package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzhb;
import java.util.List;

@zzhb
public final class AdRequestParcel implements SafeParcelable {
    public static final zzg CREATOR;
    public final Bundle extras;
    public final int versionCode;
    public final long zztC;
    public final int zztD;
    public final List<String> zztE;
    public final boolean zztF;
    public final int zztG;
    public final boolean zztH;
    public final String zztI;
    public final SearchAdRequestParcel zztJ;
    public final Location zztK;
    public final String zztL;
    public final Bundle zztM;
    public final Bundle zztN;
    public final List<String> zztO;
    public final String zztP;
    public final String zztQ;
    public final boolean zztR;

    static {
        zzg zzg;
        zzg zzg2 = zzg;
        zzg zzg3 = new zzg();
        CREATOR = zzg2;
    }

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        Bundle bundle4;
        long j2 = j;
        Bundle bundle5 = bundle;
        int i4 = i2;
        List<String> list3 = list;
        boolean z4 = z;
        int i5 = i3;
        boolean z5 = z2;
        String str5 = str;
        SearchAdRequestParcel searchAdRequestParcel2 = searchAdRequestParcel;
        Location location2 = location;
        String str6 = str2;
        Bundle bundle6 = bundle2;
        Bundle bundle7 = bundle3;
        List<String> list4 = list2;
        String str7 = str3;
        String str8 = str4;
        boolean z6 = z3;
        this.versionCode = i;
        this.zztC = j2;
        if (bundle5 == null) {
            Bundle bundle8 = bundle4;
            Bundle bundle9 = new Bundle();
            bundle5 = bundle8;
        }
        this.extras = bundle5;
        this.zztD = i4;
        this.zztE = list3;
        this.zztF = z4;
        this.zztG = i5;
        this.zztH = z5;
        this.zztI = str5;
        this.zztJ = searchAdRequestParcel2;
        this.zztK = location2;
        this.zztL = str6;
        this.zztM = bundle6;
        this.zztN = bundle7;
        this.zztO = list4;
        this.zztP = str7;
        this.zztQ = str8;
        this.zztR = z6;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof AdRequestParcel) {
            AdRequestParcel adRequestParcel = (AdRequestParcel) obj2;
            if (this.versionCode == adRequestParcel.versionCode && this.zztC == adRequestParcel.zztC && zzw.equal(this.extras, adRequestParcel.extras) && this.zztD == adRequestParcel.zztD && zzw.equal(this.zztE, adRequestParcel.zztE) && this.zztF == adRequestParcel.zztF && this.zztG == adRequestParcel.zztG && this.zztH == adRequestParcel.zztH && zzw.equal(this.zztI, adRequestParcel.zztI) && zzw.equal(this.zztJ, adRequestParcel.zztJ) && zzw.equal(this.zztK, adRequestParcel.zztK) && zzw.equal(this.zztL, adRequestParcel.zztL) && zzw.equal(this.zztM, adRequestParcel.zztM) && zzw.equal(this.zztN, adRequestParcel.zztN) && zzw.equal(this.zztO, adRequestParcel.zztO) && zzw.equal(this.zztP, adRequestParcel.zztP) && zzw.equal(this.zztQ, adRequestParcel.zztQ) && this.zztR == adRequestParcel.zztR) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zztC), this.extras, Integer.valueOf(this.zztD), this.zztE, Boolean.valueOf(this.zztF), Integer.valueOf(this.zztG), Boolean.valueOf(this.zztH), this.zztI, this.zztJ, this.zztK, this.zztL, this.zztM, this.zztN, this.zztO, this.zztP, this.zztQ, Boolean.valueOf(this.zztR));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
