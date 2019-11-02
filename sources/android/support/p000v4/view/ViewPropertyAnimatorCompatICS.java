package android.support.p000v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatICS */
class ViewPropertyAnimatorCompatICS {
    ViewPropertyAnimatorCompatICS() {
    }

    public static void alpha(View view, float f) {
        ViewPropertyAnimator alpha = view.animate().alpha(f);
    }

    public static void alphaBy(View view, float f) {
        ViewPropertyAnimator alphaBy = view.animate().alphaBy(f);
    }

    public static void cancel(View view) {
        view.animate().cancel();
    }

    public static long getDuration(View view) {
        return view.animate().getDuration();
    }

    public static long getStartDelay(View view) {
        return view.animate().getStartDelay();
    }

    public static void rotation(View view, float f) {
        ViewPropertyAnimator rotation = view.animate().rotation(f);
    }

    public static void rotationBy(View view, float f) {
        ViewPropertyAnimator rotationBy = view.animate().rotationBy(f);
    }

    public static void rotationX(View view, float f) {
        ViewPropertyAnimator rotationX = view.animate().rotationX(f);
    }

    public static void rotationXBy(View view, float f) {
        ViewPropertyAnimator rotationXBy = view.animate().rotationXBy(f);
    }

    public static void rotationY(View view, float f) {
        ViewPropertyAnimator rotationY = view.animate().rotationY(f);
    }

    public static void rotationYBy(View view, float f) {
        ViewPropertyAnimator rotationYBy = view.animate().rotationYBy(f);
    }

    public static void scaleX(View view, float f) {
        ViewPropertyAnimator scaleX = view.animate().scaleX(f);
    }

    public static void scaleXBy(View view, float f) {
        ViewPropertyAnimator scaleXBy = view.animate().scaleXBy(f);
    }

    public static void scaleY(View view, float f) {
        ViewPropertyAnimator scaleY = view.animate().scaleY(f);
    }

    public static void scaleYBy(View view, float f) {
        ViewPropertyAnimator scaleYBy = view.animate().scaleYBy(f);
    }

    public static void setDuration(View view, long j) {
        ViewPropertyAnimator duration = view.animate().setDuration(j);
    }

    public static void setInterpolator(View view, Interpolator interpolator) {
        ViewPropertyAnimator interpolator2 = view.animate().setInterpolator(interpolator);
    }

    public static void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        C01151 r7;
        View view2 = view;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener2 = viewPropertyAnimatorListener;
        if (viewPropertyAnimatorListener2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            C01151 r3 = r7;
            final ViewPropertyAnimatorListener viewPropertyAnimatorListener3 = viewPropertyAnimatorListener2;
            final View view3 = view2;
            C01151 r4 = new AnimatorListenerAdapter() {
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

    public static void setStartDelay(View view, long j) {
        ViewPropertyAnimator startDelay = view.animate().setStartDelay(j);
    }

    public static void start(View view) {
        view.animate().start();
    }

    public static void translationX(View view, float f) {
        ViewPropertyAnimator translationX = view.animate().translationX(f);
    }

    public static void translationXBy(View view, float f) {
        ViewPropertyAnimator translationXBy = view.animate().translationXBy(f);
    }

    public static void translationY(View view, float f) {
        ViewPropertyAnimator translationY = view.animate().translationY(f);
    }

    public static void translationYBy(View view, float f) {
        ViewPropertyAnimator translationYBy = view.animate().translationYBy(f);
    }

    /* renamed from: x */
    public static void m16x(View view, float f) {
        ViewPropertyAnimator x = view.animate().x(f);
    }

    public static void xBy(View view, float f) {
        ViewPropertyAnimator xBy = view.animate().xBy(f);
    }

    /* renamed from: y */
    public static void m17y(View view, float f) {
        ViewPropertyAnimator y = view.animate().y(f);
    }

    public static void yBy(View view, float f) {
        ViewPropertyAnimator yBy = view.animate().yBy(f);
    }
}
