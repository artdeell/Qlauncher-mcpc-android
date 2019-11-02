package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzf implements Creator<AdRequestInfoParcel> {
    public zzf() {
    }

    static void zza(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, adRequestInfoParcel2.versionCode);
        zzb.zza(parcel2, 2, adRequestInfoParcel2.zzHs, false);
        zzb.zza(parcel2, 3, (Parcelable) adRequestInfoParcel2.zzHt, i2, false);
        zzb.zza(parcel2, 4, (Parcelable) adRequestInfoParcel2.zzrp, i2, false);
        zzb.zza(parcel2, 5, adRequestInfoParcel2.zzrj, false);
        zzb.zza(parcel2, 6, (Parcelable) adRequestInfoParcel2.applicationInfo, i2, false);
        zzb.zza(parcel2, 7, (Parcelable) adRequestInfoParcel2.zzHu, i2, false);
        zzb.zza(parcel2, 8, adRequestInfoParcel2.zzHv, false);
        zzb.zza(parcel2, 9, adRequestInfoParcel2.zzHw, false);
        zzb.zza(parcel2, 10, adRequestInfoParcel2.zzHx, false);
        zzb.zza(parcel2, 11, (Parcelable) adRequestInfoParcel2.zzrl, i2, false);
        zzb.zza(parcel2, 12, adRequestInfoParcel2.zzHy, false);
        zzb.zzc(parcel2, 13, adRequestInfoParcel2.zzHz);
        zzb.zzb(parcel2, 14, adRequestInfoParcel2.zzrH, false);
        zzb.zza(parcel2, 15, adRequestInfoParcel2.zzHA, false);
        zzb.zza(parcel2, 17, (Parcelable) adRequestInfoParcel2.zzHC, i2, false);
        zzb.zza(parcel2, 16, adRequestInfoParcel2.zzHB);
        zzb.zzc(parcel2, 19, adRequestInfoParcel2.zzHE);
        zzb.zzc(parcel2, 18, adRequestInfoParcel2.zzHD);
        zzb.zza(parcel2, 21, adRequestInfoParcel2.zzHG, false);
        zzb.zza(parcel2, 20, adRequestInfoParcel2.zzHF);
        zzb.zza(parcel2, 25, adRequestInfoParcel2.zzHH);
        zzb.zzb(parcel2, 27, adRequestInfoParcel2.zzHJ, false);
        zzb.zza(parcel2, 26, adRequestInfoParcel2.zzHI, false);
        zzb.zza(parcel2, 29, (Parcelable) adRequestInfoParcel2.zzrD, i2, false);
        zzb.zza(parcel2, 28, adRequestInfoParcel2.zzri, false);
        zzb.zza(parcel2, 31, adRequestInfoParcel2.zzHL);
        zzb.zzb(parcel2, 30, adRequestInfoParcel2.zzHK, false);
        zzb.zza(parcel2, 34, adRequestInfoParcel2.zzHO);
        zzb.zzc(parcel2, 35, adRequestInfoParcel2.zzHP);
        zzb.zza(parcel2, 32, (Parcelable) adRequestInfoParcel2.zzHM, i2, false);
        zzb.zza(parcel2, 33, adRequestInfoParcel2.zzHN, false);
        zzb.zzc(parcel2, 36, adRequestInfoParcel2.zzHQ);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzG */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }

    /* renamed from: zzi */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        AdRequestInfoParcel adRequestInfoParcel;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        List list3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        float f2 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel2, zzat);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel2, zzat, (Creator<T>) AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) zza.zza(parcel2, zzat, (Creator<T>) AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel2, zzat, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel2, zzat, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 9:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel2, zzat, (Creator<T>) VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzr(parcel2, zzat);
                    break;
                case 13:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 14:
                    list = zza.zzD(parcel2, zzat);
                    break;
                case 15:
                    bundle3 = zza.zzr(parcel2, zzat);
                    break;
                case 16:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel2, zzat, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 19:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 20:
                    f = zza.zzl(parcel2, zzat);
                    break;
                case 21:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 25:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 26:
                    str6 = zza.zzp(parcel2, zzat);
                    break;
                case 27:
                    list2 = zza.zzD(parcel2, zzat);
                    break;
                case 28:
                    str7 = zza.zzp(parcel2, zzat);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) zza.zza(parcel2, zzat, (Creator<T>) NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    list3 = zza.zzD(parcel2, zzat);
                    break;
                case 31:
                    j2 = zza.zzi(parcel2, zzat);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) zza.zza(parcel2, zzat, CapabilityParcel.CREATOR);
                    break;
                case 33:
                    str8 = zza.zzp(parcel2, zzat);
                    break;
                case 34:
                    f2 = zza.zzl(parcel2, zzat);
                    break;
                case 35:
                    i5 = zza.zzg(parcel2, zzat);
                    break;
                case 36:
                    i6 = zza.zzg(parcel2, zzat);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        AdRequestInfoParcel adRequestInfoParcel3 = new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, nativeAdOptionsParcel, list3, j2, capabilityParcel, str8, f2, i5, i6);
        return adRequestInfoParcel2;
    }
}
