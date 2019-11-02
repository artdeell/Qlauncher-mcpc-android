package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.MaterialProgressDrawable */
class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR;
    /* access modifiers changed from: private */
    public static final Interpolator MATERIAL_INTERPOLATOR;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private final int[] COLORS;
    private Animation mAnimation;
    private final ArrayList<Animation> mAnimators;
    private final Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    /* access modifiers changed from: private */
    public float mRotationCount;
    private double mWidth;

    @Retention(RetentionPolicy.CLASS)
    /* renamed from: android.support.v4.widget.MaterialProgressDrawable$ProgressDrawableSize */
    public @interface ProgressDrawableSize {
    }

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable$Ring */
    private static class Ring {
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Callback mCallback;
        private final Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private int mCurrentColor;
        private float mEndTrim = 0.0f;
        private final Paint mPaint;
        private double mRingCenterRadius;
        private float mRotation = 0.0f;
        private boolean mShowArrow;
        private float mStartTrim = 0.0f;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
        private float mStrokeWidth = 5.0f;
        private final RectF mTempBounds;

        public Ring(Callback callback) {
            RectF rectF;
            Paint paint;
            Paint paint2;
            Paint paint3;
            Callback callback2 = callback;
            RectF rectF2 = rectF;
            RectF rectF3 = new RectF();
            this.mTempBounds = rectF2;
            Paint paint4 = paint;
            Paint paint5 = new Paint();
            this.mPaint = paint4;
            Paint paint6 = paint2;
            Paint paint7 = new Paint();
            this.mArrowPaint = paint6;
            Paint paint8 = paint3;
            Paint paint9 = new Paint(1);
            this.mCirclePaint = paint8;
            this.mCallback = callback2;
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.mArrowPaint.setStyle(Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
        }

        private void drawTriangle(Canvas canvas, float f, float f2, Rect rect) {
            Path path;
            Canvas canvas2 = canvas;
            float f3 = f;
            float f4 = f2;
            Rect rect2 = rect;
            if (this.mShowArrow) {
                if (this.mArrow == null) {
                    Path path2 = path;
                    Path path3 = new Path();
                    this.mArrow = path2;
                    this.mArrow.setFillType(FillType.EVEN_ODD);
                } else {
                    this.mArrow.reset();
                }
                float f5 = ((float) (((int) this.mStrokeInset) / 2)) * this.mArrowScale;
                float cos = (float) ((this.mRingCenterRadius * Math.cos(0.0d)) + ((double) rect2.exactCenterX()));
                float sin = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + ((double) rect2.exactCenterY()));
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(((float) this.mArrowWidth) * this.mArrowScale, 0.0f);
                this.mArrow.lineTo((((float) this.mArrowWidth) * this.mArrowScale) / 2.0f, ((float) this.mArrowHeight) * this.mArrowScale);
                this.mArrow.offset(cos - f5, sin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                canvas2.rotate((f3 + f4) - 5.0f, rect2.exactCenterX(), rect2.exactCenterY());
                canvas2.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        private int getNextColorIndex() {
            return (1 + this.mColorIndex) % this.mColors.length;
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }

        public void draw(Canvas canvas, Rect rect) {
            Canvas canvas2 = canvas;
            Rect rect2 = rect;
            RectF rectF = this.mTempBounds;
            rectF.set(rect2);
            rectF.inset(this.mStrokeInset, this.mStrokeInset);
            float f = 360.0f * (this.mStartTrim + this.mRotation);
            float f2 = (360.0f * (this.mEndTrim + this.mRotation)) - f;
            this.mPaint.setColor(this.mCurrentColor);
            canvas2.drawArc(rectF, f, f2, false, this.mPaint);
            drawTriangle(canvas2, f, f2, rect2);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas2.drawCircle(rect2.exactCenterX(), rect2.exactCenterY(), (float) (rect2.width() / 2), this.mCirclePaint);
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public float getRotation() {
            return this.mRotation;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int i) {
            int i2 = i;
            this.mAlpha = i2;
        }

        public void setArrowDimensions(float f, float f2) {
            float f3 = f2;
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f3;
        }

        public void setArrowScale(float f) {
            float f2 = f;
            if (f2 != this.mArrowScale) {
                this.mArrowScale = f2;
                invalidateSelf();
            }
        }

        public void setBackgroundColor(int i) {
            int i2 = i;
            this.mBackgroundColor = i2;
        }

        public void setCenterRadius(double d) {
            double d2 = d;
            this.mRingCenterRadius = d2;
        }

        public void setColor(int i) {
            int i2 = i;
            this.mCurrentColor = i2;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            ColorFilter colorFilter2 = this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[this.mColorIndex];
        }

        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public void setInsets(int i, int i2) {
            float min = (float) Math.min(i, i2);
            this.mStrokeInset = (this.mRingCenterRadius <= 0.0d || min < 0.0f) ? (float) Math.ceil((double) (this.mStrokeWidth / 2.0f)) : (float) (((double) (min / 2.0f)) - this.mRingCenterRadius);
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void setShowArrow(boolean z) {
            boolean z2 = z;
            if (this.mShowArrow != z2) {
                this.mShowArrow = z2;
                invalidateSelf();
            }
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public void setStrokeWidth(float f) {
            float f2 = f;
            this.mStrokeWidth = f2;
            this.mPaint.setStrokeWidth(f2);
            invalidateSelf();
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    static {
        LinearInterpolator linearInterpolator;
        FastOutSlowInInterpolator fastOutSlowInInterpolator;
        LinearInterpolator linearInterpolator2 = linearInterpolator;
        LinearInterpolator linearInterpolator3 = new LinearInterpolator();
        LINEAR_INTERPOLATOR = linearInterpolator2;
        FastOutSlowInInterpolator fastOutSlowInInterpolator2 = fastOutSlowInInterpolator;
        FastOutSlowInInterpolator fastOutSlowInInterpolator3 = new FastOutSlowInInterpolator();
        MATERIAL_INTERPOLATOR = fastOutSlowInInterpolator2;
    }

    public MaterialProgressDrawable(Context context, View view) {
        ArrayList<Animation> arrayList;
        C01353 r8;
        Ring ring;
        Context context2 = context;
        View view2 = view;
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = -16777216;
        this.COLORS = iArr2;
        ArrayList<Animation> arrayList2 = arrayList;
        ArrayList<Animation> arrayList3 = new ArrayList<>();
        this.mAnimators = arrayList2;
        C01353 r4 = r8;
        C01353 r5 = new Callback(this) {
            final /* synthetic */ MaterialProgressDrawable this$0;

            {
                this.this$0 = r5;
            }

            public void invalidateDrawable(Drawable drawable) {
                Drawable drawable2 = drawable;
                this.this$0.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                Drawable drawable2 = drawable;
                Runnable runnable2 = runnable;
                long j2 = j;
                this.this$0.scheduleSelf(runnable2, j2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                Drawable drawable2 = drawable;
                Runnable runnable2 = runnable;
                this.this$0.unscheduleSelf(runnable2);
            }
        };
        this.mCallback = r4;
        this.mParent = view2;
        this.mResources = context2.getResources();
        Ring ring2 = ring;
        Ring ring3 = new Ring(this.mCallback);
        this.mRing = ring2;
        this.mRing.setColors(this.COLORS);
        updateSizes(1);
        setupAnimators();
    }

    static /* synthetic */ float access$402(MaterialProgressDrawable materialProgressDrawable, float f) {
        float f2 = f;
        materialProgressDrawable.mRotationCount = f2;
        return f2;
    }

    /* access modifiers changed from: private */
    public void applyFinishTranslation(float f, Ring ring) {
        float f2 = f;
        Ring ring2 = ring;
        updateRingColor(f2, ring2);
        float floor = (float) (1.0d + Math.floor((double) (ring2.getStartingRotation() / MAX_PROGRESS_ARC)));
        ring2.setStartTrim(ring2.getStartingStartTrim() + (f2 * ((ring2.getStartingEndTrim() - getMinProgressArc(ring2)) - ring2.getStartingStartTrim())));
        ring2.setEndTrim(ring2.getStartingEndTrim());
        ring2.setRotation(ring2.getStartingRotation() + (f2 * (floor - ring2.getStartingRotation())));
    }

    private int evaluateColorChange(float f, int i, int i2) {
        float f2 = f;
        int i3 = i2;
        int intValue = Integer.valueOf(i).intValue();
        int i4 = 255 & (intValue >> 24);
        int i5 = 255 & (intValue >> 16);
        int i6 = 255 & (intValue >> 8);
        int i7 = intValue & 255;
        int intValue2 = Integer.valueOf(i3).intValue();
        return ((i4 + ((int) (f2 * ((float) ((255 & (intValue2 >> 24)) - i4))))) << 24) | ((i5 + ((int) (f2 * ((float) ((255 & (intValue2 >> 16)) - i5))))) << 16) | ((i6 + ((int) (f2 * ((float) ((255 & (intValue2 >> 8)) - i6))))) << 8) | (i7 + ((int) (f2 * ((float) ((intValue2 & 255) - i7)))));
    }

    /* access modifiers changed from: private */
    public float getMinProgressArc(Ring ring) {
        Ring ring2 = ring;
        return (float) Math.toRadians(((double) ring2.getStrokeWidth()) / (6.283185307179586d * ring2.getCenterRadius()));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setSizeParameters(double d, double d2, double d3, double d4, float f, float f2) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        float f3 = f;
        float f4 = f2;
        Ring ring = this.mRing;
        float f5 = this.mResources.getDisplayMetrics().density;
        this.mWidth = d5 * ((double) f5);
        this.mHeight = d6 * ((double) f5);
        ring.setStrokeWidth(f5 * ((float) d8));
        ring.setCenterRadius(d7 * ((double) f5));
        ring.setColorIndex(0);
        ring.setArrowDimensions(f3 * f5, f4 * f5);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
    }

    private void setupAnimators() {
        C01331 r8;
        C01342 r82;
        Ring ring = this.mRing;
        C01331 r3 = r8;
        final Ring ring2 = ring;
        C01331 r4 = new Animation(this) {
            final /* synthetic */ MaterialProgressDrawable this$0;

            {
                Ring ring = r7;
                this.this$0 = r6;
            }

            public void applyTransformation(float f, Transformation transformation) {
                float f2 = f;
                Transformation transformation2 = transformation;
                if (this.this$0.mFinishing) {
                    this.this$0.applyFinishTranslation(f2, ring2);
                    return;
                }
                float access$100 = this.this$0.getMinProgressArc(ring2);
                float startingEndTrim = ring2.getStartingEndTrim();
                float startingStartTrim = ring2.getStartingStartTrim();
                float startingRotation = ring2.getStartingRotation();
                this.this$0.updateRingColor(f2, ring2);
                if (f2 <= 0.5f) {
                    ring2.setStartTrim(startingStartTrim + ((MaterialProgressDrawable.MAX_PROGRESS_ARC - access$100) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f2 / 0.5f)));
                }
                if (f2 > 0.5f) {
                    ring2.setEndTrim(startingEndTrim + ((MaterialProgressDrawable.MAX_PROGRESS_ARC - access$100) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((f2 - 0.5f) / 0.5f)));
                }
                ring2.setRotation(startingRotation + (0.25f * f2));
                this.this$0.setRotation((216.0f * f2) + (MaterialProgressDrawable.FULL_ROTATION * (this.this$0.mRotationCount / 5.0f)));
            }
        };
        C01331 r2 = r3;
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(LINEAR_INTERPOLATOR);
        C01331 r32 = r2;
        C01342 r42 = r82;
        final Ring ring3 = ring;
        C01342 r5 = new AnimationListener(this) {
            final /* synthetic */ MaterialProgressDrawable this$0;

            {
                Ring ring = r7;
                this.this$0 = r6;
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                Animation animation2 = animation;
                ring3.storeOriginals();
                ring3.goToNextColor();
                ring3.setStartTrim(ring3.getEndTrim());
                if (this.this$0.mFinishing) {
                    this.this$0.mFinishing = false;
                    animation2.setDuration(1332);
                    ring3.setShowArrow(false);
                    return;
                }
                float access$402 = MaterialProgressDrawable.access$402(this.this$0, (1.0f + this.this$0.mRotationCount) % 5.0f);
            }

            public void onAnimationStart(Animation animation) {
                Animation animation2 = animation;
                float access$402 = MaterialProgressDrawable.access$402(this.this$0, 0.0f);
            }
        };
        r32.setAnimationListener(r42);
        this.mAnimation = r2;
    }

    /* access modifiers changed from: private */
    public void updateRingColor(float f, Ring ring) {
        float f2 = f;
        Ring ring2 = ring;
        if (f2 > 0.75f) {
            ring2.setColor(evaluateColorChange((f2 - 0.75f) / 0.25f, ring2.getStartingColor(), ring2.getNextColor()));
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int save = canvas2.save();
        canvas2.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas2, bounds);
        canvas2.restoreToCount(save);
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i) {
        int i2 = i;
        this.mRing.setAlpha(i2);
    }

    public void setArrowScale(float f) {
        float f2 = f;
        this.mRing.setArrowScale(f2);
    }

    public void setBackgroundColor(int i) {
        int i2 = i;
        this.mRing.setBackgroundColor(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        ColorFilter colorFilter2 = colorFilter;
        this.mRing.setColorFilter(colorFilter2);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    public void setProgressRotation(float f) {
        float f2 = f;
        this.mRing.setRotation(f2);
    }

    /* access modifiers changed from: 0000 */
    public void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        float f3 = f2;
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f3);
    }

    public void showArrow(boolean z) {
        boolean z2 = z;
        this.mRing.setShowArrow(z2);
    }

    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666);
            this.mParent.startAnimation(this.mAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimation.setDuration(1332);
        this.mParent.startAnimation(this.mAnimation);
    }

    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    public void updateSizes(@ProgressDrawableSize int i) {
        if (i == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }
}
