package android.support.p000v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.p000v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.PagerTitleStrip */
public class PagerTitleStrip extends ViewGroup implements Decor {
    private static final int[] ATTRS = {16842804, 16842901, 16842904, 16842927};
    private static final PagerTitleStripImpl IMPL;
    private static final float SIDE_ALPHA = 0.6f;
    private static final String TAG = "PagerTitleStrip";
    private static final int[] TEXT_ATTRS;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    /* access modifiers changed from: private */
    public float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    /* renamed from: android.support.v4.view.PagerTitleStrip$PageListener */
    private class PageListener extends DataSetObserver implements OnPageChangeListener, OnAdapterChangeListener {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        private PageListener(PagerTitleStrip pagerTitleStrip) {
            this.this$0 = pagerTitleStrip;
        }

        /* synthetic */ PageListener(PagerTitleStrip pagerTitleStrip, C01071 r7) {
            C01071 r2 = r7;
            this(pagerTitleStrip);
        }

        public void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerAdapter pagerAdapter3 = pagerAdapter;
            PagerAdapter pagerAdapter4 = pagerAdapter2;
            this.this$0.updateAdapter(pagerAdapter3, pagerAdapter4);
        }

        public void onChanged() {
            this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            float f = 0.0f;
            if (this.this$0.mLastKnownPositionOffset >= 0.0f) {
                f = this.this$0.mLastKnownPositionOffset;
            }
            this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
        }

        public void onPageScrollStateChanged(int i) {
            int i2 = i;
            this.mScrollState = i2;
        }

        public void onPageScrolled(int i, float f, int i2) {
            int i3 = i;
            float f2 = f;
            int i4 = i2;
            if (f2 > 0.5f) {
                i3++;
            }
            this.this$0.updateTextPositions(i3, f2, false);
        }

