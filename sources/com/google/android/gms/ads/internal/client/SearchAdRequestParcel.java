package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final zzam CREATOR;
    public final int backgroundColor;
    public final int versionCode;
    public final int zzvd;
    public final int zzve;
    public final int zzvf;
    public final int zzvg;
    public final int zzvh;
    public final int zzvi;
    public final int zzvj;
    public final String zzvk;
    public final int zzvl;
    public final String zzvm;
    public final int zzvn;
    public final int zzvo;
    public final String zzvp;

    static {
        zzam zzam;
        zzam zzam2 = zzam;
        zzam zzam3 = new zzam();
        CREATOR = zzam2;
    }

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        String str4 = str;
        int i21 = i10;
        String str5 = str2;
        int i22 = i11;
        int i23 = i12;
        String str6 = str3;
        this.versionCode = i;
        this.zzvd = i13;
        this.backgroundColor = i14;
        this.zzve = i15;
        this.zzvf = i16;
        this.zzvg = i17;
        this.zzvh = i18;
        this.zzvi = i19;
        this.zzvj = i20;
        this.zzvk = str4;
        this.zzvl = i21;
        this.zzvm = str5;
        this.zzvn = i22;
        this.zzvo = i23;
        this.zzvp = str6;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        SearchAdRequest searchAdRequest2 = searchAdRequest;
        this.versionCode = 1;
        this.zzvd = searchAdRequest2.getAnchorTextColor();
        this.backgroundColor = searchAdRequest2.getBackgroundColor();
        this.zzve = searchAdRequest2.getBackgroundGradientBottom();
        this.zzvf = searchAdRequest2.getBackgroundGradientTop();
        this.zzvg = searchAdRequest2.getBorderColor();
        this.zzvh = searchAdRequest2.getBorderThickness();
        this.zzvi = searchAdRequest2.getBorderType();
        this.zzvj = searchAdRequest2.getCallButtonColor();
        this.zzvk = searchAdRequest2.getCustomChannels();
        this.zzvl = searchAdRequest2.getDescriptionTextColor();
        this.zzvm = searchAdRequest2.getFontFace();
        this.zzvn = searchAdRequest2.getHeaderTextColor();
        this.zzvo = searchAdRequest2.getHeaderTextSize();
        this.zzvp = searchAdRequest2.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzam.zza(this, parcel, i);
    }
}
