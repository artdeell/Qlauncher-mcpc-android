package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzn;

public class zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zzc zzafF;

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        zzafF = zzc2;
    }

    zzc() {
    }

    private String zzj(@Nullable Context context, @Nullable String str) {
        StringBuilder sb;
        Context context2 = context;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("gcore_");
        StringBuilder append2 = sb4.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        StringBuilder append3 = sb4.append("-");
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder append4 = sb4.append(str2);
        }
        StringBuilder append5 = sb4.append("-");
        if (context2 != null) {
            StringBuilder append6 = sb4.append(context2.getPackageName());
        }
        StringBuilder append7 = sb4.append("-");
        if (context2 != null) {
            try {
                StringBuilder append8 = sb4.append(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
            }
        }
        return sb4.toString();
    }

    public static zzc zzoK() {
        return zzafF;
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, null);
    }

    public String getErrorString(int i) {
        return zze.getErrorString(i);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        Context context2 = context;
        int isGooglePlayServicesAvailable = zze.isGooglePlayServicesAvailable(context2);
        if (zze.zzd(context2, isGooglePlayServicesAvailable)) {
            isGooglePlayServicesAvailable = 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zze.isUserRecoverableError(i);
    }

    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        Context context2 = context;
        int i3 = i2;
        Intent zza = zza(context2, i, str);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context2, i3, zza, 268435456);
    }

    @Nullable
    public Intent zza(Context context, int i, @Nullable String str) {
        Context context2 = context;
        String str2 = str;
        switch (i) {
            case 1:
            case 2:
                return zzn.zzx("com.google.android.gms", zzj(context2, str2));
            case 3:
                return zzn.zzcJ("com.google.android.gms");
            case 42:
                return zzn.zzqU();
            default:
                return null;
        }
    }

    public int zzaj(Context context) {
        return zze.zzaj(context);
    }

    public void zzak(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zze.zzad(context);
    }

    public void zzal(Context context) {
        zze.zzal(context);
    }

    @Nullable
    @Deprecated
    public Intent zzbu(int i) {
        return zza(null, i, null);
    }

    public boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    public boolean zzi(Context context, String str) {
        return zze.zzi(context, str);
    }
}
