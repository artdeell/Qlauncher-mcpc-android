package android.support.p000v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatJB */
class ViewPropertyAnimatorCompatJB {
    ViewPropertyAnimatorCompatJB() {
    }

    public static void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        C01161 r7;
        View view2 = view;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener2 = viewPropertyAnimatorListener;
        if (viewPropertyAnimatorListener2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            C01161 r3 = r7;
            final ViewPropertyAnimatorListener viewPropertyAnimatorListener3 = viewPropertyAnimatorListener2;
            final View view3 = view2;
            C01161 r4 = new AnimatorListenerAdapter() {
                {
                    View view = r7;
                }

                public void onAnimationCancel(Animator animator) {
                    Animator animator2 = animator;
                    viewPropertyAnimatorListener3.onAnimationCancel(view3);
                }

                public void onAnimationEnd(Animator animator) {
                    Animator animator2 = animator;
                    viewPropertyAnimatorListener3.onAnimationEnd(view3);
                }

                public void onAnimationStart(Animator animator) {
                    Animator animator2 = animator;
                    viewPropertyAnimatorListener3.onAnimationStart(view3);
                }
            };
            ViewPropertyAnimator listener = animate.setListener(r3);
            return;
        }
        ViewPropertyAnimator listener2 = view2.animate().setListener(null);
    }

    public static void withEndAction(View view, Runnable runnable) {
        ViewPropertyAnimator withEndAction = view.animate().withEndAction(runnable);
    }

    public static void withLayer(View view) {
        ViewPropertyAnimator withLayer = view.animate().withLayer();
    }

    public static void withStartAction(View view, Runnable runnable) {
        ViewPropertyAnimator withStartAction = view.animate().withStartAction(runnable);
    }
}
