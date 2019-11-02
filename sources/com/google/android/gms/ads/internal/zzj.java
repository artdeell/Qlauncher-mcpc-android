package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzj extends zza {
    private final Context mContext;
    private zzq zzpK;
    private NativeAdOptionsParcel zzpP;
    private zzx zzpR;
    private final String zzpS;
    private final VersionInfoParcel zzpT;
    private zzcr zzpY;
    private zzcs zzpZ;
    private final zzd zzpm;
    private final zzex zzpn;
    private SimpleArrayMap<String, zzct> zzqa;
    private SimpleArrayMap<String, zzcu> zzqb;

    public zzj(Context context, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        SimpleArrayMap<String, zzcu> simpleArrayMap;
        SimpleArrayMap<String, zzct> simpleArrayMap2;
        String str2 = str;
        zzex zzex2 = zzex;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzd zzd2 = zzd;
        this.mContext = context;
        this.zzpS = str2;
        this.zzpn = zzex2;
        this.zzpT = versionInfoParcel2;
        SimpleArrayMap<String, zzcu> simpleArrayMap3 = simpleArrayMap;
        SimpleArrayMap<String, zzcu> simpleArrayMap4 = new SimpleArrayMap<>();
        this.zzqb = simpleArrayMap3;
        SimpleArrayMap<String, zzct> simpleArrayMap5 = simpleArrayMap2;
        SimpleArrayMap<String, zzct> simpleArrayMap6 = new SimpleArrayMap<>();
        this.zzqa = simpleArrayMap5;
        this.zzpm = zzd2;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        this.zzpP = nativeAdOptionsParcel2;
    }

    public void zza(zzcr zzcr) {
        zzcr zzcr2 = zzcr;
        this.zzpY = zzcr2;
    }

    public void zza(zzcs zzcs) {
        zzcs zzcs2 = zzcs;
        this.zzpZ = zzcs2;
    }

    public void zza(String str, zzcu zzcu, zzct zzct) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        zzcu zzcu2 = zzcu;
        zzct zzct2 = zzct;
        if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
            throw illegalArgumentException2;
        }
        Object put = this.zzqb.put(str2, zzcu2);
        Object put2 = this.zzqa.put(str2, zzct2);
    }

    public void zzb(zzq zzq) {
        zzq zzq2 = zzq;
        this.zzpK = zzq2;
    }

    public void zzb(zzx zzx) {
        zzx zzx2 = zzx;
        this.zzpR = zzx2;
    }

    public zzr zzbn() {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi(this.mContext, this.zzpS, this.zzpn, this.zzpT, this.zzpK, this.zzpY, this.zzpZ, this.zzqb, this.zzqa, this.zzpP, this.zzpR, this.zzpm);
        return zzi2;
    }
}
