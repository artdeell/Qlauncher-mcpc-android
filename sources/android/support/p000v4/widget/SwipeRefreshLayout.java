package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingChild;
import android.support.p000v4.view.NestedScrollingChildHelper;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

/* renamed from: android.support.v4.widget.SwipeRefreshLayout */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS;
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleHeight;
    /* access modifiers changed from: private */
    public CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    /* access modifiers changed from: private */
    public int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    /* access modifiers changed from: private */
    public OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    /* access modifiers changed from: private */
    public boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    /* access modifiers changed from: private */
    public MaterialProgressDrawable mProgress;
    private AnimationListener mRefreshListener;
    /* access modifiers changed from: private */
    public boolean mRefreshing;
    private boolean mReturningToStart;
    /* access modifiers changed from: private */
    public boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    /* access modifiers changed from: private */
    public float mSpinnerFinalOffset;
    /* access modifiers changed from: private */
    public float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    /* access modifiers changed from: private */
    public boolean mUsingCustomStart;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener */
    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16842766;
        LAYOUT_ATTRS = iArr2;
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        C01431 r9;
        C01486 r92;
        C01497 r93;
        DecelerateInterpolator decelerateInterpolator;
        NestedScrollingParentHelper nestedScrollingParentHelper;
        NestedScrollingChildHelper nestedScrollingChildHelper;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        super(context2, attributeSet2);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        C01431 r6 = r9;
        C01431 r7 = new AnimationListener(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void onAnimationEnd(Animation animation) {
                Animation animation2 = animation;
                if (this.this$0.mRefreshing) {
                    this.this$0.mProgress.setAlpha(255);
                    this.this$0.mProgress.start();
                    if (this.this$0.mNotify && this.this$0.mListener != null) {
                        this.this$0.mListener.onRefresh();
                    }
                } else {
                    this.this$0.mProgress.stop();
                    this.this$0.mCircleView.setVisibility(8);
                    this.this$0.setColorViewAlpha(255);
                    if (this.this$0.mScale) {
                        this.this$0.setAnimationProgress(0.0f);
                    } else {
                        this.this$0.setTargetOffsetTopAndBottom(this.this$0.mOriginalOffsetTop - this.this$0.mCurrentTargetOffsetTop, true);
                    }
                }
                int access$802 = SwipeRefreshLayout.access$802(this.this$0, this.this$0.mCircleView.getTop());
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mRefreshListener = r6;
        C01486 r62 = r92;
        C01486 r72 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void applyTransformation(float f, Transformation transformation) {
                float f2 = f;
                Transformation transformation2 = transformation;
                this.this$0.setTargetOffsetTopAndBottom((this.this$0.mFrom + ((int) (f2 * ((float) ((!this.this$0.mUsingCustomStart ? (int) (this.this$0.mSpinnerFinalOffset - ((float) Math.abs(this.this$0.mOriginalOffsetTop))) : (int) this.this$0.mSpinnerFinalOffset) - this.this$0.mFrom))))) - this.this$0.mCircleView.getTop(), false);
                this.this$0.mProgress.setArrowScale(1.0f - f2);
            }
        };
        this.mAnimateToCorrectPosition = r62;
        C01497 r63 = r93;
        C01497 r73 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void applyTransformation(float f, Transformation transformation) {
                float f2 = f;
                Transformation transformation2 = transformation;
                this.this$0.moveToStart(f2);
            }
        };
        this.mAnimateToStartPosition = r63;
        this.mTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        DecelerateInterpolator decelerateInterpolator2 = decelerateInterpolator;
        DecelerateInterpolator decelerateInterpolator3 = new DecelerateInterpolator(2.0f);
        this.mDecelerateInterpolator = decelerateInterpolator2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleWidth = (int) (40.0f * displayMetrics.density);
        this.mCircleHeight = (int) (40.0f * displayMetrics.density);
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mSpinnerFinalOffset = 64.0f * displayMetrics.density;
        this.mTotalDragDistance = this.mSpinnerFinalOffset;
        NestedScrollingParentHelper nestedScrollingParentHelper2 = nestedScrollingParentHelper;
        NestedScrollingParentHelper nestedScrollingParentHelper3 = new NestedScrollingParentHelper(this);
        this.mNestedScrollingParentHelper = nestedScrollingParentHelper2;
        NestedScrollingChildHelper nestedScrollingChildHelper2 = nestedScrollingChildHelper;
        NestedScrollingChildHelper nestedScrollingChildHelper3 = new NestedScrollingChildHelper(this);
        this.mNestedScrollingChildHelper = nestedScrollingChildHelper2;
        setNestedScrollingEnabled(true);
    }

    static /* synthetic */ int access$802(SwipeRefreshLayout swipeRefreshLayout, int i) {
        int i2 = i;
        swipeRefreshLayout.mCurrentTargetOffsetTop = i2;
        return i2;
    }

    private void animateOffsetToCorrectPosition(int i, AnimationListener animationListener) {
        AnimationListener animationListener2 = animationListener;
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener2 != null) {
            this.mCircleView.setAnimationListener(animationListener2);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, AnimationListener animationListener) {
        int i2 = i;
        AnimationListener animationListener2 = animationListener;
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i2, animationListener2);
            return;
        }
        this.mFrom = i2;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener2 != null) {
            this.mCircleView.setAnimationListener(animationListener2);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        CircleImageView circleImageView;
        MaterialProgressDrawable materialProgressDrawable;
        CircleImageView circleImageView2 = circleImageView;
        CircleImageView circleImageView3 = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, 20.0f);
        this.mCircleView = circleImageView2;
        MaterialProgressDrawable materialProgressDrawable2 = materialProgressDrawable;
        MaterialProgressDrawable materialProgressDrawable3 = new MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable2;
        this.mProgress.setBackgroundColor(CIRCLE_BG_LIGHT);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f) {
        C01475 r7;
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        C01475 r3 = null;
        if (!this.mScale) {
            C01475 r4 = r7;
            C01475 r5 = new AnimationListener(this) {
                final /* synthetic */ SwipeRefreshLayout this$0;

                {
                    this.this$0 = r5;
                }

                public void onAnimationEnd(Animation animation) {
                    Animation animation2 = animation;
                    if (!this.this$0.mScale) {
                        this.this$0.startScaleDownAnimation(null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
            r3 = r4;
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r3);
        this.mProgress.showArrow(false);
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent2, findPointerIndex);
    }

    private boolean isAlphaUsedForScale() {
        return VERSION.SDK_INT < 11;
    }

    private boolean isAnimationRunning(Animation animation) {
        Animation animation2 = animation;
        return animation2 != null && animation2.hasStarted() && !animation2.hasEnded();
    }

    private void moveSpinner(float f) {
        float f2 = f;
        this.mProgress.showArrow(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.mTotalDragDistance));
        float max = (5.0f * ((float) Math.max(((double) min) - 0.4d, 0.0d))) / 3.0f;
        float abs = Math.abs(f2) - this.mTotalDragDistance;
        float f3 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - ((float) this.mOriginalOffsetTop) : this.mSpinnerFinalOffset;
        float max2 = Math.max(0.0f, Math.min(abs, 2.0f * f3) / f3);
        float pow = 2.0f * ((float) (((double) (max2 / 4.0f)) - Math.pow((double) (max2 / 4.0f), 2.0d)));
        int i = this.mOriginalOffsetTop + ((int) ((2.0f * f3 * pow) + (f3 * min)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            ViewCompat.setScaleX(this.mCircleView, 1.0f);
            ViewCompat.setScaleY(this.mCircleView, 1.0f);
        }
        if (f2 < this.mTotalDragDistance) {
            if (this.mScale) {
                setAnimationProgress(f2 / this.mTotalDragDistance);
            }
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
            this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, max * MAX_PROGRESS_ANGLE));
            this.mProgress.setArrowScale(Math.min(1.0f, max));
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.setProgressRotation(0.5f * (-0.25f + (0.4f * max) + (2.0f * pow)));
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
    }

    /* access modifiers changed from: private */
    public void moveToStart(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (f * ((float) (this.mOriginalOffsetTop - this.mFrom))))) - this.mCircleView.getTop(), false);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent2);
        if (MotionEventCompat.getPointerId(motionEvent2, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, actionIndex == 0 ? 1 : 0);
        }
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        float f2 = f;
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (255.0f * f2));
            return;
        }
        ViewCompat.setScaleX(this.mCircleView, f2);
        ViewCompat.setScaleY(this.mCircleView, f2);
    }

    /* access modifiers changed from: private */
    public void setColorViewAlpha(int i) {
        int i2 = i;
        this.mCircleView.getBackground().setAlpha(i2);
        this.mProgress.setAlpha(i2);
    }

    private void setRefreshing(boolean z, boolean z2) {
        boolean z3 = z;
        boolean z4 = z2;
        if (this.mRefreshing != z3) {
            this.mNotify = z4;
            ensureTarget();
            this.mRefreshing = z3;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        int i2 = i;
        boolean z2 = z;
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(i2);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        if (z2 && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private Animation startAlphaAnimation(int i, int i2) {
        C01464 r9;
        int i3 = i;
        int i4 = i2;
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        C01464 r4 = r9;
        final int i5 = i3;
        final int i6 = i4;
        C01464 r5 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                int i = r8;
                int i2 = r9;
                this.this$0 = r7;
            }

            public void applyTransformation(float f, Transformation transformation) {
                Transformation transformation2 = transformation;
                this.this$0.mProgress.setAlpha((int) (((float) i5) + (f * ((float) (i6 - i5)))));
            }
        };
        C01464 r3 = r4;
        r3.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r3);
        return r3;
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    /* access modifiers changed from: private */
    public void startScaleDownAnimation(AnimationListener animationListener) {
        C01453 r6;
        AnimationListener animationListener2 = animationListener;
        C01453 r3 = r6;
        C01453 r4 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void applyTransformation(float f, Transformation transformation) {
                Transformation transformation2 = transformation;
                this.this$0.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = r3;
        this.mScaleDownAnimation.setDuration(150);
        this.mCircleView.setAnimationListener(animationListener2);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startScaleDownReturnToStartAnimation(int i, AnimationListener animationListener) {
        C01508 r7;
        AnimationListener animationListener2 = animationListener;
        this.mFrom = i;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = (float) this.mProgress.getAlpha();
        } else {
            this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
        }
        C01508 r4 = r7;
        C01508 r5 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void applyTransformation(float f, Transformation transformation) {
                float f2 = f;
                Transformation transformation2 = transformation;
                this.this$0.setAnimationProgress(this.this$0.mStartingScale + (f2 * (-this.this$0.mStartingScale)));
                this.this$0.moveToStart(f2);
            }
        };
        this.mScaleDownToStartAnimation = r4;
        this.mScaleDownToStartAnimation.setDuration(150);
        if (animationListener2 != null) {
            this.mCircleView.setAnimationListener(animationListener2);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(AnimationListener animationListener) {
        C01442 r6;
        AnimationListener animationListener2 = animationListener;
        this.mCircleView.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.mProgress.setAlpha(255);
        }
        C01442 r3 = r6;
        C01442 r4 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout this$0;

            {
                this.this$0 = r5;
            }

            public void applyTransformation(float f, Transformation transformation) {
                float f2 = f;
                Transformation transformation2 = transformation;
                this.this$0.setAnimationProgress(f2);
            }
        };
        this.mScaleAnimation = r3;
        this.mScaleAnimation.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener2 != null) {
            this.mCircleView.setAnimationListener(animationListener2);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0.mTarget.getScrollY() > 0) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canChildScrollUp() {
        /*
            r6 = this;
            r0 = r6
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 14
            if (r4 >= r5) goto L_0x0055
            r4 = r0
            android.view.View r4 = r4.mTarget
            boolean r4 = r4 instanceof android.widget.AbsListView
            if (r4 == 0) goto L_0x0039
            r4 = r0
            android.view.View r4 = r4.mTarget
            android.widget.AbsListView r4 = (android.widget.AbsListView) r4
            r3 = r4
            r4 = r3
            int r4 = r4.getChildCount()
            if (r4 <= 0) goto L_0x0036
            r4 = r3
            int r4 = r4.getFirstVisiblePosition()
            if (r4 > 0) goto L_0x0033
            r4 = r3
            r5 = 0
            android.view.View r4 = r4.getChildAt(r5)
            int r4 = r4.getTop()
            r5 = r3
            int r5 = r5.getPaddingTop()
            if (r4 >= r5) goto L_0x0036
        L_0x0033:
            r4 = 1
            r0 = r4
        L_0x0035:
            return r0
        L_0x0036:
            r4 = 0
            r0 = r4
            goto L_0x0035
        L_0x0039:
            r4 = r0
            android.view.View r4 = r4.mTarget
            r5 = -1
            boolean r4 = android.support.p000v4.view.ViewCompat.canScrollVertically(r4, r5)
            if (r4 != 0) goto L_0x0050
            r4 = r0
            android.view.View r4 = r4.mTarget
            int r4 = r4.getScrollY()
            r2 = r4
            r4 = 0
            r1 = r4
            r4 = r2
            if (r4 <= 0) goto L_0x0052
        L_0x0050:
            r4 = 1
            r1 = r4
        L_0x0052:
            r4 = r1
            r0 = r4
            goto L_0x0035
        L_0x0055:
            r4 = r0
            android.view.View r4 = r4.mTarget
            r5 = -1
            boolean r4 = android.support.p000v4.view.ViewCompat.canScrollVertically(r4, r5)
            r0 = r4
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SwipeRefreshLayout.canChildScrollUp():boolean");
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mCircleViewIndex >= 0) {
            if (i4 == i3 - 1) {
                return this.mCircleViewIndex;
            }
            if (i4 >= this.mCircleViewIndex) {
                return i4 + 1;
            }
        }
        return i4;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        if (this.mCircleView != null) {
            return this.mCircleView.getMeasuredHeight();
        }
        return 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return r0.mIsBeingDragged;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r6 = r0
            r6.ensureTarget()
            r6 = r1
            int r6 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r6)
            r2 = r6
            r6 = r0
            boolean r6 = r6.mReturningToStart
            if (r6 == 0) goto L_0x0018
            r6 = r2
            if (r6 != 0) goto L_0x0018
            r6 = r0
            r7 = 0
            r6.mReturningToStart = r7
        L_0x0018:
            r6 = r0
            boolean r6 = r6.isEnabled()
            if (r6 == 0) goto L_0x0035
            r6 = r0
            boolean r6 = r6.mReturningToStart
            if (r6 != 0) goto L_0x0035
            r6 = r0
            boolean r6 = r6.canChildScrollUp()
            if (r6 != 0) goto L_0x0035
            r6 = r0
            boolean r6 = r6.mRefreshing
            if (r6 != 0) goto L_0x0035
            r6 = r0
            boolean r6 = r6.mNestedScrollInProgress
            if (r6 == 0) goto L_0x0038
        L_0x0035:
            r6 = 0
            r0 = r6
        L_0x0037:
            return r0
        L_0x0038:
            r6 = r2
            switch(r6) {
                case 0: goto L_0x0041;
                case 1: goto L_0x00c8;
                case 2: goto L_0x0074;
                case 3: goto L_0x00c8;
                case 4: goto L_0x003c;
                case 5: goto L_0x003c;
                case 6: goto L_0x00c1;
                default: goto L_0x003c;
            }
        L_0x003c:
            r6 = r0
            boolean r6 = r6.mIsBeingDragged
            r0 = r6
            goto L_0x0037
        L_0x0041:
            r6 = r0
            r7 = r0
            int r7 = r7.mOriginalOffsetTop
            r8 = r0
            android.support.v4.widget.CircleImageView r8 = r8.mCircleView
            int r8 = r8.getTop()
            int r7 = r7 - r8
            r8 = 1
            r6.setTargetOffsetTopAndBottom(r7, r8)
            r6 = r0
            r7 = r1
            r8 = 0
            int r7 = android.support.p000v4.view.MotionEventCompat.getPointerId(r7, r8)
            r6.mActivePointerId = r7
            r6 = r0
            r7 = 0
            r6.mIsBeingDragged = r7
            r6 = r0
            r7 = r1
            r8 = r0
            int r8 = r8.mActivePointerId
            float r6 = r6.getMotionEventY(r7, r8)
            r5 = r6
            r6 = r5
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0035
            r6 = r0
            r7 = r5
            r6.mInitialDownY = r7
            goto L_0x003c
        L_0x0074:
            r6 = r0
            int r6 = r6.mActivePointerId
            r7 = -1
            if (r6 != r7) goto L_0x0085
            java.lang.String r6 = LOG_TAG
            java.lang.String r7 = "Got ACTION_MOVE event but don't have an active pointer id."
            int r6 = android.util.Log.e(r6, r7)
            r6 = 0
            r0 = r6
            goto L_0x0037
        L_0x0085:
            r6 = r0
            r7 = r1
            r8 = r0
            int r8 = r8.mActivePointerId
            float r6 = r6.getMotionEventY(r7, r8)
            r3 = r6
            r6 = r3
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0035
            r6 = r3
            r7 = r0
            float r7 = r7.mInitialDownY
            float r6 = r6 - r7
            r7 = r0
            int r7 = r7.mTouchSlop
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x003c
            r6 = r0
            boolean r6 = r6.mIsBeingDragged
            if (r6 != 0) goto L_0x003c
            r6 = r0
            r7 = r0
            float r7 = r7.mInitialDownY
            r8 = r0
            int r8 = r8.mTouchSlop
            float r8 = (float) r8
            float r7 = r7 + r8
            r6.mInitialMotionY = r7
            r6 = r0
            r7 = 1
            r6.mIsBeingDragged = r7
            r6 = r0
            android.support.v4.widget.MaterialProgressDrawable r6 = r6.mProgress
            r7 = 76
            r6.setAlpha(r7)
            goto L_0x003c
        L_0x00c1:
            r6 = r0
            r7 = r1
            r6.onSecondaryPointerUp(r7)
            goto L_0x003c
        L_0x00c8:
            r6 = r0
            r7 = 0
            r6.mIsBeingDragged = r7
            r6 = r0
            r7 = -1
            r6.mActivePointerId = r7
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = z;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            if (this.mTarget != null) {
                View view = this.mTarget;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, paddingLeft + ((measuredWidth - getPaddingLeft()) - getPaddingRight()), paddingTop + ((measuredHeight - getPaddingTop()) - getPaddingBottom()));
                int measuredWidth2 = this.mCircleView.getMeasuredWidth();
                int measuredHeight2 = this.mCircleView.getMeasuredHeight();
                int i9 = (measuredWidth / 2) - (measuredWidth2 / 2);
                this.mCircleView.layout(i9, this.mCurrentTargetOffsetTop, (measuredWidth / 2) + (measuredWidth2 / 2), measuredHeight2 + this.mCurrentTargetOffsetTop);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget != null) {
            this.mTarget.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), IDirectInputDevice.DIEP_NORESTART), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), IDirectInputDevice.DIEP_NORESTART));
            this.mCircleView.measure(MeasureSpec.makeMeasureSpec(this.mCircleWidth, IDirectInputDevice.DIEP_NORESTART), MeasureSpec.makeMeasureSpec(this.mCircleHeight, IDirectInputDevice.DIEP_NORESTART));
            if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
                this.mOriginalOffsetCalculated = true;
                int i3 = -this.mCircleView.getMeasuredHeight();
                this.mOriginalOffsetTop = i3;
                this.mCurrentTargetOffsetTop = i3;
            }
            this.mCircleViewIndex = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.mCircleView) {
                    this.mCircleViewIndex = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        View view2 = view;
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        View view2 = view;
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        View view2 = view;
        int i3 = i;
        int i4 = i2;
        int[] iArr2 = iArr;
        if (i4 > 0 && this.mTotalUnconsumed > 0.0f) {
            if (((float) i4) > this.mTotalUnconsumed) {
                iArr2[1] = i4 - ((int) this.mTotalUnconsumed);
                this.mTotalUnconsumed = 0.0f;
            } else {
                this.mTotalUnconsumed -= (float) i4;
                iArr2[1] = i4;
            }
            moveSpinner(this.mTotalUnconsumed);
        }
        if (this.mUsingCustomStart && i4 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i4 - iArr2[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr3 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i3 - iArr2[0], i4 - iArr2[1], iArr3, null)) {
            iArr2[0] = iArr2[0] + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        View view2 = view;
        int i5 = i4;
        boolean dispatchNestedScroll = dispatchNestedScroll(i, i2, i3, i5, this.mParentOffsetInWindow);
        int i6 = i5 + this.mParentOffsetInWindow[1];
        if (i6 < 0) {
            this.mTotalUnconsumed += (float) Math.abs(i6);
            moveSpinner(this.mTotalUnconsumed);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        int i2 = i;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i2);
        boolean startNestedScroll = startNestedScroll(i2 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        View view3 = view;
        View view4 = view2;
        return isEnabled() && !this.mReturningToStart && !this.mRefreshing && (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        if (this.mTotalUnconsumed > 0.0f) {
            finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r10 = r1
            int r10 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r10)
            r2 = r10
            r10 = r0
            boolean r10 = r10.mReturningToStart
            if (r10 == 0) goto L_0x0014
            r10 = r2
            if (r10 != 0) goto L_0x0014
            r10 = r0
            r11 = 0
            r10.mReturningToStart = r11
        L_0x0014:
            r10 = r0
            boolean r10 = r10.isEnabled()
            if (r10 == 0) goto L_0x002c
            r10 = r0
            boolean r10 = r10.mReturningToStart
            if (r10 != 0) goto L_0x002c
            r10 = r0
            boolean r10 = r10.canChildScrollUp()
            if (r10 != 0) goto L_0x002c
            r10 = r0
            boolean r10 = r10.mNestedScrollInProgress
            if (r10 == 0) goto L_0x002f
        L_0x002c:
            r10 = 0
            r0 = r10
        L_0x002e:
            return r0
        L_0x002f:
            r10 = r2
            switch(r10) {
                case 0: goto L_0x0036;
                case 1: goto L_0x009e;
                case 2: goto L_0x0044;
                case 3: goto L_0x002c;
                case 4: goto L_0x0033;
                case 5: goto L_0x007a;
                case 6: goto L_0x0098;
                default: goto L_0x0033;
            }
        L_0x0033:
            r10 = 1
            r0 = r10
            goto L_0x002e
        L_0x0036:
            r10 = r0
            r11 = r1
            r12 = 0
            int r11 = android.support.p000v4.view.MotionEventCompat.getPointerId(r11, r12)
            r10.mActivePointerId = r11
            r10 = r0
            r11 = 0
            r10.mIsBeingDragged = r11
            goto L_0x0033
        L_0x0044:
            r10 = r1
            r11 = r0
            int r11 = r11.mActivePointerId
            int r10 = android.support.p000v4.view.MotionEventCompat.findPointerIndex(r10, r11)
            r8 = r10
            r10 = r8
            if (r10 >= 0) goto L_0x005b
            java.lang.String r10 = LOG_TAG
            java.lang.String r11 = "Got ACTION_MOVE event but have an invalid active pointer id."
            int r10 = android.util.Log.e(r10, r11)
            r10 = 0
            r0 = r10
            goto L_0x002e
        L_0x005b:
            r10 = 1056964608(0x3f000000, float:0.5)
            r11 = r1
            r12 = r8
            float r11 = android.support.p000v4.view.MotionEventCompat.getY(r11, r12)
            r12 = r0
            float r12 = r12.mInitialMotionY
            float r11 = r11 - r12
            float r10 = r10 * r11
            r9 = r10
            r10 = r0
            boolean r10 = r10.mIsBeingDragged
            if (r10 == 0) goto L_0x0033
            r10 = r9
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x002c
            r10 = r0
            r11 = r9
            r10.moveSpinner(r11)
            goto L_0x0033
        L_0x007a:
            r10 = r1
            int r10 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r10)
            r6 = r10
            r10 = r6
            if (r10 >= 0) goto L_0x008e
            java.lang.String r10 = LOG_TAG
            java.lang.String r11 = "Got ACTION_POINTER_DOWN event but have an invalid action index."
            int r10 = android.util.Log.e(r10, r11)
            r10 = 0
            r0 = r10
            goto L_0x002e
        L_0x008e:
            r10 = r0
            r11 = r1
            r12 = r6
            int r11 = android.support.p000v4.view.MotionEventCompat.getPointerId(r11, r12)
            r10.mActivePointerId = r11
            goto L_0x0033
        L_0x0098:
            r10 = r0
            r11 = r1
            r10.onSecondaryPointerUp(r11)
            goto L_0x0033
        L_0x009e:
            r10 = r1
            r11 = r0
            int r11 = r11.mActivePointerId
            int r10 = android.support.p000v4.view.MotionEventCompat.findPointerIndex(r10, r11)
            r3 = r10
            r10 = r3
            if (r10 >= 0) goto L_0x00b6
            java.lang.String r10 = LOG_TAG
            java.lang.String r11 = "Got ACTION_UP event but don't have an active pointer id."
            int r10 = android.util.Log.e(r10, r11)
            r10 = 0
            r0 = r10
            goto L_0x002e
        L_0x00b6:
            r10 = 1056964608(0x3f000000, float:0.5)
            r11 = r1
            r12 = r3
            float r11 = android.support.p000v4.view.MotionEventCompat.getY(r11, r12)
            r12 = r0
            float r12 = r12.mInitialMotionY
            float r11 = r11 - r12
            float r10 = r10 * r11
            r4 = r10
            r10 = r0
            r11 = 0
            r10.mIsBeingDragged = r11
            r10 = r0
            r11 = r4
            r10.finishSpinner(r11)
            r10 = r0
            r11 = -1
            r10.mActivePointerId = r11
            r10 = 0
            r0 = r10
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SwipeRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        boolean z2 = z;
        if (VERSION.SDK_INT < 21 && (this.mTarget instanceof AbsListView)) {
            return;
        }
        if (this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    @ColorInt
    public void setColorSchemeColors(int... iArr) {
        int[] iArr2 = iArr;
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr2);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        int[] iArr2 = iArr;
        Resources resources = getResources();
        int[] iArr3 = new int[iArr2.length];
        for (int i = 0; i < iArr2.length; i++) {
            iArr3[i] = resources.getColor(iArr2[i]);
        }
        setColorSchemeColors(iArr3);
    }

    public void setDistanceToTriggerSync(int i) {
        float f = (float) i;
        this.mTotalDragDistance = f;
    }

    public void setNestedScrollingEnabled(boolean z) {
        boolean z2 = z;
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z2);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        OnRefreshListener onRefreshListener2 = onRefreshListener;
        this.mListener = onRefreshListener2;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        int i2 = i;
        this.mCircleView.setBackgroundColor(i2);
        this.mProgress.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        boolean z2 = z;
        this.mSpinnerFinalOffset = (float) i;
        this.mScale = z2;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.mScale = z;
        this.mCircleView.setVisibility(8);
        this.mCurrentTargetOffsetTop = i3;
        this.mOriginalOffsetTop = i3;
        this.mSpinnerFinalOffset = (float) i4;
        this.mUsingCustomStart = true;
        this.mCircleView.invalidate();
    }

    public void setRefreshing(boolean z) {
        boolean z2 = z;
        if (!z2 || this.mRefreshing == z2) {
            setRefreshing(z2, false);
            return;
        }
        this.mRefreshing = z2;
        setTargetOffsetTopAndBottom((!this.mUsingCustomStart ? (int) (this.mSpinnerFinalOffset + ((float) this.mOriginalOffsetTop)) : (int) this.mSpinnerFinalOffset) - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i) {
        int i2 = i;
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                int i3 = (int) (56.0f * displayMetrics.density);
                this.mCircleWidth = i3;
                this.mCircleHeight = i3;
            } else {
                int i4 = (int) (40.0f * displayMetrics.density);
                this.mCircleWidth = i4;
                this.mCircleHeight = i4;
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(i2);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }
}
