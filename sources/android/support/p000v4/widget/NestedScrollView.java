package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingChild;
import android.support.p000v4.view.NestedScrollingChildHelper;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.ScrollingView;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.NestedScrollView */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent, NestedScrollingChild, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffectCompat mEdgeGlowBottom;
    private EdgeEffectCompat mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private ScrollerCompat mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    /* renamed from: android.support.v4.widget.NestedScrollView$AccessibilityDelegate */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent2);
            NestedScrollView nestedScrollView = (NestedScrollView) view2;
            accessibilityEvent2.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent2);
            asRecord.setScrollable(nestedScrollView.getScrollRange() > 0);
            asRecord.setScrollX(nestedScrollView.getScrollX());
            asRecord.setScrollY(nestedScrollView.getScrollY());
            asRecord.setMaxScrollX(nestedScrollView.getScrollX());
            asRecord.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            View view2 = view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat2);
            NestedScrollView nestedScrollView = (NestedScrollView) view2;
            accessibilityNodeInfoCompat2.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int access$000 = nestedScrollView.getScrollRange();
                if (access$000 > 0) {
                    accessibilityNodeInfoCompat2.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat2.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < access$000) {
                        accessibilityNodeInfoCompat2.addAction(4096);
                    }
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            View view2 = view;
            int i2 = i;
            if (super.performAccessibilityAction(view2, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view2;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            switch (i2) {
                case 4096:
                    int min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, min);
                    return true;
                case 8192:
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$OnScrollChangeListener */
    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public int scrollPosition;

        static {
            C01361 r2;
            C01361 r0 = r2;
            C01361 r1 = new Creator<SavedState>() {
                public SavedState createFromParcel(Parcel parcel) {
                    SavedState savedState;
                    SavedState savedState2 = savedState;
                    SavedState savedState3 = new SavedState(parcel);
                    return savedState2;
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            CREATOR = r0;
        }

        public SavedState(Parcel parcel) {
            Parcel parcel2 = parcel;
            super(parcel2);
            this.scrollPosition = parcel2.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("HorizontalScrollView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" scrollPosition=").append(this.scrollPosition).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            super.writeToParcel(parcel2, i);
            parcel2.writeInt(this.scrollPosition);
        }
    }

    static {
        AccessibilityDelegate accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate2 = accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate3 = new AccessibilityDelegate();
        ACCESSIBILITY_DELEGATE = accessibilityDelegate2;
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16843130;
        SCROLLVIEW_STYLEABLE = iArr2;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        Rect rect;
        NestedScrollingParentHelper nestedScrollingParentHelper;
        NestedScrollingChildHelper nestedScrollingChildHelper;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        super(context2, attributeSet2, i2);
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        this.mTempRect = rect2;
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, SCROLLVIEW_STYLEABLE, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        NestedScrollingParentHelper nestedScrollingParentHelper2 = nestedScrollingParentHelper;
        NestedScrollingParentHelper nestedScrollingParentHelper3 = new NestedScrollingParentHelper(this);
        this.mParentHelper = nestedScrollingParentHelper2;
        NestedScrollingChildHelper nestedScrollingChildHelper2 = nestedScrollingChildHelper;
        NestedScrollingChildHelper nestedScrollingChildHelper3 = new NestedScrollingChildHelper(this);
        this.mChildHelper = nestedScrollingChildHelper2;
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private boolean canScroll() {
        View childAt = getChildAt(0);
        boolean z = false;
        if (childAt != null) {
            int height = childAt.getHeight();
            z = false;
            if (getHeight() < height + getPaddingTop() + getPaddingBottom()) {
                z = true;
            }
        }
        return z;
    }

    private static int clamp(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i5 >= i6 || i4 < 0) {
            i4 = 0;
        } else if (i5 + i4 > i6) {
            return i6 - i5;
        }
        return i4;
    }

    private void doScrollY(int i) {
        int i2 = i;
        if (i2 == 0) {
            return;
        }
        if (this.mSmoothScrollingEnabled) {
            smoothScrollBy(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll();
        if (this.mEdgeGlowTop != null) {
            boolean onRelease = this.mEdgeGlowTop.onRelease();
            boolean onRelease2 = this.mEdgeGlowBottom.onRelease();
        }
    }

    private void ensureGlows() {
        EdgeEffectCompat edgeEffectCompat;
        EdgeEffectCompat edgeEffectCompat2;
        if (ViewCompat.getOverScrollMode(this) == 2) {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        } else if (this.mEdgeGlowTop == null) {
            Context context = getContext();
            EdgeEffectCompat edgeEffectCompat3 = edgeEffectCompat;
            EdgeEffectCompat edgeEffectCompat4 = new EdgeEffectCompat(context);
            this.mEdgeGlowTop = edgeEffectCompat3;
            EdgeEffectCompat edgeEffectCompat5 = edgeEffectCompat2;
            EdgeEffectCompat edgeEffectCompat6 = new EdgeEffectCompat(context);
            this.mEdgeGlowBottom = edgeEffectCompat5;
        }
    }

    private View findFocusableViewInBounds(boolean z, int i, int i2) {
        boolean z2 = z;
        int i3 = i;
        int i4 = i2;
        ArrayList focusables = getFocusables(2);
        View view = null;
        boolean z3 = false;
        int size = focusables.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z4 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private void flingWithNestedDispatch(int i) {
        int i2 = i;
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i2 > 0) && (scrollY < getScrollRange() || i2 < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i2)) {
            boolean dispatchNestedFling = dispatchNestedFling(0.0f, (float) i2, z);
            if (z) {
                fling(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public int getScrollRange() {
        int i = 0;
        if (getChildCount() > 0) {
            i = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return i;
    }

    private float getVerticalScrollFactorCompat() {
        TypedValue typedValue;
        IllegalStateException illegalStateException;
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue2 = typedValue;
            TypedValue typedValue3 = new TypedValue();
            TypedValue typedValue4 = typedValue2;
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue4, true)) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                throw illegalStateException2;
            }
            this.mVerticalScrollFactor = typedValue4.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        boolean z = false;
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            z = false;
            if (i4 >= childAt.getTop() - scrollY) {
                z = false;
                if (i4 < childAt.getBottom() - scrollY) {
                    z = false;
                    if (i3 >= childAt.getLeft()) {
                        z = false;
                        if (i3 < childAt.getRight()) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            return;
        }
        this.mVelocityTracker.clear();
    }

    private void initScrollView() {
        ScrollerCompat scrollerCompat;
        ScrollerCompat scrollerCompat2 = scrollerCompat;
        ScrollerCompat scrollerCompat3 = new ScrollerCompat(getContext(), null);
        this.mScroller = scrollerCompat2;
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        boolean z = false;
        if (!isWithinDeltaOfScreen(view, 0, getHeight())) {
            z = true;
        }
        return z;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        View view3 = view;
        View view4 = view2;
        if (view3 != view4) {
            ViewParent parent = view3.getParent();
            if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View) parent, view4)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        View view2 = view;
        int i3 = i;
        int i4 = i2;
        view2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
        return i3 + this.mTempRect.bottom >= getScrollY() && this.mTempRect.top - i3 <= i4 + getScrollY();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = (65280 & motionEvent2.getAction()) >> 8;
        if (MotionEventCompat.getPointerId(motionEvent2, action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.mLastMotionY = (int) MotionEventCompat.getY(motionEvent2, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean scrollAndFocus(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        boolean z = true;
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = scrollY + height;
        boolean z2 = i4 == 33;
        View findFocusableViewInBounds = findFocusableViewInBounds(z2, i5, i6);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i5 < scrollY || i6 > i7) {
            doScrollY(z2 ? i5 - scrollY : i6 - i7);
        } else {
            z = false;
        }
        if (findFocusableViewInBounds != findFocus()) {
            boolean requestFocus = findFocusableViewInBounds.requestFocus(i4);
        }
        return z;
    }

    private void scrollToChild(View view) {
        View view2 = view;
        view2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        boolean z2 = z;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z3 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                return z3;
            }
        }
        return z3;
    }

    public void addView(View view) {
        IllegalStateException illegalStateException;
        View view2 = view;
        if (getChildCount() > 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("ScrollView can host only one direct child");
            throw illegalStateException2;
        }
        super.addView(view2);
    }

    public void addView(View view, int i) {
        IllegalStateException illegalStateException;
        View view2 = view;
        int i2 = i;
        if (getChildCount() > 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("ScrollView can host only one direct child");
            throw illegalStateException2;
        }
        super.addView(view2, i2);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        IllegalStateException illegalStateException;
        View view2 = view;
        int i2 = i;
        LayoutParams layoutParams2 = layoutParams;
        if (getChildCount() > 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("ScrollView can host only one direct child");
            throw illegalStateException2;
        }
        super.addView(view2, i2, layoutParams2);
    }

    public void addView(View view, LayoutParams layoutParams) {
        IllegalStateException illegalStateException;
        View view2 = view;
        LayoutParams layoutParams2 = layoutParams;
        if (getChildCount() > 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("ScrollView can host only one direct child");
            throw illegalStateException2;
        }
        super.addView(view2, layoutParams2);
    }

    public boolean arrowScroll(int i) {
        boolean z;
        int i2 = i;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            int i3 = maxScrollAmount;
            if (i2 == 33 && getScrollY() < i3) {
                i3 = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    i3 = bottom - scrollY;
                }
            }
            z = false;
            if (i3 != 0) {
                doScrollY(i2 == 130 ? i3 : -i3);
            }
            return z;
        }
        findNextFocus.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        boolean requestFocus = findNextFocus.requestFocus(i2);
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            boolean requestFocus2 = requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        z = true;
        return z;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        boolean z = true;
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = ViewCompat.getOverScrollMode(this);
                if (overScrollMode != 0 && (overScrollMode != 1 || scrollRange <= 0)) {
                    z = false;
                }
                boolean overScrollByCompat = overScrollByCompat(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (z) {
                    ensureGlows();
                    if (currY <= 0 && scrollY > 0) {
                        boolean onAbsorb = this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        boolean onAbsorb2 = this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        Rect rect2 = rect;
        if (getChildCount() != 0) {
            int height = getHeight();
            int scrollY = getScrollY();
            int i = scrollY + height;
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (rect2.top > 0) {
                scrollY += verticalFadingEdgeLength;
            }
            if (rect2.bottom < getChildAt(0).getHeight()) {
                i -= verticalFadingEdgeLength;
            }
            if (rect2.bottom > i && rect2.top > scrollY) {
                return Math.min(rect2.height() > height ? 0 + (rect2.top - scrollY) : 0 + (rect2.bottom - i), getChildAt(0).getBottom() - i);
            } else if (rect2.top < scrollY && rect2.bottom < i) {
                return Math.max(rect2.height() > height ? 0 - (i - rect2.bottom) : 0 - (scrollY - rect2.top), -getScrollY());
            }
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        return super.dispatchKeyEvent(keyEvent2) || executeKeyEvent(keyEvent2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.draw(canvas2);
        if (this.mEdgeGlowTop != null) {
            int scrollY = getScrollY();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas2.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas2.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.mEdgeGlowTop.setSize(width, getHeight());
                if (this.mEdgeGlowTop.draw(canvas2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas2.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                int save2 = canvas2.save();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas2.translate((float) ((-width2) + getPaddingLeft()), (float) (height + Math.max(getScrollRange(), scrollY)));
                canvas2.rotate(180.0f, (float) width2, 0.0f);
                this.mEdgeGlowBottom.setSize(width2, height);
                if (this.mEdgeGlowBottom.draw(canvas2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas2.restoreToCount(save2);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        this.mTempRect.setEmpty();
        if (!canScroll()) {
            boolean z = false;
            if (isFocused()) {
                z = false;
                if (keyEvent2.getKeyCode() != 4) {
                    View findFocus = findFocus();
                    if (findFocus == this) {
                        findFocus = null;
                    }
                    View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                    z = false;
                    if (findNextFocus != null) {
                        z = false;
                        if (findNextFocus != this) {
                            z = false;
                            if (findNextFocus.requestFocus(130)) {
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        }
        boolean z2 = false;
        if (keyEvent2.getAction() == 0) {
            z2 = false;
            switch (keyEvent2.getKeyCode()) {
                case 19:
                    if (keyEvent2.isAltPressed()) {
                        z2 = fullScroll(33);
                        break;
                    } else {
                        z2 = arrowScroll(33);
                        break;
                    }
                case 20:
                    if (keyEvent2.isAltPressed()) {
                        z2 = fullScroll(130);
                        break;
                    } else {
                        z2 = arrowScroll(130);
                        break;
                    }
                case 62:
                    boolean pageScroll = pageScroll(keyEvent2.isShiftPressed() ? 33 : 130);
                    z2 = false;
                    break;
            }
        }
        return z2;
    }

    public void fling(int i) {
        int i2 = i;
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, height / 2);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean fullScroll(int i) {
        int i2 = i;
        boolean z = i2 == 130;
        int height = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = height;
        if (z) {
            int childCount = getChildCount();
            if (childCount > 0) {
                this.mTempRect.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
                this.mTempRect.top = this.mTempRect.bottom - height;
            }
        }
        return scrollAndFocus(i2, this.mTempRect.top, this.mTempRect.bottom);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        View view2 = view;
        int i3 = i2;
        view2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view2.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        View view2 = view;
        int i5 = i3;
        int i6 = i4;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view2.getLayoutParams();
        view2.measure(getChildMeasureSpec(i, i2 + getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if ((2 & MotionEventCompat.getSource(motionEvent2)) != 0) {
            switch (motionEvent2.getAction()) {
                case 8:
                    if (!this.mIsBeingDragged) {
                        float axisValue = MotionEventCompat.getAxisValue(motionEvent2, 9);
                        if (axisValue != 0.0f) {
                            int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                            int scrollRange = getScrollRange();
                            int scrollY = getScrollY();
                            int i = scrollY - verticalScrollFactorCompat;
                            if (i < 0) {
                                i = 0;
                            } else if (i > scrollRange) {
                                i = scrollRange;
                            }
                            if (i != scrollY) {
                                super.scrollTo(getScrollX(), i);
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        StringBuilder sb;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent2.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent2.getY();
                if (inChild((int) motionEvent2.getX(), y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, 0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent2);
                    boolean z = false;
                    if (!this.mScroller.isFinished()) {
                        z = true;
                    }
                    this.mIsBeingDragged = z;
                    boolean startNestedScroll = startNestedScroll(2);
                    break;
                } else {
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                stopNestedScroll();
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, i);
                    if (findPointerIndex != -1) {
                        int y2 = (int) MotionEventCompat.getY(motionEvent2, findPointerIndex);
                        if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = y2;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent2);
                            this.mNestedYOffset = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    } else {
                        String str = TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int e = Log.e(str, sb2.append("Invalid pointerId=").append(i).append(" in onInterceptTouchEvent").toString());
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent2);
                break;
        }
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i4;
        super.onLayout(z, i, i5, i3, i6);
        this.mIsLayoutDirty = false;
        if (this.mChildToScrollTo != null && isViewDescendantOf(this.mChildToScrollTo, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i6 - i5) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        super.onMeasure(i3, i4);
        if (this.mFillViewport && MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), IDirectInputDevice.DIEP_NORESTART));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        View view2 = view;
        float f3 = f;
        float f4 = f2;
        if (z) {
            return false;
        }
        flingWithNestedDispatch((int) f4);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        View view2 = view;
        float f3 = f;
        float f4 = f2;
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        View view2 = view;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int scrollY = getScrollY();
        scrollBy(0, i8);
        int scrollY2 = getScrollY() - scrollY;
        boolean dispatchNestedScroll = dispatchNestedScroll(0, scrollY2, 0, i8 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        boolean startNestedScroll = startNestedScroll(2);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        boolean z3 = z;
        boolean z4 = z2;
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2 = i;
        Rect rect2 = rect;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        View findNextFocusFromRect = rect2 == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect2, i2);
        if (findNextFocusFromRect != null && !isOffScreen(findNextFocusFromRect)) {
            return findNextFocusFromRect.requestFocus(i2, rect2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        SavedState savedState2 = savedState;
        SavedState savedState3 = new SavedState(super.onSaveInstanceState());
        SavedState savedState4 = savedState2;
        savedState4.scrollPosition = getScrollY();
        return savedState4;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        super.onScrollChanged(i5, i6, i7, i8);
        if (this.mOnScrollChangeListener != null) {
            this.mOnScrollChangeListener.onScrollChange(this, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i4;
        super.onSizeChanged(i, i2, i3, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        View view3 = view;
        View view4 = view2;
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mParentHelper.onStopNestedScroll(view);
        stopNestedScroll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x03a0, code lost:
        if (r2.mEdgeGlowBottom.isFinished() == false) goto L_0x03a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r39) {
        /*
            r38 = this;
            r2 = r38
            r3 = r39
            r27 = r2
            r27.initVelocityTrackerIfNotExists()
            r27 = r3
            android.view.MotionEvent r27 = android.view.MotionEvent.obtain(r27)
            r4 = r27
            r27 = r3
            int r27 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r27)
            r5 = r27
            r27 = r5
            if (r27 != 0) goto L_0x0027
            r27 = r2
            r28 = 0
            r0 = r28
            r1 = r27
            r1.mNestedYOffset = r0
        L_0x0027:
            r27 = r4
            r28 = 0
            r29 = r2
            r0 = r29
            int r0 = r0.mNestedYOffset
            r29 = r0
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            r27.offsetLocation(r28, r29)
            r27 = r5
            switch(r27) {
                case 0: goto L_0x0061;
                case 1: goto L_0x0408;
                case 2: goto L_0x00ec;
                case 3: goto L_0x04a2;
                case 4: goto L_0x0040;
                case 5: goto L_0x04f0;
                case 6: goto L_0x051f;
                default: goto L_0x0040;
            }
        L_0x0040:
            r27 = r2
            r0 = r27
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r27 = r0
            if (r27 == 0) goto L_0x0057
            r27 = r2
            r0 = r27
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r27 = r0
            r28 = r4
            r27.addMovement(r28)
        L_0x0057:
            r27 = r4
            r27.recycle()
            r27 = 1
            r2 = r27
        L_0x0060:
            return r2
        L_0x0061:
            r27 = r2
            int r27 = r27.getChildCount()
            if (r27 != 0) goto L_0x006e
            r27 = 0
            r2 = r27
            goto L_0x0060
        L_0x006e:
            r27 = r2
            r0 = r27
            android.support.v4.widget.ScrollerCompat r0 = r0.mScroller
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 != 0) goto L_0x00e7
            r27 = 1
            r24 = r27
        L_0x0080:
            r27 = r2
            r28 = r24
            r0 = r28
            r1 = r27
            r1.mIsBeingDragged = r0
            r27 = r24
            if (r27 == 0) goto L_0x00a1
            r27 = r2
            android.view.ViewParent r27 = r27.getParent()
            r26 = r27
            r27 = r26
            if (r27 == 0) goto L_0x00a1
            r27 = r26
            r28 = 1
            r27.requestDisallowInterceptTouchEvent(r28)
        L_0x00a1:
            r27 = r2
            r0 = r27
            android.support.v4.widget.ScrollerCompat r0 = r0.mScroller
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 != 0) goto L_0x00ba
            r27 = r2
            r0 = r27
            android.support.v4.widget.ScrollerCompat r0 = r0.mScroller
            r27 = r0
            r27.abortAnimation()
        L_0x00ba:
            r27 = r2
            r28 = r3
            float r28 = r28.getY()
            r0 = r28
            int r0 = (int) r0
            r28 = r0
            r0 = r28
            r1 = r27
            r1.mLastMotionY = r0
            r27 = r2
            r28 = r3
            r29 = 0
            int r28 = android.support.p000v4.view.MotionEventCompat.getPointerId(r28, r29)
            r0 = r28
            r1 = r27
            r1.mActivePointerId = r0
            r27 = r2
            r28 = 2
            boolean r27 = r27.startNestedScroll(r28)
            goto L_0x0040
        L_0x00e7:
            r27 = 0
            r24 = r27
            goto L_0x0080
        L_0x00ec:
            r27 = r3
            r28 = r2
            r0 = r28
            int r0 = r0.mActivePointerId
            r28 = r0
            int r27 = android.support.p000v4.view.MotionEventCompat.findPointerIndex(r27, r28)
            r9 = r27
            r27 = r9
            r28 = -1
            r0 = r27
            r1 = r28
            if (r0 != r1) goto L_0x0135
            java.lang.String r27 = "NestedScrollView"
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r37 = r28
            r28 = r37
            r29 = r37
            r29.<init>()
            java.lang.String r29 = "Invalid pointerId="
            java.lang.StringBuilder r28 = r28.append(r29)
            r29 = r2
            r0 = r29
            int r0 = r0.mActivePointerId
            r29 = r0
            java.lang.StringBuilder r28 = r28.append(r29)
            java.lang.String r29 = " in onTouchEvent"
            java.lang.StringBuilder r28 = r28.append(r29)
            java.lang.String r28 = r28.toString()
            int r27 = android.util.Log.e(r27, r28)
            goto L_0x0040
        L_0x0135:
            r27 = r3
            r28 = r9
            float r27 = android.support.p000v4.view.MotionEventCompat.getY(r27, r28)
            r0 = r27
            int r0 = (int) r0
            r27 = r0
            r10 = r27
            r27 = r2
            r0 = r27
            int r0 = r0.mLastMotionY
            r27 = r0
            r28 = r10
            int r27 = r27 - r28
            r11 = r27
            r27 = r2
            r28 = 0
            r29 = r11
            r30 = r2
            r0 = r30
            int[] r0 = r0.mScrollConsumed
            r30 = r0
            r31 = r2
            r0 = r31
            int[] r0 = r0.mScrollOffset
            r31 = r0
            boolean r27 = r27.dispatchNestedPreScroll(r28, r29, r30, r31)
            if (r27 == 0) goto L_0x01b6
            r27 = r11
            r28 = r2
            r0 = r28
            int[] r0 = r0.mScrollConsumed
            r28 = r0
            r29 = 1
            r28 = r28[r29]
            int r27 = r27 - r28
            r11 = r27
            r27 = r4
            r28 = 0
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            r27.offsetLocation(r28, r29)
            r27 = r2
            r28 = r2
            r0 = r28
            int r0 = r0.mNestedYOffset
            r28 = r0
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            int r28 = r28 + r29
            r0 = r28
            r1 = r27
            r1.mNestedYOffset = r0
        L_0x01b6:
            r27 = r2
            r0 = r27
            boolean r0 = r0.mIsBeingDragged
            r27 = r0
            if (r27 != 0) goto L_0x0203
            r27 = r11
            int r27 = java.lang.Math.abs(r27)
            r28 = r2
            r0 = r28
            int r0 = r0.mTouchSlop
            r28 = r0
            r0 = r27
            r1 = r28
            if (r0 <= r1) goto L_0x0203
            r27 = r2
            android.view.ViewParent r27 = r27.getParent()
            r22 = r27
            r27 = r22
            if (r27 == 0) goto L_0x01e7
            r27 = r22
            r28 = 1
            r27.requestDisallowInterceptTouchEvent(r28)
        L_0x01e7:
            r27 = r2
            r28 = 1
            r0 = r28
            r1 = r27
            r1.mIsBeingDragged = r0
            r27 = r11
            if (r27 <= 0) goto L_0x0302
            r27 = r11
            r28 = r2
            r0 = r28
            int r0 = r0.mTouchSlop
            r28 = r0
            int r27 = r27 - r28
            r11 = r27
        L_0x0203:
            r27 = r2
            r0 = r27
            boolean r0 = r0.mIsBeingDragged
            r27 = r0
            if (r27 == 0) goto L_0x0040
            r27 = r2
            r28 = r10
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            int r28 = r28 - r29
            r0 = r28
            r1 = r27
            r1.mLastMotionY = r0
            r27 = r2
            int r27 = r27.getScrollY()
            r12 = r27
            r27 = r2
            int r27 = r27.getScrollRange()
            r13 = r27
            r27 = r2
            int r27 = android.support.p000v4.view.ViewCompat.getOverScrollMode(r27)
            r14 = r27
            r27 = r14
            if (r27 == 0) goto L_0x024f
            r27 = r14
            r28 = 1
            r0 = r27
            r1 = r28
            if (r0 != r1) goto L_0x0312
            r27 = r13
            if (r27 <= 0) goto L_0x0312
        L_0x024f:
            r27 = 1
            r15 = r27
        L_0x0253:
            r27 = r2
            r28 = 0
            r29 = r11
            r30 = 0
            r31 = r2
            int r31 = r31.getScrollY()
            r32 = 0
            r33 = r13
            r34 = 0
            r35 = 0
            r36 = 1
            boolean r27 = r27.overScrollByCompat(r28, r29, r30, r31, r32, r33, r34, r35, r36)
            if (r27 == 0) goto L_0x0284
            r27 = r2
            boolean r27 = r27.hasNestedScrollingParent()
            if (r27 != 0) goto L_0x0284
            r27 = r2
            r0 = r27
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r27 = r0
            r27.clear()
        L_0x0284:
            r27 = r2
            int r27 = r27.getScrollY()
            r28 = r12
            int r27 = r27 - r28
            r16 = r27
            r27 = r2
            r28 = 0
            r29 = r16
            r30 = 0
            r31 = r11
            r32 = r16
            int r31 = r31 - r32
            r32 = r2
            r0 = r32
            int[] r0 = r0.mScrollOffset
            r32 = r0
            boolean r27 = r27.dispatchNestedScroll(r28, r29, r30, r31, r32)
            if (r27 == 0) goto L_0x0318
            r27 = r2
            r28 = r2
            r0 = r28
            int r0 = r0.mLastMotionY
            r28 = r0
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            int r28 = r28 - r29
            r0 = r28
            r1 = r27
            r1.mLastMotionY = r0
            r27 = r4
            r28 = 0
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            r27.offsetLocation(r28, r29)
            r27 = r2
            r28 = r2
            r0 = r28
            int r0 = r0.mNestedYOffset
            r28 = r0
            r29 = r2
            r0 = r29
            int[] r0 = r0.mScrollOffset
            r29 = r0
            r30 = 1
            r29 = r29[r30]
            int r28 = r28 + r29
            r0 = r28
            r1 = r27
            r1.mNestedYOffset = r0
            goto L_0x0040
        L_0x0302:
            r27 = r11
            r28 = r2
            r0 = r28
            int r0 = r0.mTouchSlop
            r28 = r0
            int r27 = r27 + r28
            r11 = r27
            goto L_0x0203
        L_0x0312:
            r27 = 0
            r15 = r27
            goto L_0x0253
        L_0x0318:
            r27 = r15
            if (r27 == 0) goto L_0x0040
            r27 = r2
            r27.ensureGlows()
            r27 = r12
            r28 = r11
            int r27 = r27 + r28
            r17 = r27
            r27 = r17
            if (r27 >= 0) goto L_0x03a9
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowTop
            r27 = r0
            r28 = r11
            r0 = r28
            float r0 = (float) r0
            r28 = r0
            r29 = r2
            int r29 = r29.getHeight()
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            float r28 = r28 / r29
            r29 = r3
            r30 = r9
            float r29 = android.support.p000v4.view.MotionEventCompat.getX(r29, r30)
            r30 = r2
            int r30 = r30.getWidth()
            r0 = r30
            float r0 = (float) r0
            r30 = r0
            float r29 = r29 / r30
            boolean r27 = r27.onPull(r28, r29)
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowBottom
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 != 0) goto L_0x037c
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowBottom
            r27 = r0
            boolean r27 = r27.onRelease()
        L_0x037c:
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowTop
            r27 = r0
            if (r27 == 0) goto L_0x0040
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowTop
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 == 0) goto L_0x03a2
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowBottom
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 != 0) goto L_0x0040
        L_0x03a2:
            r27 = r2
            android.support.p000v4.view.ViewCompat.postInvalidateOnAnimation(r27)
            goto L_0x0040
        L_0x03a9:
            r27 = r17
            r28 = r13
            r0 = r27
            r1 = r28
            if (r0 <= r1) goto L_0x037c
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowBottom
            r27 = r0
            r28 = r11
            r0 = r28
            float r0 = (float) r0
            r28 = r0
            r29 = r2
            int r29 = r29.getHeight()
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            float r28 = r28 / r29
            r29 = 1065353216(0x3f800000, float:1.0)
            r30 = r3
            r31 = r9
            float r30 = android.support.p000v4.view.MotionEventCompat.getX(r30, r31)
            r31 = r2
            int r31 = r31.getWidth()
            r0 = r31
            float r0 = (float) r0
            r31 = r0
            float r30 = r30 / r31
            float r29 = r29 - r30
            boolean r27 = r27.onPull(r28, r29)
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowTop
            r27 = r0
            boolean r27 = r27.isFinished()
            if (r27 != 0) goto L_0x037c
            r27 = r2
            r0 = r27
            android.support.v4.widget.EdgeEffectCompat r0 = r0.mEdgeGlowTop
            r27 = r0
            boolean r27 = r27.onRelease()
            goto L_0x037c
        L_0x0408:
            r27 = r2
            r0 = r27
            boolean r0 = r0.mIsBeingDragged
            r27 = r0
            if (r27 == 0) goto L_0x0465
            r27 = r2
            r0 = r27
            android.view.VelocityTracker r0 = r0.mVelocityTracker
            r27 = r0
            r7 = r27
            r27 = r7
            r28 = 1000(0x3e8, float:1.401E-42)
            r29 = r2
            r0 = r29
            int r0 = r0.mMaximumVelocity
            r29 = r0
            r0 = r29
            float r0 = (float) r0
            r29 = r0
            r27.computeCurrentVelocity(r28, r29)
            r27 = r7
            r28 = r2
            r0 = r28
            int r0 = r0.mActivePointerId
            r28 = r0
            float r27 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r27, r28)
            r0 = r27
            int r0 = (int) r0
            r27 = r0
            r8 = r27
            r27 = r8
            int r27 = java.lang.Math.abs(r27)
            r28 = r2
            r0 = r28
            int r0 = r0.mMinimumVelocity
            r28 = r0
            r0 = r27
            r1 = r28
            if (r0 <= r1) goto L_0x0476
            r27 = r2
            r28 = r8
            r0 = r28
            int r0 = -r0
            r28 = r0
            r27.flingWithNestedDispatch(r28)
        L_0x0465:
            r27 = r2
            r28 = -1
            r0 = r28
            r1 = r27
            r1.mActivePointerId = r0
            r27 = r2
            r27.endDrag()
            goto L_0x0040
        L_0x0476:
            r27 = r2
            r0 = r27
            android.support.v4.widget.ScrollerCompat r0 = r0.mScroller
            r27 = r0
            r28 = r2
            int r28 = r28.getScrollX()
            r29 = r2
            int r29 = r29.getScrollY()
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = r2
            int r33 = r33.getScrollRange()
            boolean r27 = r27.springBack(r28, r29, r30, r31, r32, r33)
            if (r27 == 0) goto L_0x0465
            r27 = r2
            android.support.p000v4.view.ViewCompat.postInvalidateOnAnimation(r27)
            goto L_0x0465
        L_0x04a2:
            r27 = r2
            r0 = r27
            boolean r0 = r0.mIsBeingDragged
            r27 = r0
            if (r27 == 0) goto L_0x04df
            r27 = r2
            int r27 = r27.getChildCount()
            if (r27 <= 0) goto L_0x04df
            r27 = r2
            r0 = r27
            android.support.v4.widget.ScrollerCompat r0 = r0.mScroller
            r27 = r0
            r28 = r2
            int r28 = r28.getScrollX()
            r29 = r2
            int r29 = r29.getScrollY()
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = r2
            int r33 = r33.getScrollRange()
            boolean r27 = r27.springBack(r28, r29, r30, r31, r32, r33)
            if (r27 == 0) goto L_0x04df
            r27 = r2
            android.support.p000v4.view.ViewCompat.postInvalidateOnAnimation(r27)
        L_0x04df:
            r27 = r2
            r28 = -1
            r0 = r28
            r1 = r27
            r1.mActivePointerId = r0
            r27 = r2
            r27.endDrag()
            goto L_0x0040
        L_0x04f0:
            r27 = r3
            int r27 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r27)
            r6 = r27
            r27 = r2
            r28 = r3
            r29 = r6
            float r28 = android.support.p000v4.view.MotionEventCompat.getY(r28, r29)
            r0 = r28
            int r0 = (int) r0
            r28 = r0
            r0 = r28
            r1 = r27
            r1.mLastMotionY = r0
            r27 = r2
            r28 = r3
            r29 = r6
            int r28 = android.support.p000v4.view.MotionEventCompat.getPointerId(r28, r29)
            r0 = r28
            r1 = r27
            r1.mActivePointerId = r0
            goto L_0x0040
        L_0x051f:
            r27 = r2
            r28 = r3
            r27.onSecondaryPointerUp(r28)
            r27 = r2
            r28 = r3
            r29 = r3
            r30 = r2
            r0 = r30
            int r0 = r0.mActivePointerId
            r30 = r0
            int r29 = android.support.p000v4.view.MotionEventCompat.findPointerIndex(r29, r30)
            float r28 = android.support.p000v4.view.MotionEventCompat.getY(r28, r29)
            r0 = r28
            int r0 = (int) r0
            r28 = r0
            r0 = r28
            r1 = r27
            r1.mLastMotionY = r0
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    public boolean overScrollByCompat(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        boolean z4 = z;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i17 = i11 + i9;
        if (!z7) {
            i15 = 0;
        }
        int i18 = i12 + i10;
        if (!z8) {
            i16 = 0;
        }
        int i19 = -i15;
        int i20 = i15 + i13;
        int i21 = -i16;
        int i22 = i16 + i14;
        if (i17 > i20) {
            i17 = i20;
            z2 = true;
        } else {
            z2 = false;
            if (i17 < i19) {
                i17 = i19;
                z2 = true;
            }
        }
        if (i18 > i22) {
            i18 = i22;
            z3 = true;
        } else {
            z3 = false;
            if (i18 < i21) {
                i18 = i21;
                z3 = true;
            }
        }
        if (z3) {
            boolean springBack = this.mScroller.springBack(i17, i18, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i17, i18, z2, z3);
        return z2 || z3;
    }

    public boolean pageScroll(int i) {
        int i2 = i;
        boolean z = i2 == 130;
        int height = getHeight();
        if (z) {
            this.mTempRect.top = height + getScrollY();
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (height + this.mTempRect.top > childAt.getBottom()) {
                    this.mTempRect.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        this.mTempRect.bottom = height + this.mTempRect.top;
        return scrollAndFocus(i2, this.mTempRect.top, this.mTempRect.bottom);
    }

    public void requestChildFocus(View view, View view2) {
        View view3 = view;
        View view4 = view2;
        if (!this.mIsLayoutDirty) {
            scrollToChild(view4);
        } else {
            this.mChildToScrollTo = view4;
        }
        super.requestChildFocus(view3, view4);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        View view2 = view;
        Rect rect2 = rect;
        boolean z2 = z;
        rect2.offset(view2.getLeft() - view2.getScrollX(), view2.getTop() - view2.getScrollY());
        return scrollToChildRect(rect2, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        boolean z2 = z;
        if (z2) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i3, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i4, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        boolean z2 = z;
        if (z2 != this.mFillViewport) {
            this.mFillViewport = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        boolean z2 = z;
        this.mChildHelper.setNestedScrollingEnabled(z2);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        OnScrollChangeListener onScrollChangeListener2 = onScrollChangeListener;
        this.mOnScrollChangeListener = onScrollChangeListener2;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        boolean z2 = z;
        this.mSmoothScrollingEnabled = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i4, max)) - scrollY);
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                scrollBy(i3, i4);
            }
            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public boolean startNestedScroll(int i) {
        return this.mChildHelper.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }
}
