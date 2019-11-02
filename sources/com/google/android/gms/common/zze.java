package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0157R;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zzne;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzoM();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzafL = false;
    public static boolean zzafM = false;
    static int zzafN = -1;
    private static String zzafO = null;
    private static Integer zzafP = null;
    static final AtomicBoolean zzafQ;
    private static final AtomicBoolean zzafR;
    private static final Object zzqy;

    static {
        Object obj;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
        AtomicBoolean atomicBoolean3 = atomicBoolean;
        AtomicBoolean atomicBoolean4 = new AtomicBoolean();
        zzafQ = atomicBoolean3;
        AtomicBoolean atomicBoolean5 = atomicBoolean2;
        AtomicBoolean atomicBoolean6 = new AtomicBoolean();
        zzafR = atomicBoolean5;
    }

    zze() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzc.zzoK().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOpenSourceSoftwareLicenseInfo(android.content.Context r12) {
        /*
            r0 = r12
            android.net.Uri$Builder r8 = new android.net.Uri$Builder
            r11 = r8
            r8 = r11
            r9 = r11
            r9.<init>()
            java.lang.String r9 = "android.resource"
            android.net.Uri$Builder r8 = r8.scheme(r9)
            java.lang.String r9 = "com.google.android.gms"
            android.net.Uri$Builder r8 = r8.authority(r9)
            java.lang.String r9 = "raw"
            android.net.Uri$Builder r8 = r8.appendPath(r9)
            java.lang.String r9 = "oss_notice"
            android.net.Uri$Builder r8 = r8.appendPath(r9)
            android.net.Uri r8 = r8.build()
            r1 = r8
            r8 = r0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x0068 }
            r9 = r1
            java.io.InputStream r8 = r8.openInputStream(r9)     // Catch:{ Exception -> 0x0068 }
            r4 = r8
            java.util.Scanner r8 = new java.util.Scanner     // Catch:{ NoSuchElementException -> 0x0051, all -> 0x005d }
            r11 = r8
            r8 = r11
            r9 = r11
            r10 = r4
            r9.<init>(r10)     // Catch:{ NoSuchElementException -> 0x0051, all -> 0x005d }
            java.lang.String r9 = "\\A"
            java.util.Scanner r8 = r8.useDelimiter(r9)     // Catch:{ NoSuchElementException -> 0x0051, all -> 0x005d }
            java.lang.String r8 = r8.next()     // Catch:{ NoSuchElementException -> 0x0051, all -> 0x005d }
            r7 = r8
            r8 = r7
            r3 = r8
            r8 = r4
            if (r8 == 0) goto L_0x006c
            r8 = r4
            r8.close()     // Catch:{ Exception -> 0x0068 }
            r8 = r3
            r0 = r8
        L_0x0050:
            return r0
        L_0x0051:
            r8 = move-exception
            r6 = r8
            r8 = r4
            if (r8 == 0) goto L_0x005a
            r8 = r4
            r8.close()     // Catch:{ Exception -> 0x0068 }
        L_0x005a:
            r8 = 0
            r0 = r8
            goto L_0x0050
        L_0x005d:
            r8 = move-exception
            r5 = r8
            r8 = r4
            if (r8 == 0) goto L_0x0066
            r8 = r4
            r8.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0066:
            r8 = r5
            throw r8     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            r8 = move-exception
            r2 = r8
            r8 = 0
            r3 = r8
        L_0x006c:
            r8 = r3
            r0 = r8
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zze.getOpenSourceSoftwareLicenseInfo(android.content.Context):java.lang.String");
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        StringBuilder sb;
        Context context2 = context;
        if (zzd.zzakE) {
            return 0;
        }
        PackageManager packageManager = context2.getPackageManager();
        try {
            String string = context2.getResources().getString(C0157R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Throwable th2 = th;
            int e = Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context2.getPackageName())) {
            zzan(context2);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzf zzoO = zzf.zzoO();
            if (!zzmu.zzaw(context2)) {
                try {
                    zza zza = zzoO.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), C0887zzd.zzafK);
                    if (zza == null) {
                        int w = Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    zzf zzf = zzoO;
                    PackageInfo packageInfo2 = packageInfo;
                    zza[] zzaArr = new zza[1];
                    zza[] zzaArr2 = zzaArr;
                    zzaArr[0] = zza;
                    if (zzf.zza(packageInfo2, zzaArr2) == null) {
                        int w2 = Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    NameNotFoundException nameNotFoundException = e2;
                    int w3 = Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (zzoO.zza(packageInfo, C0887zzd.zzafK) == null) {
                int w4 = Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzmx.zzco(packageInfo.versionCode) < zzmx.zzco(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int w5 = Log.w("GooglePlayServicesUtil", sb2.append("Google Play services out of date.  Requires ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(packageInfo.versionCode).toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (NameNotFoundException e3) {
                    int wtf = Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e3);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e4) {
            NameNotFoundException nameNotFoundException2 = e4;
            int w6 = Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static void zzad(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        StringBuilder sb;
        GooglePlayServicesRepairableException googlePlayServicesRepairableException;
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException;
        Context context2 = context;
        int isGooglePlayServicesAvailable = zzc.zzoK().isGooglePlayServicesAvailable(context2);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zza = zzc.zzoK().zza(context2, isGooglePlayServicesAvailable, "e");
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e = Log.e("GooglePlayServicesUtil", sb2.append("GooglePlayServices not available due to error ").append(isGooglePlayServicesAvailable).toString());
            if (zza == null) {
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException2 = googlePlayServicesNotAvailableException;
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException3 = new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
                throw googlePlayServicesNotAvailableException2;
            }
            GooglePlayServicesRepairableException googlePlayServicesRepairableException2 = googlePlayServicesRepairableException;
            GooglePlayServicesRepairableException googlePlayServicesRepairableException3 = new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
            throw googlePlayServicesRepairableException2;
        }
    }

    @Deprecated
    public static int zzaj(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            int w = Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static void zzal(Context context) {
        Context context2 = context;
        if (!zzafQ.getAndSet(true)) {
            try {
                ((NotificationManager) context2.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
                SecurityException securityException = e;
            }
        }
    }

    private static void zzan(Context context) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Integer num;
        IllegalStateException illegalStateException;
        StringBuilder sb2;
        IllegalStateException illegalStateException2;
        Context context2 = context;
        if (!zzafR.get()) {
            Object obj = zzqy;
            synchronized (obj) {
                try {
                    if (zzafO == null) {
                        zzafO = context2.getPackageName();
                        Bundle bundle = context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            zzafP = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            zzafP = null;
                        }
                    } else if (!zzafO.equals(context2.getPackageName())) {
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        StringBuilder sb3 = sb;
                        StringBuilder sb4 = new StringBuilder();
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb3.append("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '").append(zzafO).append("' and this call used package '").append(context2.getPackageName()).append("'.").toString());
                        throw illegalArgumentException2;
                    }
                } catch (NameNotFoundException e) {
                    int wtf = Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
                num = zzafP;
            }
            if (num == null) {
                IllegalStateException illegalStateException3 = illegalStateException2;
                IllegalStateException illegalStateException4 = new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw illegalStateException3;
            } else if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                IllegalStateException illegalStateException5 = illegalStateException;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but").append(" found ").append(num).append(".  You must have the").append(" following declaration within the <application> element: ").append("    <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
                throw illegalStateException5;
            }
        }
    }

    public static String zzao(Context context) {
        ApplicationInfo applicationInfo;
        Context context2 = context;
        String str = context2.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context2.getPackageName();
            PackageManager packageManager = context2.getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context2.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                str = packageManager.getApplicationLabel(applicationInfo).toString();
            }
        }
        return str;
    }

    public static boolean zzap(Context context) {
        return zzne.zzsm() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    @TargetApi(18)
    public static boolean zzaq(Context context) {
        Context context2 = context;
        if (zzne.zzsj()) {
            Bundle applicationRestrictions = ((UserManager) context2.getSystemService("user")).getApplicationRestrictions(context2.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        boolean z;
        Context context2 = context;
        int i2 = i;
        String str2 = str;
        if (zzne.zzsk()) {
            try {
                ((AppOpsManager) context2.getSystemService("appops")).checkPackage(i2, str2);
                z = true;
            } catch (SecurityException e) {
                SecurityException securityException = e;
                return false;
            }
        } else {
            String[] packagesForUid = context2.getPackageManager().getPackagesForUid(i2);
            z = false;
            if (str2 != null) {
                z = false;
                if (packagesForUid != null) {
                    int i3 = 0;
                    while (true) {
                        z = false;
                        if (i3 >= packagesForUid.length) {
                            break;
                        } else if (str2.equals(packagesForUid[i3])) {
                            return true;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        return z;
    }

    public static boolean zzb(PackageManager packageManager) {
        PackageManager packageManager2 = packageManager;
        boolean z = true;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzafN == -1) {
                    PackageInfo packageInfo = packageManager2.getPackageInfo("com.google.android.gms", 64);
                    if (zzf.zzoO().zza(packageInfo, C0887zzd.zzafK[1]) != null) {
                        zzafN = 1;
                    } else {
                        zzafN = 0;
                    }
                }
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
                zzafN = 0;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
            if (zzafN == 0) {
                z = false;
            }
        }
        return z;
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return zzc.zzoK().zza(null, i, null);
    }

    static boolean zzbw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzoN();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        Context context2 = context;
        int i2 = i;
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return zzi(context2, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        Context context2 = context;
        if (i == 9) {
            return zzi(context2, GOOGLE_PLAY_STORE_PACKAGE);
        }
        return false;
    }

    public static boolean zzf(Context context, int i) {
        Context context2 = context;
        if (zzb(context2, i, "com.google.android.gms")) {
            try {
                return zzf.zzoO().zza(context2.getPackageManager(), context2.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
                if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                    int d = Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
                    return false;
                }
            }
        }
        return false;
    }

    @TargetApi(21)
    static boolean zzi(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        if (zzne.zzsm()) {
            for (SessionInfo appPackageName : context2.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str2.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzaq(context2)) {
            return false;
        }
        try {
            return context2.getPackageManager().getApplicationInfo(str2, 8192).enabled;
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            return false;
        }
    }

    private static int zzoM() {
        return 8487000;
    }

    public static boolean zzoN() {
        return zzafL ? zzafM : "user".equals(Build.TYPE);
    }
}
