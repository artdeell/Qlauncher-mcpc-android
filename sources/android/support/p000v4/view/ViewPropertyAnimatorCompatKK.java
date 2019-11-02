package android.support.p000v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatKK */
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        C01171 r7;
        View view2 = view;
        ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener2 = viewPropertyAnimatorUpdateListener;
        C01171 r2 = null;
        if (viewPropertyAnimatorUpdateListener2 != null) {
            C01171 r3 = r7;
            final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener3 = viewPropertyAnimatorUpdateListener2;
            final View view3 = view2;
            C01171 r4 = new AnimatorUpdateListener() {
                {
                    View view = r7;
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ValueAnimator valueAnimator2 = valueAnimator;
                    viewPropertyAnimatorUpdateListener3.onAnimationUpdate(view3);
                }
            };
            r2 = r3;
        }
        ViewPropertyAnimator updateListener = view2.animate().setUpdateListener(r2);
    }
}
