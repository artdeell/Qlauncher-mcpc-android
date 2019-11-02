package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;

@zzhb
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzit zza(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        C01871 r11;
        Context context2 = context;
        Context context3 = context2;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzji<AdRequestInfoParcel> zzji2 = zzji;
        zza zza3 = zza2;
        C01871 r8 = r11;
        final Context context4 = context2;
        C01871 r9 = new zzb() {
            public boolean zza(VersionInfoParcel versionInfoParcel) {
                return versionInfoParcel.zzNb || (zze.zzap(context4) && !((Boolean) zzbt.zzwb.get()).booleanValue());
            }
        };
        return zza(context3, versionInfoParcel2, zzji2, zza3, r8);
    }

    static zzit zza(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2, zzb zzb2) {
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzji<AdRequestInfoParcel> zzji2 = zzji;
        zza zza3 = zza2;
        return zzb2.zza(versionInfoParcel2) ? zza(context2, zzji2, zza3) : zzb(context2, versionInfoParcel2, zzji2, zza3);
    }

    private static zzit zza(Context context, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        com.google.android.gms.ads.internal.request.zzd.zza zza3;
        Context context2 = context;
        zzji<AdRequestInfoParcel> zzji2 = zzji;
        zza zza4 = zza2;
        zzin.zzaI("Fetching ad response from local ad request service.");
        com.google.android.gms.ads.internal.request.zzd.zza zza5 = zza3;
        com.google.android.gms.ads.internal.request.zzd.zza zza6 = new com.google.android.gms.ads.internal.request.zzd.zza(context2, zzji2, zza4);
        com.google.android.gms.ads.internal.request.zzd.zza zza7 = zza5;
        Void zzga = zza7.zzgd();
        return zza7;
    }

    private static zzit zzb(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        com.google.android.gms.ads.internal.request.zzd.zzb zzb2;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzji<AdRequestInfoParcel> zzji2 = zzji;
        zza zza3 = zza2;
        zzin.zzaI("Fetching ad response from remote ad request service.");
        if (!zzn.zzcS().zzU(context2)) {
            zzin.zzaK("Failed to connect to remote ad request service.");
            return null;
        }
        com.google.android.gms.ads.internal.request.zzd.zzb zzb3 = zzb2;
        com.google.android.gms.ads.internal.request.zzd.zzb zzb4 = new com.google.android.gms.ads.internal.request.zzd.zzb(context2, versionInfoParcel2, zzji2, zza3);
        return zzb3;
    }
}
