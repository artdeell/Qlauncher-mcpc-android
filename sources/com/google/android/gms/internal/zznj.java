package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class zznj {
    private static final Method zzaol = zzsp();
    private static final Method zzaom = zzsq();
    private static final Method zzaon = zzsr();
    private static final Method zzaoo = zzss();
    private static final Method zzaop = zzst();

    public static int zza(WorkSource workSource) {
        WorkSource workSource2 = workSource;
        if (zzaon != null) {
            try {
                return ((Integer) zzaon.invoke(workSource2, new Object[0])).intValue();
            } catch (Exception e) {
                int wtf = Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        WorkSource workSource2 = workSource;
        int i2 = i;
        if (zzaop != null) {
            try {
                return (String) zzaop.invoke(workSource2, new Object[]{Integer.valueOf(i2)});
            } catch (Exception e) {
                int wtf = Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        WorkSource workSource2 = workSource;
        int i2 = i;
        String str2 = str;
        if (zzaom != null) {
            if (str2 == null) {
                str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
            }
            try {
                Object invoke = zzaom.invoke(workSource2, new Object[]{Integer.valueOf(i2), str2});
            } catch (Exception e) {
                int wtf = Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (zzaol != null) {
            try {
                Object invoke2 = zzaol.invoke(workSource2, new Object[]{Integer.valueOf(i2)});
            } catch (Exception e2) {
                int wtf2 = Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean zzaA(Context context) {
        Context context2 = context;
        if (context2 != null) {
            PackageManager packageManager = context2.getPackageManager();
            if (packageManager != null && packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context2.getPackageName()) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r5v15, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> zzb(android.os.WorkSource r8) {
        /*
            r0 = r8
            r5 = 0
            r1 = r5
            r5 = r0
            if (r5 != 0) goto L_0x0011
            r5 = 0
            r2 = r5
        L_0x0008:
            r5 = r2
            if (r5 != 0) goto L_0x0018
            java.util.List r5 = java.util.Collections.EMPTY_LIST
            r3 = r5
        L_0x000e:
            r5 = r3
            r0 = r5
            return r0
        L_0x0011:
            r5 = r0
            int r5 = zza(r5)
            r2 = r5
            goto L_0x0008
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r7 = r5
            r5 = r7
            r6 = r7
            r6.<init>()
            r3 = r5
        L_0x0021:
            r5 = r1
            r6 = r2
            if (r5 >= r6) goto L_0x000e
            r5 = r0
            r6 = r1
            java.lang.String r5 = zza(r5, r6)
            r4 = r5
            r5 = r4
            boolean r5 = com.google.android.gms.internal.zzni.zzcV(r5)
            if (r5 != 0) goto L_0x0039
            r5 = r3
            r6 = r4
            boolean r5 = r5.add(r6)
        L_0x0039:
            int r1 = r1 + 1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznj.zzb(android.os.WorkSource):java.util.List");
    }

    public static WorkSource zzf(int i, String str) {
        WorkSource workSource;
        int i2 = i;
        String str2 = str;
        WorkSource workSource2 = workSource;
        WorkSource workSource3 = new WorkSource();
        WorkSource workSource4 = workSource2;
        zza(workSource4, i2, str2);
        return workSource4;
    }

    public static WorkSource zzl(Context context, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        Context context2 = context;
        String str2 = str;
        if (context2 == null || context2.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context2.getPackageManager().getApplicationInfo(str2, 0);
            if (applicationInfo != null) {
                return zzf(applicationInfo.uid, str2);
            }
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int e = Log.e("WorkSourceUtil", sb3.append("Could not get applicationInfo from package: ").append(str2).toString());
            return null;
        } catch (NameNotFoundException e2) {
            NameNotFoundException nameNotFoundException = e2;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int e3 = Log.e("WorkSourceUtil", sb5.append("Could not find package: ").append(str2).toString());
            return null;
        }
    }

    private static Method zzsp() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    private static Method zzsq() {
        Method method = null;
        if (zzne.zzsj()) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
                Exception exc = e;
                return null;
            }
        }
        return method;
    }

    private static Method zzsr() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    private static Method zzss() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    private static Method zzst() {
        Method method = null;
        if (zzne.zzsj()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
                Exception exc = e;
                return null;
            }
        }
        return method;
    }
}
