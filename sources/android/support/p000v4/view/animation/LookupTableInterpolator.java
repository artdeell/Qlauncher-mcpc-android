package android.support.p000v4.view.animation;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.LookupTableInterpolator */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize = (1.0f / ((float) (-1 + this.mValues.length)));
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
    }

    public float getInterpolation(float f) {
        float f2 = f;
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (f2 * ((float) (-1 + this.mValues.length))), -2 + this.mValues.length);
        return this.mValues[min] + (((f2 - (((float) min) * this.mStepSize)) / this.mStepSize) * (this.mValues[min + 1] - this.mValues[min]));
    }
}