        public void onPageSelected(int i) {
            int i2 = i;
            if (this.mScrollState == 0) {
                this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
                float f = 0.0f;
                if (this.this$0.mLastKnownPositionOffset >= 0.0f) {
                    f = this.this$0.mLastKnownPositionOffset;
                }
                this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
            }
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImpl */
    interface PagerTitleStripImpl {
        void setSingleLineAllCaps(TextView textView);
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase */
    static class PagerTitleStripImplBase implements PagerTitleStripImpl {
        PagerTitleStripImplBase() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            textView.setSingleLine();
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImplIcs */
    static class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        PagerTitleStripImplIcs() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            PagerTitleStripIcs.setSingleLineAllCaps(textView);
        }
    }

    static {
        PagerTitleStripImplBase pagerTitleStripImplBase;
        PagerTitleStripImplIcs pagerTitleStripImplIcs;
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16843660;
        TEXT_ATTRS = iArr2;
        if (VERSION.SDK_INT >= 14) {
            PagerTitleStripImplIcs pagerTitleStripImplIcs2 = pagerTitleStripImplIcs;
            PagerTitleStripImplIcs pagerTitleStripImplIcs3 = new PagerTitleStripImplIcs();
            IMPL = pagerTitleStripImplIcs2;
            return;
        }
        PagerTitleStripImplBase pagerTitleStripImplBase2 = pagerTitleStripImplBase;
        PagerTitleStripImplBase pagerTitleStripImplBase3 = new PagerTitleStripImplBase();
        IMPL = pagerTitleStripImplBase2;
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        PageListener pageListener;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        super(context2, attributeSet2);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        PageListener pageListener2 = pageListener;
        PageListener pageListener3 = new PageListener(this, null);
        this.mPageListener = pageListener2;
        TextView textView4 = textView;
        TextView textView5 = new TextView(context2);
        TextView textView6 = textView4;
        this.mPrevText = textView6;
        addView(textView6);
        TextView textView7 = textView2;
        TextView textView8 = new TextView(context2);
        TextView textView9 = textView7;
        this.mCurrText = textView9;
        addView(textView9);
        TextView textView10 = textView3;
        TextView textView11 = new TextView(context2);
        TextView textView12 = textView10;
        this.mNextText = textView12;
        addView(textView12);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.mPrevText.setTextAppearance(context2, resourceId);
            this.mCurrText.setTextAppearance(context2, resourceId);
            this.mNextText.setTextAppearance(context2, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        this.mPrevText.setEllipsize(TruncateAt.END);
        this.mCurrText.setEllipsize(TruncateAt.END);
        this.mNextText.setEllipsize(TruncateAt.END);
        boolean z = false;
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (16.0f * context2.getResources().getDisplayMetrics().density);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        IMPL.setSingleLineAllCaps(textView);
    }

    /* access modifiers changed from: 0000 */
    public int getMinHeight() {
        Drawable background = getBackground();
        int i = 0;
        if (background != null) {
            i = background.getIntrinsicHeight();
        }
        return i;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IllegalStateException illegalStateException;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
            throw illegalStateException2;
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        OnPageChangeListener internalPageChangeListener = viewPager.setInternalPageChangeListener(this.mPageListener);
        viewPager.setOnAdapterChangeListener(this.mPageListener);
        this.mPager = viewPager;
        updateAdapter(this.mWatchingAdapter != null ? (PagerAdapter) this.mWatchingAdapter.get() : null, adapter);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPager != null) {
            updateAdapter(this.mPager.getAdapter(), null);
            OnPageChangeListener internalPageChangeListener = this.mPager.setInternalPageChangeListener(null);
            this.mPager.setOnAdapterChangeListener(null);
            this.mPager = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = z;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (this.mPager != null) {
            float f = 0.0f;
            if (this.mLastKnownPositionOffset >= 0.0f) {
                f = this.mLastKnownPositionOffset;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int max;
        IllegalStateException illegalStateException;
        int i3 = i;
        int i4 = i2;
        if (MeasureSpec.getMode(i3) != 1073741824) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Must measure with an exact width");
            throw illegalStateException2;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i4, paddingTop, -2);
        int size = MeasureSpec.getSize(i3);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (int) (0.2f * ((float) size)), -2);
        this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
        this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
        this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i4) == 1073741824) {
            max = MeasureSpec.getSize(i4);
        } else {
            max = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, ViewCompat.resolveSizeAndState(max, i4, ViewCompat.getMeasuredState(this.mCurrText) << 16));
    }

    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.mGravity = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, mo15to = 1.0d) float f) {
        this.mNonPrimaryAlpha = 255 & ((int) (255.0f * f));
        int i = (this.mNonPrimaryAlpha << 24) | (16777215 & this.mTextColor);
        this.mPrevText.setTextColor(i);
        this.mNextText.setTextColor(i);
    }

    public void setTextColor(@ColorInt int i) {
        int i2 = i;
        this.mTextColor = i2;
        this.mCurrText.setTextColor(i2);
        int i3 = (this.mNonPrimaryAlpha << 24) | (16777215 & this.mTextColor);
        this.mPrevText.setTextColor(i3);
        this.mNextText.setTextColor(i3);
    }

    public void setTextSize(int i, float f) {
        int i2 = i;
        float f2 = f;
        this.mPrevText.setTextSize(i2, f2);
        this.mCurrText.setTextSize(i2, f2);
        this.mNextText.setTextSize(i2, f2);
    }

    public void setTextSpacing(int i) {
        this.mScaledTextSpacing = i;
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        WeakReference<PagerAdapter> weakReference;
        PagerAdapter pagerAdapter3 = pagerAdapter;
        PagerAdapter pagerAdapter4 = pagerAdapter2;
        if (pagerAdapter3 != null) {
            pagerAdapter3.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter4 != null) {
            pagerAdapter4.registerDataSetObserver(this.mPageListener);
            WeakReference<PagerAdapter> weakReference2 = weakReference;
            WeakReference<PagerAdapter> weakReference3 = new WeakReference<>(pagerAdapter4);
            this.mWatchingAdapter = weakReference2;
        }
        if (this.mPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(this.mPager.getCurrentItem(), pagerAdapter4);
            requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateText(int i, PagerAdapter pagerAdapter) {
        int i2 = i;
        PagerAdapter pagerAdapter2 = pagerAdapter;
        int i3 = pagerAdapter2 != null ? pagerAdapter2.getCount() : 0;
        this.mUpdatingText = true;
        CharSequence charSequence = null;
        if (i2 >= 1) {
            charSequence = null;
            if (pagerAdapter2 != null) {
                charSequence = pagerAdapter2.getPageTitle(i2 - 1);
            }
        }
        this.mPrevText.setText(charSequence);
        this.mCurrText.setText((pagerAdapter2 == null || i2 >= i3) ? null : pagerAdapter2.getPageTitle(i2));
        CharSequence charSequence2 = null;
        if (i2 + 1 < i3) {
            charSequence2 = null;
            if (pagerAdapter2 != null) {
                charSequence2 = pagerAdapter2.getPageTitle(i2 + 1);
            }
        }
        this.mNextText.setText(charSequence2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (0.8f * ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())))), Integer.MIN_VALUE);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i2;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i2, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    /* access modifiers changed from: 0000 */
    public void updateTextPositions(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = i;
        float f2 = f;
        boolean z2 = z;
        if (i5 != this.mLastKnownCurrentPage) {
            updateText(i5, this.mPager.getAdapter());
        } else if (!z2) {
            if (f2 == this.mLastKnownPositionOffset) {
                return;
            }
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f3 = f2 + 0.5f;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (f3 * ((float) i8)))) - (measuredWidth2 / 2);
        int i10 = i9 + measuredWidth2;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int measuredHeight = i11 + this.mPrevText.getMeasuredHeight();
        int measuredHeight2 = i12 + this.mCurrText.getMeasuredHeight();
        int max2 = Math.max(Math.max(measuredHeight, measuredHeight2), i13 + this.mNextText.getMeasuredHeight());
        switch (112 & this.mGravity) {
            case 16:
                int i14 = (((height - paddingTop) - paddingBottom) - max2) / 2;
                i2 = i14 + i11;
                i3 = i14 + i12;
                i4 = i14 + i13;
                break;
            case 80:
                int i15 = (height - paddingBottom) - max2;
                i2 = i15 + i11;
                i3 = i15 + i12;
                i4 = i15 + i13;
                break;
            default:
                i2 = paddingTop + i11;
                i3 = paddingTop + i12;
                i4 = paddingTop + i13;
                break;
        }
        this.mCurrText.layout(i9, i3, i10, i3 + this.mCurrText.getMeasuredHeight());
        int min = Math.min(paddingLeft, (i9 - this.mScaledTextSpacing) - measuredWidth);
        this.mPrevText.layout(min, i2, min + measuredWidth, i2 + this.mPrevText.getMeasuredHeight());
        int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.mScaledTextSpacing);
        this.mNextText.layout(max3, i4, max3 + measuredWidth3, i4 + this.mNextText.getMeasuredHeight());
        this.mLastKnownPositionOffset = f2;
        this.mUpdatingPositions = false;
    }
}
