package com.google.android.gms.internal;

import android.text.TextUtils;

@zzhb
public class zzbw {
    public zzbw() {
    }

    public zzbv zza(zzbu zzbu) {
        zzbv zzbv;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        zzbu zzbu2 = zzbu;
        if (zzbu2 == null) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("CSI configuration can't be null. ");
            throw illegalArgumentException4;
        } else if (!zzbu2.zzdu()) {
            zzin.m20v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzbu2.getContext() == null) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
            throw illegalArgumentException6;
        } else if (TextUtils.isEmpty(zzbu2.zzcs())) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
            throw illegalArgumentException8;
        } else {
            zzbv zzbv2 = zzbv;
            zzbv zzbv3 = new zzbv(zzbu2.getContext(), zzbu2.zzcs(), zzbu2.zzdv(), zzbu2.zzdw());
            return zzbv2;
        }
    }
}
