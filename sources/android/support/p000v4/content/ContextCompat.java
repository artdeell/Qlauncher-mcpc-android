package android.support.p000v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompat */
public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    public ContextCompat() {
    }

    private static File buildPath(File file, String... strArr) {
        File file2;
        File file3;
        File file4;
        File file5 = file;
        String[] strArr2 = strArr;
        int length = strArr2.length;
        int i = 0;
        File file6 = file5;
        while (true) {
            File file7 = file6;
            if (i >= length) {
                return file7;
            }
            String str = strArr2[i];
            if (file7 == null) {
                file2 = file4;
                File file8 = new File(str);
            } else if (str != null) {
                file2 = file3;
                File file9 = new File(file7, str);
            } else {
                file2 = file7;
            }
            i++;
            file6 = file2;
        }
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        IllegalArgumentException illegalArgumentException;
        Context context2 = context;
        String str2 = str;
        if (str2 != null) {
            return context2.checkPermission(str2, Process.myPid(), Process.myUid());
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("permission is null");
        throw illegalArgumentException2;
    }

    private static File createFilesDir(File file) {
        StringBuilder sb;
        File file2 = file;
        synchronized (ContextCompat.class) {
            try {
                if (!file2.exists() && !file2.mkdirs() && !file2.exists()) {
                    String str = TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w(str, sb2.append("Unable to create files subdir ").append(file2.getPath()).toString());
                    file2 = null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<ContextCompat> cls = ContextCompat.class;
                throw th2;
            }
        }
        return file2;
    }

    public static final int getColor(Context context, int i) {
        Context context2 = context;
        int i2 = i;
        return VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColor(context2, i2) : context2.getResources().getColor(i2);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        Context context2 = context;
        int i2 = i;
        return VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColorStateList(context2, i2) : context2.getResources().getColorStateList(i2);
    }

    public static final Drawable getDrawable(Context context, int i) {
        Context context2 = context;
        int i2 = i;
        return VERSION.SDK_INT >= 21 ? ContextCompatApi21.getDrawable(context2, i2) : context2.getResources().getDrawable(i2);
    }

    public static File[] getExternalCacheDirs(Context context) {
        File buildPath;
        Context context2 = context;
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context2);
        }
        if (i >= 8) {
            buildPath = ContextCompatFroyo.getExternalCacheDir(context2);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context2.getPackageName(), DIR_CACHE);
        }
        File[] fileArr = new File[1];
        File[] fileArr2 = fileArr;
        fileArr[0] = buildPath;
        return fileArr2;
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        File buildPath;
        Context context2 = context;
        String str2 = str;
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context2, str2);
        }
        if (i >= 8) {
            buildPath = ContextCompatFroyo.getExternalFilesDir(context2, str2);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context2.getPackageName(), DIR_FILES, str2);
        }
        File[] fileArr = new File[1];
        File[] fileArr2 = fileArr;
        fileArr[0] = buildPath;
        return fileArr2;
    }

    public static File[] getObbDirs(Context context) {
        File buildPath;
        Context context2 = context;
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getObbDirs(context2);
        }
        if (i >= 11) {
            buildPath = ContextCompatHoneycomb.getObbDir(context2);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context2.getPackageName());
        }
        File[] fileArr = new File[1];
        File[] fileArr2 = fileArr;
        fileArr[0] = buildPath;
        return fileArr2;
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        Context context2 = context;
        Intent[] intentArr2 = intentArr;
        Bundle bundle2 = bundle;
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            ContextCompatJellybean.startActivities(context2, intentArr2, bundle2);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            ContextCompatHoneycomb.startActivities(context2, intentArr2);
            return true;
        }
    }

    public final File getCodeCacheDir(Context context) {
        File file;
        Context context2 = context;
        if (VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getCodeCacheDir(context2);
        }
        File file2 = file;
        File file3 = new File(context2.getApplicationInfo().dataDir, "code_cache");
        return createFilesDir(file2);
    }

    public final File getNoBackupFilesDir(Context context) {
        File file;
        Context context2 = context;
        if (VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getNoBackupFilesDir(context2);
        }
        File file2 = file;
        File file3 = new File(context2.getApplicationInfo().dataDir, "no_backup");
        return createFilesDir(file2);
    }
}
