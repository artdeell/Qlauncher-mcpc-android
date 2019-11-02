package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.util.Pair;
import android.view.View;

/* renamed from: android.support.v4.app.ActivityOptionsCompat */
public class ActivityOptionsCompat {

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImpl21 */
    private static class ActivityOptionsImpl21 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat21 mImpl;

        ActivityOptionsImpl21(ActivityOptionsCompat21 activityOptionsCompat21) {
            this.mImpl = activityOptionsCompat21;
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
            if (activityOptionsCompat2 instanceof ActivityOptionsImpl21) {
                this.mImpl.update(((ActivityOptionsImpl21) activityOptionsCompat2).mImpl);
            }
        }
    }

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB */
    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB activityOptionsCompatJB) {
            this.mImpl = activityOptionsCompatJB;
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
            if (activityOptionsCompat2 instanceof ActivityOptionsImplJB) {
                this.mImpl.update(((ActivityOptionsImplJB) activityOptionsCompat2).mImpl);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        ActivityOptionsCompat activityOptionsCompat;
        ActivityOptionsImplJB activityOptionsImplJB;
        Context context2 = context;
        int i3 = i;
        int i4 = i2;
        if (VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB activityOptionsImplJB2 = activityOptionsImplJB;
            ActivityOptionsImplJB activityOptionsImplJB3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context2, i3, i4));
            return activityOptionsImplJB2;
        }
        ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
        ActivityOptionsCompat activityOptionsCompat3 = new ActivityOptionsCompat();
        return activityOptionsCompat2;
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        ActivityOptionsCompat activityOptionsCompat;
        ActivityOptionsImplJB activityOptionsImplJB;
        View view2 = view;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB activityOptionsImplJB2 = activityOptionsImplJB;
            ActivityOptionsImplJB activityOptionsImplJB3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(view2, i5, i6, i7, i8));
            return activityOptionsImplJB2;
        }
        ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
        ActivityOptionsCompat activityOptionsCompat3 = new ActivityOptionsCompat();
        return activityOptionsCompat2;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        ActivityOptionsCompat activityOptionsCompat;
        ActivityOptionsImpl21 activityOptionsImpl21;
        Activity activity2 = activity;
        View view2 = view;
        String str2 = str;
        if (VERSION.SDK_INT >= 21) {
            ActivityOptionsImpl21 activityOptionsImpl212 = activityOptionsImpl21;
            ActivityOptionsImpl21 activityOptionsImpl213 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity2, view2, str2));
            return activityOptionsImpl212;
        }
        ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
        ActivityOptionsCompat activityOptionsCompat3 = new ActivityOptionsCompat();
        return activityOptionsCompat2;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        ActivityOptionsCompat activityOptionsCompat;
        ActivityOptionsImpl21 activityOptionsImpl21;
        Activity activity2 = activity;
        Pair<View, String>[] pairArr2 = pairArr;
        if (VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            View[] viewArr = null;
            if (pairArr2 != null) {
                viewArr = new View[pairArr2.length];
                strArr = new String[pairArr2.length];
                for (int i = 0; i < pairArr2.length; i++) {
                    viewArr[i] = (View) pairArr2[i].first;
                    strArr[i] = (String) pairArr2[i].second;
                }
            }
            ActivityOptionsImpl21 activityOptionsImpl212 = activityOptionsImpl21;
            ActivityOptionsImpl21 activityOptionsImpl213 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity2, viewArr, strArr));
            return activityOptionsImpl212;
        }
        ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
        ActivityOptionsCompat activityOptionsCompat3 = new ActivityOptionsCompat();
        return activityOptionsCompat2;
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        ActivityOptionsCompat activityOptionsCompat;
        ActivityOptionsImplJB activityOptionsImplJB;
        View view2 = view;
        Bitmap bitmap2 = bitmap;
        int i3 = i;
        int i4 = i2;
        if (VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB activityOptionsImplJB2 = activityOptionsImplJB;
            ActivityOptionsImplJB activityOptionsImplJB3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(view2, bitmap2, i3, i4));
            return activityOptionsImplJB2;
        }
        ActivityOptionsCompat activityOptionsCompat2 = activityOptionsCompat;
        ActivityOptionsCompat activityOptionsCompat3 = new ActivityOptionsCompat();
        return activityOptionsCompat2;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}
