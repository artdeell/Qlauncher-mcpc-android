package android.support.p000v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.app.AppOpsManagerCompat */
public class AppOpsManagerCompat {
    private static final AppOpsManagerImpl IMPL;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$AppOpsManager23 */
    private static class AppOpsManager23 extends AppOpsManagerImpl {
        private AppOpsManager23() {
            super(null);
        }

        /* synthetic */ AppOpsManager23(C00041 r4) {
            C00041 r1 = r4;
            this();
        }

        public int noteOp(Context context, String str, int i, String str2) {
            return AppOpsManagerCompat23.noteOp(context, str, i, str2);
        }

        public int noteProxyOp(Context context, String str, String str2) {
            return AppOpsManagerCompat23.noteProxyOp(context, str, str2);
        }

        public String permissionToOp(String str) {
            return AppOpsManagerCompat23.permissionToOp(str);
        }
    }

    /* renamed from: android.support.v4.app.AppOpsManagerCompat$AppOpsManagerImpl */
    private static class AppOpsManagerImpl {
        private AppOpsManagerImpl() {
        }

        /* synthetic */ AppOpsManagerImpl(C00041 r4) {
            C00041 r1 = r4;
            this();
        }

        public int noteOp(Context context, String str, int i, String str2) {
            Context context2 = context;
            String str3 = str;
            int i2 = i;
            String str4 = str2;
            return 1;
        }

        public int noteProxyOp(Context context, String str, String str2) {
            Context context2 = context;
            String str3 = str;
            String str4 = str2;
            return 1;
        }

        public String permissionToOp(String str) {
            String str2 = str;
            return null;
        }
    }

    static {
        AppOpsManagerImpl appOpsManagerImpl;
        AppOpsManager23 appOpsManager23;
        if (VERSION.SDK_INT >= 23) {
            AppOpsManager23 appOpsManager232 = appOpsManager23;
            AppOpsManager23 appOpsManager233 = new AppOpsManager23(null);
            IMPL = appOpsManager232;
            return;
        }
        AppOpsManagerImpl appOpsManagerImpl2 = appOpsManagerImpl;
        AppOpsManagerImpl appOpsManagerImpl3 = new AppOpsManagerImpl(null);
        IMPL = appOpsManagerImpl2;
    }

    public AppOpsManagerCompat() {
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i, @NonNull String str2) {
        return IMPL.noteOp(context, str, i, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return IMPL.noteProxyOp(context, str, str2);
    }

    public static String permissionToOp(@NonNull String str) {
        return IMPL.permissionToOp(str);
    }
}
