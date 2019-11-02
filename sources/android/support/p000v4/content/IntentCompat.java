package android.support.p000v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.content.IntentCompat */
public class IntentCompat {
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    private static final IntentCompatImpl IMPL;

    /* renamed from: android.support.v4.content.IntentCompat$IntentCompatImpl */
    interface IntentCompatImpl {
        Intent makeMainActivity(ComponentName componentName);

        Intent makeMainSelectorActivity(String str, String str2);

        Intent makeRestartActivityTask(ComponentName componentName);
    }

    /* renamed from: android.support.v4.content.IntentCompat$IntentCompatImplBase */
    static class IntentCompatImplBase implements IntentCompatImpl {
        IntentCompatImplBase() {
        }

        public Intent makeMainActivity(ComponentName componentName) {
            Intent intent;
            ComponentName componentName2 = componentName;
            Intent intent2 = intent;
            Intent intent3 = new Intent("android.intent.action.MAIN");
            Intent intent4 = intent2;
            Intent component = intent4.setComponent(componentName2);
            Intent addCategory = intent4.addCategory("android.intent.category.LAUNCHER");
            return intent4;
        }

        public Intent makeMainSelectorActivity(String str, String str2) {
            Intent intent;
            String str3 = str2;
            Intent intent2 = intent;
            Intent intent3 = new Intent(str);
            Intent intent4 = intent2;
            Intent addCategory = intent4.addCategory(str3);
            return intent4;
        }

        public Intent makeRestartActivityTask(ComponentName componentName) {
            Intent makeMainActivity = makeMainActivity(componentName);
            Intent addFlags = makeMainActivity.addFlags(268468224);
            return makeMainActivity;
        }
    }

    /* renamed from: android.support.v4.content.IntentCompat$IntentCompatImplHC */
    static class IntentCompatImplHC extends IntentCompatImplBase {
        IntentCompatImplHC() {
        }

        public Intent makeMainActivity(ComponentName componentName) {
            return IntentCompatHoneycomb.makeMainActivity(componentName);
        }

        public Intent makeRestartActivityTask(ComponentName componentName) {
            return IntentCompatHoneycomb.makeRestartActivityTask(componentName);
        }
    }

    /* renamed from: android.support.v4.content.IntentCompat$IntentCompatImplIcsMr1 */
    static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        IntentCompatImplIcsMr1() {
        }

        public Intent makeMainSelectorActivity(String str, String str2) {
            return IntentCompatIcsMr1.makeMainSelectorActivity(str, str2);
        }
    }

    static {
        IntentCompatImplBase intentCompatImplBase;
        IntentCompatImplHC intentCompatImplHC;
        IntentCompatImplIcsMr1 intentCompatImplIcsMr1;
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            IntentCompatImplIcsMr1 intentCompatImplIcsMr12 = intentCompatImplIcsMr1;
            IntentCompatImplIcsMr1 intentCompatImplIcsMr13 = new IntentCompatImplIcsMr1();
            IMPL = intentCompatImplIcsMr12;
        } else if (i >= 11) {
            IntentCompatImplHC intentCompatImplHC2 = intentCompatImplHC;
            IntentCompatImplHC intentCompatImplHC3 = new IntentCompatImplHC();
            IMPL = intentCompatImplHC2;
        } else {
            IntentCompatImplBase intentCompatImplBase2 = intentCompatImplBase;
            IntentCompatImplBase intentCompatImplBase3 = new IntentCompatImplBase();
            IMPL = intentCompatImplBase2;
        }
    }

    private IntentCompat() {
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        return IMPL.makeMainActivity(componentName);
    }

    public static Intent makeMainSelectorActivity(String str, String str2) {
        return IMPL.makeMainSelectorActivity(str, str2);
    }

    public static Intent makeRestartActivityTask(ComponentName componentName) {
        return IMPL.makeRestartActivityTask(componentName);
    }
}
