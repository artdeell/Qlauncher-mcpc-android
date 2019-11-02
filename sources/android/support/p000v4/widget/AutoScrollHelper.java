package android.support.p000v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.AutoScrollHelper */
public abstract class AutoScrollHelper implements OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    /* access modifiers changed from: private */
    public boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    /* access modifiers changed from: private */
    public boolean mNeedsCancel;
    /* access modifiers changed from: private */
    public boolean mNeedsReset;
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private Runnable mRunnable;
    /* access modifiers changed from: private */
    public final ClampedScroller mScroller;
    /* access modifiers changed from: private */
    public final View mTarget;

    /* renamed from: android.support.v4.widget.AutoScrollHelper$ClampedScroller */
    private static class ClampedScroller {
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        public ClampedScroller() {
        }

        private float getValueAt(long j) {
            long j2 = j;
            if (j2 < this.mStartTime) {
                return 0.0f;
            }
            if (this.mStopTime < 0 || j2 < this.mStopTime) {
                return 0.5f * AutoScrollHelper.constrain(((float) (j2 - this.mStartTime)) / ((float) this.mRampUpDuration), 0.0f, 1.0f);
            }
            return (1.0f - this.mStopValue) + (this.mStopValue * AutoScrollHelper.constrain(((float) (j2 - this.mStopTime)) / ((float) this.mEffectiveRampDown), 0.0f, 1.0f));
        }

        private float interpolateValue(float f) {
            float f2 = f;
            return (f2 * -4.0f * f2) + (4.0f * f2);
        }

        public void computeScrollDelta() {
            RuntimeException runtimeException;
            if (this.mDeltaTime == 0) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("Cannot compute scroll delta before calling start()");
                throw runtimeException2;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.mDeltaTime;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mDeltaX = (int) (interpolateValue * ((float) j) * this.mTargetVelocityX);
            this.mDeltaY = (int) (interpolateValue * ((float) j) * this.mTargetVelocityY);
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            return (int) (this.mTargetVelocityX / Math.abs(this.mTargetVelocityX));
        }

        public int getVerticalDirection() {
            return (int) (this.mTargetVelocityY / Math.abs(this.mTargetVelocityY));
        }

        public boolean isFinished() {
            return this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i) {
            int i2 = i;
            this.mRampDownDuration = i2;
        }

        public void setRampUpDuration(int i) {
            int i2 = i;
            this.mRampUpDuration = i2;
        }

        public void setTargetVelocity(float f, float f2) {
            float f3 = f2;
            this.mTargetVelocityX = f;
            this.mTargetVelocityY = f3;
        }

        public void start() {
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStopTime = -1;
            this.mDeltaTime = this.mStartTime;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* renamed from: android.support.v4.widget.AutoScrollHelper$ScrollAnimationRunnable */
    private class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper this$0;

        private ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
            this.this$0 = autoScrollHelper;
        }

        /* synthetic */ ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper, C01261 r7) {
            C01261 r2 = r7;
            this(autoScrollHelper);
        }

        public void run() {
            if (this.this$0.mAnimating) {
                if (this.this$0.mNeedsReset) {
                    boolean access$202 = AutoScrollHelper.access$202(this.this$0, false);
                    this.this$0.mScroller.start();
                }
                ClampedScroller access$300 = this.this$0.mScroller;
                if (access$300.isFinished() || !this.this$0.shouldAnimate()) {
                    boolean access$102 = AutoScrollHelper.access$102(this.this$0, false);
                    return;
                }
                if (this.this$0.mNeedsCancel) {
                    boolean access$502 = AutoScrollHelper.access$502(this.this$0, false);
                    this.this$0.cancelTargetTouch();
                }
                access$300.computeScrollDelta();
                this.this$0.scrollTargetBy(access$300.getDeltaX(), access$300.getDeltaY());
                ViewCompat.postOnAnimation(this.this$0.mTarget, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        ClampedScroller clampedScroller;
        AccelerateInterpolator accelerateInterpolator;
        View view2 = view;
        ClampedScroller clampedScroller2 = clampedScroller;
        ClampedScroller clampedScroller3 = new ClampedScroller();
        this.mScroller = clampedScroller2;
        AccelerateInterpolator accelerateInterpolator2 = accelerateInterpolator;
        AccelerateInterpolator accelerateInterpolator3 = new AccelerateInterpolator();
        this.mEdgeInterpolator = accelerateInterpolator2;
        this.mTarget = view2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) (0.5f + (1575.0f * displayMetrics.density));
        int i2 = (int) (0.5f + (315.0f * displayMetrics.density));
        AutoScrollHelper maximumVelocity = setMaximumVelocity((float) i, (float) i);
        AutoScrollHelper minimumVelocity = setMinimumVelocity((float) i2, (float) i2);
        AutoScrollHelper edgeType = setEdgeType(1);
        AutoScrollHelper maximumEdges = setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        AutoScrollHelper relativeEdges = setRelativeEdges(0.2f, 0.2f);
        AutoScrollHelper relativeVelocity = setRelativeVelocity(1.0f, 1.0f);
        AutoScrollHelper activationDelay = setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        AutoScrollHelper rampUpDuration = setRampUpDuration(500);
        AutoScrollHelper rampDownDuration = setRampDownDuration(500);
    }

    static /* synthetic */ boolean access$102(AutoScrollHelper autoScrollHelper, boolean z) {
        boolean z2 = z;
        autoScrollHelper.mAnimating = z2;
        return z2;
    }

    static /* synthetic */ boolean access$202(AutoScrollHelper autoScrollHelper, boolean z) {
        boolean z2 = z;
        autoScrollHelper.mNeedsReset = z2;
        return z2;
    }

    static /* synthetic */ boolean access$502(AutoScrollHelper autoScrollHelper, boolean z) {
        boolean z2 = z;
        autoScrollHelper.mNeedsCancel = z2;
        return z2;
    }

    /* access modifiers changed from: private */
    public void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        boolean onTouchEvent = this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float computeTargetVelocity(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f3;
        float edgeValue = getEdgeValue(this.mRelativeEdges[i2], f2, this.mMaximumEdges[i2], f);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        float f5 = this.mRelativeVelocity[i2];
        float f6 = this.mMinimumVelocity[i2];
        float f7 = this.mMaximumVelocity[i2];
        float f8 = f5 * f4;
        return edgeValue > 0.0f ? constrain(edgeValue * f8, f6, f7) : -constrain(f8 * (-edgeValue), f6, f7);
    }

    /* access modifiers changed from: private */
    public static float constrain(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    /* access modifiers changed from: private */
    public static int constrain(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        return i4 > i6 ? i6 : i4 < i5 ? i5 : i4;
    }

    private float constrainEdgeValue(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        if (f4 != 0.0f) {
            switch (this.mEdgeType) {
                case 0:
                case 1:
                    if (f3 < f4) {
                        if (f3 >= 0.0f) {
                            return 1.0f - (f3 / f4);
                        }
                        if (this.mAnimating && this.mEdgeType == 1) {
                            return 1.0f;
                        }
                    }
                    break;
                case 2:
                    if (f3 < 0.0f) {
                        return f3 / (-f4);
                    }
                    break;
                default:
                    return 0.0f;
            }
        }
        return 0.0f;
    }

    private float getEdgeValue(float f, float f2, float f3, float f4) {
        float f5;
        float interpolation;
        float f6 = f2;
        float f7 = f4;
        float constrain = constrain(f * f6, 0.0f, f3);
        float constrainEdgeValue = constrainEdgeValue(f6 - f7, constrain) - constrainEdgeValue(f7, constrain);
        if (constrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else {
            f5 = 0.0f;
            if (constrainEdgeValue > 0.0f) {
                interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
            }
            return f5;
        }
        f5 = constrain(interpolation, -1.0f, 1.0f);
        return f5;
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    private void startAnimating() {
        ScrollAnimationRunnable scrollAnimationRunnable;
        if (this.mRunnable == null) {
            ScrollAnimationRunnable scrollAnimationRunnable2 = scrollAnimationRunnable;
            ScrollAnimationRunnable scrollAnimationRunnable3 = new ScrollAnimationRunnable(this, null);
            this.mRunnable = scrollAnimationRunnable2;
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || this.mActivationDelay <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, (long) this.mActivationDelay);
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2 = view;
        MotionEvent motionEvent2 = motionEvent;
        boolean z = true;
        if (!this.mEnabled) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent2)) {
            case 0:
                this.mNeedsCancel = true;
                this.mAlreadyDelayed = false;
                break;
            case 1:
            case 3:
                requestStop();
                break;
            case 2:
                break;
        }
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent2.getX(), (float) view2.getWidth(), (float) this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent2.getY(), (float) view2.getHeight(), (float) this.mTarget.getHeight()));
        if (!this.mAnimating && shouldAnimate()) {
            startAnimating();
        }
        if (!this.mExclusive || !this.mAnimating) {
            z = false;
        }
        return z;
    }

    public abstract void scrollTargetBy(int i, int i2);

    public AutoScrollHelper setActivationDelay(int i) {
        this.mActivationDelay = i;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i) {
        this.mEdgeType = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        boolean z2 = z;
        if (this.mEnabled && !z2) {
            requestStop();
        }
        this.mEnabled = z2;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.mExclusive = z;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        float f3 = f2;
        this.mMaximumEdges[0] = f;
        this.mMaximumEdges[1] = f3;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        float f3 = f2;
        this.mMaximumVelocity[0] = f / 1000.0f;
        this.mMaximumVelocity[1] = f3 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        float f3 = f2;
        this.mMinimumVelocity[0] = f / 1000.0f;
        this.mMinimumVelocity[1] = f3 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i) {
        this.mScroller.setRampDownDuration(i);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i) {
        this.mScroller.setRampUpDuration(i);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        float f3 = f2;
        this.mRelativeEdges[0] = f;
        this.mRelativeEdges[1] = f3;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        float f3 = f2;
        this.mRelativeVelocity[0] = f / 1000.0f;
        this.mRelativeVelocity[1] = f3 / 1000.0f;
        return this;
    }
}
