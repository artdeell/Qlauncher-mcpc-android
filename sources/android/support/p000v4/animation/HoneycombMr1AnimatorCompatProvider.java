package android.support.p000v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator mDefaultInterpolator;

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper */
    static class AnimatorListenerCompatWrapper implements AnimatorListener {
        final ValueAnimatorCompat mValueAnimatorCompat;
        final AnimatorListenerCompat mWrapped;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            ValueAnimatorCompat valueAnimatorCompat2 = valueAnimatorCompat;
            this.mWrapped = animatorListenerCompat;
            this.mValueAnimatorCompat = valueAnimatorCompat2;
        }

        public void onAnimationCancel(Animator animator) {
            Animator animator2 = animator;
            this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
        }

        public void onAnimationEnd(Animator animator) {
            Animator animator2 = animator;
            this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
        }

        public void onAnimationRepeat(Animator animator) {
            Animator animator2 = animator;
            this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
        }

        public void onAnimationStart(Animator animator) {
            Animator animator2 = animator;
            this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
        }
    }

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat */
    static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator mWrapped;

        public HoneycombValueAnimatorCompat(Animator animator) {
            this.mWrapped = animator;
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            AnimatorListenerCompatWrapper animatorListenerCompatWrapper;
            AnimatorListenerCompat animatorListenerCompat2 = animatorListenerCompat;
            Animator animator = this.mWrapped;
            AnimatorListenerCompatWrapper animatorListenerCompatWrapper2 = animatorListenerCompatWrapper;
            AnimatorListenerCompatWrapper animatorListenerCompatWrapper3 = new AnimatorListenerCompatWrapper(animatorListenerCompat2, this);
            animator.addListener(animatorListenerCompatWrapper2);
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            C00011 r7;
            AnimatorUpdateListenerCompat animatorUpdateListenerCompat2 = animatorUpdateListenerCompat;
            if (this.mWrapped instanceof ValueAnimator) {
                ValueAnimator valueAnimator = (ValueAnimator) this.mWrapped;
                C00011 r3 = r7;
                final AnimatorUpdateListenerCompat animatorUpdateListenerCompat3 = animatorUpdateListenerCompat2;
                C00011 r4 = new AnimatorUpdateListener(this) {
                    final /* synthetic */ HoneycombValueAnimatorCompat this$0;

                    {
                        AnimatorUpdateListenerCompat animatorUpdateListenerCompat = r7;
                        this.this$0 = r6;
                    }

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ValueAnimator valueAnimator2 = valueAnimator;
                        animatorUpdateListenerCompat3.onAnimationUpdate(this.this$0);
                    }
                };
                valueAnimator.addUpdateListener(r3);
            }
        }

        public void cancel() {
            this.mWrapped.cancel();
        }

        public float getAnimatedFraction() {
            return ((ValueAnimator) this.mWrapped).getAnimatedFraction();
        }

        public void setDuration(long j) {
            long j2 = j;
            Animator duration = this.mWrapped.setDuration(j2);
        }

        public void setTarget(View view) {
            View view2 = view;
            this.mWrapped.setTarget(view2);
        }

        public void start() {
            this.mWrapped.start();
        }
    }

    HoneycombMr1AnimatorCompatProvider() {
    }

    public void clearInterpolator(View view) {
        ValueAnimator valueAnimator;
        View view2 = view;
        if (this.mDefaultInterpolator == null) {
            ValueAnimator valueAnimator2 = valueAnimator;
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.mDefaultInterpolator = valueAnimator2.getInterpolator();
        }
        ViewPropertyAnimator interpolator = view2.animate().setInterpolator(this.mDefaultInterpolator);
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        HoneycombValueAnimatorCompat honeycombValueAnimatorCompat;
        HoneycombValueAnimatorCompat honeycombValueAnimatorCompat2 = honeycombValueAnimatorCompat;
        HoneycombValueAnimatorCompat honeycombValueAnimatorCompat3 = new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
        return honeycombValueAnimatorCompat2;
    }
}
