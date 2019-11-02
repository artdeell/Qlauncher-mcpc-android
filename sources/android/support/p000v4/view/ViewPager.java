package android.support.p000v4.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.p000v4.p002os.ParcelableCompat;
import android.support.p000v4.p002os.ParcelableCompatCreatorCallbacks;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p000v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: android.support.v4.view.ViewPager */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    /* access modifiers changed from: private */
    public static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;
    private int mActivePointerId = -1;
    /* access modifiers changed from: private */
    public PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    /* access modifiers changed from: private */
    public int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.view.ViewPager$Decor */
    interface Decor {
    }

    /* renamed from: android.support.v4.view.ViewPager$ItemInfo */
    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$LayoutParams */
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            Context context2 = context;
            AttributeSet attributeSet2 = attributeSet;
            super(context2, attributeSet2);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$MyAccessibilityDelegate */
    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager this$0;

        MyAccessibilityDelegate(ViewPager viewPager) {
            this.this$0 = viewPager;
        }

        private boolean canScroll() {
            return this.this$0.mAdapter != null && this.this$0.mAdapter.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent2);
            accessibilityEvent2.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent2.getEventType() == 4096 && this.this$0.mAdapter != null) {
                obtain.setItemCount(this.this$0.mAdapter.getCount());
                obtain.setFromIndex(this.this$0.mCurItem);
                obtain.setToIndex(this.this$0.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat2);
            accessibilityNodeInfoCompat2.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat2.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat2.addAction(4096);
            }
            if (this.this$0.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat2.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            int i2 = i;
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            switch (i2) {
                case 4096:
                    if (!this.this$0.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.this$0.setCurrentItem(1 + this.this$0.mCurItem);
                    return true;
                case 8192:
                    if (!this.this$0.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.this$0.setCurrentItem(-1 + this.this$0.mCurItem);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$OnAdapterChangeListener */
    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: android.support.v4.view.ViewPager$OnPageChangeListener */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager$PageTransformer */
    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager$PagerObserver */
    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        private PagerObserver(ViewPager viewPager) {
            this.this$0 = viewPager;
        }

        /* synthetic */ PagerObserver(ViewPager viewPager, C01101 r7) {
            C01101 r2 = r7;
            this(viewPager);
        }

        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$SavedState */
    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            C01131 r2;
            C01131 r0 = r2;
            C01131 r1 = new ParcelableCompatCreatorCallbacks<SavedState>() {
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    SavedState savedState;
                    SavedState savedState2 = savedState;
                    SavedState savedState3 = new SavedState(parcel, classLoader);
                    return savedState2;
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            CREATOR = ParcelableCompat.newCreator(r0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Parcel parcel2 = parcel;
            ClassLoader classLoader2 = classLoader;
            super(parcel2);
            if (classLoader2 == null) {
                classLoader2 = getClass().getClassLoader();
            }
            this.position = parcel2.readInt();
            this.adapterState = parcel2.readParcelable(classLoader2);
            this.loader = classLoader2;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(this.position).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            super.writeToParcel(parcel2, i2);
            parcel2.writeInt(this.position);
            parcel2.writeParcelable(this.adapterState, i2);
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$SimpleOnPageChangeListener */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$ViewPositionComparator */
    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            return layoutParams.isDecor != layoutParams2.isDecor ? layoutParams.isDecor ? 1 : -1 : layoutParams.position - layoutParams2.position;
        }
    }

    static {
        C01101 r4;
        C01112 r42;
        ViewPositionComparator viewPositionComparator;
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16842931;
        LAYOUT_ATTRS = iArr2;
        C01101 r0 = r4;
        C01101 r1 = new Comparator<ItemInfo>() {
            public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
                return itemInfo.position - itemInfo2.position;
            }
        };
        COMPARATOR = r0;
        C01112 r02 = r42;
        C01112 r12 = new Interpolator() {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return 1.0f + (f2 * f2 * f2 * f2 * f2);
            }
        };
        sInterpolator = r02;
        ViewPositionComparator viewPositionComparator2 = viewPositionComparator;
        ViewPositionComparator viewPositionComparator3 = new ViewPositionComparator();
        sPositionComparator = viewPositionComparator2;
    }

    public ViewPager(Context context) {
        ArrayList<ItemInfo> arrayList;
        ItemInfo itemInfo;
        Rect rect;
        C01123 r6;
        super(context);
        ArrayList<ItemInfo> arrayList2 = arrayList;
        ArrayList<ItemInfo> arrayList3 = new ArrayList<>();
        this.mItems = arrayList2;
        ItemInfo itemInfo2 = itemInfo;
        ItemInfo itemInfo3 = new ItemInfo();
        this.mTempItem = itemInfo2;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        this.mTempRect = rect2;
        C01123 r3 = r6;
        C01123 r4 = new Runnable(this) {
            final /* synthetic */ ViewPager this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.setScrollState(0);
                this.this$0.populate();
            }
        };
        this.mEndScrollRunnable = r3;
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        ArrayList<ItemInfo> arrayList;
        ItemInfo itemInfo;
        Rect rect;
        C01123 r7;
        super(context, attributeSet);
        ArrayList<ItemInfo> arrayList2 = arrayList;
        ArrayList<ItemInfo> arrayList3 = new ArrayList<>();
        this.mItems = arrayList2;
        ItemInfo itemInfo2 = itemInfo;
        ItemInfo itemInfo3 = new ItemInfo();
        this.mTempItem = itemInfo2;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        this.mTempRect = rect2;
        C01123 r4 = r7;
        C01123 r5 = new Runnable(this) {
            final /* synthetic */ ViewPager this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.setScrollState(0);
                this.this$0.populate();
            }
        };
        this.mEndScrollRunnable = r4;
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        ItemInfo itemInfo5 = itemInfo;
        int i2 = i;
        ItemInfo itemInfo6 = itemInfo2;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (itemInfo6 != null) {
            int i3 = itemInfo6.position;
            if (i3 < itemInfo5.position) {
                int i4 = 0;
                float f2 = f + itemInfo6.offset + itemInfo6.widthFactor;
                int i5 = i3 + 1;
                while (i5 <= itemInfo5.position) {
                    if (i4 >= this.mItems.size()) {
                        break;
                    }
                    Object obj = this.mItems.get(i4);
                    while (true) {
                        itemInfo4 = (ItemInfo) obj;
                        if (i5 <= itemInfo4.position) {
                            break;
                        }
                        if (i4 >= -1 + this.mItems.size()) {
                            break;
                        }
                        i4++;
                        obj = this.mItems.get(i4);
                    }
                    while (i5 < itemInfo4.position) {
                        f2 += f + this.mAdapter.getPageWidth(i5);
                        i5++;
                    }
                    itemInfo4.offset = f2;
                    f2 += f + itemInfo4.widthFactor;
                    i5++;
                }
            } else {
                if (i3 > itemInfo5.position) {
                    int size = -1 + this.mItems.size();
                    float f3 = itemInfo6.offset;
                    int i6 = i3 - 1;
                    while (i6 >= itemInfo5.position && size >= 0) {
                        Object obj2 = this.mItems.get(size);
                        while (true) {
                            itemInfo3 = (ItemInfo) obj2;
                            if (i6 < itemInfo3.position && size > 0) {
                                size--;
                                obj2 = this.mItems.get(size);
                            }
                        }
                        while (i6 > itemInfo3.position) {
                            f3 -= f + this.mAdapter.getPageWidth(i6);
                            i6--;
                        }
                        f3 -= f + itemInfo3.widthFactor;
                        itemInfo3.offset = f3;
                        i6--;
                    }
                }
            }
        }
        int size2 = this.mItems.size();
        float f4 = itemInfo5.offset;
        int i7 = -1 + itemInfo5.position;
        this.mFirstOffset = itemInfo5.position == 0 ? itemInfo5.offset : -3.4028235E38f;
        this.mLastOffset = itemInfo5.position == count + -1 ? (itemInfo5.offset + itemInfo5.widthFactor) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            ItemInfo itemInfo7 = (ItemInfo) this.mItems.get(i8);
            while (i7 > itemInfo7.position) {
                f4 -= f + this.mAdapter.getPageWidth(i7);
                i7--;
            }
            f4 -= f + itemInfo7.widthFactor;
            itemInfo7.offset = f4;
            if (itemInfo7.position == 0) {
                this.mFirstOffset = f4;
            }
            i8--;
            i7--;
        }
        float f5 = f + itemInfo5.offset + itemInfo5.widthFactor;
        int i9 = 1 + itemInfo5.position;
        int i10 = i2 + 1;
        while (i10 < size2) {
            ItemInfo itemInfo8 = (ItemInfo) this.mItems.get(i10);
            while (i9 < itemInfo8.position) {
                f5 += f + this.mAdapter.getPageWidth(i9);
                i9++;
            }
            if (itemInfo8.position == count - 1) {
                this.mLastOffset = (f5 + itemInfo8.widthFactor) - 1.0f;
            }
            itemInfo8.offset = f5;
            f5 += f + itemInfo8.widthFactor;
            i10++;
            i9++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        boolean z2 = z;
        boolean z3 = this.mScrollState == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    boolean pageScrolled = pageScrolled(currX);
                }
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (itemInfo.scrolling) {
                z3 = true;
                itemInfo.scrolling = false;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        int i4;
        int i5 = i;
        float f2 = f;
        int i6 = i2;
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i6) <= this.mMinimumVelocity) {
            i4 = (int) ((i5 >= this.mCurItem ? 0.4f : 0.6f) + f2 + ((float) i5));
        } else {
            i4 = i6 > 0 ? i5 : i5 + 1;
        }
        if (this.mItems.size() > 0) {
            i4 = Math.max(((ItemInfo) this.mItems.get(0)).position, Math.min(i4, ((ItemInfo) this.mItems.get(-1 + this.mItems.size())).position));
        }
        return i4;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        int i3 = i;
        float f2 = f;
        int i4 = i2;
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i3, f2, i4);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i5 = 0; i5 < size; i5++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i5);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i3, f2, i4);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i3, f2, i4);
        }
    }

    private void dispatchOnPageSelected(int i) {
        int i2 = i;
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        int i2 = i;
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    private void enableLayers(boolean z) {
        boolean z2 = z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z2 ? 2 : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        Rect rect3 = rect;
        View view2 = view;
        if (rect3 == null) {
            Rect rect4 = rect2;
            Rect rect5 = new Rect();
            rect3 = rect4;
        }
        if (view2 != null) {
            rect3.left = view2.getLeft();
            rect3.right = view2.getRight();
            rect3.top = view2.getTop();
            rect3.bottom = view2.getBottom();
            ViewParent parent = view2.getParent();
            while (true) {
                ViewParent viewParent = parent;
                if (!(viewParent instanceof ViewGroup) || viewParent == this) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) viewParent;
                rect3.left += viewGroup.getLeft();
                rect3.right += viewGroup.getRight();
                rect3.top += viewGroup.getTop();
                rect3.bottom += viewGroup.getBottom();
                parent = viewGroup.getParent();
            }
        } else {
            rect3.set(0, 0, 0, 0);
        }
        return rect3;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        ItemInfo itemInfo;
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        if (clientWidth > 0) {
            f2 = ((float) this.mPageMargin) / ((float) clientWidth);
        }
        int i = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = true;
        ItemInfo itemInfo2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mItems.size()) {
                break;
            }
            itemInfo = (ItemInfo) this.mItems.get(i2);
            if (!z && itemInfo.position != i + 1) {
                itemInfo = this.mTempItem;
                itemInfo.offset = f2 + f3 + f4;
                itemInfo.position = i + 1;
                itemInfo.widthFactor = this.mAdapter.getPageWidth(itemInfo.position);
                i2--;
            }
            float f5 = itemInfo.offset;
            float f6 = f2 + f5 + itemInfo.widthFactor;
            if (!z && f < f5) {
                break;
            } else if (f < f6 || i2 == -1 + this.mItems.size()) {
                itemInfo2 = itemInfo;
            } else {
                i = itemInfo.position;
                f3 = f5;
                f4 = itemInfo.widthFactor;
                itemInfo2 = itemInfo;
                i2++;
                z = false;
            }
        }
        itemInfo2 = itemInfo;
        return itemInfo2;
    }

    private boolean isGutterDrag(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        return (f3 < ((float) this.mGutterSize) && f4 > 0.0f) || (f3 > ((float) (getWidth() - this.mGutterSize)) && f4 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent2);
        if (MotionEventCompat.getPointerId(motionEvent2, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent2, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        boolean z;
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        int i2 = i;
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            z = false;
            if (!this.mCalledSuper) {
                IllegalStateException illegalStateException3 = illegalStateException2;
                IllegalStateException illegalStateException4 = new IllegalStateException("onPageScrolled did not call superclass implementation");
                throw illegalStateException3;
            }
        } else {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i3 = clientWidth + this.mPageMargin;
            float f = ((float) this.mPageMargin) / ((float) clientWidth);
            int i4 = infoForCurrentScrollPosition.position;
            float f2 = ((((float) i2) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / (f + infoForCurrentScrollPosition.widthFactor);
            int i5 = (int) (f2 * ((float) i3));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, i5);
            if (!this.mCalledSuper) {
                IllegalStateException illegalStateException5 = illegalStateException;
                IllegalStateException illegalStateException6 = new IllegalStateException("onPageScrolled did not call superclass implementation");
                throw illegalStateException5;
            }
            z = true;
        }
        return z;
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2 = f;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = f3 + ((float) getScrollX());
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        boolean z2 = true;
        boolean z3 = true;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(-1 + this.mItems.size());
        if (itemInfo.position != 0) {
            z2 = false;
            f4 = itemInfo.offset * ((float) clientWidth);
        }
        if (itemInfo2.position != -1 + this.mAdapter.getCount()) {
            z3 = false;
            f5 = itemInfo2.offset * ((float) clientWidth);
        }
        if (scrollX < f4) {
            z = false;
            if (z2) {
                z = this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
            scrollX = f4;
        } else {
            z = false;
            if (scrollX > f5) {
                boolean z4 = false;
                if (z3) {
                    z4 = this.mRightEdge.onPull(Math.abs(scrollX - f5) / ((float) clientWidth));
                }
                scrollX = f5;
            }
        }
        this.mLastMotionX += scrollX - ((float) ((int) scrollX));
        scrollTo((int) scrollX, getScrollY());
        boolean pageScrolled = pageScrolled((int) scrollX);
        return z;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i6 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((float) ((i5 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) ((((float) getScrollX()) / ((float) (i8 + ((i6 - getPaddingLeft()) - getPaddingRight())))) * ((float) (i7 + ((i5 - getPaddingLeft()) - getPaddingRight()))));
        scrollTo(scrollX, getScrollY());
        if (!this.mScroller.isFinished()) {
            this.mScroller.startScroll(scrollX, 0, (int) (infoForPosition(this.mCurItem).offset * ((float) i5)), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        boolean z2 = z;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int i3 = i;
        boolean z3 = z;
        int i4 = i2;
        boolean z4 = z2;
        ItemInfo infoForPosition = infoForPosition(i3);
        int i5 = 0;
        if (infoForPosition != null) {
            i5 = (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        }
        if (z3) {
            smoothScrollTo(i5, 0, i4);
            if (z4) {
                dispatchOnPageSelected(i3);
                return;
            }
            return;
        }
        if (z4) {
            dispatchOnPageSelected(i3);
        }
        completeScroll(false);
        scrollTo(i5, 0);
        boolean pageScrolled = pageScrolled(i5);
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        int i2 = i;
        if (this.mScrollState != i2) {
            this.mScrollState = i2;
            if (this.mPageTransformer != null) {
                enableLayers(i2 != 0);
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        boolean z2 = z;
        if (this.mScrollingCacheEnabled != z2) {
            this.mScrollingCacheEnabled = z2;
        }
    }

    private void sortChildDrawingOrder() {
        ArrayList<View> arrayList;
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                ArrayList<View> arrayList2 = arrayList;
                ArrayList<View> arrayList3 = new ArrayList<>();
                this.mDrawingOrderedChildren = arrayList2;
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean add = this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ArrayList<View> arrayList2 = arrayList;
        int i3 = i;
        int i4 = i2;
        int size = arrayList2.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList2, i3, i4);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList2.size()) || !isFocusable()) {
            return;
        }
        if (((i4 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList2 != null) {
            boolean add = arrayList2.add(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo;
        int i3 = i;
        int i4 = i2;
        ItemInfo itemInfo2 = itemInfo;
        ItemInfo itemInfo3 = new ItemInfo();
        ItemInfo itemInfo4 = itemInfo2;
        itemInfo4.position = i3;
        itemInfo4.object = this.mAdapter.instantiateItem((ViewGroup) this, i3);
        itemInfo4.widthFactor = this.mAdapter.getPageWidth(i3);
        if (i4 < 0 || i4 >= this.mItems.size()) {
            boolean add = this.mItems.add(itemInfo4);
            return itemInfo4;
        }
        this.mItems.add(i4, itemInfo4);
        return itemInfo4;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        ArrayList arrayList;
        OnPageChangeListener onPageChangeListener2 = onPageChangeListener;
        if (this.mOnPageChangeListeners == null) {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.mOnPageChangeListeners = arrayList2;
        }
        boolean add = this.mOnPageChangeListeners.add(onPageChangeListener2);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = arrayList;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList2);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        IllegalStateException illegalStateException;
        View view2 = view;
        int i2 = i;
        android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (!checkLayoutParams(layoutParams2)) {
            layoutParams2 = generateLayoutParams(layoutParams2);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.isDecor |= view2 instanceof Decor;
        if (!this.mInLayout) {
            super.addView(view2, i2, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.isDecor) {
            layoutParams3.needsMeasure = true;
            boolean addViewInLayout = addViewInLayout(view2, i2, layoutParams2);
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Cannot add pager decor view during layout");
            throw illegalStateException2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ec, code lost:
        if (r3 == 2) goto L_0x01ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r24) {
        /*
            r23 = this;
            r2 = r23
            r3 = r24
            r18 = r2
            android.view.View r18 = r18.findFocus()
            r4 = r18
            r18 = r4
            r19 = r2
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x009c
            r18 = 0
            r4 = r18
        L_0x001a:
            android.view.FocusFinder r18 = android.view.FocusFinder.getInstance()
            r19 = r2
            r20 = r4
            r21 = r3
            android.view.View r18 = r18.findNextFocus(r19, r20, r21)
            r12 = r18
            r18 = r12
            if (r18 == 0) goto L_0x01b8
            r18 = r12
            r19 = r4
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x01b8
            r18 = r3
            r19 = 17
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x0158
            r18 = r2
            r19 = r2
            r0 = r19
            android.graphics.Rect r0 = r0.mTempRect
            r19 = r0
            r20 = r12
            android.graphics.Rect r18 = r18.getChildRectInPagerCoordinates(r19, r20)
            r0 = r18
            int r0 = r0.left
            r18 = r0
            r16 = r18
            r18 = r2
            r19 = r2
            r0 = r19
            android.graphics.Rect r0 = r0.mTempRect
            r19 = r0
            r20 = r4
            android.graphics.Rect r18 = r18.getChildRectInPagerCoordinates(r19, r20)
            r0 = r18
            int r0 = r0.left
            r18 = r0
            r17 = r18
            r18 = r4
            if (r18 == 0) goto L_0x014e
            r18 = r16
            r19 = r17
            r0 = r18
            r1 = r19
            if (r0 < r1) goto L_0x014e
            r18 = r2
            boolean r18 = r18.pageLeft()
            r13 = r18
        L_0x0088:
            r18 = r13
            if (r18 == 0) goto L_0x0097
            r18 = r2
            r19 = r3
            int r19 = android.view.SoundEffectConstants.getContantForFocusDirection(r19)
            r18.playSoundEffect(r19)
        L_0x0097:
            r18 = r13
            r2 = r18
            return r2
        L_0x009c:
            r18 = r4
            if (r18 == 0) goto L_0x001a
            r18 = r4
            android.view.ViewParent r18 = r18.getParent()
            r5 = r18
        L_0x00a8:
            r18 = r5
            r0 = r18
            boolean r0 = r0 instanceof android.view.ViewGroup
            r18 = r0
            r6 = r18
            r18 = 0
            r7 = r18
            r18 = r6
            if (r18 == 0) goto L_0x00c8
            r18 = r5
            r19 = r2
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x011a
            r18 = 1
            r7 = r18
        L_0x00c8:
            r18 = r7
            if (r18 != 0) goto L_0x001a
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r22 = r18
            r18 = r22
            r19 = r22
            r19.<init>()
            r8 = r18
            r18 = r8
            r19 = r4
            java.lang.Class r19 = r19.getClass()
            java.lang.String r19 = r19.getSimpleName()
            java.lang.StringBuilder r18 = r18.append(r19)
            r18 = r4
            android.view.ViewParent r18 = r18.getParent()
            r10 = r18
        L_0x00f1:
            r18 = r10
            r0 = r18
            boolean r0 = r0 instanceof android.view.ViewGroup
            r18 = r0
            if (r18 == 0) goto L_0x0123
            r18 = r8
            java.lang.String r19 = " => "
            java.lang.StringBuilder r18 = r18.append(r19)
            r19 = r10
            java.lang.Class r19 = r19.getClass()
            java.lang.String r19 = r19.getSimpleName()
            java.lang.StringBuilder r18 = r18.append(r19)
            r18 = r10
            android.view.ViewParent r18 = r18.getParent()
            r10 = r18
            goto L_0x00f1
        L_0x011a:
            r18 = r5
            android.view.ViewParent r18 = r18.getParent()
            r5 = r18
            goto L_0x00a8
        L_0x0123:
            java.lang.String r18 = "ViewPager"
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r22 = r19
            r19 = r22
            r20 = r22
            r20.<init>()
            java.lang.String r20 = "arrowScroll tried to find focus based on non-child current focused view "
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r8
            java.lang.String r20 = r20.toString()
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            int r18 = android.util.Log.e(r18, r19)
            r18 = 0
            r4 = r18
            goto L_0x001a
        L_0x014e:
            r18 = r12
            boolean r18 = r18.requestFocus()
            r13 = r18
            goto L_0x0088
        L_0x0158:
            r18 = 0
            r13 = r18
            r18 = r3
            r19 = 66
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x0088
            r18 = r2
            r19 = r2
            r0 = r19
            android.graphics.Rect r0 = r0.mTempRect
            r19 = r0
            r20 = r12
            android.graphics.Rect r18 = r18.getChildRectInPagerCoordinates(r19, r20)
            r0 = r18
            int r0 = r0.left
            r18 = r0
            r14 = r18
            r18 = r2
            r19 = r2
            r0 = r19
            android.graphics.Rect r0 = r0.mTempRect
            r19 = r0
            r20 = r4
            android.graphics.Rect r18 = r18.getChildRectInPagerCoordinates(r19, r20)
            r0 = r18
            int r0 = r0.left
            r18 = r0
            r15 = r18
            r18 = r4
            if (r18 == 0) goto L_0x01ae
            r18 = r14
            r19 = r15
            r0 = r18
            r1 = r19
            if (r0 > r1) goto L_0x01ae
            r18 = r2
            boolean r18 = r18.pageRight()
            r13 = r18
            goto L_0x0088
        L_0x01ae:
            r18 = r12
            boolean r18 = r18.requestFocus()
            r13 = r18
            goto L_0x0088
        L_0x01b8:
            r18 = r3
            r19 = 17
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x01cc
            r18 = r3
            r19 = 1
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x01d6
        L_0x01cc:
            r18 = r2
            boolean r18 = r18.pageLeft()
            r13 = r18
            goto L_0x0088
        L_0x01d6:
            r18 = r3
            r19 = 66
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x01ee
            r18 = 0
            r13 = r18
            r18 = r3
            r19 = 2
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x0088
        L_0x01ee:
            r18 = r2
            boolean r18 = r18.pageRight()
            r13 = r18
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
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
                if (i5 + scrollX >= childAt.getLeft() && i5 + scrollX < childAt.getRight() && i6 + scrollY >= childAt.getTop() && i6 + scrollY < childAt.getBottom() && canScroll(childAt, true, i4, (i5 + scrollX) - childAt.getLeft(), (i6 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && ViewCompat.canScrollHorizontally(view2, -i4);
    }

    public boolean canScrollHorizontally(int i) {
        int i2 = i;
        boolean z = true;
        if (this.mAdapter != null) {
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            if (i2 < 0) {
                if (scrollX <= ((int) (((float) clientWidth) * this.mFirstOffset))) {
                    z = false;
                }
                return z;
            } else if (i2 > 0) {
                if (scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
        return (layoutParams2 instanceof LayoutParams) && super.checkLayoutParams(layoutParams2);
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void computeScroll() {
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: 0000 */
    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < 1 + (2 * this.mOffscreenPageLimit) && this.mItems.size() < count;
        int i = this.mCurItem;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    Object remove = this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    z = true;
                    if (this.mCurItem == itemInfo.position) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                        z = true;
                    }
                } else if (itemInfo.position != itemPosition) {
                    if (itemInfo.position == this.mCurItem) {
                        i = itemPosition;
                    }
                    itemInfo.position = itemPosition;
                    z = true;
                }
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        return super.dispatchKeyEvent(keyEvent2) || executeKeyEvent(keyEvent2);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
        if (accessibilityEvent2.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent2);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (0.4712389167638204d * ((double) (f - 0.5f)))));
    }

    public void draw(Canvas canvas) {
        boolean z;
        Canvas canvas2 = canvas;
        super.draw(canvas2);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            z = false;
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas2.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas2.rotate(270.0f);
                canvas2.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z = false | this.mLeftEdge.draw(canvas2);
                canvas2.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas2.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas2.rotate(90.0f);
                canvas2.translate((float) (-getPaddingTop()), (-(1.0f + this.mLastOffset)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas2);
                canvas2.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
            z = false;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            boolean state = drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        IllegalStateException illegalStateException;
        if (!this.mFakeDragging) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            throw illegalStateException2;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
        int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        if (keyEvent2.getAction() == 0) {
            switch (keyEvent2.getKeyCode()) {
                case 21:
                    return arrowScroll(17);
                case 22:
                    return arrowScroll(66);
                case 61:
                    if (VERSION.SDK_INT >= 11) {
                        if (KeyEventCompat.hasNoModifiers(keyEvent2)) {
                            return arrowScroll(2);
                        }
                        if (KeyEventCompat.hasModifiers(keyEvent2, 1)) {
                            return arrowScroll(1);
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public void fakeDragBy(float f) {
        IllegalStateException illegalStateException;
        float f2 = f;
        if (!this.mFakeDragging) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            throw illegalStateException2;
        }
        this.mLastMotionX = f2 + this.mLastMotionX;
        float scrollX = ((float) getScrollX()) - f2;
        int clientWidth = getClientWidth();
        float f3 = ((float) clientWidth) * this.mFirstOffset;
        float f4 = ((float) clientWidth) * this.mLastOffset;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(-1 + this.mItems.size());
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * ((float) clientWidth);
        }
        if (itemInfo2.position != -1 + this.mAdapter.getCount()) {
            f4 = itemInfo2.offset * ((float) clientWidth);
        }
        if (scrollX < f3) {
            scrollX = f3;
        } else if (scrollX > f4) {
            scrollX = f4;
        }
        this.mLastMotionX += scrollX - ((float) ((int) scrollX));
        scrollTo((int) scrollX, getScrollY());
        boolean pageScrolled = pageScrolled((int) scrollX);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
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
        android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = i2;
        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(this.mDrawingOrder == 2 ? (i - 1) - i3 : i3)).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: 0000 */
    public ItemInfo infoForAnyChild(View view) {
        View view2 = view;
        while (true) {
            ViewParent parent = view2.getParent();
            if (parent == this) {
                return infoForChild(view2);
            }
            if (parent != null && (parent instanceof View)) {
                view2 = (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public ItemInfo infoForChild(View view) {
        View view2 = view;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view2, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public ItemInfo infoForPosition(int i) {
        int i2 = i;
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i3);
            if (itemInfo.position == i2) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void initViewPager() {
        Scroller scroller;
        EdgeEffectCompat edgeEffectCompat;
        EdgeEffectCompat edgeEffectCompat2;
        MyAccessibilityDelegate myAccessibilityDelegate;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        Scroller scroller2 = scroller;
        Scroller scroller3 = new Scroller(context, sInterpolator);
        this.mScroller = scroller2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        EdgeEffectCompat edgeEffectCompat3 = edgeEffectCompat;
        EdgeEffectCompat edgeEffectCompat4 = new EdgeEffectCompat(context);
        this.mLeftEdge = edgeEffectCompat3;
        EdgeEffectCompat edgeEffectCompat5 = edgeEffectCompat2;
        EdgeEffectCompat edgeEffectCompat6 = new EdgeEffectCompat(context);
        this.mRightEdge = edgeEffectCompat5;
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        MyAccessibilityDelegate myAccessibilityDelegate2 = myAccessibilityDelegate;
        MyAccessibilityDelegate myAccessibilityDelegate3 = new MyAccessibilityDelegate(this);
        ViewCompat.setAccessibilityDelegate(this, myAccessibilityDelegate2);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        boolean removeCallbacks = removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        Canvas canvas2 = canvas;
        super.onDraw(canvas2);
        if (this.mPageMargin > 0) {
            if (this.mMarginDrawable != null) {
                if (this.mItems.size() > 0) {
                    if (this.mAdapter != null) {
                        int scrollX = getScrollX();
                        int width = getWidth();
                        float f2 = ((float) this.mPageMargin) / ((float) width);
                        int i = 0;
                        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
                        float f3 = itemInfo.offset;
                        int size = this.mItems.size();
                        int i2 = itemInfo.position;
                        int i3 = ((ItemInfo) this.mItems.get(size - 1)).position;
                        int i4 = i2;
                        while (i4 < i3) {
                            while (i4 > itemInfo.position && i < size) {
                                i++;
                                itemInfo = (ItemInfo) this.mItems.get(i);
                            }
                            if (i4 == itemInfo.position) {
                                f = (itemInfo.offset + itemInfo.widthFactor) * ((float) width);
                                f3 = f2 + itemInfo.offset + itemInfo.widthFactor;
                            } else {
                                float pageWidth = this.mAdapter.getPageWidth(i4);
                                f = (f3 + pageWidth) * ((float) width);
                                f3 += pageWidth + f2;
                            }
                            if (f + ((float) this.mPageMargin) > ((float) scrollX)) {
                                this.mMarginDrawable.setBounds((int) f, this.mTopPageBounds, (int) (0.5f + f + ((float) this.mPageMargin)), this.mBottomPageBounds);
                                this.mMarginDrawable.draw(canvas2);
                            }
                            if (f <= ((float) (scrollX + width))) {
                                i4++;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        MotionEvent motionEvent2 = motionEvent;
        int action = 255 & motionEvent2.getAction();
        if (action == 3 || action == 1) {
            boolean resetTouch = resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent2.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent2.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, 0);
                this.mIsUnableToDrag = false;
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2) {
                    if (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        break;
                    }
                }
                completeScroll(false);
                this.mIsBeingDragged = false;
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, i);
                    float x2 = MotionEventCompat.getX(motionEvent2, findPointerIndex);
                    float f2 = x2 - this.mLastMotionX;
                    float abs = Math.abs(f2);
                    float y2 = MotionEventCompat.getY(motionEvent2, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (f2 != 0.0f) {
                        if (!isGutterDrag(this.mLastMotionX, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                            this.mLastMotionX = x2;
                            this.mLastMotionY = y2;
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                    if (abs <= ((float) this.mTouchSlop) || 0.5f * abs <= abs2) {
                        if (abs2 > ((float) this.mTouchSlop)) {
                            this.mIsUnableToDrag = true;
                        }
                    } else {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        if (f2 > 0.0f) {
                            f = this.mInitialMotionX + ((float) this.mTouchSlop);
                        } else {
                            f = this.mInitialMotionX - ((float) this.mTouchSlop);
                        }
                        this.mLastMotionX = f;
                        this.mLastMotionY = y2;
                        setScrollingCacheEnabled(true);
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent2);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        boolean z2 = z;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int childCount = getChildCount();
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i13 = 112 & layoutParams.gravity;
                    switch (7 & layoutParams.gravity) {
                        case 1:
                            measuredWidth = Math.max((i9 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            measuredWidth = paddingLeft;
                            paddingLeft += childAt.getMeasuredWidth();
                            break;
                        case 5:
                            measuredWidth = (i9 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                        default:
                            measuredWidth = paddingLeft;
                            break;
                    }
                    switch (i13) {
                        case 16:
                            measuredHeight = Math.max((i10 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            measuredHeight = paddingTop;
                            paddingTop += childAt.getMeasuredHeight();
                            break;
                        case 80:
                            measuredHeight = (i10 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            break;
                        default:
                            measuredHeight = paddingTop;
                            break;
                    }
                    int i14 = measuredWidth + scrollX;
                    childAt.layout(i14, measuredHeight, i14 + childAt.getMeasuredWidth(), measuredHeight + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i15 = (i9 - paddingLeft) - paddingRight;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor) {
                    ItemInfo infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        int i17 = paddingLeft + ((int) (((float) i15) * infoForChild.offset));
                        int i18 = paddingTop;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) i15) * layoutParams2.widthFactor), IDirectInputDevice.DIEP_NORESTART), MeasureSpec.makeMeasureSpec((i10 - paddingTop) - paddingBottom, IDirectInputDevice.DIEP_NORESTART));
                        }
                        childAt2.layout(i17, i18, i17 + childAt2.getMeasuredWidth(), i18 + childAt2.getMeasuredHeight());
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i10 - paddingBottom;
        this.mDecorChildCount = i11;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    int i4 = 7 & layoutParams.gravity;
                    int i5 = 112 & layoutParams.gravity;
                    int i6 = Integer.MIN_VALUE;
                    int i7 = Integer.MIN_VALUE;
                    boolean z = i5 == 48 || i5 == 80;
                    boolean z2 = i4 == 3 || i4 == 5;
                    if (z) {
                        i6 = 1073741824;
                    } else if (z2) {
                        i7 = 1073741824;
                    }
                    int i8 = paddingLeft;
                    int i9 = measuredHeight;
                    if (layoutParams.width != -2) {
                        i6 = 1073741824;
                        if (layoutParams.width != -1) {
                            i8 = layoutParams.width;
                        }
                    }
                    if (layoutParams.height != -2) {
                        i7 = 1073741824;
                        if (layoutParams.height != -1) {
                            i9 = layoutParams.height;
                        }
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i8, i6), MeasureSpec.makeMeasureSpec(i9, i7));
                    if (z) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(paddingLeft, IDirectInputDevice.DIEP_NORESTART);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, IDirectInputDevice.DIEP_NORESTART);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2 == null || !layoutParams2.isDecor) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams2.widthFactor), IDirectInputDevice.DIEP_NORESTART), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onPageScrolled(int i, float f, int i2) {
        int measuredWidth;
        int i3 = i;
        float f2 = f;
        int i4 = i2;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    switch (7 & layoutParams.gravity) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            measuredWidth = paddingLeft;
                            paddingLeft += childAt.getWidth();
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                        default:
                            measuredWidth = paddingLeft;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                }
            }
        }
        dispatchOnPageScrolled(i3, f2, i4);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        int i5 = i;
        Rect rect2 = rect;
        int childCount = getChildCount();
        if ((i5 & 2) != 0) {
            i2 = 0;
            i3 = 1;
            i4 = childCount;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        int i6 = i2;
        while (true) {
            int i7 = i6;
            if (i7 == i4) {
                return false;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i5, rect2)) {
                    return true;
                }
            }
            i6 = i7 + i3;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2 = parcelable;
        if (!(parcelable2 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable2);
            return;
        }
        SavedState savedState = (SavedState) parcelable2;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        SavedState savedState2 = savedState;
        SavedState savedState3 = new SavedState(super.onSaveInstanceState());
        SavedState savedState4 = savedState2;
        savedState4.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState4.adapterState = this.mAdapter.saveState();
        }
        return savedState4;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        super.onSizeChanged(i5, i2, i6, i4);
        if (i5 != i6) {
            recomputeScrollPosition(i5, i6, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        MotionEvent motionEvent2 = motionEvent;
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent2.getAction() == 0 && motionEvent2.getEdgeFlags() != 0) {
            return false;
        }
        if (this.mAdapter != null) {
            if (this.mAdapter.getCount() != 0) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent2);
                boolean z = false;
                switch (255 & motionEvent2.getAction()) {
                    case 0:
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        float x = motionEvent2.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        float y = motionEvent2.getY();
                        this.mInitialMotionY = y;
                        this.mLastMotionY = y;
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, 0);
                        z = false;
                        break;
                    case 1:
                        z = false;
                        if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                            this.mPopulatePending = true;
                            int clientWidth = getClientWidth();
                            int scrollX = getScrollX();
                            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (MotionEventCompat.getX(motionEvent2, MotionEventCompat.findPointerIndex(motionEvent2, this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 2:
                        if (!this.mIsBeingDragged) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                z = resetTouch();
                                break;
                            } else {
                                float x2 = MotionEventCompat.getX(motionEvent2, findPointerIndex);
                                float abs = Math.abs(x2 - this.mLastMotionX);
                                float y2 = MotionEventCompat.getY(motionEvent2, findPointerIndex);
                                float abs2 = Math.abs(y2 - this.mLastMotionY);
                                if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                                    this.mIsBeingDragged = true;
                                    requestParentDisallowInterceptTouchEvent(true);
                                    if (x2 - this.mInitialMotionX > 0.0f) {
                                        f = this.mInitialMotionX + ((float) this.mTouchSlop);
                                    } else {
                                        f = this.mInitialMotionX - ((float) this.mTouchSlop);
                                    }
                                    this.mLastMotionX = f;
                                    this.mLastMotionY = y2;
                                    setScrollState(1);
                                    setScrollingCacheEnabled(true);
                                    ViewParent parent = getParent();
                                    if (parent != null) {
                                        parent.requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                        z = false;
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(MotionEventCompat.getX(motionEvent2, MotionEventCompat.findPointerIndex(motionEvent2, this.mActivePointerId)));
                            break;
                        }
                        break;
                    case 3:
                        z = false;
                        if (this.mIsBeingDragged) {
                            scrollToItem(this.mCurItem, true, 0, false);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 5:
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent2);
                        this.mLastMotionX = MotionEventCompat.getX(motionEvent2, actionIndex);
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent2, actionIndex);
                        z = false;
                        break;
                    case 6:
                        onSecondaryPointerUp(motionEvent2);
                        this.mLastMotionX = MotionEventCompat.getX(motionEvent2, MotionEventCompat.findPointerIndex(motionEvent2, this.mActivePointerId));
                        z = false;
                        break;
                }
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(-1 + this.mCurItem, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= -1 + this.mAdapter.getCount()) {
            return false;
        }
        setCurrentItem(1 + this.mCurItem, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void populate() {
        populate(this.mCurItem);
    }

    /* access modifiers changed from: 0000 */
    public void populate(int i) {
        ItemInfo itemInfo;
        String hexString;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i2 = i;
        int i3 = 2;
        ItemInfo itemInfo2 = null;
        if (this.mCurItem != i2) {
            i3 = this.mCurItem < i2 ? 66 : 17;
            itemInfo2 = infoForPosition(this.mCurItem);
            this.mCurItem = i2;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i4 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i4);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, i4 + this.mCurItem);
            if (count != this.mExpectedAdapterCount) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (NotFoundException e) {
                    NotFoundException notFoundException = e;
                    hexString = Integer.toHexString(getId());
                }
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ").append(this.mExpectedAdapterCount).append(", found: ").append(count).append(" Pager id: ").append(hexString).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(this.mAdapter.getClass()).toString());
                throw illegalStateException2;
            }
            int i5 = 0;
            while (true) {
                itemInfo = null;
                if (i5 >= this.mItems.size()) {
                    break;
                }
                ItemInfo itemInfo3 = (ItemInfo) this.mItems.get(i5);
                if (itemInfo3.position >= this.mCurItem) {
                    itemInfo = null;
                    if (itemInfo3.position == this.mCurItem) {
                        itemInfo = itemInfo3;
                    }
                } else {
                    i5++;
                }
            }
            if (itemInfo == null && count > 0) {
                itemInfo = addNewItem(this.mCurItem, i5);
            }
            if (itemInfo != null) {
                float f = 0.0f;
                int i6 = i5 - 1;
                ItemInfo itemInfo4 = i6 >= 0 ? (ItemInfo) this.mItems.get(i6) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - itemInfo.widthFactor) + (((float) getPaddingLeft()) / ((float) clientWidth));
                for (int i7 = -1 + this.mCurItem; i7 >= 0; i7--) {
                    if (f < paddingLeft || i7 >= max) {
                        if (itemInfo4 == null || i7 != itemInfo4.position) {
                            f += addNewItem(i7, i6 + 1).widthFactor;
                            i5++;
                            itemInfo4 = i6 >= 0 ? (ItemInfo) this.mItems.get(i6) : null;
                        } else {
                            f += itemInfo4.widthFactor;
                            i6--;
                            itemInfo4 = i6 >= 0 ? (ItemInfo) this.mItems.get(i6) : null;
                        }
                    } else if (itemInfo4 == null) {
                        break;
                    } else {
                        if (i7 == itemInfo4.position && !itemInfo4.scrolling) {
                            Object remove = this.mItems.remove(i6);
                            this.mAdapter.destroyItem((ViewGroup) this, i7, itemInfo4.object);
                            i6--;
                            i5--;
                            itemInfo4 = i6 >= 0 ? (ItemInfo) this.mItems.get(i6) : null;
                        }
                    }
                }
                float f2 = itemInfo.widthFactor;
                int i8 = i5 + 1;
                if (f2 < 2.0f) {
                    ItemInfo itemInfo5 = i8 < this.mItems.size() ? (ItemInfo) this.mItems.get(i8) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : 2.0f + (((float) getPaddingRight()) / ((float) clientWidth));
                    for (int i9 = 1 + this.mCurItem; i9 < count; i9++) {
                        if (f2 < paddingRight || i9 <= min) {
                            if (itemInfo5 == null || i9 != itemInfo5.position) {
                                ItemInfo addNewItem = addNewItem(i9, i8);
                                i8++;
                                f2 += addNewItem.widthFactor;
                                itemInfo5 = i8 < this.mItems.size() ? (ItemInfo) this.mItems.get(i8) : null;
                            } else {
                                f2 += itemInfo5.widthFactor;
                                i8++;
                                itemInfo5 = i8 < this.mItems.size() ? (ItemInfo) this.mItems.get(i8) : null;
                            }
                        } else if (itemInfo5 == null) {
                            break;
                        } else {
                            if (i9 == itemInfo5.position && !itemInfo5.scrolling) {
                                Object remove2 = this.mItems.remove(i8);
                                this.mAdapter.destroyItem((ViewGroup) this, i9, itemInfo5.object);
                                itemInfo5 = i8 < this.mItems.size() ? (ItemInfo) this.mItems.get(i8) : null;
                            }
                        }
                    }
                }
                calculatePageOffsets(itemInfo, i5, itemInfo2);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo != null ? itemInfo.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.childIndex = i10;
                if (!layoutParams.isDecor && layoutParams.widthFactor == 0.0f) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null) {
                        layoutParams.widthFactor = infoForChild.widthFactor;
                        layoutParams.position = infoForChild.position;
                    }
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                ItemInfo itemInfo6 = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (itemInfo6 == null || itemInfo6.position != this.mCurItem) {
                    int i11 = 0;
                    while (i11 < getChildCount()) {
                        View childAt2 = getChildAt(i11);
                        ItemInfo infoForChild2 = infoForChild(childAt2);
                        if (infoForChild2 == null || infoForChild2.position != this.mCurItem || !childAt2.requestFocus(i3)) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = onPageChangeListener;
        if (this.mOnPageChangeListeners != null) {
            boolean remove = this.mOnPageChangeListeners.remove(onPageChangeListener2);
        }
    }

    public void removeView(View view) {
        View view2 = view;
        if (this.mInLayout) {
            removeViewInLayout(view2);
        } else {
            super.removeView(view2);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerObserver pagerObserver;
        PagerAdapter pagerAdapter2 = pagerAdapter;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter2;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                PagerObserver pagerObserver2 = pagerObserver;
                PagerObserver pagerObserver3 = new PagerObserver(this, null);
                this.mObserver = pagerObserver2;
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        if (this.mAdapterChangeListener != null && pagerAdapter3 != pagerAdapter2) {
            this.mAdapterChangeListener.onAdapterChanged(pagerAdapter3, pagerAdapter2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        boolean z2 = z;
        if (VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    int e2 = Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                Object invoke = this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception e3) {
                int e4 = Log.e(TAG, "Error changing children drawing order", e3);
            }
        }
    }

    public void setCurrentItem(int i) {
        int i2 = i;
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i, boolean z) {
        int i2 = i;
        boolean z2 = z;
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z2, false);
    }

    /* access modifiers changed from: 0000 */
    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    /* access modifiers changed from: 0000 */
    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        int i3 = i;
        boolean z3 = z;
        boolean z4 = z2;
        int i4 = i2;
        boolean z5 = true;
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z4 || this.mCurItem != i3 || this.mItems.size() == 0) {
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.mAdapter.getCount()) {
                i3 = -1 + this.mAdapter.getCount();
            }
            int i5 = this.mOffscreenPageLimit;
            if (i3 > i5 + this.mCurItem || i3 < this.mCurItem - i5) {
                for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                    ((ItemInfo) this.mItems.get(i6)).scrolling = true;
                }
            }
            if (this.mCurItem == i3) {
                z5 = false;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i3;
                if (z5) {
                    dispatchOnPageSelected(i3);
                }
                requestLayout();
                return;
            }
            populate(i3);
            scrollToItem(i3, z3, i4, z5);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: 0000 */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = onPageChangeListener;
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener2;
        return onPageChangeListener3;
    }

    public void setOffscreenPageLimit(int i) {
        StringBuilder sb;
        int i2 = i;
        if (i2 < 1) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str, sb2.append("Requested offscreen page limit ").append(i2).append(" too small; defaulting to ").append(1).toString());
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        OnAdapterChangeListener onAdapterChangeListener2 = onAdapterChangeListener;
        this.mAdapterChangeListener = onAdapterChangeListener2;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = onPageChangeListener;
        this.mOnPageChangeListener = onPageChangeListener2;
    }

    public void setPageMargin(int i) {
        int i2 = i;
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        Drawable drawable2 = drawable;
        this.mMarginDrawable = drawable2;
        if (drawable2 != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable2 == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        boolean z2 = z;
        PageTransformer pageTransformer2 = pageTransformer;
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z3 = pageTransformer2 != null;
            boolean z4 = z3 != (this.mPageTransformer != null);
            this.mPageTransformer = pageTransformer2;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z2) {
                    i = 2;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = 0;
            }
            if (z4) {
                populate();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    /* access modifiers changed from: 0000 */
    public void smoothScrollTo(int i, int i2, int i3) {
        int abs;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i7 = i4 - scrollX;
        int i8 = i5 - scrollY;
        if (i7 == 0 && i8 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float distanceInfluenceForSnapDuration = ((float) i9) + (((float) i9) * distanceInfluenceForSnapDuration(Math.min(1.0f, (1.0f * ((float) Math.abs(i7))) / ((float) clientWidth))));
        int abs2 = Math.abs(i6);
        if (abs2 > 0) {
            abs = 4 * Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs2)));
        } else {
            abs = (int) (100.0f * (1.0f + (((float) Math.abs(i7)) / ((((float) clientWidth) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin)))));
        }
        this.mScroller.startScroll(scrollX, scrollY, i7, i8, Math.min(abs, MAX_SETTLE_DURATION));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = drawable;
        return super.verifyDrawable(drawable2) || drawable2 == this.mMarginDrawable;
    }
}
