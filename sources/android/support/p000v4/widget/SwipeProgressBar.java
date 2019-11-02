package android.support.p000v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.SwipeProgressBar */
final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR;
    private Rect mBounds;
    private final RectF mClipRect;
    private int mColor1 = COLOR1;
    private int mColor2 = Integer.MIN_VALUE;
    private int mColor3 = COLOR3;
    private int mColor4 = COLOR4;
    private long mFinishTime;
    private final Paint mPaint;
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    static {
        FastOutSlowInInterpolator fastOutSlowInInterpolator;
        FastOutSlowInInterpolator fastOutSlowInInterpolator2 = fastOutSlowInInterpolator;
        FastOutSlowInInterpolator fastOutSlowInInterpolator3 = new FastOutSlowInInterpolator();
        INTERPOLATOR = fastOutSlowInInterpolator2;
    }

    public SwipeProgressBar(View view) {
        Paint paint;
        RectF rectF;
        Rect rect;
        View view2 = view;
        Paint paint2 = paint;
        Paint paint3 = new Paint();
        this.mPaint = paint2;
        RectF rectF2 = rectF;
        RectF rectF3 = new RectF();
        this.mClipRect = rectF2;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        this.mBounds = rect2;
        this.mParent = view2;
    }

    private void drawCircle(Canvas canvas, float f, float f2, int i, float f3) {
        Canvas canvas2 = canvas;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        this.mPaint.setColor(i);
        int save = canvas2.save();
        canvas2.translate(f4, f5);
        float interpolation = INTERPOLATOR.getInterpolation(f6);
        canvas2.scale(interpolation, interpolation);
        canvas2.drawCircle(0.0f, 0.0f, f4, this.mPaint);
        canvas2.restore();
    }

    private void drawTrigger(Canvas canvas, int i, int i2) {
        Canvas canvas2 = canvas;
        int i3 = i;
        int i4 = i2;
        this.mPaint.setColor(this.mColor1);
        canvas2.drawCircle((float) i3, (float) i4, ((float) i3) * this.mTriggerPercentage, this.mPaint);
    }

    /* access modifiers changed from: 0000 */
    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.mBounds.width();
        int height = this.mBounds.height();
        int i = width / 2;
        int i2 = height / 2;
        int save = canvas2.save();
        boolean clipRect = canvas2.clipRect(this.mBounds);
        if (!this.mRunning) {
            if (this.mFinishTime <= 0) {
                if (this.mTriggerPercentage > 0.0f) {
                    if (((double) this.mTriggerPercentage) <= 1.0d) {
                        drawTrigger(canvas2, i, i2);
                    }
                }
                canvas2.restoreToCount(save);
            }
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        long j = (currentAnimationTimeMillis - this.mStartTime) % 2000;
        long j2 = (currentAnimationTimeMillis - this.mStartTime) / 2000;
        float f = ((float) j) / 20.0f;
        boolean z = false;
        if (!this.mRunning) {
            if (currentAnimationTimeMillis - this.mFinishTime >= 1000) {
                this.mFinishTime = 0;
                return;
            }
            float interpolation = ((float) (width / 2)) * INTERPOLATOR.getInterpolation((((float) ((currentAnimationTimeMillis - this.mFinishTime) % 1000)) / 10.0f) / 100.0f);
            this.mClipRect.set(((float) i) - interpolation, 0.0f, interpolation + ((float) i), (float) height);
            int saveLayerAlpha = canvas2.saveLayerAlpha(this.mClipRect, 0, 0);
            z = true;
        }
        if (j2 == 0) {
            canvas2.drawColor(this.mColor1);
        } else if (f >= 0.0f && f < 25.0f) {
            canvas2.drawColor(this.mColor4);
        } else if (f >= 25.0f && f < 50.0f) {
            canvas2.drawColor(this.mColor1);
        } else if (f < 50.0f || f >= 75.0f) {
            canvas2.drawColor(this.mColor3);
        } else {
            canvas2.drawColor(this.mColor2);
        }
        if (f >= 0.0f && f <= 25.0f) {
            drawCircle(canvas2, (float) i, (float) i2, this.mColor1, (2.0f * (25.0f + f)) / 100.0f);
        }
        if (f >= 0.0f && f <= 50.0f) {
            drawCircle(canvas2, (float) i, (float) i2, this.mColor2, (2.0f * f) / 100.0f);
        }
        if (f >= 25.0f && f <= 75.0f) {
            drawCircle(canvas2, (float) i, (float) i2, this.mColor3, (2.0f * (f - 25.0f)) / 100.0f);
        }
        if (f >= 50.0f && f <= 100.0f) {
            drawCircle(canvas2, (float) i, (float) i2, this.mColor4, (2.0f * (f - 50.0f)) / 100.0f);
        }
        if (f >= 75.0f && f <= 100.0f) {
            drawCircle(canvas2, (float) i, (float) i2, this.mColor1, (2.0f * (f - 75.0f)) / 100.0f);
        }
        if (this.mTriggerPercentage > 0.0f && z) {
            canvas2.restoreToCount(save);
            save = canvas2.save();
            boolean clipRect2 = canvas2.clipRect(this.mBounds);
            drawTrigger(canvas2, i, i2);
        }
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
        canvas2.restoreToCount(save);
    }

    /* access modifiers changed from: 0000 */
    public boolean isRunning() {
        return this.mRunning || this.mFinishTime > 0;
    }

    /* access modifiers changed from: 0000 */
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.mBounds.left = i;
        this.mBounds.top = i5;
        this.mBounds.right = i6;
        this.mBounds.bottom = i7;
    }

    /* access modifiers changed from: 0000 */
    public void setColorScheme(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.mColor1 = i;
        this.mColor2 = i5;
        this.mColor3 = i6;
        this.mColor4 = i7;
    }

    /* access modifiers changed from: 0000 */
    public void setTriggerPercentage(float f) {
        this.mTriggerPercentage = f;
        this.mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    /* access modifiers changed from: 0000 */
    public void start() {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    public void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }
}
