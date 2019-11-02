package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzhb
public class zzif {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzBQ;
    public final List<String> zzBR;
    public final long zzBU;
    public final zzen zzCp;
    public final zzey zzCq;
    public final String zzCr;
    public final zzeq zzCs;
    public final zzjp zzED;
    public final long zzHS;
    public final boolean zzHT;
    public final long zzHU;
    public final List<String> zzHV;
    public final String zzHY;
    public final AdRequestParcel zzHt;
    public final String zzHw;
    @Nullable
    public final RewardItemParcel zzIj;
    @Nullable
    public final List<String> zzIl;
    public final boolean zzIm;
    public final JSONObject zzKT;
    public boolean zzKU;
    public final zzeo zzKV;
    public final AdSizeParcel zzKW;
    @Nullable
    public final List<String> zzKX;
    public final long zzKY;
    public final long zzKZ;
    public final com.google.android.gms.ads.internal.formats.zzh.zza zzLa;
    public boolean zzLb;
    public boolean zzLc;

    @zzhb
    public static final class zza {
        public final int errorCode;
        public final JSONObject zzKT;
        public final zzeo zzKV;
        public final long zzKY;
        public final long zzKZ;
        public final AdRequestInfoParcel zzLd;
        public final AdResponseParcel zzLe;
        public final AdSizeParcel zzrp;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzeo zzeo, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            AdResponseParcel adResponseParcel2 = adResponseParcel;
            zzeo zzeo2 = zzeo;
            AdSizeParcel adSizeParcel2 = adSizeParcel;
            int i2 = i;
            long j3 = j;
            long j4 = j2;
            JSONObject jSONObject2 = jSONObject;
            this.zzLd = adRequestInfoParcel;
            this.zzLe = adResponseParcel2;
            this.zzKV = zzeo2;
            this.zzrp = adSizeParcel2;
            this.errorCode = i2;
            this.zzKY = j3;
            this.zzKZ = j4;
            this.zzKT = jSONObject2;
        }
    }

    public zzif(AdRequestParcel adRequestParcel, zzjp zzjp, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzen zzen, zzey zzey, String str2, zzeo zzeo, zzeq zzeq, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.ads.internal.formats.zzh.zza zza2, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z2) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzjp zzjp2 = zzjp;
        List<String> list6 = list;
        int i3 = i;
        List<String> list7 = list2;
        List<String> list8 = list3;
        int i4 = i2;
        long j6 = j;
        String str4 = str;
        boolean z3 = z;
        zzen zzen2 = zzen;
        zzey zzey2 = zzey;
        String str5 = str2;
        zzeo zzeo2 = zzeo;
        zzeq zzeq2 = zzeq;
        long j7 = j2;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        long j8 = j3;
        long j9 = j4;
        long j10 = j5;
        String str6 = str3;
        JSONObject jSONObject2 = jSONObject;
        com.google.android.gms.ads.internal.formats.zzh.zza zza3 = zza2;
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        List<String> list9 = list4;
        List<String> list10 = list5;
        boolean z4 = z2;
        this.zzLb = false;
        this.zzLc = false;
        this.zzHt = adRequestParcel2;
        this.zzED = zzjp2;
        this.zzBQ = zzj(list6);
        this.errorCode = i3;
        this.zzBR = zzj(list7);
        this.zzHV = zzj(list8);
        this.orientation = i4;
        this.zzBU = j6;
        this.zzHw = str4;
        this.zzHT = z3;
        this.zzCp = zzen2;
        this.zzCq = zzey2;
        this.zzCr = str5;
        this.zzKV = zzeo2;
        this.zzCs = zzeq2;
        this.zzHU = j7;
        this.zzKW = adSizeParcel2;
        this.zzHS = j8;
        this.zzKY = j9;
        this.zzKZ = j10;
        this.zzHY = str6;
        this.zzKT = jSONObject2;
        this.zzLa = zza3;
        this.zzIj = rewardItemParcel2;
        this.zzKX = zzj(list9);
        this.zzIl = zzj(list10);
        this.zzIm = z4;
    }

    public zzif(zza zza2, zzjp zzjp, zzen zzen, zzey zzey, String str, zzeq zzeq, com.google.android.gms.ads.internal.formats.zzh.zza zza3) {
        zza zza4 = zza2;
        this(zza4.zzLd.zzHt, zzjp, zza4.zzLe.zzBQ, zza4.errorCode, zza4.zzLe.zzBR, zza4.zzLe.zzHV, zza4.zzLe.orientation, zza4.zzLe.zzBU, zza4.zzLd.zzHw, zza4.zzLe.zzHT, zzen, zzey, str, zza4.zzKV, zzeq, zza4.zzLe.zzHU, zza4.zzrp, zza4.zzLe.zzHS, zza4.zzKY, zza4.zzKZ, zza4.zzLe.zzHY, zza4.zzKT, zza3, zza4.zzLe.zzIj, zza4.zzLe.zzIk, zza4.zzLe.zzIk, zza4.zzLe.zzIm);
    }

    @Nullable
    private static <T> List<T> zzj(@Nullable List<T> list) {
        List<T> list2 = list;
        if (list2 == null) {
            return null;
        }
        return Collections.unmodifiableList(list2);
    }

    public boolean zzcv() {
        if (this.zzED == null || this.zzED.zzhU() == null) {
            return false;
        }
        return this.zzED.zzhU().zzcv();
    }
}
