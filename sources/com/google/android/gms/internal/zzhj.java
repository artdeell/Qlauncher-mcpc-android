package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.zze;
import java.util.Locale;

@zzhb
public final class zzhj {
    public final int zzHD;
    public final int zzHE;
    public final float zzHF;
    public final int zzJQ;
    public final boolean zzJR;
    public final boolean zzJS;
    public final String zzJT;
    public final String zzJU;
    public final boolean zzJV;
    public final boolean zzJW;
    public final boolean zzJX;
    public final boolean zzJY;
    public final String zzJZ;
    public final String zzKa;
    public final int zzKb;
    public final int zzKc;
    public final int zzKd;
    public final int zzKe;
    public final int zzKf;
    public final int zzKg;
    public final double zzKh;
    public final boolean zzKi;
    public final boolean zzKj;
    public final int zzKk;
    public final String zzKl;

    public static final class zza {
        private int zzHD;
        private int zzHE;
        private float zzHF;
        private int zzJQ;
        private boolean zzJR;
        private boolean zzJS;
        private String zzJT;
        private String zzJU;
        private boolean zzJV;
        private boolean zzJW;
        private boolean zzJX;
        private boolean zzJY;
        private String zzJZ;
        private String zzKa;
        private int zzKb;
        private int zzKc;
        private int zzKd;
        private int zzKe;
        private int zzKf;
        private int zzKg;
        private double zzKh;
        private boolean zzKi;
        private boolean zzKj;
        private int zzKk;
        private String zzKl;

        public zza(Context context) {
            Context context2 = context;
            boolean z = true;
            PackageManager packageManager = context2.getPackageManager();
            zzB(context2);
            zza(context2, packageManager);
            zzC(context2);
            Locale locale = Locale.getDefault();
            this.zzJR = zza(packageManager, "geo:0,0?q=donuts") != null;
            if (zza(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.zzJS = z;
            this.zzJU = locale.getCountry();
            this.zzJV = zzn.zzcS().zzhI();
            this.zzJW = zze.zzap(context2);
            this.zzJZ = locale.getLanguage();
            this.zzKa = zza(packageManager);
            Resources resources = context2.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.zzHF = displayMetrics.density;
                    this.zzHD = displayMetrics.widthPixels;
                    this.zzHE = displayMetrics.heightPixels;
                }
            }
        }

        public zza(Context context, zzhj zzhj) {
            Context context2 = context;
            zzhj zzhj2 = zzhj;
            PackageManager packageManager = context2.getPackageManager();
            zzB(context2);
            zza(context2, packageManager);
            zzC(context2);
            zzD(context2);
            this.zzJR = zzhj2.zzJR;
            this.zzJS = zzhj2.zzJS;
            this.zzJU = zzhj2.zzJU;
            this.zzJV = zzhj2.zzJV;
            this.zzJW = zzhj2.zzJW;
            this.zzJZ = zzhj2.zzJZ;
            this.zzKa = zzhj2.zzKa;
            this.zzHF = zzhj2.zzHF;
            this.zzHD = zzhj2.zzHD;
            this.zzHE = zzhj2.zzHE;
        }

