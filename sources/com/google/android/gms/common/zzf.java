package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

public class zzf {
    private static final zzf zzafS;

    static {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf();
        zzafS = zzf2;
    }

    private zzf() {
    }

    public static zzf zzoO() {
        return zzafS;
    }

    /* access modifiers changed from: 0000 */
    public zza zza(PackageInfo packageInfo, zza... zzaArr) {
        zzb zzb;
        StringBuilder sb;
        PackageInfo packageInfo2 = packageInfo;
        zza[] zzaArr2 = zzaArr;
        if (packageInfo2.signatures.length != 1) {
            int w = Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb(packageInfo2.signatures[0].toByteArray());
        zzb zzb4 = zzb2;
        for (int i = 0; i < zzaArr2.length; i++) {
            if (zzaArr2[i].equals(zzb4)) {
                return zzaArr2[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v("GoogleSignatureVerifier", sb2.append("Signature not valid.  Found: \n").append(Base64.encodeToString(zzb4.getBytes(), 0)).toString());
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        zza zza;
        PackageInfo packageInfo2 = packageInfo;
        boolean z2 = z;
        if (!(packageInfo2 == null || packageInfo2.signatures == null)) {
            if (z2) {
                zza = zza(packageInfo2, C0887zzd.zzafK);
            } else {
                zza = zza(packageInfo2, C0887zzd.zzafK[0]);
            }
            if (zza != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        PackageManager packageManager2 = packageManager;
        PackageInfo packageInfo2 = packageInfo;
        boolean z = false;
        if (packageInfo2 != null) {
            if (zze.zzc(packageManager2)) {
                return zza(packageInfo2, true);
            }
            z = zza(packageInfo2, false);
            if (!z && zza(packageInfo2, true)) {
                int w = Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                return z;
            }
        }
        return z;
    }
}
