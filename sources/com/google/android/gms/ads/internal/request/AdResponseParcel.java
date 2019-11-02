package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.List;

@zzhb
public final class AdResponseParcel implements SafeParcelable {
    public static final zzh CREATOR;
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final List<String> zzBQ;
    public final List<String> zzBR;
    public final long zzBU;
    private AdRequestInfoParcel zzCu;
    public final String zzEF;
    public final boolean zzHB;
    public final long zzHS;
    public final boolean zzHT;
    public final long zzHU;
    public final List<String> zzHV;
    public final String zzHW;
    public final long zzHX;
    public final String zzHY;
    public final boolean zzHZ;
    public final String zzIa;
    public final String zzIb;
    public final boolean zzIc;
    public final boolean zzId;
    public final boolean zzIe;
    public final int zzIf;
    public LargeParcelTeleporter zzIg;
    public String zzIh;
    public String zzIi;
    @Nullable
    public RewardItemParcel zzIj;
    @Nullable
    public List<String> zzIk;
    @Nullable
    public List<String> zzIl;
    @Nullable
    public boolean zzIm;
    public final boolean zzuk;
    public boolean zzul;
    public boolean zzum;

    static {
        zzh zzh;
        zzh zzh2 = zzh;
        zzh zzh3 = new zzh();
        CREATOR = zzh2;
    }

    public AdResponseParcel(int i) {
        this(16, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
    }

    public AdResponseParcel(int i, long j) {
        this(16, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10) {
        String str9 = str;
        String str10 = str2;
        List<String> list6 = list;
        int i5 = i2;
        List<String> list7 = list2;
        long j5 = j;
        boolean z11 = z;
        long j6 = j2;
        List<String> list8 = list3;
        long j7 = j3;
        int i6 = i3;
        String str11 = str3;
        long j8 = j4;
        String str12 = str4;
        boolean z12 = z2;
        String str13 = str5;
        String str14 = str6;
        boolean z13 = z3;
        boolean z14 = z4;
        boolean z15 = z5;
        boolean z16 = z6;
        boolean z17 = z7;
        int i7 = i4;
        LargeParcelTeleporter largeParcelTeleporter2 = largeParcelTeleporter;
        String str15 = str7;
        String str16 = str8;
        boolean z18 = z8;
        boolean z19 = z9;
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        List<String> list9 = list4;
        List<String> list10 = list5;
        boolean z20 = z10;
        this.versionCode = i;
        this.zzEF = str9;
        this.body = str10;
        this.zzBQ = list6 != null ? Collections.unmodifiableList(list6) : null;
        this.errorCode = i5;
        this.zzBR = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.zzHS = j5;
        this.zzHT = z11;
        this.zzHU = j6;
        this.zzHV = list8 != null ? Collections.unmodifiableList(list8) : null;
        this.zzBU = j7;
        this.orientation = i6;
        this.zzHW = str11;
        this.zzHX = j8;
        this.zzHY = str12;
        this.zzHZ = z12;
        this.zzIa = str13;
        this.zzIb = str14;
        this.zzIc = z13;
        this.zzuk = z14;
        this.zzHB = z15;
        this.zzId = z16;
        this.zzIe = z17;
        this.zzIf = i7;
        this.zzIg = largeParcelTeleporter2;
        this.zzIh = str15;
        this.zzIi = str16;
        if (this.body == null) {
            if (this.zzIg != null) {
                StringParcel stringParcel = (StringParcel) this.zzIg.zza(StringParcel.CREATOR);
                if (stringParcel != null && !TextUtils.isEmpty(stringParcel.zzgz())) {
                    this.body = stringParcel.zzgz();
                }
            }
        }
        this.zzul = z18;
        this.zzum = z19;
        this.zzIj = rewardItemParcel2;
        this.zzIk = list9;
        this.zzIl = list10;
        this.zzIm = z20;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z9) {
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        this(16, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, i2, null, null, str6, z7, z8, rewardItemParcel, list4, list5, z9);
        this.zzCu = adRequestInfoParcel2;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10) {
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        this(16, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i2, null, null, str7, z8, z9, rewardItemParcel, list4, list5, z10);
        this.zzCu = adRequestInfoParcel2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        LargeParcelTeleporter largeParcelTeleporter;
        StringParcel stringParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        if (this.zzCu != null && this.zzCu.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            LargeParcelTeleporter largeParcelTeleporter2 = largeParcelTeleporter;
            StringParcel stringParcel2 = stringParcel;
            StringParcel stringParcel3 = new StringParcel(this.body);
            LargeParcelTeleporter largeParcelTeleporter3 = new LargeParcelTeleporter(stringParcel2);
            this.zzIg = largeParcelTeleporter2;
            this.body = null;
        }
        zzh.zza(this, parcel2, i2);
    }
}
