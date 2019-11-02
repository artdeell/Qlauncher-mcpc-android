package android.support.p000v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider */
class DonutAnimatorCompatProvider implements AnimatorProvider {

    /* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider$DonutFloatValueAnimator */
    private static class DonutFloatValueAnimator implements ValueAnimatorCompat {
        /* access modifiers changed from: private */
        public long mDuration = 200;
        private boolean mEnded = false;
        /* access modifiers changed from: private */
        public float mFraction = 0.0f;
        List<AnimatorListenerCompat> mListeners;
        /* access modifiers changed from: private */
        public Runnable mLoopRunnable;
        /* access modifiers changed from: private */
        public long mStartTime;
        private boolean mStarted = false;
        View mTarget;
        List<AnimatorUpdateListenerCompat> mUpdateListeners;

        public DonutFloatValueAnimator() {
            ArrayList arrayList;
            ArrayList arrayList2;
            C00001 r5;
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList();
            this.mListeners = arrayList3;
            ArrayList arrayList5 = arrayList2;
            ArrayList arrayList6 = new ArrayList();
            this.mUpdateListeners = arrayList5;
            C00001 r2 = r5;
            C00001 r3 = new Runnable(this) {
                final /* synthetic */ DonutFloatValueAnimator this$0;

                {
                    this.this$0 = r5;
                }

                public void run() {
                    float access$000 = (1.0f * ((float) (this.this$0.getTime() - this.this$0.mStartTime))) / ((float) this.this$0.mDuration);
                    if (access$000 > 1.0f || this.this$0.mTarget.getParent() == null) {
                        access$000 = 1.0f;
                    }
                    float access$302 = DonutFloatValueAnimator.access$302(this.this$0, access$000);
                    this.this$0.notifyUpdateListeners();
                    if (this.this$0.mFraction >= 1.0f) {
                        this.this$0.dispatchEnd();
                    } else {
                        boolean postDelayed = this.this$0.mTarget.postDelayed(this.this$0.mLoopRunnable, 16);
                    }
                }
            };
            this.mLoopRunnable = r2;
        }

        static /* synthetic */ float access$302(DonutFloatValueAnimator donutFloatValueAnimator, float f) {
            float f2 = f;
            donutFloatValueAnimator.mFraction = f2;
            return f2;
        }

        private void dispatchCancel() {
            for (int size = -1 + this.mListeners.size(); size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationCancel(this);
            }
        }

        /* access modifiers changed from: private */
        public void dispatchEnd() {
            for (int size = -1 + this.mListeners.size(); size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationEnd(this);
            }
        }

        private void dispatchStart() {
            for (int size = -1 + this.mListeners.size(); size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationStart(this);
            }
        }

        /* access modifiers changed from: private */
        public long getTime() {
            return this.mTarget.getDrawingTime();
        }

        /* access modifiers changed from: private */
        public void notifyUpdateListeners() {
            for (int size = -1 + this.mUpdateListeners.size(); size >= 0; size--) {
                ((AnimatorUpdateListenerCompat) this.mUpdateListeners.get(size)).onAnimationUpdate(this);
            }
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            AnimatorListenerCompat animatorListenerCompat2 = animatorListenerCompat;
            boolean add = this.mListeners.add(animatorListenerCompat2);
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            AnimatorUpdateListenerCompat animatorUpdateListenerCompat2 = animatorUpdateListenerCompat;
            boolean add = this.mUpdateListeners.add(animatorUpdateListenerCompat2);
        }

        public void cancel() {
            if (!this.mEnded) {
                this.mEnded = true;
                if (this.mStarted) {
                    dispatchCancel();
                }
                dispatchEnd();
            }
        }

        public float getAnimatedFraction() {
            return this.mFraction;
        }

        public void setDuration(long j) {
            long j2 = j;
            if (!this.mStarted) {
                this.mDuration = j2;
            }
        }

        public void setTarget(View view) {
            View view2 = view;
            this.mTarget = view2;
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.mFraction = 0.0f;
                this.mStartTime = getTime();
                boolean postDelayed = this.mTarget.postDelayed(this.mLoopRunnable, 16);
            }
        }
    }

    DonutAnimatorCompatProvider() {
    }

    public void clearInterpolator(View view) {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        DonutFloatValueAnimator donutFloatValueAnimator;
        DonutFloatValueAnimator donutFloatValueAnimator2 = donutFloatValueAnimator;
        DonutFloatValueAnimator donutFloatValueAnimator3 = new DonutFloatValueAnimator();
        return donutFloatValueAnimator2;
    }
}
