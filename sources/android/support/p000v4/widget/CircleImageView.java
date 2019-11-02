package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.p000v4.view.ViewCompat;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.CircleImageView */
class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private AnimationListener mListener;
    /* access modifiers changed from: private */
    public int mShadowRadius;

    /* renamed from: android.support.v4.widget.CircleImageView$OvalShadow */
    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        final /* synthetic */ CircleImageView this$0;

        public OvalShadow(CircleImageView circleImageView, int i, int i2) {
            Paint paint;
            RadialGradient radialGradient;
            CircleImageView circleImageView2 = circleImageView;
            int i3 = i;
            int i4 = i2;
            this.this$0 = circleImageView2;
            Paint paint2 = paint;
            Paint paint3 = new Paint();
            this.mShadowPaint = paint2;
            int access$002 = CircleImageView.access$002(circleImageView2, i3);
            this.mCircleDiameter = i4;
            RadialGradient radialGradient2 = radialGradient;
            RadialGradient radialGradient3 = new RadialGradient((float) (this.mCircleDiameter / 2), (float) (this.mCircleDiameter / 2), (float) circleImageView2.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, TileMode.CLAMP);
            this.mRadialGradient = radialGradient2;
            Shader shader = this.mShadowPaint.setShader(this.mRadialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            Canvas canvas2 = canvas;
            Paint paint2 = paint;
            int width = this.this$0.getWidth();
            int height = this.this$0.getHeight();
            canvas2.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.mCircleDiameter / 2) + this.this$0.mShadowRadius), this.mShadowPaint);
            canvas2.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.mCircleDiameter / 2), paint2);
        }
    }

    public CircleImageView(Context context, int i, float f) {
        ShapeDrawable shapeDrawable;
        OvalShadow ovalShadow;
        ShapeDrawable shapeDrawable2;
        ShapeDrawable shapeDrawable3;
        OvalShape ovalShape;
        int i2 = i;
        float f2 = f;
        super(context);
        float f3 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (2.0f * f2 * f3);
        int i4 = (int) (Y_OFFSET * f3);
        int i5 = (int) (0.0f * f3);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f3);
        if (elevationSupported()) {
            ShapeDrawable shapeDrawable4 = shapeDrawable3;
            OvalShape ovalShape2 = ovalShape;
            OvalShape ovalShape3 = new OvalShape();
            ShapeDrawable shapeDrawable5 = new ShapeDrawable(ovalShape2);
            shapeDrawable2 = shapeDrawable4;
            ViewCompat.setElevation(this, 4.0f * f3);
        } else {
            ShapeDrawable shapeDrawable6 = shapeDrawable;
            OvalShadow ovalShadow2 = ovalShadow;
            OvalShadow ovalShadow3 = new OvalShadow(this, this.mShadowRadius, i3);
            ShapeDrawable shapeDrawable7 = new ShapeDrawable(ovalShadow2);
            shapeDrawable2 = shapeDrawable6;
            ViewCompat.setLayerType(this, 1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.mShadowRadius, (float) i5, (float) i4, KEY_SHADOW_COLOR);
            int i6 = this.mShadowRadius;
            setPadding(i6, i6, i6, i6);
        }
        shapeDrawable2.getPaint().setColor(i2);
        setBackgroundDrawable(shapeDrawable2);
    }

    static /* synthetic */ int access$002(CircleImageView circleImageView, int i) {
        int i2 = i;
        circleImageView.mShadowRadius = i2;
        return i2;
    }

    private boolean elevationSupported() {
        return VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mListener != null) {
            this.mListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.mListener != null) {
            this.mListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (2 * this.mShadowRadius), getMeasuredHeight() + (2 * this.mShadowRadius));
        }
    }

    public void setAnimationListener(AnimationListener animationListener) {
        AnimationListener animationListener2 = animationListener;
        this.mListener = animationListener2;
    }

    public void setBackgroundColor(int i) {
        int i2 = i;
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }
}
