package android.support.p000v4.app;

import android.app.Activity;

/* renamed from: android.support.v4.app.ActivityCompatApi23 */
class ActivityCompatApi23 {

    /* renamed from: android.support.v4.app.ActivityCompatApi23$RequestPermissionsRequestCodeValidator */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    ActivityCompatApi23() {
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        Activity activity2 = activity;
        String[] strArr2 = strArr;
        int i2 = i;
        if (activity2 instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity2).validateRequestPermissionsRequestCode(i2);
        }
        activity2.requestPermissions(strArr2, i2);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
