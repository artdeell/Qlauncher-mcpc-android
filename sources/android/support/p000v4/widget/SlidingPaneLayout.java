package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.SlidingPaneLayout */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    /* access modifiers changed from: private */
    public final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    /* access modifiers changed from: private */
    public boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    /* access modifiers changed from: private */
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    private boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    /* access modifiers changed from: private */
    public float mSlideOffset;
    /* access modifiers changed from: private */
    public int mSlideRange;
    /* access modifiers changed from: private */
    public View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$AccessibilityDelegate */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ SlidingPaneLayout this$0;

        AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
            Rect rect;
            this.this$0 = slidingPaneLayout;
            Rect rect2 = rect;
            Rect rect3 = new Rect();
            this.mTmpRect = rect2;
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
            accessibilityNodeInfoCompat3.setMovementGranularities(accessibilityNodeInfoCompat4.getMovementGranularities());
        }

        public boolean filter(View view) {
            return this.this$0.isDimmed(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent2);
            accessibilityEvent2.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            View view2 = view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat2);
            super.onInitializeAccessibilityNodeInfo(view2, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat2, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat2.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat2.setSource(view2);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view2);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat2.setParent((View) parentForAccessibility);
            }
            int childCount = this.this$0.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.this$0.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat2.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            ViewGroup viewGroup2 = viewGroup;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            if (!filter(view2)) {
                return super.onRequestSendAccessibilityEvent(viewGroup2, view2, accessibilityEvent2);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable */
    private class DisableLayerRunnable implements Runnable {
        final View mChildView;
        final /* synthetic */ SlidingPaneLayout this$0;

        DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
            View view2 = view;
            this.this$0 = slidingPaneLayout;
            this.mChildView = view2;
        }

        public void run() {
            if (this.mChildView.getParent() == this.this$0) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                this.this$0.invalidateChildRegion(this.mChildView);
            }
            boolean remove = this.this$0.mPostedRunnables.remove(this);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$DragHelperCallback */
    private class DragHelperCallback extends Callback {
        final /* synthetic */ SlidingPaneLayout this$0;

        private DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
            this.this$0 = slidingPaneLayout;
        }

        /* synthetic */ DragHelperCallback(SlidingPaneLayout slidingPaneLayout, C01411 r7) {
            C01411 r2 = r7;
            this(slidingPaneLayout);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            View view2 = view;
            int i3 = i;
            int i4 = i2;
            LayoutParams layoutParams = (LayoutParams) this.this$0.mSlideableView.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport()) {
                int width = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + layoutParams.rightMargin) + this.this$0.mSlideableView.getWidth());
                return Math.max(Math.min(i3, width), width - this.this$0.mSlideRange);
            }
            int paddingLeft = this.this$0.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i3, paddingLeft), paddingLeft + this.this$0.mSlideRange);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            View view2 = view;
            return this.this$0.mSlideRange;
        }

        public void onEdgeDragStarted(int i, int i2) {
            int i3 = i;
            this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, i2);
        }

        public void onViewCaptured(View view, int i) {
            View view2 = view;
            int i2 = i;
            this.this$0.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int i) {
            int i2 = i;
            if (this.this$0.mDragHelper.getViewDragState() != 0) {
                return;
            }
            if (this.this$0.mSlideOffset == 0.0f) {
                this.this$0.updateObscuredViewsVisibility(this.this$0.mSlideableView);
                this.this$0.dispatchOnPanelClosed(this.this$0.mSlideableView);
                boolean access$502 = SlidingPaneLayout.access$502(this.this$0, false);
                return;
            }
            this.this$0.dispatchOnPanelOpened(this.this$0.mSlideableView);
            boolean access$5022 = SlidingPaneLayout.access$502(this.this$0, true);
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            View view2 = view;
            int i5 = i2;
            int i6 = i3;
            int i7 = i4;
            this.this$0.onPanelDragged(i);
            this.this$0.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            View view2 = view;
            float f3 = f;
            float f4 = f2;
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport()) {
                int paddingRight = this.this$0.getPaddingRight() + layoutParams.rightMargin;
                if (f3 < 0.0f || (f3 == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                    paddingRight += this.this$0.mSlideRange;
                }
                paddingLeft = (this.this$0.getWidth() - paddingRight) - this.this$0.mSlideableView.getWidth();
            } else {
                paddingLeft = this.this$0.getPaddingLeft() + layoutParams.leftMargin;
                if (f3 > 0.0f || (f3 == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                    paddingLeft += this.this$0.mSlideRange;
                }
            }
            boolean z = this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view2.getTop());
            this.this$0.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            View view2 = view;
            int i2 = i;
            if (this.this$0.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view2.getLayoutParams()).slideable;
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] ATTRS;
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight = 0.0f;

        static {
            int[] iArr = new int[1];
            int[] iArr2 = iArr;
            iArr[0] = 16843137;
            ATTRS = iArr2;
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            Context context2 = context;
            AttributeSet attributeSet2 = attributeSet;
            super(context2, attributeSet2);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            LayoutParams layoutParams2 = layoutParams;
            super(layoutParams2);
            this.weight = layoutParams2.weight;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$PanelSlideListener */
    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        boolean isOpen;

        static {
            C01421 r2;
            C01421 r0 = r2;
            C01421 r1 = new Creator<SavedState>() {
                public SavedState createFromParcel(Parcel parcel) {
                    SavedState savedState;
                    SavedState savedState2 = savedState;
                    SavedState savedState3 = new SavedState(parcel, null);
                    return savedState2;
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            CREATOR = r0;
        }

        private SavedState(Parcel parcel) {
            Parcel parcel2 = parcel;
            super(parcel2);
            this.isOpen = parcel2.readInt() != 0;
        }

        /* synthetic */ SavedState(Parcel parcel, C01411 r7) {
            C01411 r2 = r7;
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            super.writeToParcel(parcel2, i);
            parcel2.writeInt(this.isOpen ? 1 : 0);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SimplePanelSlideListener */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public SimplePanelSlideListener() {
        }

        public void onPanelClosed(View view) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelSlide(View view, float f) {
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl */
    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase */
    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            View view2 = view;
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJB */
    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
                int e2 = Log.e(SlidingPaneLayout.TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                int e4 = Log.e(SlidingPaneLayout.TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
            }
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            SlidingPaneLayout slidingPaneLayout2 = slidingPaneLayout;
            View view2 = view;
            if (this.mGetDisplayList == null || this.mRecreateDisplayList == null) {
                view2.invalidate();
                return;
            }
            try {
                this.mRecreateDisplayList.setBoolean(view2, true);
                Object invoke = this.mGetDisplayList.invoke(view2, null);
            } catch (Exception e) {
                int e2 = Log.e(SlidingPaneLayout.TAG, "Error refreshing display list state", e);
            }
            super.invalidateChildRegion(slidingPaneLayout2, view2);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJBMR1 */
    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            SlidingPaneLayout slidingPaneLayout2 = slidingPaneLayout;
            View view2 = view;
            ViewCompat.setLayerPaint(view2, ((LayoutParams) view2.getLayoutParams()).dimPaint);
        }
    }

    static {
        SlidingPanelLayoutImplBase slidingPanelLayoutImplBase;
        SlidingPanelLayoutImplJB slidingPanelLayoutImplJB;
        SlidingPanelLayoutImplJBMR1 slidingPanelLayoutImplJBMR1;
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            SlidingPanelLayoutImplJBMR1 slidingPanelLayoutImplJBMR12 = slidingPanelLayoutImplJBMR1;
            SlidingPanelLayoutImplJBMR1 slidingPanelLayoutImplJBMR13 = new SlidingPanelLayoutImplJBMR1();
            IMPL = slidingPanelLayoutImplJBMR12;
        } else if (i >= 16) {
            SlidingPanelLayoutImplJB slidingPanelLayoutImplJB2 = slidingPanelLayoutImplJB;
            SlidingPanelLayoutImplJB slidingPanelLayoutImplJB3 = new SlidingPanelLayoutImplJB();
            IMPL = slidingPanelLayoutImplJB2;
        } else {
            SlidingPanelLayoutImplBase slidingPanelLayoutImplBase2 = slidingPanelLayoutImplBase;
            SlidingPanelLayoutImplBase slidingPanelLayoutImplBase3 = new SlidingPanelLayoutImplBase();
            IMPL = slidingPanelLayoutImplBase2;
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        Rect rect;
        ArrayList<DisableLayerRunnable> arrayList;
        AccessibilityDelegate accessibilityDelegate;
        DragHelperCallback dragHelperCallback;
        Context context2 = context;
        super(context2, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        this.mTmpRect = rect2;
        ArrayList<DisableLayerRunnable> arrayList2 = arrayList;
        ArrayList<DisableLayerRunnable> arrayList3 = new ArrayList<>();
        this.mPostedRunnables = arrayList2;
        float f = context2.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) (0.5f + (32.0f * f));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        setWillNotDraw(false);
        AccessibilityDelegate accessibilityDelegate2 = accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate3 = new AccessibilityDelegate(this);
        ViewCompat.setAccessibilityDelegate(this, accessibilityDelegate2);
        ViewCompat.setImportantForAccessibility(this, 1);
        DragHelperCallback dragHelperCallback2 = dragHelperCallback;
        DragHelperCallback dragHelperCallback3 = new DragHelperCallback(this, null);
        this.mDragHelper = ViewDragHelper.create(this, 0.5f, dragHelperCallback2);
        this.mDragHelper.setMinVelocity(400.0f * f);
    }

    static /* synthetic */ boolean access$502(SlidingPaneLayout slidingPaneLayout, boolean z) {
        boolean z2 = z;
        slidingPaneLayout.mPreservedOpenState = z2;
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (smoothSlideTo(0.0f, r2) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean closePane(android.view.View r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r10
            r5 = r0
            boolean r5 = r5.mFirstLayout
            if (r5 != 0) goto L_0x0015
            r5 = r0
            r6 = 0
            r7 = r2
            boolean r5 = r5.smoothSlideTo(r6, r7)
            r4 = r5
            r5 = 0
            r3 = r5
            r5 = r4
            if (r5 == 0) goto L_0x001b
        L_0x0015:
            r5 = r0
            r6 = 0
            r5.mPreservedOpenState = r6
            r5 = 1
            r3 = r5
        L_0x001b:
            r5 = r3
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SlidingPaneLayout.closePane(android.view.View, int):boolean");
    }

    private void dimChildView(View view, float f, int i) {
        DisableLayerRunnable disableLayerRunnable;
        PorterDuffColorFilter porterDuffColorFilter;
        Paint paint;
        View view2 = view;
        float f2 = f;
        int i2 = i;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (f2 * ((float) ((-16777216 & i2) >>> 24)))) << 24) | (16777215 & i2);
            if (layoutParams.dimPaint == null) {
                LayoutParams layoutParams2 = layoutParams;
                Paint paint2 = paint;
                Paint paint3 = new Paint();
                layoutParams2.dimPaint = paint2;
            }
            Paint paint4 = layoutParams.dimPaint;
            PorterDuffColorFilter porterDuffColorFilter2 = porterDuffColorFilter;
            PorterDuffColorFilter porterDuffColorFilter3 = new PorterDuffColorFilter(i3, Mode.SRC_OVER);
            ColorFilter colorFilter = paint4.setColorFilter(porterDuffColorFilter2);
            if (ViewCompat.getLayerType(view2) != 2) {
                ViewCompat.setLayerType(view2, 2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view2);
        } else if (ViewCompat.getLayerType(view2) != 0) {
            if (layoutParams.dimPaint != null) {
                ColorFilter colorFilter2 = layoutParams.dimPaint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable2 = disableLayerRunnable;
            DisableLayerRunnable disableLayerRunnable3 = new DisableLayerRunnable(this, view2);
            DisableLayerRunnable disableLayerRunnable4 = disableLayerRunnable2;
            boolean add = this.mPostedRunnables.add(disableLayerRunnable4);
            ViewCompat.postOnAnimation(this, disableLayerRunnable4);
        }
    }

    /* access modifiers changed from: private */
    public void invalidateChildRegion(View view) {
        IMPL.invalidateChildRegion(this, view);
    }

    /* access modifiers changed from: private */
    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* access modifiers changed from: private */
    public void onPanelDragged(int i) {
        int i2 = i;
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        this.mSlideOffset = ((float) ((isLayoutRtlSupport ? (getWidth() - i2) - this.mSlideableView.getWidth() : i2) - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.mSlideRange);
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    private boolean openPane(View view, int i) {
        View view2 = view;
        int i2 = i;
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i2)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parallaxOtherViews(float r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r12 = r0
            boolean r12 = r12.isLayoutRtlSupport()
            r2 = r12
            r12 = r0
            android.view.View r12 = r12.mSlideableView
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            android.support.v4.widget.SlidingPaneLayout$LayoutParams r12 = (android.support.p000v4.widget.SlidingPaneLayout.LayoutParams) r12
            r3 = r12
            r12 = r3
            boolean r12 = r12.dimWhenOffset
            if (r12 == 0) goto L_0x0046
            r12 = r2
            if (r12 == 0) goto L_0x0041
            r12 = r3
            int r12 = r12.rightMargin
            r11 = r12
        L_0x0020:
            r12 = r11
            if (r12 > 0) goto L_0x0046
            r12 = 1
            r4 = r12
        L_0x0025:
            r12 = r0
            int r12 = r12.getChildCount()
            r5 = r12
            r12 = 0
            r6 = r12
        L_0x002d:
            r12 = r6
            r13 = r5
            if (r12 >= r13) goto L_0x0091
            r12 = r0
            r13 = r6
            android.view.View r12 = r12.getChildAt(r13)
            r7 = r12
            r12 = r7
            r13 = r0
            android.view.View r13 = r13.mSlideableView
            if (r12 != r13) goto L_0x0049
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0041:
            r12 = r3
            int r12 = r12.leftMargin
            r11 = r12
            goto L_0x0020
        L_0x0046:
            r12 = 0
            r4 = r12
            goto L_0x0025
        L_0x0049:
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = r0
            float r13 = r13.mParallaxOffset
            float r12 = r12 - r13
            r13 = r0
            int r13 = r13.mParallaxBy
            float r13 = (float) r13
            float r12 = r12 * r13
            int r12 = (int) r12
            r8 = r12
            r12 = r0
            r13 = r1
            r12.mParallaxOffset = r13
            r12 = r8
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = r1
            float r13 = r13 - r14
            r14 = r0
            int r14 = r14.mParallaxBy
            float r14 = (float) r14
            float r13 = r13 * r14
            int r13 = (int) r13
            int r12 = r12 - r13
            r9 = r12
            r12 = r2
            if (r12 == 0) goto L_0x006d
            r12 = r9
            int r12 = -r12
            r9 = r12
        L_0x006d:
            r12 = r7
            r13 = r9
            r12.offsetLeftAndRight(r13)
            r12 = r4
            if (r12 == 0) goto L_0x003e
            r12 = r2
            if (r12 == 0) goto L_0x0089
            r12 = r0
            float r12 = r12.mParallaxOffset
            r13 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 - r13
            r10 = r12
        L_0x007f:
            r12 = r0
            r13 = r7
            r14 = r10
            r15 = r0
            int r15 = r15.mCoveredFadeColor
            r12.dimChildView(r13, r14, r15)
            goto L_0x003e
        L_0x0089:
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = r0
            float r13 = r13.mParallaxOffset
            float r12 = r12 - r13
            r10 = r12
            goto L_0x007f
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SlidingPaneLayout.parallaxOtherViews(float):void");
    }

    private static boolean viewIsOpaque(View view) {
        View view2 = view;
        if (!ViewCompat.isOpaque(view2)) {
            if (VERSION.SDK_INT >= 18) {
                return false;
            }
            Drawable background = view2.getBackground();
            if (background == null) {
                return false;
            }
            if (background.getOpacity() != -1) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        boolean z2 = z;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = -1 + viewGroup.getChildCount(); childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i5 + scrollX >= childAt.getLeft() && i5 + scrollX < childAt.getRight() && i6 + scrollY >= childAt.getTop() && i6 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i4, (i5 + scrollX) - childAt.getLeft(), (i6 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z2) {
            if (!isLayoutRtlSupport()) {
                i4 = -i4;
            }
            if (ViewCompat.canScrollHorizontally(view2, i4)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
        return (layoutParams2 instanceof LayoutParams) && super.checkLayoutParams(layoutParams2);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if (!this.mDragHelper.continueSettling(true)) {
            return;
        }
        if (!this.mCanSlide) {
            this.mDragHelper.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnPanelClosed(View view) {
        View view2 = view;
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(view2);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnPanelOpened(View view) {
        View view2 = view;
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(view2);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnPanelSlide(View view) {
        View view2 = view;
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(view2, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        int left;
        int i;
        Canvas canvas2 = canvas;
        super.draw(canvas2);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View view = getChildCount() > 1 ? getChildAt(1) : null;
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i = view.getRight();
                left = i + intrinsicWidth;
            } else {
                left = view.getLeft();
                i = left - intrinsicWidth;
            }
            drawable.setBounds(i, top, left, bottom);
            drawable.draw(canvas2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        StringBuilder sb;
        Canvas canvas2 = canvas;
        View view2 = view;
        long j2 = j;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int save = canvas2.save(2);
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            boolean clipBounds = canvas2.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            } else {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            }
            boolean clipRect = canvas2.clipRect(this.mTmpRect);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas2, view2, j2);
        } else if (!layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            if (view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas2, view2, j2);
        } else {
            if (!view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache != null) {
                canvas2.drawBitmap(drawingCache, (float) view2.getLeft(), (float) view2.getTop(), layoutParams.dimPaint);
                drawChild = false;
            } else {
                String str = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e = Log.e(str, sb2.append("drawChild: child view ").append(view2).append(" returned null drawing cache").toString());
                drawChild = super.drawChild(canvas2, view2, j2);
            }
        }
        canvas2.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams();
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
        android.view.ViewGroup.LayoutParams layoutParams4 = layoutParams;
        if (layoutParams4 instanceof MarginLayoutParams) {
            LayoutParams layoutParams5 = layoutParams3;
            LayoutParams layoutParams6 = new LayoutParams((MarginLayoutParams) layoutParams4);
            return layoutParams5;
        }
        LayoutParams layoutParams7 = layoutParams2;
        LayoutParams layoutParams8 = new LayoutParams(layoutParams4);
        return layoutParams7;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    /* access modifiers changed from: 0000 */
    public boolean isDimmed(View view) {
        View view2 = view;
        if (view2 != null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.mCanSlide && layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
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
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            ((DisableLayerRunnable) this.mPostedRunnables.get(i)).run();
        }
        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent2);
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent2.getX(), (int) motionEvent2.getY());
            }
        }
        if (this.mCanSlide) {
            if (!this.mIsUnableToDrag || actionMasked == 0) {
                if (actionMasked == 3 || actionMasked == 1) {
                    this.mDragHelper.cancel();
                    return false;
                }
                boolean z = false;
                switch (actionMasked) {
                    case 0:
                        this.mIsUnableToDrag = false;
                        float x = motionEvent2.getX();
                        float y = motionEvent2.getY();
                        this.mInitialMotionX = x;
                        this.mInitialMotionY = y;
                        z = false;
                        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y)) {
                            z = false;
                            if (isDimmed(this.mSlideableView)) {
                                z = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x2 = motionEvent2.getX();
                        float y2 = motionEvent2.getY();
                        float abs = Math.abs(x2 - this.mInitialMotionX);
                        float abs2 = Math.abs(y2 - this.mInitialMotionY);
                        z = false;
                        if (abs > ((float) this.mDragHelper.getTouchSlop())) {
                            z = false;
                            if (abs2 > abs) {
                                this.mDragHelper.cancel();
                                this.mIsUnableToDrag = true;
                                return false;
                            }
                        }
                        break;
                }
                return this.mDragHelper.shouldInterceptTouchEvent(motionEvent2) || z;
            }
        }
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(motionEvent2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        float f;
        boolean z2 = z;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i11 = i9 - i7;
        int paddingLeft = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingRight = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i12 = paddingLeft;
        int i13 = i12;
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mPreservedOpenState) {
                    f = 1.0f;
                    this.mSlideOffset = f;
                }
            }
            f = 0.0f;
            this.mSlideOffset = f;
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i15 = 0;
                if (layoutParams.slideable) {
                    int min = (Math.min(i13, (i11 - paddingRight) - this.mOverhangSize) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    int i16 = isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.dimWhenOffset = (min + (i12 + i16)) + (measuredWidth / 2) > i11 - paddingRight;
                    int i17 = (int) (((float) min) * this.mSlideOffset);
                    i12 += i17 + i16;
                    this.mSlideOffset = ((float) i17) / ((float) this.mSlideRange);
                } else {
                    if (this.mCanSlide) {
                        if (this.mParallaxBy != 0) {
                            i15 = (int) ((1.0f - this.mSlideOffset) * ((float) this.mParallaxBy));
                            i12 = i13;
                        }
                    }
                    i12 = i13;
                    i15 = 0;
                }
                if (isLayoutRtlSupport) {
                    i6 = i15 + (i11 - i12);
                    i5 = i6 - measuredWidth;
                } else {
                    i5 = i12 - i15;
                    i6 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i6, paddingTop + childAt.getMeasuredHeight());
                i13 += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    dimChildView(getChildAt(i18), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        int i3 = i;
        int i4 = i2;
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i4);
        int size2 = MeasureSpec.getSize(i4);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                IllegalStateException illegalStateException3 = illegalStateException2;
                IllegalStateException illegalStateException4 = new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                throw illegalStateException3;
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                IllegalStateException illegalStateException5 = illegalStateException;
                IllegalStateException illegalStateException6 = new IllegalStateException("Height must not be UNSPECIFIED");
                throw illegalStateException5;
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        int i5 = -1;
        int i6 = 0;
        switch (mode2) {
            case Integer.MIN_VALUE:
                i5 = (size2 - getPaddingTop()) - getPaddingBottom();
                i6 = 0;
                break;
            case IDirectInputDevice.DIEP_NORESTART /*1073741824*/:
                i5 = (size2 - getPaddingTop()) - getPaddingBottom();
                i6 = i5;
                break;
        }
        float f = 0.0f;
        boolean z = false;
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i7 = paddingLeft;
        int childCount = getChildCount();
        if (childCount > 2) {
            int e = Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = false;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f += layoutParams.weight;
                    if (layoutParams.width == 0) {
                    }
                }
                int i9 = layoutParams.leftMargin + layoutParams.rightMargin;
                int makeMeasureSpec = layoutParams.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - i9, Integer.MIN_VALUE) : layoutParams.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - i9, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(layoutParams.width, IDirectInputDevice.DIEP_NORESTART);
                int makeMeasureSpec2 = layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(i5, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(layoutParams.height, IDirectInputDevice.DIEP_NORESTART);
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i6) {
                    i6 = Math.min(measuredHeight, i5);
                }
                i7 -= measuredWidth;
                boolean z2 = i7 < 0;
                layoutParams.slideable = z2;
                z |= z2;
                if (layoutParams.slideable) {
                    this.mSlideableView = childAt;
                }
            }
        }
        if (z || f > 0.0f) {
            int i10 = paddingLeft - this.mOverhangSize;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z3 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z3 ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                int makeMeasureSpec3 = layoutParams2.width == 0 ? layoutParams2.height == -2 ? MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE) : layoutParams2.height == -1 ? MeasureSpec.makeMeasureSpec(i5, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(layoutParams2.height, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), IDirectInputDevice.DIEP_NORESTART);
                                if (z) {
                                    int i12 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    int makeMeasureSpec4 = MeasureSpec.makeMeasureSpec(i12, IDirectInputDevice.DIEP_NORESTART);
                                    if (measuredWidth2 != i12) {
                                        childAt2.measure(makeMeasureSpec4, makeMeasureSpec3);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * ((float) Math.max(0, i7))) / f)), IDirectInputDevice.DIEP_NORESTART), makeMeasureSpec3);
                                }
                            }
                        } else if (layoutParams2.width < 0 && (measuredWidth2 > i10 || layoutParams2.weight > 0.0f)) {
                            int makeMeasureSpec5 = z3 ? layoutParams2.height == -2 ? MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE) : layoutParams2.height == -1 ? MeasureSpec.makeMeasureSpec(i5, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(layoutParams2.height, IDirectInputDevice.DIEP_NORESTART) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), IDirectInputDevice.DIEP_NORESTART);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i10, IDirectInputDevice.DIEP_NORESTART), makeMeasureSpec5);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(size, i6 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z;
        if (this.mDragHelper.getViewDragState() != 0 && !z) {
            this.mDragHelper.abort();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            boolean openPane = openPane();
        } else {
            boolean closePane = closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        SavedState savedState2 = savedState;
        SavedState savedState3 = new SavedState(super.onSaveInstanceState());
        SavedState savedState4 = savedState2;
        savedState4.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState4;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        super.onSizeChanged(i5, i2, i6, i4);
        if (i5 != i6) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = motionEvent;
        if (!this.mCanSlide) {
            z = super.onTouchEvent(motionEvent2);
        } else {
            this.mDragHelper.processTouchEvent(motionEvent2);
            z = true;
            switch (motionEvent2.getAction() & 255) {
                case 0:
                    float x = motionEvent2.getX();
                    float y = motionEvent2.getY();
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    return true;
                case 1:
                    if (isDimmed(this.mSlideableView)) {
                        float x2 = motionEvent2.getX();
                        float y2 = motionEvent2.getY();
                        float f = x2 - this.mInitialMotionX;
                        float f2 = y2 - this.mInitialMotionY;
                        int touchSlop = this.mDragHelper.getTouchSlop();
                        if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                            boolean closePane = closePane(this.mSlideableView, 0);
                            return true;
                        }
                    }
                    break;
                default:
                    return true;
            }
        }
        return z;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(View view, View view2) {
        View view3 = view;
        super.requestChildFocus(view3, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = view3 == this.mSlideableView;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        int i2 = i;
        this.mCoveredFadeColor = i2;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = panelSlideListener;
        this.mPanelSlideListener = panelSlideListener2;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        Drawable drawable2 = drawable;
        this.mShadowDrawableLeft = drawable2;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        Drawable drawable2 = drawable;
        this.mShadowDrawableRight = drawable2;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        int i2 = i;
        this.mSliderFadeColor = i2;
    }

    @Deprecated
    public void smoothSlideClosed() {
        boolean closePane = closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        boolean openPane = openPane();
    }

    /* access modifiers changed from: 0000 */
    public boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        float f2 = f;
        int i2 = i;
        if (this.mCanSlide) {
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            if (isLayoutRtlSupport()) {
                paddingLeft = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.mSlideRange))) + ((float) this.mSlideableView.getWidth())));
            } else {
                paddingLeft = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.mSlideRange)));
            }
            if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paddingLeft, this.mSlideableView.getTop())) {
                setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int paddingLeft = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int width = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view2)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i2 = view2.getLeft();
            i3 = view2.getRight();
            i4 = view2.getTop();
            i = view2.getBottom();
        }
        int i5 = 0;
        int childCount = getChildCount();
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view2) {
                childAt.setVisibility((Math.max(isLayoutRtlSupport ? width : paddingLeft, childAt.getLeft()) < i2 || Math.max(paddingTop, childAt.getTop()) < i4 || Math.min(isLayoutRtlSupport ? paddingLeft : width, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                i5++;
            } else {
                return;
            }
        }
    }
}
