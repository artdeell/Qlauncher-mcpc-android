package android.support.p000v4.widget;

import android.content.Context;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.support.p000v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.ViewDragHelper */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator;
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.widget.ViewDragHelper$Callback */
    public static abstract class Callback {
        public Callback() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            View view2 = view;
            int i3 = i;
            int i4 = i2;
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            View view2 = view;
            int i3 = i;
            int i4 = i2;
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            View view2 = view;
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            View view2 = view;
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            int i2 = i;
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    static {
        C01511 r2;
        C01511 r0 = r2;
        C01511 r1 = new Interpolator() {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return 1.0f + (f2 * f2 * f2 * f2 * f2);
            }
        };
        sInterpolator = r0;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        C01522 r9;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Context context2 = context;
        ViewGroup viewGroup2 = viewGroup;
        Callback callback2 = callback;
        C01522 r6 = r9;
        C01522 r7 = new Runnable(this) {
            final /* synthetic */ ViewDragHelper this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.setDragState(0);
            }
        };
        this.mSetIdleRunnable = r6;
        if (viewGroup2 == null) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Parent view may not be null");
            throw illegalArgumentException3;
        } else if (callback2 == null) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Callback may not be null");
            throw illegalArgumentException5;
        } else {
            this.mParentView = viewGroup2;
            this.mCallback = callback2;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
            this.mEdgeSize = (int) (0.5f + (20.0f * context2.getResources().getDisplayMetrics().density));
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = ScrollerCompat.create(context2, sInterpolator);
        }
    }

    private boolean checkNewEdgeDrag(float f, float f2, int i, int i2) {
        float f3 = f2;
        int i3 = i;
        int i4 = i2;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f3);
        if (!((i4 & this.mInitialEdgesTouched[i3]) != i4 || (i4 & this.mTrackingEdges) == 0 || (i4 & this.mEdgeDragsLocked[i3]) == i4 || (i4 & this.mEdgeDragsInProgress[i3]) == i4 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop)))) {
            if (abs < 0.5f * abs2 && this.mCallback.onEdgeLock(i4)) {
                int[] iArr = this.mEdgeDragsLocked;
                iArr[i3] = i4 | iArr[i3];
                return false;
            } else if ((i4 & this.mEdgeDragsInProgress[i3]) == 0 && abs > ((float) this.mTouchSlop)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f, float f2) {
        View view2 = view;
        float f3 = f;
        float f4 = f2;
        boolean z = true;
        if (view2 == null) {
            z = false;
        } else {
            boolean z2 = this.mCallback.getViewHorizontalDragRange(view2) > 0;
            boolean z3 = this.mCallback.getViewVerticalDragRange(view2) > 0;
            if (!z2 || !z3) {
                if (z2) {
                    if (Math.abs(f3) <= ((float) this.mTouchSlop)) {
                        return false;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    if (Math.abs(f4) <= ((float) this.mTouchSlop)) {
                        return false;
                    }
                }
            } else if ((f3 * f3) + (f4 * f4) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
        }
        return z;
    }

    private float clampMag(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        float abs = Math.abs(f4);
        if (abs < f5) {
            f6 = 0.0f;
        } else if (abs <= f6) {
            return f4;
        } else {
            if (f4 <= 0.0f) {
                return -f6;
            }
        }
        return f6;
    }

    private int clampMag(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int abs = Math.abs(i4);
        if (abs < i5) {
            i6 = 0;
        } else if (abs <= i6) {
            return i4;
        } else {
            if (i4 <= 0) {
                return -i6;
            }
        }
        return i6;
    }

    private void clearMotionHistory() {
        if (this.mInitialMotionX != null) {
            Arrays.fill(this.mInitialMotionX, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private void clearMotionHistory(int i) {
        int i2 = i;
        if (this.mInitialMotionX != null) {
            this.mInitialMotionX[i2] = 0.0f;
            this.mInitialMotionY[i2] = 0.0f;
            this.mLastMotionX[i2] = 0.0f;
            this.mLastMotionY[i2] = 0.0f;
            this.mInitialEdgesTouched[i2] = 0;
            this.mEdgeDragsInProgress[i2] = 0;
            this.mEdgeDragsLocked[i2] = 0;
            this.mPointersDown &= -1 ^ (1 << i2);
        }
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i4 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        int i7 = width / 2;
        float distanceInfluenceForSnapDuration = ((float) i7) + (((float) i7) * distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i4)) / ((float) width))));
        int abs = Math.abs(i5);
        return Math.min(abs > 0 ? 4 * Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) : (int) (256.0f * (1.0f + (((float) Math.abs(i4)) / ((float) i6)))), MAX_SETTLE_DURATION);
    }

    private int computeSettleDuration(View view, int i, int i2, int i3, int i4) {
        View view2 = view;
        int i5 = i;
        int i6 = i2;
        int i7 = i4;
        int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i7, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        return (int) (((clampMag != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9)) * ((float) computeAxisDuration(i5, clampMag, this.mCallback.getViewHorizontalDragRange(view2)))) + ((clampMag2 != 0 ? ((float) abs4) / ((float) i8) : ((float) abs2) / ((float) i9)) * ((float) computeAxisDuration(i6, clampMag2, this.mCallback.getViewVerticalDragRange(view2)))));
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        float f2 = f;
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f2));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        ViewDragHelper viewDragHelper;
        ViewGroup viewGroup2 = viewGroup;
        ViewDragHelper viewDragHelper2 = viewDragHelper;
        ViewDragHelper viewDragHelper3 = new ViewDragHelper(viewGroup2.getContext(), viewGroup2, callback);
        return viewDragHelper2;
    }

    private void dispatchViewReleased(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f3, f4);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (0.4712389167638204d * ((double) (f - 0.5f)))));
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i7 != 0) {
            i9 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i5, i7);
            this.mCapturedView.offsetLeftAndRight(i9 - left);
        }
        if (i8 != 0) {
            i10 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i6, i8);
            this.mCapturedView.offsetTopAndBottom(i10 - top);
        }
        if (i7 != 0 || i8 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i9, i10, i9 - left, i10 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i) {
        int i2 = i;
        if (this.mInitialMotionX == null || this.mInitialMotionX.length <= i2) {
            float[] fArr = new float[(i2 + 1)];
            float[] fArr2 = new float[(i2 + 1)];
            float[] fArr3 = new float[(i2 + 1)];
            float[] fArr4 = new float[(i2 + 1)];
            int[] iArr = new int[(i2 + 1)];
            int[] iArr2 = new int[(i2 + 1)];
            int[] iArr3 = new int[(i2 + 1)];
            if (this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, fArr, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, fArr2, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, fArr3, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, fArr4, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, iArr, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, iArr2, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, iArr3, 0, this.mEdgeDragsLocked.length);
            }
            this.mInitialMotionX = fArr;
            this.mInitialMotionY = fArr2;
            this.mLastMotionX = fArr3;
            this.mLastMotionY = fArr4;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i9 = i5 - left;
        int i10 = i6 - top;
        if (i9 == 0 && i10 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i9, i10, computeSettleDuration(this.mCapturedView, i9, i10, i7, i8));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = 0;
        if (i3 < this.mParentView.getLeft() + this.mEdgeSize) {
            i5 = 0 | 1;
        }
        if (i4 < this.mParentView.getTop() + this.mEdgeSize) {
            i5 |= 4;
        }
        if (i3 > this.mParentView.getRight() - this.mEdgeSize) {
            i5 |= 2;
        }
        if (i4 > this.mParentView.getBottom() - this.mEdgeSize) {
            i5 |= 8;
        }
        return i5;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f, float f2, int i) {
        float f3 = f;
        float f4 = f2;
        int i2 = i;
        int i3 = 0;
        if (checkNewEdgeDrag(f3, f4, i2, 1)) {
            i3 = 0 | 1;
        }
        if (checkNewEdgeDrag(f4, f3, i2, 4)) {
            i3 |= 4;
        }
        if (checkNewEdgeDrag(f3, f4, i2, 2)) {
            i3 |= 2;
        }
        if (checkNewEdgeDrag(f4, f3, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i2] = i3 | iArr[i2];
            this.mCallback.onEdgeDragStarted(i3, i2);
        }
    }

    private void saveInitialMotion(float f, float f2, int i) {
        float f3 = f;
        float f4 = f2;
        int i2 = i;
        ensureMotionHistorySizeForId(i2);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i2] = f3;
        fArr[i2] = f3;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i2] = f4;
        fArr2[i2] = f4;
        this.mInitialEdgesTouched[i2] = getEdgesTouched((int) f3, (int) f4);
        this.mPointersDown |= 1 << i2;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent2);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent2, i);
            float x = MotionEventCompat.getX(motionEvent2, i);
            float y = MotionEventCompat.getY(motionEvent2, i);
            this.mLastMotionX[pointerId] = x;
            this.mLastMotionY[pointerId] = y;
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        View view2 = view;
        boolean z2 = z;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = -1 + viewGroup.getChildCount(); childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i7 + scrollX >= childAt.getLeft() && i7 + scrollX < childAt.getRight() && i8 + scrollY >= childAt.getTop() && i8 + scrollY < childAt.getBottom() && canScroll(childAt, true, i5, i6, (i7 + scrollX) - childAt.getLeft(), (i8 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && (ViewCompat.canScrollHorizontally(view2, -i5) || ViewCompat.canScrollVertically(view2, -i6));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        View view2 = view;
        int i2 = i;
        if (view2.getParent() != this.mParentView) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (").append(this.mParentView).append(")").toString());
            throw illegalArgumentException2;
        }
        this.mCapturedView = view2;
        this.mActivePointerId = i2;
        this.mCallback.onViewCaptured(view2, i2);
        setDragState(1);
    }

    public boolean checkTouchSlop(int i) {
        int i2 = i;
        int length = this.mInitialMotionX.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (checkTouchSlop(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        boolean z = true;
        if (!isPointerDown(i4)) {
            z = false;
        } else {
            boolean z2 = (i3 & 1) == 1;
            boolean z3 = (i3 & 2) == 2;
            float f = this.mLastMotionX[i4] - this.mInitialMotionX[i4];
            float f2 = this.mLastMotionY[i4] - this.mInitialMotionY[i4];
            if (!z2 || !z3) {
                if (z2) {
                    if (Math.abs(f) <= ((float) this.mTouchSlop)) {
                        return false;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    if (Math.abs(f2) <= ((float) this.mTouchSlop)) {
                        return false;
                    }
                }
            } else if ((f * f) + (f2 * f2) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
        }
        return z;
    }

    public boolean continueSettling(boolean z) {
        boolean z2 = z;
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                this.mCapturedView.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.mCapturedView.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z2) {
                    boolean post = this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        for (int childCount = -1 + this.mParentView.getChildCount(); childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        IllegalStateException illegalStateException;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (!this.mReleaseInProgress) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
            throw illegalStateException2;
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), i5, i7, i6, i8);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.mCapturedView, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int i2 = i;
        int length = this.mInitialEdgesTouched.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (isEdgeTouched(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        int i3 = i2;
        return isPointerDown(i3) && (i & this.mInitialEdgesTouched[i3]) != 0;
    }

    public boolean isPointerDown(int i) {
        return (this.mPointersDown & (1 << i)) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        View view2 = view;
        int i3 = i;
        int i4 = i2;
        return view2 != null && i3 >= view2.getLeft() && i3 < view2.getRight() && i4 >= view2.getTop() && i4 < view2.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent2);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent2);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        switch (actionMasked) {
            case 0:
                float x = motionEvent2.getX();
                float y = motionEvent2.getY();
                int pointerId = MotionEventCompat.getPointerId(motionEvent2, 0);
                View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                saveInitialMotion(x, y, pointerId);
                boolean tryCaptureViewForDrag = tryCaptureViewForDrag(findTopChildUnder, pointerId);
                int i = this.mInitialEdgesTouched[pointerId];
                if ((i & this.mTrackingEdges) != 0) {
                    this.mCallback.onEdgeTouched(i & this.mTrackingEdges, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.mDragState == 1) {
                    releaseViewForPointerUp();
                }
                cancel();
                return;
            case 2:
                if (this.mDragState == 1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, this.mActivePointerId);
                    float x2 = MotionEventCompat.getX(motionEvent2, findPointerIndex);
                    int i2 = (int) (x2 - this.mLastMotionX[this.mActivePointerId]);
                    int y2 = (int) (MotionEventCompat.getY(motionEvent2, findPointerIndex) - this.mLastMotionY[this.mActivePointerId]);
                    dragTo(i2 + this.mCapturedView.getLeft(), y2 + this.mCapturedView.getTop(), i2, y2);
                    saveLastMotion(motionEvent2);
                    return;
                }
                int pointerCount = MotionEventCompat.getPointerCount(motionEvent2);
                int i3 = 0;
                while (i3 < pointerCount) {
                    int pointerId2 = MotionEventCompat.getPointerId(motionEvent2, i3);
                    float x3 = MotionEventCompat.getX(motionEvent2, i3);
                    float y3 = MotionEventCompat.getY(motionEvent2, i3);
                    float f = x3 - this.mInitialMotionX[pointerId2];
                    float f2 = y3 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f, f2, pointerId2);
                    if (this.mDragState != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (!checkTouchSlop(findTopChildUnder2, f, f2) || !tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            i3++;
                        }
                    }
                    saveLastMotion(motionEvent2);
                    return;
                }
                saveLastMotion(motionEvent2);
                return;
            case 3:
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent2, actionIndex);
                float x4 = MotionEventCompat.getX(motionEvent2, actionIndex);
                float y4 = MotionEventCompat.getY(motionEvent2, actionIndex);
                saveInitialMotion(x4, y4, pointerId3);
                if (this.mDragState == 0) {
                    boolean tryCaptureViewForDrag2 = tryCaptureViewForDrag(findTopChildUnder((int) x4, (int) y4), pointerId3);
                    int i4 = this.mInitialEdgesTouched[pointerId3];
                    if ((i4 & this.mTrackingEdges) != 0) {
                        this.mCallback.onEdgeTouched(i4 & this.mTrackingEdges, pointerId3);
                        return;
                    }
                    return;
                } else if (isCapturedViewUnder((int) x4, (int) y4)) {
                    boolean tryCaptureViewForDrag3 = tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = MotionEventCompat.getPointerId(motionEvent2, actionIndex);
                if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
                    int i5 = -1;
                    int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent2);
                    int i6 = 0;
                    while (true) {
                        if (i6 < pointerCount2) {
                            int pointerId5 = MotionEventCompat.getPointerId(motionEvent2, i6);
                            if (pointerId5 != this.mActivePointerId) {
                                if (findTopChildUnder((int) MotionEventCompat.getX(motionEvent2, i6), (int) MotionEventCompat.getY(motionEvent2, i6)) == this.mCapturedView) {
                                    if (tryCaptureViewForDrag(this.mCapturedView, pointerId5)) {
                                        i5 = this.mActivePointerId;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i5 == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId4);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setDragState(int i) {
        int i2 = i;
        boolean removeCallbacks = this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i2) {
            this.mDragState = i2;
            this.mCallback.onViewDragStateChanged(i2);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        int i2 = i;
        this.mTrackingEdges = i2;
    }

    public void setMinVelocity(float f) {
        float f2 = f;
        this.mMinVelocity = f2;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        IllegalStateException illegalStateException;
        int i3 = i;
        int i4 = i2;
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i3, i4, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        throw illegalStateException2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x02ca, code lost:
        if (r17 != r15) goto L_0x02ed;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r39) {
        /*
            r38 = this;
            r2 = r38
            r3 = r39
            r34 = r3
            int r34 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r34)
            r4 = r34
            r34 = r3
            int r34 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r34)
            r5 = r34
            r34 = r4
            if (r34 != 0) goto L_0x001d
            r34 = r2
            r34.cancel()
        L_0x001d:
            r34 = r2
            r0 = r34
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r34 = r0
            if (r34 != 0) goto L_0x0033
            r34 = r2
            android.view.VelocityTracker r35 = android.view.VelocityTracker.obtain()
            r0 = r35
            r1 = r34
            r1.mVelocityTracker = r0
        L_0x0033:
            r34 = r2
            r0 = r34
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r34 = r0
            r35 = r3
            r34.addMovement(r35)
            r34 = r4
            switch(r34) {
                case 0: goto L_0x005a;
                case 1: goto L_0x032b;
                case 2: goto L_0x01a2;
                case 3: goto L_0x032b;
                case 4: goto L_0x0045;
                case 5: goto L_0x00f6;
                case 6: goto L_0x031c;
                default: goto L_0x0045;
            }
        L_0x0045:
            r34 = r2
            r0 = r34
            int r0 = r0.mDragState
            r34 = r0
            r35 = 1
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x0332
            r34 = 1
            r2 = r34
        L_0x0059:
            return r2
        L_0x005a:
            r34 = r3
            float r34 = r34.getX()
            r29 = r34
            r34 = r3
            float r34 = r34.getY()
            r30 = r34
            r34 = r3
            r35 = 0
            int r34 = android.support.p000v4.view.MotionEventCompat.getPointerId(r34, r35)
            r31 = r34
            r34 = r2
            r35 = r29
            r36 = r30
            r37 = r31
            r34.saveInitialMotion(r35, r36, r37)
            r34 = r2
            r35 = r29
            r0 = r35
            int r0 = (int) r0
            r35 = r0
            r36 = r30
            r0 = r36
            int r0 = (int) r0
            r36 = r0
            android.view.View r34 = r34.findTopChildUnder(r35, r36)
            r32 = r34
            r34 = r32
            r35 = r2
            r0 = r35
            android.view.View r0 = r0.mCapturedView
            r35 = r0
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x00bf
            r34 = r2
            r0 = r34
            int r0 = r0.mDragState
            r34 = r0
            r35 = 2
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x00bf
            r34 = r2
            r35 = r32
            r36 = r31
            boolean r34 = r34.tryCaptureViewForDrag(r35, r36)
        L_0x00bf:
            r34 = r2
            r0 = r34
            int[] r0 = r0.mInitialEdgesTouched
            r34 = r0
            r35 = r31
            r34 = r34[r35]
            r33 = r34
            r34 = r33
            r35 = r2
            r0 = r35
            int r0 = r0.mTrackingEdges
            r35 = r0
            r34 = r34 & r35
            if (r34 == 0) goto L_0x0045
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r33
            r36 = r2
            r0 = r36
            int r0 = r0.mTrackingEdges
            r36 = r0
            r35 = r35 & r36
            r36 = r31
            r34.onEdgeTouched(r35, r36)
            goto L_0x0045
        L_0x00f6:
            r34 = r3
            r35 = r5
            int r34 = android.support.p000v4.view.MotionEventCompat.getPointerId(r34, r35)
            r23 = r34
            r34 = r3
            r35 = r5
            float r34 = android.support.p000v4.view.MotionEventCompat.getX(r34, r35)
            r24 = r34
            r34 = r3
            r35 = r5
            float r34 = android.support.p000v4.view.MotionEventCompat.getY(r34, r35)
            r25 = r34
            r34 = r2
            r35 = r24
            r36 = r25
            r37 = r23
            r34.saveInitialMotion(r35, r36, r37)
            r34 = r2
            r0 = r34
            int r0 = r0.mDragState
            r34 = r0
            if (r34 != 0) goto L_0x0160
            r34 = r2
            r0 = r34
            int[] r0 = r0.mInitialEdgesTouched
            r34 = r0
            r35 = r23
            r34 = r34[r35]
            r28 = r34
            r34 = r28
            r35 = r2
            r0 = r35
            int r0 = r0.mTrackingEdges
            r35 = r0
            r34 = r34 & r35
            if (r34 == 0) goto L_0x0045
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r28
            r36 = r2
            r0 = r36
            int r0 = r0.mTrackingEdges
            r36 = r0
            r35 = r35 & r36
            r36 = r23
            r34.onEdgeTouched(r35, r36)
            goto L_0x0045
        L_0x0160:
            r34 = r2
            r0 = r34
            int r0 = r0.mDragState
            r34 = r0
            r35 = 2
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x0045
            r34 = r2
            r35 = r24
            r0 = r35
            int r0 = (int) r0
            r35 = r0
            r36 = r25
            r0 = r36
            int r0 = (int) r0
            r36 = r0
            android.view.View r34 = r34.findTopChildUnder(r35, r36)
            r26 = r34
            r34 = r26
            r35 = r2
            r0 = r35
            android.view.View r0 = r0.mCapturedView
            r35 = r0
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x0045
            r34 = r2
            r35 = r26
            r36 = r23
            boolean r34 = r34.tryCaptureViewForDrag(r35, r36)
            goto L_0x0045
        L_0x01a2:
            r34 = r2
            r0 = r34
            float[] r0 = r0.mInitialMotionX
            r34 = r0
            if (r34 == 0) goto L_0x0045
            r34 = r2
            r0 = r34
            float[] r0 = r0.mInitialMotionY
            r34 = r0
            if (r34 == 0) goto L_0x0045
            r34 = r3
            int r34 = android.support.p000v4.view.MotionEventCompat.getPointerCount(r34)
            r6 = r34
            r34 = 0
            r7 = r34
        L_0x01c2:
            r34 = r7
            r35 = r6
            r0 = r34
            r1 = r35
            if (r0 >= r1) goto L_0x02de
            r34 = r3
            r35 = r7
            int r34 = android.support.p000v4.view.MotionEventCompat.getPointerId(r34, r35)
            r8 = r34
            r34 = r3
            r35 = r7
            float r34 = android.support.p000v4.view.MotionEventCompat.getX(r34, r35)
            r9 = r34
            r34 = r3
            r35 = r7
            float r34 = android.support.p000v4.view.MotionEventCompat.getY(r34, r35)
            r10 = r34
            r34 = r9
            r35 = r2
            r0 = r35
            float[] r0 = r0.mInitialMotionX
            r35 = r0
            r36 = r8
            r35 = r35[r36]
            float r34 = r34 - r35
            r11 = r34
            r34 = r10
            r35 = r2
            r0 = r35
            float[] r0 = r0.mInitialMotionY
            r35 = r0
            r36 = r8
            r35 = r35[r36]
            float r34 = r34 - r35
            r12 = r34
            r34 = r2
            r35 = r9
            r0 = r35
            int r0 = (int) r0
            r35 = r0
            r36 = r10
            r0 = r36
            int r0 = (int) r0
            r36 = r0
            android.view.View r34 = r34.findTopChildUnder(r35, r36)
            r13 = r34
            r34 = r13
            if (r34 == 0) goto L_0x02e7
            r34 = r2
            r35 = r13
            r36 = r11
            r37 = r12
            boolean r34 = r34.checkTouchSlop(r35, r36, r37)
            if (r34 == 0) goto L_0x02e7
            r34 = 1
            r14 = r34
        L_0x023a:
            r34 = r14
            if (r34 == 0) goto L_0x02ed
            r34 = r13
            int r34 = r34.getLeft()
            r15 = r34
            r34 = r15
            r35 = r11
            r0 = r35
            int r0 = (int) r0
            r35 = r0
            int r34 = r34 + r35
            r16 = r34
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r13
            r36 = r16
            r37 = r11
            r0 = r37
            int r0 = (int) r0
            r37 = r0
            int r34 = r34.clampViewPositionHorizontal(r35, r36, r37)
            r17 = r34
            r34 = r13
            int r34 = r34.getTop()
            r18 = r34
            r34 = r18
            r35 = r12
            r0 = r35
            int r0 = (int) r0
            r35 = r0
            int r34 = r34 + r35
            r19 = r34
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r13
            r36 = r19
            r37 = r12
            r0 = r37
            int r0 = (int) r0
            r37 = r0
            int r34 = r34.clampViewPositionVertical(r35, r36, r37)
            r20 = r34
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r13
            int r34 = r34.getViewHorizontalDragRange(r35)
            r21 = r34
            r34 = r2
            r0 = r34
            android.support.v4.widget.ViewDragHelper$Callback r0 = r0.mCallback
            r34 = r0
            r35 = r13
            int r34 = r34.getViewVerticalDragRange(r35)
            r22 = r34
            r34 = r21
            if (r34 == 0) goto L_0x02cc
            r34 = r21
            if (r34 <= 0) goto L_0x02ed
            r34 = r17
            r35 = r15
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x02ed
        L_0x02cc:
            r34 = r22
            if (r34 == 0) goto L_0x02de
            r34 = r22
            if (r34 <= 0) goto L_0x02ed
            r34 = r20
            r35 = r18
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x02ed
        L_0x02de:
            r34 = r2
            r35 = r3
            r34.saveLastMotion(r35)
            goto L_0x0045
        L_0x02e7:
            r34 = 0
            r14 = r34
            goto L_0x023a
        L_0x02ed:
            r34 = r2
            r35 = r11
            r36 = r12
            r37 = r8
            r34.reportNewEdgeDrags(r35, r36, r37)
            r34 = r2
            r0 = r34
            int r0 = r0.mDragState
            r34 = r0
            r35 = 1
            r0 = r34
            r1 = r35
            if (r0 == r1) goto L_0x02de
            r34 = r14
            if (r34 == 0) goto L_0x0318
            r34 = r2
            r35 = r13
            r36 = r8
            boolean r34 = r34.tryCaptureViewForDrag(r35, r36)
            if (r34 != 0) goto L_0x02de
        L_0x0318:
            int r7 = r7 + 1
            goto L_0x01c2
        L_0x031c:
            r34 = r2
            r35 = r3
            r36 = r5
            int r35 = android.support.p000v4.view.MotionEventCompat.getPointerId(r35, r36)
            r34.clearMotionHistory(r35)
            goto L_0x0045
        L_0x032b:
            r34 = r2
            r34.cancel()
            goto L_0x0045
        L_0x0332:
            r34 = 0
            r2 = r34
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i3, i4, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    /* access modifiers changed from: 0000 */
    public boolean tryCaptureViewForDrag(View view, int i) {
        View view2 = view;
        int i2 = i;
        if (view2 == this.mCapturedView && this.mActivePointerId == i2) {
            return true;
        }
        if (view2 == null || !this.mCallback.tryCaptureView(view2, i2)) {
            return false;
        }
        this.mActivePointerId = i2;
        captureChildView(view2, i2);
        return true;
    }
}
