package com.google.android.gms.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;

@zzhb
public class zzdv {
    private MutableContextWrapper zzAb;
    private final VersionInfoParcel zzpT;
    private final zzd zzpm;
    private final zzex zzpn;

    zzdv(Context context, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        MutableContextWrapper mutableContextWrapper;
        zzex zzex2 = zzex;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzd zzd2 = zzd;
        MutableContextWrapper mutableContextWrapper2 = mutableContextWrapper;
        MutableContextWrapper mutableContextWrapper3 = new MutableContextWrapper(context.getApplicationContext());
        this.zzAb = mutableContextWrapper2;
        this.zzpn = zzex2;
        this.zzpT = versionInfoParcel2;
        this.zzpm = zzd2;
    }

    public zzk zzX(String str) {
        zzk zzk;
        AdSizeParcel adSizeParcel;
        String str2 = str;
        zzk zzk2 = zzk;
        MutableContextWrapper mutableContextWrapper = this.zzAb;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel();
        zzk zzk3 = new zzk(mutableContextWrapper, adSizeParcel2, str2, this.zzpn, this.zzpT, this.zzpm);
        return zzk2;
    }

    public zzdv zzec() {
        zzdv zzdv;
        zzdv zzdv2 = zzdv;
        zzdv zzdv3 = new zzdv(this.zzAb.getBaseContext(), this.zzpn, this.zzpT, this.zzpm);
        return zzdv2;
    }

    public MutableContextWrapper zzed() {
        return this.zzAb;
    }
}
