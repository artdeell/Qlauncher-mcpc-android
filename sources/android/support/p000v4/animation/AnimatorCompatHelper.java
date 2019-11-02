package android.support.p000v4.animation;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.animation.AnimatorCompatHelper */
public abstract class AnimatorCompatHelper {
    static AnimatorProvider IMPL;

    static {
        DonutAnimatorCompatProvider donutAnimatorCompatProvider;
        HoneycombMr1AnimatorCompatProvider honeycombMr1AnimatorCompatProvider;
        if (VERSION.SDK_INT >= 12) {
            HoneycombMr1AnimatorCompatProvider honeycombMr1AnimatorCompatProvider2 = honeycombMr1AnimatorCompatProvider;
            HoneycombMr1AnimatorCompatProvider honeycombMr1AnimatorCompatProvider3 = new HoneycombMr1AnimatorCompatProvider();
            IMPL = honeycombMr1AnimatorCompatProvider2;
            return;
        }
        DonutAnimatorCompatProvider donutAnimatorCompatProvider2 = donutAnimatorCompatProvider;
        DonutAnimatorCompatProvider donutAnimatorCompatProvider3 = new DonutAnimatorCompatProvider();
        IMPL = donutAnimatorCompatProvider2;
    }

    AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        IMPL.clearInterpolator(view);
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }
}
