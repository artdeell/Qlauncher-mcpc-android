package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.KeyEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewGroupCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.p000v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.widget.DrawerLayout */
public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    private static final boolean ALLOW_EDGE_LOCK = false;
    /* access modifiers changed from: private */
    public static final boolean CAN_HIDE_DESCENDANTS = (VERSION.SDK_INT >= 19);
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final DrawerLayoutCompatImpl IMPL;
    /* access modifiers changed from: private */
    public static final int[] LAYOUT_ATTRS = {16842931};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    /* renamed from: android.support.v4.widget.DrawerLayout$AccessibilityDelegate */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ DrawerLayout this$0;

        AccessibilityDelegate(DrawerLayout drawerLayout) {
            Rect rect;
            this.this$0 = drawerLayout;
            Rect rect2 = rect;
            Rect rect3 = new Rect();
            this.mTmpRect = rect2;
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            ViewGroup viewGroup2 = viewGroup;
            int childCount = viewGroup2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup2.getChildAt(i);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    accessibilityNodeInfoCompat2.addChild(childAt);
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat4 = accessibilityNodeInfoCompat2;
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat4.getBoundsInParent(rect);
            accessibilityNodeInfoCompat3.setBoundsInParent(rect);
            accessibilityNodeInfoCompat4.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat3.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat3.setVisibleToUser(accessibilityNodeInfoCompat4.isVisibleToUser());
            accessibilityNodeInfoCompat3.setPackageName(accessibilityNodeInfoCompat4.getPackageName());
            accessibilityNodeInfoCompat3.setClassName(accessibilityNodeInfoCompat4.getClassName());
            accessibilityNodeInfoCompat3.setContentDescription(accessibilityNodeInfoCompat4.getContentDescription());
            accessibilityNodeInfoCompat3.setEnabled(accessibilityNodeInfoCompat4.isEnabled());
            accessibilityNodeInfoCompat3.setClickable(accessibilityNodeInfoCompat4.isClickable());
            accessibilityNodeInfoCompat3.setFocusable(accessibilityNodeInfoCompat4.isFocusable());
            accessibilityNodeInfoCompat3.setFocused(accessibilityNodeInfoCompat4.isFocused());
            accessibilityNodeInfoCompat3.setAccessibilityFocused(accessibilityNodeInfoCompat4.isAccessibilityFocused());
            accessibilityNodeInfoCompat3.setSelected(accessibilityNodeInfoCompat4.isSelected());
            accessibilityNodeInfoCompat3.setLongClickable(accessibilityNodeInfoCompat4.isLongClickable());
            accessibilityNodeInfoCompat3.addAction(accessibilityNodeInfoCompat4.getActions());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            if (accessibilityEvent2.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent2);
            }
            List text = accessibilityEvent2.getText();
            View access$300 = this.this$0.findVisibleDrawer();
            if (access$300 != null) {
                CharSequence drawerTitle = this.this$0.getDrawerTitle(this.this$0.getDrawerViewAbsoluteGravity(access$300));
                if (drawerTitle != null) {
                    boolean add = text.add(drawerTitle);
                }
            }
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent2);
            accessibilityEvent2.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            View view2 = view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat2);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat2);
                super.onInitializeAccessibilityNodeInfo(view2, obtain);
                accessibilityNodeInfoCompat2.setSource(view2);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view2);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat2.setParent((View) parentForAccessibility);
                }
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat2, obtain);
                obtain.recycle();
                addChildrenForAccessibility(accessibilityNodeInfoCompat2, (ViewGroup) view2);
            }
            accessibilityNodeInfoCompat2.setClassName(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat2.setFocusable(false);
            accessibilityNodeInfoCompat2.setFocused(false);
            boolean removeAction = accessibilityNodeInfoCompat2.removeAction(AccessibilityActionCompat.ACTION_FOCUS);
            boolean removeAction2 = accessibilityNodeInfoCompat2.removeAction(AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            ViewGroup viewGroup2 = viewGroup;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view2)) {
                return super.onRequestSendAccessibilityEvent(viewGroup2, view2, accessibilityEvent2);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$ChildAccessibilityDelegate */
    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout this$0;

        ChildAccessibilityDelegate(DrawerLayout drawerLayout) {
            this.this$0 = drawerLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            View view2 = view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat2);
            if (!DrawerLayout.includeChildForAccessibility(view2)) {
                accessibilityNodeInfoCompat2.setParent(null);
            }
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImpl */
    interface DrawerLayoutCompatImpl {
        void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void configureApplyInsets(View view);

        void dispatchChildInsets(View view, Object obj, int i);

        Drawable getDefaultStatusBarBackground(Context context);

        int getTopInset(Object obj);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImplApi21 */
    static class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplApi21() {
        }

        public void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            DrawerLayoutCompatApi21.applyMarginInsets(marginLayoutParams, obj, i);
        }

        public void configureApplyInsets(View view) {
            DrawerLayoutCompatApi21.configureApplyInsets(view);
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
            DrawerLayoutCompatApi21.dispatchChildInsets(view, obj, i);
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(context);
        }

        public int getTopInset(Object obj) {
            return DrawerLayoutCompatApi21.getTopInset(obj);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImplBase */
    static class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
        }

        public void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public void configureApplyInsets(View view) {
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            Context context2 = context;
            return null;
        }

        public int getTopInset(Object obj) {
            Object obj2 = obj;
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerListener */
    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.widget.DrawerLayout$EdgeGravity */
    private @interface EdgeGravity {
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        boolean isPeeking;
        boolean knownOpen;
        float onScreen;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            int i4 = i3;
            this(i, i2);
            this.gravity = i4;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            Context context2 = context;
            AttributeSet attributeSet2 = attributeSet;
            super(context2, attributeSet2);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            LayoutParams layoutParams2 = layoutParams;
            super(layoutParams2);
            this.gravity = 0;
            this.gravity = layoutParams2.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.widget.DrawerLayout$LockMode */
    private @interface LockMode {
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SavedState */
    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int lockModeLeft = 0;
        int lockModeRight = 0;
        int openDrawerGravity = 0;

        static {
            C01301 r2;
            C01301 r0 = r2;
            C01301 r1 = new Creator<SavedState>() {
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
            this.openDrawerGravity = parcel2.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            super.writeToParcel(parcel2, i);
            parcel2.writeInt(this.openDrawerGravity);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SimpleDrawerListener */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.widget.DrawerLayout$State */
    private @interface State {
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$ViewDragCallback */
    private class ViewDragCallback extends Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        public ViewDragCallback(DrawerLayout drawerLayout, int i) {
            C01311 r7;
            int i2 = i;
            this.this$0 = drawerLayout;
            C01311 r4 = r7;
            C01311 r5 = new Runnable(this) {
                final /* synthetic */ ViewDragCallback this$1;

                {
                    this.this$1 = r5;
                }

                public void run() {
                    this.this$1.peekDrawer();
                }
            };
            this.mPeekRunnable = r4;
            this.mAbsGravity = i2;
        }

        private void closeOtherDrawer() {
            int i = 3;
            if (this.mAbsGravity == 3) {
                i = 5;
            }
            View findDrawerWithGravity = this.this$0.findDrawerWithGravity(i);
            if (findDrawerWithGravity != null) {
                this.this$0.closeDrawer(findDrawerWithGravity);
            }
        }

        /* access modifiers changed from: private */
        public void peekDrawer() {
            View findDrawerWithGravity;
            int width;
            int edgeSize = this.mDragger.getEdgeSize();
            boolean z = this.mAbsGravity == 3;
            if (z) {
                findDrawerWithGravity = this.this$0.findDrawerWithGravity(3);
                int i = 0;
                if (findDrawerWithGravity != null) {
                    i = -findDrawerWithGravity.getWidth();
                }
                width = i + edgeSize;
            } else {
                findDrawerWithGravity = this.this$0.findDrawerWithGravity(5);
                width = this.this$0.getWidth() - edgeSize;
            }
            if (findDrawerWithGravity == null) {
                return;
            }
            if (((z && findDrawerWithGravity.getLeft() < width) || (!z && findDrawerWithGravity.getLeft() > width)) && this.this$0.getDrawerLockMode(findDrawerWithGravity) == 0) {
                LayoutParams layoutParams = (LayoutParams) findDrawerWithGravity.getLayoutParams();
                boolean smoothSlideViewTo = this.mDragger.smoothSlideViewTo(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
                layoutParams.isPeeking = true;
                this.this$0.invalidate();
                closeOtherDrawer();
                this.this$0.cancelChildViewTouch();
            }
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            View view2 = view;
            int i3 = i;
            int i4 = i2;
            if (this.this$0.checkDrawerViewAbsoluteGravity(view2, 3)) {
                return Math.max(-view2.getWidth(), Math.min(i3, 0));
            }
            int width = this.this$0.getWidth();
            return Math.max(width - view2.getWidth(), Math.min(i3, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            View view2 = view;
            if (this.this$0.isDrawerView(view2)) {
                return view2.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            int i3 = i2;
            View findDrawerWithGravity = (i & 1) == 1 ? this.this$0.findDrawerWithGravity(3) : this.this$0.findDrawerWithGravity(5);
            if (findDrawerWithGravity != null && this.this$0.getDrawerLockMode(findDrawerWithGravity) == 0) {
                this.mDragger.captureChildView(findDrawerWithGravity, i3);
            }
        }

        public boolean onEdgeLock(int i) {
            int i2 = i;
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            boolean postDelayed = this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        public void onViewCaptured(View view, int i) {
            int i2 = i;
            ((LayoutParams) view.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        public void onViewDragStateChanged(int i) {
            this.this$0.updateDrawerState(this.mAbsGravity, i, this.mDragger.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            View view2 = view;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            int width = view2.getWidth();
            float width2 = this.this$0.checkDrawerViewAbsoluteGravity(view2, 3) ? ((float) (width + i5)) / ((float) width) : ((float) (this.this$0.getWidth() - i5)) / ((float) width);
            this.this$0.setDrawerViewOffset(view2, width2);
            view2.setVisibility(width2 == 0.0f ? 4 : 0);
            this.this$0.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            View view2 = view;
            float f3 = f;
            float f4 = f2;
            float drawerViewOffset = this.this$0.getDrawerViewOffset(view2);
            int width = view2.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(view2, 3)) {
                i = (f3 > 0.0f || (f3 == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.this$0.getWidth();
                i = (f3 < 0.0f || (f3 == 0.0f && drawerViewOffset > 0.5f)) ? width2 - width : width2;
            }
            boolean z = this.mDragger.settleCapturedViewAt(i, view2.getTop());
            this.this$0.invalidate();
        }

        public void removeCallbacks() {
            boolean removeCallbacks = this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            ViewDragHelper viewDragHelper2 = viewDragHelper;
            this.mDragger = viewDragHelper2;
        }

        public boolean tryCaptureView(View view, int i) {
            View view2 = view;
            int i2 = i;
            return this.this$0.isDrawerView(view2) && this.this$0.checkDrawerViewAbsoluteGravity(view2, this.mAbsGravity) && this.this$0.getDrawerLockMode(view2) == 0;
        }
    }

    static {
        DrawerLayoutCompatImplBase drawerLayoutCompatImplBase;
        DrawerLayoutCompatImplApi21 drawerLayoutCompatImplApi21;
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        SET_DRAWER_SHADOW_FROM_ELEVATION = z;
        if (VERSION.SDK_INT >= 21) {
            DrawerLayoutCompatImplApi21 drawerLayoutCompatImplApi212 = drawerLayoutCompatImplApi21;
            DrawerLayoutCompatImplApi21 drawerLayoutCompatImplApi213 = new DrawerLayoutCompatImplApi21();
            IMPL = drawerLayoutCompatImplApi212;
            return;
        }
        DrawerLayoutCompatImplBase drawerLayoutCompatImplBase2 = drawerLayoutCompatImplBase;
        DrawerLayoutCompatImplBase drawerLayoutCompatImplBase3 = new DrawerLayoutCompatImplBase();
        IMPL = drawerLayoutCompatImplBase2;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        ChildAccessibilityDelegate childAccessibilityDelegate;
        Paint paint;
        ViewDragCallback viewDragCallback;
        ViewDragCallback viewDragCallback2;
        AccessibilityDelegate accessibilityDelegate;
        ArrayList<View> arrayList;
        Context context2 = context;
        super(context2, attributeSet, i);
        ChildAccessibilityDelegate childAccessibilityDelegate2 = childAccessibilityDelegate;
        ChildAccessibilityDelegate childAccessibilityDelegate3 = new ChildAccessibilityDelegate(this);
        this.mChildAccessibilityDelegate = childAccessibilityDelegate2;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        Paint paint2 = paint;
        Paint paint3 = new Paint();
        this.mScrimPaint = paint2;
        this.mFirstLayout = true;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) (0.5f + (64.0f * f));
        float f2 = 400.0f * f;
        ViewDragCallback viewDragCallback3 = viewDragCallback;
        ViewDragCallback viewDragCallback4 = new ViewDragCallback(this, 3);
        this.mLeftCallback = viewDragCallback3;
        ViewDragCallback viewDragCallback5 = viewDragCallback2;
        ViewDragCallback viewDragCallback6 = new ViewDragCallback(this, 5);
        this.mRightCallback = viewDragCallback5;
        this.mLeftDragger = ViewDragHelper.create(this, 1.0f, this.mLeftCallback);
        this.mLeftDragger.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(f2);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        this.mRightDragger = ViewDragHelper.create(this, 1.0f, this.mRightCallback);
        this.mRightDragger.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(f2);
        this.mRightCallback.setDragger(this.mRightDragger);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        AccessibilityDelegate accessibilityDelegate2 = accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate3 = new AccessibilityDelegate(this);
        ViewCompat.setAccessibilityDelegate(this, accessibilityDelegate2);
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            IMPL.configureApplyInsets(this);
            this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(context2);
        }
        this.mDrawerElevation = 10.0f * f;
        ArrayList<View> arrayList2 = arrayList;
        ArrayList<View> arrayList3 = new ArrayList<>();
        this.mNonDrawerViews = arrayList2;
    }

    /* access modifiers changed from: private */
    public View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    static String gravityToString(int i) {
        int i2 = i;
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        boolean z = false;
        if (background != null) {
            z = false;
            if (background.getOpacity() == -1) {
                z = true;
            }
        }
        return z;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isPeeking) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null;
    }

    /* access modifiers changed from: private */
    public static boolean includeChildForAccessibility(View view) {
        View view2 = view;
        return (ViewCompat.getImportantForAccessibility(view2) == 4 || ViewCompat.getImportantForAccessibility(view2) == 2) ? false : true;
    }

    private boolean mirror(Drawable drawable, int i) {
        Drawable drawable2 = drawable;
        int i2 = i;
        if (drawable2 == null || !DrawableCompat.isAutoMirrored(drawable2)) {
            return false;
        }
        DrawableCompat.setLayoutDirection(drawable2, i2);
        return true;
    }

    private Drawable resolveLeftShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.mShadowStart != null) {
                boolean mirror = mirror(this.mShadowStart, layoutDirection);
                return this.mShadowStart;
            }
        } else if (this.mShadowEnd != null) {
            boolean mirror2 = mirror(this.mShadowEnd, layoutDirection);
            return this.mShadowEnd;
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.mShadowEnd != null) {
                boolean mirror = mirror(this.mShadowEnd, layoutDirection);
                return this.mShadowEnd;
            }
        } else if (this.mShadowStart != null) {
            boolean mirror2 = mirror(this.mShadowStart, layoutDirection);
            return this.mShadowStart;
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = resolveLeftShadow();
            this.mShadowRightResolved = resolveRightShadow();
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z) {
        View view2 = view;
        boolean z2 = z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z2 || isDrawerView(childAt)) && (!z2 || childAt != view2)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ArrayList<View> arrayList2 = arrayList;
        int i3 = i;
        int i4 = i2;
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!isDrawerView(childAt)) {
                    boolean add = this.mNonDrawerViews.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    z = true;
                    childAt.addFocusables(arrayList2, i3, i4);
                }
            }
            if (!z) {
                int size = this.mNonDrawerViews.size();
                for (int i6 = 0; i6 < size; i6++) {
                    View view = (View) this.mNonDrawerViews.get(i6);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList2, i3, i4);
                    }
                }
            }
            this.mNonDrawerViews.clear();
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        View view2 = view;
        super.addView(view2, i, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view2)) {
            ViewCompat.setImportantForAccessibility(view2, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view2, 1);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(view2, this.mChildAccessibilityDelegate);
        }
    }

    /* access modifiers changed from: 0000 */
    public void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean dispatchTouchEvent = getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        int i2 = i;
        return (i2 & getDrawerViewAbsoluteGravity(view)) == i2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
        return (layoutParams2 instanceof LayoutParams) && super.checkLayoutParams(layoutParams2);
    }

    public void closeDrawer(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("No drawer view found with gravity ").append(gravityToString(i2)).toString());
            throw illegalArgumentException2;
        }
        closeDrawer(findDrawerWithGravity);
    }

    public void closeDrawer(View view) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        View view2 = view;
        if (!isDrawerView(view2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("View ").append(view2).append(" is not a sliding drawer").toString());
            throw illegalArgumentException2;
        }
        if (this.mFirstLayout) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            layoutParams.onScreen = 0.0f;
            layoutParams.knownOpen = false;
        } else if (checkDrawerViewAbsoluteGravity(view2, 3)) {
            boolean smoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(view2, -view2.getWidth(), view2.getTop());
        } else {
            boolean smoothSlideViewTo2 = this.mRightDragger.smoothSlideViewTo(view2, getWidth(), view2.getTop());
        }
        invalidate();
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    /* access modifiers changed from: 0000 */
    public void closeDrawers(boolean z) {
        boolean z2 = z;
        boolean z3 = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z2 || layoutParams.isPeeking)) {
                z3 = checkDrawerViewAbsoluteGravity(childAt, 3) ? z3 | this.mLeftDragger.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : z3 | this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                layoutParams.isPeeking = false;
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (z3) {
            invalidate();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).onScreen);
        }
        this.mScrimOpacity = f;
        if (this.mLeftDragger.continueSettling(true) || this.mRightDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnDrawerClosed(View view) {
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (layoutParams.knownOpen) {
            layoutParams.knownOpen = false;
            if (this.mListener != null) {
                this.mListener.onDrawerClosed(view2);
            }
            updateChildrenImportantForAccessibility(view2, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnDrawerOpened(View view) {
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (!layoutParams.knownOpen) {
            layoutParams.knownOpen = true;
            if (this.mListener != null) {
                this.mListener.onDrawerOpened(view2);
            }
            updateChildrenImportantForAccessibility(view2, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            boolean requestFocus = view2.requestFocus();
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnDrawerSlide(View view, float f) {
        View view2 = view;
        float f2 = f;
        if (this.mListener != null) {
            this.mListener.onDrawerSlide(view2, f2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Canvas canvas2 = canvas;
        View view2 = view;
        long j2 = j;
        int height = getHeight();
        boolean isContentView = isContentView(view2);
        int width = getWidth();
        int save = canvas2.save();
        int i = 0;
        if (isContentView) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != view2 && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i) {
                            i = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            boolean clipRect = canvas2.clipRect(i, 0, width, getHeight());
        }
        boolean drawChild = super.drawChild(canvas2, view2, j2);
        canvas2.restoreToCount(save);
        if (this.mScrimOpacity <= 0.0f || !isContentView) {
            if (this.mShadowLeftResolved == null || !checkDrawerViewAbsoluteGravity(view2, 3)) {
                if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view2, 5)) {
                    int intrinsicWidth = this.mShadowRightResolved.getIntrinsicWidth();
                    int left2 = view2.getLeft();
                    float max = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.mRightDragger.getEdgeSize()), 1.0f));
                    this.mShadowRightResolved.setBounds(left2 - intrinsicWidth, view2.getTop(), left2, view2.getBottom());
                    this.mShadowRightResolved.setAlpha((int) (255.0f * max));
                    this.mShadowRightResolved.draw(canvas2);
                    return drawChild;
                }
            } else {
                int intrinsicWidth2 = this.mShadowLeftResolved.getIntrinsicWidth();
                int right2 = view2.getRight();
                float max2 = Math.max(0.0f, Math.min(((float) right2) / ((float) this.mLeftDragger.getEdgeSize()), 1.0f));
                this.mShadowLeftResolved.setBounds(right2, view2.getTop(), right2 + intrinsicWidth2, view2.getBottom());
                this.mShadowLeftResolved.setAlpha((int) (255.0f * max2));
                this.mShadowLeftResolved.draw(canvas2);
                return drawChild;
            }
        } else {
            this.mScrimPaint.setColor((((int) (((float) ((-16777216 & this.mScrimColor) >>> 24)) * this.mScrimOpacity)) << 24) | (16777215 & this.mScrimColor));
            canvas2.drawRect((float) i, 0.0f, (float) width, (float) getHeight(), this.mScrimPaint);
        }
        return drawChild;
    }

    /* access modifiers changed from: 0000 */
    public View findDrawerWithGravity(int i) {
        int absoluteGravity = 7 & GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((7 & getDrawerViewAbsoluteGravity(childAt)) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).knownOpen) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        return layoutParams2;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutParams layoutParams;
        AttributeSet attributeSet2 = attributeSet;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(getContext(), attributeSet2);
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        LayoutParams layoutParams3;
        LayoutParams layoutParams4;
        android.view.ViewGroup.LayoutParams layoutParams5 = layoutParams;
        if (layoutParams5 instanceof LayoutParams) {
            LayoutParams layoutParams6 = layoutParams4;
            LayoutParams layoutParams7 = new LayoutParams((LayoutParams) layoutParams5);
            return layoutParams6;
        } else if (layoutParams5 instanceof MarginLayoutParams) {
            LayoutParams layoutParams8 = layoutParams3;
            LayoutParams layoutParams9 = new LayoutParams((MarginLayoutParams) layoutParams5);
            return layoutParams8;
        } else {
            LayoutParams layoutParams10 = layoutParams2;
            LayoutParams layoutParams11 = new LayoutParams(layoutParams5);
            return layoutParams10;
        }
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.mLockModeLeft;
        }
        if (absoluteGravity == 5) {
            return this.mLockModeRight;
        }
        return 0;
    }

    public int getDrawerLockMode(View view) {
        int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(view);
        if (drawerViewAbsoluteGravity == 3) {
            return this.mLockModeLeft;
        }
        if (drawerViewAbsoluteGravity == 5) {
            return this.mLockModeRight;
        }
        return 0;
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int getDrawerViewAbsoluteGravity(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    /* access modifiers changed from: 0000 */
    public float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: 0000 */
    public boolean isContentView(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    public boolean isDrawerOpen(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerOpen(View view) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        View view2 = view;
        if (isDrawerView(view2)) {
            return ((LayoutParams) view2.getLayoutParams()).knownOpen;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("View ").append(view2).append(" is not a drawer").toString());
        throw illegalArgumentException2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isDrawerView(View view) {
        View view2 = view;
        return (7 & GravityCompat.getAbsoluteGravity(((LayoutParams) view2.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view2))) != 0;
    }

    public boolean isDrawerVisible(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        View view2 = view;
        if (isDrawerView(view2)) {
            return ((LayoutParams) view2.getLayoutParams()).onScreen > 0.0f;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("View ").append(view2).append(" is not a drawer").toString());
        throw illegalArgumentException2;
    }

    /* access modifiers changed from: 0000 */
    public void moveDrawerToOffset(View view, float f) {
        View view2 = view;
        float f2 = f;
        float drawerViewOffset = getDrawerViewOffset(view2);
        int width = view2.getWidth();
        int i = ((int) (f2 * ((float) width))) - ((int) (drawerViewOffset * ((float) width)));
        if (!checkDrawerViewAbsoluteGravity(view2, 3)) {
            i = -i;
        }
        view2.offsetLeftAndRight(i);
        setDrawerViewOffset(view2, f2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas2);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int topInset = IMPL.getTopInset(this.mLastInsets);
            if (topInset > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), topInset);
                this.mStatusBarBackground.draw(canvas2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r0.mChildrenCanceledTouch != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r13 = r1
            int r13 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r13)
            r2 = r13
            r13 = r0
            android.support.v4.widget.ViewDragHelper r13 = r13.mLeftDragger
            r14 = r1
            boolean r13 = r13.shouldInterceptTouchEvent(r14)
            r14 = r0
            android.support.v4.widget.ViewDragHelper r14 = r14.mRightDragger
            r15 = r1
            boolean r14 = r14.shouldInterceptTouchEvent(r15)
            r13 = r13 | r14
            r3 = r13
            r13 = 0
            r4 = r13
            r13 = r2
            switch(r13) {
                case 0: goto L_0x003d;
                case 1: goto L_0x00a2;
                case 2: goto L_0x0085;
                case 3: goto L_0x00a2;
                default: goto L_0x0022;
            }
        L_0x0022:
            r13 = r3
            if (r13 != 0) goto L_0x0038
            r13 = r4
            if (r13 != 0) goto L_0x0038
            r13 = r0
            boolean r13 = r13.hasPeekingDrawer()
            if (r13 != 0) goto L_0x0038
            r13 = r0
            boolean r13 = r13.mChildrenCanceledTouch
            r6 = r13
            r13 = 0
            r5 = r13
            r13 = r6
            if (r13 == 0) goto L_0x003a
        L_0x0038:
            r13 = 1
            r5 = r13
        L_0x003a:
            r13 = r5
            r0 = r13
            return r0
        L_0x003d:
            r13 = r1
            float r13 = r13.getX()
            r8 = r13
            r13 = r1
            float r13 = r13.getY()
            r9 = r13
            r13 = r0
            r14 = r8
            r13.mInitialMotionX = r14
            r13 = r0
            r14 = r9
            r13.mInitialMotionY = r14
            r13 = r0
            float r13 = r13.mScrimOpacity
            r14 = 0
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            r10 = r13
            r13 = 0
            r4 = r13
            r13 = r10
            if (r13 <= 0) goto L_0x007c
            r13 = r0
            android.support.v4.widget.ViewDragHelper r13 = r13.mLeftDragger
            r14 = r8
            int r14 = (int) r14
            r15 = r9
            int r15 = (int) r15
            android.view.View r13 = r13.findTopChildUnder(r14, r15)
            r11 = r13
            r13 = 0
            r4 = r13
            r13 = r11
            if (r13 == 0) goto L_0x007c
            r13 = r0
            r14 = r11
            boolean r13 = r13.isContentView(r14)
            r12 = r13
            r13 = 0
            r4 = r13
            r13 = r12
            if (r13 == 0) goto L_0x007c
            r13 = 1
            r4 = r13
        L_0x007c:
            r13 = r0
            r14 = 0
            r13.mDisallowInterceptRequested = r14
            r13 = r0
            r14 = 0
            r13.mChildrenCanceledTouch = r14
            goto L_0x0022
        L_0x0085:
            r13 = r0
            android.support.v4.widget.ViewDragHelper r13 = r13.mLeftDragger
            r14 = 3
            boolean r13 = r13.checkTouchSlop(r14)
            r7 = r13
            r13 = 0
            r4 = r13
            r13 = r7
            if (r13 == 0) goto L_0x0022
            r13 = r0
            android.support.v4.widget.DrawerLayout$ViewDragCallback r13 = r13.mLeftCallback
            r13.removeCallbacks()
            r13 = r0
            android.support.v4.widget.DrawerLayout$ViewDragCallback r13 = r13.mRightCallback
            r13.removeCallbacks()
            r13 = 0
            r4 = r13
            goto L_0x0022
        L_0x00a2:
            r13 = r0
            r14 = 1
            r13.closeDrawers(r14)
            r13 = r0
            r14 = 0
            r13.mDisallowInterceptRequested = r14
            r13 = r0
            r14 = 0
            r13.mChildrenCanceledTouch = r14
            r13 = 0
            r4 = r13
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (i2 != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i2, keyEvent2);
        }
        KeyEventCompat.startTracking(keyEvent2);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent2);
        }
        View findVisibleDrawer = findVisibleDrawer();
        if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
            closeDrawers();
        }
        return findVisibleDrawer != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        boolean z2 = z;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        this.mInLayout = true;
        int i10 = i8 - i6;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        i5 = (-measuredWidth) + ((int) (((float) measuredWidth) * layoutParams.onScreen));
                        f = ((float) (measuredWidth + i5)) / ((float) measuredWidth);
                    } else {
                        i5 = i10 - ((int) (((float) measuredWidth) * layoutParams.onScreen));
                        f = ((float) (i10 - i5)) / ((float) measuredWidth);
                    }
                    boolean z3 = f != layoutParams.onScreen;
                    switch (112 & layoutParams.gravity) {
                        case 16:
                            int i12 = i9 - i7;
                            int i13 = (i12 - measuredHeight) / 2;
                            if (i13 < layoutParams.topMargin) {
                                i13 = layoutParams.topMargin;
                            } else {
                                if (i13 + measuredHeight > i12 - layoutParams.bottomMargin) {
                                    i13 = (i12 - layoutParams.bottomMargin) - measuredHeight;
                                }
                            }
                            childAt.layout(i5, i13, i5 + measuredWidth, i13 + measuredHeight);
                            break;
                        case 80:
                            int i14 = i9 - i7;
                            childAt.layout(i5, (i14 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), i5 + measuredWidth, i14 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, layoutParams.topMargin, i5 + measuredWidth, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z3) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i15 = layoutParams.onScreen > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i15) {
                        childAt.setVisibility(i15);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        int mode = MeasureSpec.getMode(i3);
        int mode2 = MeasureSpec.getMode(i4);
        int size = MeasureSpec.getSize(i3);
        int size2 = MeasureSpec.getSize(i4);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                throw illegalArgumentException2;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this);
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        IMPL.dispatchChildInsets(childAt, this.mLastInsets, absoluteGravity);
                    } else {
                        IMPL.applyMarginInsets(layoutParams, this.mLastInsets, absoluteGravity);
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, IDirectInputDevice.DIEP_NORESTART), MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, IDirectInputDevice.DIEP_NORESTART));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        if (ViewCompat.getElevation(childAt) != this.mDrawerElevation) {
                            ViewCompat.setElevation(childAt, this.mDrawerElevation);
                        }
                    }
                    int drawerViewAbsoluteGravity = 7 & getDrawerViewAbsoluteGravity(childAt);
                    if ((0 & drawerViewAbsoluteGravity) != 0) {
                        IllegalStateException illegalStateException3 = illegalStateException2;
                        StringBuilder sb3 = sb2;
                        StringBuilder sb4 = new StringBuilder();
                        IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("Child drawer has absolute gravity ").append(gravityToString(drawerViewAbsoluteGravity)).append(" but this ").append(TAG).append(" already has a ").append("drawer view along that edge").toString());
                        throw illegalStateException3;
                    }
                    childAt.measure(getChildMeasureSpec(i3, this.mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i4, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                } else {
                    IllegalStateException illegalStateException5 = illegalStateException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("Child ").append(childAt).append(" at index ").append(i5).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ").append("Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                    throw illegalStateException5;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0) {
            View findDrawerWithGravity = findDrawerWithGravity(savedState.openDrawerGravity);
            if (findDrawerWithGravity != null) {
                openDrawer(findDrawerWithGravity);
            }
        }
        setDrawerLockMode(savedState.lockModeLeft, 3);
        setDrawerLockMode(savedState.lockModeRight, 5);
    }

    public void onRtlPropertiesChanged(int i) {
        int i2 = i;
        resolveShadowDrawables();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        SavedState savedState2 = savedState;
        SavedState savedState3 = new SavedState(super.onSaveInstanceState());
        SavedState savedState4 = savedState2;
        View findOpenDrawer = findOpenDrawer();
        if (findOpenDrawer != null) {
            savedState4.openDrawerGravity = ((LayoutParams) findOpenDrawer.getLayoutParams()).gravity;
        }
        savedState4.lockModeLeft = this.mLockModeLeft;
        savedState4.lockModeRight = this.mLockModeRight;
        return savedState4;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        this.mLeftDragger.processTouchEvent(motionEvent2);
        this.mRightDragger.processTouchEvent(motionEvent2);
        switch (255 & motionEvent2.getAction()) {
            case 0:
                float x = motionEvent2.getX();
                float y = motionEvent2.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                return true;
            case 1:
                float x2 = motionEvent2.getX();
                float y2 = motionEvent2.getY();
                boolean z = true;
                View findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x2, (int) y2);
                if (findTopChildUnder != null && isContentView(findTopChildUnder)) {
                    float f = x2 - this.mInitialMotionX;
                    float f2 = y2 - this.mInitialMotionY;
                    int touchSlop = this.mLeftDragger.getTouchSlop();
                    if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop))) {
                        View findOpenDrawer = findOpenDrawer();
                        if (findOpenDrawer != null) {
                            z = getDrawerLockMode(findOpenDrawer) == 2;
                        }
                    }
                }
                closeDrawers(z);
                this.mDisallowInterceptRequested = false;
                return true;
            case 3:
                closeDrawers(true);
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                return true;
            default:
                return true;
        }
    }

    public void openDrawer(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("No drawer view found with gravity ").append(gravityToString(i2)).toString());
            throw illegalArgumentException2;
        }
        openDrawer(findDrawerWithGravity);
    }

    public void openDrawer(View view) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        View view2 = view;
        if (!isDrawerView(view2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("View ").append(view2).append(" is not a sliding drawer").toString());
            throw illegalArgumentException2;
        }
        if (this.mFirstLayout) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            layoutParams.onScreen = 1.0f;
            layoutParams.knownOpen = true;
            updateChildrenImportantForAccessibility(view2, true);
        } else if (checkDrawerViewAbsoluteGravity(view2, 3)) {
            boolean smoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(view2, 0, view2.getTop());
        } else {
            boolean smoothSlideViewTo2 = this.mRightDragger.smoothSlideViewTo(view2, getWidth() - view2.getWidth(), view2.getTop());
        }
        invalidate();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        boolean z2 = z;
        super.requestDisallowInterceptTouchEvent(z2);
        this.mDisallowInterceptRequested = z2;
        if (z2) {
            closeDrawers(true);
        }
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object obj, boolean z) {
        boolean z2 = z;
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                ViewCompat.setElevation(childAt, this.mDrawerElevation);
            }
        }
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = drawerListener;
        this.mListener = drawerListener2;
    }

    public void setDrawerLockMode(int i) {
        int i2 = i;
        setDrawerLockMode(i2, 3);
        setDrawerLockMode(i2, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int i3 = i;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.mLockModeLeft = i3;
        } else if (absoluteGravity == 5) {
            this.mLockModeRight = i3;
        }
        if (i3 != 0) {
            (absoluteGravity == 3 ? this.mLeftDragger : this.mRightDragger).cancel();
        }
        switch (i3) {
            case 1:
                View findDrawerWithGravity = findDrawerWithGravity(absoluteGravity);
                if (findDrawerWithGravity != null) {
                    closeDrawer(findDrawerWithGravity);
                    return;
                }
                return;
            case 2:
                View findDrawerWithGravity2 = findDrawerWithGravity(absoluteGravity);
                if (findDrawerWithGravity2 != null) {
                    openDrawer(findDrawerWithGravity2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        View view2 = view;
        if (!isDrawerView(view2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("View ").append(view2).append(" is not a ").append("drawer with appropriate layout_gravity").toString());
            throw illegalArgumentException2;
        }
        setDrawerLockMode(i2, ((LayoutParams) view2.getLayoutParams()).gravity);
    }

    public void setDrawerShadow(@DrawableRes int i, int i2) {
        int i3 = i2;
        setDrawerShadow(getResources().getDrawable(i), i3);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        Drawable drawable2 = drawable;
        int i2 = i;
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((i2 & 8388611) == 8388611) {
                this.mShadowStart = drawable2;
            } else if ((i2 & GravityCompat.END) == 8388613) {
                this.mShadowEnd = drawable2;
            } else if ((i2 & 3) == 3) {
                this.mShadowLeft = drawable2;
            } else if ((i2 & 5) == 5) {
                this.mShadowRight = drawable2;
            } else {
                return;
            }
            resolveShadowDrawables();
            invalidate();
        }
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence2;
        } else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setDrawerViewOffset(View view, float f) {
        View view2 = view;
        float f2 = f;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (f2 != layoutParams.onScreen) {
            layoutParams.onScreen = f2;
            dispatchOnDrawerSlide(view2, f2);
        }
    }

    public void setScrimColor(@ColorInt int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        int i2 = i;
        this.mStatusBarBackground = i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        ColorDrawable colorDrawable;
        ColorDrawable colorDrawable2 = colorDrawable;
        ColorDrawable colorDrawable3 = new ColorDrawable(i);
        this.mStatusBarBackground = colorDrawable2;
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void updateDrawerState(int i, int i2, View view) {
        int i3 = i;
        int i4 = i2;
        View view2 = view;
        int viewDragState = this.mLeftDragger.getViewDragState();
        int viewDragState2 = this.mRightDragger.getViewDragState();
        int i5 = (viewDragState == 1 || viewDragState2 == 1) ? 1 : (viewDragState == 2 || viewDragState2 == 2) ? 2 : 0;
        if (view2 != null && i4 == 0) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.onScreen == 0.0f) {
                dispatchOnDrawerClosed(view2);
            } else if (layoutParams.onScreen == 1.0f) {
                dispatchOnDrawerOpened(view2);
            }
        }
        if (i5 != this.mDrawerState) {
            this.mDrawerState = i5;
            if (this.mListener != null) {
                this.mListener.onDrawerStateChanged(i5);
            }
        }
    }
}
