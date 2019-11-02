package android.support.p000v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* renamed from: android.support.v4.app.ActivityOptionsCompat21 */
class ActivityOptionsCompat21 {
    private final ActivityOptions mActivityOptions;

    private ActivityOptionsCompat21(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity activity, View view, String str) {
        ActivityOptionsCompat21 activityOptionsCompat21;
        ActivityOptionsCompat21 activityOptionsCompat212 = activityOptionsCompat21;
        ActivityOptionsCompat21 activityOptionsCompat213 = new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        return activityOptionsCompat212;
    }

    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity activity, View[] viewArr, String[] strArr) {
        ActivityOptionsCompat21 activityOptionsCompat21;
        Activity activity2 = activity;
        View[] viewArr2 = viewArr;
        String[] strArr2 = strArr;
        Pair[] pairArr = null;
        if (viewArr2 != null) {
            pairArr = new Pair[viewArr2.length];
            for (int i = 0; i < pairArr.length; i++) {
                pairArr[i] = Pair.create(viewArr2[i], strArr2[i]);
            }
        }
        ActivityOptionsCompat21 activityOptionsCompat212 = activityOptionsCompat21;
        ActivityOptionsCompat21 activityOptionsCompat213 = new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(activity2, pairArr));
        return activityOptionsCompat212;
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompat21 activityOptionsCompat21) {
        this.mActivityOptions.update(activityOptionsCompat21.mActivityOptions);
    }
}