        private void zzB(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.zzJQ = audioManager.getMode();
            this.zzJX = audioManager.isMusicActive();
            this.zzJY = audioManager.isSpeakerphoneOn();
            this.zzKb = audioManager.getStreamVolume(3);
            this.zzKf = audioManager.getRingerMode();
            this.zzKg = audioManager.getStreamVolume(2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0042, code lost:
            if (r3 == 5) goto L_0x0044;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void zzC(android.content.Context r14) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r7 = r1
                r8 = 0
                android.content.IntentFilter r9 = new android.content.IntentFilter
                r12 = r9
                r9 = r12
                r10 = r12
                java.lang.String r11 = "android.intent.action.BATTERY_CHANGED"
                r10.<init>(r11)
                android.content.Intent r7 = r7.registerReceiver(r8, r9)
                r2 = r7
                r7 = r2
                if (r7 == 0) goto L_0x004b
                r7 = r2
                java.lang.String r8 = "status"
                r9 = -1
                int r7 = r7.getIntExtra(r8, r9)
                r3 = r7
                r7 = r2
                java.lang.String r8 = "level"
                r9 = -1
                int r7 = r7.getIntExtra(r8, r9)
                r4 = r7
                r7 = r2
                java.lang.String r8 = "scale"
                r9 = -1
                int r7 = r7.getIntExtra(r8, r9)
                r5 = r7
                r7 = r0
                r8 = r4
                float r8 = (float) r8
                r9 = r5
                float r9 = (float) r9
                float r8 = r8 / r9
                double r8 = (double) r8
                r7.zzKh = r8
                r7 = r3
                r8 = 2
                if (r7 == r8) goto L_0x0044
                r7 = 0
                r6 = r7
                r7 = r3
                r8 = 5
                if (r7 != r8) goto L_0x0046
            L_0x0044:
                r7 = 1
                r6 = r7
            L_0x0046:
                r7 = r0
                r8 = r6
                r7.zzKi = r8
            L_0x004a:
                return
            L_0x004b:
                r7 = r0
                r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
                r7.zzKh = r8
                r7 = r0
                r8 = 0
                r7.zzKi = r8
                goto L_0x004a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhj.zza.zzC(android.content.Context):void");
        }

        private void zzD(Context context) {
            Context context2 = context;
            this.zzKl = Build.FINGERPRINT;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            Intent intent;
            PackageManager packageManager2 = packageManager;
            Intent intent2 = intent;
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            return packageManager2.resolveActivity(intent2, 65536);
        }

        private static String zza(PackageManager packageManager) {
            StringBuilder sb;
            PackageManager packageManager2 = packageManager;
            ResolveInfo zza = zza(packageManager2, "market://details?id=com.google.android.gms.ads");
            if (zza != null) {
                ActivityInfo activityInfo = zza.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager2.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            return sb2.append(packageInfo.versionCode).append(".").append(activityInfo.packageName).toString();
                        }
                    } catch (NameNotFoundException e) {
                        NameNotFoundException nameNotFoundException = e;
                        return null;
                    }
                }
            }
            return null;
        }

        @TargetApi(16)
        private void zza(Context context, PackageManager packageManager) {
            Context context2 = context;
            PackageManager packageManager2 = packageManager;
            TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            this.zzJT = telephonyManager.getNetworkOperator();
            this.zzKd = telephonyManager.getNetworkType();
            this.zzKe = telephonyManager.getPhoneType();
            this.zzKc = -2;
            this.zzKj = false;
            this.zzKk = -1;
            if (zzr.zzbC().zza(packageManager2, context2.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzKc = activeNetworkInfo.getType();
                    this.zzKk = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzKc = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.zzKj = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        public zzhj zzgI() {
            zzhj zzhj;
            zzhj zzhj2 = zzhj;
            zzhj zzhj3 = new zzhj(this.zzJQ, this.zzJR, this.zzJS, this.zzJT, this.zzJU, this.zzJV, this.zzJW, this.zzJX, this.zzJY, this.zzJZ, this.zzKa, this.zzKb, this.zzKc, this.zzKd, this.zzKe, this.zzKf, this.zzKg, this.zzHF, this.zzHD, this.zzHE, this.zzKh, this.zzKi, this.zzKj, this.zzKk, this.zzKl);
            return zzhj2;
        }
    }

    zzhj(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5) {
        boolean z9 = z;
        boolean z10 = z2;
        String str6 = str;
        String str7 = str2;
        boolean z11 = z3;
        boolean z12 = z4;
        boolean z13 = z5;
        boolean z14 = z6;
        String str8 = str3;
        String str9 = str4;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        float f2 = f;
        int i17 = i8;
        int i18 = i9;
        double d2 = d;
        boolean z15 = z7;
        boolean z16 = z8;
        int i19 = i10;
        String str10 = str5;
        this.zzJQ = i;
        this.zzJR = z9;
        this.zzJS = z10;
        this.zzJT = str6;
        this.zzJU = str7;
        this.zzJV = z11;
        this.zzJW = z12;
        this.zzJX = z13;
        this.zzJY = z14;
        this.zzJZ = str8;
        this.zzKa = str9;
        this.zzKb = i11;
        this.zzKc = i12;
        this.zzKd = i13;
        this.zzKe = i14;
        this.zzKf = i15;
        this.zzKg = i16;
        this.zzHF = f2;
        this.zzHD = i17;
        this.zzHE = i18;
        this.zzKh = d2;
        this.zzKi = z15;
        this.zzKj = z16;
        this.zzKk = i19;
        this.zzKl = str10;
    }
}
