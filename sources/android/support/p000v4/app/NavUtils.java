package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.p000v4.content.IntentCompat;
import android.util.Log;

/* renamed from: android.support.v4.app.NavUtils */
public class NavUtils {
    private static final NavUtilsImpl IMPL;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImpl */
    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity activity);

        String getParentActivityName(Context context, ActivityInfo activityInfo);

        void navigateUpTo(Activity activity, Intent intent);

        boolean shouldUpRecreateTask(Activity activity, Intent intent);
    }

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImplBase */
    static class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }

        public Intent getParentActivityIntent(Activity activity) {
            ComponentName componentName;
            StringBuilder sb;
            Intent intent;
            Intent component;
            Activity activity2 = activity;
            String parentActivityName = NavUtils.getParentActivityName(activity2);
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName2 = componentName;
            ComponentName componentName3 = new ComponentName(activity2, parentActivityName);
            ComponentName componentName4 = componentName2;
            try {
                if (NavUtils.getParentActivityName(activity2, componentName4) == null) {
                    component = IntentCompat.makeMainActivity(componentName4);
                } else {
                    Intent intent2 = intent;
                    Intent intent3 = new Intent();
                    component = intent2.setComponent(componentName4);
                }
                return component;
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
                String str = NavUtils.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("getParentActivityIntent: bad parentActivityName '").append(parentActivityName).append("' in manifest").toString());
                return null;
            }
        }

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            String string;
            StringBuilder sb;
            Context context2 = context;
            ActivityInfo activityInfo2 = activityInfo;
            if (activityInfo2.metaData == null) {
                string = null;
            } else {
                string = activityInfo2.metaData.getString(NavUtils.PARENT_ACTIVITY);
                if (string == null) {
                    return null;
                }
                if (string.charAt(0) == '.') {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    return sb2.append(context2.getPackageName()).append(string).toString();
                }
            }
            return string;
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            Activity activity2 = activity;
            Intent intent2 = intent;
            Intent addFlags = intent2.addFlags(67108864);
            activity2.startActivity(intent2);
            activity2.finish();
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            Intent intent2 = intent;
            String action = activity.getIntent().getAction();
            return action != null && !action.equals("android.intent.action.MAIN");
        }
    }

    /* renamed from: android.support.v4.app.NavUtils$NavUtilsImplJB */
    static class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
        }

        public Intent getParentActivityIntent(Activity activity) {
            Activity activity2 = activity;
            Intent parentActivityIntent = NavUtilsJB.getParentActivityIntent(activity2);
            if (parentActivityIntent == null) {
                parentActivityIntent = superGetParentActivityIntent(activity2);
            }
            return parentActivityIntent;
        }

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            Context context2 = context;
            ActivityInfo activityInfo2 = activityInfo;
            String parentActivityName = NavUtilsJB.getParentActivityName(activityInfo2);
            if (parentActivityName == null) {
                parentActivityName = super.getParentActivityName(context2, activityInfo2);
            }
            return parentActivityName;
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            NavUtilsJB.navigateUpTo(activity, intent);
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            return NavUtilsJB.shouldUpRecreateTask(activity, intent);
        }

        /* access modifiers changed from: 0000 */
        public Intent superGetParentActivityIntent(Activity activity) {
            return super.getParentActivityIntent(activity);
        }
    }

    static {
        NavUtilsImplBase navUtilsImplBase;
        NavUtilsImplJB navUtilsImplJB;
        if (VERSION.SDK_INT >= 16) {
            NavUtilsImplJB navUtilsImplJB2 = navUtilsImplJB;
            NavUtilsImplJB navUtilsImplJB3 = new NavUtilsImplJB();
            IMPL = navUtilsImplJB2;
            return;
        }
        NavUtilsImplBase navUtilsImplBase2 = navUtilsImplBase;
        NavUtilsImplBase navUtilsImplBase3 = new NavUtilsImplBase();
        IMPL = navUtilsImplBase2;
    }

    private NavUtils() {
    }

    public static Intent getParentActivityIntent(Activity activity) {
        return IMPL.getParentActivityIntent(activity);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws NameNotFoundException {
        ComponentName componentName2;
        Intent intent;
        Context context2 = context;
        ComponentName componentName3 = componentName;
        String parentActivityName = getParentActivityName(context2, componentName3);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName4 = componentName2;
        ComponentName componentName5 = new ComponentName(componentName3.getPackageName(), parentActivityName);
        ComponentName componentName6 = componentName4;
        if (getParentActivityName(context2, componentName6) == null) {
            return IntentCompat.makeMainActivity(componentName6);
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        return intent2.setComponent(componentName6);
    }

    public static Intent getParentActivityIntent(Context context, Class<?> cls) throws NameNotFoundException {
        ComponentName componentName;
        ComponentName componentName2;
        Intent intent;
        Context context2 = context;
        Context context3 = context2;
        ComponentName componentName3 = componentName;
        ComponentName componentName4 = new ComponentName(context2, cls);
        String parentActivityName = getParentActivityName(context3, componentName3);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName5 = componentName2;
        ComponentName componentName6 = new ComponentName(context2, parentActivityName);
        ComponentName componentName7 = componentName5;
        if (getParentActivityName(context2, componentName7) == null) {
            return IntentCompat.makeMainActivity(componentName7);
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        return intent2.setComponent(componentName7);
    }

    @Nullable
    public static String getParentActivityName(Activity activity) {
        IllegalArgumentException illegalArgumentException;
        Activity activity2 = activity;
        try {
            return getParentActivityName(activity2, activity2.getComponentName());
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(nameNotFoundException);
            throw illegalArgumentException2;
        }
    }

    @Nullable
    public static String getParentActivityName(Context context, ComponentName componentName) throws NameNotFoundException {
        Context context2 = context;
        return IMPL.getParentActivityName(context2, context2.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void navigateUpFromSameTask(Activity activity) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Activity activity2 = activity;
        Intent parentActivityIntent = getParentActivityIntent(activity2);
        if (parentActivityIntent == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Activity ").append(activity2.getClass().getSimpleName()).append(" does not have a parent activity name specified.").append(" (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> ").append(" element in your manifest?)").toString());
            throw illegalArgumentException2;
        }
        navigateUpTo(activity2, parentActivityIntent);
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        IMPL.navigateUpTo(activity, intent);
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return IMPL.shouldUpRecreateTask(activity, intent);
    }
}
