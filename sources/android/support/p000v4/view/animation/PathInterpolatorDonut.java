package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorDonut */
class PathInterpolatorDonut implements Interpolator {
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private final float[] f11mX;

    /* renamed from: mY */
    private final float[] f12mY;

    public PathInterpolatorDonut(float f, float f2) {
        this(createQuad(f, f2));
    }

    public PathInterpolatorDonut(float f, float f2, float f3, float f4) {
        this(createCubic(f, f2, f3, f4));
    }

    public PathInterpolatorDonut(Path path) {
        PathMeasure pathMeasure;
        PathMeasure pathMeasure2 = pathMeasure;
        PathMeasure pathMeasure3 = new PathMeasure(path, false);
        PathMeasure pathMeasure4 = pathMeasure2;
        float length = pathMeasure4.getLength();
        int i = 1 + ((int) (length / 0.002f));
        this.f11mX = new float[i];
        this.f12mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            boolean posTan = pathMeasure4.getPosTan((length * ((float) i2)) / ((float) (i - 1)), fArr, null);
            this.f11mX[i2] = fArr[0];
            this.f12mY[i2] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f2, float f3, float f4) {
        Path path;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        Path path2 = path;
        Path path3 = new Path();
        Path path4 = path2;
        path4.moveTo(0.0f, 0.0f);
        path4.cubicTo(f5, f6, f7, f8, 1.0f, 1.0f);
        return path4;
    }

    private static Path createQuad(float f, float f2) {
        Path path;
        float f3 = f;
        float f4 = f2;
        Path path2 = path;
        Path path3 = new Path();
        Path path4 = path2;
        path4.moveTo(0.0f, 0.0f);
        path4.quadTo(f3, f4, 1.0f, 1.0f);
        return path4;
    }

    public float getInterpolation(float f) {
        float f2 = f;
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = -1 + this.f11mX.length;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f11mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f3 = this.f11mX[length] - this.f11mX[i];
        if (f3 == 0.0f) {
            return this.f12mY[i];
        }
        float f4 = (f2 - this.f11mX[i]) / f3;
        float f5 = this.f12mY[i];
        return f5 + (f4 * (this.f12mY[length] - f5));
    }
}
